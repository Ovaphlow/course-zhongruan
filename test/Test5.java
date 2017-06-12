public class Test5 {
    public static void main(String[] args) {
        String s1 = new String("abcde");
        String s2 = new String("abcde");
        boolean b1 = s1.equals(s2);
        boolean b2 = s1 == s2;
        System.out.println(b1 + " " + b2);
    }
}