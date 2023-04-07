import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class createENV {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(".env"));
        writer.println("API_KEY=Hwo9saj1hrf67uPRqBP4fcy7bq7QKZsz");
        writer.close();
    }
}
