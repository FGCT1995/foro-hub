package com.aluradesafios.forohub.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record DatosCreacionTopico(
        @NotBlank (message = "Titulo es obligatorio")
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDateTime fecha_de_creacion,
        @NotNull
        String autor,
        @NotNull
        Curso curso
                                  ) {
}
