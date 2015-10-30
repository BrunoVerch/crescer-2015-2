using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    class Cliente
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }

        public Cliente(int id,string nome)
        {
            this.Id = id;
            this.Nome = nome;
        }

        public void LocarJogo(Jogo jogo)
        {

        }
        public void DevolverJogo(Jogo jogo)
        {

        }
    }
}
