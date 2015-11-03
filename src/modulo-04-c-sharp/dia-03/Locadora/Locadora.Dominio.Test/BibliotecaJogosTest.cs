using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class BibliotecaJogosTest
    {
        [TestMethod]
        public void PesquisarJogoPorNomeRetornaComSucesso()
        {
            BibliotecaDeJogos dados = new BibliotecaDeJogos();
            IList<Jogo> atual = dados.PesquisarJogoPorNome("Top Gear");
            Jogo esperado = new Jogo("Top Gear", 20, Categoria.CORRIDA);
            Assert.AreEqual(esperado.Nome, atual[0].Nome);
        }
        [TestMethod]
        public void CadastarJogoComSucesso()
        {
            BibliotecaDeJogos dados = new BibliotecaDeJogos();
            Jogo cadastrado = new Jogo("Jogo Cadastrado", 30, Categoria.CORRIDA);
            dados.CadastrarJogo(cadastrado);           
            Assert.AreEqual(cadastrado.Nome, dados.PesquisarJogoPorNome("Jogo Cadastrado")[0].Nome);
        }
        [TestMethod]
        public void EditarNomeDoJogo()
        {
            BibliotecaDeJogos dados = new BibliotecaDeJogos();
            int id=dados.GetId("Top Gear");
            dados.EditarNomeDoJogo(id,"Jogo Alterado");
            Assert.AreEqual("Jogo Alterado", dados.PesquisarJogoPorNome("Jogo Alterado")[0].Nome);
        }
    }
}
