using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public Categoria Categoria { get; set; }

        public string Descricao { get; set; }

        public Selo Selo { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }

        public Cliente ClienteLocacao { get; private set; }

        public decimal Valor
        {
            get
            {
                if (Selo == Selo.OURO)
                    return 15;
                if (Selo == Selo.PRATA)
                    return 10;
                else
                    return 5;
            }
        }

        public int? IdCliente { get; set; }

        public DateTime? DataLocacao { get; set; }


        public Jogo()
        {

        }

        public Jogo(int id)
        {
            this.Id = id;
        }

        public void LocarPara(Cliente cliente)
        {
            this.DataLocacao = DateTime.Now.Date;
            this.IdCliente = cliente.Id;
            this.ClienteLocacao = cliente;
        }

        public void DevolverJogo()
        {
            this.ClienteLocacao = null;
            this.IdCliente = null;
            this.DataLocacao = null;
        }

        public bool EstaDisponivel()
        {
            if (this.IdCliente == null)
                return true;
            else
                return false;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Categoria: " + this.Categoria);
            builder.AppendLine("Descricao: "+ this.Descricao);
            builder.AppendLine("Selo: "+this.Selo);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.ClienteLocacao == jogoComp.ClienteLocacao;
            }

            return false;
        }
    }
}
