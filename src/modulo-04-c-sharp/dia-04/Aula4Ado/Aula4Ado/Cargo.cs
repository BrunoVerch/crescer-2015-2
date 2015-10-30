using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aula4Ado
{
    class Cargo
    {
        public int IdCargo { get; private set; }

        public string Nome { get; private set; }

        public char Situacao { get; set; }
        

        public Cargo(int idCargo, string nome)
        {
            this.IdCargo = idCargo;
            this.Nome = nome;
        }

    }
}
