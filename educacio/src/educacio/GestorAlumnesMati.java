package educacio;

public class GestorAlumnesMati {
	
private AlumneMati alumne=new AlumneMati();
	
	public AlumneMati getAlumne()
	{


			return this.alumne;


	}
	/**
	 * @param codi
	 *            the codi to set
	 *@param nom
	 *            the nom to set
	 *@param edat
	 *            the edat to set
	 **@param grup
	 *            the grup to set
	 * 
	 */
	public void setAlumne(int codi,String nom,int edat,int tipus,String password)
	{
			   		
			   		this.alumne.setIdPersona(codi);
					this.alumne.setNomPersona(nom);
					this.alumne.setEdatPersona(edat);
					this.alumne.setGrupPersona();
					this.alumne.setPasswordPersona(password);
		   
		   
		  }  
		
}



