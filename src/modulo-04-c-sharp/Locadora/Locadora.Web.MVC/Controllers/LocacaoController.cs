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

        public ActionResult Locar(int id)
        {
            IJogoRepositorio repositorio = FabricaDeModulos.CriarJogoRepositorio();
            Jogo jogo = BuscarPorId(repositorio, id);

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
            if (string.IsNullOrWhiteSpace(nomeCliente))
            {
                TempData["Mensagem"] = "Informe um nome correto!";
                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            IJogoRepositorio repositorio = FabricaDeModulos.CriarJogoRepositorio();
            IClienteRepositorio repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            ILocacaoServico repositorioLocacao = FabricaDeModulos.CriarServicoLocacao();

            Jogo jogo = BuscarPorId(repositorio, idJogo);
            Cliente cliente = BuscarClientePorNome(repositorioCliente,nomeCliente);

            if (cliente != null && repositorioLocacao.PodeLocar(cliente))
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
            IJogoRepositorio repositorio = FabricaDeModulos.CriarJogoRepositorio();
            IClienteRepositorio repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            ILocacaoServico repositorioLocacao = FabricaDeModulos.CriarServicoLocacao();

            Cliente cliente = BuscarClientePorNome(repositorioCliente,nomeCliente);
            IList<Jogo> listaJogos = repositorio.BuscarJogosPorCliente(cliente.Id);
            var model = new ListaJogosModel();
            model.IdCliente = cliente.Id;
            foreach (var jogo in listaJogos)
            {
                var modelJogo = new JogoDevolucaoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    DataLocacao = (DateTime)jogo.DataLocacao,
                    ValorTotal = repositorioLocacao.CalcularValorFinal(jogo)
                };
                model.Jogos.Add(modelJogo);
            }
            return PartialView("_Devolver", model);
        }

        public ActionResult FinalizaDevolver(string nomeJogo)
        {
            IJogoRepositorio repositorio = FabricaDeModulos.CriarJogoRepositorio();
            IList<Jogo> jogos = repositorio.BuscarPorNome(nomeJogo);
            Jogo jogo = jogos.FirstOrDefault();
            jogo.DevolverJogo();
            repositorio.Atualizar(jogo);
            TempData["Mensagem"] = "Jogo devolvido com sucesso!";
            return View("Devolucao");
        }

        public Jogo BuscarPorId(IJogoRepositorio repositorio, int idJogo)
        {
            return repositorio.BuscarPorId(idJogo);
        }

        public Cliente BuscarClientePorNome(IClienteRepositorio repositorio, string nomeCliente)
        {
            IList<Cliente> clientes = repositorio.BuscarPorNome(nomeCliente);
            return clientes.FirstOrDefault();
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