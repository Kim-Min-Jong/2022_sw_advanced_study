package Basic;

public class TypeCastingPrimitive {
	public static void main(String[] args) {
		 // byte, short type 변수에 정수 상수를 넣으면??
	      // 우측의 상수는 int 이지만, byte, short 에 범위가 맞으면 error 발생 X
	      {
	         byte b1 = 10;
	         // byte b2 = 1000; // 오류 범위를 벗어남
	         short s1 = 1000;
	         // short s2 = 100000; // 오류 범위를 벗어남
	      }
	      
	      // 큰 것 <- 작은 것
	      // 묵시적 형 병환 처리
	      // int <- byte
	      {
	         byte b = 10;

	         int i = b;
	         System.out.println(i);
	      }

	      // 작은 것 < - 큰 것
	      // 명시적 형 변환 없으면 오류 발생
	      // byte <- int
	      {
	         int i = 10; // 127 -> 127 범위 안의 수
	         //byte b = i; // 오류
	         byte b = (byte) i;
	         System.out.println(b);
	      }
	      
	      // 명시적 형 변환의 경우 data loss 발생
	      {
	         int i = 1000; // 127 -> 127 범위 밖의 수
	         byte b = (byte) i;
	         System.out.println(b); // -24
	      }

	      // char - unicode
	      // unicode 는 ascii 코드를 포함합니다.
	      {
	         char c = 'c';
	         char u = '한';
	         
	         System.out.println(c);
	         System.out.println(u);
	      }
	      
	      // char + char
	      {
	         char c1 = 'a';
	         char c2 = 'b';
	         // char c3 = c1 + c2; // char + char = int <= operator 에 의한 int 형 변환
	         int i = c1 + c2;
	         System.out.println(i);
	      }
	      
	      // char - char
	      {
	         char a = 'a';
	         char b = 'b';
	         
	         // 두 문자의 차이
	         //char c = b - a; // 오류 발생 - int <= operator 에 의한 int 형 변환
	         int i = b - a;
	         System.out.println(i);
	      }

	      // char -> int
	      // sum 구하기
	      {
	         int sum = 0;
	         char[] charArray = {'3','2','1'};
	         for (char c : charArray) {
	            //sum += c; // 150
	            sum += c - '0';
	         }
	         
	         System.out.println(sum);
	      }
	}
}
