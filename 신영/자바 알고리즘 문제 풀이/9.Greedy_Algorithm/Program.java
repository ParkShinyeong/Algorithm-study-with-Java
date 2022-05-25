public class Program {
    public static void main(String[] args) {
        String str = tryCatch();
        System.out.println(str);
    }

    public static String tryCatch() {
        try {
            System.out.println("Inside try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Inside catch");
            return "from catch";
        } finally {
            System.out.println("Inside finally");
            return "Finally";
        }
    }
}
