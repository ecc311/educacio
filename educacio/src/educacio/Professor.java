package educacio;

/**
 * Clase que descriu els atributs del Professor
 * 
 * @author eric
 * 
 */

public class Professor extends Persona {

	private int id;
	private String nom;
	private int edat;
	private String password;

	/**
	 * @return the id
	 */
	public int getIdPersona() {
		return this.id;
	}

	/**
	 * @param id the idPersona to set
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

	@Override
	public
	String getGrupPersona() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGrupPersona() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public
	String getPasswordPersona() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public void setPasswordPersona(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}

	public String getHorariPersona(){return null;}

	public void setHorariPersona(){}

	}


