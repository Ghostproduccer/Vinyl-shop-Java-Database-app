package com.example.pojo;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@XmlRootElement(name = "pedido")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pedido {

    @XmlElement(required = true)
    private Integer idPedido;

    @XmlElement(name = "id_user")
    private Integer idUser;

    @XmlElement(name = "fecha_pedido")
    private String fechaPedido;

    @XmlElement(name = "estado")
    private String estado;

    public Pedido() {
    }

    public Pedido(Integer idPedido, Integer idUser, String fechaPedido, String estado) {
        this.idPedido = idPedido;
        this.idUser = idUser;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\n----------\nidPedido=" + idPedido + "\nidUser=" + idUser + "\nfechaPedido=" + fechaPedido
                + "\nEstado=" + estado + "\n----------\n";
    }

}

