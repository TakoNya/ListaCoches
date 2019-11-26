package listacochesapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCochesApp {
//Se crea un ArrayList para guardar obtejos de tipo Coche.

    static ArrayList<Coche> coches = new ArrayList();
    static Scanner teclado = new Scanner(System.in);

    //método main
    public static void main(String[] args) {
        leerCoches();
        System.out.println("\nCoches introducidos: ");
        mostrarCoches();
        mostrarPorMarca();
        mostrarPorKm();
        System.out.println("\nCoches con mayor número de Km: " + mostrarMayorKm());
        System.out.println("\nCoches ordenados de menor a mayor número de Km");
        mostrarOrdenadosPorKm();

    } //fin método main.

    //Método para leer coches e introducirlos en el array
    public static void leerCoches() {
        //Declaración de variables para leer los datos de los coches
        String matricula;
        String marca;
        String modelo;
        int Km;
        //Variable auxiliar que contendrá la referencia a cada coche nuevo.
        Coche aux;
        int i, N;
        //se pide por teclado el número de coches a leer
        do {
            System.out.print("Número de coches? ");
            N = teclado.nextInt();
        } while (N < 0);
        teclado.nextLine(); //limpiar el intro
        //lectura de N coches
        for (i = 1; i <= N; i++) {
            //leer datos de cada coche
            System.out.println("Coche " + i);
            System.out.print("Matrícula: ");
            matricula = teclado.nextLine();
            System.out.print("Marca: ");
            marca = teclado.nextLine();
            System.out.print("Modelo: ");
            modelo = teclado.nextLine();
            System.out.print("Número de kilómetros: ");
            Km = teclado.nextInt();
            teclado.nextLine();  //limpiar intro
            //Se crea un objeto Coche como aux, se asignan valores a los atributos del nuevo objeto
            aux = new Coche();
            aux.setMatricula(matricula);
            aux.setMarca(marca);
            aux.setModelo(modelo);
            aux.setKm(Km);
            //Se añade el objeto al final del array
            coches.add(aux);

        }
    } //fin del m{etodo leerCoches();
    //Método para mostrar todos los coches

    public static void mostrarCoches() {
        for (int i = 0; i < coches.size(); i++) {
            System.out.println(coches.get(i)); //se invoca el método toString de la clase Coche
        }
    }

    //Método para mostrar todos los coches de una marca que se pide por teclado
    public static void mostrarPorMarca() {
        String marca;
        System.out.print("Introduce marca: ");
        marca = teclado.nextLine();
        System.out.println("Coches de la marca " + marca);
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getMarca().equalsIgnoreCase(marca)) {
                System.out.println(coches.get(i));
            }
        }

    }

    //Método para mostrar todos los coches con un número de Km inferior
    //al número de Km que se pide por teclado
    public static void mostrarPorKm() {
        int Km;
        System.out.print("introduce número de kilómetros: ");
        Km = teclado.nextInt();
        System.out.println("Coches con menos de " + Km + " Km");
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getKm() < Km) {
                System.out.println(coches.get(i));
            }
        }

    }

    //Método que devuelve el Coche con mayor número de Km
    public static Coche mostrarMayorKm() {
        Coche mayor = coches.get(0);
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getKm() > mayor.getKm()) {
                mayor = coches.get(i);
            }
            return mayor;
        }
        return null;
    }
        //método que muestra los coches ordenados por número de Km de menor a mayor
        public static void mostrarOrdenadosPorKm(){
            int i,j;
            Coche aux;
            for (i = 0; i < coches.size();i++)
                for (j=0;j<coches.size()-i-1;j++)                    
                    if(coches.get(j+1).getKm()<coches.get(j).getKm()){
                        aux=coches.get(j+1);
                        coches.set(j+1, coches.get(j));
                        coches.set(j,aux);
        }
            mostrarCoches();
    }

}//fin de la clase principal
