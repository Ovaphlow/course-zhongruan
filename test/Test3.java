public class Test3 {
    public static void main(String[] args) {
        int b[][] = {{1, 1, 1}, {2, 2}, {3}};
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                sum += b[i][j];
            }
        }
        System.out.println(sum);
    }
}