package collection;

import java.util.HashMap;

public class Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      HashMap<String, String> map = new HashMap<>();
	      map.put("love", "사랑하다");
	      map.put("hate", "미워하다");
	      map.put("same", "똑같다");

	      
	      String meaning = map.get("same");
	      System.out.println(meaning);

	      // foreach
	      // 순서 X
	      for( String key : map.keySet()) {
	         System.out.print(key);
	         System.out.println(" " + map.get(key));
	      }
	      
	      // key 중복 X
	      map.put("love", "사랑하다 season2"); // key 덮어 쓴다.
	      
	      map.put("equal", "똑같다"); // value 는 중복 O
	      
	      System.out.println();
	      
	      // foreach
	      for( String key : map.keySet()) {
	         System.out.print(key);
	         System.out.println(" " + map.get(key));
	      }
	}

}
