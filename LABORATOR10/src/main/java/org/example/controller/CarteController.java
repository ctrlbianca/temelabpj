package org.example.controller;

import org.example.model.Carte;
import orrg.example.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lista-carti")
public class CarteController {
    @Autowired
    private CarteService carteService;

    @GetMapping
    public String getAllCarti(Model model) {
        List<Carte> carti = carteService.getAllCarti();
        model.addAttribute("carti", carti);
        model.addAttribute("mesaj", "Lista cartilor preluate prin repository");
        return "lista-carti";
    }

    @PostMapping("/adauga")
    public String adaugaCarte(@ModelAttribute Carte carte, Model model) {
        if (carte.getIsbn().isEmpty() || carte.getTitlu().isEmpty() || carte.getAutor().isEmpty()) {
            model.addAttribute("mesaj", "Adaugarea nu se realizează dacă nu completaţi toate caracteristicile!");
        } else {
            carteService.saveCarte(carte);
            model.addAttribute("mesaj", "Adaugare realizata cu succes!");
        }
        return "redirect:/lista-carti";
    }

    @PostMapping("/modifica")
    public String modificaCarte(@ModelAttribute Carte carte, Model model) {
        if (carteService.getCarteByIsbn(carte.getIsbn()).isPresent()) {
            carteService.saveCarte(carte);
            model.addAttribute("mesaj", "Cartea cu ISBN-ul " + carte.getIsbn() + " a fost modificata!");
        } else {
            model.addAttribute("mesaj", "Nu se gaseste nici o carte cu isbn-ul introdus.");
        }
        return "redirect:/lista-carti";
    }

    @PostMapping("/sterge")
    public String stergeCarte(@RequestParam String isbn, Model model) {
        if (carteService.getCarteByIsbn(isbn).isPresent()) {
            carteService.deleteCarte(isbn);
            model.addAttribute("mesaj", "Stergerea a fost realizata cu succes!");
        } else {
            model.addAttribute("mesaj", "Nu exista o carte cu acest ISBN!");
        }
        return "redirect:/lista-carti";
    }

    @PostMapping("/filtreaza")
    public String filtreazaDupaAutor(@RequestParam(required = false) String autor, Model model) {
        if (autor == null || autor.isEmpty()) {
            model.addAttribute("carti", carteService.getAllCarti());
            model.addAttribute("mesaj", "Toate cărţile au fost afişate!");
        } else {
            List<Carte> carti = carteService.getCartiByAutor(autor);
            model.addAttribute("carti", carti);
            model.addAttribute("mesaj", "Cărţile următoare aparţin autorului " + autor);
        }
        return "lista-carti";
    }
}
