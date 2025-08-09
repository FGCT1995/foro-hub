package com.aluradesafios.forohub.DTO;

import com.aluradesafios.forohub.Modelo.Topico;

import java.time.LocalDateTime;
import java.util.Date;

public record DatosListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_de_creacion,
        String autor,
        Curso curso
) {
    public DatosListaTopicos(Topico topicos){
        this(
                topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensaje(),
                topicos.getFechaDeCreacion(),
                topicos.getAutor(),
                topicos.getCurso());
    }
}
