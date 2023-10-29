package com.restgame.restproject.player;

import java.util.List;

public class Room {
    private String description;
    private String choices;
    private String instructions;

    public Room(String description, String choices, String instructions) {
        this.description = description;
        this.choices = choices;
        this.instructions = instructions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getInstructions(){
        return instructions;
    }
    public void setInstructons(String instructions){
        this.instructions=instructions;
    }
}

