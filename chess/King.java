package chess;

public class King extends Piece{
    public King(boolean available, int x, int y,boolean color) {
        super(available, x, y, color);
        this.castle=true;
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        if(Math.abs((toX - fromX))==2&& fromX-toX==0) {
        	if(castle) {
        		//check if no pieces are there between rook and king and rook hasn't moved and is available
        		int x;
				if(toX-fromX<0)
					x=0;
        		else
        			x=7;
        		int y;
				if((board.getSpot(fromX, fromY)).piece.getColor()==true)
        		 y=0;
        		else
        			y=7;
				int pos=board.getPieces().indexOf(new Rook(true,x,y,(board.getSpot(fromX, fromY)).piece.getColor()));
        		if(pos!=-1) {
        			//also check for the castle flag of rook;
        			if(board.getPieces().get(pos).castle) {
        				if(x==0) {
//        					board.setSpot() to be added
        					board.getPieces().get(pos).setX(3);
        				}
        				else
        					board.getPieces().get(pos).setX(5);
        				return true;
        			}
        			
        		}
        	}
        }
        if(Math.sqrt(Math.pow(Math.abs((toX - fromX)),2)) + Math.pow(Math.abs((toY - fromY)), 2) == Math.sqrt(2)){
            this.castle=false;
        	return true;
        }
        return false;
    }

}