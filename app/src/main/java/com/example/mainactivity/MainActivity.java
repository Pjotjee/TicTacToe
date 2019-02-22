package com.example.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //initialize the variables
    private int row;
    private int col;
    private String symbol;
    private TextView textV;
    Game game;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    /* Check if there is an ongoing game saved in the Bundle and create that on the screen,
    otherwise start a new game.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        textV = findViewById(R.id.textView);

        if (savedInstanceState == null ) {
            game = new Game();
        }else{
            game = (Game)savedInstanceState.getSerializable("game");
            String text1 = savedInstanceState.getString("button1Text");
            String text2 = savedInstanceState.getString("button2Text");
            String text3 = savedInstanceState.getString("button3Text");
            String text4 = savedInstanceState.getString("button4Text");
            String text5 = savedInstanceState.getString("button5Text");
            String text6 = savedInstanceState.getString("button6Text");
            String text7 = savedInstanceState.getString("button7Text");
            String text8 = savedInstanceState.getString("button8Text");
            String text9 = savedInstanceState.getString("button9Text");
            String textG = savedInstanceState.getString("textG");
            button1.setText(text1);
            button2.setText(text2);
            button3.setText(text3);
            button4.setText(text4);
            button5.setText(text5);
            button6.setText(text6);
            button7.setText(text7);
            button8.setText(text8);
            button9.setText(text9);
            textV.setText(textG);
        }
    }

    // save the game in a bundle before the screen changes
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super
        outState.putSerializable("game", game);
        // check the texts
        String button1Text = String.valueOf(button1.getText());
        String button2Text = String.valueOf(button2.getText());
        String button3Text = String.valueOf(button3.getText());
        String button4Text = String.valueOf(button4.getText());
        String button5Text = String.valueOf(button5.getText());
        String button6Text = String.valueOf(button6.getText());
        String button7Text = String.valueOf(button7.getText());
        String button8Text = String.valueOf(button8.getText());
        String button9Text = String.valueOf(button9.getText());
        String textG = String.valueOf(textV.getText());
        // put texts into the out state
        outState.putString("button1Text", button1Text );
        outState.putString("button2Text", button2Text );
        outState.putString("button3Text", button3Text );
        outState.putString("button4Text", button4Text );
        outState.putString("button5Text", button5Text );
        outState.putString("button6Text", button6Text );
        outState.putString("button7Text", button7Text );
        outState.putString("button8Text", button8Text );
        outState.putString("button9Text", button9Text );
        outState.putString("textG", textG);
    }

    //tileClicked handels the process when a tile is clicked on the screen
    public void tileClicked(View view) {
        // this way more is know about what is clicked (the view)
        Button button = (Button) view;
        // assign coordinates to the buttons
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
        // check the state of the tile clicked
        TileState state = game.choose(row, col);
        textV = findViewById(R.id.textView);
        // switch case according to the symbol
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
        // set the textfield and tile according to the player's turn
        if (state == TileState.CROSS) {
            button.setText(symbol);
            textV.setText("Player Two's Turn");
        }  else if (state == TileState.CIRCLE){
            button.setText(symbol);
            textV.setText("Player One's Turn");
        }
        // disable further entries after the game is won
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
    // when a new game is started the board must be reset
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
