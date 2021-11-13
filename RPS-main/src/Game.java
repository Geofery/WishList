public class Game {
    UI ui = new UI();
    Player AI = new Computer();
    Player human = new Human();
    Menu menu = new Menu();

    public void run() {
        ui.ANSI_BLUE("Welcome to Rock Paper scissors");
        menu.printMenu();
        pickMenuOption();
    }

    public void pickMenuOption() {
        String choice;
        boolean isRunning;
        do {
            choice = ui.scanString();
            isRunning = true;
            switch (choice) {
                case "1" -> playGame();
                case "2" -> {
                    ui.ANSI_YELLOW("many stats, such wow");
                    run();
                }
                case "3" -> {
                    ui.printString("The machines have won");
                    run();
                }
                case "4" -> {
                    ui.ANSI_RED("OK....Bye");
                    isRunning = false;
                }
                default -> {
                    ui.printString("Enter nr between 1 and 4");
                    run();
                }
            }
        } while (isRunning);
    }

    public void playGame() {
        boolean run = true;
        do {
            ui.printString("----------------------------------------");
            ui.printString("Enter Rock, Paper or scissors");
            //Player gets Hand move
            Hand player1 = getHand(human.takeTurn());

            while (player1 == null) {
                player1 = getHand(human.takeTurn());
            }
            Hand player2 = getHand(AI.takeTurn());
            while (player2 == null) {
                //AI randomizes move
                player2 = getHand(AI.takeTurn());
            }
            //AI plays string but player plays Hand???
            playRound(player1, player2);
            if (AI.getPoint() == 3 || human.getPoint() == 3) {
                run = false;
            }
        }
        while (run);

        checkWinner();
        resetPoints();
        run();
    }

    //Part of stats?
    public void checkWinner() {
        if (AI.getPoint() == 3) {
            ui.printString("AI won \n");

        } else {
            ui.printString("You won! \n");
        }
    }

    public void resetPoints() {
        human.resetPoints();
        AI.resetPoints();
    }

    public void playRound(Hand player1, Hand player2) {
        if (player2.equals(Hand.SCISSORS) && player1.equals(Hand.PAPER) || player2.equals(Hand.PAPER) && player1.equals(Hand.ROCK) ||
                player2.equals(Hand.ROCK) && player1.equals(Hand.SCISSORS)) {
            ui.printString("----------------------------------------");
            ui.ANSI_RED("Your move: " + player1 + " AI move: " + player2);
            ui.ANSI_RED("Computer wins the round");
            ui.printString("----------------------------------------");
            AI.addPoint();

        } else if (player1.equals(player2)) {
            ui.printString("----------------------------------------");
            ui.printString("Your move: " + player1 + " AI move: " + player2);
            ui.printString("It's a tie");
            ui.printString("----------------------------------------");

        } else {
            ui.printString("----------------------------------------");
            ui.ANSI_GREEN("Your move: " + player1 + " AI move: " + player2 + "\n");
            ui.ANSI_GREEN("You win the round");
            ui.printString("----------------------------------------");
            human.addPoint();
        }
        displayResult();

    }

    //Pretty self-explanatory
    public void displayResult() {
        ui.printString("Your score: " + human.getPoint() + " AI score: " + AI.getPoint());
    }

    //Converts the takeTurn from string to type Hand
    public Hand getHand(String move) {
        Hand hand = null;
        switch (move) {
            case "Rock", "r", "R", "1" -> hand = Hand.ROCK;

            case "Paper", "p", "P", "2" -> hand = Hand.PAPER;

            case "Scissor", "s", "S", "3" -> hand = Hand.SCISSORS;

            default -> ui.printString("Enter either Rock, Paper or Scissor");
        }
        return hand;
    }
}