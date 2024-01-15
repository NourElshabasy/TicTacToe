import java.util.Scanner;

public class TicTacToe
  {
    private Scanner input = new Scanner(System.in);
    private int totalWins;
    private int totalLoss;
    private int ROW;
    private int COL;
    private boolean win;
    private String[][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

    // Constructor sets all stats to 0
    public TicTacToe()
    {
      totalWins = 0;
      totalLoss = 0;
      win = false;
    }


    public void setRowCol()
    {
      System.out.print("\nEnter row: ");
      ROW = input.nextInt();
      System.out.print("Enter column: ");
      COL = input.nextInt();
    }

    // Prints the current state of the board
    public void printBoard()
    {
      int num = 0;
      System.out.println("  0 1 2");
      for(String[] boardRow : board)
        {
          System.out.print(num + " ");
          num++;
          for(String spot : boardRow)
            {
              System.out.print(spot + " ");
            }
          System.out.println();
        }   
    }

    public void resetBoard()
    {
      for(int i = 0; i <= 2; i++)
      {
        for(int k = 0; k <= 2; k++)
        {
          board[i][k] = "-";
        }
      }
    }

    public void placeX()
    {
      if (board[ROW][COL].equals("-"))
      {
        board[ROW][COL] = "X";
      }
      else
      {
        System.out.println("That spot is already taken!");
        setRowCol();
        placeX();
      }
    }

    public void placeO()
    {
      if (board[ROW][COL].equals("-"))
      {
        board[ROW][COL] = "O";
      }
      else
      {
        System.out.println("That spot is already taken!");
        setRowCol();
        placeO();
      }
    }

    public void cpuPlace()
    {
      int cpuRow = (int) (Math.random() * 3);;
      int cpuCol = (int) (Math.random() * 3);;
      
      while(!board[cpuRow][cpuCol].equals("-"))
      {
        cpuRow = (int) (Math.random() * 3);
        cpuCol = (int) (Math.random() * 3);
      }

      board[cpuRow][cpuCol] = "O";
    }

    public void checkWin()
    {
      if ((board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) || 
          (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")) || 
          (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")) || 
          (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")) || 
          (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")) || 
          (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")) || 
          (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")) || 
          (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")))
      {
        System.out.println("\nX Wins!");
        totalWins++;
        win = true;
      }
     
      if ((board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) || 
          (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")) || 
          (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) || 
          (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) || 
          (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")) || 
          (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) || 
          (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) || 
          (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")))
      {
        System.out.println("\nO Wins!");
        totalLoss++;
        win = true;
      }   
    }

    public void mainMenu()
    {
      System.out.print("\033\143");
      System.out.println("=== Welcome to TicTacToe ====");
      System.out.println("> Singleplayer");
      System.out.println("> Multiplayer");
      System.out.println("> Singleplayer Scoreboard");
      System.out.println("> Exit");
      int menuChoice = input.nextInt(); 

      if (menuChoice == 1)
      {
        singleplayer();
      }
      else if (menuChoice == 2)
      {
        System.out.print("\033\143");
        multiplayer();
      }
      else if (menuChoice == 3)
      {
        System.out.print("\033\143");
        scoreboard();
      }
      else if (menuChoice == 4)
      {
        System.out.print("\033\143");
        System.out.println("Exited...");
        System.exit(0);
      }  
      else
      {
        System.out.print("\033\143");
        System.out.println("Please enter a number 1-4");
        mainMenu();
      }
    }
    
    public void singleplayer()
    {
      System.out.print("\033\143");
      System.out.println("=== Singleplayer ===\n");

      while (true)
      {
        printBoard();
        setRowCol();
        placeX();
        System.out.println();
        printBoard();
        checkWin();
        if(win==true)
          break;
        System.out.println("\nCPU's Turn...\n");
        cpuPlace();
        checkWin();
        if(win == true)
        {
          printBoard();
          break;
        }
      }

      win = false;
      resetBoard();
      
      System.out.println("\n> Play Again");
      System.out.println("> Main Menu");
      int choice = input.nextInt();

      while(true)
      {
        if (choice == 1)
          singleplayer();
        else if (choice == 2)
          mainMenu();
        else
        {
          System.out.println("\nPlease enter 1 or 2");
          choice = input.nextInt();
        }   
      }    
    }


    public void multiplayer()
    {
      System.out.print("\033\143");
      System.out.println("=== Multiplayer ===\n");

      while (true)
      {
        printBoard();
        System.out.println("\nP1 Turn");
        setRowCol();
        placeX();
        System.out.println();
        printBoard();
        checkWin();
        if(win==true)
          break;
        System.out.println("\nP2 Turn");
        setRowCol();
        placeO();
        checkWin();
        if(win == true)
        {
          printBoard();
          break;
        }
      }

      win = false;
      resetBoard();

      System.out.println("\n> Play Again");
      System.out.println("> Main Menu");
      int choice = input.nextInt();

      while(true)
      {
        if (choice == 1)
          singleplayer();
        else if (choice == 2)
          mainMenu();
        else
        {
          System.out.println("\nPlease enter 1 or 2");
          choice = input.nextInt();
        }   
      }    
    }

    public void scoreboard()
    {
      System.out.print("\033\143");
      System.out.println("=== Scoreboard ===");
      System.out.println("Wins: " + totalWins);
      System.out.println("Losses: " + totalLoss);
      System.out.println("\nEnter 1 to return to the main menu");
      int choice = input.nextInt();

      while (choice != 1)
      {
        System.out.println("\nEnter 1 to return to the main menu");
        choice = input.nextInt();
      }

      mainMenu();
    }
  }
