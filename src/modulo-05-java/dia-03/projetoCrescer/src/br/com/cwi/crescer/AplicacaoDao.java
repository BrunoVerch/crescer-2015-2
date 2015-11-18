package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class AplicacaoDao {

    public static void menu() {
        System.out.println("\tLista");
        System.out.println("0. Incluir pedido");
        System.out.println("1. Listar pedidos de determinado cliente");
        System.out.println("2. Sair");
        System.out.println("Opcao:");
    }
    
    public static void incluirPedido() throws SQLException{
    	Scanner teclado = new Scanner(System.in);
    	PedidoDao pedidoDao = new PedidoDao();

        System.out.println("Digite o nome do cliente");
        String nomeCliente = teclado.nextLine();
        List<Cliente> lista = pesquisaClientePorNome(nomeCliente);
        
        Long[] ids = exibeOpcoesDeCliente(lista);
        
        System.out.println("Selecione o cliente");
        int numCliente = teclado.nextInt();
        
        System.out.println("Digite a descricao");
        String descricao = teclado.nextLine();
        
        boolean estaDentroDasOpcoes = numCliente < ids.length;
        if (estaDentroDasOpcoes) {
        	Pedido pedido = new Pedido();
        	pedido.setIdCliente(ids[numCliente]);
        	pedido.setDsPedido(descricao);
        	pedidoDao.include(pedido);
        }else {
            System.out.println("Opcao invalida");
        }
    }
    
    private static List<Cliente> pesquisaClientePorNome(String nomeCliente) throws SQLException{
    	ClienteDao clienteDao = new ClienteDao();
    	Cliente cliente = new Cliente();
    	cliente.setNmCliente(nomeCliente);
        return clienteDao.find(cliente);
    }
    
    private static List<Pedido> pesquisaPedidoPorIdCliente(Long id) throws SQLException{
    	PedidoDao pedidoDao = new PedidoDao();
    	Pedido pedido = new Pedido();
        pedido.setIdCliente(id);
        return pedidoDao.find(pedido);
    }
    
    private static Long[] exibeOpcoesDeCliente(List<Cliente> lista){
    	Long[] ids = new Long[lista.size()];
        int count = 0;
        for (Cliente cliente : lista) {
        	ids[count] = cliente.getIdCliente();
            count++;
            System.out.println(count + " - " + cliente.getNmCliente());
        }
        return ids;
    }

    public static void listarPedidosPorCliente() throws SQLException {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o nome do cliente");
        String nomeCliente = teclado.nextLine();
        List<Cliente> lista = pesquisaClientePorNome(nomeCliente);
        
        Long[] ids = exibeOpcoesDeCliente(lista);
        
        System.out.println("Selecione o cliente");
        int numCliente = teclado.nextInt();
        
        boolean estaDentroDasOpcoes = numCliente < ids.length;
        if (estaDentroDasOpcoes) {
            List<Pedido> listaPedidos = pesquisaPedidoPorIdCliente(ids[numCliente]);
            
            int count = 0;
            for (Pedido pedido : listaPedidos) {
                count++;
                System.out.println(count + " - " + pedido.getDsPedido());
            }
        } else {
            System.out.println("Opcao invalida");
        }
    }

    public static void main(String[] args) throws SQLException {

        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            menu();
            opcao = entrada.nextInt();

            switch (opcao) {
            	case 0:
            		incluirPedido();
            		break;
                case 1:
                    listarPedidosPorCliente();
                    break;

                case 2:
                    System.out.println("Voce saiu");
                    break;

                default:
                    System.out.println("Opçao invalida.");
            }
        } while (opcao != 1);
    }

}
