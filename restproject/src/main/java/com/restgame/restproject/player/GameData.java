package com.restgame.restproject.player;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import scala.collection.Iterator;
import scala.collection.immutable.List;
@Component
public class GameData {
    private Map<Integer, Room> rooms;
    public GameData() {
        rooms = new HashMap<>();

        
        Room room1 = new Room("You have walked deep into the forest. Days have gone by and your mind starts to forget. Who are you? Choose your class:", 
        "wizard, thief, warrior", "Choose by writing localhost:8080/choose-class?player_class=class you want to pic. After this continue by writing localhost:8080/continue.");
        rooms.put(1, room1);

        Room room2 = new Room("Tall pine trees surround you. You can feel the distant warmth of an autumn sun on your face. \n Soon you come to a clearing. Pine needles coat the ground. At center of the clearing you can see set of stairs leading down. \n Why are those here? You don’t see any ruins. What do you do?" ,
        "continue, go back", "choose by typing localhost:8080/continue or goback");
        rooms.put(2, room2);
        
        Room room3 = new Room("The stairs lead you to a narrow tunnel. The stone walls of the tunnel are luminated by burning torches. \n You continue deeper until you come by a wooden door. It seems to be locked. What do you do?", 
        "use item, go back", "choose by typing localhost:8080/goback or by typing localhost:8080/use-on-door?player_item=item you want to use");
        rooms.put(3,room3); 

        Room room4 = new Room("The door leads to a small damp room. Moss coats the stone floor and walls.\n There’s a small fireplace. The fire is cracling. For a moment you feel cozy and safe. You see two open doors. One on your leftside and the other one on the right. Which way do you want to go?", 
        "go right. go left", "choose by typing localhost:8080/right ot left");
        rooms.put(4, room4);

        Room room5 = new Room("You follow a short tunnel that leads you to a metallic door. The door is rusted and ajar. \n You open it and you see skeletal remains of someone. The skeleton is wearing a heavy armor. \n You search the skeleton more closely and find a vial with red liquid inside. There doesn’t seem to be anything else here.\n What do you want to do?",
         "loot, leave skeleton", "choose by typing localhost:8080/leave_skeleton or localhost:8080/loot?loot_item=armor or vial");
        rooms.put(5, room5);
        
        Room room6 = new Room("The door leads to a ground floor of what seems to be a tower. That’s odd. You didn’t see a tower in the forest. \n Infront of you there are steel ladders that go up to the tower. What do you want to do?", 
        "go up, go back", "choose by typing localhost:8080/goup ot goback");
        rooms.put(6, room6);

        Room room7 = new Room("You climb up. You seem to be above the treeline. The last rays of autumn sun bless you with some warmth. \n There is a knight dressed in black armor infront of you. Behind them you see a wooden chest. The knight draws their sword.\n What do you do?",
        "use item, do nothing", "by typing localhost:8080/use-on-enemy?item=item you want to use or by typing localhost:8080/donothing");
        rooms.put(7, room7);
    }
    public Map<Integer, Room> getRooms() {
        return rooms;
    }
}
