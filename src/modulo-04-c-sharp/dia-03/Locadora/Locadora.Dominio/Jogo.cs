using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public double Preco { get; private set; }
        public Categoria Categoria { get; private set; }

        public Jogo(string nome,double preco,Categoria categoria)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }
        //construtor para converter de xml para object
        public Jogo(XElement elem)
        {
            this.Id = Convert.ToInt32(elem.Attribute("id").Value);
            this.Nome =elem.Element("nome").Value;
            this.Preco = Convert.ToDouble(elem.Element("preco").Value, System.Globalization.CultureInfo.InvariantCulture);
            this.Categoria =(Categoria)Enum.Parse(typeof(Categoria), elem.Element("categoria").Value);
        }
    }
}
