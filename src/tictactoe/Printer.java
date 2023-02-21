package tictactoe;

public class Printer {

    //Create visual boundaries and print the tic-tac-toe game field.
    protected void printMatrix(String[][] matrix){
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    //Filling the tic-tac-toe field (2-dimension board) with empty space, ready to enter the player's moves.
    protected void fillMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = " ";
            }
        }
    }
}
