import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TicTacToeTest {

    int n = 3;
    TicTacToe ticTacToe = new TicTacToe(n);



    @Test
    void test(){
        ArrayList<Character> testField = new ArrayList<>();
        for (int i = 0; i < n*n; i++){
            testField.add(' ');
        }

        testField.set(0, 'X');
        Assertions.assertEquals(testField, ticTacToe.placeSymbol(0, 'X'));

        testField.set(0, ' ');
        Assertions.assertEquals(testField, ticTacToe.clearSymbol(0));

        ticTacToe.placeSymbol(0, 'X');
        Assertions.assertEquals(1, ticTacToe.findLine( 'X'));
        ticTacToe.placeSymbol(4, 'X');
        Assertions.assertEquals(2, ticTacToe.findLine( 'X'));
        ticTacToe.placeSymbol(8, 'X');
        Assertions.assertEquals(3, ticTacToe.findLine( 'X'));

    }

}
