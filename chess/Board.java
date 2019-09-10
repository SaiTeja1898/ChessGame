package chess;

import java.util.ArrayList;
import java.util.List;

//white true black false
public class Board {
	  private Spot[][] spots = new Spot[8][8];
	  public final int PAWNS = 8;
	    public final int BISHOPS = 2;
	    public final int ROOKS = 2;
	    private List<Piece> pieces = new ArrayList<Piece>();
	    public Board() {
	        for(int i=0; i<spots.length; i++){
	            for(int j=0; j<spots.length; j++){
	                this.spots[i][j] = new Spot(i, j);
	            }
	        }
	        initializePieces();
	    }
	    public void initializePieces(){//white starts at 0 side and black at 7 side
	        
            for(int i=0; i<PAWNS; i++){ // draw pawns
            	spots[i][1].piece=new Pawn(true,i,1,true);
                pieces.add(spots[i][1].piece);
                spots[i][6].piece=new Pawn(true,i,6,false);
                pieces.add(spots[i][6].piece);
            }
            //white
            spots[0][0].piece=new Rook(true, 0, 0,true);
            pieces.add(spots[0][0].piece);
            spots[7][0].piece=new Rook(true, 7, 0,true);
            pieces.add(spots[7][0].piece);
            spots[2][0].piece=new Bishop(true, 2, 0,true);
            pieces.add(spots[2][0].piece);
            spots[5][0].piece=new Bishop(true, 5, 0,true);
            pieces.add(spots[5][0].piece);
            spots[1][0].piece=new Knight(true, 1, 0,true);
            pieces.add(spots[1][0].piece);
            spots[6][0].piece=new Knight(true, 6, 0,true);
            pieces.add(spots[6][0].piece);
            spots[3][0].piece=new Queen(true, 3, 0,true);
            pieces.add(spots[3][0].piece);
            spots[4][0].piece=new King(true, 4, 0,true);
            pieces.add(spots[4][0].piece);
            //black
            spots[0][7].piece=new Rook(true, 0, 7,false);
            pieces.add(spots[0][7].piece);
            spots[7][7].piece=new Rook(true, 7, 7,false);
            pieces.add(spots[7][7].piece);
            spots[2][7].piece=new Bishop(true, 2, 7,false);
            pieces.add(spots[2][7].piece);
            spots[5][7].piece=new Bishop(true, 5, 7,false);
            pieces.add(spots[5][7].piece);
            spots[1][7].piece=new Knight(true, 1, 7,false);
            pieces.add(spots[1][7].piece);
            spots[6][7].piece=new Knight(true, 6, 7,false);
            pieces.add(spots[6][7].piece);
            spots[3][7].piece=new Queen(true, 3, 7,false);
            pieces.add(spots[3][7].piece);
            spots[4][7].piece=new King(true, 4, 7,false);
            pieces.add(spots[4][7].piece);
        
           
        }   
	    public List<Piece> getPieces() {
	        return pieces;
	    }
	    public Spot getSpot(int x, int y) {
	        return spots[x][y];
	    }
}
