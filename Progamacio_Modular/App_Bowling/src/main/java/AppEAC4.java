
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 * @author IOC
 */
public class AppEAC4 {
    // missatges MENU
    private static final String MENUTEXT = "1) Puntuar Ronda.\n2) Mostrar tauler.\n0) Sortir.";
    private static final String DASH = "-";
    private static final int DASH_REPEAT_SHORT = 50;
    private static final int DASH_REPEAT_LONG = 85;
    private static final String TITLE_MENU = "GESTIO IOC BOWLING";


    // Informació
    private static final String TITLE_ERROR = "ERROR";
    private static final String MESSAGE_ERROR_JUGADORS = "No s'ha introduït un nombre correcte de jugadors.";
    private static final String MESSAGE_ERROR_OPTION_MENU = "No s'ha introduït un una opció valida.";
    private static final String MESSAGE_ERROR_INTEGER = "No has possat un nombre.";
    private static final String MESSAGE_ERROR_ZERO = "Has de possar una edat correcte.";
    private static final String MESSAGE_ERROR_EMPTY = "No has possat cap nom.";
    private static final String MESSAGE_ERROR_ROUND = "La ronda introduïda no existeix. Introdueixi un valor entre 1 i 10.";
    private static final String MESSAGE_ERROR_POINTS = "Els punts han de ser un valor entre 0 i 10.";

    private static final String PROMPT_PLAYER_NAME = "Introdueix el nom del jugdor.";
    private static final String PROMPT_PLAYER_LASTNAME = "Introdueixi el cognom del jugador.";
    private static final String PROMPT_AGE = "Introdueixi l'edat del jugador.";
    private static final String PROMPT_NUM_PLAYER = "Quants jugadors hi haurà?";
    private static final String PROMPT_MENU = "Introdueixi un valor enter per l'opció";
    private static final String PROMPT_SCORE_ROUND = "Introdueixi els punts per ";
    private static final String PROMPT_ROUND = "Quina ronda vols puntuar ";
    private static final String PROMPT_EXIT = "saliendo de la app....";


    private static final int NUM_MAX_ROUND = 10;
    private static final int NUM_ILIGAL_MIN = 0;
    private static final int MIN_PLAYER_ALOWED = 1;
    private static final int NUM_ILIGAL_MAX = 99;
    private static final int PUNT_MAX = 10;
    private static final int PUNT_MIN = 0;

    private static final int PLAYER_DATA_COLUMN = 3;
    private static final int COLUMN_NAME = 0;
    private static final int COLUMN_LASTNAME = 1;
    private static final int COLUMN_AGE = 2;

    private static final int SCORE_ROUND = 1;
    private static final int MOSTRAR_TAULER = 2;
    private static final int EXIT = 0;

    private int[][] pointsTotal;
    private String[][] playersData;
    private int numberPlayer;


    public static void main(String[] args) {
        AppEAC4 bowlingApp = new AppEAC4();

        bowlingApp.start();
    }

    public void start() {
        numberPlayer = askForInteger(PROMPT_NUM_PLAYER, MESSAGE_ERROR_INTEGER);
        // si el nombre jugadors és 0 o negatiu sortim del mètode.
        if (numberPlayer < MIN_PLAYER_ALOWED) {
            showError(MESSAGE_ERROR_JUGADORS);
            return;
        }

        initializePlayers(numberPlayer);
        initializePoints(numberPlayer);

        // introduim la informació dels jugadors a la matriu
        for (int i = 0; i < playersData.length; i++) {
            System.out.print(i + 1 + "/" + playersData.length + " - ");
            String name = askForString(PROMPT_PLAYER_NAME, MESSAGE_ERROR_EMPTY);

            System.out.print(i + 1 + "/" + playersData.length + " - ");
            String lastName = askForString(PROMPT_PLAYER_LASTNAME, MESSAGE_ERROR_EMPTY);

            System.out.print(i + 1 + "/" + playersData.length + " - ");
            int age = askForInteger(PROMPT_AGE, MESSAGE_ERROR_INTEGER);

            while (age <= NUM_ILIGAL_MIN || age > NUM_ILIGAL_MAX) {
                showError(MESSAGE_ERROR_ZERO);
                System.out.print(i + 1 + "/" + playersData.length + " - ");
                age = askForInteger(PROMPT_AGE, MESSAGE_ERROR_INTEGER);
            }
            playersData[i][COLUMN_NAME] = name;
            playersData[i][COLUMN_LASTNAME] = lastName;
            playersData[i][COLUMN_AGE] = String.valueOf(age);

        }
        // Menu Principal
        int optionUser;
        do {
            showMenu(MENUTEXT);
            optionUser = askForInteger(PROMPT_MENU, MESSAGE_ERROR_INTEGER);
            subMenu(optionUser);
        } while (optionUser != EXIT);


    }

