package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.example.pojo.*;

public class XMLConversion {

    private static final String XML_PATH = "conexion_tienda_bruno\\src\\main\\resources\\xml\\";

    public List<User> getUsersfromXML(String usersPath) {
        File xmlFile = new File(usersPath);
        List<User> listaUsers = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Users users = (Users) jaxbUnmarshaller.unmarshal(xmlFile);
            listaUsers = users.getUsers();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaUsers;
    }

    public List<Vinilo> getVinilosfromXML(String vinilosPath) {
        File xmlFile = new File(vinilosPath);
        List<Vinilo> listaVinilos = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Vinilos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Vinilos vinilos = (Vinilos) jaxbUnmarshaller.unmarshal(xmlFile);
            listaVinilos = vinilos.getVinilos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaVinilos;
    }

    public void setVinilosToXML(String xmlPath, Vinilos vinilos) {
        try {
            JAXBContext context = JAXBContext.newInstance(Vinilos.class);
            // objeto Marshaller para escribir
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // escribimos al xml
            jaxbMarshaller.marshal(vinilos, new File(xmlPath));
            System.out.println("Vinilos volcados a xml en " + xmlPath);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Pedido> getPedidosfromXML(String pedidosPath) {
        File xmlFile = new File(pedidosPath);
        List<Pedido> listaPedidos = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Pedidos pedidos = (Pedidos) jaxbUnmarshaller.unmarshal(xmlFile);
            listaPedidos = pedidos.getPedidos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaPedidos;
    }

    public List<DetallePedido> getDetallesPedidosfromXML(String detallesPedidosPath) {
        File xmlFile = new File(detallesPedidosPath);
        List<DetallePedido> listaDetallesPedidos = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(DetallesPedidos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            DetallesPedidos detallesPedidos = (DetallesPedidos) jaxbUnmarshaller.unmarshal(xmlFile);
            listaDetallesPedidos = detallesPedidos.getDetallesPedidos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaDetallesPedidos;
    }

    public static String getXmlPath() {
        return XML_PATH;
    }

}
