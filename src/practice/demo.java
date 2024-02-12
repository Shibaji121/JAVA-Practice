package practice;

public class demo extends demo1 {
    public final int a;

    public demo(int a) {
        super();
        this.a = a;
    }

    public void method() {
        System.out.println("Method in demo class");
    }
    public void method(int i) {
        System.out.println("overloaded");
        int k = super.i;
    }
    public String method(String k) {
        System.out.println("return type changed overlaped");
        return "ABC";
    }
    protected void finalize(){

    }
    public static void main(String[] args) {
        new demo(1).method();
        new demo(2).method(2);
        new demo(3).method("ABC");

    }
}
