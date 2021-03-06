﻿using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        public Usuario BuscarPorEmail(string email)
        {
            using (var db = new CodeFirst())
            {
                return db.Usuario.Include("Permissoes").FirstOrDefault(p => p.Email == email);
            }
        }

        public int Criar(Usuario usuario)
        {
            using (var db = new CodeFirst())
            {
                db.Entry(usuario).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }
        }
    }
}
