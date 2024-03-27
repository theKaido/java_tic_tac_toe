package Jeu;

import player.Player;

public class CasesDeLaGrille {

	// CHAMPS
	private int id; // on identifie les cases de la grille par un identifiant
	private PieceDuJeu content; // ici le contenu de la case
	
	// CONSTRUCTEUR
	public CasesDeLaGrille(int caseId) {
		this.id = caseId;
		this.content = null; // dans le cas ou la grille est vide
	}
	
	public CasesDeLaGrille(int caseId, PieceDuJeu piece) {
		this.id = caseId;
		this.content = piece;
	}
	
	// GETTERS / SETTERS
	public void setPiece(PieceDuJeu piece) {
		this.content = piece; // on va remplacer la piece null par la valeur qui aura ete defini	
	}
	
	public Player getProprietairePiece() {
		if (this.content != null)
			return this.content.getProprietaire(); // on accede au proprietaire de la piece situe dans la case
		else
			return null;
	}
		
	// METHODS
	public boolean vide() {
		return this.content == null; // dans le cas où le contenu est null donc c'est que c'est vide
	}
	
	@Override
	public String toString() {
		if (this.content != null)
			return this.content.toString(); 
		else
			return Integer.toString(this.id); // on renvoie l'id de la case, on converti un entier en chaine de charactere
	}
}
