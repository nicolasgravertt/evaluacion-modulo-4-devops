package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testActualizarPeso() {
        Usuario usuario = new Usuario("Juan", 70.0);
        usuario.actualizarPeso(72.5);
        assertEquals(72.5, usuario.getPeso(), 0.01);
    }
}
