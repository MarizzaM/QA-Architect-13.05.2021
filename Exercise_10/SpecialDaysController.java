package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class SpecialDaysController {
    SpecialDayDAO specialDayDAO = new SpecialDayDAO("jdbc:sqlite:C:/SQLite/Calendar.db");

    @GetMapping("/specialDay")
    public ArrayList<SpecialDay> getSpecialDays(){
        return specialDayDAO.getAllSpecialDays();
    }

    @GetMapping("/specialDay/{id}")
    public SpecialDay doGetSpecialDayById(@PathVariable("id") int id){
        return specialDayDAO.getSpecialDayById(id);
    }

    @PostMapping("/specialDay")
    public void addSpecialDay(@RequestBody SpecialDay holiday){
        specialDayDAO.insertSpecialDay(holiday);
    }

    @PutMapping("/specialDay/{id}")
    public void doUpdateSpecialDayByID(@PathVariable("id") int id, @RequestBody SpecialDay sent){
        specialDayDAO.updateSpecialDay(sent, id);
    }

    @DeleteMapping ("/specialDay/{id}")
    public void deleteSpecialDayById(@PathVariable("id") int id){
        specialDayDAO.deleteSpecialDay(id);
    }
}
