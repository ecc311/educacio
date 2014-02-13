package educacio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecuperacionUsuario
 */
@WebServlet("/RecuperacionUsuario")
public class RecuperacionUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperacionUsuario() {
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
    	String ident;
    	int id;
    	String password;
    	
    	ident=request.getParameter("nom");
    	id=Integer.parseInt(ident);
    	password=request.getParameter("password");
    	
    	Gestor gestor=new Gestor();
    	
    	
    	PrintWriter out = response.getWriter();

         out.println("<html>");
         out.println("<head></head>");         
         out.println("<body>");

         out.println(gestor.getPersona(id,password).getNomPersona());
         out.println("<br>");
         out.println(gestor.getPersona(id,password).getEdatPersona());         
         out.println("<br>");
         out.println(gestor.getPersona(id,password).getGrupPersona());
         out.println("<br>");
         out.println(gestor.getPersona(id,password).getHorariPersona());
         out.println("<br>");     
         out.println("</body>");
         out.println("</html>");           
    }

}