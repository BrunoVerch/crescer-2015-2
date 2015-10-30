using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;
using DbExtensions;

namespace Aula4Ado
{
    class Program
    {
        static void Main(string[] args)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = 
                    "UPDATE Cargo SET Nome = @paramNome WHERE IDCargo = @paramIdCargo";

                comando.AddParameter("paramNome", "Prefeito");
                comando.AddParameter("paramIdCargo", "0 OR 1=1 --");

                connection.Open();

                int linhasAfetadas = comando.ExecuteNonQuery();
                
                transacao.Complete();

                connection.Close();
            }


            
            Console.Read();
        }
        
    }
}


/*
using (TransactionScope transacao = new TransactionScope())
using (IDbConnection connection = new SqlConnection(connectionString))
{
    IDbCommand comando = connection.CreateCommand();
    comando.CommandText = "INSERT INTO Cargo (Nome, Situacao) values (@paramNome, @paramSituacao)";

    IDbDataParameter paramNome = comando.CreateParameter();
    paramNome.ParameterName = "paramNome";
    paramNome.Value = "Didi";
    comando.Parameters.Add(paramNome);

    IDbDataParameter paramSituacao = comando.CreateParameter();
    paramSituacao.ParameterName = "paramSituacao";
    paramSituacao.Value = "I";
    comando.Parameters.Add(paramSituacao);

    connection.Open();

    comando.ExecuteNonQuery();

    //int num = Convert.ToInt32("abc");

    transacao.Complete();

    connection.Close();
}
*/

/*
IDbCommand comando = connection.CreateCommand();
comando.CommandText = "SELECT * FROM Partido";
connection.Open();

IDataReader reader = comando.ExecuteReader();

while (reader.Read())
{
    string nome = reader["Nome"].ToString();
    Console.WriteLine(nome);
}

connection.Close();
*/


/**
string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

IDbConnection connection = 
    new SqlConnection(connectionString);

IDbCommand comando = connection.CreateCommand();

string novoNome = "' or 1=1 --";

comando.CommandText = "UPDATE Candidato SET NomeCompleto = @paramNomeCompleto WHERE IDCandidato = 1";

var paramenter = comando.CreateParameter();
paramenter.ParameterName = "paramNomeCompleto";
paramenter.Value = novoNome;

comando.Parameters.Add(paramenter);


connection.Open();

//int afetados = comando.ExecuteNonQuery();

connection.Close();
*/
