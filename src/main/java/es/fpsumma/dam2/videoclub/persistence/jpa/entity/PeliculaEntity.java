package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "anio_estreno", nullable = false)
    private Integer anio_estreno;

    @Column(name = "puntuacion")
    private Float puntuacion;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private DirectorEntity director;

    @ManyToMany(mappedBy = "peliculas")
    private List<ActorEntity> actores;

    // ===== Constructores =====
    public PeliculaEntity(Long id, String titulo, String genero, Integer anio_estreno, Float puntuacion,
            DirectorEntity director) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio_estreno = anio_estreno;
        this.puntuacion = puntuacion;
        this.director = director;
    }

    public PeliculaEntity() {
    }

    // ===== Getters y setters =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnio_estreno() {
        return anio_estreno;
    }

    public void setAnio_estreno(Integer anio_estreno) {
        this.anio_estreno = anio_estreno;
    }

    public Float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public DirectorEntity getDirector() {
        return director;
    }

    public void setDirector(DirectorEntity director) {
        this.director = director;
    }

}
