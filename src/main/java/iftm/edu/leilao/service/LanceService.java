package iftm.edu.leilao.service;

import iftm.edu.leilao.model.Lance;
import iftm.edu.leilao.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanceService {

    @Autowired
    private LanceRepository repository;

    public Lance salvarLance(Lance lance) {
        repository.save(lance);
        return lance;
    }

    public List<Lance> listarLance() {
        return repository.findAll();
    }

    public void atualizarLance(Integer id, Lance lance) {
        lance.setId(id);
        repository.save(lance);
    }

    public void excluirLance(Integer id) {
        repository.deleteById(id);
    }
}
