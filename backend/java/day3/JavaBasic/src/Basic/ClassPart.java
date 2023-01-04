package basic;

public class ClassPart {
	   // member variable
	   int n;
	   String str;
	   
	   // method
	   void m1() {
	      System.out.println("m1()");
	   }
	   
	   // method getter
	   int getN() {
	      return this.n;
	   }
	   
	   // method setter
	   void setN(int n) {
	      this.n = n;
	   }
	   
	   // constructor
	   ClassPart(){
	      
	   }
	   
	   ClassPart(int n, String str){
	      this.n = n;
	      this.str = str;
	   }
}
