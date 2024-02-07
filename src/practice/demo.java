package practice;

public class demo {
    public void method() {
        System.out.println("Method in demo class");
    }
    public void method(int i) {
        System.out.println("overloaded");
    }
    public String method(String k) {
        System.out.println("return type changed overlaped");
        return "ABC";
    }
    public static void main(String[] args) {
        new demo().method();
        new demo().method(2);
        new demo().method("ABC");
    }
}
