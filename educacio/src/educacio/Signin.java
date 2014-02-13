package educacio;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import educacio.GestorAlumnes;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
    	String name;
    	String edat;
    	int age;
    	String grup;
    	int group;
    	String password;
    	String tipus;
    	int type;
    	
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
     
        name=request.getParameter("nom");
        edat=request.getParameter("edat");
   	    age=Integer.parseInt(edat);	
   	    grup=request.getParameter("grup");
   	    group=Integer.parseInt(grup);	
   	    password=request.getParameter("password");
   	    tipus=request.getParameter("type");
   	    type=Integer.parseInt(tipus);
   	    
   	    if (type==1)
   	    {
   	    	
   	    	
   	    	GestorAlumnes gestora = new GestorAlumnes();
   	   	    gestora.setAlumne(name,age,group,password);
   	   	    Gestor gestor=new Gestor();
   	   	    gestor.setPersona(gestora.getAlumne());
   	   	    out.println("<html>");
   	   	    out.println("<body>");
   	   	    out.println("<h1>"+gestora.getAlumne().getIdPersona()+"</h1>");
   	   	    out.println("</body>"); 
   	   	    out.println("</html>");
   	    }else{
   	    GestorProfessors gestorp = new GestorProfessors();
   	    gestorp.setProfessor(name,age,password);
   	    Gestor gestor=new Gestor();
   	    gestor.setPersona(gestorp.getProfessor());
   	    out.println("<html>");
   	    out.println("<body>");
   	    out.println("<h1>"+gestorp.getProfessor().getIdPersona()+"</h1>");
   	    out.println("</body>"); 
   	    out.println("</html>");
   	    

   	    }
   	    



    	    
        
    }
    
}



