public class Main {
    public static void main(String[] args) throws Exception {
        int nose = algo("123");
        int otronose = algo("absbabs");
    }

    public static int algo(String input) throws Exception {
        try {
            return Integer.parseInt(input);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
