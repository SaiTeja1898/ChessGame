package chess;

public class Knight extends Piece{

    public Knight(boolean available, int x, int y,boolean color) {
        super(available, x, y, color);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;

        if(Math.abs((toX - fromX))==2&&Math.abs((toY - fromY))==1) {
        	return true;
        }
        else if(Math.abs((toX - fromX))==1&&Math.abs((toY - fromY))==2) {
        	return true;
        }
        return false;
    }

}
