package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HolidaysController {
    HolidayDAO holidayDAO = new HolidayDAO("jdbc:sqlite:C:/SQLite/Calendar.db");

    @GetMapping("/holiday")
    public ArrayList<Holiday> getHolidays(){
        return holidayDAO.getAllHolidays();
    }

    @GetMapping("/holiday/{id}")
    public Holiday doGetHolidayById(@PathVariable("id") int id){
        return holidayDAO.getHolidayById(id);
    }

    @PostMapping("/holiday")
    public void addHoliday(@RequestBody Holiday holiday){
        holidayDAO.insertHoliday(holiday);
    }

    @PutMapping("/holiday/{id}")
    public void doUpdateHolidayByID(@PathVariable("id") int id, @RequestBody Holiday sent){
        holidayDAO.updateHoliday(sent, id);
    }

    @DeleteMapping ("/holiday/{id}")
    public void deleteHolidayById(@PathVariable("id") int id){
        holidayDAO.deleteHoliday(id);
    }
}
