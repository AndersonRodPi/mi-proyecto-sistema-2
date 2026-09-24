package com.umg.api_ventas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "cliente_id", length = 50)
    private String clienteId;

    @Column(name = "documento_identidad", nullable = false, unique = true, length = 20)
    private String documentoIdentidad;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(length = 20)
    private String telefono;

    public Cliente() {
    }

    public Cliente(String clienteId, String documentoIdentidad, String nombre, String correo, String telefono) {
        this.clienteId = clienteId;
        this.documentoIdentidad = documentoIdentidad;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getClienteId() { 
        return clienteId; 
    }
    public void setClienteId(String clienteId) { 
        this.clienteId = clienteId; 
    }

    public String getDocumentoIdentidad() { 
        return documentoIdentidad; 
    }
    public void setDocumentoIdentidad(String documentoIdentidad) { 
        this.documentoIdentidad = documentoIdentidad; 
    }

    public String getNombre() {
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getCorreo() {
        return correo; 
    }
    public void setCorreo(String correo) { 
        this.correo = correo; 
    }

    public String getTelefono() { 
        return telefono; 
    }
    public void setTelefono(String telefono) { 
        this.telefono = telefono; 
    }
}