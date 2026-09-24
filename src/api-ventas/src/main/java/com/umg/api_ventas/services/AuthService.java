package com.umg.api_ventas.services;

import com.umg.api_ventas.dto.LoginRequest;
import com.umg.api_ventas.dto.LoginResponse;
import com.umg.api_ventas.models.Usuario;
import com.umg.api_ventas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public LoginResponse login(LoginRequest request) {
        // 1. Buscar usuario por email
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el correo: " + request.getEmail()));

        // 2. Validar contraseña
        if (!usuario.getPasswordHash().equals(request.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // 3. Generar token de sesión simulado
        String tokenSimulado = "bearer_token_" + UUID.randomUUID().toString();

        return new LoginResponse(tokenSimulado, usuario.getRol().name(), usuario.getUsuarioId());
    }
}