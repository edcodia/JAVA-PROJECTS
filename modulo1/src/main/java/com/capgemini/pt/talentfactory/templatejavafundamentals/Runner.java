package com.capgemini.pt.talentfactory.templatejavafundamentals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Runner implements CommandLineRunner {
    private RestauranteService restiSvc;
    private Pattern integerPattern;

    public Runner(RestauranteService restiSvc) {
        this.restiSvc = restiSvc;
        this.integerPattern = Pattern.compile("^(\\d+)$");

    }
    public int getAllRestaurantes() {
        return this.restiSvc.list().size();
    }
    public void showMainMenu(Scanner scanner) {
        System.out.println("# Menu principal #");
        System.out.println("1) Criar restaurante");
        System.out.println("2) Ver restaurante");
        System.out.println("3) Criar Menu");
        System.out.println("4) Ver Menu");
        System.out.println("5) Sair");
        System.out.print("> ");
        String option = scanner.nextLine();

        switch (option) {
            case "1":
                this.criarRestaurante(scanner);
                break;
            case "2":
                this.showRestaurante(scanner);
                this.showMainMenu(scanner);
                break;
            case "3":
                this.criarMenu(scanner);
                break;
            case "4":
                this.showMenu(scanner);
                break;
            case "5":
                break;
            default:
                this.showMainMenu(scanner);
        }
    }
    private void showRestaurante(Scanner scanner) {
        System.out.println("# Mostrar Restaurante #");
        for (int i = 0 ; i < restiSvc.list().size() ; i++) {
            System.out.printf("Restaurante %s, %s, %s, %d, %d, %d, %d \n" , restiSvc.list().get(i).getNome(),restiSvc.list().get(i).getMorada(),
                    restiSvc.list().get(i).getCodigopostal(),restiSvc.list().get(i).getContato(),restiSvc.list().get(i).getAbertura(), restiSvc.list().get(i).getEncerramento(), i);
        }

    }
    private void criarRestaurante(Scanner scanner) {
        System.out.println("# Criar Restaurante #");
        System.out.print("Nome> ");
        String nome = scanner.nextLine();
        System.out.print("Morada> ");
        String morada = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\d{4}(-\\d{3})?");
        Matcher matcher ;

        String codigoPostal = "";
        boolean b;
        do{
            System.out.print("Codigo Postal> ");
            codigoPostal = scanner.nextLine();
            matcher = pattern.matcher(codigoPostal);
            b = matcher.matches();

            if(!b){
                System.out.println("Codigo postal invalido");
            }

        }while(!b);


        System.out.print("Contato> ");
        int contato = scanner.nextInt();
        System.out.print("Abertura> ");
        int abertura = scanner.nextInt();
        System.out.print("Encerramento> ");
        int encerramento = scanner.nextInt();

        System.out.print("Menu");
        ArrayList<Menus> menu = new ArrayList<Menus>();

        Restaurante restaurante = new Restaurante(nome, morada , codigoPostal ,contato, abertura , encerramento,  menu );

        this.restiSvc.add(restaurante);
        this.showMainMenu(scanner);
    }
    private void criarMenu(Scanner scanner) {
        Scanner ler = new Scanner(System.in);
        showRestaurante(scanner);

            System.out.printf("\n em que restaurante quer criar o menu :\n");
            int i = ler.nextInt();

        System.out.println("# Criar Menu#");
        System.out.print("Nome> ");
        String name = scanner.nextLine();
        System.out.print("Tipo de Menu> ");
        String tipomenu = scanner.nextLine();

        HashMap<String, Integer>  artigos = new  HashMap<String, Integer>();


        System.out.println("Número de produtos a introduzir");

        int num = scanner.nextInt() ;
        scanner.nextLine();
        for (int j =0; j < num ; j++ ){
            System.out.print("Produto:");
            String key = scanner.nextLine();
            System.out.print("Preço:");
            int valor = scanner.nextInt();
            scanner.nextLine();
            artigos.put(key, valor);
        }

        Menus menu = new Menus(name, tipomenu, artigos);
        restiSvc.list().get(i).getMenu().add(menu);
        this.showMainMenu(scanner);
}
    private void showMenu(Scanner scanner) {
        Scanner ler = new Scanner(System.in);
        showRestaurante(scanner);
        System.out.printf("\n Quer ver o menu de qual restaurante :\n");
        int i = ler.nextInt();
       ArrayList<Menus> menuList = restiSvc.list().get(i).getMenu();

       for (Menus menu : menuList){
           System.out.println(menu.getName()+" " +menu.getTipomenu()+" \n");

           for (String produto : menu.getArtigos().keySet()) {
               System.out.println("Produto:" + produto + " preço: " + menu.getArtigos().get(produto));
           }
       }
            this.showMainMenu(scanner);
            }

      @Override
      public void run(String... args) throws Exception {
          try (Scanner scanner = new Scanner(System.in)) {
              this.showMainMenu(scanner);
          }
          System.out.println("\n Bye bye!");
      }
    }





