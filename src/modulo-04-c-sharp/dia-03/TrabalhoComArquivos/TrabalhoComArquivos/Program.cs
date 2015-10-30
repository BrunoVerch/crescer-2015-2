using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace TrabalhoComArquivos
{
    class Program
    {
        static void Main(string[] args)
        {
            //double salario = 10;

            //string texto = String.Format("meu salario eh {0}, {0}", salario);
            //Console.WriteLine(texto);

            //Console.WriteLine(DateTime.Now);
            //Console.WriteLine(DateTime.Now.ToString("dd-MM-yyyy"));
            /*
            string texto = String.Format("minha data de pagamento eh {0:dd-MM-yyyy}", DateTime.Now);
            Console.WriteLine(texto);
            Console.Read();
            */
        }

        /*
        static void Main(string[] args)
        {
            string caminhoArquivo = @"C:\Users\Ben-hur\Desktop\arquivos\jogos.xml";

            XElement xmlJogos = XElement.Load(caminhoArquivo);

            foreach (XElement jogo in xmlJogos.Elements("jogo"))
            {
                XElement nome = jogo.Element("nome");
                Console.WriteLine(jogo.Attribute("id"));
                Console.WriteLine(nome.Value);
            }

            Console.Read();
        }
        */

        /*
        static void Main(string[] args)
        {
            string caminhoArquivo = @"C:\Users\Ben-hur\Desktop\arquivos\meu-arquivo.txt";

            using (var reader = new StreamReader(caminhoArquivo))
            {
                reader.ReadLine();

            }

            //try
            //{
            //    ;
            //}
            //finally
            //{
            //    if(reader != null)
            //    {
            //        reader.Dispose();
            //    }
            //}
            Console.Read();
        }
        */
        /*
        static void Main(string[] args)
        {
            string caminhoArquivo = @"C:\Users\Ben-hur\Desktop\arquivos\meu-arquivo.txt";
            var arquivoPrincipal = File.Open(caminhoArquivo, FileMode.Open, FileAccess.ReadWrite, FileShare.ReadWrite);

            var reader = new StreamReader(caminhoArquivo);
            var leitura = reader.ReadToEnd();

            Console.Read();
        }*/

        /*
        static void Main(string[] args)
        {
            string caminhoArquivo = @"C:\Users\Ben-hur\Desktop\arquivos\meu-arquivo.txt";

            var writer = new StreamWriter(caminhoArquivo, true);

            writer.WriteLine("didi must die");


            writer.Close();

            Console.Read();
        }
        */

        /*
        static void Main(string[] args)
        {
            string caminhoArquivo = @"C:\Users\Ben-hur\Desktop\arquivos\meu-arquivo.txt";
            string textoDoArquivo = "didi must die"; // + Environment.NewLine;

            //File.AppendAllText(caminhoArquivo, textoDoArquivo);
            //File.AppendAllText(caminhoArquivo, textoDoArquivo);
            //string[] linhas = File.ReadAllLines(caminhoArquivo);
            //string texto = File.ReadAllText(caminhoArquivo);

            byte[] arquivo = File.ReadAllBytes(caminhoArquivo);

            Console.Read();
        }
        */
    }
}
