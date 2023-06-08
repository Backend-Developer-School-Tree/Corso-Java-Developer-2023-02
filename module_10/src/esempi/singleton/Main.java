package esempi.singleton;

public class Main {
    public static void main(String[] args) {
        SpiderMan s1 = SpiderMan.getInstance();
        SpiderMan s2 = SpiderMan.getInstance();
        System.out.println(s1 == s2);
    }
}
