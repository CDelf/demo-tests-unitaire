package fr.diginamic.enumerations;

import java.text.Normalizer;

/**
 * Représente une saison et fournit les 4 instances de saisons.
 * 
 * @author DIGINAMIC
 *
 */
public enum Saison {

	/** Les 4 instances de Saison */
	PRINTEMPS("Printemps", 1), ETE("Eté", 2), AUTOMNE("Automne", 3), HIVER("Hiver", 4);

	/** libelle */
	private String libelle;
	/** ordre */
	private int ordre;

	/**
	 * Constructeur
	 * 
	 * @param libelle libellé
	 * @param ordre   ordre
	 */
	private Saison(String libelle, int ordre) {
		this.libelle = libelle;
		this.ordre = ordre;
	}

	/**
	 * Permet de rechercher une Saison à partir de son libellé
	 * 
	 * @param libelle libellé
	 * @return {@link Saison}
	 */
	public static Saison valueOfLibelle(String libelle) {
		if (libelle == null) return null;
		String normalizedInput = Normalizer
				.normalize(libelle.trim(), Normalizer.Form.NFD)
				.replaceAll("\\p{M}", "") // supprime les accents
				.toLowerCase();

		for (Saison saison : Saison.values()) {
			String normalizedLibelle = Normalizer
					.normalize(saison.getLibelle(), Normalizer.Form.NFD)
					.replaceAll("\\p{M}", "") // supprime les accents
					.toLowerCase();

			if (normalizedInput.equals(normalizedLibelle)) {
				return saison;
			}
		}
		return null;
	}


	@Override
	public String toString() {
		return ordre + ". " + libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the ordre
	 */
	public int getOrdre() {
		return ordre;
	}
}