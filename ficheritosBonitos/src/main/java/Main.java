import java.io.*;

public class Main {
    public static void main(String[] args){
        try {
            FileReader reader = new FileReader("C:\\Users\\Keloc\\IdeaProjects\\ficheritosBonitos\\src\\main\\ficherito.txt");
            BufferedReader buffer = new BufferedReader (reader);
            FileWriter writer = new FileWriter("C:\\Users\\Keloc\\IdeaProjects\\ficheritosBonitos\\src\\main\\ficherito.txt", true);
            PrintWriter pw = new PrintWriter(writer, true);
            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);
            buffer.lines().forEach(line -> System.out.println(line));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
