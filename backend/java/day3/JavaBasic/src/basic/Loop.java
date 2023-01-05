package Basic;

public class Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 홀수의 제곱수 출력
		// for
		// i => 1, 3, 5, 7, 9
		for (int i = 0; i < 10; i++) {

			if (i % 2 == 0)
				continue;
			System.out.println(i * i);
		}

		System.out.println();

		// 5 미만 제곱수 출력
		// while
		int i = 0;
		while (i < 5) {
			System.out.println(i * i);
			i++;
		}

		System.out.println();

		i = 0;
		// while true
		while (true) {
			if (i >= 5)
				break;
			System.out.println(i * i);
			i++;
		}

		System.out.println();

		i = 0;
		// do while
		do {
			System.out.println(i * i);
			i++;
		} while (i < 5);
		
		for(int k = 1; k <= 5; k++) {
			for(int j = 1; j <= k; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
