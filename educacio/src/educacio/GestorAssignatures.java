package educacio;

/**
 * Clase que gestiona els atributs de les assignatures
 * 
 * @author eric
 * 
 */
public class GestorAssignatures  {

	private Assignatura a = new Assignatura();

	/**
	 * @param codi
	 *            the codi to set
	 *@param nom
	 *            the nom to set
	 *@param d
	 *            the credits to set
	 * 
	 */

	public void setAssignatura(int codi, String nom, double d) {

		this.a.setCodi(codi);
		this.a.setNomAssignatura(nom);
		//this.a.setCreditsAssignatura(d);

	}

	/**
	 * @return the assignatura
	 */
	public Assignatura getAssignatura() {
		return this.a;

	}

}
