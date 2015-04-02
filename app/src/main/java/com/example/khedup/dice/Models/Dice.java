package com.example.khedup.dice.Models;

import android.content.res.Resources;

import com.example.khedup.dice.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Khedup on 4/2/2015.
 */
    public class Dice {
        ArrayList<String> diceResults = new ArrayList<>();


        public void Dice(ArrayList<String> myList){
            diceResults = myList;
        }
        public ArrayList roll(ArrayList<Boolean> diceHold){

            for(int i = 0; i <diceHold.size();i++) {
                if (diceHold.get(i) != true) {
                    double random = Math.random();
                    String temp = Resources.getSystem().getString(R.string.diceResult1);
                }
            }

            return diceResults;
        }



}
