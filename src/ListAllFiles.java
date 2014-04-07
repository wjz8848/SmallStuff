import java.io.File;
import java.io.IOException;

public class ListAllFiles {

	public static void main(String[] args) {
		
		File Dir;
		if(args.length == 1){
			Dir = new File(args[0]);
			displayDirectoryContents(Dir);
		} else {
			System.err.println("Please provide the folder to Display");
		}	
	}

	public static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}