package com.auto.auto.service.impl;

import com.auto.auto.model.entities.Dealership;
import com.auto.auto.repository.DealershipRepository;
import com.auto.auto.service.IDealershipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DealershipServiceImpl implements IDealershipService {
    private final DealershipRepository dealershipRepository;
    @Override
    public Dealership getDealershipById(Long id) {
        return dealershipRepository.getById(id);
    }

    @Override
    public List<Dealership> getAllDealership() {
        return dealershipRepository.findAll();
    }

    @Override
    public Dealership saveDealership(Dealership dealership) {
        return dealershipRepository.save(dealership);
    }

    @Override
    public Dealership updateDealership(Dealership dealership, Long id) {
        dealership.setId(id);
        return dealershipRepository.save(dealership);
    }

    @Override
    public String deleteDealership(Long id) {
        try {
            dealershipRepository.deleteById(id);
            return "Dealership deleted successfully";
        }catch (Exception e){
            return "Dealership not found =>id: "+id;
        }
    }
}
