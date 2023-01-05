package Basic;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello"; // 리터럴
		String s2 = "Hello"; // 리터럴
		String s3 = new String("Hello");
		String s4 = new String("Hello");

		if (s1 == s2)
			System.out.println("s1 == s2");
		if (s3 == s4)
			System.out.println("s3 == s4"); // false
		if (s1 == s3)
			System.out.println("s1 == s3"); // false

		if (s1.equals(s2))
			System.out.println("s1 equal s2"); // true
		if (s3.equals(s4))
			System.out.println("s3 equal s4"); // true
		if (s1.equals(s4))
			System.out.println("s1 equal s4"); // true

		MyClass mc1 = new MyClass();
		MyClass mc2 = new MyClass();
		if (mc1 == mc2)
			System.out.println("mc1 == mc2");
		if (mc1.equals(mc2))
			System.out.println("mc1 equal mc2");
	}

	static class MyClass {
		String s = "Hello";

		@Override
		public boolean equals(Object o) {
			if (o == null || !(o instanceof MyClass))
				return false;
			MyClass mc = (MyClass) o; // 형변환
			// o -> mc
			// mc.s 배교 this.s // String
			if (mc.s.equals(this.s))
				return true;
			return false;
		}
	}
}
