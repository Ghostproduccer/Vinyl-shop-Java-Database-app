package com.example.pojo;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "detalles_pedidos")
@XmlAccessorType(XmlAccessType.FIELD)
public class DetallesPedidos {

    @XmlElement(name = "detalle_pedido")
    private List<DetallePedido> detallesPedidos;

    public DetallesPedidos() {
    }

    public DetallesPedidos(List<DetallePedido> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }

    public List<DetallePedido> getDetallesPedidos() {
        return detallesPedidos;
    }

    public void setDetallesPedidos(List<DetallePedido> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }

}
