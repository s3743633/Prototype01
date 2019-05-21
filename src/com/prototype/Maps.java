package com.prototype;

import java.util.*;

public class Maps {
    private int isComplete;
    private String name;
    private int questID;
    private Scanner input = new Scanner(System.in);
    private Player player1 = new Player("", 100, 5, 10, true, 0,0, 0,3);
    private List<String> inv = new ArrayList<String>();
    public String choice;

    //default items set so you can't equip null
    public String[] equippedItems = new String[2];

    public String[] wepName = {"pointy stick", "Bronze sword", "Steel Sword", "Dragon Sword"};
    public String[] armName = {"Tattered Clothes", "Bronze Platebody", "Steel Platebody, Dragon Platebody"};
    public int[] itemStat = {0,10, 20, 30};


    public Maps(int isComplete, String name, int questID) {
        this.isComplete = isComplete;
        this.name = name;
        this.questID = questID;
    }

    public void setComplete(int isComplete) {
        this.isComplete = isComplete;
    }

    public void setQuestID(int questID) {
        this.questID = questID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComplete() {
        return isComplete;
    }

    public int getQuestID() {
        return questID;
    }

    public String setName() {
        return name;
    }

    public int equipItem() {
        System.out.println("what do you want to equip?");
        System.out.println(inv);
        System.out.println("currently equipped items:");
        System.out.println(Arrays.toString(equippedItems));
        System.out.println("Exit");
        choice = input.nextLine();
        int isEquipped = 1;

        //ifs are used here instead of a switch because it checks for 2 Strings. the while loop is used here so that the menu returns to the previous menu on return.

        while (isEquipped == 1) {
            if (choice.equalsIgnoreCase(wepName[1]) && inv.contains(wepName[1])) {
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(itemStat[1]);  //sets weapon damage
                inv.add(equippedItems[0]); //adds current item to inventory
                equippedItems[0] = (wepName[1]); //replaces equipped item 0 index
                inv.remove(wepName[1]); //removes item from inventory
                isEquipped = 2;
                equipItem();

            } else if (choice.equalsIgnoreCase(wepName[2]) && inv.contains(wepName[2])) {
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(itemStat[2]);
                inv.add(equippedItems[0]);
                equippedItems[0] = wepName[2];
                inv.remove(wepName[2]);
                isEquipped = 2;
                equipItem();

            } else if (choice.equalsIgnoreCase(wepName[3]) && inv.contains(wepName[3])) {
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(itemStat[3]);
                inv.add(equippedItems[0]);
                inv.remove(wepName[3]);
                isEquipped = 2;
                equipItem();

            } else if (choice.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid input try again");
                isEquipped = 2;
                equipItem();
            }
        }
            return getComplete();
    }



    public void mapDirection(String north, String east, String south, String west) {


        //designed to stop replicated code, you can set the parameter depending on which directions you want to go

        System.out.println("where do you want to go?");
        if (north.equalsIgnoreCase("north")) {
            System.out.println("\tGo North (n)");
        }
        if (west.equalsIgnoreCase("west")) {
            System.out.println("\tGo West (w)");

        }
        if (east.equalsIgnoreCase("east")) {
            System.out.println("\tGo East (e)");

        }
        if (south.equalsIgnoreCase("south")) {
            System.out.println("\tGo South (s)");

        }

        System.out.println("\tInventory");
        System.out.println("\tMenu");
    }


    private int mapA3() { //starting square

        System.out.println("Shipwreck Debris");

        while (getComplete() == 1) {
            System.out.println("As you explore the area, you are attacked by a shiny blue slime!");
            Player slime = new Player("slime", 20, 10, 100, true, 0, 0, 0, 0);
            player1.fight(player1, slime);
            if(slime.isAlive) {
                System.out.println("you limp back to safety");
            mapA4();
            }
            else if (!slime.isAlive()){
                System.out.println("you found an " + wepName[1]);
                inv.add(wepName[1]);
                inv.add(wepName[2]);
                setComplete(2);
            }
        }

//so that it doesnt repeat above sequence
        while (getComplete() >= 2) {
            mapDirection("", "east", "south", "");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("east") || choice.equalsIgnoreCase("go east") || choice.equalsIgnoreCase("e")) {
                mapB3();

            } else if (choice.equalsIgnoreCase("south") || choice.equalsIgnoreCase("go south") || choice.equalsIgnoreCase("s")) {
                mapA4();

            } else if (choice.equalsIgnoreCase("Menu")) {
                player1.menu(player1);
            } else if (choice.equalsIgnoreCase("Inventory")) {
                equipItem();
            } else {
                System.out.println("Please try again");
            } //validation check

        }
        return getComplete();
    }
    public int mapA4() {
        setQuestID(1);
        System.out.println("Shipwreck Cove");

        //loop used for unique scenario on first entry.
        while (getComplete() == 0) {

            System.out.println("you awaken, poked by a strangers walking stick.");
            System.out.println("your body aches all over, finally opening your eyes the man says");
            System.out.println("\"You're lucky to be alive friend! Do you remember who you are?\"");
            System.out.println("You can't quite remember your name but you tell the man its: ");
            player1.setName(input.nextLine());
            System.out.println(player1.getName() + " is it? Well its good that you don't have amnesia!");
            equippedItems[0] = wepName[0];
            equippedItems[1] = armName[0];
            setComplete(1);


        }
        //map tile will go here afterwards on entry.
        while(getComplete() >= 1) {
            mapDirection("north", "", "", "");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("north") || (choice.equalsIgnoreCase("n") || (choice.equalsIgnoreCase("go north")))) {
                mapA3();
            } else if (choice.equalsIgnoreCase("Menu")) {
                player1.menu(player1);
            } else if (choice.equalsIgnoreCase("Inventory")) {
                equipItem();
            }else if(choice.equalsIgnoreCase("::dev")){
                devMenu();
            }else {
                System.out.println("Please try again");
            }
        }


