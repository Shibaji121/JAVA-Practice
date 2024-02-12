package practice;

public class LearnStatic {
    public static String s = "Shibaji";
    public static void method() {
        s= "Sahi";
        int a = 0;
        a++;
    }
    public static void main(String[] args) {
        String k = "Shibaji";
        String str = new String("Shibaji");
        System.out.println(k==str);
        System.out.println(k.equals(str));
        demo1 demo1 = null;
        System.out.println(demo1);
    }
}
