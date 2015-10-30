using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aula4Ado
{
    interface IRepositorio<T>
    {
        T BuscarPorId(int id);
    }
}
