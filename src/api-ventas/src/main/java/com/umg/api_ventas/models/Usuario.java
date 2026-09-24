package com.umg.api_ventas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "usuario_id", length = 50)
    private String usuarioId;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", columnDefinition = "varchar(20) default 'ACTIVO'")
    private EstadoUsuario estado;

    public enum Rol { VENDEDOR, ADMIN }
    public enum EstadoUsuario { ACTIVO, INACTIVO }

    // Constructor vacío exigido por JPA
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String usuarioId, String email, String passwordHash, Rol rol, EstadoUsuario estado) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.estado = estado;
    }

    // Getters y Setters
    public String getUsuarioId() { 
        return usuarioId; 
    }
    public void setUsuarioId(String usuarioId) { 
        this.usuarioId = usuarioId; 
    }

    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) {
        this.email = email; 
    }

    public String getPasswordHash() { 
        return passwordHash; 
    }
    public void setPasswordHash(String passwordHash) { 
        this.passwordHash = passwordHash; 
    }

    public Rol getRol() { 
        return rol; 
    }
    public void setRol(Rol rol) { 
        this.rol = rol; 
    }

    public EstadoUsuario getEstado() { 
        return estado; 
    }
    public void setEstado(EstadoUsuario estado) { 
        this.estado = estado; 
    }
}