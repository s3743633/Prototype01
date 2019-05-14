package com.prototype;


import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Maps {

    private boolean iscomplete;
    private String name;
    private int questID;
    private Scanner input = new Scanner(System.in);
    public boolean isvalid;
    private Player player1 = new Player("", 40, 5, 100, true, 0);

    public Maps(boolean iscomplete, String name, int questID) {
        this.iscomplete = iscomplete;
        this.name = name;
        this.questID = questID;
    }


    public String menu() {

        String n;
        n = "hello";
        return n;
    }

    public boolean isIscomplete() {
        return iscomplete;
    }


    public void mapDirection(String north, String east, String south, String west) {


        //designed to stop replicated code, you can set the parameter depending on which directions you want to go

        System.out.println("where do you want to go?");
        if (north.equalsIgnoreCase("north")) {
            System.out.println("\tgo north");
        }
        if (west.equalsIgnoreCase("west")) {
            System.out.println("\tgo west");

        }
        if (east.equalsIgnoreCase("east")) {
            System.out.println("\tgo east");

        }
        if (south.equalsIgnoreCase("south")) {
            System.out.println("\tgo south");

        }

            System.out.println("\tMenu");
    }


// Row A maps going down grid

    public void mapA1() {

        System.out.println("bandit hideout (3)");
        isvalid = false;

        mapDirection("", "west", "", "");
        String choice = input.nextLine();
        while(!isvalid)
        if (choice.equalsIgnoreCase("east")) {
            isvalid = true;
            mapB1();
        }else if(choice.equalsIgnoreCase("Menu")) {
            player1.menu(player1);
        }else
            System.out.println("Please try again");

    }


    public void mapA2() {


        System.out.println("dead end 3");
        isvalid = false;
        while (!isvalid) {
            mapDirection("", "east", "", "s");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("east")) {
                isvalid = true;
                mapB2();
            } else if (choice.equalsIgnoreCase("Menu")) {
                player1.menu(player1);
            } else
                System.out.println("Please try again");

        }
    }

    private Boolean mapA3() {
        System.out.println("Shipwreck Debris");

        while (!iscomplete) {
            System.out.println("As you explore the area, you are attacked by a shiny blue slime!");
            Player slime = new Player("slime", 20, 0, 5, true, 0);
            player1.fight(player1, slime);
            iscomplete = true;
        }

        isvalid = false;
        while (!isvalid) {
            mapDirection("", "east", "south", "");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("east")) {
                isvalid = true;
                mapB3();

            } else if (choice.equalsIgnoreCase("south")) {
                isvalid = true;
                mapA4();

            } else if (choice.equalsIgnoreCase("Menu")) {
                player1.menu(player1);
            } else
                System.out.println("Please try again");

        }
        return iscomplete;
    }


    public boolean mapA4() {


        while(!Maps.this.iscomplete){
        System.out.println("Shipwreck Cove");
        System.out.println("you awaken, poked by a strangers walking stick.");
        System.out.println("your body aches all over, finally opening your eyes the man says");
        System.out.println("\"You're lucky to be alive friend! Do you remember who you are?\"");
        System.out.println("You can't quite remember your name but you tell the man its: ");
        player1.setName(input.nextLine());
        System.out.println(player1.getName() + " is it? Well its good that you don't have amnesia!");
        isvalid = false;
        Maps.this.iscomplete = true;
        }
        while (!isvalid) {
            mapDirection("north", "", "", "");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("north")) {
                isvalid = true;
                mapA3();
            }else if(choice.equalsIgnoreCase("Menu")) {
                player1.menu(player1);
            }else
                System.out.println("Please try again");

        }
    return(iscomplete);
    }


    //Maps B row


    public void mapB1() {
        System.out.println("Bandit hideout (2)");
        isvalid = false;
        while (!isvalid) {
            mapDirection("", "east", "", "west");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("east")) {
                isvalid = true;
                mapC1();
            } else if (choice.equalsIgnoreCase("west")) {
                isvalid = true;
                mapA1();
            } else {
                System.out.println("Please try again");
            }
        }
    }

    public void mapB2() {
        System.out.println("circle forest");
        isvalid = false;
        while (!isvalid) {
            mapDirection("", "east", "south", "west");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("east")) {
                isvalid = true;
                mapC2();
            } else if (choice.equalsIgnoreCase("south")) {
                isvalid = true;
                mapB3();
            } else if (choice.equalsIgnoreCase("west")) {
                isvalid = true;
                mapA2();
            } else {
                System.out.println("Please try again");
            }
        }
    }

    public void mapB3() {
        System.out.println("circle forest");
        mapDirection("north", "", "south", "west");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("north")) {
        mapB2();
        }

        if (choice.equalsIgnoreCase("south")) {
            mapB4();
        }

        if (choice.equalsIgnoreCase("west")) {
            mapA3();
        }
    }

    public void mapB4(){
        System.out.println("circle forest");
        mapDirection("north", "east", "south","");
        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("north")){
            mapB3();
        }

        if(choice.equalsIgnoreCase("east")){
            mapC4();
        }

        if(choice.equalsIgnoreCase("south")){
            mapB5();

        }

    }

  //DEAD END 1
    public void mapB5(){
        System.out.println("Dead End");
        mapDirection("north","","","");
        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("north")){
            mapB4();

        }
    }

    // Maps C row


    public void mapC1(){
        System.out.println("Bandit Hideout (1)");
      mapDirection("","","south","");
      String choice = input.nextLine();

        if(choice.equalsIgnoreCase("south")){
            mapC2();
        }


    }

    public void mapC2(){
        System.out.println("circle forest");
        mapDirection("north", "east","","west");

        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("north")){
            mapC1();
        }


        if(choice.equalsIgnoreCase("east")){
            mapD2();

        }


        if(choice.equalsIgnoreCase("west")){
            mapB2();

        }



    }


    public void mapC4(){
        System.out.println("circle forest");
        mapDirection("","east", "", "west");
        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("east")){
            mapB4();
        }

        if(choice.equalsIgnoreCase("west")){
            mapD4();
        }

    }


    //Maps D row

    public void mapD1(){
        System.out.println("Lighthouse Road");
        mapDirection("","east","","");
        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("east")){
            mapE1();
        }

    }

    public void mapD2(){
        System.out.println("circle forest");
        mapDirection("north", "","south","west" );
        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("north")){
            mapD1();
        }

        if(choice.equalsIgnoreCase("south")){
            mapD3();
        }

        if(choice.equalsIgnoreCase("west")){
            mapC2();
        }


    }


    public void mapD3(){
        System.out.println("circle forest");
        mapDirection("north", "east", "south","");
        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("north")){
            mapD2();
        }

        if(choice.equalsIgnoreCase("east")){
            mapE3();

        }

        if(choice.equalsIgnoreCase("south")){
            mapD4();

        }



    }


    public void mapD4(){
        System.out.println("circle forest");
        mapDirection("north", "", "south", "west");
        String choice = input.next();


        if(choice.equalsIgnoreCase("north")){
            mapD3();
        }
        if(choice.equalsIgnoreCase("south")){
            mapD5();
        }
        if(choice.equalsIgnoreCase("west")){
            mapC4();
        }


    }

    //Dead End
    public void mapD5(){
        System.out.println("Dead End");
        mapDirection("north","","","");
        String choice = input.next();

        if(choice.equalsIgnoreCase("north")){
            mapD4();
        }

    }

    //Maps E row

    public void mapE1(){
        System.out.println("Lighthouse");
        mapDirection("","","","west");
        String choice = input.nextLine();

        if(choice.equalsIgnoreCase("west")){
            mapD1();
        }
    }

    //PORT TOWN
    public void mapE2(){
        System.out.println("Port Town - Ships");
        mapDirection("","","south","");
        String choice = input.nextLine();

        if(choice.equalsIgnoreCase("south")){
            mapE3();
        }
    }

    public void mapE3(){
        System.out.println("Port Town - Entrance");
        mapDirection("north", "","south", "west");
        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("north")){
            mapE2();
        }

        if(choice.equalsIgnoreCase("south")){
            mapE4();
        }

        if(choice.equalsIgnoreCase("west")){
            mapD3();
        }

    }

    public void mapE4(){
        System.out.println("Port Town - Market");
        mapDirection("north", "","","");
        String choice = input.nextLine();


        if(choice.equalsIgnoreCase("north")){
            mapE3();
        }

    }
}




