package Jeu;

import player.Player;

public class PieceDuJeu {
	
	// CHAMPS
	private char lettrePiece; // chaque piece aura un propietaire
	private Player proprietaire; // propietaire de la piece
	
	// CONSTRUCTEUR
	public PieceDuJeu(char c, Player player) {
		this.lettrePiece = c;	
		this.proprietaire = player;
	}
	
	// GETTERS/ SETTERS
	public Player getProprietaire() {
		return this.proprietaire; // on accede au proprietaire de la piece
	}
		
	// METHODS
	@Override
	public String toString() {
		return Character.toString(this.lettrePiece); // methode static qui permet de convertir un char en chaine de charactere
	}
}
