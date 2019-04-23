package com.course.Tetris;

import java.util.Scanner;

import static com.course.Tetris.BoardState.*;

public class Tetris {

    Board Board = new Board();
    boolean gameOver = false;
    Piece currentPiece;
    Boolean collision=false;
    KeyBoardCommands Commands=new KeyBoardCommands();

    Tetris(){}

    Tetris(Board board){
        Board=board;
    }

    public int getLines(){
        return Board.LINES;
        
    }
    public int getColums(){
        return Board.COLUMNS;

    }

    

    public void new_piece(){
        int[][][] newShape = Shapes.getRandomShape();

        int columnPosShape = getColums() / 2 - (newShape[0].length + 1) / 2;

        this.currentPiece = new Piece(newShape, 0, columnPosShape);
        if (!Collides(0,0)) {
            this.refreshPiece(false);
        } else {
            gameOver = true;
        }

    }


    public void refreshPiece(boolean stickBoard) {
        this.cleanBoard();
        int pieceState = GAMEPIECE;
        int pieceLine = this.currentPiece.line;
        int pieceColumn = this.currentPiece.column;
        int[][] currentShape = this.currentPiece.currentShape();
        if(stickBoard == true) {
            pieceState = FULL;
        }
        for(int linePoint = 0; linePoint < this.currentPiece.sizeLine; linePoint++)
        {
            for(int columnPoint = 0; columnPoint < this.currentPiece.sizeColumn; columnPoint++)
            {
                if(currentShape[linePoint][columnPoint] == 1)
                {
                    this.Board.grid[pieceLine + linePoint][pieceColumn + columnPoint] = pieceState;
                }
            }
        }
    }
    public void cleanBoard() {
        for (int i = 0; i < getLines(); i++) {
            for (int j = 0; j < getColums(); j++) {
                if (this.Board.grid[i][j] == GAMEPIECE) {
                    this.Board.grid[i][j] = EMPTY;
                }
            }
        }
    }
    public boolean Collides(int lineToMove, int columnToMove) {
        int lineToGo = currentPiece.line + lineToMove;

        int columnToGo = currentPiece.column + columnToMove;

        int[][] currentShape = this.currentPiece.currentShape();

        for (int linePoint = 0; linePoint < this.currentPiece.sizeLine; linePoint++)
        {
            for (int columnPoint = 0; columnPoint < this.currentPiece.sizeColumn; columnPoint++)
            {
                if (currentShape[linePoint][columnPoint] == 1)
                {
                    if (this.Board.grid[lineToGo + linePoint][columnToGo + columnPoint] == FULL ||

                            this.Board.grid[lineToGo + linePoint][columnToGo + columnPoint] == BORDER) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    public void move(int i) {
        if (!Collides(0,i))
        {
            currentPiece.column+=i;
        }
        this.refreshPiece(false);
    }
    public void moveDown() {
        if (!Collides(1,0)) {
            currentPiece.line += 1;
            System.out.println("pas de collision");
            this.refreshPiece(false);
        }
        else {
            collision=true;
            System.out.println("collision");
            this.refreshPiece(true);
            Board.detectFullLine();
            this.new_piece();
        }
    }

    public void Rotate(int i) {
        this.currentPiece.updateState(i);
        if (!Collides(0,0)) {
            this.refreshPiece(false);
        } else {
            this.currentPiece.updateState(-i);
        }
    }


    public void startGame() {
        Board.initialize();
        new_piece();
        Board.PrintBoard();
        Scanner keyboard = new Scanner(System.in);

        boolean exit = false;
        while(!exit) {
            if(!gameOver) {
                String input = keyboard.next();
                System.out.println("input : " + input);
                Commands.chooseAction(input,this,Board);
            } else {

                System.out.println("game over");
                exit = true;
            }
        }
        System.out.println("merci :)");
    }



    public static void main(String[] args){


        Tetris Game= new Tetris();
        Game.startGame();

    }

}
