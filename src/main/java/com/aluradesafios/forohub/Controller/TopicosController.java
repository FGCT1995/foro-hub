package com.aluradesafios.forohub.Controller;

import com.aluradesafios.forohub.DTO.DatosActualizarTopico;
import com.aluradesafios.forohub.DTO.DatosCreacionTopico;
import com.aluradesafios.forohub.DTO.DatosListaTopicos;
import com.aluradesafios.forohub.Modelo.Topico;
import com.aluradesafios.forohub.Repository.TopicosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid DatosCreacionTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var topicos = new Topico(datos);
        repository.save(topicos);
        var uri = uriComponentsBuilder.path("/topicos/${id}").buildAndExpand(topicos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topicos));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopicos>> listar(@PageableDefault(size = 10,sort = {"fechaDeCreacion"}, direction = Sort.Direction.ASC)Pageable paginacion){
        var page =repository.findAllByStatusTrue(paginacion).map(DatosListaTopicos::new);

        return ResponseEntity.ok(page);
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity listarUno(@PathVariable Long id){
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar (@RequestBody @Valid DatosActualizarTopico datos){
        Optional<Topico> verificar = repository.findById(datos.id());

        if (!verificar.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        var topico =repository.getReferenceById(datos.id());
        topico.actualizarInformacion(datos);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public  ResponseEntity eliminar (@PathVariable Long id){
        Optional<Topico> verificar = repository.findById(id);

        if (!verificar.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        var topico = repository.getReferenceById(id);
        topico.eliminar();
        return ResponseEntity.noContent().build();
    }
}
