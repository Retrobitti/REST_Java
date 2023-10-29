package com.restgame.restproject.player;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Player {
    private String player_class;
    private int currentRoomId; // Add currentRoomId attribute
    private String[] items;
    private int health;
    private int armor;
    private String description;
    private String info;
    private String conclusion;
    

    public Player(String playerClass) {
        this.player_class = playerClass;
        this.currentRoomId = 0; // Initialize to an empty string

        if ("wizard".equals(playerClass)) {
            this.health = 20;
            this.armor = 0;
            this.items = new String[] { "fire_sphere_spell", "ice_wall_spell", "potion_of_liquifying" };
            this.description="Wizards are wise and learned. You value knowledge above all and  you must learn more before the thirst of it drives you mad.";
            this.conclusion="Inside the chest you find an old tome written in an ancient language that has been long forgotten. This will quench your thirst for now.";
        } else if ("thief".equals(playerClass)) {
            this.health = 20;
            this.armor = 0;
            this.items = new String[] { "dagger", "lockpick", "smoke_bomb" };
            this.description="It’s a cruel world. Born into poverty or forced to it by some event you have to survive and make ends meet. No matter what it takes.";
            this.conclusion="Inside the chest you find gold and jewels. These are more than enough to get you out of poverty. But are they worth more than a life?";
        } else if ("warrior".equals(playerClass)) {
            this.health = 40;
            this.armor = 20;
            this.items = new String[] { "sword", "shield" };
            this.description="Warriors value respect and fame above all else. You achieve this by searching strong foes and defeating them.";
            this.conclusion="You leave the chest. Defeating a mighty foe is enough for you.";
        }
    }

    public String getPlayerClass() {
        return this.player_class;
    }

    public void setPlayerClass(String player_class) {
        this.player_class = player_class;
    }

    public String[] getItems() {
        return this.items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    // Getters and setters for other attributes
    public int getCurrentRoomId() {
        return currentRoomId;
    }

    public void setCurrentRoomId(int currentRoomId) {
        this.currentRoomId = currentRoomId;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getInfo(){
        String info = "Health: " + String.format("%d", this.getHealth())+"\n"+ 
        "Armor: " + String.format("%d", this.getArmor())+"\n"+
        "Items: " + Arrays.toString(this.items) + "\n";
        return info;
    }

    public String getConclusion(){
        return this.conclusion;
    }

}
