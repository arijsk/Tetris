package com.course.Tetris;

import java.util.Scanner;

public class KeyBoardCommands {

    public  void chooseAction(String input, Tetris Game, Board board){

        if(input.contains("left")) {
            Game.move(-1);
            board.PrintBoard();
        }
        if(input.contains("right")) {
            Game.move(1);
            board.PrintBoard();
        }
        if(input.contains("down")) {
            Game.Rotate(-1);
            board.PrintBoard();
        }
        if(input.contains("up")) {
            Game.Rotate(1);
            board.PrintBoard();
        }
        if(input.contains("space")) {
            Game.moveDown();
            board.PrintBoard();
        }

    }

}
