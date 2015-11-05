using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Locadora.Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nomeJogo)
        {
            var model = new RelatorioModel();
            foreach (var jogo in repositorio.BuscarTodos())
            {
                var jogoModel = new JogoModel() { Id = jogo.Id, Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString() };
                model.Jogos.Add(jogoModel);
            }
            model.QuantidadeDeJogos = model.Jogos.Count;
            model.ValorMedio = model.Jogos.Average(jogo=>jogo.Preco);
            model.JogoMaisBarato = model.Jogos.OrderBy(jogo => jogo.Preco).ToList()[0].Nome;
            model.JogoMaisCaro = model.Jogos.OrderByDescending(jogo => jogo.Preco).ToList()[0].Nome; 
               
            return View(model);
        }
    }
}