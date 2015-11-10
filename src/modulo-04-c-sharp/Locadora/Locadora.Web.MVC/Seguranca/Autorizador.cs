using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Seguranca
{
    public class Autorizador : AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            UsuarioLogadoModel usuarioLogado = filterContext.HttpContext.Session["USUARIO_LOGADO"] as UsuarioLogadoModel;

            var identidade = new GenericIdentity(usuarioLogado.Usuario);
            string[] roles = usuarioLogado.Permissoes;

            var principal = new GenericPrincipal(identidade, roles);

            Thread.CurrentPrincipal = principal;
            HttpContext.Current.User = principal;

            base.OnAuthorization(filterContext);
        }
    }
}