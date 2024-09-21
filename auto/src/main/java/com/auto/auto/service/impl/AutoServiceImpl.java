package com.auto.auto.service.impl;

import com.auto.auto.model.entities.Auto;
import com.auto.auto.repository.AutoRepository;
import com.auto.auto.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AutoServiceImpl implements AutoService {
    private final AutoRepository autoRepository;

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public Auto getAutoById(Long id) {
        return this.autoRepository.findById(id).get();
    }

    @Override
    public List<Auto> getAllAuto() {
        return this.autoRepository.findAll();
    }

    @Override
    public Auto saveAuto(Auto auto) {
        return this.autoRepository.save(auto);
    }

    @Override
    public Auto updateAuto(Auto auto, Long id) {
        Optional<Auto> autoOptional=this.autoRepository.findById(id);
        if(autoOptional.isEmpty()){
            throw new RuntimeException("Auto not found");
        }
            auto.setId(id);
            return this.autoRepository.save(auto);
    }

    @Override
    public String deleteAuto(Long id) {
        Optional<Auto> autoOptional=this.autoRepository.findById(id);
        if(autoOptional.isEmpty()){
            return "Not found...";
        }
        this.autoRepository.deleteById(id);
        return "Auto deleted ID ==> "+id;
    }
}
