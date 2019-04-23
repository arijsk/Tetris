
package com.course.Tetris;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.assertNotNull;

public class TetrisTest {
    Tetris Game;
    Board Board;
    KeyBoardCommands Commands=new KeyBoardCommands();




    void initialize(){
        Board=new Board();
        Board.initialize();
        Game=new Tetris(Board);

    }

    @Test
    void should_return_true_after_initialization(){
       initialize();
        assertThat(Arrays.asList(Board.grid).contains(1)).isFalse();
        assertThat(Arrays.asList(Board.grid).contains(-1)).isFalse();
    }


    @Test
    void should_Change_State_after_rotation(){
        initialize();
        Game.new_piece();
        int currentState= Game.currentPiece.currentState;
        Game.Rotate(1);
        assertThat(Game.currentPiece.currentState==currentState).isFalse();

    }


    @Test
    void should_move_right_when_the_input_is_right(){
        initialize();
        Game.new_piece();
        int col= Game.currentPiece.column;
        Commands.chooseAction("right",Game,Board);
        assertThat(Game.currentPiece.column==col+1).isTrue();

    }

    @Test
    void should_move_left_when_the_input_is_left(){
        initialize();
        Game.new_piece();
        int col= Game.currentPiece.column;
        Commands.chooseAction("left",Game,Board);
        assertThat(Game.currentPiece.column==col-1).isTrue();

    }

    @Test
    void should_roate_correctly_when_the_input_is_up(){
        initialize();
        Game.new_piece();
        int state= Game.currentPiece.currentState;
        Commands.chooseAction("up",Game,Board);
        assertThat(Game.currentPiece.currentState==state+1).isTrue();

    }
    @Test
    void should_rotate_correctly_when_the_input_is_down(){
        initialize();
        Game.new_piece();
        int state= Game.currentPiece.pieceShapeList.length - 1;
        Commands.chooseAction("down",Game,Board);
        assertThat(Game.currentPiece.currentState==state).isTrue();

    }
    @Test
    void should_move_down_when_the_input_is_space(){
        initialize();
        Game.new_piece();
        int line= Game.currentPiece.line;
        Commands.chooseAction("space",Game,Board);
        assertThat(Game.currentPiece.line==line+1).isTrue();

    }





    @Test
    void should_return_true_after_changing_current_piece_with_new_piece(){
        initialize();
        Game.new_piece();
        assertNotNull(Game.currentPiece);
    }
    @Test
    void should_return_true_when_collides_with_border (){
        initialize();
        Game.new_piece();
        //boolean col=Game.collision;
        Board.PrintBoard();

        while(!Game.collision)
        {
            Game.moveDown();
        }
        assertThat(Game.collision).isTrue();


    }
    @Test
    void should_return_false_if_no_detection_of_full_line (){
        initialize();
        Game.new_piece();
        assertThat(Board.FullLine).isFalse();

    }

}
