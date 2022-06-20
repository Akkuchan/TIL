package com.codestates.coplit;

public class Solution {
  public int sumTo(int num){
    //TODO..
    int k = 0;
    if(num<=1)return num;
    else return  k = num + sumTo(num-1);

  }
}

--------------------------

----------------------------
package com.codestates.coplit;

public class Solution {
	public int factorial(int num){
    //TODO..
    if(num==0) return 1;

     return num*factorial(num-1);
  }
}
--------------------
package com.codestates.coplit;

public class Solution {
	public int fibonacci(int num){
		//TODO..
    if(num<=1) return num;

      int[] fibo = new int [16];
        fibo[0]=0;
        fibo[1]=1;
      return  fibo[num] = fibonacci(num-1) + fibonacci(num-2);



	}
}
---------------------------
package com.codestates.coplit;
import java.util.*;

public class Solution {
	public int arrSum(int[] arr){
    //TODO..
      int k = arr.length;
    if(k==0) return 0;
      int head = arr[0] ; // 첫 인덱스 값ㄷ 저장
     int[] tail = Arrays.copyOfRange(arr, 1, k);// 첫 인덱스 값을 제외한 1번부터의 배열을 복사하여 새로운 배열로 옮기기

      return head + arrSum(tail);




  }
}
-----------------------
package com.codestates.coplit;
import java.util.*;

public class Solution {
	public int arrProduct(int[] arr){
    // TODO:
    int k = arr.length;
    if(k==0) return 1;
      int head = arr[0] ; // 첫 인덱스 값 저장
     int[] tail = Arrays.copyOfRange(arr, 1, k);// 첫 인덱스 값을 제외한 1번부터의 배열을 복사하여 새로운 배열로 옮기기

      return head * arrProduct(tail);
	}
}
--------------------------
package com.codestates.coplit;
import java.util.*;

public class Solution {
	public int arrLength(int[] arr){
    // TODO:

    if(arr.length==0) return 0;


    int head = arr.length;
    int[] tail = Arrays.copyOfRange(arr, 1, head);

    return  (head -arrLength(tail))*head;
	}
}
-----------------------
package com.codestates.coplit;
import java.util.*;

public class Solution {
	public int[] drop(int num, int[] arr){
    // TODO:
    if(num>=arr.length) return new int[0];
    if(num==0) return arr;

    int[] tail = Arrays.copyOfRange(arr, 1, arr.length);

     return drop(num-1, tail);


	}
}
----------------------------------
