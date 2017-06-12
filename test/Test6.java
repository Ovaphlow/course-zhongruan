import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test6 {
    public static void main(String[] args) {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));        
        while (true) {
            String str = "";
            try {
                str = buff.readLine();
            } catch (Exception e) {}
            if (str.equals("quit")) {
                break;
            }
            int x = Integer.parseInt(str);
            System.out.println(x * x);
        }
    }
}