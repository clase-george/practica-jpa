package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

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
    @JoinColumn(name = "cliente_id")
    private Long clienteId;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Long peliculaId;

    @Column(name = "fecha_alquiler", nullable = false)
    private String fechaAlquiler;

    @Column(name = "fecha_devolucion")
    private String fechaDevolucion;

    // ===== Constructores =====//
    public AlquilerEntity() {
    }

    public AlquilerEntity(Long id, Long clienteId, Long peliculaId, String fechaAlquiler,
            String fechaDevolucion) {
        this.id = id;
        this.clienteId = clienteId;
        this.peliculaId = peliculaId;
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
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Long peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
