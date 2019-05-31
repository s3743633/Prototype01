/*
Intro to programming - Final Project
Created by Chris Jayawardena & Grant Cavanagh
RMIT semester 1 - June 2019

 */



package com.prototype;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Maps gameStart = new Maps(0, "okDevious", 0);
        Scanner newGame = new Scanner(System.in);


           loadScreen();
           System.out.println("Check out the readme to know learn how to play the game");
           System.out.println("Press enter key to start");
           newGame.nextLine();
           gameStart.mapA4();

        }


    public static void loadScreen(){

        System.out.println("okDevious is loading...please wait");
        try

        {
            for(int i=0;i<=10;i++){
                System.out.print("** ");
                Thread.sleep(300); // this should pause the program or the loop
            }
            System.out.println();
        }

        catch(Exception e){

        }

        System.out.println("Loading completed!!");
        System.out.println();

        try {


            for (int i = 1; i <= 1; i++) {

                Thread.sleep(2000);
                System.out.println("*******************************************************************************************");
                System.out.println();
                System.out.println("      ******     *     *      ****    *****  *       *  ***  ******   *    *  ****         ");
                System.out.println("     *      *    *   *        *   *   *       *     *    *  *      *  *    *  *            ");
                System.out.println("     *      *    * *          *    *  *****    *   *     *  *      *  *    *  ****         ");
                System.out.println("     *      *    *   *        *   *   *         * *      *  *      *  *    *     *         ");
                System.out.println("      ******     *     *      ****    *****      *      ***  ******   ******  ****         ");
                System.out.println();
                System.out.println("*******************************************************************************************");
            }
        }
        catch(Exception e){
        }


    }
    }

