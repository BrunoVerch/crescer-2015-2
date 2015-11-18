package br.com.cwi.crescer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    public static void menu() {
        System.out.println("\tLista");
        System.out.println("0. Adiciona na primeira posicao");
        System.out.println("1. Adiciona na ultima posicao");
        System.out.println("2. Remove na primeira posicao");
        System.out.println("3. Remove na posicao selecionada");
        System.out.println("4. Adiciona na posicao selecionada");
        System.out.println("5. Verifica se esta vazio");
        System.out.println("6. Listar");
        System.out.println("7. Imprime lista no arquivo");
        System.out.println("8. Sair");
        System.out.println("Opcao:");
    }

    public static void adicionaNaPrimeiraPosicao(LinkedList linkedList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o valor");
        String valor = entrada.nextLine();
        linkedList.addFirst(valor);
    }

    public static void adicionaNaUltimaPosicao(LinkedList linkedList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o valor");
        String valor = entrada.nextLine();
        linkedList.addLast(valor);
    }

    public static void removeNaPrimeiraPosicao(LinkedList linkedList) {
        linkedList.removeFirst();
    }

    public static void removeNaPosicaoSelecionada(LinkedList linkedList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a posicao");
        int valor = entrada.nextInt();
        linkedList.remove(valor);
    }

    public static void adicionaNaPosicaoSelecionada(LinkedList linkedList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o valor");
        String valor = entrada.nextLine();
        System.out.println("Digite a posicao");
        int posicao = entrada.nextInt();
        linkedList.adicionar(posicao,valor);
    }

    public static void verificaSeEstaVazio(LinkedList linkedList) throws InterruptedException {
        System.out.println(linkedList.isEmpty());
        Thread.sleep(3000);
    }

    public static void listar(LinkedList linkedList) throws InterruptedException {
        List<String> lista = linkedList.list();
        for(String valor : lista ){
            System.err.println(valor);
        }
        Thread.sleep(6000);
    }

    public static void listarNoArquivo(LinkedList linkedList) throws IOException {
        List<String> lista =linkedList.list();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o caminho");
        String valor = entrada.nextLine();
        File file = new File(valor);
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter buff=new BufferedWriter(new FileWriter(file));
        for(String val : lista ){
            buff.write(val);
            buff.newLine();
        }
        buff.close();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        LinkedList linkedList = new LinkedList();
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            menu();
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    adicionaNaPrimeiraPosicao(linkedList);
                    break;

                case 1:
                    adicionaNaUltimaPosicao(linkedList);
                    break;

                case 2:
                    removeNaPrimeiraPosicao(linkedList);
                    break;

                case 3:
                    removeNaPosicaoSelecionada(linkedList);
                    break;

                case 4:
                    adicionaNaPosicaoSelecionada(linkedList);
                    break;

                case 5:
                    verificaSeEstaVazio(linkedList);
                    break;

                case 6:
                    listar(linkedList);
                    break;

                case 7:
                    listarNoArquivo(linkedList);
                    break;

                case 8:
                    System.out.println("Voce saiu");
                    break;

                default:
                    System.out.println("Op��o inv�lida.");
            }
        } while (opcao != 7);

    }

}
