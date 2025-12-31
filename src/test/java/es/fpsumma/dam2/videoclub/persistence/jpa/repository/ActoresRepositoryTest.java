package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ActorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ActoresRepositoryTest {

    @Autowired
    private ActoresRepository actoresRepository;

    @Test
    void deberiaEncontrarActorPorNombre() {
        List<ActorEntity> actores = actoresRepository.findByNombre("Tom Hanks");
        assertThat(actores).hasSize(1);
        assertThat(actores.get(0).getNombre()).isEqualTo("Tom Hanks");
    }

    @Test
    void deberiaEncontrarActoresPorTituloPelicula_conQuery() {
        List<ActorEntity> actores = actoresRepository.buscarPorTituloPelicula("Inception");
        assertThat(actores).isNotEmpty();
        assertThat(actores).extracting(ActorEntity::getNombre).contains("Leonardo DiCaprio");
    }
}
