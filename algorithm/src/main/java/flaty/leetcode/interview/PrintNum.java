package flaty.leetcode.interview;

public class PrintNum {


    public void print(int start, int max) {
        if (start >= max) {
            System.out.println(start);
            return;
        }
        System.out.println(start);
        print(start*2,max);
        System.out.println(start);

    }


    public static void main(String[] args) {


        new PrintNum().print(1,19);
    }

}

