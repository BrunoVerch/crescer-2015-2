using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioController : BaseController
    {
        private IJogoRepositorio repositorio = null;

        [Autorizador]
        public ActionResult JogosDisponiveis(string nomeJogo)
        {
            repositorio = CriarJogoRepositorio();
            var model = new RelatorioModel();
            IList<Dominio.Jogo> ListaJogos = new List<Dominio.Jogo>();
            ListaJogos = ObterJogosPorFiltro(nomeJogo);

            foreach (var jogo in ListaJogos)
            {
                if (jogo.IdCliente == null) //jogo.EstaLocado
                {
                    var jogoModel = new JogoModel() { Id = jogo.Id, Nome = jogo.Nome, Categoria = jogo.Categoria.ToString(), Selo = jogo.Selo.ToString() };
                    model.Jogos.Add(jogoModel);
                }
            }
            if (ListaJogos.Count == 0)
            {
                return View("JogoNaoEncontrado");
            }
            model.QuantidadeDeJogos = model.Jogos.Count;

            return View(model);
        }

        public JsonResult JogosAutocomplete(string term)
        {
            IList<Jogo> jogosEncontrados = ObterJogosPorFiltro(term);

            var json = jogosEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }

        private IList<Jogo> ObterJogosPorFiltro(string nome)
        {
            IJogoRepositorio jogoRepositorio = FabricaDeModulos.CriarJogoRepositorio();

            if (string.IsNullOrWhiteSpace(nome))
            {
                return jogoRepositorio.BuscarTodos();
            }
            else
            {
                return jogoRepositorio.BuscarPorNome(nome);
            }
        }
    }
}