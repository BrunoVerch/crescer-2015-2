using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class Cargo
    {
        public string Titulo { get; private set; }
        public double Salario { get; private set; }

        public Cargo(string titulo, double salario)
        {
            this.Titulo = titulo;
            this.Salario = salario;
        }

    }
}
