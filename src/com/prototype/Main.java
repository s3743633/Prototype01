package com.prototype;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
Scanner input = new Scanner(System.in);
Enemy wolf = new Enemy("wolf", 50, 5, 10, true);
Player player1 = new Player("bob", 100, 5,30, true);

        System.out.println("fight test");

  player1.fight(player1, wolf);


    }


}
