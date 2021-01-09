package tictactoe;

public class Checker {
    private boolean xWins = false;
    private boolean oWins = false;
    private boolean draw = false;

    public boolean isxWins() {
        return xWins;
    }

    public boolean isoWins() {
        return oWins;
    }

    public boolean isDraw() {
        return draw;
    }

    protected void checkXWin(String[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (
                        matrix[0][0].equals("X") && matrix[0][1].equals("X") && matrix[0][2].equals("X") ||
                                matrix[1][0].equals("X") && matrix[1][1].equals("X") && matrix[1][2].equals("X") ||
                                matrix[2][0].equals("X") && matrix[2][1].equals("X") && matrix[2][2].equals("X") ||
                                matrix[0][0].equals("X") && matrix[1][0].equals("X") && matrix[2][0].equals("X") ||
                                matrix[0][1].equals("X") && matrix[1][1].equals("X") && matrix[2][1].equals("X") ||
                                matrix[0][2].equals("X") && matrix[1][2].equals("X") && matrix[2][2].equals("X") ||
                                matrix[0][0].equals("X") && matrix[1][1].equals("X") && matrix[2][2].equals("X") ||
                                matrix[0][2].equals("X") && matrix[1][1].equals("X") && matrix[2][0].equals("X")) {
                    xWins = true;
                    break;
                }
            }
        }
    }

    protected void checkOWin(String[][] matrix){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (
                        matrix[0][0].equals("O") && matrix[0][1].equals("O") && matrix[0][2].equals("O") ||
                                matrix[1][0].equals("O") && matrix[1][1].equals("O") && matrix[1][2].equals("O") ||
                                matrix[2][0].equals("O") && matrix[2][1].equals("O") && matrix[2][2].equals("O") ||
                                matrix[0][0].equals("O") && matrix[1][0].equals("O") && matrix[2][0].equals("O") ||
                                matrix[0][1].equals("O") && matrix[1][1].equals("O") && matrix[2][1].equals("O") ||
                                matrix[0][2].equals("O") && matrix[1][2].equals("O") && matrix[2][2].equals("O") ||
                                matrix[0][0].equals("O") && matrix[1][1].equals("O") && matrix[2][2].equals("O") ||
                                matrix[0][2].equals("O") && matrix[1][1].equals("O") && matrix[2][0].equals("O")) {
                    oWins = true;
                    break;
                }
            }
        }
    }

    protected void checkDraw(String[][] matrix){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!matrix[0][0].equals(" ") && !matrix[0][1].equals(" ") && !matrix[0][2].equals(" ") && !matrix[1][1].equals(" ") && !matrix[1][2].equals(" ") && !matrix[2][0].equals(" ") && !matrix[2][1].equals(" ") && !matrix[2][2].equals(" ")) {
                    draw = true;
                    break;
                }
            }
        }
    }
}
