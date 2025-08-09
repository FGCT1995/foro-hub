package com.aluradesafios.forohub.Modelo;

import com.aluradesafios.forohub.DTO.Curso;
import com.aluradesafios.forohub.DTO.DatosActualizarTopico;
import com.aluradesafios.forohub.DTO.DatosCreacionTopico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_de_creacion")
    private LocalDateTime fechaDeCreacion;
    private boolean status;
    private String autor;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(@Valid DatosCreacionTopico datos) {
        this.id = null;
        this.status = true;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaDeCreacion = datos.fecha_de_creacion();
        this.autor = datos.autor();
        this.curso = datos.curso();

    }

    public void actualizarInformacion(@Valid DatosActualizarTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if (datos.curso() != null){
            this.curso = datos.curso();
        }
    }

    public void eliminar(){
        this.status = false;
    }

}
