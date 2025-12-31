package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ClienteEntity;

public interface ClientesRepository extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

    Page<ClienteEntity> findAll(Pageable pageable);

    @Query("SELECT c FROM ClienteEntity c WHERE c.email = :email")
    Optional<ClienteEntity> buscarPorEmail(@Param("email") String email);

}
