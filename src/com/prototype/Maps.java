package com.prototype;

import java.util.*;

public class Maps {
    private int isComplete;
    private String name;
    private int questID;
    private Scanner input = new Scanner(System.in);
    private Scanner input2 = new Scanner(System.in);
    private Player player1 = new Player("", 100, 5, 40, true, 0,0, 0,3);
    private List<String> inv = new ArrayList<String>();
    public String choice;

    //default items set so you can't equip null
    public String[] equippedItems = new String[2];

    public String[] wepName = {"pointy stick", "Bronze sword", "Steel Sword", "Dragon Sword"};
    public String[] armName = {"Tattered Clothes", "Bronze Platebody", "Steel Platebody, Dragon Platebody"};
    public int[] itemStat = {0, 10, 20, 30};


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
        line();
        System.out.println("currently equipped items:");
        System.out.println(Arrays.toString(equippedItems));
        line();
        System.out.println("what do you want to equip?");
        System.out.println(inv);
        System.out.println("\tExit");
        choice = input.nextLine();
        int isEquipped = 2;

        //ifs are used here instead of a switch because it checks for 2 Strings. the while loop is used here so that the menu returns to the previous menu on return.

        while (isEquipped == 2) {
            if (choice.equalsIgnoreCase(wepName[0]) && inv.contains(wepName[0])) {
                line();
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(itemStat[0]);  //sets weapon damage
                inv.add(equippedItems[0]); //adds current item to inventory
                equippedItems[0] = (wepName[0]); //replaces equipped item 0 index
                inv.remove(wepName[0]); //removes item from inventory
                isEquipped = 0;

            } else if (choice.equalsIgnoreCase(wepName[1]) && inv.contains(wepName[1])) {
                line();
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(itemStat[1]);
                inv.add(equippedItems[0]);
                equippedItems[0] = wepName[1];
                inv.remove(wepName[1]);
                isEquipped = 0;

            } else if (choice.equalsIgnoreCase(wepName[2]) && inv.contains(wepName[2])) {
                line();
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(itemStat[2]);
                inv.add(equippedItems[0]);
                equippedItems[0] = wepName[2];
                inv.remove(wepName[2]);
                isEquipped = 0;

            } else if (choice.equalsIgnoreCase(wepName[3]) && inv.contains(wepName[3])) {
                line();
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(itemStat[3]);
                inv.add(equippedItems[0]);
                inv.remove(wepName[3]);
                isEquipped = 0;

            } else if (choice.equalsIgnoreCase(wepName[4]) && inv.contains(wepName[4])) {
                line();
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(itemStat[4]);
                inv.add(equippedItems[0]);
                equippedItems[0] = wepName[4];
                inv.remove(wepName[4]);
                isEquipped = 0;

            } else if (choice.equalsIgnoreCase(armName[0]) && inv.contains(armName[0])) {
                line();
                System.out.println("Equipped successfully");
                player1.setDefence(itemStat[0]);
                inv.add(equippedItems[1]);
                equippedItems[1] = armName[0];
                inv.remove(armName[0]);
                isEquipped = 1;

            } else if (choice.equalsIgnoreCase(armName[1]) && inv.contains(armName[1])) {
                line();
                System.out.println("Equipped successfully");
                player1.setDefence(itemStat[1]);
                inv.add(equippedItems[1]);
                equippedItems[1] = armName[1];
                inv.remove(armName[1]);
                isEquipped = 1;

            } else if (choice.equalsIgnoreCase(armName[2]) && inv.contains(armName[2])) {
                line();
                System.out.println("Equipped successfully");
                player1.setDefence(itemStat[2]);
                inv.add(equippedItems[1]);
                equippedItems[1] = armName[2];
                inv.remove(armName[2]);
                isEquipped = 1;

            } else if (choice.equalsIgnoreCase(armName[3]) && inv.contains(armName[3])) {
                line();
                System.out.println("Equipped successfully");
                player1.setDefence(itemStat[3]);
                inv.add(equippedItems[1]);
                equippedItems[1] = armName[3];
                inv.remove(armName[3]);
                isEquipped = 1;

            } else if (choice.equalsIgnoreCase(armName[4]) && inv.contains(armName[4])) {
                line();
                System.out.println("Equipped successfully");
                player1.setDefence(itemStat[4]);
                inv.add(equippedItems[1]);
                equippedItems[1] = armName[4];
                inv.remove(armName[4]);
                isEquipped = 1;

            } else if (choice.equalsIgnoreCase("exit")) {
                break;
            } else {
                line();
                System.out.println("Invalid input try again");
                equipItem();
            }
        }

            while (isEquipped ==0){
                System.out.println("Your current damage is: "+ (player1.getDamage()+player1.getWeaponDmg()));
                equipItem();
        }
            while (isEquipped == 1){
                System.out.println("Your current defence is: "+ player1.getDefence());
                equipItem();
            }

            return getComplete();
    }



    public void mapDirection(String north, String east, String south, String west) {


        //designed to stop replicated code, you can set the parameter depending on which directions you want to go
        line();
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
        System.out.println("Or access");
        System.out.println("\tInventory");
        System.out.println("\tMenu");

    }


    private int mapA3() { //starting square
        star();
        System.out.println("Shipwreck Debris");

        while (getComplete() == 1) {
            line();
            System.out.println("You see the remnants of your ship, spread out \non the coast. You should search the area");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("search")) {
                System.out.println("while searching the area, a slime sneaks upon you!");
                Player slime = new Player("slime", 20, 10, 10, true, 0, 0, 0, 0);
                player1.fight(player1, slime);
                if (slime.isAlive) {
                    line();
                    System.out.println("You limp back to safety");
                    mapA4();
                } else if (!slime.isAlive()) {
                    System.out.println("Now that the slime is dead, you search the area again.");
                    System.out.println("After awhile you found what you were looking for, your " + wepName[1] + " and ");
                    inv.add(wepName[1]);
                    inv.add(wepName[2]);
                    setComplete(2);
                }else{
                    System.out.println("it'll be better to search the area.");
                }
            }
        }
