package com.example.mainactivity;

import android.util.Log;

import java.io.Serializable;

public class Game implements Serializable {
    // initialize the variables
    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;
    // the board will be initialized
    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;
        movesPlayed = 0;
        playerOneTurn = true;
        gameOver = false;
    }
    // state the tile clicked according to the player's turn and update the game
    public TileState choose(int row, int column) {
        if (playerOneTurn){
            if (board[row][column] == TileState.BLANK) {
                playerOneTurn = false;
                movesPlayed++;
                board[row][column] = TileState.CROSS;
                return TileState.CROSS;
            } else {
                return TileState.INVALID;
            }
        } else {
            if (board[row][column] == TileState.BLANK) {
                playerOneTurn = true;
                movesPlayed++;
                board[row][column] = TileState.CIRCLE;
                return TileState.CIRCLE;
            } else {//(board[row][column] != TileState.BLANK) {
                return TileState.INVALID;
            }
        }
    }
    // check if a player won the game and return the state of the game
    public GameState won() {
        if ( (board[0][0] != TileState.BLANK) && (board[0][0] == board[0][1]) && (board[0][0] == board[0][2])) {
            if (playerOneTurn)
                return GameState.PLAYER_TWO;
            else
                return GameState.PLAYER_ONE;
        } else if ((board[1][0] != TileState.BLANK) && (board[1][0] == board[1][1]) && (board[1][0] == board[1][2])) {
            if (playerOneTurn)
                return GameState.PLAYER_TWO;
            else
                return GameState.PLAYER_ONE;
        } else if ((board[2][0] != TileState.BLANK) && (board[2][0] == board[2][1]) && (board[2][0] == board[2][2])) {
            if (playerOneTurn)
                return GameState.PLAYER_TWO;
            else
                return GameState.PLAYER_ONE;
        } else if ((board[0][0] != TileState.BLANK) && (board[0][0] == board[1][1]) && (board[0][0] == board[2][2])) {
            if (playerOneTurn)
                return GameState.PLAYER_TWO;
            else
                return GameState.PLAYER_ONE;
        } else if ( (board[0][2] != TileState.BLANK) && (board[0][2] == board[1][1]) && (board[0][2] == board[2][0])) {
            if (playerOneTurn)
                return GameState.PLAYER_TWO;
            else
                return GameState.PLAYER_ONE;
        } else if ((board[0][0] != TileState.BLANK) && (board[0][0] == board[1][0]) && (board[0][0] == board[2][0])) {
                if (playerOneTurn)
                    return GameState.PLAYER_TWO;
                else
                    return GameState.PLAYER_ONE;
        } else if ((board[0][1] != TileState.BLANK) && (board[0][1] == board[1][1]) && (board[0][1] == board[2][1])) {
            if (playerOneTurn)
                return GameState.PLAYER_TWO;
            else
                return GameState.PLAYER_ONE;
        } else if ((board[0][2] != TileState.BLANK) && (board[0][2] == board[1][2]) && (board[0][2] == board[2][2])) {
            if (playerOneTurn)
                return GameState.PLAYER_TWO;
            else
                return GameState.PLAYER_ONE;
        } else if (movesPlayed == 9)
            return GameState.DRAW;
        return GameState.IN_PROGRESS;
    }
}
