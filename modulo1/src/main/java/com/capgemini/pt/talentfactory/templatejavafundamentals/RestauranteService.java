package com.capgemini.pt.talentfactory.templatejavafundamentals;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    private LinkedList<Restaurante> restivSvc;
    public RestauranteService() {
        this.restivSvc = new LinkedList<Restaurante>();
    }
    public void add(Restaurante restaurante) {
        this.restivSvc.add(restaurante);
    }
    public LinkedList<Restaurante> list() {
        return restivSvc;
    }
}
