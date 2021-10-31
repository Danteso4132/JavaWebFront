package com.example.webapplicationtry3;


import com.example.webapplicationtry3.Play_Repertoire.Play;
import com.example.webapplicationtry3.Play_Repertoire.Repertoire;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Controller
public class WebController {


    @GetMapping("/all")
    public String getAllTheatres(
                                 Map<String, Object> model) {
        FilterController filterController = new FilterController();
        model.put("theatreList", filterController.allTheatres);
        return "allTheatres";
    }

    @PostMapping("/all")
    public String findTheatre(@RequestParam String theatreName, Map<String, Object> model){

        FilterController filterController = new FilterController();
        model.put("theatreList", filterController.getByName(theatreName));
        return "allTheatres";
    }
    @GetMapping("/mainPage")
    public String mainPage(
            Map<String, Object> model) {
        return "mainPage";
    }


    @GetMapping("/repertoire")
    public String getAllPlays(Map<String, Object> model){
        Repertoire repertoire = new Repertoire();
        model.put("plays", repertoire.allPlays);
        return "listOfPlays";
    }

    @PostMapping("/repertoire")
    public String getFiltratedPlays(@RequestParam String genre, @RequestParam String ageString, Map<String, Object> model){
        Repertoire repertoire = new Repertoire();
        int age;
        System.out.println(ageString + genre);
        if (ageString == ""){
            age = 99;
        }
        else{
            age = Integer.parseInt(ageString);
        }
        System.out.println(age + genre);
        model.put("plays", repertoire.filterPlays(genre, age));
        return "listOfPlays";
    }



    /*
    @GetMapping("/play/{id}")
    public String playInfoGet(Map<String, Object> model){
        Repertoire repertoire = new Repertoire();
        model.put("play", repertoire.allPlays.get(0));
        return "playInfo";
    }

    @PostMapping("/play/{id}")
    public String playInfoPost(@RequestParam String id, Map<String, Object> model){
        Repertoire repertoire = new Repertoire();
        Play play = repertoire.findById(Integer.parseInt(id));
        model.put("play", play);
        return "playInfo";
    }
    */
}