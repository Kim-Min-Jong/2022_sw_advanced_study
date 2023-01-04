package basic;

public class ClassPartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      ClassPart cp1 = new ClassPart();
	      cp1.setN(3);
	      System.out.println(cp1.n);
	      System.out.println(cp1.getN());
	      
	      ClassPart cp2 = new ClassPart(5, "Hello");
	      System.out.println(cp2.n);
	      System.out.println(cp2.getN());
	      System.out.println(cp2.str);
	}

}
