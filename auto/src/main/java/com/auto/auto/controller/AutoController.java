package com.auto.auto.controller;

import com.auto.auto.exception.ExceptionAuto;
import com.auto.auto.model.entities.Auto;
import com.auto.auto.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auto")
@CrossOrigin("*")
public class AutoController {
    private final AutoService autoService;
    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Auto> getAutoById(@PathVariable Long id){
        try {
            Auto auto=this.autoService.getAutoById(id);
            return new ResponseEntity<>(auto,HttpStatus.OK);
        }catch (Exception e){
            throw new ExceptionAuto("Auto not found");
        }
    }
    @GetMapping
    public ResponseEntity<List<Auto>> getAutoList(){
        return new ResponseEntity<>(this.autoService.getAllAuto(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Auto> createAuto(@RequestBody Auto auto){
        return new ResponseEntity<>(this.autoService.saveAuto(auto), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Auto> updateAuto(@PathVariable Long id, @RequestBody Auto auto){
        return new ResponseEntity<>(this.autoService.updateAuto( auto,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuto(@PathVariable Long id) {
        return new ResponseEntity<>(this.autoService.deleteAuto(id), HttpStatus.NO_CONTENT);
    }

}
