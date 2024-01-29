package com.example.pojo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "detalle_pedido")
@XmlAccessorType(XmlAccessType.FIELD)
public class DetallePedido {

    @XmlElement(required = true)
    private Integer idDetalle;

    @XmlElement(name = "id_pedido")
    private Integer idPedido;

    @XmlElement(name = "id_vinilo")
    private Integer idVinilo;

    @XmlElement(name = "cantidad")
    private Integer cantidad;

    @XmlElement(name = "precio_unitario")
    private Double precioUnitario;

    public DetallePedido() {
    }

    public DetallePedido(Integer idDetalle, Integer idPedido, Integer idVinilo,
            Integer cantidad, Double precioUnitario) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.idVinilo = idVinilo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdVinilo() {
        return idVinilo;
    }

    public void setIdVinilo(Integer idVinilo) {
        this.idVinilo = idVinilo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "\n----------\nidDetalle=" + idDetalle + "\nidPedido=" + idPedido
                + "\nidVinilo=" + idVinilo + "\ncantidad=" + cantidad + "\nprecioUnitario=" + precioUnitario + "\n----------\n";
    }

}
