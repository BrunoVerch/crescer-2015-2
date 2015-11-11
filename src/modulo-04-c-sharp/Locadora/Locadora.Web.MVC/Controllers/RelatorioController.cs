using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : BaseController
    {
        private IJogoRepositorio repositorio = null;

        [Autorizador]
        public ActionResult JogosDisponiveis(string nomeJogo)
        {
            repositorio = CriarJogoRepositorio();
            var model = new RelatorioModel();
            IList<Dominio.Jogo> ListaJogos=new List<Dominio.Jogo>();            
            if(!string.IsNullOrWhiteSpace(nomeJogo))
            {
                ListaJogos = repositorio.BuscarPorNome(nomeJogo);
            }
            else
            {
                ListaJogos = repositorio.BuscarTodos();
            }            
            foreach (var jogo in ListaJogos)
            {
                var jogoModel = new JogoModel() { Id = jogo.Id, Nome = jogo.Nome, Categoria = jogo.Categoria.ToString() };
                model.Jogos.Add(jogoModel);
            }
            if (ListaJogos.Count == 0)
            {
                return View("JogoNaoEncontrado");
            }
            model.QuantidadeDeJogos = model.Jogos.Count;
               
            return View(model);
        }
    }
}