package Basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RuntimeExceptionTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//      String s = null;
//      s.length(); // NullPointer...
      try {
         int[] intArr = new int[3];
         int i = intArr[3];      
      }catch(Exception e) {
         throw new FileNotFoundException();
      }
	}
}

