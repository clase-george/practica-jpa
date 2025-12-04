package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AlquilerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    private Long peliculaId;

    private String fecha_alquiler;
    private String fecha_devolucion;

}
