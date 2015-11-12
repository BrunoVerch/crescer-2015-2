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

namespace Locadora.Web.MVC.Controllers
{
    public class LocacaoController : Controller
    {
        private IJogoRepositorio repositorio = null;

        public ActionResult Locar(int id)
        {
            repositorio = FabricaDeModulos.CriarJogoRepositorio();           
            Jogo jogo = repositorio.BuscarPorId(id);

            LocacaoServico locacao = new LocacaoServico();
            locacao.GerarDataDevolucao(jogo);

            var model = new LocarJogoModel() { Id = jogo.Id, Nome = jogo.Nome, Descricao = jogo.Descricao, Imagem = jogo.Imagem, Selo = jogo.Selo, DataDevolucao=(DateTime)jogo.DataDevolucao, Valor=jogo.Valor };

            return View(model);
        }

        [HttpPost]
        public ActionResult Salvar(string nomeCliente, int id)
        {
            repositorio = FabricaDeModulos.CriarJogoRepositorio();
            IClienteRepositorio repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            Jogo jogo=repositorio.BuscarPorId(id);
            Cliente cliente=repositorioCliente.BuscarPorNome(nomeCliente).FirstOrDefault();

            LocacaoServico locacao = new LocacaoServico();
            locacao.GerarDataDevolucao(jogo);

            if (cliente != null)
            {
                jogo.LocarPara(cliente);
                repositorio.Atualizar(jogo);
                repositorio.Criar(jogo);
            }

            TempData["Mensagem"] = "Jogo locado com sucesso!";
            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }

        public JsonResult ClienteAutocomplete(string term)
        {
            IClienteRepositorio repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            IList<Cliente> clientesEncontrados = repositorioCliente.BuscarPorNome(term);

            var json = clientesEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }
    }
}