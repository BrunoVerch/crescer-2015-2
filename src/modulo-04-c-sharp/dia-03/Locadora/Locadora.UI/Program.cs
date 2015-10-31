using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.UI
{
    class Program
    {
        private const string CADASTRAR_JOGO = "1";
        private const string EDITAR_NOME_JOGO = "2";
        private const string EDITAR_PRECO_JOGO = "3";
        private const string EDITAR_CATEGORIA_JOGO = "4";
        private const string PESQUISAR_JOGO = "5";
        private const string GERA_RELATORIO = "6";
        private const string SAIR = "7";

        static void Main(string[] args)
        {
            ClasseOpcoes opcoes = new ClasseOpcoes();
            string opcao;
            do
            {
                opcoes.Menu();
                opcao = opcoes.Opcao();
                if (opcao == CADASTRAR_JOGO)
                    opcoes.CadatrarJogo();
                else if (opcao == EDITAR_NOME_JOGO)
                    opcoes.EditarNomeJogo();
                else if (opcao == EDITAR_PRECO_JOGO)
                    opcoes.EditarPrecoJogo();
                else if (opcao == EDITAR_CATEGORIA_JOGO)
                    opcoes.EditarCategoriaJogo();
                else if (opcao == PESQUISAR_JOGO)
                    opcoes.PesquisarPorNome();
                else if (opcao == GERA_RELATORIO)
                    opcoes.GerarRelatorio();

            } while (opcao != SAIR);
        }
    }
}
