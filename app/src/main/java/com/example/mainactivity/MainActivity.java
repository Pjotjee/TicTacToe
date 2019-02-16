package com.example.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int row;
    private int col;
    private String symbol;
    private TextView textV;



    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public void tileClicked(View view) {
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        // This way more is know about the view:
        Button button = (Button) view;
        if (button.getId()== R.id.button1) {
            row = 0;
            col = 0;
        } else if (button.getId() == R.id.button2) {
            row = 0;
            col = 1;
        } else if (button.getId() == R.id.button3) {
            row = 0;
            col = 2;
        } else if (button.getId() == R.id.button4) {
            row = 1;
            col = 0;
        } else if (button.getId() == R.id.button5) {
            row = 1;
            col = 1;
        } else if (button.getId() == R.id.button6) {
            row = 1;
            col = 2;
        } else if (button.getId() == R.id.button7) {
            row = 2;
            col = 0;
        } else if (button.getId() == R.id.button8) {
            row = 2;
            col = 1;
        } else if (button.getId() == R.id.button9) {
            row = 2;
            col = 2;
        }


        TileState state = game.choose(row, col);
        Log.d("errorcheck", String.valueOf(state));
        textV = findViewById(R.id.textView);


        switch(state) {
            case CROSS:
                symbol ="X";
                break;
            case CIRCLE:
                symbol ="O";
                break;
            case INVALID:
                //
                break;
        }
        Log.d("errorcheck", String.valueOf(state));
        if (state == TileState.CROSS) {
            button.setText(symbol);
            textV.setText("Player Two's Turn");
        }  else if (state == TileState.CIRCLE){
            button.setText(symbol);
            textV.setText("Player One's Turn");
        }

        GameState GameStat = game.won();
        if (GameStat == GameState.PLAYER_ONE){
            textV.setText("Player One Won!!");
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
        } else if (GameStat == GameStat.PLAYER_TWO) {
            textV.setText("Player Two Won!!");
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);

        } else if (GameStat == GameStat.DRAW) {
            textV.setText("It's a draw");
        }



    }

    public void resetClicked(View view) {
        game = new Game();

        Button button1 = findViewById(R.id.button1);
        button1.setText(" ");
        Button button2 = findViewById(R.id.button2);
        button2.setText(" ");
        Button button3 = findViewById(R.id.button3);
        button3.setText(" ");
        Button button4 = findViewById(R.id.button4);
        button4.setText(" ");
        Button button5 = findViewById(R.id.button5);
        button5.setText(" ");
        Button button6 = findViewById(R.id.button6);
        button6.setText(" ");
        Button button7 = findViewById(R.id.button7);
        button7.setText(" ");
        Button button8 = findViewById(R.id.button8);
        button8.setText(" ");
        Button button9 = findViewById(R.id.button9);
        button9.setText(" ");
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        textV = findViewById(R.id.textView);
        textV.setText("Player One's Turn");
    }
}
