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
	@WebServlet("/Retornarassignatures")
	public class Retornarassignatures extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Retornarassignatures() {
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
	    	int i=0;
	    	
	    	ident=request.getParameter("nom");
	    	id=Integer.parseInt(ident);
	    	
	    	Gestor gestor=new Gestor();
	    	
	    	
	    	PrintWriter out = response.getWriter();

	         out.println("<html>");
	         out.println("<head></head>");         
	         out.println("<body>");
	         
	         while(i<gestor.getAssignatura(id).size())
	         {
	         out.println(gestor.getAssignatura(id).get(i));
	         out.println("<br>");
	         i++;
	         }
	         out.println("</body>");
	         out.println("</html>");           
	    }

	}

