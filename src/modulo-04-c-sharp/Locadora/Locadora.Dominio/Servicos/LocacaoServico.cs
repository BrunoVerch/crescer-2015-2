using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class LocacaoServico
    {
        private IJogoRepositorio jogoRepositorio;

        public LocacaoServico(IJogoRepositorio repositorio)
        {
            this.jogoRepositorio = repositorio;
        }

        public void GerarDataDevolucao(Jogo jogo)
        {
            if (jogo.Selo == Selo.OURO)
            {
                jogo.DataDevolucao = DateTime.Now.AddDays(1);
            }
            else if(jogo.Selo == Selo.PRATA)
            {
                jogo.DataDevolucao = DateTime.Now.AddDays(2);
            }
            else if (jogo.Selo == Selo.BRONZE)
            {
                jogo.DataDevolucao = DateTime.Now.AddDays(3);
            }
        }
        
        public int PodeLocar(Cliente cliente)
        {
            return jogoRepositorio.BuscarJogosPorCliente(cliente.Id).Count();
        }      
    }
}
