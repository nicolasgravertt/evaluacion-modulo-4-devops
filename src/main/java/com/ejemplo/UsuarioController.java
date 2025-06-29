package com.ejemplo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario actualizarPeso(@RequestBody Usuario usuario) {
        return service.actualizarPeso(usuario, usuario.getPeso());
    }
}
