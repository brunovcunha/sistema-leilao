package iftm.edu.leilao.service;

import iftm.edu.leilao.model.Participante;
import iftm.edu.leilao.repository.ParticipanteRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository repository;

    public void novoParticipante(Participante participante) {
        repository.save(participante);
    }

    public Participante buscarParticipantePorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Participante não encontrado"));
    }

    public List<Participante> buscarParticipantes() {
        return repository.findAll();
    }

    public void atualizarParticipantePorId(Integer id, Participante participante) {
        participante.setId(id);
        repository.save(participante);

    }

    public void deletarParticipante(Integer id) {
        repository.deleteById(id);
    }
}
