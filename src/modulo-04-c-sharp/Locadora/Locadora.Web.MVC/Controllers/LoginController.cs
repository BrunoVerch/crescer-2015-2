using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login(string email,string senha)
        {
            //TODO: validar usuario

            if (email == "didi" && senha == "die")
            {
                var usuarioLogadoModel = new UsuarioLogadoModel("didi", new string[] { "MASTER" });

                FormsAuthentication.SetAuthCookie(email, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Home");
        }
    }
}