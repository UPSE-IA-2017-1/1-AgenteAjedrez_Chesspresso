package ec.edu.upse.ia.chess;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;

import chesspresso.src.main.java.me.desht.chesspresso.game.Game;
import chesspresso.src.main.java.me.desht.chesspresso.game.GameHeaderModel;
import chesspresso.src.main.java.me.desht.chesspresso.game.GameModel;
import chesspresso.src.main.java.me.desht.chesspresso.game.view.GameBrowser;
import chesspresso.src.main.java.me.desht.chesspresso.pgn.PGN;
import chesspresso.src.main.java.me.desht.chesspresso.pgn.PGNReader;
import chesspresso.src.main.java.me.desht.chesspresso.pgn.PGNSyntaxError;

public class AjedrezBuscando {

	public static void main(String[] args) throws PGNSyntaxError, IOException {
		// TODO Auto-generated method stub'
		File f = new File("D:\\Users\\ivans\\workspace\\ChessSearchGame\\PGN_Files\\test.pgn");
		System.out.println(f.getPath());
		InputStream in = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(in);
		PGNReader miPGNReader = new PGNReader(f.getPath());
		Game juegoAdam = miPGNReader.parseGame();
		//GameHeaderModel miHeaderModel = new GameHeaderModel(in, mode)
		//GameModel miModelo = new GameModel(headerModel, moveModel)
		System.out.println(juegoAdam.toString());
		//System.out.println(juegoAdam);
		GameBrowser miJuegoDibujado = new GameBrowser(juegoAdam);
		//System.out.println(juegoAdam.getModel().getMoveModel().getMove(3));
		miJuegoDibujado.createImage(200, 200);
		miJuegoDibujado.repaint();
		miJuegoDibujado.setVisible(true);
		//miJuegoDibujado.show();
		
		
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame();
	    frame.setTitle("Agente DerrotaTigreros");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JLabel label = new JLabel("Mi Ajedrez");
	    frame.add(label);
	    frame.add(miJuegoDibujado);
	    frame.pack();
	    frame.setVisible(true);
	}

}
