package br.gama.itau.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.gama.itau.hospital.model.Paciente;
import br.gama.itau.hospital.repo.PacienteRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepo repo;

    public List<Paciente> getAll() {
        return (List<Paciente>) repo.findAll();
    }
}
