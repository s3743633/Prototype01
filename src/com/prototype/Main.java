package com.prototype;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player wolf = new Player("wolf", 50, 1, 100, true, 0);
        Player player1 = new Player("bob", 100, 10, 30, true, 0);
        Maps mapa1 = new Maps(false, "beach", 0);

        System.out.println("you wake up and find yourself stranded on the coast, you see that there is a path that leads north");
        mapa1.mapA4();


    }


}
