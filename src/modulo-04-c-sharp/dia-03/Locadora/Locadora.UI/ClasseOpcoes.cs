using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class ClasseOpcoes
    {
        private const string AVENTURA = "1";
        private const string RPG = "2";
        private const string CORRIDA = "3";
        private const string LUTA = "4";
        private const string ESPORTE = "5";

        BibliotecaDeJogos biblioteca = new BibliotecaDeJogos();

        public void Menu()
        {
            Console.Clear();
            Console.WriteLine("Para cadastrar um jogo digite 1");
            Console.WriteLine("Para editar o nome de um jogo digite 2");
            Console.WriteLine("Para editar o preco de um jogo digite 3");
            Console.WriteLine("Para editar a categoria de um jogo digite 4");
            Console.WriteLine("Para consultar um jogo pelo nome digite 5");
            Console.WriteLine("Para gerar um relatorio digite 6");
            Console.WriteLine("Para sair digite 7");
        }
        public string Opcao()
        {
            Console.WriteLine("Digite o numero conforme opcao:");
            string opcaoEscolhida=Console.ReadLine();
            string opcoes = "[1,2,3,4,5,6,7]";
            if(Regex.Matches(opcaoEscolhida, opcoes).Count != 1)
            {
                Console.WriteLine("Não há esta opçao, escolha uma válida");
            }
            return opcaoEscolhida;
        }
        //opcao 1
        public void CadatrarJogo()
        {
            Console.WriteLine("Digite o nome do jogo:");
            string nome = Console.ReadLine();
            Console.WriteLine("Digite o preco do jogo:");
            double preco = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Escolha a categoria(caso escolha uma opcao diferente a categoria sera RPG)");
            Console.WriteLine("1-AVENTURA \r\n 2-RPG \r\n 3-CORRIDA \r\n 4-LUTA \r\n 5-ESPORTE");
            Categoria categoria = OpcoesCategoria(Console.ReadLine());
            biblioteca.CadastrarJogo(new Jogo(nome,preco,categoria));
            Console.WriteLine("Cadastrando jogo...");
            Thread.Sleep(3000);
            Console.Clear();
        }
        public Categoria OpcoesCategoria(string categoriaDigitada)
        {
            categoriaDigitada=categoriaDigitada.ToUpper();
            Categoria categoria=Categoria.RPG;
            if (categoriaDigitada == AVENTURA)
                categoria = Categoria.AVENTURA;
            else if (categoriaDigitada == RPG)
                categoria = Categoria.RPG;
            else if (categoriaDigitada == CORRIDA)
                categoria = Categoria.CORRIDA;
            else if (categoriaDigitada == LUTA)
                categoria = Categoria.LUTA;
            else if (categoriaDigitada == ESPORTE)
                categoria = Categoria.ESPORTE;
            return categoria;
        }
        //opcao 2
        public void EditarNomeJogo()
        {
            Console.WriteLine("Digite o nome do jogo a ser alterado");
            string nomeJogo = Console.ReadLine();
            Console.WriteLine("Digite o novo nome do jogo");
            string nomeAlterado = Console.ReadLine();
            int id=biblioteca.getId(nomeJogo);
            biblioteca.EditarNomeDoJogo(id, nomeAlterado);
            Console.WriteLine("Editando nome...");
            Thread.Sleep(4000);
            Console.Clear();
        }
        //opcao 3
        public void EditarPrecoJogo()
        {
            Console.WriteLine("Digite o nome do jogo a ser alterado");
            string nomeJogo = Console.ReadLine();
            Console.WriteLine("Digite o novo valor do jogo");
            double precoAlterado = Convert.ToDouble(Console.ReadLine());
            int id = biblioteca.getId(nomeJogo);
            biblioteca.EditarPrecoDoJogo(id, precoAlterado);
            Console.WriteLine("Editando preco...");
            Thread.Sleep(2000);
            Console.Clear();
        }
        //opcao 4
        public void EditarCategoriaJogo()
        {
            Console.WriteLine("Digite o nome do jogo a ser alterado");
            string nomeJogo = Console.ReadLine();
            Console.WriteLine("Escolha a categoria(caso escolha uma opcao diferente a categoria sera RPG)");
            Console.WriteLine("1-AVENTURA \r\n 2-RPG \r\n 3-CORRIDA \r\n 4-LUTA \r\n 5-ESPORTE");
            Categoria categoria = OpcoesCategoria(Console.ReadLine());
            int id = biblioteca.getId(nomeJogo);
            biblioteca.EditarCategoriaDoJogo(id, categoria);
            Console.WriteLine("Editando categoria...");
            Thread.Sleep(2000);
            Console.Clear();
        }
        //opcao 5
        public void PesquisarPorNome()
        {
            Console.WriteLine("Digite o nome do jogo");
            List<Jogo> lista = biblioteca.PesquisarJogoPorNome(Console.ReadLine());
            foreach (Jogo jogo in lista)
            {
                Console.WriteLine("ID-{0} \r\n Nome-{1} \r\n Preco-{2} \r\n Categoria-{3}", jogo.Id, jogo.Nome, jogo.Preco, jogo.Categoria);
            }
            Thread.Sleep(5000);
            Console.Clear();
        }
        //opcao 6
        public void GerarRelatorio()
        {
            biblioteca.gerarRelatorio();
            Console.WriteLine("Relatorio gerado local: "+ biblioteca.caminhoTXT);
            Thread.Sleep(5000);
            Console.Clear();
        }
    }
}
