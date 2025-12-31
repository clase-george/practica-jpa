package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ActorEntity;

public interface ActoresRepository extends JpaRepository<ActorEntity, Long> {

    // Buscar actor por nombre
    List<ActorEntity> findByNombre(String nombre);

    // Obtener actores que han participado en una película por título (travesal)
    List<ActorEntity> findByPeliculasTitulo(String titulo);

    // JPQL: obtener actores por título de película
    @Query("SELECT DISTINCT a FROM ActorEntity a JOIN a.peliculas p WHERE p.titulo = :titulo")
    List<ActorEntity> buscarPorTituloPelicula(@Param("titulo") String titulo);

    // Ordenación alfabética por nombre
    List<ActorEntity> findAllByOrderByNombreAsc();

}
