package com.auto.auto.controller;

import com.auto.auto.exception.ExceptionAuto;
import com.auto.auto.model.entities.Auto;
import com.auto.auto.model.entities.Dealership;
import com.auto.auto.service.IAutoService;
import com.auto.auto.service.IDealershipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dealership")
@AllArgsConstructor
@CrossOrigin("*")
public class DealershipController {
    private final IDealershipService dealershipservice;
    @GetMapping("{id}")
    public ResponseEntity<Dealership> getDealershipById(@PathVariable Long id){
        try {
            Dealership dealership=this.dealershipservice.getDealershipById(id);
            return new ResponseEntity<>(dealership, HttpStatus.OK);
        }catch (Exception e){
            throw new ExceptionAuto("Auto not found");
        }
    }
    @GetMapping
    public ResponseEntity<List<Dealership>> getDealershipList(){
        return new ResponseEntity<>(this.dealershipservice.getAllDealership(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Dealership> createDealership(@RequestBody Dealership dealership){
        return new ResponseEntity<>(this.dealershipservice.saveDealership(dealership), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Dealership> updateDealership(@PathVariable Long id, @RequestBody Dealership dealership){
        return new ResponseEntity<>(this.dealershipservice.updateDealership( dealership,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDealership(@PathVariable Long id) {
        return new ResponseEntity<>(this.dealershipservice.deleteDealership(id), HttpStatus.NO_CONTENT);
    }
}
