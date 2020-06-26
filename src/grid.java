public class grid {
	public static void main(String[] args) {
	board grid = new board();
	
	grid.setWidth();
	
	grid.setHeight();
	
	grid.SetBoard();
	
	grid.GridEmpty();
	
	grid.setAmountPlaying();
	
	grid.setWinningCondition();
	
	grid.CreateGrid();
	
	grid.Play();
	
	
	/*
	 * Game finishing statement
	 */
	grid.CreateGrid();
	System.out.println(grid.getPlayerWon() + " Has won the game!");
	
	
		
	}
}


