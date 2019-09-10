package chess;

public class Rook extends Piece{
	//indicating castle option available
    public Rook(boolean available, int x, int y,boolean color) {
        super(available, x, y,color);
        this.castle=true;
        // TODO Auto-generated constructor stub
    }


    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        if(toX == fromX) {
        	this.castle=false;
            return true;
        }
        if(toY == fromY) {
        	this.castle=false;
            return true;
        }
        return false;
    }
}