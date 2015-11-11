using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using System.Web.Security;

namespace Locadora.Web.MVC.Seguranca
{
    public class ControleDeSessao
    {
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        public static UsuarioLogado UsuarioLogado
        {
            get
            {
                return HttpContext.Current.Session[USUARIO_LOGADO] as UsuarioLogado;
            }
        }

        public static void CriarSessaoDeUsuario(Usuario usuarioAutenticado)
        {
            var usuarioLogado = new UsuarioLogado(usuarioAutenticado);
            FormsAuthentication.SetAuthCookie(usuarioLogado.Email, true);
            HttpContext.Current.Session[USUARIO_LOGADO] = usuarioLogado;
        }

        public static void Encerrar()
        {
            FormsAuthentication.SignOut();
            HttpContext.Current.Session.Abandon();
        }
    }
}
