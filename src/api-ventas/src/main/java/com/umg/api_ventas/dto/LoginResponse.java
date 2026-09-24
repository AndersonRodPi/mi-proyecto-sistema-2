package com.umg.api_ventas.dto;

public class LoginResponse {
    private String token;
    private String rol;
    private String usuarioId;

    public LoginResponse() {}

    public LoginResponse(String token, String rol, String usuarioId) {
        this.token = token;
        this.rol = rol;
        this.usuarioId = usuarioId;
    }

    public String getToken() { 
        return token; 
    }
    public void setToken(String token) { 
        this.token = token; 
    }

    public String getRol() { 
        return rol; 
    }
    public void setRol(String rol) { 
        this.rol = rol; 
    }

    public String getUsuarioId() { 
        return usuarioId; 
    }
    public void setUsuarioId(String usuarioId) { 
        this.usuarioId = usuarioId; 
    }
}