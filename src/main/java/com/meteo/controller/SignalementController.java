package com.meteo.controller;

import com.meteo.model.Signalement;
import com.meteo.service.SignalementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signalements")
public class SignalementController {

    @Autowired
    private SignalementService signalementService;

    @GetMapping("/")
    public String testAPI() {
        return "API Météo opérationnelle ✅";
    }

    // Ajouter un signalement
    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouter(@RequestBody Signalement signalement) {
        signalementService.ajouterSignalement(signalement);
        return new ResponseEntity<>(HttpStatus.CREATED); // Retourne un code 201 (Created)
    }

    // Rechercher des signalements dans un rayon
    @GetMapping("/rechercher")
    public ResponseEntity<List<Signalement>> rechercher(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam double rayon) {
        List<Signalement> signalements = signalementService.obtenirSignalements(lat, lon, rayon);
        return new ResponseEntity<>(signalements, HttpStatus.OK); // Retourne une liste de signalements
    }
}
