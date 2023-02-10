package com.capgemini.pt.talentfactory.templatejavafundamentals;

import java.util.HashMap;

public class Menus {
    private String name;
    private String tipomenu;
    HashMap<String, Integer> artigos ;
    public Menus(String name, String tipomenu, HashMap<String, Integer> artigos) {
        this.name = name;
        this.tipomenu = tipomenu;
        this.artigos = ( HashMap<String, Integer>) artigos.clone();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTipomenu() {
        return tipomenu;
    }
    public void setTipomenu(String tipomenu) {
        this.tipomenu = tipomenu;
    }
    public void setArtigos(HashMap<String, Integer> artigos) {
        this.artigos = artigos;
    }
    public HashMap<String, Integer> getArtigos() {
        return artigos;
    }
}