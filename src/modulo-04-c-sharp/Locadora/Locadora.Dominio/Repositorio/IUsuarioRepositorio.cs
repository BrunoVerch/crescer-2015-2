using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IUsuarioRepositorio
    {
        IList<Usuario> BuscarPorNome(string nome);
        IList<Usuario> BuscarTodos();
        int Criar(Usuario usuario);
        int Atualizar(Usuario usuario);
        int Excluir(int id);
        Jogo BuscarPorId(int id);
    }
}
