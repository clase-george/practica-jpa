package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.PeliculaEntity;

public interface PeliculasRepository extends JpaRepository<PeliculaEntity, Long> {

    // Películas por nombre de director (usando traversal)
    List<PeliculaEntity> findByDirectorNombre(String nombre);

    // Películas por género
    List<PeliculaEntity> findByGenero(String genero);

    // Películas con puntuación mínima
    List<PeliculaEntity> findByPuntuacionGreaterThanEqual(Float puntuacion);

    // Películas en las que participa un actor (JPQL obligatorio)
    @Query("SELECT DISTINCT p FROM PeliculaEntity p JOIN p.actores a WHERE a.nombre = :nombre")
    List<PeliculaEntity> findByActorNombre(@Param("nombre") String nombre);

    // Paginación por género
    Page<PeliculaEntity> findByGenero(String genero, Pageable pageable);

    // Ordenación por año y por puntuación (consultas simples)
    @Query("SELECT p FROM PeliculaEntity p ORDER BY p.anio_estreno ASC")
    List<PeliculaEntity> findAllOrderByAnioEstrenoAsc();

    @Query("SELECT p FROM PeliculaEntity p ORDER BY p.puntuacion DESC")
    List<PeliculaEntity> findAllOrderByPuntuacionDesc();

}
