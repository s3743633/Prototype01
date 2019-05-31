package com.prototype;

import java.util.*;

public class Maps {
    private int isComplete;
    private String name;
    private int questID;
    private Scanner input = new Scanner(System.in);
    private Scanner input2 = new Scanner(System.in);
    private Player player1 = new Player("", 100, 5, 40, true, 0, 0, 0, 3);
    private List<String> inv = new ArrayList<String>();
    public String choice;

    //default items set so you can't equip null
    public String[] equippedItems = new String[2];


    public String[] wepName = {"pointy stick", "Fathers Sword", "Steel Sword", "Dragon Sword", "Godsword", ""};
    public String[] armName = {"Tattered Clothes", "Fathers Tunic", "Steel Platebody", "Dragon Platebody", "Daedric Platebody", ""};
    public int[] itemStat = {0, 10, 20, 30, 100};


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



    public void equipItem() {
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
                inv.remove(armName[4]);
                equippedItems[1] = armName[4];
                isEquipped = 1;

            } else if (choice.equalsIgnoreCase("exit")) {
                break;
            } else {
                line();
                System.out.println("Invalid input try again");
                equipItem();
            }

        }

        if (isEquipped == 0) {
            System.out.println("Your current damage is: " + (player1.getDamage() + player1.getWeaponDmg()));
            equipItem();
        }else if(isEquipped == 1) {
            System.out.println("Your current defence is: " + player1.getDefence());
            equipItem();
        }
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
                    System.out.println("After awhile you found what you were looking for, your " + wepName[1] + " and " + armName[1]);
                    System.out.println("Go to inventory to equip the new gear");
                    pause();
                    inv.add(wepName[1]);
                    inv.add(armName[1]);
                    setComplete(2);
                } else {
                    System.out.println("it'll be better to search the area.");
                }
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

            } else menu();


        }
        return getComplete();
    }

    public int mapA4() {
        setQuestID(0);
        star();
        System.out.println("Shipwreck Cove");

        //loop used for unique scenario on first entry.
        while (getComplete() == 0) {
            line();

            System.out.println("you awaken, poked by a strangers walking stick.");
            System.out.println("your body aches all over, finally opening your eyes the man says");
            convo("Strange Stranger", "Hey friend, you alright? do you remember your name?");
            pause();
            System.out.println("As you finally awaken enough you remember its:");
            player1.setName(input.nextLine());
            convo("strange stranger", "well, " + player1.getName() + " you're very lucky that your alive. \nSo where did you come from?");
            convo("you", "I come from a land down under, where women glow and men plunder");
            pause();
            convo("strange stranger", "I see you're a man of culture, I too like to plunder. " +
                    "\nA part of your ship is up north, you should go check it. Well be seeing you!");
            pause();
            System.out.println("As the strange man leaves, you decide its best to get going");
            pause();
            equippedItems[0] = wepName[0];
            equippedItems[1] = armName[0];
            setComplete(1);


        }



        if(getComplete() >= 16 && inv.contains("Shovel")){
            System.out.println("Congrats, you found a secret!");
            System.out.println("There's another spot here for you to dig!");
            System.out.println("do you want to dig there?");
            choice = input.nextLine();
            if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
                System.out.println("You find a golden treasure chest!");
                System.out.println("Your shovel breaks as you smash it open with it");
                System.out.println("you find a " + armName[4] +"and a " +  wepName[4] +"!!!");
                inv.remove("Shovel");
                inv.add(armName[4]);
                inv.add(wepName[4]);
            }else{
                System.out.println("No thanks, I dont want Game breaking items");
                inv.remove("Shovel");
            }


        }



        //map tile will go here afterwards on entry.
        while (getComplete() >= 1) {
            mapDirection("north", "", "", "");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("north") || (choice.equalsIgnoreCase("n") || (choice.equalsIgnoreCase("go north")))) {
                mapA3();
            } else {
                menu();
            }


        }

        return getComplete();
    }

    public int mapB3() {
        star();
        System.out.println("Forest Entrance");

        while (getComplete() == 2) {
            System.out.println("After walking for while, you reach the start of a forest.\nIn the distance you see a man farming, as you get closer he notices you" +
                    " and says: ");
            convo("Master Farmer", "Oi, don't you go and steal my special herbs! Its critical for the survival of this isle you know!");
            convo("You", "I wasn't trying to steal your herbs! I'm not even 38 thieving!");
            pause();
            convo("Master Farmer", "Well, well, what brings you here then?");
            convo("You", "Ive just awoken, My ship broke as I was escaping from Karamja \n" +
                    "I'm not sure if my family are still alive, Do you think you can help me?");
            pause();
            convo("Master Farmer", "There's a port town not far from here, I can take you there.\n you'll find some ships, you might get lucky");
            convo("you", "Really? That'll be great!");
            pause();
            System.out.println("After a short journey, you arrive at the docks of the Port town!");
            setComplete(3);
            mapE3();
        }

        while (getComplete() > 3) {
            mapDirection("", "east", "", "west");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("east") || (choice.equalsIgnoreCase("e") || (choice.equalsIgnoreCase("go east")))) {
                mapC3();
            } else if (choice.equalsIgnoreCase("west") || choice.equalsIgnoreCase("w") || (choice.equalsIgnoreCase("go west"))) {
                mapA3();
            }
            menu();


        }
        return getComplete();
    }

    public int mapE3() {

        while (getComplete() == 3) {
            System.out.println("As you arrive at the docks, there is only 1 large ship remaining. ");
            System.out.println("The crew are busy readying the ship, you walk towards it, so you can talk to someone in charge.");
            convo("You", "OOIIII!!!");
            System.out.println("After yelling for someones attention, you finally get a response.");
            pause();
            convo("Crew Member", "Ay matey what thee bloody hell do you want?");
            convo("You", "Tell me, can I board this ship?");
            pause();
            convo("Crew Member", "Cant help you but, wait here I'll go get the cap'.");
            pause();
            System.out.println("you are still waiting...");
            pause();
            System.out.println("After waiting for what seems like forever, the captain of the ship finally approaches you.");
            convo("Captain Bob", "So you want to board this ship? I can let you, but it depends on where you're going.");
            convo("You", "I need to go back to the isles to the west can you take me?");
            pause();
            convo("Captain Bob", "You're in luck then, but I can't set sail til the lighthouse is back on \n its to south of here, if you do that then ill let you board.");
            convo("You", "Sure, I can try but i dont have anything that'll start a fire.");
            pause();
            convo("Captain Bob", "Ask the merchant he might be able to help you, good luck!");
            System.out.println("You must reach the lighthouse to the south, so that you can get back home.");
            pause();
            setComplete(4);
            setQuestID(1);
        }


        while (getComplete() == 11) {
            System.out.println("You arrive back to the docks, as you walk towards the ship \nyou notice that all the crew members are flustered and panicking.");
            System.out.println("The Captain, with an frustrated expression \nspots you walking towards the ship.");
            pause();
            convo("Captain Bob", "I see the lighthouse is back on. \nSorry for uh..not telling you about the spider. I knew you'll be ok honestly.");
            convo("You", "Thanks for warning me, no wonder no one wanted to do it. When do we set sail?");
            pause();
            convo("Captain Bob", "Well I would love to set sail but you see..\n");
            pause();
            convo("Captain Bob", "The Co-Captain has been missing since this mornin'. \nWe don't have enough spare man power to search, could you look for the Co-Captain?");
            convo("You", "...Fine. As long as there are no gigantic spiders this time. \nDo you know where to start looking?");
            pause();
            convo("Captain Bob", "Don't worry there's no spiders this time...\nThere was a bunch of rowdy men in town yesterday they came from the north");
            convo("You", "Well better then nothing, I'll head north");
            convo("Captain Bob", "Best of luck to you.");
            pause();
            System.out.println("You head back towards the entrance of the docks");
            setComplete(12);
            setQuestID(3);
        }

        while(getComplete() == 24 && getQuestID() == 10){
            System.out.println("");


        }



        while (getComplete() >= 4) {
            System.out.println("Port Town Docks");

            mapDirection("", "", "south", "");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("south") || (choice.equalsIgnoreCase("s") || (choice.equalsIgnoreCase("go south")))) {
                mapE4();
            } else {
                menu();

            }

        }

        return getComplete();
    }


    public int mapE4() {
        star();
        System.out.println("Port Town Market");
        while (getComplete() == 4 && getQuestID() == 1) {
            System.out.println("You arrive at the Port Town market and" +
                    "enter the General Store");
            convo("Trustworthy Merchant", "Hello there!, Welcome to the Port Town General Store!\n" +
                    "How may I be of assistance?");
            convo("You", "Hi! I would like to purchase some flint and steel.");
            pause();
            convo("Trustworthy Merchant", "Sure thing! That'll be 10gp");
            setQuestID(2);
        }
        while (getComplete() == 4 && getQuestID() == 2) {
            line();
            System.out.println("Would you like to buy some flint and steel?\n\tYes\n\tNo");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("Yes")) {
                player1.setgp(Math.max(0, player1.getgp() - 10));
                System.out.println("You now have " + player1.getgp() + "gp left!");
                setComplete(5);
            } else if (choice.equalsIgnoreCase("No")) {
                System.out.println("It's probably a good idea to buy some flint and steel or I wouldn't" +
                        "\n be able to light the lighthouse");
            } else {
                System.out.println("Invalid input, please try again.");

            }
        }

        while (getComplete() >= 16 && questID == 5) {
            System.out.println("You enter the portshop and speak to the merchant");
            convo("Merchant", "ohh its our saviour!, I heard about you from my son");
            pause();
            convo("You", "wow news sure travels fast here! \nYour daughter said you might be able to help with those bandits?");
            convo("Merchant", "For you sure! Here take this shovel, Go back to where my daughter was \nI buried a cache there, from when i was an adventure like you!");
            pause();
            convo("You", "Thanks, it'll come in handy!");
            convo("Merchant", "I hope it serves you well");
            pause();
            inv.add("Shovel");
            setQuestID(6);
        }

        while (getComplete() >= 5) {
            mapDirection("north", "", "", "west");
            System.out.println("\tPort Shop");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("west") || (choice.equalsIgnoreCase("w") || (choice.equalsIgnoreCase("go west")))) {
                mapD4();
            } else if (choice.equalsIgnoreCase("north") || (choice.equalsIgnoreCase("n") || (choice.equalsIgnoreCase("go north")))) {
                mapE3();
            } else if (choice.equalsIgnoreCase("port shop")) {
                player1.portShop(player1);
            } else {
                menu();
            }

        }
        return getComplete();
    }

    public int mapD4() {


        while (getComplete() == 5) {
            System.out.println("you leave the town, and find yourself on a dirt road.");
            mapDirection("", "east", "south", "west");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("west") || choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("go west")) {
                System.out.println("A farmer is relocating their cattle, it will take awhile before you can go that way");
            } else if (choice.equalsIgnoreCase("east") || choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("go east")) {
                mapE4();
            } else if (choice.equalsIgnoreCase("south") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("go south")) {
                setComplete(6);
            }

            while (getComplete() == 6) {

                System.out.println("There is a large wolf blocking the way, it notices you before you even realise.");
                Player wolf = new Player("Wolf", 50, 5, 15, true, 0, 5, 0, 0);
                player1.fight(player1, wolf);

                if (wolf.isAlive) {
                    line();
                    System.out.println("You limp back to the market place");
                    mapE4();
                } else if (!wolf.isAlive()) {
                    System.out.println("Now that the wolf is out of the way, you can continue to the lighthouse");
                    pause();
                    setComplete(7);
                    mapD5();
                } else {
                    System.out.println("invalid input");
                }
            }
        }


        while (getComplete() == 7) {
            mapDirection("", "east", "south", "west");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("east") || choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("go east")) {
                mapE4();
            } else if (choice.equalsIgnoreCase("west") || choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("go west")) {
                System.out.println("The cattle are still in the way");
            } else if (choice.equalsIgnoreCase("south") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("go south")) {
                mapD5();
            } else {
                menu();
            }
        }

        while (getComplete() >= 8) {
            mapDirection("", "east", "south", "west");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("east") || choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("go east")) {
                mapE4();
            } else if (choice.equalsIgnoreCase("west") || choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("go west")) {
                mapC4();
            } else if (choice.equalsIgnoreCase("south") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("go south")) {
                mapD5();
            } else {
                menu();
            }
        }
        return getComplete();
    }


    public int mapD5() {
        System.out.println("Lighthouse road");
        System.out.println("There is only a road leading east towards the lighthouse");

        mapDirection("north", "east", "", "");

        choice = input.nextLine();
        if (choice.equalsIgnoreCase("north") || choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("go north")) {
            mapD4();
        } else if (choice.equalsIgnoreCase("east") || choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("go east")) {
            mapE5();
        } else {
            menu();
        }

        return getComplete();
    }


    public int mapE5() {

        while (getComplete() == 7) {

            System.out.println("You've finally reached the lighthouse");
            pause();
            System.out.println("you walk up to the lighthouse, the door is locked");
            System.out.println("do you want to search the area?");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("search") || choice.equalsIgnoreCase("y")) {
                System.out.println("You look under the house mat and luckily you found a key");
                inv.add("Lighthouse key");
                setComplete(8);
            } else {
                System.out.println("invalid input");
            }
        }

        while (getComplete() == 8) {
            System.out.println("do you want to open the lighthouse?");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("open") || choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                setComplete(9);
            } else if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {
                System.out.println("You decided its best to continue on your journey");
                setComplete(9);
            } else {
                System.out.println("invalid input");
            }
        }

        while (getComplete() == 9) {
            Player spider = new Player("Large Spider", 60, 15, 20, true, 0, 5, 0, 0);
            System.out.println("you enter the Lighthouse");
            System.out.println("You start to panic as you notice the area is covered in large cob webs");
            pause();
            System.out.println("After taking a big breath in you steele yourself to continue");
            System.out.println("Do you want to go up the spiral staircase?");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("go up stairs") || choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                System.out.println("you walk up the stairs, your heart rate increases as you notice \n8 large beaded eyes staring at you from the ceiling");
                pause();
                player1.fight(player1, spider);
            }

            if (spider.isAlive) {
                System.out.println("You sneak away while the spider wasn't looking");
                mapD5();
            } else if (!spider.isAlive()) {
                System.out.println("You feel relieved that you never have to experience that again");
                setComplete(10);
            } else {
                System.out.println("invalid input");
            }

        }


        while (getComplete() == 10) {
            System.out.println("Do you want to continue up the stairs?");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("Go up stairs")) {
                System.out.println("You go up the stairs and reach the top of the lighthouse");
                System.out.println("Do you want to light the fire?");
                choice = input.nextLine();
                if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("light the fire") || choice.equalsIgnoreCase("use flint")) {
                    System.out.println("The lighthouse is working again");
                    System.out.println("You head back to the docks");
                    pause();
                    setComplete(11);
                    line();
                    mapE3();
                }

            }

        }

        while (getComplete() >= 11) {
            System.out.println("The Lighthouse");
            mapDirection("", "", "", "west");
            System.out.println("\tenter the lighthouse");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("west") || choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("go west")) {
                mapD5();
            } else if (choice.equalsIgnoreCase("enter the lighthouse") || choice.equalsIgnoreCase("lighthouse")) {
                System.out.println("You try to go inside, but the door is locked shut");
                pause();
            } else {
                menu();
            }
        }
        return getComplete();
    }

    public int mapC4() {

        while (getComplete() == 12) {

            System.out.println("As you walk up the dirt road, a distressed child pleas for your help");
            convo("Child", "Mister please help, m-my sister is being attack by bad people");
            pause();
            convo("You", "That terrible! Where abouts is your sister?");
            convo("Child", "J-just to the north, hurry mister!");
            pause();
            convo("You", "Everything will be ok, go over there and wait, I wont be long trust me!");
            System.out.println("The young child hides behind a large boulder");
            pause();
            System.out.println("You quickly run to the north!");
            setComplete(13);
            mapC3();
        }

        while (getComplete() >= 13) {
            mapDirection("north", "east", "", "");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("north") || choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("go north")) {
                mapC3();
            } else if (choice.equalsIgnoreCase("east") || choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("go east")) {
                mapD4();
            } else {
                menu();
            }

        }
        return getComplete();
    }

    public int mapC3() {

        while (getComplete() == 13) {

            System.out.println("You see the child's sister being harassed by 2 thugs, as you get closer you hear them talk");
            pause();
            convo("Thug 1", "C'mon missy, you havent paid yet..The boss needs the money today");
            convo("Young lady", "Its only been 1 week since we last paid! You said it was monthly!");
            pause();
            convo("Thug 1", "That was then, the deals changed. So pay up!");
            convo("Young lady", "I wont have enough!");
            pause();
            convo("Thug 2", "hehe, you can use something else to pay");
            System.out.println("The second thug starts to unbuckle his belt");
            convo("Young lady", "Don't you think about it, you creep!");
            pause();
            System.out.println("As your blood starts to boil, the thugs have still yet to notice you");
            System.out.println("You sneak upon the second thug and tap him on the shoulder");
            pause();
            convo("Thug 2", "HUHH?! What do you want boy!");
            convo("You", "Be quiet and die silently");
            setComplete(14);
        }

        Player thug2 = new Player("Thug 2", 80, 10, 10, true, 0, 10, 100, 0);
        while (getComplete() == 14) {
            System.out.println("Start a fight?");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                System.out.println("You draw your weapon and a fight starts");
                convo("Thug 2", "I see you want a sword fight");
                player1.fight(player1, thug2);

            } else {
                System.out.println("The thug draws his weapon and a fight starts");
                player1.fight(player1, thug2);
            }

            if (thug2.isAlive) {
                line();
                System.out.println("you limp back to safety");
                mapC4();
            } else if (!thug2.isAlive()) {
                System.out.println("The first thug panics at the sight of his dead comrade");
                pause();
                convo("Thug 1", "You think you won now boy! Wait til boss man hears about you! \nYou're seeking death!!");
                System.out.println("The thug flees to the north");
                setComplete(15);
            } else {
                System.out.println("invalid input");
            }
        }

        while (getComplete() == 15) {
            System.out.println("The young lady looks relieved as the thug runs away \nShe turns to look at you and says");
            convo("Young lady", "Thanks for the help stranger, but you're in great danger now");
            convo("You", "You're welcome miss, but I can take whatever comes at me next");
            pause();
            convo("young lady", "You might need some help then, my father might be able to help\n his the merchant in town.");
            convo("You", "hmmm, i'll probably take you on that offer");
            pause();
            convo("young lady", "You'll do this isle a great service if you get rid of those men.");
            convo("You", "Yeah..your brother is to the south, he was worried about you.");
            pause();
            convo("Young lady", "Thanks, ill go get him. Well be seeing you stranger");
            System.out.println("The lady leaves before you get to ask for her name");
            pause();
            setComplete(16);
            setQuestID(5);
        }


        while (getComplete() == 16 && questID == 6 && inv.contains("Shovel")) {
            System.out.println("Theres a spot marked with an X, do you want to dig here");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                System.out.println("You dig hear a ding as your shovel hits the top of a chest");
                System.out.println("you lift it out of the hole and open it");
                System.out.println("You find a " + armName[3] + " and a " + wepName[3]);
                System.out.println("You should equip them!");
                inv.add(armName[3]);
                inv.add(wepName[3]);
                setQuestID(7);
            } else if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {
                System.out.println("You decided to make fights harder for yourself");
                setQuestID(7);
            } else {
                System.out.println("invalid input");
            }
        }


        while (getComplete() >= 16) {
            System.out.println("The Cross Road");
            mapDirection("north", "", "south", "west");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("north") || choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("go north")) {
                mapC2();
            } else if (choice.equalsIgnoreCase("south") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("go south")) {
                mapC4();
            } else if (choice.equalsIgnoreCase("west") || choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("go west")) {
                mapB3();
            } else {
                menu();
            }

        }

        return getComplete();
    }

    public int mapC2(){
        star();
        System.out.println("Bandit Way");
        while(getComplete() == 16){
            System.out.println("You walk down the narrow dirt path following the footsteps of the the second thug");
            convo("You", "Man, I wonder if I'll be able to find this super secret, hidden bandit hideout");
            pause();
            System.out.println("You notice a sign post that reads \"Beware! Bandit hideout ahead!\"");
            convo("You", "Oh.. Nevermind then");
            pause();
            setComplete(17);

        }
        while(getComplete() >= 17){
            line();
            System.out.println("Continue North to enter the bandit hideout\n Or Go south to go back");
            mapDirection("north", "", "south","");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("north")|| choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("go north")){
                mapC1();
            }else if(choice.equalsIgnoreCase("south") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("go south")){
                mapC3();
            }else{
                menu();
            }
        }

        return getComplete();
    }

    public int mapC1(){
        star();
            System.out.println("Bandit hideout Entrance Room");
            while(getComplete() ==17){
                line();
                System.out.println("You brace yourself as you open the creaky door");
                convo("Thug 1", "Hey! That's the guy I told you about!");
                convo("Higher ranking Thug","This guy? Doesnt look like much. I dont think we should bother the boss man\n for someone" +
                        " like this.");
                pause();
                convo("You", "Look, I dont want to cause any trouble, I'm just here for the co-captain. \n Just let him go and we'll be on" +
                        " our way");
                convo("Higher ranking Thug", "You think you're in a position to be making demands? \n Thug 1! Take care" +
                        " of him");
                pause();
                convo("Thug 1", "For the last time, my name is Tom");
                pause();
                setComplete(18);
            }
            Player thug1 = new Player("Thug 1 (Tom)", 90, 15, 15, true, 0, 10, 100, 0);
            while (getComplete() == 18){
                line();
                System.out.println("The thug grabs the nearest spear and charges towards you");
                System.out.println("You realize that there's no escaping this and prepare for battle");
                    player1.fight(player1, thug1);

                    if(thug1.isAlive){
                    line();
                    System.out.println("you limp back to safety");
                    mapC2();
                }else{

                    convo("Higher ranking Thug", "NOO! How dare you kill Thug 1!");
                    convo("Thug 1(final dying breath)", "I....it...it's... Tom....");
                        System.out.println("Thug 1 collapses");
                    pause();
                    convo("Higher ranking Thug","You'll pay for this!");
                        System.out.println("The thug runs to the next room");
                    convo("You", "Why do they have to be so difficult");
                    setComplete(19);

                }


            }

            while(getComplete()>=19){
                line();
                System.out.println("Go East to enter the next room\nOr go south to go back");
                mapDirection("", "east", "south","");
                choice = input.nextLine();

                if (choice.equalsIgnoreCase("east")|| choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("go east")){
                    mapB1();
                }else if(choice.equalsIgnoreCase("south") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("go south")){
                    mapC2();
                }else{
                    menu();
                }

            }

        return getComplete();
        }

    public int mapB1(){
        star();
        System.out.println("Bandit Hideout Room 1");
        while(getComplete() == 19){
            line();
            System.out.println("You enter the next room slowly.\n The thug from earlier rushes towards you");
            convo("Higher ranking Thug", "SURPRISE ATTACK!!!!!");
            pause();
            System.out.println("You punch him straight in the face\n He collapses instantly.");
            convo("You","Well that was easy");
            pause();
            System.out.println("Another thug approaches you.");
            convo("You", "So, who might you be? Thug 2.1?");
            convo("Thug 3.1", "Actually, it's Thug 3.1");
            pause();
            convo("Thug 3.1", "Prepare yourself.");
            System.out.println("You realize that this won't be an easy fight. \n So you draw your weapon");
            pause();
            setComplete(20);

        }
        Player thug3point1 = new Player("Thug 3.1", 95, 15, 20, true, 0, 10, 100, 0);

        while (getComplete() == 20) {
            line();

            System.out.println("Thug 3.1 Swings his sword at you");
            player1.fight(player1, thug3point1);

            if(thug3point1.isAlive){
                line();
                System.out.println("you limp back to safety");
                mapC1();
            }else{
                System.out.println("Thug 3.1's body lays in a heap");
                convo("You","Guess it's time I wrap this up");
                pause();

                setComplete(21);

            }
        }

        while (getComplete() == 21 && getQuestID() == 6){
            line();
            System.out.println("You notice something shiny in the corner of yor eye");
            convo("You","Ooh, What is this?");
            pause();
            System.out.println("You find a half opened chest, with weapons and armour inside");
            System.out.println("It's a "+armName[2]+ " and a "+wepName[2]+"!");
            pause();
            System.out.println("You grab your new equipment");
            inv.add(armName[2]);
            inv.add(wepName[2]);
            System.out.println("I should probably equip these before the final fight");
            pause();
            setQuestID(7);
        }

        while(getComplete()>=21){
            line();
            System.out.println("Go East to enter the final boss room\nOr go west to go back");
            mapDirection("", "east", "","west");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("east")|| choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("go east")){
                mapA1();
            }else if(choice.equalsIgnoreCase("west") || choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("go west")){
                mapC1();
            }else{
                menu();
            }

        }

        return getComplete();
    }



    public int mapA1(){


        return getComplete();
    }

    public void devMenu() {

        int loop = 0;
        int x;

        while (loop == 0) {
            line();
            System.out.println("Dev menu entered");
            choice = input.nextLine();

            try {

                if (choice.equalsIgnoreCase("::mapA3")) { //teleport to square, you will be able to teleport to any tile, used for testing.
                    mapA3();
                } else if (choice.equalsIgnoreCase("::mapB3")) {
                    mapB3();
                } else if (choice.equalsIgnoreCase("::mapA4")) {
                    mapA4();
                } else if (choice.equalsIgnoreCase("::mapE3")) {
                    mapE3();
                } else if (choice.equalsIgnoreCase("::mapE4")) {
                    mapE4();
                } else if (choice.equalsIgnoreCase("::mapD4")) {
                    mapD4();
                } else if (choice.equalsIgnoreCase("::mapD5")) {
                    mapD5();
                } else if (choice.equalsIgnoreCase("::mapE5")) {
                    mapE5();
                } else if(choice.equalsIgnoreCase("::mapC1")){
                    mapC1();
                } else if(choice.equalsIgnoreCase("::mapA1")){
                    mapA1();
                } else if(choice.equalsIgnoreCase("::mapC2")){
                    mapC2();
                    //add maps here
                }else if (choice.equalsIgnoreCase("::setCom")) { //set stage of map square, useful for testing
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
                    loop = 1;
                } else {
                    System.out.println("nice try cheater");
                }

            } catch (InputMismatchException e) {
                System.out.println("wrong input, try again");
                input2.next();

            }
        }


    }

    public void convo(String npc, String text) {

        System.out.println();
        line();
        System.out.print(npc + ": ");
        System.out.println("\"" + text + "\"");
    }

    public void line() {
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void star() {
        for (int i = 0; i < 40; i++) {
            System.out.print("*");
        }
        System.out.println();

    }

    public void pause() {
        System.out.print("\t\t\t\t[.....Press enter to continue...]");
        input.nextLine();
    }

    public void menu() {
        if (choice.equalsIgnoreCase("Menu")) {
            player1.menu(player1);
        } else if (choice.equalsIgnoreCase("Inventory")) {
            equipItem();
        } else if (choice.equalsIgnoreCase("::dev")) {
            devMenu();
        } else {
            line();
            System.out.println("Please try again");
        }

    }
}


