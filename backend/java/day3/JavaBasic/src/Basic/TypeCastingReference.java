package basic;

public class TypeCastingReference {
	public static void main(String[] args) {
	      A a = new A();
	      B b = new B();
	      A ab = new B();
//	      B ba = new A(); // error
	}
}
class A {}
class B extends A {}