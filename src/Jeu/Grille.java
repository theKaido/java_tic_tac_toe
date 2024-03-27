package Jeu;

import player.Player;

public class Grille {

	// CHAMPS
	private CasesDeLaGrille[] cases; // structure de donnée qui va contenir les cases
	
	// CONSTRUCTEUR
	// on va gerer les cases de la grille de notre morpion
	public Grille() {
		this.cases = new CasesDeLaGrille[9]; // on instacie le tableau
		
		// on instancie les elements du tableau
		for (int i = 0; i < 9; ++i) {
			this.cases[i] = new CasesDeLaGrille(i); 
		}
	}
	
	//GETTERS / SETTERS 
	private Player getPieceCase(int id) {
		return this.cases[id].getProprietairePiece();
	}
	
	public void setPieceCase(int caseId, PieceDuJeu piece) {
		this.cases[caseId].setPiece(piece);
	}
	
	// METHODS PRIVEE
	private Player getLigneGagnante() { // pour récuperer le gagnant si un joueur a trois pieces alignees sur la meme ligne
		Player gagnant = null;
		
		for (int ligne = 0; ligne < 3; ++ligne) {
			Player player = getPieceCase(0 + ligne * 3);
			
			if (player == null)
				continue;
			
			if (player.equals(getPieceCase(1 + ligne * 3))) { // le numero de l'element de la ligne + numero de la ligne * nombre d'element par ligne
				if (player.equals(getPieceCase(2 + ligne * 3))) {
					gagnant = player;
					break;
				}
			}
		}
		
		return gagnant;
	}
	
	private Player getColonneGagnante() { // pour récuperer le gagnant si un joueur a trois pieces alignees sur la meme colonne
		Player gagnant = null;
		
		for (int colonne = 0; colonne < 3; ++colonne) {
			Player player = getPieceCase(colonne + 0 * 3);
			
			if (player == null)
				continue;
			
			if (player.equals(getPieceCase(colonne + 1 * 3))) { // le numero de la colonne + numero de la case dans la colonne * nombre d'element par ligne
				if (player.equals(getPieceCase(colonne + 2 * 3))) {
					gagnant = player;
					break;
				}
			}
		}
		
		return gagnant;
	}
	
	// METHODS
	//fonction qui va renvoyer le gagnant
	public Player getGagnant() {
		Player gagnant = null;
		
		gagnant = getLigneGagnante();
		if (gagnant != null)
			return gagnant;
		
		gagnant = getColonneGagnante();
		if (gagnant != null)
			return gagnant;
		
		Player player = getPieceCase(0);
		if (player != null && player.equals(getPieceCase(4))) { // pour récuperer le gagnant si un joueur a trois pieces alignees sur la diagonale allant de la case 0 à la case 8
			if (player.equals(getPieceCase(8))) {
				return player;
			}
		}
		
		player = getPieceCase(2);
		if (player != null && player.equals(getPieceCase(4))) { // pour récuperer le gagnant si un joueur a trois pieces alignees sur la diagonale allant de la case 2 à la case 6
			if (player.equals(getPieceCase(6))) {
				return player;
			}
		}
		
		return gagnant;
	}
	
	//fonction qui va renvoyer si la grille est pleine
	public boolean pleine() {
		boolean pleine = true;
		
		for(int i = 0; i < 9; ++i)
		{
			if (this.cases[i].vide()) {//on verifie si on a au moins une case vide
				pleine = false; // donc notre grille n'est pas pleine
				break;
			}
		}
		return pleine;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("│ ").append(this.cases[0]).append(" │ ").append(this.cases[1]).append(" │ ").append(this.cases[2]).append(" │").append(System.lineSeparator());
		builder.append("-------------").append(System.lineSeparator());
		builder.append("│ ").append(this.cases[3]).append(" │ ").append(this.cases[4]).append(" │ ").append(this.cases[5]).append(" │").append(System.lineSeparator());
		builder.append("-------------").append(System.lineSeparator());
		builder.append("│ ").append(this.cases[6]).append(" │ ").append(this.cases[7]).append(" │ ").append(this.cases[8]).append(" │").append(System.lineSeparator());
		builder.append("-------------").append(System.lineSeparator());
		
		
		return builder.toString();
	}
}
