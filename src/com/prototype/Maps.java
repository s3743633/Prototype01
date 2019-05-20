package com.prototype;

import java.util.*;

public class Maps {
    private int isComplete;
    private String name;
    private int questID;
    private Scanner input = new Scanner(System.in);
    private Player player1 = new Player("", 80, 5, 100, true, 0,0);
    private List<String> inv = new ArrayList<String>();
    public String choice;

    //default items set so you can't equip null
    public String[] equippeditems = {"pointy stick", "tattered robes"};

    public String[] weapname = {"wooden sword", "metal sword", "bronze sword"};
    public int[] weapdmg = {10, 20, 30};



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
        System.out.println(Arrays.toString(equippeditems));
        System.out.println("Exit");
        choice = input.nextLine();
        int isEquipped = 1;

        //ifs are used here instead of a switch because it checks for 2 Strings. the while loop is used here so that the menu returns to the previous menu on return.

        while (isEquipped == 1) {
            if (choice.equalsIgnoreCase(weapname[0]) && inv.contains(weapname[0])) {
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(weapdmg[0]);
                inv.add(equippeditems[0]);
                equippeditems[0] = (weapname[0]);
                inv.remove(weapname[0]);
                isEquipped = 2;
                equipItem();

            } else if (choice.equalsIgnoreCase("Dragon Longsword") && inv.contains("dragon longsword")) {
                System.out.println("Equipped successfully");
                player1.setWeaponDmg(20);
                inv.add(equippeditems[0]);
                equippeditems[0] = ("dragon longsword");
                inv.remove("dragon longsword");
                isEquipped = 2;
                equipItem();

            } else if (choice.equalsIgnoreCase("rune plate") && inv.contains("rune plate")) {
                player1.setDefence(100);
                System.out.println("Equipped successfully");
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


    private int mapA3() {

        System.out.println("Shipwreck Debris");

        while (getComplete() == 1) {
            System.out.println("As you explore the area, you are attacked by a shiny blue slime!");
            Player slime = new Player("slime", 20, 0, 5, true, 0, 0);
            player1.fight(player1, slime);
            System.out.println("you found an "+ weapname[0]);
            inv.add(weapname[0]);
            inv.add("dragon longsword");
            setComplete(2);
        }

        while (getComplete() >= 2) {
            mapDirection("", "east", "south", "");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("east")) {
                mapB3();

            } else if (choice.equalsIgnoreCase("south")) {
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

        while (getComplete() == 0) {
            System.out.println("Shipwreck Cove");
            System.out.println("you awaken, poked by a strangers walking stick.");
            System.out.println("your body aches all over, finally opening your eyes the man says");
            System.out.println("\"You're lucky to be alive friend! Do you remember who you are?\"");
            System.out.println("You can't quite remember your name but you tell the man its: ");
            player1.setName(input.nextLine());
            System.out.println(player1.getName() + " is it? Well its good that you don't have amnesia!");
            inv.add("rune plate");
            setComplete(1);


        }

        while(getComplete() >= 1) {
            mapDirection("north", "", "", "");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("north") || (choice.equalsIgnoreCase("n") || (choice.equalsIgnoreCase("go north")))) {
                mapA3();
            } else if (choice.equalsIgnoreCase("Menu")) {
                player1.menu(player1);
            } else if (choice.equalsIgnoreCase("Inventory")) {
                equipItem();
            }else {
                System.out.println("Please try again");
            }
        }


        return getComplete();
    }
    public int mapB3() {

        return getComplete();
    }


}
