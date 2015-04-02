package com.example.khedup.dice;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private ArrayList<TextView> diceResults = new ArrayList<>();
    private ArrayList<Button> diceButtons = new ArrayList<>();
    private ArrayList<Boolean> diceHold = new ArrayList<>();
    private int numRolls;

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

        ArrayList<String> currentTurn = turn();

    }

    public ArrayList<String> turn(){
        numRolls = 0;

        for (int i = 0; i < 6; i++) {
            diceHold.add(false);
        }
        //TextView temp = (TextView) findViewById(R.id.turn);
        // temp.setText(numRolls);

        Button rollButton = (Button) findViewById(R.id.rollAllDice);
        rollButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (numRolls < 10) {
                            for (int i = 0; i < diceResults.size(); i++) {
                                double random = Math.random();
                                if (!diceHold.get(i)) {
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

                        }
                        numRolls++;
                    }
                }
        );
        for(int i = 0; i <diceHold.size();i++) {
            keepButtons(i);
        }
        return null;
    }
    public void keepButtons(final int index){
        Button temp = diceButtons.get(index);
        temp.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (numRolls != 0) {
                            diceHold.set(index, true);
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
