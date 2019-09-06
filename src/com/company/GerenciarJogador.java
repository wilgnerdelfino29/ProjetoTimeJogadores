package com.company;

import java.util.Scanner;

/**
 * Classe para gerenciar a execucao do programa que ira conter atributos e metodos para o mesmo.
 * O objeto criado contera um vetor do tipo Time, assim como um vetor do tipo Jogador.
 * Ambos terao a função de controle e armazenamento.
 * @author Wilgner Delfino
 * @since 06 de Setembro de 2019
 */

public class GerenciarJogador {

    public int i = 0;
    public int j = 0;
    Time times[] = new Time[4];
    Jogador jogs[] = new Jogador[12];
    Scanner sc = new Scanner(System.in);

    /**
     * O main contera um menu de escolha para acessar as principais funcoes do programa.
     */

    public static void main(String[] args) {
        GerenciarJogador ger = new GerenciarJogador();
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        do{
            System.out.println("--- Menu Principal ---");
            System.out.println();
            System.out.println("1.. Cadastrar time");
            System.out.println("2.. Cadastrar jogador");
            System.out.println("3.. Cadastrar jogador no time");
            System.out.println("4.. Remover jogador do time");
            System.out.println("5.. Listar jogadores do time");
            System.out.println("6.. Listar dados do time");
            System.out.println("7.. Listar times");
            System.out.println("9.. Sair");
            System.out.println();
            System.out.println("Opção: ");
            opt = ger.validaInt("Opção");
            switch (opt){
                case 1:
                    ger.execCadTime();
                    break;
                case 2:
                    ger.execCadJogador();
                    break;
                case 3:
                    ger.execCadJogadorNoTime();
                    break;
                case 4:
                    ger.execRemJogadorDoTime();
                    break;
                case 5:
                    ger.listarJogadoresDoTime();
                    break;
                case 6:
                    ger.listarDadosTime();
                    break;
                case 7:
                    ger.listarTimes();
                    break;
                case 9:
                    System.out.println("Fechando programa..");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }while (opt!=9);

    }

    /**
     * Metodo para cadastrar um time criando um objeto Time.
     */

    public void execCadTime(){
        if (i < 4) {
            times[i] = new Time();
            times[i].setIdTime(i);
            System.out.println("Nome do time: ");
            times[i].setNomeTime(sc.nextLine());
            System.out.println("Time " + times[i].getNomeTime() + " cadastrado com sucesso!");
            System.out.println();
            i++;
        } else {
            System.out.println("Limite de times atingido!");
        }
    }

    /**
     * Metodo para cadastrar um jogador criando um objeto Jogador.
     */

    public void execCadJogador(){
        if (j < 12) {
            jogs[j] = new Jogador();
            jogs[j].setIdJogador(j);
            System.out.println("Nome do jogador: ");
            jogs[j].setNomeJogador(sc.nextLine());
            System.out.println("Posição do jogador: ");
            jogs[j].setPosicaoJogador(sc.nextLine());
            System.out.println("Jogador " + jogs[j].getNomeJogador() + " cadastrado com sucesso!");
            System.out.println();
            j++;
        } else {
            System.out.println("Limite de jogadores atingido!");
        }
    }

    /**
     * Metodo que inicia o cadastro de um jogador em um time.
     */

    public void execCadJogadorNoTime(){
        if(seTiverTime()) {
            System.out.println("JOGADORES SEM TIMES");
            System.out.println();
            for (Jogador jog : jogs) {
                if (jog != null && !jog.isTaNumTime())
                    System.out.println(jog.getIdJogador() + ".. " + jog.getNomeJogador() + ".. " + jog.getPosicaoJogador());
            }
            System.out.println();
            System.out.println("Id do jogador:");
            int idJog = validaInt("Id do jogador");
            if (idJog < j && idJog >= 0) {
                System.out.println("TIMES");
                System.out.println();
                for (Time t : times) {
                    if (t != null) {
                        if (t != null) t.listar();
                    }
                }
                System.out.println();
                System.out.println("Id do time: ");
                int idTime = validaInt("Id do time");
                if (idTime < i && idTime >= 0) {
                    times[idTime].adicionarJogador(jogs[idJog]);
                } else {
                    System.out.println("Id de time não existente!");
                }
            } else {
                System.out.println("Id de jogador não existente!");
            }
        }
    }

    /**
     * Metodo que inicia a remocao de um jogador de um time.
     */

    public void execRemJogadorDoTime(){
        if(seTiverTime()) {
            System.out.println("TIMES");
            System.out.println();
            for (Time t : times) {
                if (t != null) if (t != null) t.listar();
            }
            System.out.println();
            System.out.println("Id do time:");
            int idTime = validaInt("Id do time");
            if (idTime < i && idTime >= 0) {
                times[idTime].removerJogador();
            } else {
                System.out.println("Id de time não existente!");
            }
        }
    }

    /**
     * Metodo que inicia o processo de imprimir na tela os dados de um time
     */

    public void listarDadosTime(){
        if(seTiverTime()) {
            System.out.println("ID do time:");
            int idDesejado = validaInt("Id do time");
            for (Time t : times) {
                if (t != null) {
                    if (t.getIdTime() == idDesejado) {
                        t.listar();
                        return;
                    }
                }
            }
            System.out.println("Id de time não existente!");
        }
    }

    /**
     * Metodo que inicia o processo de imprimir na tela os jogadores de um time
     */

    public void listarJogadoresDoTime(){
        if(seTiverTime()) {
            System.out.println("ID do time:");
            int idDesejado = validaInt("Id do time");
            for (Time t : times) {
                if (t != null) {
                    if (t.getIdTime() == idDesejado) {
                        t.listarJogadores();
                        return;
                    }
                }
            }
            System.out.println("Id de time não existente!");
        }
    }

    /**
     * Metodo que imprimi nas tela os dados de todos os times cadastrados
     * juntamente com os dados dos jogadores cadastrados naquele time.
     */

    public void listarTimes(){
        if(seTiverTime()){
            for (Time t : times) {
                if (t != null) {
                    System.out.println();
                    System.out.println("________  TIME___________");
                    t.listar();
                    System.out.println();
                    if(t.getQtdJogadores()>0) {
                        System.out.println("______  JOGADORES________");
                        t.listarJogadores();
                        System.out.println();
                    }
                }
            }
        }
    }

    /**
     * Metodo de controle usado para verificar se ha times cadastrados
     * e bloquear outros metodos de executar caso nao haja times.
     * @return boolean true - se tiver times cadastrados
     * @return boolean false - se nao houver times cadastrados
     */

    public boolean seTiverTime(){
        if(i>0) {
            return true;
        }else{
            System.out.println();
            System.out.println("Não há times cadastrados ainda, por favor, cadastre um time.");
            System.out.println();
            return false;
        }
    }

    /**
     * Metodo para validar entrada inteira que bloqueia outros tipos de entrada.
     * Recebe como parametro o nome do campo inteiro a ser validado.
     * Corrige a mensagem de erro quando nao inteiro e pede nova entrada.
     * Quando entrado valor inteiro retorna o valor digitado.
     * @param campo String
     * @return int - opt
     */

    public int validaInt(String campo){
        int opt;
        while(true) {
            try {
                opt = Integer.parseInt(sc.nextLine());
                break;
            }catch (java.lang.NumberFormatException e){
                System.out.println(campo + " deve ser inteiro!");
                System.out.println("Digite novamente: ");
            }
        }
        return opt;
    }
}
