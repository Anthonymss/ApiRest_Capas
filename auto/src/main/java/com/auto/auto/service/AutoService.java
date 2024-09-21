package com.auto.auto.service;
import com.auto.auto.model.entities.Auto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AutoService {
    public Auto getAutoById(Long id);
    public List<Auto> getAllAuto();
    public Auto saveAuto(Auto auto);
    public Auto updateAuto(Auto auto, Long id);
    public String deleteAuto(Long id);
}