        return getComplete();
    }
    public int mapB3() {

        return getComplete();

    }

    public int devMenu(){

            int x;
            System.out.println("Dev menu entered");


            choice=input.nextLine();
            if(choice.equalsIgnoreCase("::mapA3")){ //teleport to square, you will be able to teleport to any tile, used for testing.
                mapA3();
            }else if(choice.equalsIgnoreCase("::mapA4")){
                mapA4();
            //add maps here
            }else if (choice.equalsIgnoreCase("::setCom")){ //set stage of map square, useful for testing
                System.out.println("set complete to?");
                x=input.nextInt();
                setComplete(x);
            }else if(choice.equalsIgnoreCase("::setDmg")){ //change damage of player
                System.out.println("set damage to?");
                x=input.nextInt();
                player1.setDamage(x);
            }else if(choice.equalsIgnoreCase("::setWDmg")){ //change weapon damage of player
                System.out.println("set weapon damage to?");
                x=input.nextInt();
                player1.setWeaponDmg(x);
            }else if(choice.equalsIgnoreCase("::setHp")){ //to change health of player
                System.out.println("set health to?");
                x=input.nextInt();
                player1.setHealth(x);
            }else if(choice.equalsIgnoreCase("::setDef")){ //changes player defence
                System.out.println("set defence to?");
                x=input.nextInt();
                player1.setDefence(x);
            }else if(choice.equalsIgnoreCase("::setQId")){ //changes questID, useful for testing
                System.out.println("set questID to?");
                x=input.nextInt();
                setQuestID(x);
            }else if(choice.equalsIgnoreCase("::resetInv")){ //resets inventory and sets equipped to default gear
                inv.clear();
                equippedItems[0] = wepName[0];
                equippedItems[1] = armName[0];
            }else{
                System.out.println("nice try cheater");
                devMenu();
            }
            return getComplete();
        }


        public static void back(){

        }
    }


