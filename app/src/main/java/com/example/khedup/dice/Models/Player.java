package com.example.khedup.dice.Models;

/**
 * Created by Khedup on 4/2/2015.
 */
public class Player {
    private int health;
    private int victoryPoint;
    private int energy;

    public Player(){
        health  = 10;
        victoryPoint = 0;
        energy = 0;
    }

    public void updateHealth(int i){
        health += i;
    }
    public void updateVictoryPoint(int v){
        victoryPoint += v;
    }
    public void updateEnergy(int e){
        energy+=e;
    }
    public int getHealth(){
        return health;
    }
    public int getVictoryPoint(){
        return victoryPoint;
    }
    public int getEnergy(){
        return energy;
    }
}
