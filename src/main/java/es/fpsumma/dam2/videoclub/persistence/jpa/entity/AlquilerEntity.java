package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alquiler")
public class AlquilerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "pelicula_id", nullable = false)
    private PeliculaEntity pelicula;

    @Column(name = "fecha_alquiler", nullable = false)
    private LocalDate fechaAlquiler;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    // ===== Constructores =====//
    public AlquilerEntity() {
    }

    public AlquilerEntity(Long id, ClienteEntity cliente, PeliculaEntity pelicula, LocalDate fechaAlquiler,
            LocalDate fechaDevolucion) {
        this.id = id;
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    // ===== Getters y setters =====//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return cliente != null ? cliente.getId() : null;
    }

    public void setClienteId(Long clienteId) {
        // kept for compatibility: prefer setCliente
    }

    public Long getPeliculaId() {
        return pelicula != null ? pelicula.getId() : null;
    }

    public void setPeliculaId(Long peliculaId) {
        // kept for compatibility: prefer setPelicula
    }

    public String getFechaAlquiler() {
        return fechaAlquiler != null ? fechaAlquiler.toString() : null;
    }

    public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler != null ? LocalDate.parse(fechaAlquiler) : null;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion != null ? fechaDevolucion.toString() : null;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion != null ? LocalDate.parse(fechaDevolucion) : null;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public PeliculaEntity getPelicula() {
        return pelicula;
    }

    public void setPelicula(PeliculaEntity pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getFechaAlquilerLocal() {
        return fechaAlquiler;
    }

    public void setFechaAlquilerLocal(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaDevolucionLocal() {
        return fechaDevolucion;
    }

    public void setFechaDevolucionLocal(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
