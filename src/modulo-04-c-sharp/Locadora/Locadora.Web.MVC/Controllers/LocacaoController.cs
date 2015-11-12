using Locadora.Dominio.Repositorio;
using Locadora.Dominio;
using Locadora.Web.MVC.Helpers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Web.MVC.Models;

namespace Locadora.Web.MVC.Controllers
{
    public class LocacaoController : Controller
    {
        private IJogoRepositorio repositorio = null;

        public ActionResult Locar(int id)
        {
            repositorio = FabricaDeModulos.CriarJogoRepositorio();           
            Jogo jogo = repositorio.BuscarPorId(id);

            var model = new LocarJogoModel() { Id = jogo.Id, Nome = jogo.Nome, Descricao = jogo.Descricao, Imagem = jogo.Imagem, Selo = jogo.Selo };

            return View(model);
        }
    }
}