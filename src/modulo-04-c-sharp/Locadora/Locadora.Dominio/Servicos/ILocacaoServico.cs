using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public interface ILocacaoServico
    {
        DateTime GerarDataDevolucao(Jogo jogo);

        bool PodeLocar(Cliente cliente);

        decimal CalcularValorFinal(Jogo jogo);
    }
}
