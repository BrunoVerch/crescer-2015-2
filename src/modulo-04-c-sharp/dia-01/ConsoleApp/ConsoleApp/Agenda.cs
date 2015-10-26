using System;
using System.Collections.Generic;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos=new List<Contato>();

        public int QuantidadeContatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }
        public void RemoverContatosPorNome(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                {
                    contatosASeremRemovidos.Add(contatos[i]);                   
                }
            }
            
            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void RemoverContatosPorNumero(int numero)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if(contatos[i].Numero == numero)
                {
                    contatosASeremRemovidos.Add(contatos[i]);
                }               
            }
            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public List<Contato> ListarContatosOrdenadoPorNome()
        {
            var contatosOrdenados = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                
            }
            
            return contatosOrdenados;

        }
        public List<Contato> ListarContatos()
        {
            var listaContatos = new List<Contato>();
            foreach (var contato in contatos)
            {
                listaContatos.Add(contato);
            }
            return listaContatos;
        }
    }
}
