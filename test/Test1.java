public class Test1 {
    public static void main (String[] args) {
        String s = "xxxxxxxxxxxxxxx#123#456#zzzzz";
        int n = s.indexOf("#");
        System.out.println(n);
        int k = s.indexOf("#", n+1);
        System.out.println(k);
        String s2 = s.substring(n+1, k);
        System.out.println(s2);
    }
}
