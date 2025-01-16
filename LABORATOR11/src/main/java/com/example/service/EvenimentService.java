package com.example.LABORATOR11.service;

import com.example.LABORATOR11.model.Eveniment;
import com.example.LABORATOR11.repository.EvenimentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EvenimentService {

    private final EvenimentRepository repository;

    public EvenimentService(EvenimentRepository repository) {
        this.repository = repository;
    }

    public List<Eveniment> getAllEvenimente() {
        return repository.findAll();
    }

    public List<Eveniment> getEvenimenteByLocatie(String locatie) {
        return repository.findByLocatie(locatie);
    }

    public List<Eveniment> getEvenimenteByData(LocalDate data) {
        return repository.findByData(data);
    }

    public Eveniment addEveniment(Eveniment eveniment) {
        return repository.save(eveniment);
    }

    public Eveniment updateEveniment(Long id, Eveniment evenimentDetails) {
        Eveniment eveniment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Eveniment nu a fost găsit"));
        eveniment.setDenumire(evenimentDetails.getDenumire());
        eveniment.setLocatie(evenimentDetails.getLocatie());
        eveniment.setData(evenimentDetails.getData());
        eveniment.setTimp(evenimentDetails.getTimp());
        eveniment.setPretBilet(evenimentDetails.getPretBilet());
        return repository.save(eveniment);
    }

    public void deleteEveniment(Long id) {
        repository.deleteById(id);
    }
}