    // Metodes principals de l'app

    public int[][] initializePoints(int playersNumber) {
        if (playersNumber < MIN_PLAYER_ALOWED) {
            return null;
        }
        pointsTotal = new int[playersNumber][NUM_MAX_ROUND];

        for (int i = 0; i < pointsTotal.length; i++) {
            for (int j = 0; j < NUM_MAX_ROUND; j++) {
                pointsTotal[i][j] = -1;
            }
        }
        return pointsTotal;
    }

    public String[][] initializePlayers(int playersNumber) {
        if (playersNumber < MIN_PLAYER_ALOWED) {
            return null;
        }
        playersData = new String[playersNumber][PLAYER_DATA_COLUMN];

        for (int i = 0; i < playersData.length; i++) {
            for (int j = 0; j < PLAYER_DATA_COLUMN; j++) {
                playersData[i][j] = "";
            }
        }
        return playersData;
    }

    public void showMenu(String menuText) {
        if (menuText == null || menuText.isEmpty()) {
            return;
        }
        // Construcció menu
        String titol = DASH.repeat(DASH_REPEAT_SHORT) + "\n" + TITLE_MENU + "\n" + DASH.repeat(DASH_REPEAT_SHORT) + "\n" + menuText + "\n" + DASH.repeat(DASH_REPEAT_SHORT);
        System.out.println(titol);
    }

    public void showError(String textError) {
        if (textError == null || textError.isEmpty()) {
            return;
        }
        String error = DASH.repeat(DASH_REPEAT_SHORT) + "\n" + TITLE_ERROR + "\n" + DASH.repeat(DASH_REPEAT_SHORT) + "\n" + textError;
        System.out.println(error);

    }

    public String askForString(String message, String errorMessage) {
        Scanner input = new Scanner(System.in);
        String nameUser = "";

        while (true) {
            System.out.println(message);
            nameUser = input.nextLine();

            if (!nameUser.isEmpty()) {
                return nameUser;

            } else {
                showError(errorMessage);
            }
        }
    }

