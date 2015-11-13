using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class LocacaoServico : ILocacaoServico
    {
        private IJogoRepositorio jogoRepositorio;

        public LocacaoServico(IJogoRepositorio repositorio)
        {
            this.jogoRepositorio = repositorio;
        }

        public DateTime GerarDataDevolucao(Jogo jogo)
        {
            jogo.DataLocacao = DateTime.Now;
            if (jogo.Selo == Selo.OURO)
            {
                return jogo.DataLocacao.GetValueOrDefault().AddDays(1);
            }
            else if(jogo.Selo == Selo.PRATA)
            {
                return jogo.DataLocacao.GetValueOrDefault().AddDays(2);
            }
            else
            {
                return jogo.DataLocacao.GetValueOrDefault().AddDays(3);
            }
        }
        
        public bool PodeLocar(Cliente cliente)
        {
            int total = jogoRepositorio.BuscarJogosPorCliente(cliente.Id).Count();
            if(total == 3)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public decimal CalcularValorFinal(Jogo jogo)
        {
            decimal ValorFinal = 0;
            int diferencaDias =(DateTime.Now - jogo.DataLocacao.Value).Days;

            if (jogo.Valor == 15 && diferencaDias > 1)
                ValorFinal = jogo.Valor + (diferencaDias * 5);
            else
            if (jogo.Valor == 10 && diferencaDias > 2)
                ValorFinal = jogo.Valor + (diferencaDias * 5);
            else
            if (jogo.Valor == 5 && diferencaDias > 3)
                ValorFinal = jogo.Valor + (diferencaDias * 5);
            else
                ValorFinal = jogo.Valor;

            return ValorFinal;
        }
    }
}
