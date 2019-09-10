package chess;

import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game chess=new Game();
		Player white=new Player(true);
		Player black=new Player(false);
		chess.setColorWhite(white);
		chess.setColorBlack(black);
		Scanner in = new Scanner(System.in); 
		int fromX,fromY,toX,toY;
		while(chess.status) {
			//take inputs from user
			fromX=in.nextInt();
			fromY=in.nextInt();
			toX=in.nextInt();
			toY=in.nextInt();
			if(chess.move(fromX,fromY,toX,toY)==false)
				System.out.print("wrong move please give correct positions\n ");
			
		}

	}

}
