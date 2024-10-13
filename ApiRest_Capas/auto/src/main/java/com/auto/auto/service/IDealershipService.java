package com.auto.auto.service;

import com.auto.auto.model.entities.Auto;
import com.auto.auto.model.entities.Dealership;

import java.util.List;

public interface IDealershipService {
    public Dealership getDealershipById(Long id);
    public List<Dealership> getAllDealership();
    public Dealership saveDealership(Dealership  dealership);
    public Dealership updateDealership(Dealership dealership, Long id);
    public String deleteDealership(Long id);
}
