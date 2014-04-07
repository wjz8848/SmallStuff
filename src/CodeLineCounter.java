import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class CodeLineCounter{
	
	 public static void main (String[] args) throws IOException { 
		 
     	if(args.length == 2){
     		codeDirectory = args[0];
     		codeType = args[1];
     		File file = new File(codeDirectory);
     		fileLister(file);
     		System.out.println("You have coded for " + numLines + " lines of " 
			 			+ codeType + " code");
     	} else {
     		System.err.println("Argument Wrong, please provide valid "
     				+ "[Directory] [Code Type e.g. java]");
     	}
	 }
	 
	 // Recursively loop thru all the subDirectory
	 public static void fileLister(File Directory) throws IOException{
		 
		 try {
				File[] files = Directory.listFiles();
				for (File file : files) {
					if (file.isDirectory()) {
						fileLister(file);
					} else {
						lineCounter(file);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
	 // Line counter
	 public static void lineCounter(File file) throws IOException{
		 
		 // File filter
		 if(file.toString().endsWith(codeType)){
			 
			 int fileLines = 0; // Display the lines for each file
			 br = new BufferedReader(new FileReader(file));
			 line = br.readLine();
			 while(line != null){
				 if(line.length() > 1){
					 numLines++;
					 fileLines++;
				 }
				 line = br.readLine();
			 }
			 
			 System.out.println("File: " + file.getPath() + " has " +
					 			fileLines + " lines.");
		 }
	 }
	
	 public static String codeDirectory;
	 public static String codeType;
	 public static int numLines = 0;
	 public static String line = null;
	 private static BufferedReader br;
}