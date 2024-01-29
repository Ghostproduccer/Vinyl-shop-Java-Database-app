package com.example.pojo;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "pedidos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pedidos {

    @XmlElement(name = "pedido")
    private List<Pedido> pedidos;

    public Pedidos() {
    }

    public Pedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
