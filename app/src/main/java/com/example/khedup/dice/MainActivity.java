package com.example.khedup.dice;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.khedup.dice.Models.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private ArrayList<TextView> diceResults = new ArrayList<>();
    private ArrayList<Button> diceButtons = new ArrayList<>();
    private ArrayList<Boolean> diceHold = new ArrayList<>();
    private int numRolls;
    private int numKeeps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //START here
        diceResults.add((TextView) findViewById(R.id.firstResult));
        diceResults.add((TextView) findViewById(R.id.secondResult));
        diceResults.add((TextView) findViewById(R.id.thirdResult));
        diceResults.add((TextView) findViewById(R.id.fourthResult));
        diceResults.add((TextView) findViewById(R.id.fifthResult));
        diceResults.add((TextView) findViewById(R.id.sixthResult));
        diceButtons.add((Button) findViewById(R.id.firstButton));
        diceButtons.add((Button) findViewById(R.id.secondButton));
        diceButtons.add((Button) findViewById(R.id.thirdButton));
        diceButtons.add((Button) findViewById(R.id.fourthButton));
        diceButtons.add((Button) findViewById(R.id.fifthButton));
        diceButtons.add((Button) findViewById(R.id.sixthButton));
        for (int i = 0; i < 6; i++) {
            diceHold.add(false);
        }
        Player p1 = new Player();
        TextView p1HealthView = (TextView) findViewById(R.id.p1Health);
        p1HealthView.setText(Integer.toString(p1.getHealth()));
        // TextView temp2 = (TextView) findViewById(R.id.p1Points);
        // temp2.setText(p1.getVictoryPoint());
        Player p2 = new Player();
        TextView p2HealthView = (TextView) findViewById(R.id.p2Health);
        p2HealthView.setText(Integer.toString(p2.getHealth()));

        currentTurn(p1, p2);
        p1HealthView.setText(Integer.toString(p1.getHealth()));
        p2HealthView.setText(Integer.toString(p2.getHealth()));


    }

    public void currentTurn(Player player, Player opponent) {
        numRolls = 0;
        numKeeps = 0;
        for (int i = 0; i < 6; i++) {
            diceHold.set(i, false);
        }
            rollDice();
        resultParse(diceResults, player, opponent);


    }


    public void resultParse(ArrayList<TextView> myList, Player p, Player o) {
        int dmg = 0;
        int energy = 0;
        int heal = 0;
        int vp = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equals(R.string.diceResult1)) {
                dmg += 1;
            } else if (myList.get(i).equals(R.string.diceResult2)) {
                dmg += 2;
            } else if (myList.get(i).equals(R.string.diceResult3)) {
                dmg += 3;
            } else if (myList.get(i).equals(R.string.diceResult4)) {
                vp++;
            } else if (myList.get(i).equals(R.string.diceResult5)) {
                energy++;
            } else if (myList.get(i).equals(R.string.diceResult6)) {
                heal++;
            }

        }
        p.updateHealth(heal);
        p.updateVictoryPoint(vp);
        p.updateEnergy(energy);
        o.updateHealth(-dmg);
        return;
    }
    public void rollDice(){
        Button rollButton = (Button) findViewById(R.id.rollAllDice);
        rollButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        for (int i = 0; i < diceResults.size(); i++) {
                            if (!diceHold.get(i)) {
                                double random = Math.random();
                                if (random < .166) {
                                    diceResults.get(i).setText(R.string.diceResult1);
                                } else if (random < .333) {
                                    diceResults.get(i).setText(R.string.diceResult2);
                                } else if (random < .5) {
                                    diceResults.get(i).setText(R.string.diceResult3);
                                } else if (random < .666) {
                                    diceResults.get(i).setText(R.string.diceResult4);
                                } else if (random < .833) {
                                    diceResults.get(i).setText(R.string.diceResult5);
                                } else {
                                    diceResults.get(i).setText(R.string.diceResult6);

                                }
                            }
                        }
                        for (int i = 0; i < diceHold.size(); i++) {
                            keepButtons(i);
                        }

                    }
                }
        );

        return;
    }
    public void keepButtons(final int index) {
        Button temp = diceButtons.get(index);
        temp.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (numRolls != 0) {
                            diceHold.set(index, true);
                            numKeeps++;
                        }
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
