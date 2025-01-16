package org.example.controller;

import org.example.model.Masina;
import org.example.service.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/masini")
public class MasinaController {

    @Autowired
    private MasinaService masinaService;

    @PostMapping("/adauga")
    public void adaugaMasina(@RequestBody Masina masina) {
        masinaService.adaugaMasina(masina);
    }

    @DeleteMapping("/sterge/{nrInmatriculare}")
    public void stergeMasina(@PathVariable String nrInmatriculare) {
        masinaService.stergeMasina(nrInmatriculare);
    }

    @GetMapping("/{nrInmatriculare}")
    public Masina cautaMasina(@PathVariable String nrInmatriculare) {
        return masinaService.cautaMasina(nrInmatriculare);
    }

    @GetMapping("/toate")
    public List<Masina> getToateMasinile() {
        return masinaService.getToateMasinile();
    }

    @GetMapping("/count/marca")
    public long countMasiniCuMarca(@RequestParam String marca) {
        return masinaService.countMasiniCuMarca(marca);
    }

    @GetMapping("/count/km")
    public long countMasiniSub100000Km() {
        return masinaService.countMasiniSub100000Km();
    }

    @GetMapping("/masini_noi")
    public List<Masina> masiniMaiNoiDe5Ani() {
        return masinaService.masiniMaiNoiDe5Ani();
    }
}
