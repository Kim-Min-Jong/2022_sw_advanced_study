package oop;

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child(111,222,333);
		child.showSub();
	}

}
class Parent {
	   private int num = 10;
	   private int serial = 100;
	   
	   // this
	   public int getNum() {
	      return this.num;
	   }
	   
	   public void setNum(int num) {
	      this.num = num;
	   }
	   
	   public Parent() {}
	   public Parent(int num) {
	      this.num = num;
	   }
	   
	   // this()
	   public Parent(int num, int serial) {
	      this(num);
	      this.serial = serial;
	   }
	   
	   public void showParent() {
	      System.out.println(this.num);
	      System.out.println(this.serial);
	   }
	}

	class Child extends Parent{
	   public int numSub = 20;
	   
	   // super()
	   public Child(int num, int serial, int numSub) {
	      super(num, serial);
	      this.numSub = numSub;
	   }
	   
	   public void showSub() {
	      super.showParent();
	      System.out.println(this.numSub);
	   }
	}