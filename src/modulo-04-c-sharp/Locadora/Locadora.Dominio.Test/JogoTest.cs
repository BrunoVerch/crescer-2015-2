using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {
            Jogo jogoA = new Jogo(id: 1);
            Jogo jogoB = new Jogo(id: 1);

            Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void JogoADeveSerDiferenteJogoB()
        {
            Jogo jogoA = new Jogo(id: 1);
            Jogo jogoB = new Jogo(id: 2);

            Assert.AreNotEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            Jogo jogo = new Jogo();

            jogo.LocarPara(new Cliente(1));

            Assert.AreEqual(1, jogo.ClienteLocacao.Id);
        }

        [TestMethod]
        public void ClienteDevolveJogo()
        {
            Jogo jogo = new Jogo();
            jogo.LocarPara(new Cliente(1));
            jogo.DevolverJogo();

            Assert.AreEqual(null, jogo.ClienteLocacao);
        }

        [TestMethod]
        public void JogoSeloOuroBuscaValor()
        {
            Jogo jogo = new Jogo()
            {
                Selo = Selo.OURO
            };
            decimal valor=jogo.Valor;

            Assert.AreEqual(15, valor);
        }

        [TestMethod]
        public void JogoSeloBronzeBuscaValor()
        {
            Jogo jogo = new Jogo()
            {
                Selo = Selo.BRONZE
            };
            decimal valor = jogo.Valor;

            Assert.AreEqual(5, valor);
        }
    }
}
