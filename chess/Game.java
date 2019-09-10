package chess;


	
public class Game {
    private Board board = new Board();
    private Player white;
    private Player black;
    private boolean current_turn=true;
    private boolean winner;
    public boolean status=true;

    public void setColorWhite(Player player) {
        this.white = player;
    }

    public void setColorBlack(Player player) {
        this.black = player;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWhite() {
        return white;
    }

    public void setWhite(Player white) {
        this.white = white;
    }

    public Player getBlack() {
        return black;
    }

    public void setBlack(Player black) {
        this.black = black;
    }

    //implement move function
    public boolean move(int fromX, int fromY, int toX, int toY) {
    	boolean check=false;
    	if((board.getSpot(fromX, fromY)).piece==null)
    		return false;
    	else if((board.getSpot(fromX, fromY)).piece.getColor()!=current_turn) {
    		return false;
    	}
    	else {//if true change the location and the kill the opponent piece and if king end game
    		if(board.getSpot(fromX, fromY).piece instanceof Pawn)
    			check= board.getSpot(fromX, fromY).piece.isValid(board,fromX,fromY, toX, toY);
    		else if(board.getSpot(fromX, fromY).piece instanceof Queen)
    			check= board.getSpot(fromX, fromY).piece.isValid(board,fromX,fromY, toX, toY);
    		else if(board.getSpot(fromX, fromY).piece instanceof King)
    			check= board.getSpot(fromX, fromY).piece.isValid(board,fromX,fromY, toX, toY);
    		else if(board.getSpot(fromX, fromY).piece instanceof Knight)
    			check= board.getSpot(fromX, fromY).piece.isValid(board,fromX,fromY, toX, toY);
    		else if(board.getSpot(fromX, fromY).piece instanceof Rook)
    			check= board.getSpot(fromX, fromY).piece.isValid(board,fromX,fromY, toX, toY);
    		else if(board.getSpot(fromX, fromY).piece instanceof Bishop)
    			check= board.getSpot(fromX, fromY).piece.isValid(board,fromX,fromY, toX, toY);
    		else
    			return false;
    		if(check==true) {
    			board.getSpot(fromX, fromY).piece.setX(toX);
    			board.getSpot(fromX, fromY).piece.setY(toY);
    			//killing opposite pieces
    			if(board.getSpot(toX, toY).piece!=null) {
    				// pawn movement
    				if(board.getSpot(fromX, fromY).piece instanceof Pawn) {
    					if(toX-fromX==0)
    						return false;
    				}
    				board.getSpot(toX, toY).piece.setAvailable(false);
    				if(board.getSpot(toX, toY).piece instanceof King) {
    					this.winner=current_turn;
    					status=false;
    				}
    			}
    			board.getSpot(toX, toY).piece=board.getSpot(fromX, fromY).piece;
    			board.getSpot(fromX, fromY).piece=null;
    			current_turn=!current_turn;
    			return true;
    		}
    	
    	}
    	
		return false;
    }

	

}

