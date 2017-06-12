public class Test8 {
    public static void main(String[] args) {
        int j = 10;
        System.out.println("j1: " + j);
        calculate(j);
        System.out.println("j3: " + j);
    }

    static void calculate(int j) {
        for (int i = 0; i < 10; i++) {
            j++;
        }
        System.out.println("j2: " + j);
    }
}
    