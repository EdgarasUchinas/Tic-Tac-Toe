import java.util.Scanner;
public class board {
	private int width;
	private int height;
	private Scanner scnr = new Scanner(System.in);
	private String[][] board;
	private int amountPlaying;
	private String[] playerSymbol = new String[]{"X", "O", "A", "B", "C", "D"};
	private int xValue;
	private int yValue;
	private int player;
	private boolean gameOver;
	private int WinningCondition;
	/*
	 * Default Constructor
	 */
	public board() {
		this.width = 0;
		this.height = 0;
		this.amountPlaying = 0;
		this.xValue = 0;
		this.yValue = 0;
		this.player = 0;
		this.gameOver = false;
		this.WinningCondition = 0;
	}
	
	/*
	 * Specialized Constructor
	 */
	public board(int width, int height, int playing, int xVal, int yVal, int player , boolean gameOver, int WinningCondition) {

		this.width = width;
		this.height = height;
		this.amountPlaying = playing;
		this.xValue = xVal;
		this.yValue = yVal;	
		this.player = player;
		this.gameOver = gameOver;
		this.WinningCondition = WinningCondition;
	}
	
	/*
	 * 
	 */
//<-----------BOARD METHODS---------------->
	
	/* 
	 * Creates the 2D Array
	 */
	public void SetBoard() {
		board = new String[this.width][this.height];
	}
	
	/*
	 * Sets Array Width
	 */
	public void setWidth() {
		System.out.println("Enter Width: ");
		this.width = scnr.nextInt();
	}
	
	/*
	 * returns Array Width
	 */
	public int getWidth() {
		return this.width;
	}
	
	/*
	 * Sets Array Height
	 */
	public void setHeight() {
		System.out.println("Enter Height: ");
		this.height = scnr.nextInt();
	}
	
	/*
	 * returns Array Height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/*
	 * Sets Array Slots to Empty
	 */
	public void GridEmpty() {
		//Assigns a Empty Space as a letter Place Holder
				for (int i = 0; i < this.width; ++i) {
					for (int j = 0; j < this.height; ++j) {
						this.board[i][j] = " ";
					}
				}    
			}
	
	/*
	 * Prints the Grid to the Console
	 */
	public void CreateGrid() {

		
		//Prints Out the Horizontal Numbers
		int i = 0;
		System.out.print("  ");
		while (i < this.width) {
			if (i < 9) {
				System.out.print(i + 1 + "   ");	
			}else {
				System.out.print(i + 1 + "  ");
			}
			++i;
		}
		System.out.println();
			
		//Prints out the Grid
		for (int w = 0; w < this.width; ++w) {
			//Prints the Vertical Numbers
			System.out.print(w + 1 + " ");
			
			//Printing the inside
			for (int h = 0; h < this.height; ++h) {
				System.out.print(board[w][h]);
				
				//Printing the Vertical Lines
				if (h != this.height - 1) {
					System.out.print(" | "); 
				}
			}
			System.out.println();
			
			//Prints Horizontal Lines
			if (w != this.width - 1) {
				System.out.print("  ");
				for (int c = 0; c < this.width; ++c) {
					if (c % 3 == 0) {
						System.out.print("---------");	
					}
				}
			}
			
			System.out.println();
	}
}
	
//<------------End of BOARD METHODS------------>
	/*
	 * 
	 */
//<------------PLAYER METHODS----------------->
	public void setAmountPlaying() {
		boolean playerCheck = false;
		do {
			System.out.println("How many people are playing: ");
			amountPlaying = scnr.nextInt();
			
			if (amountPlaying == 1 || amountPlaying == 0) {
				System.out.println("Not enough players...\n");
				continue;
			}else if (amountPlaying > 6) {
				System.out.println("Too many players...\n");
				continue;
			}else {
				playerCheck = true;
			}
			
		} while (playerCheck == false);
		
	}
	
	public int getAmountPlaying() {
		return this.amountPlaying;
	}
	
	public void setWinningCondition() {
		System.out.println("Enter Winning Condition: ");
		this.WinningCondition = scnr.nextInt();
	}
	
	public int getWinningCondition() {
		return this.WinningCondition;
	}
	
	public String getPlayerWon() {
		return this.playerSymbol[player];
	}
	
	public boolean GameOverRows() {
		//Checking Rows
		int checkRows = 0;
		for (int i = 0; i < this.width; ++i) {
			checkRows = 0;
			for (int j = 0; j < this.height; ++j) {
				if (this.board[i][j] == this.playerSymbol[this.player]) {
					++checkRows;
				}
				else if (this.board[i][j] != this.playerSymbol[this.player]) {
					checkRows = 0;
				}
				if (checkRows == this.WinningCondition) {
					this.gameOver = true;
				}
			}
		}
		//----------End of Checking Rows-------------
		return this.gameOver;
	}
	
	public boolean GameOverCols() {
		//Checking Column
		int checkCols = 0;
		for (int i = 0; i < this.width; ++i) {
			checkCols = 0;
			for (int j = 0; j < this.height; ++j) {
				if (this.board[j][i] == this.playerSymbol[this.player]) {
					++checkCols;
				}
				else if (this.board[j][i] != this.playerSymbol[this.player]) {
					checkCols = 0;
				}
				if (checkCols == this.WinningCondition) {
					this.gameOver = true;
				}
			}
		}
		return this.gameOver;
	}
	

	public void Play() {
		boolean empty = false;
		
		do {
			this.player = 0;
			while (this.player < 7) {
				
				// Enters a Value
				do {
					System.out.println("\nIt is " + "Player " + (this.player + 1) + "'s Turn\n" + "Symbol: " + playerSymbol[this.player]);
					System.out.println("Enter an X value: ");
					xValue = scnr.nextInt();
					System.out.println("Enter an Y value: ");
					yValue = scnr.nextInt();
					
					if (xValue > this.width || yValue > this.height) {
						System.out.println("One of the values is out of range...\n");
						continue;	
					}
					else if (xValue <= 0 || yValue <= 0) {
						System.out.println("One of the values is out of range...\n");
						continue;	
					}
					else if (board[xValue - 1][yValue - 1].contentEquals(" ")) {
						board[xValue - 1][yValue - 1] = playerSymbol[this.player];
						empty = true;
						if (GameOverRows() == true) {
							break;
						}
						if (GameOverCols() == true) {
							break;
						}
						CreateGrid();
						++this.player;
					} 
					else if (!board[xValue - 1][yValue - 1].isEmpty()) {
						CreateGrid();
						System.out.println("That position is already taken...");
						continue;
					}
				} while (empty == false);
				// ------------End of Entering Value
				
				if (this.player == amountPlaying) {
					this.player = 0;
				}
				if (this.gameOver == true) {
					break;
				}
				//End of First Iteration
			}
		
			
		} while (this.gameOver = false);
		
	}

	
	
	
	
	
//<-------------End of PLAYERS METHODS ---------->
	
	
	
	
	
}

