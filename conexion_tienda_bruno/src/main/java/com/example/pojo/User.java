package com.example.pojo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlElement(required = true)
    private Integer idUser;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "apellidos")
    private String apellido;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "direccion")
    private String direccion;

    @XmlElement(name = "telefono")
    private String telefono;

    @XmlElement(name = "contrasena")
    private String contrasena;

    public User() {
    }

    public User(Integer idUser, String nombre, String apellido, String email, String direccion,
            String telefono, String contrasena) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return email;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.email = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "\n----------\nid=" + idUser + "\nNombre=" + nombre + "\nApellido=" + apellido + "\nEmail=" + email
                + "\nDireccion=" + direccion + "\nTelefono=" + telefono + "\nContrasena=" + contrasena + "\n----------\n";
    }

}
