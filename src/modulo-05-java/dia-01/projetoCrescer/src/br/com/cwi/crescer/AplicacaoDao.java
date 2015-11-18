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

    public static void ListarPedidosPorCliente() throws SQLException {
        Scanner teclado = new Scanner(System.in);
        ClienteDao clienteDao = new ClienteDao();
        PedidoDao pedidoDao = new PedidoDao();
        Cliente cliente = new Cliente();

        System.out.println("Digite o nome do cliente");
        String nomeCliente = teclado.nextLine();
        cliente.setNmCliente(nomeCliente);
        List<Cliente> lista = clienteDao.find(cliente);
        Long[] ids = new Long[lista.size()];
        int count = 0;
        for (Cliente cliente2 : lista) {
            count++;
            System.out.println(count + " - " + cliente2.getNmCliente());
            // TODO refatorar e arrumar
            ids[count] = cliente2.getIdCliente();
        }
        System.out.println("Selecione o cliente");
        int numCliente = teclado.nextInt();
        if (numCliente < ids.length) {
            Pedido pedido = new Pedido();
            pedido.setIdCliente(ids[numCliente]);
            List<Pedido> listaPedidos = pedidoDao.find(pedido);
            int count2 = 0;
            for (Pedido pedido2 : listaPedidos) {
                count2++;
                System.out.println(count2 + " - " + pedido.getDsPedido());
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
                case 1:
                    ListarPedidosPorCliente();
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
