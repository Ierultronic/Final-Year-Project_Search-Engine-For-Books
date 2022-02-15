package LuceneTester;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DisplayContent
 */

public class DisplayContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayContent() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//get file path from results class
		String getPrm = request.getParameter("gotu");
		
		//using scanner to read the text file
		File myObj = new File(getPrm);
       Scanner myReader = new Scanner(myObj);
        
    if(myObj.exists()) {
		myReader.useDelimiter("\\|");
		 while (myReader.hasNextLine()) {

		  String pic = myReader.next().trim();
		  String t = myReader.next().trim();
		  String aut = myReader.next().trim();
		  String page= myReader.next().trim();
		  String year= myReader.next().trim();
		  String publisher= myReader.next().trim();
		  String sumary= myReader.next().trim();
		  pw.println("<style>\r\n"
		  		+ "table {\r\n"
		  		+ "  background: white;\r\n"
		  		+ " border: 1px solid black;\r\n"
		  		+ "  width: 600px;"
		  		+ "}\r\n"
		  		+ "th{\r\n"
		  		+ " border: 1px solid black;\r\n"
		  		+ "}\r\n"
		  		+ "td{\r\n"
		  		+ " border: 1px solid black;\r\n"
		  		+ "  width: 400px;\r\n"
		  		+ "  overflow: hidden;"
		  		+ "}\r\n"
		  		+ "table.center {\r\n"
		  		+ "  margin-left: auto; \r\n"
		  		+ "  margin-right: auto;\r\n"
		  		+ "}\r\n"
		  		+ "body{\r\n"
				+ "  background: #2a2a2a;\r\n"
				+ "  font-family: 'Open Sans', sans-serif;\r\n"
				+ "} "
		  		+ "</style>");
		   pw.println("<table class=\"center\">\r\n"
		   		+ "  <tr>\r\n"
		   		+ "    <th colspan=\"2\">Book Info</th>\r\n"
		   		+ "  </tr>\r\n"
		   		+ "  <tr>\r\n"
		   		+ "    <th>Book Cover</th>\r\n"
		   		+ "    <td><img src=\""+ pic +"\" alt=\"gambau\" width=\"285\" height=\"400\"></td>\r\n"
		   		+ "  </tr>\r\n"
		   		+ "  <tr>\r\n"
		   		+ "    <th>Book Title</th>\r\n"
		   		+ "    <td>"+ t +"</td>\r\n"
		   		+ "  </tr>\r\n"
		   		+ "  <tr>\r\n"
		   		+ "    <th>Author</th>\r\n"
		   		+ "    <td>"+ aut +"</td>\r\n"
		   		+ "  </tr>\r\n"
		   		+ "  <tr>\r\n"
		   		+ "    <th>Pages Count</th>\r\n"
		   		+ "    <td>"+ page +"</td>\r\n"
		   		+ "  </tr>\r\n"
		   		+ "  <tr>\r\n"
		   		+ "    <th>Year Published</th>\r\n"
		   		+ "    <td>"+ year +"</td>\r\n"
		   		+ "  </tr>\r\n"
		   		+ "  <tr>\r\n"
		   		+ "    <th>Publisher</th>\r\n"
		   		+ "    <td>"+ publisher +"</td>\r\n"
		   		+ "  </tr>\r\n"
		   		+ "  <tr>\r\n"
		   		+ "    <th>Synopsis</th>\r\n"
		   		+ "    <td>"+ sumary +"</td>\r\n"
		   		+ "  </tr>\r\n"
		   		+ "</table>");
		 }
		
		 myReader.close();
		 }
    else {pw.println("<p>Nothing found... Try another search.</p>");}

	}

}
