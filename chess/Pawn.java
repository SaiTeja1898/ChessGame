package chess;

public class Pawn extends Piece{
	boolean start=true;//indicating one or two steps
	private boolean check=false;
	public Pawn(boolean available, int x, int y,boolean color) {
		// TODO Auto-generated constructor stub
		super(available, x, y,color);
	}
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
      
		if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
		if(board.getSpot(fromX,fromY).piece.getColor()==true) {
			if((toX-fromX)==0&&(toY-fromY)==2) {
				if(start==true) {
					start=false;
					enpassant_kill=true;
					check= true;
				}
			}
			else
				enpassant_kill=false;
			
			if((toX-fromX)==0&&(toY-fromY)==1)
				check= true;
			if((toX-fromX)==1&&(toY-fromY)==1) {
	//			(board.getSpot(fromX, fromY)).piece.setAvailable(false);
				if(board.getSpot(toX,toY).piece.getColor()==false){
					check= true;
				}
				
			}
			
			//enpassant and promotion to be added
			if(check==true) {
				if(toY==7)
					(board.getSpot(fromX, fromY)).piece=new Queen(true, fromX, fromY,true);
				return true;
			}
			//enpassant to be added
		}
		else {
			if((toX-fromX)==0&&(toY-fromY)==-2) {
				if(start==true) {
					start=false;
					enpassant_kill=true;
					check= true;
				}
			}
			else
				enpassant_kill=false;
			
			if((toX-fromX)==0&&(toY-fromY)==-1)
				check= true;
			if((toX-fromX)==1&&(toY-fromY)==-1) {
	//			(board.getSpot(fromX, fromY)).piece.setAvailable(false);
				if(board.getSpot(toX,toY).piece.getColor()==true){
					check= true;
				}
				
			}
			
			//enpassant and promotion to be added
			if(check==true) {
				if(toY==0)
					(board.getSpot(fromX, fromY)).piece=new Queen(true, fromX, fromY,false);
				return true;
			}
			//enpassant to be added
			
		}
		return false;
	}

}
