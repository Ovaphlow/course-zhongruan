public class Test7 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60, 70};
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {
                s += array[i];
            }
        }
        System.out.println(s);
    }
}