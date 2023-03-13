package br.gama.itau.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gama.itau.hospital.model.Paciente;
import br.gama.itau.hospital.repo.PacienteRepo;
import br.gama.itau.hospital.util.GeneratePaciente;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService service;

    @Mock
    private PacienteRepo repo;

    @Test
    private void getAll_returnListPaciente_whenPacienteExist() {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(GeneratePaciente.pacienteId1());
        pacientes.add(GeneratePaciente.pacienteId2());

        BDDMockito.when(repo.findAll()).thenReturn(pacientes);

        List<Paciente> listaRecuperada = service.getAll();

        assertThat(listaRecuperada).isNotNull();
        assertThat(listaRecuperada).isNotEmpty();
        //
        assertThat(listaRecuperada.get(0).getId()).isEqualTo(GeneratePaciente.pacienteId1().getId());
    }
}
