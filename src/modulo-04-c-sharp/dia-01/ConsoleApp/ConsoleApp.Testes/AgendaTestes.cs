using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Testes
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            var contato = new Contato("bruno", 12334);

            agenda.AdicionarContato(contato);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }
        [TestMethod]
        public void AgendaRemoveDoisContatosPeloNumero()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("bruno", 12334);
            var contato2 = new Contato("bruno1", 12334);

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);

            agenda.RemoverContatosPorNumero(12334);

            Assert.AreEqual(0,agenda.QuantidadeContatos);
        }
        [TestMethod]
        public void AgendaRemoveDoisContatosPeloNome()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("bruno", 12334);
            var contato2 = new Contato("bruno", 12344);

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);

            agenda.RemoverContatosPorNome("bruno");

            Assert.AreEqual(0,agenda.QuantidadeContatos);
        }
        [TestMethod]
        public void AgendaAdicionaContatosEListaContatos()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("bruno1", 12334);
            var contato2 = new Contato("bruno2", 12344);
            var contato3 = new Contato("bruno3", 12344);

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato3);

            agenda.ListarContatos();
            int esperado = 3;

            Assert.AreEqual(esperado, agenda.ListarContatos().Count);
        }
    }
}
