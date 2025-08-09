package com.aluradesafios.forohub.Controller;

import com.aluradesafios.forohub.DTO.Curso;
import com.aluradesafios.forohub.Modelo.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_de_creacion,
        String autor,
        Curso curso
) {
    public DatosDetalleTopico(Topico topicos) {
        this(
                topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensaje(),
                topicos.getFechaDeCreacion(),
                topicos.getAutor(),
                topicos.getCurso()
        );
    }
}
