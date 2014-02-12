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

        //Escribimos el principio de la página HTML
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Parámetros del servlet desde un formulario HTML</h1>");

        //cogemos los nombres de los parametros
        Enumeration paramNames = request.getParameterNames();

        //vamos mostrando los parámetros en unwhile
        while(paramNames.hasMoreElements()) {
          //cogemos el siguiente parámetro
          String paramName = (String)paramNames.nextElement();

          //Mostramos el nombre del parámetro 	
          out.print(paramName + " = ");

          //Cogemos los valores del parámetro
          String[] paramValues = request.getParameterValues(paramName);

          //Miramos si tiene más de un valor 
          if (paramValues.length == 1) {
     	//Si tiene un sólo valor, miramos si está vacío o no
            String paramValue = paramValues[0];
            if (paramValue.length() == 0)
              out.println("<i>Sin valor</i><br>");
            else
              out.println(paramValue + "<br>");
          }
          else {
    	//Si tiene más de un sólo valor, los mostramos
            for(int i=0; i<paramValues.length; i++) 
              out.println(paramValues[i] + ", ");
    	out.println("<br>");
          }
        }//end while

        //Escribimos el final de la página HTML
        out.println("</body>");
        out.println("</html>");
        
    }
    
}



