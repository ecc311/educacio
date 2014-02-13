package educacio;

import java.sql.Connection;
import java.sql.ResultSet;
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
		
		if (alumne.getIdPersona()>9000)
		{
			setProfessor(alumne);
		}else{
			
			setAlumne(alumne);
		}
	}
	void setAlumne(Persona alumne){
		
		init();
		try {
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO alumne SET idalumne='"+alumne.getIdPersona()+"',nom='"+alumne.getNomPersona()+"',edat='"+alumne.getEdatPersona()+"',horari='"+alumne.getHorariPersona()+"',password='"+alumne.getPasswordPersona()+"',grup='"+alumne.getGrupPersona()+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	void setProfessor(Persona alumne){
		
		init();
		try {
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO professor SET idprofessor='"+alumne.getIdPersona()+"',nom='"+alumne.getNomPersona()+"',edat='"+alumne.getEdatPersona()+"',password='"+alumne.getPasswordPersona()+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Persona getPersona(int id,String password){
			
			if (id>9000)
			{
				//return this.persona.getProfessor();
				return getProfessor(id, password);
				
			}else{
				
				return getAlumne(id,password);
			}
			
		}
		
	
	Persona getProfessor(int id,String password){
		
		int idp=0;
		String nom="";
		int edat=0;

		init();
		try {
			Statement stmt = conn.createStatement();
			sql = "SELECT idprofessor,nom,edat FROM professor WHERE idprofessor='"+id+"' AND password='"+password+"'";
			ResultSet aux=stmt.executeQuery(sql);
			aux.beforeFirst();
			aux.next();
			idp=aux.getInt("idprofessor");
			nom=aux.getString("nom");
			edat=aux.getInt("edat");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Professor professor=new Professor();
		
		professor.setIdPersona(idp);
		professor.setEdatPersona(edat);
		professor.setNomPersona(nom);
		return professor;
	
	}
	
	
	Persona getAlumne(int id,String password){
		
		int ida=0;
		String nom="";
		int edat=0;
		int grup=0;
		
		
		init();
		try {
			Statement stmt = conn.createStatement();
			sql = "SELECT idalumne,nom,edat,grup FROM alumne WHERE idalumne='"+id+"' AND password='"+password+"'";
			ResultSet aux=stmt.executeQuery(sql);
			//aux.next();
			aux.beforeFirst();
			aux.next();
			ida=aux.getInt("idalumne");
			nom=aux.getString("nom");
			edat=aux.getInt("edat");
			grup=aux.getInt("grup");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (grup==1)
		{
			AlumneMati alumne=new AlumneMati();
			
			alumne.setIdPersona(ida);
			alumne.setEdatPersona(edat);
			alumne.setNomPersona(nom);
			alumne.setGrupPersona();
			alumne.setHorariPersona();
			
			return alumne;
			
		}else
		{
			AlumneTarda alumnet=new AlumneTarda();
			
			alumnet.setIdPersona(ida);
			alumnet.setEdatPersona(edat);
			alumnet.setNomPersona(nom);
			alumnet.setGrupPersona();
			alumnet.setHorariPersona();
			
			return alumnet;
		}

	
	
	}
	
	
	public void setAssignatura(Persona persona,int id){
		
		
	}
}
