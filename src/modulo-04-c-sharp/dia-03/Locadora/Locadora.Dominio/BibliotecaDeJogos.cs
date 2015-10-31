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
            XElement arquivoXML = XElement.Load(caminhoDoArquivo);
            int idNovo= Convert.ToInt32(arquivoXML.Elements("jogo").Last().Attribute("id").Value);
            XElement jogo = new XElement("jogo");
            jogo.Add(new XAttribute("id", idNovo + 1));
            jogo.Add(new XElement("nome", joguinho.Nome));
            jogo.Add(new XElement("preco", joguinho.Preco));
            jogo.Add(new XElement("categoria", joguinho.Categoria));
            arquivoXML.Add(jogo);
            arquivoXML.Save(caminhoDoArquivo);
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
            string nomeM=nome.ToUpper();
            XElement jogoEsperado = arquivoXML.Elements("jogo").FirstOrDefault(jogo =>jogo.Element("nome").Value.ToUpper() == nomeM);
            return Convert.ToInt32(jogoEsperado.FirstAttribute.Value);   
        }

        public void EditarNomeDoJogo(int id,string nomeAlterado)
        {
            XElement xmlJogos = XElement.Load(caminhoDoArquivo);
            XElement jogo = xmlJogos.Elements("jogo").First(jog=> jog.FirstAttribute.Value == id.ToString());
            jogo.Element("nome").SetValue(nomeAlterado);
            xmlJogos.Save(caminhoDoArquivo);
        }

        public void EditarPrecoDoJogo(int id, double novoValor)
        {
            XElement xmlJogos = XElement.Load(caminhoDoArquivo);
            XElement jogo = xmlJogos.Elements("jogo").First(jog => jog.FirstAttribute.Value == id.ToString());
            jogo.Element("preco").SetValue(novoValor.ToString("0.00", System.Globalization.CultureInfo.InvariantCulture));
            jogo.Save(caminhoDoArquivo);
        }

        public void EditarCategoriaDoJogo(int id, Categoria categoria)
        {
            XElement xmlJogos = XElement.Load(caminhoDoArquivo);
            XElement jogo = xmlJogos.Elements("jogo").First(jog => jog.FirstAttribute.Value == id.ToString());
            jogo.Element("categoria").SetValue(Convert.ToString(categoria));
            jogo.Save(caminhoDoArquivo);
        }

        public void gerarRelatorio()
        {
            XElement arquivoXML = XElement.Load(caminhoDoArquivo);
            List<Jogo> listaDeJogos = new List<Jogo>();
            foreach (XElement jogo in arquivoXML.Elements("jogo"))
            {                
                    listaDeJogos.Add(new Jogo(jogo));                
            }
            double valorTotal = 0;
            StringBuilder lista = new StringBuilder();
            foreach (var jogo in listaDeJogos)
            {
                valorTotal += jogo.Preco;
                lista.Append(jogo.Id.ToString().PadRight(10));
                lista.Append(jogo.Categoria.ToString().PadRight(10));
                lista.Append(jogo.Nome.PadRight(45));
                lista.Append(jogo.Preco.ToString().PadRight(10) + "\r\n");
            }
            int totalDeJogos = listaDeJogos.Count;
            double valorMedio = valorTotal / totalDeJogos;
            double maiorPreco = listaDeJogos.Max(jogo=>jogo.Preco);
            double menorPreco = listaDeJogos.Min(jogo => jogo.Preco);
            string maisCaro = listaDeJogos.First(jogo => jogo.Preco == maiorPreco).Nome;
            string maisBarato = listaDeJogos.First(jogo => jogo.Preco == menorPreco).Nome;
            string data = DateTime.Now.Date.ToString("dd/MM/yyyy");
            string hora = DateTime.Now.ToLongTimeString();

            string nomeLocadora ="LOCADORA NUNES GAMES";
            string nomeRelatorio = "Relatorio de Jogos";
            string cabecalhoLista = "ID".PadRight(10) + "Categoria".PadRight(10)+"Nome".PadRight(45)+"Preco".PadRight(10);
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
                writer.WriteLine("Quantidade total de jogos: "+ totalDeJogos);
                writer.WriteLine("Quantidade de jogos disponiveis: ");
                writer.WriteLine("Valor medio por jogo: "+ valorMedio);
                writer.WriteLine("Jogo mais caro: "+ maisCaro);
                writer.WriteLine("Jogo mais barato: "+ maisBarato);
                writer.WriteLine("==========================================================================");
            }

        }
    }
}
