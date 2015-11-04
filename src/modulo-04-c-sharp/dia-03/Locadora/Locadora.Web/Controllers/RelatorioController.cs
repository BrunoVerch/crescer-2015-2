using Locadora.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.Controllers
{
    public class RelatorioController : Controller
    {
        // GET: Relatorio
        public ActionResult Relatorio()
        {
            var model = new RelatorioModel();
            return View(model);
        }
    }
}