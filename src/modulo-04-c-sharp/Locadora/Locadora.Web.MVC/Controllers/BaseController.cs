using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public abstract class BaseController : Controller
    {
        public IJogoRepositorio CriarJogoRepositorio()
        {
            return new Locadora.Repositorio.EF.JogoRepositorio();
        }
    }
}