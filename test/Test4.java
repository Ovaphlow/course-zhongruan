import java.util.Hashtable;

public class Test4 {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put("100", "aaa");
        table.put("200", "bbb");
        table.put("300", "ccc");
        System.out.println(table.get("300").toString()
            + table.get("200").toString()
            + table.get("300").toString());
    }
}
    