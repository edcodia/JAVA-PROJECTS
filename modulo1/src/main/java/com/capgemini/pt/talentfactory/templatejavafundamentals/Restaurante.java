package com.capgemini.pt.talentfactory.templatejavafundamentals;
import java.util.ArrayList;

public class Restaurante {
    private String nome, morada,codigopostal ;
    private int contato;
    private int abertura, encerramento;
    ArrayList<Menus> menu ;
    public Restaurante(String nome, String morada, String codigopostal, int contato, int abertura, int encerramento, ArrayList<Menus> menu ) {
        this.nome = nome;
        this.morada = morada;
        this.codigopostal = codigopostal;
        this.contato = contato;
        this.abertura = abertura;
        this.encerramento = encerramento;
        this.menu = ( ArrayList<Menus> ) menu.clone() ;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }

    public int getAbertura() {
        return abertura;
    }

    public void setAbertura(int abertura) {
        this.abertura = abertura;
    }

    public int getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(int encerramento) {
        this.encerramento = encerramento;
    }
    public ArrayList<Menus> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menus> menu) {
        this.menu = menu;
    }
}