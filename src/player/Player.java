package player;

import Jeu.PieceDuJeu;

public class Player {
	
	// CHAMPS
	private int id; // id du joueur  
	private PieceDuJeu lettrepiece; // piece du joueur
	
	// CONSTRUCTEUR
	// ici le joueur sera represente par un entier et aura une piece qui lui sera associe
	public Player(int playerId, char c) {
		this.id = playerId;
		this.lettrepiece = new PieceDuJeu(c, this);
	}
	
	// GETTERS/ SETTERS
	public PieceDuJeu getPiece() {
		return this.lettrepiece; // on recupere la piece
	}
	
	// METHODS
	@Override
	//permet de comparer 2 objects 
	public boolean equals(Object autres) {
		if (autres == null) {
			return false;
		}
		
		//est-ce que mon objet "autres" est de type "Player" grace au mot cle de 
		//Java "instanceof"
		if (autres instanceof Player) {
			Player player = (Player)autres; //on caste
			return player.id == this.id;
		} else
			return false;
	}
}
