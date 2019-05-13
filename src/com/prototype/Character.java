package com.prototype;

import java.util.*;

public abstract class Character {
    private String name;
    public int health;
    private int defence;
    private int damage;
    private boolean isAlive;
    public int questID;


    public Character(String name, int health, int defence, int damage, boolean isAlive, int questID) {
        this.name = name;
        this.health = health;
        this.defence = defence;
        this.damage = damage;
        this.isAlive = isAlive;
        this.questID = questID;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlive(boolean isAlive){this.isAlive = isAlive; }

    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive(){
        return health > 0;
    }
}


    class Player extends Character {

        public Player(String name, int health, int defence, int damage, boolean isAlive, int questID) {

            super(name, health, defence, damage, isAlive, questID);

        }

        public void attack(Player a, Player b) {
            Random rand = new Random();
            int damage = Math.max(0,rand.nextInt(a.getDamage()) - b.getDefence());
            int monsDamage = Math.max(0,rand.nextInt(b.getDamage()) - a.getDefence());
            int health = Math.max(0,b.getHealth() - damage);
            b.setHealth(health);
            System.out.println("you hit a " + damage);
            System.out.println(b.getName() + " hp is now:" + health);
            if(!b.isAlive()){
                System.out.println("You killed: " + b.getName());
            }
            else {
                int yourHP = Math.max(0,a.getHealth() - monsDamage);
                a.setHealth(yourHP);
                System.out.println(b.getName() + " did " + monsDamage);
                System.out.println("your health is now: " + yourHP);}
        }


        public void fight(Player a, Player b) {
            Scanner input = new Scanner(System.in);

            do{
                System.out.println("what do you want to do?");
                System.out.println("attack or runaway?");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("attack")) {
                    attack(a, b);
                }
            } while (a.isAlive() && b.isAlive());
                if(!a.isAlive()){
                    System.out.println("RIP Game Over!");
                }

        }
    }