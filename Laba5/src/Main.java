import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Applicant {
    private String lastName;
    private String firstName;
    private String middleName;
    private String gender;
    private String nationality;
    private String dateOfBirth;
    private String address;
    private List<Integer> examScores;
    private double passingScore;

    public Applicant(String lastName, String firstName, String middleName, String gender, String nationality,
                     String dateOfBirth, String address, List<Integer> examScores, double passingScore) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.examScores = examScores;
        this.passingScore = passingScore;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public List<Integer> getExamScores() {
        return examScores;
    }

    public double getPassingScore() {
        return passingScore;
    }

    public static String printSorted(List<Applicant> applicants) {
        StringBuilder result = new StringBuilder();
        Collections.sort(applicants, (a1, a2) -> a1.getLastName().compareTo(a2.getLastName()));
        for (Applicant applicant : applicants) {
            result.append("Фамилия: ").append(applicant.getLastName()).append("\\n");
            result.append("Имя: ").append(applicant.getFirstName()).append("\\n");
            result.append("Отчество: ").append(applicant.getMiddleName()).append("\\n");
            result.append("Пол: ").append(applicant.getGender()).append("\\n");
            result.append("Национальность: ").append(applicant.getNationality()).append("\\n");
            result.append("Дата рождения: ").append(applicant.getDateOfBirth()).append("\\n");
            result.append("Домашний адрес: ").append(applicant.getAddress()).append("\\n");
            result.append("Оценки по экзаменам: ").append(applicant.getExamScores()).append("\\n");
            result.append("Проходной балл: ").append(applicant.getPassingScore()).append("\\n\\n");
        }
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        List<Applicant> applicants = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("applicants.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 8) {
                    List<Integer> scores = new ArrayList<>();
                    for (int i = 7; i < data.length - 1; i++) {
                        if (!data[i].isEmpty()) {
                            scores.add(Integer.parseInt(data[i]));
                        } else {
                            System.out.println("Пустая строка: " + line);
                        }
                    }
                    if (!data[data.length - 1].isEmpty()) {
                        double passingScore = Double.parseDouble(data[data.length - 1]);
                        Applicant applicant = new Applicant(data[0], data[1], data[2], data[3], data[4], data[5], data[6], scores, passingScore);
                        applicants.add(applicant);
                    } else {
                        System.out.println("Пустая строка: " + line);
                    }
                } else {
                    System.out.println("Неправильный формат данных: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Applicant applicant : applicants) {
            if (applicant.getPassingScore() > 4) {
                System.out.println("Проходной балл больше 4:");
                System.out.println("Фамилия: " + applicant.getLastName());
                System.out.println("Имя: " + applicant.getFirstName());
                System.out.println("Проходной балл: " + applicant.getPassingScore());
                System.out.println();
            }
        }

    }
}
