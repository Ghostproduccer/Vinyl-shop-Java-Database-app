package com.example.main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.example.dao.DetallePedidoDAOImplementation;
import com.example.dao.PedidoDAOImplementation;
import com.example.dao.UserDAOImplementation;
import com.example.dao.ViniloDAOImplementation;
import com.example.model.*;
import com.example.util.DatabaseConnection;
import com.example.util.XMLConversion;

public class TiendaBrunoBBDD {

    DatabaseConnection databasecon = new DatabaseConnection();

    UserDAOImplementation userDAO = new UserDAOImplementation();
    ViniloDAOImplementation viniloDAO = new ViniloDAOImplementation();
    PedidoDAOImplementation pedidoDAO = new PedidoDAOImplementation();
    DetallePedidoDAOImplementation detalleDAO = new DetallePedidoDAOImplementation();

    private XMLConversion xmLtoList = new XMLConversion();

    public TiendaBrunoBBDD() {
    }

    public void consultarTabla(String tabla) {

        if (tabla.equals("users")) {

            for (User user : userDAO.getAllUsers()) {
                System.out.println(user);
            }

        }
        if (tabla.equals("vinilos")) {

            for (Vinilo vinilo : viniloDAO.getAllVinilos()) {
                System.out.println(vinilo);
            }

        }
        if (tabla.equals("pedidos")) {

            for (Pedido pedido : pedidoDAO.getAllPedidos()) {
                System.out.println(pedido);
            }

        }
        if (tabla.equals("detalles_pedido")) {

            for (DetallePedido dp : detalleDAO.getAllDetallesPedidos()) {
                System.out.println(dp);
            }

        }
    }

    public void realizarPedido(Vinilos vinilos, User cliente) {

        // Primero actualizar el stock de los vinilos seleccionados y realizar el
        // seguimiento de la cantidad
        Map<Integer, Integer> cantidadPorVinilo = new HashMap<>();

        for (Vinilo vinilo : vinilos.getVinilos()) {
            if (vinilo != null && vinilo.getStock() > 0) {

                // Realizar el seguimiento de la cantidad por vinilo
                int cantidadActual = cantidadPorVinilo.getOrDefault(vinilo.getIdVinilo(), 0);

                // Verificar si ya existe un registro para este vinilo
                if (cantidadActual == 0) {
                    cantidadPorVinilo.put(vinilo.getIdVinilo(), 1);
                } else {
                    cantidadPorVinilo.put(vinilo.getIdVinilo(), cantidadActual + 1);
                }

                int nuevoStock = vinilo.getStock() - cantidadPorVinilo.getOrDefault(vinilo.getIdVinilo(), 1);

                vinilo.setStock(nuevoStock);

                viniloDAO.updateVinilo(vinilo);

                System.out.println("Stock del vinilo " + vinilo.getIdVinilo() + " Actualizado a " + vinilo.getStock());

            } else {
                System.out.println("Vinilo agotado");
            }
        }

        // Después añadir un nuevo pedido
        LocalDate fechaActual = LocalDate.now();
        int idPedido = pedidoDAO
                .insertPedido(new Pedido(null, cliente.getIdUser(), fechaActual.toString(), "En proceso"));
        System.out.println("nuevo pedido añadido con id" + idPedido);

        // Insertar registros en la tabla detalles_pedido
        for (Map.Entry<Integer, Integer> entry : cantidadPorVinilo.entrySet()) {
            int idVinilo = entry.getKey();
            int cantidad = entry.getValue();
            // Obtener el precio unitario del vinilo
            double precioUnitario = viniloDAO.getViniloById(idVinilo).getPrecio();

            detalleDAO.insertDetallePedido(new DetallePedido(null, idPedido, idVinilo, cantidad, precioUnitario));

            System.out.println("Detalle de pedido insertado para el vinilo " + idVinilo);
        }
    }

    public void insertarVinilosdesdeXML(String vinilosPath) {

        List<Vinilo> vinilosInsert = xmLtoList.getVinilosfromXML(vinilosPath);

        for (Vinilo vinilo : vinilosInsert) {
            viniloDAO.insertVinilo(vinilo);
        }

        System.out.println("Se han insertado " + vinilosInsert.size() + " vinilos en la base de datos\n");

    }

    public void volcarVinilosXML() {
        Vinilos vinilos = new Vinilos(viniloDAO.getAllVinilos());
        LocalDate fechaActual = LocalDate.now();
        String xmlPath = xmLtoList.getXmlPath() + "backup_vinilos_" + fechaActual.toString() + ".xml";

        xmLtoList.setVinilosToXML(xmlPath, vinilos);
    }

    public void modificarPrecioVinilo(Vinilo vinilo, Scanner sc) {
        System.out.println("El precio actual es " + vinilo.getPrecio() + " , introduzca el nuevo importe:");
        double nuevoPrecio = sc.nextDouble();
        vinilo.setPrecio(nuevoPrecio);
        viniloDAO.updateVinilo(vinilo);
        System.out.println("precio actualizado");
    }
}
