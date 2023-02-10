package com.capgemini.pt.talentfactory.templatejavafundamentals;

public class OpcaoMenu {
    private String name, preco, tipomenu;
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public OpcaoMenu(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}