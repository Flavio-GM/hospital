package br.gama.itau.hospital.integration;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import br.gama.itau.hospital.model.Paciente;
import br.gama.itau.hospital.repo.PacienteRepo;
import br.gama.itau.hospital.util.GeneratePaciente;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
public class PacienteControllerITTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PacienteRepo repo;

    @Test
    public void getAll_returnListPaciente_whenPacienteExist() throws Exception {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(GeneratePaciente.novoPaciente1());
        pacientes.add(GeneratePaciente.novoPaciente2());

        repo.saveAll(pacientes);

        ResultActions retorno = mockMvc.perform(get("/pacientes").contentType(MediaType.APPLICATION_JSON));

        retorno.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", CoreMatchers.is(2)))
                .andExpect(jsonPath("$[0].name", CoreMatchers.is(GeneratePaciente.novoPaciente1().getName())));
    }
}
