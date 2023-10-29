package com.restgame.restproject.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/")
public class GameController {
    private Map<Integer, Room> rooms;
    private Map<String, Player> players = new HashMap<>();
    private final GameData gameData;
    private int currentRoom=1;
    private Player player1;
    

    public GameController(GameData gameData) {
        this.gameData=gameData;
        this.rooms = gameData.getRooms();
        
    }

    public String getInfo(){
        
        rooms.get(currentRoom);
        return player1.getInfo();
    }

    //Gets the starting room 
    @GetMapping
    public Room getInitialRoom() {
        currentRoom = 1;
        return rooms.get(1);    
    }
    
    //Allows player to choose theiur desired class
    @PostMapping("/choose-class")
    public String choosePlayerClass(@RequestParam String player_class) {
        player1 = new Player(player_class);
        player1.setCurrentRoomId(1); 
        players.put("player 1", player1);
        return player1.getDescription()+" You've chosen the class: " + player_class;
    }

    // Takes player to the next room.
    @GetMapping("/continue")
    public String updateRoom(){
        currentRoom++;
        Room room = rooms.get(currentRoom);
        return getInfo()+" "+room.getDescription()+"\n" + room.getChoices()+"\n" + room.getInstructions();
    }

    // Lets player leave the quest
    @GetMapping("/goback")
    public String escape(){
        return "You turn back and keep moving deeper into the forest. The forest never ends and you forget yourself.";
    }

    //lets player choose what item they wan to use to get the door open
    @PostMapping("use-on-door")
    public String chooseItem(@RequestParam String player_item){
        if(Arrays.asList(player1.getItems()).contains(player_item)){
            if(player_item.equals("sword")){
                return "You hit it with sword but nothing happens.";
            }
            if(player_item.equals("shield")){
                return "You have trained your body to it’s limits. A wooden door is no match to you. You brake the lock by bashing it with your shield. \n You can continue by typing localhost:8080/continue";
            }
            if(player_item.equals("smoke_bomb")){
                return "You fill the tunnel with smoke. Nothing happens";
            }
            if(player_item.equals("dagger")){
                return "You think about using your dagger but deside against it.";
            }
            if(player_item.equals("lockpick")){
                return "This isn’t the first locked door you have dealt with. You take out your lockpick and soon the door is open. \n You can continue by typing localhost:8080/continue";
            }
            if(player_item.equals("fire_sphere_spell")){
                return "It’s cold down here but you draw from from the heat of the distant sun and focus your magic.\n A sphere of fire burns the door down. \n You can continue by typing localhost:8080/continue";
            }
            if(player_item.equals("ice_wall_spell")){
                return "You draw from the cold northern wind and make a wall of ice between you and the door";
            }
            if(player_item.equals("potion_of_liquifying")){
                return "You pour the potion of liquifying on the lock. The lock turns into liquid and forms a small puddle on the ground. The door can now be opened \n You can continue by typing localhost:8080/continue";
            }
            else{
                return "no such item";
            }  
        }
        else{
            return "no such item";
        }
    }

    // Gets the room on the right
    @GetMapping("/right")
    public String rightRoom(){
        currentRoom=6;
        Room room = rooms.get(currentRoom);
        return getInfo()+" "+room.getDescription()+"\n" + room.getChoices()+"\n" + room.getInstructions();
    }
    // Gets the room on the left
    @GetMapping("/left")
    public String leftRoom(){
        currentRoom=5;
        Room room = rooms.get(currentRoom);
        return getInfo()+" "+room.getDescription()+"\n" + room.getChoices()+"\n" + room.getInstructions();
    }
    // Returns player to the previous room
    @GetMapping("/leave_skeleton")
    public String previousRoom(){
        currentRoom=4;
        Room room = rooms.get(currentRoom);
        return getInfo()+" "+room.getDescription()+"\n" + room.getChoices()+"\n" + room.getInstructions();
    }

    //Lets playeer loot the skeleton adding it's loot to the inventory
    @PostMapping("/loot")
    public String lootItem(@RequestParam String loot_item){
        if(loot_item.equals("armor")){
            List<String> itemList = new ArrayList<>(Arrays.asList(player1.getItems()));
            itemList.add(loot_item);
            player1.setItems(itemList.toArray(new String[0]));
            player1.setArmor(50);
            return "You put on the armor. It's heavy but it should protect you. \n You can continue by typing localhost:8080/leave_skeleton";
        }
        if(loot_item.equals("vial")){
            List<String> itemList = new ArrayList<>(Arrays.asList(player1.getItems()));
            itemList.add(loot_item);
            player1.setItems(itemList.toArray(new String[0]));
            return "You take the vial. Maybe it can be helpful in the future. \n You can continue by typing localhost:8080/leave_skeleton";
        }
        else return "no such item";
    }
    //takes player up the ladder
    @GetMapping("/goup")
    public String ladders(){
           
        currentRoom++;
        Room room = rooms.get(currentRoom);
        return getInfo()+" "+room.getDescription()+"\n" + room.getChoices()+"\n" + room.getInstructions();
        
    }
    // Lets player choose what item to use on the enemy
    @PostMapping("/use-on-enemy")
    public String useItem(@RequestParam String item){
        if(Arrays.asList(player1.getItems()).contains(item)){
            if(item.equals("sword")){
                return "You raise your sword and attack the knight. Your blade cuts through the armor. The knight falls to their knees and bleeds out. \n You can continue by typing localhost:8080/chest";
            }
            if(item.equals("shield")){
                return "You block the knights attack with you shield. This leaves them defenseless as you cut off their head with your sword. You have defeated the knight. \n You can continue by typing localhost:8080/chest";
            }
            if(item.equals("smoke_bomb")){
                return "You throw the smoke bomb. The smoke blocks knights vision and you get away. You keep moving deeper into the forest. The forest never ends and you forget yourself. \n You can continue by typing localhost:8080/chest";
            }
            if(item.equals("dagger")){
                return "You know you have to wait for an opening to strike. The knight raises their sword and strikes at you. You manage to dodge the attack and see your opening. \n You drive your dagger through an opening in the helmet’s visor. The knight collapses on the ground. You have defeated the knight. \n You can continue by typing localhost:8080/chest";
            }
            if(item.equals("fire_sphere_spell")){
                return "You draw from the heat of the distant sun and focus your magic. A sphere of fire hurls towards the knight coating them in flames. You have defeated the knight. \n You can continue by typing localhost:8080/chest";
            }
            if(item.equals("ice_wall_spell")){
                return "You draw from the cold northern wind and make a wall of ice between you and the knight.";
            }
            if(item.equals("potion_of_liquifying")){
                return "You throw the potion of liquifying at the knight. They scream as they become a puddle. You have defeated the knight. \n You can continue by typing localhost:8080/chest";
            }
            else{
                return "no such item or item not useful";
            }  
        }
        else{
            return "no such item";
        }
    }
    // Lets player do nothing against the knight
    @GetMapping("/donothing")
    public String enemyAttack(){
        return "The knight’s dark blade cuts your flesh easily. You die almost instantly.";
    }
    // Gives player a description of loot inside the chest. This changes depending of character class
    @GetMapping("/chest")
        public String conclusion(){
            return player1.getConclusion();
        }
    
}

    


    

    
