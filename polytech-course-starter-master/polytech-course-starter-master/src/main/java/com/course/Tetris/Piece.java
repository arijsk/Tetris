package com.course.Tetris;


public class Piece {
    int  [][][] pieceShapeList;
    int currentState;
    int sizeLine, sizeColumn;
    int line;
    int column;

    public Piece(int [][][] pieceShape, int line, int column) {
        this.pieceShapeList = pieceShape;
        this.currentState = 0;
        this.line = line;
        this.column = column;
        this.sizeLine = this.pieceShapeList[this.currentState].length;
        this.sizeColumn = this.pieceShapeList[this.currentState][0].length;
    }
    public void updateState(int i){
        if(currentState + i > pieceShapeList.length - 1) {
            currentState = 0;
        }
        else if (currentState + i < 0) {
            currentState = pieceShapeList.length - 1;
        }
        else {
            currentState += i;
        }
        System.out.println("state : " + currentState);
    }

    public int[][] currentShape() {
        return this.pieceShapeList[this.currentState];
    }
}
