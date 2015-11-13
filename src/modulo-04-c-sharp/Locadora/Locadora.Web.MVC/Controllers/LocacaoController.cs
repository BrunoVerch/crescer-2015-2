using Locadora.Dominio.Repositorio;
using Locadora.Dominio;
using Locadora.Web.MVC.Helpers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Web.MVC.Models;
using Locadora.Dominio.Servicos;
using Locadora.Web.MVC.Seguranca;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class LocacaoController : Controller
    {
        private IJogoRepositorio repositorio = null;

        public ActionResult Locar(int id)
        {
            repositorio = FabricaDeModulos.CriarJogoRepositorio();           
            Jogo jogo = repositorio.BuscarPorId(id);

            var model = new LocarJogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Descricao = jogo.Descricao,
                Imagem = jogo.Imagem,
                Selo = jogo.Selo,
                DataDevolucao = DateTime.Now.Date,
                Valor = jogo.Valor.ToString("C")
            };

            return View(model);
        }

        [HttpPost]
        public ActionResult Salvar(string nomeCliente, int idJogo)
        {
            repositorio = FabricaDeModulos.CriarJogoRepositorio();
            IClienteRepositorio repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            Jogo jogo=repositorio.BuscarPorId(idJogo);
            Cliente cliente=repositorioCliente.BuscarPorNome(nomeCliente).FirstOrDefault();

            LocacaoServico locacao = new LocacaoServico(repositorio);
            jogo.DataLocacao = DateTime.Now.Date;
            if (cliente != null && locacao.PodeLocar(cliente))
            {
                jogo.LocarPara(cliente);
                repositorio.Atualizar(jogo);
                TempData["Mensagem"] = "Jogo locado com sucesso!";
            }
            else
            {
                TempData["Mensagem"] = "Não foi possivel locar este jogo!";
            }
           
            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }
        
        public ActionResult Devolucao()
        {
            return View();
        }

        public ActionResult Devolver(string nomeCliente)
        {
            repositorio = FabricaDeModulos.CriarJogoRepositorio();
            IClienteRepositorio repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            IList<Cliente> clientes = repositorioCliente.BuscarPorNome(nomeCliente);
            Cliente cliente=clientes.FirstOrDefault();
            IList<Jogo> listaJogos=repositorio.BuscarJogosPorCliente(cliente.Id);
            LocacaoServico locacao = new LocacaoServico(repositorio);
            var model = new ListaJogosModel();
            model.IdCliente = cliente.Id;
            foreach(var jogo in listaJogos)
            {
                var modelJogo = new JogoDevolucaoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    DataLocacao=(DateTime)jogo.DataLocacao,
                    ValorTotal=locacao.CalcularValorFinal(jogo)                  
                };
                model.Jogos.Add(modelJogo);
            }
            return PartialView("Devolver", model);
        }

        public ActionResult FinalizaDevolver(string nomeJogo)
        {
            repositorio = FabricaDeModulos.CriarJogoRepositorio();
            IList<Jogo> jogos = repositorio.BuscarPorNome(nomeJogo);
            Jogo jogo = jogos.FirstOrDefault();
            jogo.DevolverJogo();
            jogo.DataLocacao = null;
            repositorio.Atualizar(jogo);
            TempData["Mensagem"] = "Jogo devolvido com sucesso!";
            return View("Devolucao");
        }

        public JsonResult ClienteAutocomplete(string term)
        {
            IClienteRepositorio repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            IList<Cliente> clientesEncontrados = null;
            if (string.IsNullOrWhiteSpace(term))
            {
                clientesEncontrados = repositorioCliente.BuscarTodos();
            }
            else
            {
                clientesEncontrados = repositorioCliente.BuscarPorNome(term);
            }

            var json = clientesEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }
    }
}