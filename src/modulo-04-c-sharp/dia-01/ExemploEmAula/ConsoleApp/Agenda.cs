using System;
using System.Collections.Generic;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();        

        public int QuantidadeContatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        //public void RemoverContato(string nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if (contato.Nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}

        public void RemoverContato(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                    contatosASeremRemovidos.Add(contatos[i]);
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void ListarContatos()
        {
            foreach (var contato in contatos)
            {
                Console.WriteLine(contato.Nome + "-" + contato.Numero);
            }
        }
    }
}
