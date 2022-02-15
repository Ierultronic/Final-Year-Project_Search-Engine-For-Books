package LuceneTester;


import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;


public class Test {
  
   static String indexDir = "D:\\Index";
   static String dataDir = "D:\\Data1";
   static Indexer indexer;
   static Searcher searcher;

   public static void main(String[] args) {
   
      try {
         //Test.createIndex();
         Test.search("Harper Perennial Modern Classics"); // buat user input
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }
   static public void createIndex() throws IOException {
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();  
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println("<p>"+numIndexed+" File indexed, time taken: "  //kena buat html
         +(endTime-startTime)+" ms</p>");    
   }

  static public void search(String searchQuery) throws IOException, ParseException {
      searcher = new Searcher(indexDir);
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
   
      System.out.println(hits.totalHits +
         " documents found. Time :" + (endTime - startTime));
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);  //kena buat html
            System.out.println("File: "
            + doc.get(LuceneConstants.FILE_PATH));
      }  
   }
  

}