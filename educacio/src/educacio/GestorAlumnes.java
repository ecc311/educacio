package educacio;

import educacio.Persona;

/**
 * Clase que gestiona els atributs de l'alumne
 * 
 * @author eric
 * 
 */

public class GestorAlumnes  {

	private GestorAlumnesMati alumne2=new GestorAlumnesMati();
	private GestorAlumnesTarda alumne1=new GestorAlumnesTarda();
	private int tipus;
	private static int id;
	
	/**
	 * @return the alumne
	 */
	public Persona getAlumne()
	{

		if (this.tipus==2)
		{
			return this.alumne1.getAlumne();
		}else
		{
			return this.alumne2.getAlumne();
		}

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
	public void setAlumne(String nom,int edat,int tipus,String password)
	{
		this.tipus=tipus; 
		this.id=id+1;

		switch (tipus) {
		   case 1:
			   		this.alumne2.setAlumne(id, nom, edat, tipus,password);
			   		break;

		   case 2:
		   
			   		this.alumne1.setAlumne(id, nom, edat, tipus,password);
			   		break;
		   
		  }  
		
		 }


}
