package tictactoe;

import java.util.Scanner;

public class Game {
    private String[][] matrix = new String[3][3];


    private int playerX = 0;
    private int playerY = 0;

    private boolean game = false;
    private boolean pX = true;

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
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

    public void setpX(boolean pX) {
        this.pX = pX;
    }

    public void fillMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = " ";
            }
        }
    }

    public Game() {
        Printer printer = new Printer();
        Checker checker = new Checker();
        Scanner scanner = new Scanner(System.in);

        fillMatrix(matrix);

        printer.printMatrix(matrix);
        do {
            System.out.println("Enter the coordinates: ");
            try {
                String coordinatesForTable = scanner.nextLine();
                String[] pieces = coordinatesForTable.split(" ");
                if (Integer.parseInt(pieces[0]) <= 3 && Integer.parseInt(pieces[1]) <= 3) {
                    setPlayerX(Integer.parseInt(pieces[0]));
                    setPlayerY(Integer.parseInt(pieces[1]));
                }
                if (!getMatrix()[3 - playerY][playerX - 1].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    if (ispX()) {
                        getMatrix()[3 - playerY][playerX - 1] = "X";
                        pX = false;
                    } else {
                        getMatrix()[3 - playerY][playerX - 1] = "O";
                        pX = true;
                    }
                    printer.printMatrix(matrix);
                }
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
                System.out.println("Coordinates should be from 1 to 3!");
            }
            setPlayerX(0);
            setPlayerY(0);
        }while (!isGame());
    }
}