package com.ejemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void testActualizarPeso() {
        // Arrange
        Usuario usuario = new Usuario("Carlos", 80);

        // Act
        Usuario actualizado = usuarioService.actualizarPeso(usuario, 85);

        // Assert
        assertEquals(85.0, actualizado.getPeso());
        assertEquals("Carlos", actualizado.getNombre());
    }
}

