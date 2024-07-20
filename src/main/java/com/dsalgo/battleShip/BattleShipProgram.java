package com.dsalgo.battleShip;

import sun.nio.ch.sctp.SctpNet;

import javax.management.relation.RelationNotification;
import java.util.Random;
import java.util.Scanner;

public class BattleShipProgram {

    private static final int GRID_SIZE = 5;
    private static final char[][] playerBoard = new char[GRID_SIZE][GRID_SIZE];
    private static final char[][] computerBoard = new char[GRID_SIZE][GRID_SIZE];
    private static final char[][] computerGuesses = new char[GRID_SIZE][GRID_SIZE];

    private static final char MISS = 'X';
    private static final char HIT = 'O';
    private static final char SHIP = 'S';
    private static final char WATER = '-';

    public static void initializePlayerBoard(char[][] playerBoard) {

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                playerBoard[i][j] = WATER;
            }
        }

    }

    public static void arrangeShips(char[][] playerBoard) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int x, y;
            //Generating random values until x and y coordinates is not an ship
            do {
                x = random.nextInt(GRID_SIZE);
                y = random.nextInt(GRID_SIZE);
            } while (playerBoard[x][y] != SHIP);
            playerBoard[x][y] = SHIP;
        }

    }

    public static void playerTurn(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (computerBoard[x][y] == SHIP) {
            System.out.println("Got an Hit for the Computer");
            computerBoard[x][y] = SHIP;
        } else {
            System.out.println("Got an Miss");
            computerBoard[x][y] = MISS;
        }
    }

    public static void computerTurn(Scanner scanner) {

        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(GRID_SIZE);
            y = random.nextInt(GRID_SIZE);
        } while (computerGuesses[x][y]!=WATER);

        if (playerBoard[x][y] == SHIP) {
            System.out.println("Got an Hit for the Player");
            playerBoard[x][y] = SHIP;
        } else {
            System.out.println("Got an Miss for the player");
            playerBoard[x][y] = MISS;
        }
        computerGuesses[x][y]=MISS;
    }

    private static boolean checkWin(char[][] board){
        for (int i = 0; i <GRID_SIZE ; i++) {

            for (int j = 0; j <GRID_SIZE ; j++) {

                if(board[i][i]==SHIP){
                    return false;
                }
            }

        }
        return true;
    }

    private static void printBoard(char[][] board, boolean revealShips) {
        System.out.print("  ");
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == SHIP && !revealShips) {
                    System.out.print(WATER + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        initializePlayerBoard(playerBoard);
        initializePlayerBoard(computerBoard);
        initializePlayerBoard(computerGuesses);

        arrangeShips(playerBoard);
        arrangeShips(computerBoard);

        Scanner scanner = new Scanner(System.in);
        while (true) {

            playerTurn(scanner);
            //Checking computer board if ships are there
            if(checkWin(computerBoard)){
                System.out.println("Congratulations! You have destroyed all the computer ships");
                break;
            }
            computerTurn(scanner);
            if (checkWin(playerBoard)){
                System.out.println("Congratulations! You have destroyed all the Player Board ships");
                break;
            }

        }
        scanner.close();

    }


}
