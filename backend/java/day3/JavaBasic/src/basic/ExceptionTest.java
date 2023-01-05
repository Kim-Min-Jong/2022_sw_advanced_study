package Basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//	      File f= new File("hello");
//	      f.mkdir();
//	      
//	    try {
//			FileInputStream fis = new FileInputStream("hello.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		FileInputStream fis = new FileInputStream("hello.txt");
		
		UseFileHandle ufh = new UseFileHandle();
		ufh.useFileHandle();
	}
}

class UseFileHandle {
	public void useFileHandle() throws FileNotFoundException {
		FileHandle fh = new FileHandle();
		fh.inputHandle();
	}
}

class FileHandle {
	public void inputHandle() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("hello.txt");
	}
}
