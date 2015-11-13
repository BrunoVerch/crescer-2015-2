using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class UsuarioTest
    {
        [TestMethod]
        public void UsuariosCriadoComEmailIgual()
        {
            Usuario usuario = new Usuario()
            {
                Email = "abc@abc.com",
                Senha = "12345"
            };
            Usuario usuario2 = new Usuario()
            {
                Email = "abc@abc.com",
                Senha = "12235"
            };

            Assert.AreEqual(usuario.Email, usuario2.Email);
        }

        [TestMethod]
        public void UsuarioAdicionaPermissao()
        {
            Usuario usuario = new Usuario()
            {
                Email = "abc@abc.com",
                Senha = "12345"
            };
            usuario.AdicionarPermissao(new Permissao("ADMIN"));

            Assert.AreEqual("ADMIN",usuario.Permissoes.First().Nome);
        }

        [TestMethod]
        public void UsuarioVerificaSeTemPermissaoSucesso()
        {
            Usuario usuario = new Usuario()
            {
                Email = "abc@abc.com",
                Senha = "12345"
            };
            usuario.AdicionarPermissao(new Permissao("ADMIN"));

            Assert.IsTrue(usuario.TemPermissao("ADMIN"));
        }

        [TestMethod]
        public void UsuarioVerificaSeTemPermissaoFracassa()
        {
            Usuario usuario = new Usuario()
            {
                Email = "abc@abc.com",
                Senha = "12345"
            };
            usuario.AdicionarPermissao(new Permissao("ADMIN"));

            Assert.IsFalse(usuario.TemPermissao("MASTER"));
        }
    }
}
