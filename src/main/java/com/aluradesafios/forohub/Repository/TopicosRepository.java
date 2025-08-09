package com.aluradesafios.forohub.Repository;

import com.aluradesafios.forohub.Modelo.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicosRepository extends JpaRepository <Topico,Long>{

    Page<Topico> findAllByStatusTrue(Pageable paginacion);
}
