import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Data.Question> questions = Data.getQuestions();

        if (questions.isEmpty()) {
            System.out.println("Tidak ada soal.");
            return;
        }

        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("=== QUIZ YES / NO ===");
        System.out.println("Jawab dengan: Yes atau No");
        System.out.println("---------------------");

        for (int i = 0; i < questions.size(); i++) {

            System.out.println((i + 1) + ". " + questions.get(i).text);
            System.out.print("Jawaban: ");
            String userAnswer = input.nextLine();

            if (userAnswer.equalsIgnoreCase(questions.get(i).answer)) {
                score++;
            }
        }

        System.out.println("---------------------");
        System.out.println("Quiz selesai!");
        System.out.println("Skor kamu: " + score + " / " + questions.size());

        input.close();
    }
}
