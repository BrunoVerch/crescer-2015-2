using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public interface IServicoCriptografia
    {
        string CriptografarSenha(string senha);
    }
}
