package com.meteo.dao;

import com.meteo.model.Signalement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignalementRowMapper implements RowMapper<Signalement> {

    @Override
    public Signalement mapRow(ResultSet rs, int rowNum) throws SQLException {
        Signalement signalement = new Signalement(
                rs.getDouble("LATITUDE"),
                rs.getDouble("LONGITUDE"),
                rs.getString("TEMPS"),
                rs.getDouble("TEMPERATURE")
        );
        signalement.setId(rs.getInt("ID"));
        return signalement;
    }
}
