package com.course.polytech;

public class Tetris {
    static final int HEIGHT=24;
    static final int WIDTH=10;

    int grid [][]=new int [HEIGHT][WIDTH];
    Piece currentPiece;
    private void initialize(){
        for (int i=0;i<HEIGHT;i++){
            for (int j=0;j<WIDTH;j++){
                grid[i][j]=0;
            }
        }
    }
    public void PrintBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" x ");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public void startGame() {
        this.initialize();
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hey");
            PrintBoard();
        }
    }

    public static void main(String[] args){
        Tetris Game= new Tetris();
        Game.startGame();
    }

}
