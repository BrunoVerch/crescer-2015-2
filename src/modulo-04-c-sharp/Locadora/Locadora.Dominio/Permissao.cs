using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Permissao : EntidadeBase
    {
        public string Nome { get; private set; }

        public ICollection<Usuario> Usuarios { get; private set; }

        public Permissao(string nome)
        {
            this.Nome = nome;
        }

        //entity
        private Permissao()
        {

        }
    }
}
