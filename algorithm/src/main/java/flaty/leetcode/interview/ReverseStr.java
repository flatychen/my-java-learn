package flaty.leetcode.interview;

public class ReverseStr {


    public String reverse(String str) {
        if (str.length() == 1) {
            return str;
        }
        String subStr = str.substring(1, str.length());
        return reverse(subStr) + str.substring(0,1);
    }






    public static void main(String[] args) {
        System.out.println("ab".substring(0,2));
        String result = new ReverseStr().reverse("baiwjgg");
        System.out.println(result);
    }

}

