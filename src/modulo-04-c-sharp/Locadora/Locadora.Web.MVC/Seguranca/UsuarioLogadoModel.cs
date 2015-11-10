using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Seguranca
{
    public class UsuarioLogadoModel
    {
        public string Usuario { get; private set; }

        public string[] Permissoes { get; private set; }

        public UsuarioLogadoModel(string usuario, string[] permissoes)
        {
            this.Usuario = usuario;
            this.Permissoes = permissoes;
        }
    }
}