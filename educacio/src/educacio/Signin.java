package educacio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Escribimos el principio de la p�gina HTML
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Par�metros del servlet desde un formulario HTML</h1>");

        //cogemos los nombres de los parametros
        Enumeration paramNames = request.getParameterNames();

        //vamos mostrando los par�metros en unwhile
        while(paramNames.hasMoreElements()) {
          //cogemos el siguiente par�metro
          String paramName = (String)paramNames.nextElement();

          //Mostramos el nombre del par�metro 	
          out.print(paramName + " = ");

          //Cogemos los valores del par�metro
          String[] paramValues = request.getParameterValues(paramName);

          //Miramos si tiene m�s de un valor 
          if (paramValues.length == 1) {
     	//Si tiene un s�lo valor, miramos si est� vac�o o no
            String paramValue = paramValues[0];
            if (paramValue.length() == 0)
              out.println("<i>Sin valor</i><br>");
            else
              out.println(paramValue + "<br>");
          }
          else {
    	//Si tiene m�s de un s�lo valor, los mostramos
            for(int i=0; i<paramValues.length; i++) 
              out.println(paramValues[i] + ", ");
    	out.println("<br>");
          }
        }//end while

        //Escribimos el final de la p�gina HTML
        out.println("</body>");
        out.println("</html>");
        
    }
    
}



