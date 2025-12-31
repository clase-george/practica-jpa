package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.PeliculaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class PeliculasRepositoryTest {

    @Autowired
    private PeliculasRepository peliculasRepository;

    @Test
    void deberiaEncontrarPeliculasPorNombreDirector() {
        List<PeliculaEntity> pelis = peliculasRepository.findByDirectorNombre("Christopher Nolan");
        assertThat(pelis).isNotEmpty();
        assertThat(pelis).extracting(PeliculaEntity::getTitulo).contains("Inception");
    }

    @Test
    void deberiaEncontrarPeliculasPorActor_conQuery() {
        List<PeliculaEntity> pelis = peliculasRepository.findByActorNombre("Leonardo DiCaprio");
        assertThat(pelis).isNotEmpty();
        assertThat(pelis).extracting(PeliculaEntity::getTitulo).contains("Inception", "The Wolf of Wall Street");
    }
}
