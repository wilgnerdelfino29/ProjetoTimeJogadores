package com.company;

import java.util.Scanner;

/**
 * Classe para objetos do tipo Time que ira conter atributos e metodos para o mesmo.
 * O objeto criado contera um vetor do tipo Jogador podendo ter ate 3 objetos Jogador em cada Time.
 * @author Wilgner Delfino
 * @since 03 de Setembro de 2019
 */

public class Time {
    private int idTime;
    private String nomeTime;
    private Jogador[] jogadores = new Jogador[3];
    private int qtdJogadores = 0;
    GerenciarJogador ger = new GerenciarJogador();

    /**
     * Metodo para adicionar um novo jogador ao time e finalizar o processo de cadastro,
     * onde e passado como parametro uma referencia de um Jogador.
     * @param jog - Jogador
     */

    public void adicionarJogador(Jogador jog){
        if(qtdJogadores<3){
            if(!jog.isTaNumTime()){
                jogadores[qtdJogadores] = jog;
                jogadores[qtdJogadores].setTaNumTime(true);
                System.out.println("Jogador "+jog.getNomeJogador()+" agora está no time "+getNomeTime()+"!");
                System.out.println();
                qtdJogadores++;
                ger.j++;
            }else{
                System.out.println("Jogador já cadastrado em um time!");
            }
        }else{
            System.out.println("Limite de jogadores no time atingido!");
        }
    }

    /**
     * Metodo para remover um jogador do time e finalizar o processo de remocao.
     */

    public void removerJogador(){
        Scanner sc = new Scanner(System.in);
        if(getQtdJogadores()>0){
            System.out.println("JOGADORES DO TIME");
            System.out.println();
            for (Jogador jog : jogadores) {
                if (jog != null)
                    System.out.println(jog.getIdJogador() + ".. " + jog.getNomeJogador() + ".. " + jog.getPosicaoJogador());
            }
            System.out.println();
            System.out.println("Id do jogador:");
            int idJog = ger.validaInt("Id do jogador");
            int cont=0;

            for (Jogador jog:jogadores) {
                if(jog!=null){
                    if(jog.getIdJogador()==idJog){
                        jogadores[idJog] = null;
                        jog.setTaNumTime(false);
                        System.out.println();
                        System.out.println("Jogador removido do time");
                        System.out.println();
                        qtdJogadores--;
                        ger.j--;
                        break;
                    }else{
                        cont++;
                    }
                }else {
                    cont++;
                }
            }
            if(cont==3){
                System.out.println();
                System.out.println("Não há jogador com esse id no time!");
                System.out.println();
            }
        }else{
            System.out.println();
            System.out.println("Não há jogadores no time!");
            System.out.println();
        }
    }


    /**
     * Metodo para imprimir na tela os jogadores do time.
     */

    public void listarJogadores(){
        for (Jogador j: jogadores) {
            if(j!=null) j.listarJogador();
        }
    }

    /**
     * Metodo para imprimir na tela os dados do time excepto os dados do vetor de jogadores.
     */

    public void listar(){
        System.out.println(getIdTime()+".. "+getNomeTime()+".. "+getQtdJogadores()+" jogadores");
    }

    /**
     * Metodo para retorno do id do time.
     * @return int - idTime
     */

    public int getIdTime() {
        return idTime;
    }

    /**
     * Metodo para alterar o id do time.
     * @param idTime - int
     */

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }


    /**
     * Metodo para retorno do nome do time.
     * @return String - nomeTime
     */

    public String getNomeTime() {
        return nomeTime;
    }

    /**
     * Metodo para alterar o nome do time.
     * @param nomeTime - String
     */

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    /**
     * Metodo para retorno da quantidade atual de jogadores no time.
     * @return int qtdJogadores.
     */

    public int getQtdJogadores() {
        return qtdJogadores;
    }
}
