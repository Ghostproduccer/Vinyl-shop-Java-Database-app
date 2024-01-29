package com.example.pojo;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "vinilos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vinilos {

    @XmlElement(name = "vinilo")
    private List<Vinilo> vinilos;

    public Vinilos() {
    }

    public Vinilos(List<Vinilo> vinilos) {
        this.vinilos = vinilos;
    }

    public List<Vinilo> getVinilos() {
        return vinilos;
    }

    public void setVinilos(List<Vinilo> vinilos) {
        this.vinilos = vinilos;
    }
    
}