//so that it doesnt repeat above sequence
        while (getComplete() >= 2) {
            System.out.println("The slimes body is still there RIP");
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
                line();
                System.out.println("Please try again");
            } //validation check

        }
        return getComplete();
    }
    public int mapA4() {
        setQuestID(1);
        star();
        System.out.println("Shipwreck Cove");

        //loop used for unique scenario on first entry.
        while (getComplete() == 0) {
            line();

            System.out.println("you awaken, poked by a strangers walking stick.");
            System.out.println("your body aches all over, finally opening your eyes the man says");
            convo("Strange Stranger", "Hey friend, you alright? do you remember your name?");
            System.out.println("As you finally awaken enough you remember its:");
            player1.setName(input.nextLine());
            convo("strange stranger", "well, " + player1.getName() + " you're very lucky that your alive. \nSo where did you come from?");
            convo("you", "I come from a land down under, where women glow and men plunder");
            convo("strange stranger", "I see you're a man of culture, I too like to plunder. " +
                    "\nA part of your ship is up north, you should go check it. Well be seeing you!");
            System.out.println("As the strange man leaves, you decide its best to get going");
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
                line();
                System.out.println("Please try again");
            }
        }


        return getComplete();
    }
    public int mapB3() {
        star();
        System.out.println("Forest Entrance");

        while(getComplete() == 2) {
            System.out.println("After walking for while, you reach the start of a forest.\nIn the distance you see a man farming, as you get closer he notices you" +
                    "and says: ");
            convo("Master Farmer", "Oi, don't you go and steal my special herbs! Its critical for the survival of this isle you know!");
            convo("You", "I wasn't trying to steal your herbs! I'm not even 38 thieving!");
            pause();
            convo("Master Farmer", "Well, well, what brings you here then?");
            convo("You", "Ive just awoken, My ship broke as i was escaping from Karamja \n" +
                    "I'm not sure if my family are still alive, Do you think you can help me\n");
            pause();
            convo("Master Farmer", "There's a port town not far from here, I can take you there.\n you'll find some ships, you might get lucky");
            convo("you", "Really? That'll be great!");
            pause();
            System.out.println("After a short journey, you arrive at the docks of the Port town!");
            setComplete(3);
            //map here
        }


        return getComplete();

    }

    public int mapE4(){
        star();
        System.out.println("Port Town Market");
            while(getComplete() == 5){
                System.out.println("You arrive at the Port Town market and");
                convo("Trustworthy Merchant", "Hello there!, Welcome to the Port Town General Store!\n" +
                        "How may I be of assistance?");

            }
        return getComplete();
    }

            public void devMenu() {

        int lop = 0;
        int x;

        while (lop == 0) {
            line();
            System.out.println("Dev menu entered");
            choice = input.nextLine();

            try {

                if (choice.equalsIgnoreCase("::mapA3")) { //teleport to square, you will be able to teleport to any tile, used for testing.
                    mapA3();

                }else if(choice.equalsIgnoreCase("::mapB3")){
                    mapB3();

                } else if (choice.equalsIgnoreCase("::mapA4")) {
                    mapA4();
                    //add maps here
                } else if (choice.equalsIgnoreCase("::setCom")) { //set stage of map square, useful for testing
                    System.out.println("set complete to?");
                    x = input2.nextInt();
                    setComplete(x);
                } else if (choice.equalsIgnoreCase("::setDmg")) { //change damage of player
                    System.out.println("set damage to?");
                    x = input2.nextInt();
                    player1.setDamage(x);
                } else if (choice.equalsIgnoreCase("::setWDmg")) { //change weapon damage of player
                    System.out.println("set weapon damage to?");
                    x = input2.nextInt();
                    player1.setWeaponDmg(x);
                } else if (choice.equalsIgnoreCase("::setHp")) { //to change health of player
                    System.out.println("set health to?");
                    x = input2.nextInt();
                    player1.setHealth(x);
                } else if (choice.equalsIgnoreCase("::setDef")) { //changes player defence
                    System.out.println("set defence to?");
                    x = input2.nextInt();
                    player1.setDefence(x);
                } else if (choice.equalsIgnoreCase("::setQId")) { //changes questID, useful for testing
                    System.out.println("set questID to?");
                    x = input2.nextInt();
                    setQuestID(x);
                } else if (choice.equalsIgnoreCase("::resetInv")) { //resets inventory and sets equipped to default gear
                    inv.clear();
                    equippedItems[0] = wepName[0];
                    equippedItems[1] = armName[0];
                } else if (choice.equalsIgnoreCase("::exit")) {
                    lop = 1;
                } else {
                    System.out.println("nice try cheater");
                }

            } catch (InputMismatchException e) {
                System.out.println("wrong input, try again");
                input2.next();

            }
            //return getComplete();
        }




        }

            public void convo(String npc, String text){

            System.out.println();
            line();
            System.out.print(npc + ": ");
            System.out.println("\"" + text + "\"");}
            
            public void line(){
                for (int i = 0; i <40; i++){
                    System.out.print("-");}
                System.out.println();
            }
            public void star(){
                for (int i = 0; i <40; i++){
                    System.out.print("*");}
                System.out.println();
            
    }
            public void pause(){
        System.out.print("enter to continue...");
        input.nextLine();
    }


}


