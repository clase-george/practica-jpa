package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.AlquilerEntity;

public interface AlquileresRepository extends JpaRepository<AlquilerEntity, Long> {

    // Alquileres por email de cliente
    List<AlquilerEntity> findByClienteEmail(String email);

    // Alquileres por título de película
    List<AlquilerEntity> findByPeliculaTitulo(String titulo);

    // Alquileres activos (fecha_devolucion IS NULL)
    List<AlquilerEntity> findByFechaDevolucionIsNull();

    // JPQL obligatorio: alquileres activos de un cliente por email
    @Query("SELECT a FROM AlquilerEntity a WHERE a.cliente.email = :email AND a.fechaDevolucion IS NULL")
    List<AlquilerEntity> findActiveByClienteEmail(@Param("email") String email);

}
