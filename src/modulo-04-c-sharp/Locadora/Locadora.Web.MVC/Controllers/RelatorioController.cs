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
                var jogoModel = new JogoModel() { Id = jogo.Id, Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString() };
                model.Jogos.Add(jogoModel);
            }
            if (ListaJogos.Count == 0)
            {
                return View("JogoNaoEncontrado");
            }
            model.QuantidadeDeJogos = model.Jogos.Count;
            model.ValorMedio = model.Jogos.Average(jogo=>jogo.Preco);
            model.JogoMaisBarato = model.Jogos.OrderBy(jogo => jogo.Preco).ToList()[0].Nome;
            model.JogoMaisCaro = model.Jogos.OrderByDescending(jogo => jogo.Preco).ToList()[0].Nome; 
               
            return View(model);
        }
    }
}