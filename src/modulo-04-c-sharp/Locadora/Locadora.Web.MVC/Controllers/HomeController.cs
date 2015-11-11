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
    public class HomeController : BaseController
    {
        private IJogoRepositorio repositorio = null;

        [Autorizador]
        public ActionResult Index()
        {
            repositorio = CriarJogoRepositorio();
            var model = new ListaImagensModel();
            IList<Dominio.Jogo> ListaJogos = new List<Dominio.Jogo>();

            ListaJogos = repositorio.BuscarTodos();
            foreach (var jogo in ListaJogos)
            {
                var imagemModel = new ImagemJogoModel() { Imagem=jogo.Imagem };
                if(jogo.Imagem != "")
                {
                    model.Imagens.Add(imagemModel);
                }                
            }

            return View(model);
        }
    }
}