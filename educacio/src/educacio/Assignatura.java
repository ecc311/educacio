package educacio;
/**
 * Clase que descriu els atributs de l'Assignatura
 * 
 * @author eric
 * 
 */

public class Assignatura {
	
	private int codi;
	private String nom;
	//private double credits;
	
	/**
	 * @return the codi
	 */
	public int getCodi() {
		return this.codi;
	}

	/**
	 * @param codi the codi to set
	 *            
	 */
	public void setCodi(int codi) {
		this.codi = codi;
	}

	/**
	 * @return the nom
	 */
	public String getNomAssignatura() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 *            
	 */
	public void setNomAssignatura(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the credits
	 */
	
	/*
	public double getCreditsAssignatura() {
		return this.credits;
	}

	/**
	 * @param credits the credits to set
	 *            
	 */
	/*
	public void setCreditsAssignatura(double credits) {
		this.credits = credits;
	}*/


}
