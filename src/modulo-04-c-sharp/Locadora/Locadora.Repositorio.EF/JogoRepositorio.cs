using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Transactions;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : IJogoRepositorio
    {
        public int Atualizar(Jogo jogo)
        {
            using (var db = new CodeFirst())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = new CodeFirst())
            {
                return db.Jogo.FirstOrDefault(p => p.Id == id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (var db = new CodeFirst())
            {
                return db.Jogo.Where(p => p.Nome == nome).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = new CodeFirst())
            {
                return db.Jogo.ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var db = new CodeFirst())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var db = new CodeFirst())
            {
                Jogo jogo=BuscarPorId(id);
                db.Entry(jogo).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
        }
    }
}
