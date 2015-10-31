using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    class BibliotecaDeJogos
    {
        public string caminhoDoArquivo = @"C:\Users\bruno.verch\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\Locadora\game_store.xml";

        public void CadastrarJogo(Jogo joguinho)
        {
            XElement arquivoXML = XElement.Load(caminhoDoArquivo);
            int idNovo=arquivoXML.Elements().Max(id => Convert.ToInt32(id.Attribute("id").Value)) + 1;
            XElement jogo = new XElement("jogo");
            jogo.Add(new XAttribute("Id", idNovo));
            jogo.Add(new XElement("nome", joguinho.Nome));
            jogo.Add(new XElement("preco", joguinho.Preco));
            jogo.Add(new XElement("descricao", joguinho.Categoria));
            arquivoXML.Element("jogos").Add(jogo);
        }

        public List<Jogo> PesquisarJogoPorNome(string nome)
        {
            XElement arquivoXML = XElement.Load(caminhoDoArquivo);
            List<Jogo> listaRetorno = new List<Jogo>();
            foreach (XElement jogo in arquivoXML.Elements("jogo"))
            {
                if(jogo.Element("nome").Value.Contains(nome))
                {
                    listaRetorno.Add(new Jogo(jogo));
                }
            }
            return listaRetorno;
        }

        public int getId(string nome)
        {
            XElement arquivoXML = XElement.Load(caminhoDoArquivo);
            XElement jogoEsperado = arquivoXML.Element("jogos").Elements().FirstOrDefault(jogo => nome == jogo.Element("nome").Value);
            return Convert.ToInt32(jogoEsperado.Attribute("id").Value);   
        }

        private XElement getJogo(int id)
        {
            XElement arquivoXML = XElement.Load(caminhoDoArquivo);
            return arquivoXML.Element("jogos").Elements().FirstOrDefault(jogo => id == Convert.ToInt32(jogo.Attribute("id").Value));
        }

        public void EditarJogo(int id, Jogo jogo)
        {
            XElement jogoXML = getJogo(id);
            jogoXML.Element("nome").SetValue(jogo.Nome);
            jogoXML.Element("preco").SetValue(jogo.Preco.ToString("0.00", System.Globalization.CultureInfo.InvariantCulture));
            jogoXML.Element("categoria").SetValue(jogo.Categoria);
        }

        public void EditarNomeDoJogo(int id,string nomeAlterado)
        {
            XElement jogo = getJogo(id);
            jogo.Element("nome").SetValue(nomeAlterado);
            jogo.Save(caminhoDoArquivo);
        }

        public void EditarPrecoDoJogo(int id, double novoValor)
        {
            XElement jogo = getJogo(id);
            jogo.Element("preco").SetValue(novoValor.ToString("0.00", System.Globalization.CultureInfo.InvariantCulture));
            jogo.Save(caminhoDoArquivo);
        }

        public void EditarCategoriaDoJogo(int id, string categoria)
        {
            XElement jogo = getJogo(id);
            jogo.Element("categoria").SetValue(categoria);
            jogo.Save(caminhoDoArquivo);
        }
    }
}
