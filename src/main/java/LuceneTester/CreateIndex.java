package LuceneTester;
import java.io.IOException;


public class CreateIndex {
	 static String indexDir = "D:\\Index2";
	 static String dataDir = "D:\\Data2";
	 static Indexer indexer;
	 
	 public static void main(String[] args) {
		   
	      try {
	         CreateIndex.createIndex();
	      } catch (IOException e) {
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
		      System.out.println(numIndexed+" File indexed, time taken: " +(endTime-startTime)+" ms");    
		   }
}
