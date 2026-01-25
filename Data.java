import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final String URL =
        "jdbc:mysql://localhost:3306/quiz_yesno?useSSL=false&serverTimezone=UTC";
    private static final String USER = "quizuser";   // ganti jika perlu
    private static final String PASSWORD = "quiz123"; // ganti jika perlu

    public static class Question {
        public String text;
        public String answer;

        public Question(String text, String answer) {
            this.text = text;
            this.answer = answer;
        }
    }

    public static List<Question> getQuestions() {

        List<Question> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            // 🔥 HANYA 6 SOAL, ACAK
            ResultSet rs = stmt.executeQuery(
                "SELECT pernyataan, jawaban_benar FROM quiz ORDER BY RAND() LIMIT 6"
            );

            while (rs.next()) {
                list.add(new Question(
                    rs.getString("pernyataan"),
                    rs.getString("jawaban_benar")
                ));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Koneksi database gagal!");
            e.printStackTrace();
        }

        return list;
    }
}
