package Basic;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// primitive
		int[] intArr = { 1, 2, 3, 4, 5 };

		// reference
		String[] strArr = { "Java", "JDBC", "Spring" };

		// for
		for (int i = 0; i < intArr.length; i++) {
			System.out.println(intArr[i]);
		}

		System.out.println();

		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}

		System.out.println();

		// for each
		for (int n : intArr) {
			System.out.println(n);
		}

		System.out.println();

		for (String str : strArr) {
			System.out.println(str);
		}

		// immutable
//	      intArr = { 1, 2, 3 }; // {} 은 재할당 X

		intArr = new int[2]; // new 는 가능 => 기존 배열은 Garbage

		// ArrayIndexOutOfBoundsException
		System.out.println(intArr[2]);
	}

}
