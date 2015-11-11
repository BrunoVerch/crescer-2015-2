using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Seguranca
{
    public class UsuarioLogado
    {
        public string Email { get; private set; }

        public string[] Permissoes { get; private set; }

        public UsuarioLogado(Usuario usuario)
        {
            this.Email = usuario.Email;
            this.Permissoes = usuario.Permissoes.Select(p => p.Nome).ToArray();
        }

        public bool TemPermissao(string nomePermissao)
        {
            return this.Permissoes != null
                && this.Permissoes.Contains(nomePermissao);
        }

    }
}
