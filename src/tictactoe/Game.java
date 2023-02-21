package tictactoe;

import java.util.Scanner;

public class Game {
    private final String[][] matrix = new String[3][3];
    private int playerX = 0;
    private int playerY = 0;
    private boolean game = false;
    private boolean pX = true;

    public String[][] getMatrix() {
        return matrix;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public boolean isGame() {
        return game;
    }

    public void setGame(boolean game) {
        this.game = game;
    }

    public boolean ispX() {
        return pX;
    }

    public Game() {
        Printer printer = new Printer();
        Checker checker = new Checker();
        Scanner scanner = new Scanner(System.in);

        //Filling and printing the tic-tac-toe field.
        printer.fillMatrix(matrix);
        printer.printMatrix(matrix);

        //The main loop of the application, where the input is checked each time by logic and exception handling.
        do {
            System.out.println("Enter the coordinates: (in pairs: x y)");
            try {
                String coordinatesForTable = scanner.nextLine();

                //Taking input (x y), distributing it and assigning it to a place on the tic-tac-toe game field.
                //The value assignment system set in the task on HyperSkill:
                //x - horizontal, y - vertical. From bottom left as 1 1.
                String[] pieces = coordinatesForTable.split(" ");
                if (Integer.parseInt(pieces[0]) <= 3 && Integer.parseInt(pieces[1]) <= 3) {
                    setPlayerX(Integer.parseInt(pieces[0]));
                    setPlayerY(Integer.parseInt(pieces[1]));
                }

                //Checking the possibility of placing a player's move and placing it on the game field.
                if (!getMatrix()[3 - playerY][playerX - 1].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {

                    //If the field is not occupied, enter X or O according to the play order. (X starts).
                    if (ispX()) {
                        getMatrix()[3 - playerY][playerX - 1] = "X";
                        pX = false;
                    } else {
                        getMatrix()[3 - playerY][playerX - 1] = "O";
                        pX = true;
                    }
                    printer.printMatrix(matrix);
                }

                //Checking if the game has ended and shutting down the game if so.
                checker.checkXWin(matrix);
                checker.checkOWin(matrix);
                checker.checkDraw(matrix);

                if (checker.isxWins()) {
                    System.out.println("X wins");
                } else if (checker.isoWins()) {
                    System.out.println("O wins");
                } else if (checker.isDraw()) {
                    System.out.println("Draw");
                }
                if (checker.isxWins() || checker.isoWins() || checker.isDraw()) {
                    setGame(true);
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3! In pairs!");
            }
        } while (!isGame());
    }
}