import java.util.ArrayList;

public class TicTacToe {

    ArrayList<Character> field = new ArrayList<>();
    private int size;

    TicTacToe(int s) {
        size = s;
        for (int i = 0; i < s * s; i++) {
            field.add(' ');
        }
    }

    public void setField(ArrayList<Character> field) {
        this.field = field;
    }

    public ArrayList<Character> placeSymbol(int place, char sym) {
        if ((sym == 'X' || sym == 'O') && place < field.size()) {
            ArrayList<Character> newField = field;
            newField.set(place, sym);
            setField(newField);
        } else if (place >= field.size()) {
            System.out.println("Error. Index out of range");
        } else {
            System.out.println("Error. Only X and O allowed");
        }
        return field;
    }

    public ArrayList<Character> clearSymbol(int place) {
        if (place < field.size()) {
            ArrayList<Character> newField = field;
            newField.set(place, ' ');
            setField(newField);
        } else {
            System.out.println("Error. Index out of range");
        }
        return field;
    }


    public int findLine(char sym) {

        int length = 0;

        for (int i = 0; i < size; i++) {

            int row = 0;
            int col = 0;

            for (int j = size * i; j < size * (i + 1); j++) {
                if (field.get(j) == sym) {
                    row++;
                } else {
                    if (row > length) {
                        length = row;
                    }
                    row = 0;
                }
                if (row > length) {
                    length = row;
                }
            }

            for (int k = i; k < i + size * (size-1) + 1; k += size) {
                if (field.get(k) == sym) {
                    col++;
                } else {
                    if (col > length) {
                        length = col;
                    }
                    col = 0;
                }
                if (col > length) {
                    length = col;
                }
            }
        }


        for (int i = 1; i < 2 * size - 2; i++) {

            ArrayList<Integer> diagL = new ArrayList<>();
            ArrayList<Integer> diagR = new ArrayList<>();
            int diagLeft = 0;
            int diagRight = 0;

            for (int j = 0; j < field.size(); j++) {
                int x = j / size;
                int y = j % size;
                if (x + y == i) {
                    diagL.add(j);
                }
            }

            for (int k = 0; k < diagL.size(); k++) {
                if (field.get(diagL.get(k)) == sym) {
                    diagLeft++;
                } else {
                    if (diagLeft > length) {
                        length = diagLeft;
                    }
                    diagLeft = 0;
                }
                if (diagLeft > length) {
                    length = diagLeft;
                }
            }

            for (int j = 0; j < field.size(); j++) {
                int x = j / size; //0, 1
                int y = j % size; //1, 2
                if (x - y == i - (size - 1)) {
                    diagR.add(j);
                }
            }

            for (int k = 0; k < diagR.size(); k++) {
                if (field.get(diagR.get(k)) == sym) {
                    diagRight++;
                } else {
                    if (diagRight > length) {
                        length = diagRight;
                    }
                    diagRight = 0;
                }
                if (diagRight > length) {
                    length = diagRight;
                }
            }

        }
        return length;
    }

    public void drawTable() {
        for (int i = 0; i < size * size; i++) {
            System.out.print(field.get(i));
            if ((i % size) == (size - 1)) {
                System.out.print('\n');
            }
        }
    }

}