package chess;

public class Piece {

	   private boolean available;
	    private int x;
	    private int y;
	    private boolean color;
	    public boolean castle;
		public boolean enpassant_kill;
	    public Piece(boolean available, int x, int y,boolean color) {
	        super();
	        this.available = available;
	        this.x = x;
	        this.y = y;
	        this.castle=false;
	        this.enpassant_kill=false;
	        this.setColor(color);//0-black, 1-white
	    }


	    public boolean isAvailable() {
	        return available;
	    }
	    public void setAvailable(boolean available) {
	        this.available = available;
	    }
	    public int getX() {
	        return x;
	    }
	    public void setX(int x) {
	        this.x = x;
	    }
	    public int getY() {
	        return y;
	    }
	    public void setY(int y) {
	        this.y = y;
	    }

	    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){//have to check if there are no pieces between them
	        if(toX == fromX && toY == fromY)
	            return false; //cannot move nothing
	        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7)
	            return false;
	        if(board.getSpot(toX,toY).piece!=null){
	        	if(board.getSpot(toX,toY).piece.getColor()==board.getSpot(fromX,fromY).piece.getColor())
	        		return false;//cannot kill same color
			}
	       
	        return true;
	    }


		public boolean getColor() {
			return color;
		}


		public void setColor(boolean color) {
			this.color = color;
		}

	
	
}
