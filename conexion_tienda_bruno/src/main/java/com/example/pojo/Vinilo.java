package com.example.pojo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "vinilo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vinilo {

    @XmlElement(required = true)
    private Integer idVinilo;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "artista")
    private String artista;

    @XmlElement(name = "genero")
    private String genero;

    @XmlElement(name = "ano_lanzamiento")
    private Integer anoLanzamiento;

    @XmlElement(name = "precio")
    private Double precio;

    @XmlElement(name = "stock")
    private Integer stock;

    public Vinilo() {
    }

    public Vinilo(Integer idVinilo, String nombre, String artista, String genero,
            Integer anoLanzamiento, Double precio, Integer stock) {
        this.idVinilo = idVinilo;
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.anoLanzamiento = anoLanzamiento;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer getIdVinilo() {
        return idVinilo;
    }

    public void setIdVinilo(Integer idVinilo) {
        this.idVinilo = idVinilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public void setAnoLanzamiento(Integer anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "\n----------\nid=" + idVinilo + "\nNombre=" + nombre + "\nArtista=" + artista
                + "\nGénero=" + genero + "\nAño de lanzamiento=" + anoLanzamiento + "\nPrecio=" + precio
                + "\nStock=" + stock + "\n----------\n";
    }

}
