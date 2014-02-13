package educacio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Gestor {
	
	private static Connection conn;
	private String sql;
	/*
	 * inicialització del servlet.
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	
	
	public void init(){
		
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			NomRecursTxt recurs = new NomRecursTxt();
			recurs.setFitxer("C:/recursos.txt");
			DataSource ds = (DataSource) envContext.lookup(recurs.GetRecurs("ConexioBD"));
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setPersona(Persona alumne){
		/*
		if (alumne.getIdPersona()>9000)
		{
			setProfessor(alumne);
		}else{
			
			setAlumne(alumne);
		}*/
	}
	void setAlumne(Persona alumne){
		/*
		init();
		try {
			Statement stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "INSERT INTO alumne SET id='"+alumne.getIdPersona()+"',nom='"+alumne.getNomPersona()+"',edat='"+alumne.getEdatPersona()+"',grup='"+alumne.getGrupPersona()+"',horari='"+alumne.getHorariPersona()+"',password='"+alumne.getPasswordPersona()+"'";
		
		
		//ResultSet rs = stmt.executeUpdate(sql);
		
	*/
	}
	
	void setProfessor(Persona alumne){
		/*
		init();
		try {
			Statement stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "INSERT INTO professor SET id='"+alumne.getIdPersona()+"',nom='"+alumne.getNomPersona()+"',edat='"+alumne.getEdatPersona()+"',password='"+alumne.getPasswordPersona()+"'";
		
		
		//ResultSet rs = stmt.executeUpdate(sql);
		
	*/
	}
	
	
}
