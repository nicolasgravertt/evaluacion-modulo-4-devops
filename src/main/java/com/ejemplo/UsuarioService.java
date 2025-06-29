package com.ejemplo;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public Usuario actualizarPeso(Usuario usuario, double nuevoPeso) {
        usuario.setPeso(nuevoPeso);
        return usuario;
    }
}