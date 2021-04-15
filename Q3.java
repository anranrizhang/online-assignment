import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

// 支持表示范围 0.000 -- 999999999999.999

public class Q3 {
    public static void main(String[] args){
        double f = 999999999999.999;
        long l = (long) f;
        BigDecimal data = new BigDecimal(f - l).setScale(3, RoundingMode.HALF_UP);
        String decimal = data.toString().substring(2);//decimal表示小数部分
        String number = Long.toString(l);// number表示整数部分
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "壹");
        map.put(2, "贰");
        map.put(3, "叁");
        map.put(4, "肆");
        map.put(5, "伍");
        map.put(6, "陆");
        map.put(7, "柒");
        map.put(8, "捌");
        map.put(9, "玖");
        map.put(0, "零");

        //整数部分提取
        int count = 0;
        int index = number.length() - 1;
        StringBuilder res = new StringBuilder();
        while(index >= 0) {
            int key = number.charAt(index) - '0';
            String value = map.get(key);//value用于储存当前位的值的大写名
            String carrier = new String();//carrier用于储存位数的大写中文名
            int length = number.length();
            if (count % 4 == 0) {
                //处理第一位
                if (count == 0) {
                    carrier = "圆";
                    res.append(carrier);
                    if (key != 0) {
                        res.append(value);
                    }
                }
                //处理万所在位
                if (count == 4) {
                    if (number.length() >= 9 && number.charAt(length - 8) == '0'
                            && number.charAt(length - 7) == '0' && number.charAt(length - 6) == '0'
                            && number.charAt(length - 5) == '0') {
                        carrier = "";
                    } else {
                        carrier = "万";
                    }
                    res.append(carrier);
                    if (key != 0) {
                        res.append(value);
                    }
                }
                //处理亿所在位
                if (count == 8) {
                    carrier = "亿";
                    res.append(carrier);
                    if (key != 0)
                        res.append(value);
                }
            }
            //处理其他位
            else {
                    if (key == 0)
                        carrier = "";
                    else {
                        if (count % 4 == 1)
                            carrier = "拾";
                        if (count % 4 == 2)
                            carrier = "佰";
                        if (count % 4 == 3)
                            carrier = "仟";
                    }
                    res.append(carrier);
                    if ( res.charAt(res.length() - 1) != '零' && res.charAt(res.length() - 1) != '圆' &&
                            res.charAt(res.length() - 1) != '万' && res.charAt(res.length()- 1) != '亿')
                        res.append(value);
            }

            count++;
            index--;
        }
        res = res.reverse();

        //小数部分提取
        count = 0;
        while(count < Math.min(decimal.length(), 3)){
            int key = decimal.charAt(count) - '0';
            String value = map.get(key);
            String carrier = new String();
            if(key != 0) {
                if (count == 0)
                    carrier = "角";
                if (count == 1)
                    carrier = "分";
                if (count == 2)
                    carrier = "厘";
                res.append(value);
                res.append(carrier);
            }
            count++;
        }
        System.out.println(res);
    }
}
