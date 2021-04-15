import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q5 {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args){
        System.out.println(f(20));
        int[] arr = new int[21];
        arr[1] = 1;
        for(int i = 2; i < arr.length; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[arr.length - 1]);
        int[] test = new int[100];
        test[1] = 1;
        for(int i = 2; i < test.length; i++){
            test[i] = test[i - 1] + test[i - 2];
            if(test[i] >= 100000){
                System.out.println(i - 1);
                break;
            }
        }
    }
    public static int f(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int subValue1 = map.containsKey(n - 1) ? map.get(n - 1) : f(n - 1);
        int subValue2 = map.containsKey(n - 2) ? map.get(n - 2) : f(n - 2);
        int res = subValue1 + subValue2;
        map.put(n, res);
        return res;
    }
}
