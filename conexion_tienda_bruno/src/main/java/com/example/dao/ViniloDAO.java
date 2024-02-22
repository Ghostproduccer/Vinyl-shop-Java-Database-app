package com.example.dao;

import com.example.model.Vinilo;

import java.util.List;

public interface ViniloDAO {

    List<Vinilo> getAllVinilos();

    Vinilo getViniloById(int id);

    boolean insertVinilo(Vinilo vinilo);

    boolean updateVinilo(Vinilo vinilo);

    boolean deleteVinilo(int id);
}
