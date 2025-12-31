package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.AlquilerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class AlquileresRepositoryTest {

    @Autowired
    private AlquileresRepository alquileresRepository;

    @Test
    void deberiaEncontrarAlquileresPorEmailCliente() {
        List<AlquilerEntity> alquileres = alquileresRepository.findByClienteEmail("ana.perez@example.com");
        assertThat(alquileres).hasSize(2);
    }

    @Test
    void deberiaEncontrarAlquileresActivosPorEmail_conQuery() {
        List<AlquilerEntity> alquileres = alquileresRepository.findActiveByClienteEmail("ana.perez@example.com");
        assertThat(alquileres).hasSize(1);
        assertThat(alquileres.get(0).getPelicula().getTitulo()).isEqualTo("Interstellar");
    }
}
