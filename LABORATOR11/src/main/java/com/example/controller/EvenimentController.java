package com.example.LABORATOR11.controller;

import com.example.LABORATOR11.model.Eveniment;
import com.example.LABORATOR11.service.EvenimentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/evenimente")
public class EvenimentController {

    private final EvenimentService service;

    public EvenimentController(EvenimentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Eveniment> getAllEvenimente() {
        return service.getAllEvenimente();
    }

    @GetMapping("/locatie/{locatie}")
    public List<Eveniment> getEvenimenteByLocatie(@PathVariable String locatie) {
        return service.getEvenimenteByLocatie(locatie);
    }

    @GetMapping("/data/{data}")
    public List<Eveniment> getEvenimenteByData(@PathVariable String data) {
        return service.getEvenimenteByData(LocalDate.parse(data));
    }

    @PostMapping
    public Eveniment addEveniment(@RequestBody Eveniment eveniment) {
        return service.addEveniment(eveniment);
    }

    @PutMapping("/{id}")
    public Eveniment updateEveniment(@PathVariable Long id, @RequestBody Eveniment eveniment) {
        return service.updateEveniment(id, eveniment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEveniment(@PathVariable Long id) {
        service.deleteEveniment(id);
        return ResponseEntity.ok().build();
    }
}
