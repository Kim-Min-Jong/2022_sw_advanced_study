package Basic;

public class operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;

		System.out.println(num / 3); // 3 O, 3.3333.... X
		System.out.println(num % 3); // 1

		System.out.println();

		num += 10;
		System.out.println(num);
		System.out.println(num /= 5); // 연산 후 출력

		System.out.println();

		num = 10;
		System.out.println(num++); // 10 출력 후 11로 증가
		System.out.println(++num); // 12로 증가 후 12 출력
		System.out.println(num--); // 12 출력 후 11로 감소
		System.out.println(--num); // 10 감소 후 10 출력
	}

}
