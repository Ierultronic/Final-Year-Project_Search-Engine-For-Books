package LuceneTester;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TotalHits;

public class results extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static String indexDir = "D:\\Index";
	static String dataDir = "D:\\Data1";
	static Searcher searcher;
	static Indexer indexer;
	static DisplayContent disp;
	
	   public results(){
		   super();
		
	   }
	   
	  
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//get query assign to the variable from JSP file
		String getParam=req.getParameter("search");
		searcher = new Searcher(indexDir);
		
		try {
			//CSS for button that look like hyperlink
			pw.println("<style>"
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
					+ "button {\r\n"
					+ "  background: none!important;\r\n"
					+ "  border: none;\r\n"
					+ "  padding: 0!important;\r\n"
					+ "  /*optional*/\r\n"
					+ "  font-family: arial, sans-serif;\r\n"
					+ "  /*input has OS specific font-family*/\r\n"
					+ "  color: #069;\r\n"
					+ "  text-decoration: underline;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "}</style>");
			//search the query process
			TopDocs hits = searcher.search(getParam);
			//print result(s)
			pw.println("<form action=\"DisplayContent\" method=\"post\">"
	         		+ "<table class=\"center\">\r\n"
	         		+ "<tr>\r\n");
			pw.println("<th>"+ hits.totalHits +" book(s) were found for \""+ getParam + "\"</th></tr>\r\n"
					+ "<tr>\r\n");
			
			for(ScoreDoc scoreDoc : hits.scoreDocs) {
		         Document doc = searcher.getDocument(scoreDoc);
		         String getPath = doc.get(LuceneConstants.FILE_PATH);
		         String getTitle = doc.get(LuceneConstants.FILE_NAME);
		         //use form and button to pass the text file path to the DisplayContent class
		         
		         pw.println("<th><button type=\"submit\" name=\"gotu\"  value="+getPath+" >"+getTitle+"</button>"
		         		+ "</th>\r\n"
		         		+ "</tr>");
		         
		      }
			
			
			
		}catch(Exception e) {
			pw.println("<p>Nothing found... Try another search.</p>");
			pw.println("<a href='Interface.jsp'><button>Back to search page</button></a>");
		}
		
		pw.println("</table>\r\n"
				+ "</form>");
	}

	
	
	
	
}
