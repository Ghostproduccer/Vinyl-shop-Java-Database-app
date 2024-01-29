package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.pojo.*;

public class Main {

    private static TiendaBrunoBBDD bbdd = new TiendaBrunoBBDD();
    private static Scanner sc = new Scanner(System.in);
    private static final String XML_PATH = XMLConversion.getXmlPath();

    public static void main(String[] args) {

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    consultarTabla();
                    break;
                case 2:
                    realizarPedido();
                    break;
                case 3:
                    modificarPrecioVinilo();
                    break;
                case 4:
                    insertarDesdeXML();
                    break;
                case 5:
                    backupXML();
                    break;

                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Consultar tabla");
        System.out.println("2. Realizar pedido");
        System.out.println("3. Modificar precio vinilo");
        System.out.println("4. Insertar vinilos desde XML");
        System.out.println("5. Backup de vinilos a XML");
        System.out.println("6. Salir");
        System.out.println();
        System.out.print("Seleccione una opción: ");
    }

    private static void consultarTabla() {
        sc.nextLine();
        System.out
                .println("\nIntroduzca el nombre de la tabla (vinilos, pedidos, users, detalles_pedido):");
        String tabla = sc.nextLine();
        bbdd.consultarTabla(tabla);
    }

    private static void realizarPedido() {
        User cliente = bbdd.listarUsuarios().get(0);
        List<Vinilo> listaVinilos = new ArrayList<>();
        bbdd.consultarTabla("vinilos");
        sc.nextLine();

        while (true) {
            System.out.println(
                    "\nIngrese el ID del vinilo para añadirlo al pedido (o 'fin' para finalizar):");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                int idVinilo = Integer.parseInt(input);
                Vinilo vinilo = bbdd.consultarVinilo(idVinilo);

                if (vinilo != null) {
                    listaVinilos.add(vinilo);
                    System.out.println("Vinilo añadido a la lista.\n");
                } else {
                    System.out.println("No se encontró un vinilo con el ID proporcionado.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un ID válido.");
            }
        }
        Vinilos vinilos = new Vinilos(listaVinilos);
        System.out
                .println("Lista final de vinilos seleccionados para el pedido: \n" + vinilos.getVinilos()+"\n");

        bbdd.realizarPedido(vinilos, cliente);
    }

    private static void modificarPrecioVinilo() {
        System.out.println("Introduzca el id del vinilo");
        Integer idVinilo = sc.nextInt();
        Vinilo vinilo = bbdd.consultarVinilo(idVinilo);
        System.out.println(vinilo);
        sc.nextLine();
        System.out.println("¿Desea modificar el precio del vinilo? s/n");
        String answer = sc.nextLine();
        if (answer.equals("s")) {
            bbdd.modificarPrecioVinilo(vinilo, sc);
        }
    }

    private static void insertarDesdeXML() {
        sc.nextLine();
        System.out.println("Introduzca el nombre del archivo XML a volcar:");
        String fileName = sc.nextLine();
        bbdd.insertarVinilosdesdeXML(XML_PATH + fileName);
    }

    private static void backupXML() {
        sc.nextLine();
        System.out.println("¿Desea hacer un backup de los vinilos? s/n");
        String siono = sc.nextLine();
        if (siono.equals("s")) {
            bbdd.volcarVinilosXML();
        }
    }

}
