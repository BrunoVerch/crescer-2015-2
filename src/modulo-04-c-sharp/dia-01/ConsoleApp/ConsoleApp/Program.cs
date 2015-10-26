using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var contato1 = new Contato("bruno", 125);
            var contato2 = new Contato("bruno2", 122);
            var contato3 = new Contato("bruno123", 123);

            var agenda = new Agenda();
            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato3);

            agenda.RemoverContatosPorNome("Bruno2");
            agenda.ListarContatos();
            Console.WriteLine("Para adicionar um contato digite 1,para remover por nome digite 2,para listar os contatos digite 3,para listar os contatos por nome digite 4");
            var digitado = Console.ReadLine();
            if(digitado == "1")
            {

                Console.ReadLine();
            }
            
            Console.ReadLine();
            
        }
    }
}
