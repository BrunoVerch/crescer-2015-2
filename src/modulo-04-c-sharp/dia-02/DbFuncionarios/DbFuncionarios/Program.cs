
using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;

namespace DbFuncionarios
{
    class Program
    {
        static void Main(string[] args)
        {
            //dynamic[] projecao = BuscarNomeEIdETituloDoCargoDeFuncionarios();

            //foreach (dynamic item in projecao)
            //{
            //    Console.WriteLine(item.Id);
            //    Console.WriteLine(item.Nome);
            //    Console.WriteLine(item.TituloCargo);
            //    Console.WriteLine();
            //}
            
            Console.Read();
        }

        static void Criarasdasd(int? id)
        {
            if(id.HasValue)
            {
                Console.WriteLine("Tem valor");
            }
            else
            {
                Console.WriteLine(id.Value);
            }
        }

        static dynamic[] BuscarNomeEIdETituloDoCargoDeFuncionarios()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var query = from f in funcionarios
                        select new
                        {
                            Id = f.Id,
                            Nome = f.Nome,
                            TituloCargo = f.Cargo.Titulo
                        };

            return query.ToArray();
        }

        static IList<Funcionario> BuscarOrdenadosPorNome()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var resultado = funcionarios.OrderByDescending(funcionario => funcionario.Nome).ToList();

            return resultado;
        }

        static Funcionario BuscarPorId(int id)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            //
            //return funcionarios.FirstOrDefault(funcionario => funcionario.Id == id);

            IEnumerable<Funcionario> query = from funcionario in funcionarios
                                             where funcionario.Id == id
                                             select funcionario;
            
            //query = funcionarios.Where(f => f.Id == id).FirstOrDefault();

            return query.FirstOrDefault();
        }

        static IList<Funcionario> BuscarPorCargo(string tituloCargo)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            return funcionarios.Where(f => CompararIgnoreCase(f.Cargo.Titulo, tituloCargo)).ToList();
        }

        static bool CompararIgnoreCase(string a, string b)
        {
            if (!String.IsNullOrEmpty(a) && !String.IsNullOrEmpty(b))
            {
                return a.ToUpper() == b.ToUpper();
            }

            return a == b;
        }

        static void FazNada()
        {
            Console.WriteLine("Zorra Total");
        }

    }
}



//short, int, long
//Int16, Int32, Int64
//ushort, uint, ulong
//float, double, decimal
//String
//List<int> lista = new List<int>();
//int[] arrai = new int[6];
//var lista = new List<int>();
//var diasDaSemana = new Dictionary<int, Dictionary<string, string>>();

//var pessoa = new
//{
//    Id = 1,
//    Nome = "Ben-hur"
//};

//dynamic obj = new ExpandoObject();
//obj.Id = 1;
//obj.Nome = "asdasd";

//DateTime data = new DateTime(2015, 7, 25);
//DateTime.Now

//DateTime dt = null;

//var diff = ( DateTime.Now - DateTime.Now.AddDays(-1) );







//long[] arrai = { 1, 2, 3, 4, 3, 10, 3 };

//bool temNumero3 = false;

//temNumero3 = arrai.Any(item => item == 3);

//long numero3 = arrai.FirstOrDefault(item => item == 8);

//var numerosPares = arrai.Count(numero => numero % 2 == 0 && numero > 4);

//for (int i = 0; i < arrai.Length; i++)
//{
//    if(arrai[i] == 3)
//    {
//        temNumero3 = true;
//        break;
//    }
//}

//Console.WriteLine(temNumero3);