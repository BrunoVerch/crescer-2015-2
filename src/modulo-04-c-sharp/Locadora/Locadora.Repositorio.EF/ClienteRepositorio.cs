using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class ClienteRepositorio : IClienteRepositorio
    {
        public IList<Cliente> BuscarPorNome(string nome)
        {
            using (var db = new CodeFirst())
            {
                return db.Cliente.Where(p => p.Nome.Contains(nome)).ToList();
            }
        }

        public IList<Cliente> BuscarTodos()
        {
            using (var db = new CodeFirst())
            {
                return db.Cliente.ToList();
            }
        }
    }
}
