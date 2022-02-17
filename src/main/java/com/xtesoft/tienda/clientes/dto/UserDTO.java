package com.xtesoft.tienda.clientes.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String correoe;
    private String clave;

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public UserDTO() {
    }

    public UserDTO(String correoe, String clave) {
        this.correoe = correoe;
        this.clave = clave;
    }
}
