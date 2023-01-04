package oop;
public class Interface {

	public static void main(String[] args) {
		// 상위 클래스 타입으로 선언 및 객체 생성은 가능하나 Fly 인터페이스의  메소드는 호출 X
		{
			 Animal bird = new Bird();
//			 bird.howToFly(); // 오류
			 Transportation airplane = new AirPlane();
//			 airplane.howToFly(); // 오류			
		}

		// Fly 인터페이스로 선언 및 객체 생성이 가능하고 인터페이스의 메소드도 호출 O,
		// 상위 클래스의 메소드나 멤버 변수에 접근 X
		{
			Fly bird = new Bird();
			bird.howFastFly();
			
			Fly airplane = new AirPlane();
			airplane.howToFly();

//			bird.eat(); // 오류
//			airplane.gas(); // 오류
		}
		
		// Overriding - 상속 관계
		{
			Fly bird = new Dove();
			bird.howToFly(); // Dove() 의 howToFly() 호출!! 
		}

	}

}

class Transportation {
	String serialNo;
	public void gas() {
		System.out.println("Transportation gas!!!");
	}
}

class Animal {
	int eyeCount;
	public void eat() {
		System.out.println("Animal eat!!");
	}
}

interface Fly {
	public void howToFly();
	public void howFastFly();
}


class Bird extends Animal implements Fly{

	@Override
	public void howToFly() {
		System.out.println("By Wing!!");
	}

	@Override
	public void howFastFly() {
		System.out.println("50 km/h");
	}

}

class AirPlane extends Transportation implements Fly{

	@Override
	public void howToFly() {
		System.out.println("By Engine!!");
	}

	@Override
	public void howFastFly() {
		System.out.println("500 km/h!!");
	}

}

class Dove extends Bird{
	@Override
	public void howToFly() {
		System.out.println("I've Forgetten!!");
	}
	
	@Override
	public void howFastFly() {
		System.out.println("I don't know!!");
	};
}
