package com.example.webapplicationtry3.Play_Repertoire;

import java.util.ArrayList;
import java.util.List;

public class Repertoire {
    public List<Play> allPlays = new ArrayList<>(0);

    public Repertoire(){
        this.allPlays.add(new Play(1, "Лебединое озеро", "Описание 1", "Балет", 12));
        this.allPlays.add(new Play(2, "Щелкунчик", "Описание 2", "Балет", 6));
        this.allPlays.add(new Play(3, "Старуха Изергиль", "Описание 3", "Кукольный спектакль", 12));
        this.allPlays.add(new Play(4, "Дон Кихот", "Описание 4", "Трагикомедия", 6));
        this.allPlays.add(new Play(5, "Метель", "Описание 5", "Спектакль", 12));
        this.allPlays.add(new Play(6, "Левша", "Описание 6", "Сказка", 6));
    }

    //Filtering by genre + min age
    public List<Play> filterPlays(String genre, int age){
        List<Play> filteredPlays = new ArrayList<>(0);
        for (Play play : this.allPlays){
            if (play.genre.contains(genre) && play.minAge < age){
                filteredPlays.add(play);
            }
        }
        return filteredPlays;
    }

    public Play findById(int id){
        for (int i = 0; i < allPlays.size(); i++){
            if (allPlays.get(i).id == id){
                return allPlays.get(i);
            }
        }
        return null;
    }



}
