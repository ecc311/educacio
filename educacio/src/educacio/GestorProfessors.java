package educacio;

import educacio.Professor;

/**
 * Clase que gestiona els atributs del professor
 * 
 * @author eric
 * 
 */
public class GestorProfessors{
	
	static int id=9000;

	public Professor professor = new Professor();

	/**
	 * @return the professor
	 */

	public Professor getProfessor() {

		return this.professor;
	}

	/**
	 * @param codi
	 *            the codi to set
	 *@param nom
	 *            the nom to set
	 *@param edat
	 *            the edat to set
	 * 
	 */
	public void setProfessor(String nom, int edat,String password) {
		
		id=id+1;
		this.professor.setIdPersona(id);
		this.professor.setNomPersona(nom);
		this.professor.setEdatPersona(edat);
		this.professor.setPasswordPersona(password);

	}
}
