package com.company;

/**
 * Classe para objetos do tipo Jogador que ira conter atributos e metodos para o mesmo.
 * @author Wilgner Delfino
 * @since 03 de Setembro de 2019
 */

public class Jogador {
    private int idJogador;
    private String nomeJogador;
    private String posicaoJogador;
    private boolean taNumTime;


    /**
     * Metodo para imprimir na tela os dados jogador.
     */

    public void listarJogador(){
        System.out.println("ID Jogador: " + idJogador);
        System.out.println("Jogador: " + nomeJogador);
        System.out.println("Posicao: " + posicaoJogador);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _");
        System.out.println();
    }

    /**
     * Metodo para retorno do id do jogador.
     * @return int - idJogador
     */

    public int getIdJogador() {
        return idJogador;
    }

    /**
     * Metodo para alterar o id do jogador.
     * @param idJogador int
     */

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    /**
     * Metodo para retorno do nome do jogador.
     * @return String - nomeJogador
     */

    public String getNomeJogador() {
        return nomeJogador;
    }

    /**
     * Metodo para alterar o nome do jogador.
     * @param nomeJogador String
     */

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    /**
     * Metodo para retornar a posicao do jogador.
     * @return String - posicaoJogador
     */

    public String getPosicaoJogador() {
        return posicaoJogador;
    }

    /**
     * Metodo para alterar a posicao do jogador.
     * @param posicaoJogador String
     */

    public void setPosicaoJogador(String posicaoJogador) {
        this.posicaoJogador = posicaoJogador;
    }

    /**
     * Metodo para retornar se o jogador esta cadastrado num time.
     * @return boolean - taNumTime
     */

    public boolean isTaNumTime() {
        return taNumTime;
    }

    /**
     * Metodo para alterar a situacao cadastral do jogador em um time.
     * @param taNumTime - boolean
     */

    public void setTaNumTime(boolean taNumTime) {
        this.taNumTime = taNumTime;
    }
}