package com.meteo.service;

import com.meteo.dao.SignalementDAO;
import com.meteo.model.Signalement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalementService {

    @Autowired
    private SignalementDAO signalementDAO;

    // Ajouter un signalement
    public void ajouterSignalement(Signalement signalement) {
        signalementDAO.ajouter(signalement);
    }

    // Récupérer des signalements dans un rayon
    public List<Signalement> obtenirSignalements(double lat, double lon, double rayonKm) {
        return signalementDAO.trouverDansLeRayon(lat, lon, rayonKm);
    }
}
