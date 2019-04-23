package com.course.Tetris;


public class Board {
    static final int LINES=10;
    static final int COLUMNS =10;
    int grid[][]=new int [LINES][COLUMNS];
    boolean FullLine=false;


    //creating the grid's borders
    public void Border(){
        for (int i=0;i<LINES;i++){
            grid[i][COLUMNS-1]= grid[i][0] = BoardState.BORDER;
        }
        for (int j = 0; j< COLUMNS; j++){
            grid[LINES-1][j]= BoardState.BORDER;
        }

    }
    public void PrintBoard() {
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (this.grid[i][j] == BoardState.EMPTY) {
                    System.out.print(" . ");
                } else if (this.grid[i][j] == BoardState.GAMEPIECE){
                    System.out.print(" o ");
                } else if (this.grid[i][j] == BoardState.FULL) {
                    System.out.print(" x ");
                } else if (this.grid[i][j] == BoardState.BORDER) {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }


    public void initialize(){

        for (int i=0;i<LINES;i++){
            for (int j = 0; j< COLUMNS; j++){
                grid[i][j]= BoardState.EMPTY;
            }
        }
        Border();
    }

    public void detectFullLine() {
        int cptFullInline = 0;
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (this.grid[i][j] == BoardState.FULL) {
                    cptFullInline++;
                }
            }
            if(cptFullInline == COLUMNS - 2) { // -2 = Bordures
                FullLine=true;
                clearFullLine(i);
            }
            cptFullInline = 0;
        }
    }

    public void clearFullLine(int lastLine) {

        int gridCopy[][] = new int[LINES][COLUMNS];
        for(int i = 0; i < LINES; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                gridCopy[i][j] = this.grid[i][j];
            }
        }

        for(int i = 1; i <= lastLine; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                this.grid[i][j] = gridCopy[i-1][j];
            }
        }

        for(int i = 1; i < COLUMNS - 1; i++) {
            this.grid[0][i] = BoardState.EMPTY;
        }
    }






}
