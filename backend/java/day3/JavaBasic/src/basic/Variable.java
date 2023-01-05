package Basic;

public class Variable {

	public static void main(String[] args) {
		 // Local Variable 초기화 
	      // Local Primitive
	      int i;      
//	      System.out.println(i);
	      
	      // Local Reference
	      String s;      
//	      System.out.println(s);

	      // Member Variable 초기화
	      MyClass mc = new MyClass();
	      
	      System.out.println(mc.i);
	      System.out.println(mc.s);
	      System.out.println(mc.b);
	      
	      
	      // block 
	      {
	         int n = 10;
	         {
//	            int n = 20;
	         }
	      }
	      {
	         int n = 20;
	      }
	   }
	}

	class MyClass{
	   int i;
	   String s;
	   boolean b;
	}