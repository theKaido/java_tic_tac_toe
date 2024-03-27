package game;

import java.util.Scanner;

import Jeu.Grille;
import entree.Entree;
import player.Player;

public class Game {

	// CHAMPS
	private Grille grille;
	private Player player1;
	private Player player2;
	private Player playerEnCours;
	
	// CONSTRUCTEUR
	public Game() {
		this.grille = new Grille();
		this.player1 = new Player(0, 'X');
		this.player2 = new Player(1, 'O');
	}
	
	// METHODS PRIVEE
	private void changementPlayer() {
		if (this.playerEnCours.equals(this.player1))
			this.playerEnCours = this.player2;
		else
			this.playerEnCours = this.player1;
	}
	
	private int getEntreeUtilisateur(Scanner scan) {
		int entree = -1;
		
		while (true) {
			System.out.println("Player '" + this.playerEnCours.getPiece() + "' c'est votre tour: ");
			entree = Entree.readInt(scan);
			if (0 <= entree && entree <= 8)
				break;
		}
		
		return entree;
	}
	
	// METHODS
	private void affichageGrille() {
		System.out.flush();
		System.out.println(this.grille);
	}
	
	public void start() {
		playerEnCours = this.player1;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			affichageGrille();			
			int entree = getEntreeUtilisateur(scan);
			this.grille.setPieceCase(entree, this.playerEnCours.getPiece());
			
			if (this.grille.getGagnant() != null) {
				//un joueur a gagné
				affichageGrille();	
				System.out.println("Player '" + this.playerEnCours.getPiece() + "' ! Vous gagnez la partie ! Félicitation ! ");
				break;
			} else if (this.grille.pleine()) {
				// match nul car la grille est pleine et pas de gagnant
				affichageGrille();	
				System.out.println("Match nul ! Il n'y a aucun gagnant !");
				break;
			}
			
			changementPlayer();
		}
		
		scan.close();
	}
	
}
