package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ClienteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ClientesRepositoryTest {

    @Autowired
    private ClientesRepository clientesRepository;

    @Test
    void deberiaEncontrarClientePorEmail() {
        Optional<ClienteEntity> cliente = clientesRepository.findByEmail("ana.perez@example.com");
        assertThat(cliente).isPresent();
        assertThat(cliente.get().getNombre()).isEqualTo("Ana Perez");
    }

    @Test
    void deberiaEncontrarClientePorEmail_conQuery() {
        Optional<ClienteEntity> cliente = clientesRepository.buscarPorEmail("luis.gomez@example.com");
        assertThat(cliente).isPresent();
        assertThat(cliente.get().getNombre()).isEqualTo("Luis Gomez");
    }
}
