package com.example.webapplicationtry3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class FilterController {

    public TheatreInfo[] allTheatres;

    FilterController(){
        String url = "http://localhost:8080/api/theatre";

        RestTemplate restTemplate = new RestTemplate();
        String allTheatres = restTemplate.getForObject(url, String.class);
        TheatreInfo[] theatres = new TheatreInfo[0];
        ObjectMapper mapper = new ObjectMapper();
        try {
            theatres = mapper.readValue(allTheatres, TheatreInfo[].class);
            this.allTheatres = theatres;
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
    }

    public List<TheatreInfo> getByName(String name){
        List<TheatreInfo> filteredTheatres = new ArrayList<TheatreInfo>();
        for (TheatreInfo theatre : this.allTheatres){
            if (theatre.name.contains(name)){
                filteredTheatres.add(theatre);
            }
        }
        return filteredTheatres;
    }
}
