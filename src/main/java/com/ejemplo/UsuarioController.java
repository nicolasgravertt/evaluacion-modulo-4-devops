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
        // Aquí podrías hacer lógica adicional si quisieras
        return service.actualizarPeso(usuario, usuario.getPeso());
    }
}
