package educacio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/ConsultBD")
public class ConsultBD extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Connection conn;
	
	public ConsultBD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
			DataSource ds = (DataSource) envContext.lookup(recurs.GetRecurs("BDconector"));
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		try {
			Statement stmt = conn.createStatement();
			String sql;

			/*sql = "SELECT id, nombre, edad, profesion FROM persona";
			ResultSet rs = stmt.executeQuery(sql);
			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String age = rs.getString("nombre");
				int first = rs.getInt("edad");
				String last = rs.getString("profesion");

				// Display values
				out.println("ID: " + id + "<br>");
				out.println(", nombre: " + age + "<br>");
				out.println(", edad: " + first + "<br>");
				out.println(", profesion: " + last + "<br>");
			}
			// out.println("</body></html>");

			out.println("Hello4");
			rs.close();
			stmt.close();*/
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
