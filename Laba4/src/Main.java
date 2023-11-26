import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFile = "Z:\\4laba\\input.txt";
        String outputFile = "Z:\\4laba\\output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length == 9) {
                    String lastName = data[0];
                    String firstName = data[1];
                    String middleName = data[2];
                    String gender = data[3];
                    String nationality = data[4];
                    String dateOfBirth = data[5];
                    String address = data[6];
                    String examScores = data[7];
                    int passingScore = Integer.parseInt(data[8]);

                    if (passingScore > 4) {
                        String outputLine = lastName + ";" + firstName + ";" + middleName + ";" + gender + ";" +
                                nationality + ";" + dateOfBirth + ";" + address + ";" + examScores + ";" + passingScore;

                        writer.write(outputLine);
                        writer.newLine();
                    }
                }
            }

            reader.close();
            writer.close();

            System.out.println("Данные про абитуриентов с проходным баллом больше 4 сохранены в файл " + outputFile);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
