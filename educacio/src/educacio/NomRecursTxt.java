package educacio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class NomRecursTxt {
	
	private String Fitxer;
	
	public NomRecursTxt(){	}
	
	public void setFitxer(String nom){
		this.Fitxer=nom;
	}
	
	public String getFitxer(){
		return this.Fitxer;
	}
	
	public String GetRecurs(String nomRecurs){
		File f = new File( Fitxer );
		BufferedReader entrada;
		String retorn="null";
		try {
			entrada = new BufferedReader( new FileReader( f ) );
			String linea;
			nomRecurs= nomRecurs.concat("=");
			while(entrada.ready()){
				
				linea = entrada.readLine();
				if(linea.contains(nomRecurs)){
					retorn = linea.substring(nomRecurs.length());
					break;
				}
				
			}
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return retorn;
	}		
	
}
