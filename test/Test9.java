public class Test9 {
    public static boolean foo(char c) {
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); (i < 2) && foo('B'); foo('C')) {
            i++;
            foo('D');
        }
    }
}
