package educacio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			DataSource ds = (DataSource) envContext.lookup(recurs.GetRecurs("DBconection"));
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
			sql = "INSERT INTO alumne SET id='"+alumne.getIdPersona()+"',nom='"+alumne.getNomPersona()+"',edat='"+alumne.getEdatPersona()+"',horari='"+alumne.getHorariPersona()+"',password='"+alumne.getPasswordPersona()+"',grup='"+alumne.getGrupPersona()+"'";
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
			sql = "INSERT INTO professor SET id='"+alumne.getIdPersona()+"',nom='"+alumne.getNomPersona()+"',edat='"+alumne.getEdatPersona()+"',password='"+alumne.getPasswordPersona()+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Persona getPersona(int id,String password){
			
			if (id>9000)
			{
				
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
			sql = "SELECT id,nom,edat FROM professor WHERE id='"+id+"' AND password='"+password+"'";
			ResultSet aux=stmt.executeQuery(sql);
			aux.beforeFirst();
			aux.next();
			idp=aux.getInt("id");
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
		String grup="";
		
		
		init();
		try {
			Statement stmt = conn.createStatement();
			sql = "SELECT id,nom,edat,grup FROM alumne WHERE id='"+id+"' AND password='"+password+"'";
			ResultSet aux=stmt.executeQuery(sql);
			aux.beforeFirst();
			aux.next();
			ida=aux.getInt("id");
			nom=aux.getString("nom");
			edat=aux.getInt("edat");
			grup=aux.getString("grup");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (grup.equals("Mati"))
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
		
		if (persona.getIdPersona()>9000)
		{
			//return this.persona.getProfessor();
			setAssignaturaProfessor(persona,id);
			
		}else{
			
			setAssignaturaAlumne(persona,id);
		}
	}
	
	public void setAssignaturaAlumne(Persona persona,int id){
		
		init();
		try {
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO aluassig SET idalumne=(SELECT id FROM alumne Where id='"+persona.getIdPersona()+"'),idassignatura=(SELECT id From assignatura WHERE id='"+id+"')";
			stmt.executeUpdate(sql);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void setAssignaturaProfessor(Persona persona,int id){
		
		init();
		try {
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO profassig SET idprofessor='"+persona.getIdPersona()+"',idassignatura='"+id+"'";
			stmt.executeUpdate(sql);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public ArrayList<String> getAssignatura(int id){
	
	if (id>9000)
	{
		//return this.persona.getProfessor();
		return getAssignaturaProfessor(id);
		
	}else{
		
		return getAssignaturaAlumne(id);
	}
}

public ArrayList<String> getAssignaturaProfessor(int id){
	
	ArrayList <String> cadenes=new ArrayList<String>();
	init();
	try {
		Statement stmt = conn.createStatement();
		sql = "select t3.nom, t3.id from professor as t1, profassig as t2, assignatura as t3 where t1.id='"+id+"'and t1.id=t2.idprofessor and t2.idassignatura=t3.id";
		ResultSet aux=stmt.executeQuery(sql);
		aux.beforeFirst();
		while(aux.next())
		{
		cadenes.add(aux.getString("nom"));
		}
		

	} catch (SQLException e) {
		// TODO Auto-generated catch bloc
		e.printStackTrace();
	}
	return cadenes;
}

public ArrayList <String> getAssignaturaAlumne(int id){
	
	
	ArrayList <String> cadenes=new ArrayList<String>();
	init();
	try {
		Statement stmt = conn.createStatement();
		sql = "select t3.nom, t3.id from alumne as t1, aluassig as t2, assignatura as t3 where t1.id='"+id+"'and t1.id=t2.idalumne and t2.idassignatura=t3.id";
		ResultSet aux=stmt.executeQuery(sql);
		aux.beforeFirst();
		while(aux.next())
		{
		cadenes.add(aux.getString("nom"));
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cadenes;
}

}
