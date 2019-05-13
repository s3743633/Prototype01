package com.prototype;

import java.util.*;

public abstract class Character {
    private String name;
    public int health;
    private int defence;
    private int damage;
    private boolean isAlive;


    public Character(String name, int health, int defence, int damage, boolean isAlive) {
        this.name = name;
        this.health = health;
        this.defence = defence;
        this.damage = damage;
        this.isAlive = isAlive;
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
        return isAlive;
    }
}


    class Player extends Character{

    public Player(String name, int health, int defence, int damage, boolean isAlive){

        super(name, health, defence, damage, isAlive);

    }

    public boolean isAlive() {
        return health > 0;
    }

        public void attack(Player a, Player b){
        Random rand = new Random();
        int damage = Math.max(0,rand.nextInt(a.getDamage()));
        int monsDamage = Math.max(0,rand.nextInt(b.getDamage()));
        int health = b.getHealth() - damage;
        int yourHP = a.getHealth() - monsDamage;
            System.out.println("you hit a " + damage);
            System.out.println(b.getName() + " hp is now:" + health);
            System.out.println(b.getName() + " did " + monsDamage);
            System.out.println("your health is now: " + yourHP);

            a.setHealth(yourHP);
            b.setHealth(health);
    }


    public void fight (Player a, Player b){

    do{
        attack(a,b);
    }while (a.isAlive() && b.isAlive());

        if(a.isAlive()){
        System.out.println("you killed " + b.getName());

    }else{
        System.out.println("get gud m9");
    }



    }
}

    class Enemy extends Player {

        public Enemy(String name, int health, int defence, int damage, boolean isAlive) {

            super(name, health, defence, damage, isAlive);

        }

        public void attack(Enemy a, Player b) {
            Random rand = new Random();
            int damage = rand.nextInt(getDamage());
            int health = b.getHealth() - damage;
            System.out.println("Enemy hit a " + damage);
            System.out.println("your hp is now:" + health);
            b.setHealth(health);

        }

        public void fight(Enemy a, Player b) {


        }
    }