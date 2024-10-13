package com.auto.auto.service;
import com.auto.auto.model.entities.Auto;

import java.util.List;

public interface IAutoService {
    public Auto getAutoById(Long id);
    public List<Auto> getAllAuto();
    public Auto saveAuto(Auto auto);
    public Auto updateAuto(Auto auto, Long id);
    public String deleteAuto(Long id);
}
