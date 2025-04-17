package com.meteo.dao;

import com.meteo.model.Signalement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SignalementDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Ajouter un signalement
    public void ajouter(Signalement signalement) {
        String sql = "INSERT INTO SIGNALEMENT (LATITUDE, LONGITUDE, TEMPS, TEMPERATURE) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, signalement.getLatitude(), signalement.getLongitude(), signalement.getTemps(), signalement.getTemperature());
    }

    // Récupérer les signalements dans un rayon donné autour de (lat, lon)
    public List<Signalement> trouverDansLeRayon(double lat, double lon, double rayonKm) {
        String sql = "SELECT * FROM SIGNALEMENT WHERE " +
                     "TRUNC(HORODATAGE) = TRUNC(SYSDATE) AND " +
                     "(6371 * ACOS(COS(RADIANS(?)) * COS(RADIANS(LATITUDE)) * COS(RADIANS(LONGITUDE) - RADIANS(?)) + SIN(RADIANS(?)) * SIN(RADIANS(LATITUDE)))) < ?";

        return jdbcTemplate.query(sql, new Object[]{lat, lon, lat, rayonKm}, new SignalementRowMapper());
    }
}
