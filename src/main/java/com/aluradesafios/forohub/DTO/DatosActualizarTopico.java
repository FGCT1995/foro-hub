package com.aluradesafios.forohub.DTO;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        Curso curso
) {
}