    public int askForInteger(String message, String errorMessage) {
        Scanner input = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println(message);

            if (input.hasNextInt()) {
                number = input.nextInt();
                return number;
            } else {
                showError(errorMessage);
                input.nextLine();// neteja  buffer
            }

        }
    }

    public void insertPlayerNames(String[][] playersData, int rowNumber, String name, String lastName, int age) {
        if (playersData == null ||
                rowNumber < NUM_ILIGAL_MIN ||
                rowNumber > playersData.length ||
                name == null ||
                name.isEmpty() ||
                lastName == null ||
                lastName.isEmpty() ||
                age < NUM_ILIGAL_MIN) {
            return;
        }

        //  Si va be, accedim a la matriu
        playersData[rowNumber][COLUMN_NAME] = name;
        playersData[rowNumber][COLUMN_LASTNAME] = lastName;
        playersData[rowNumber][COLUMN_AGE] = String.valueOf(age);
    }

    public void setRoundPoints(int[][] pointsMatrix, int rowIndex, int round, int points) {

        if (pointsMatrix == null ||
                rowIndex < NUM_ILIGAL_MIN || rowIndex >= pointsMatrix.length ||
                round < NUM_ILIGAL_MIN || round > NUM_MAX_ROUND ||
                points < PUNT_MIN || points > PUNT_MAX) {
            return;
        }

        pointsTotal[rowIndex][round] = points;

    }

    public void showRounds(String[][] playersData, int[][] pointsMatrix) {
        // comprovacions
        if (playersData == null || pointsMatrix == null || playersData.length == NUM_ILIGAL_MIN || pointsMatrix.length == NUM_ILIGAL_MIN)
            return;
        if (playersData.length != pointsMatrix.length) {
            return;
        }
        for (int i = 0; i < pointsMatrix.length; i++) {
            if (pointsMatrix[i].length != NUM_MAX_ROUND || pointsMatrix[i] == null || playersData[i] == null) {
                return;
            }
        }
        printHeader();// printem la encapçalera
        printPlayerData(playersData, pointsMatrix);// printem les dades dels jugadors y la puntuació
    }

    public void subMenu(int optionUser) {
        switch (optionUser) {

            case SCORE_ROUND -> {
                // preguntem per el numero de ronda
                int round = getValidRound();

                // pregunten per la puntuació de cada jugador
                for (int i = 0; i < numberPlayer; i++) {
                    int point = getValidPlayerScore(i);

                    setRoundPoints(pointsTotal, i, (round - 1), point);// guardem si només la puntuació està entre 0 - 10
                }
            }
            case MOSTRAR_TAULER -> showRounds(playersData, pointsTotal);

            case EXIT -> System.out.println(PROMPT_EXIT);

            default -> showError(MESSAGE_ERROR_OPTION_MENU);
        }
    }

    public int getValidRound() {
        int round = askForInteger(PROMPT_ROUND, MESSAGE_ERROR_INTEGER);

        while (round <= NUM_ILIGAL_MIN || round > NUM_MAX_ROUND) {
            showError(MESSAGE_ERROR_ROUND);
            round = askForInteger(PROMPT_ROUND, MESSAGE_ERROR_INTEGER);
        }
        return round;
    }

    public int getValidPlayerScore(int playerIndex) {
        String namePlayer = playersData[playerIndex][COLUMN_NAME];
        String lastNamePlayer = playersData[playerIndex][COLUMN_LASTNAME];

        int point = askForInteger(PROMPT_SCORE_ROUND + namePlayer + " " + lastNamePlayer, MESSAGE_ERROR_INTEGER);

        while (point < PUNT_MIN || point > PUNT_MAX) {
            showError(MESSAGE_ERROR_POINTS);
            point = askForInteger(PROMPT_SCORE_ROUND + namePlayer + " " + lastNamePlayer, MESSAGE_ERROR_INTEGER);
        }
        return point;
    }

    public void printHeader() {
        System.out.println(DASH.repeat(DASH_REPEAT_LONG));

        // encabezado Player / Points
        System.out.printf("%-20s %-15s", "FULL NAME", "AGE");
        for (int i = 1; i <= NUM_MAX_ROUND; i++) {
            System.out.printf(" %-4s", "R" + i);

        }

        System.out.println("\n" + DASH.repeat(DASH_REPEAT_LONG));

    }

    public void printPlayerData(String[][] playersData, int[][] pointsMatrix) {
        for (int i = 0; i < playersData.length; i++) {
            System.out.printf("%-20s %-15s", playersData[i][COLUMN_NAME] + " " + playersData[i][COLUMN_LASTNAME], playersData[i][COLUMN_AGE]);

            for (int j = 0; j < pointsMatrix[i].length; j++) {
                if (pointsMatrix[i][j] == -1) {
                    System.out.printf(" %-4s", " -");
                } else {
                    System.out.printf(" %-4d", pointsMatrix[i][j]);
                }
            }
            System.out.println();  // Nova línia després de cada jugador
        }
    }
}




