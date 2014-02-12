package educacio;

/**
 * Clase que descriu els atributs de l'Alumne
 * 
 * @author eric
 * 
 */
public class AlumneTarda extends Persona {

	private int id;
	private String nom;
	private int edat;
	private String grup;
	private String horari;
	private String password;

	/**
	 * @return the id
	 */
	public int getIdPersona() {
		return this.id;
	}

	/**
	 * @param id
	 *            the idPersona to set
	 * 
	 */
	public void setIdPersona(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNomPersona() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 *            
	 */
	public void setNomPersona(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the edat
	 */
	public int getEdatPersona() {
		return this.edat;
	}

	/**
	 * @param edat the edat to set
	 *            
	 */
	public void setEdatPersona(int edat) {
		this.edat = edat;
	}
	/**
	 * @return the grup
	 */
	public String getGrupPersona() {
		return this.grup;
	}

	/**
	 * @param grup
	 *            the grup to set
	 * 
	 */
	public void setGrupPersona() {
		this.grup = "Tarda";
	}
	/**
	 * @return the horari
	 */
	public String getHorariPersona() {
		return this.horari;
	}

	/**
	 * @param grup
	 *            the horari to set
	 * 
	 */
	public void setHorariPersona() {
		this.horari = "15:00-20:00";
	}
	/**
	 * @return the password
	 */
	public String getPasswordPersona() {
		return this.password;
	}

	/**
	 * @param grup
	 *            the password to set
	 * 
	 */
	public void setPasswordPersona(String password) {
		this.password = password;
	}

}
