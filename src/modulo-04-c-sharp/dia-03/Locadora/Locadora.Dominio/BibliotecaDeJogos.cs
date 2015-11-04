using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class BibliotecaDeJogos
    {
        //public string caminhoDoArquivo = @"C:\Users\bruno.verch\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\Locadora\game_store.xml";
        public string caminhoDoArquivo = @"C:\Users\bruno\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\Locadora\game_store.xml";
        public string caminhoTXT = @"C:\Users\bruno\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\Locadora\Relatorios\Relatorio.txt";

        public void CadastrarJogo(Jogo joguinho)
        {
            XElement arquivoXML = Load();
            int idNovo = GetLastId(arquivoXML);
            XElement jogo = new XElement("jogo");
            jogo.Add(new XAttribute("id", idNovo + 1));
            jogo.Add(new XElement("nome", joguinho.Nome));
            jogo.Add(new XElement("preco", joguinho.Preco));
            jogo.Add(new XElement("categoria", joguinho.Categoria));
            arquivoXML.Add(jogo);
            SaveXML(arquivoXML);
        }

        private void SaveXML(XElement elem)
        {
            elem.Save(caminhoDoArquivo);
        }

        private int GetLastId(XElement elem)
        {
            return Convert.ToInt32(elem.Elements("jogo").Last().Attribute("id").Value);
        }

        public List<Jogo> PesquisarJogoPorNome(string nome)
        {
            XElement arquivoXML = Load();
            List<Jogo> listaRetorno = new List<Jogo>();
            foreach (XElement jogo in arquivoXML.Elements("jogo"))
            {
                if (jogo.Element("nome").Value.ToUpper().Contains(nome.ToUpper()))
                {
                    listaRetorno.Add(ConvertXMLtoJogo(jogo));
                }
            }
            return listaRetorno;
        }

        public int GetId(string nome)
        {
            XElement xmlJogos = Load();
            string nomeM = nome.ToUpper();
            XElement jogoEsperado = xmlJogos.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value.ToUpper() == nomeM);
            return Convert.ToInt32(jogoEsperado.FirstAttribute.Value);
        }

        private XElement GetXElementById(XElement arquivoXML,int id)
        {
            return arquivoXML.Elements("jogo").Where(elem => elem.Attribute("id").Value == id.ToString()).Single();
        }

        public void EditarNomeDoJogo(int id, string nomeAlterado)
        {
            XElement xmlJogos = Load();
            XElement jogo = GetXElementById(xmlJogos,id);
            jogo.Element("nome").SetValue(nomeAlterado);
            xmlJogos.Save(caminhoDoArquivo);
        }

        public void EditarPrecoDoJogo(int id, double novoValor)
        {
            XElement xmlJogos = Load();
            XElement jogo = GetXElementById(xmlJogos, id);
            jogo.Element("preco").SetValue(novoValor.ToString("0.00", System.Globalization.CultureInfo.InvariantCulture));
            jogo.Save(caminhoDoArquivo);
        }

        public void EditarCategoriaDoJogo(int id, Categoria categoria)
        {
            XElement xmlJogos = Load();
            XElement jogo = GetXElementById(xmlJogos, id);
            jogo.Element("categoria").SetValue(Convert.ToString(categoria));
            jogo.Save(caminhoDoArquivo);
        }

        private Jogo ConvertXMLtoJogo(XElement elem)
        {
            int IdXML = Convert.ToInt32(elem.Attribute("id").Value);
            string Nome = elem.Element("nome").Value;
            double Preco = Convert.ToDouble(elem.Element("preco").Value, System.Globalization.CultureInfo.InvariantCulture);
            string Category = elem.Element("categoria").Value;
            var Categoria = (Categoria)Enum.Parse(typeof(Categoria), Category);
            return new Jogo(Nome, Preco, Categoria) { Id = IdXML };
        }

        private XElement Load()
        {
            XElement xmlJogos = XElement.Load(caminhoDoArquivo);
            return xmlJogos;
        }

        public List<Jogo> GetJogos()
        {
            XElement arquivoXML=Load();
            List<Jogo> listaRetorno = new List<Jogo>();
            foreach (XElement jogo in arquivoXML.Elements("jogo"))
            {
                listaRetorno.Add(ConvertXMLtoJogo(jogo));
            }
            return listaRetorno;
        }
        public string JogoMaisCaro(List<Jogo> lista)
        {
            double maiorPreco = lista.Max(jogo => jogo.Preco);
            return lista.First(jogo => jogo.Preco == maiorPreco).Nome;
        }
        public string JogoMaisBarato(List<Jogo> lista)
        {
            double menorPreco = lista.Min(jogo => jogo.Preco);
            return lista.First(jogo => jogo.Preco == menorPreco).Nome;
        }
        public double ValorMedioJogo(List<Jogo> lista)
        {
            double valorTotal = 0;
            foreach (var jogo in lista)
            {
                valorTotal += jogo.Preco;
            }
            int totalDeJogos = lista.Count;
            return valorTotal / totalDeJogos;
        }

        public void gerarRelatorio()
        {
            XElement arquivoXML = XElement.Load(caminhoDoArquivo);
            List<Jogo> listaDeJogos = GetJogos();
            StringBuilder lista = new StringBuilder();
            foreach (var jogo in listaDeJogos)
            {
                lista.Append(jogo.Id.ToString().PadRight(10));
                lista.Append(jogo.Categoria.ToString().PadRight(10));
                lista.Append(jogo.Nome.PadRight(45));
                lista.Append(jogo.Preco.ToString().PadRight(10) + "\r\n");
            }
            double valorMedio = ValorMedioJogo(listaDeJogos);
            string maisCaro = JogoMaisCaro(listaDeJogos);
            string maisBarato = JogoMaisBarato(listaDeJogos);
            string data = DateTime.Now.Date.ToString("dd/MM/yyyy");
            string hora = DateTime.Now.ToLongTimeString();

            string nomeLocadora = "LOCADORA NUNES GAMES";
            string nomeRelatorio = "Relatorio de Jogos";
            string cabecalhoLista = "ID".PadRight(10) + "Categoria".PadRight(10) + "Nome".PadRight(45) + "Preco".PadRight(10);
            using (StreamWriter writer = new StreamWriter(caminhoTXT))
            {
                writer.WriteLine(nomeLocadora.PadLeft(40));
                writer.WriteLine(data.PadRight(30) + hora.PadLeft(30));
                writer.WriteLine(nomeRelatorio.PadLeft(40));
                writer.WriteLine("");
                writer.WriteLine("==========================================================================");
                writer.WriteLine(cabecalhoLista);
                writer.WriteLine(lista);
                writer.WriteLine("--------------------------------------------------------------------------");
                writer.WriteLine("Quantidade total de jogos: " + listaDeJogos.Count);
                writer.WriteLine("Quantidade de jogos disponiveis: ");
                writer.WriteLine("Valor medio por jogo: " + valorMedio);
                writer.WriteLine("Jogo mais caro: " + maisCaro);
                writer.WriteLine("Jogo mais barato: " + maisBarato);
                writer.WriteLine("==========================================================================");
            }
        }
    }

}


