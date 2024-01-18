package Laba6;
import java.util.Comparator;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Kafedra> kafedras = new ArrayList<>();
        ArrayList<Raspis> raspis = new ArrayList<>();
        ArrayList<Scores> scores = new ArrayList<>();
        students.add(new Student("Сидоров Сидор Сидорович", "И-10"));
        students.add(new Student("Александров Александр Александрович", "Пин-20"));
        students.add(new Student("Егоров Егор Егорович", "Фи-10"));
        kafedras.add(new Kafedra("Документальная", "И-10", "Юристы"));
        kafedras.add(new Kafedra("Информационная", "Пин-20", "Информационная безопасность"));
        kafedras.add(new Kafedra("Медицинская", "Фи-10", "Хирурги"));
        raspis.add(new Raspis("И-10", "Область права"));
        raspis.add(new Raspis("Пин-20", "ООП"));
        raspis.add(new Raspis("Фи-10", "Латинский язык"));
        scores.add(new Scores("Сидоров Сидор Сидорович", "И-10", "Область права", "Отлично"));
        scores.add(new Scores("Александров Александр Александрович", "Пин-20", "ООП", "Замечательно"));
        scores.add(new Scores("Егоров Егор Егорович", "Фи-10", "Латинский язык", "Хорошо"));


        Comparator<Student> cmprt= new StComparator();// Использование компаратора
        students.sort(cmprt);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).Fio);
        }
        System.out.println("---");
        System.out.println(findInfo(students.get(1).Fio, students, kafedras, scores)); // Вывод информации об одном из

    }
    public static String findInfo(String Fio, ArrayList<Student> students, ArrayList<Kafedra> kafedras, ArrayList<Scores> scores){
        String gr = "";
        String kaf = "";
        String spec = "";
        String obj = "";
        String score = "";
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).Fio == Fio){
                gr = students.get(i).group;
            }
        }
        for (int i = 0; i < kafedras.size(); i++) {
            if (kafedras.get(i).group == gr){
                kaf = kafedras.get(i).name;
                spec = kafedras.get(i).spec;
            }
        }
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).Fio == Fio){
                obj = scores.get(i).obj;
                score = scores.get(i).score;
            }
        }
        return "Студент " + Fio + "\n" + "Группа " + gr + "\n" + "Кафедра " + kaf + "\n"
                + "Специальность " + spec + "\n" + "Предмет " + obj + "\n" + "Оценка " + score + "\n";
    }

}
class StComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.Fio.compareTo(o2.Fio);
    }
}
class  Student{
    public Student(String f, String gr){
        Fio=f;
        group=gr;
    }
    public String Fio;
    public String group;


}
class Kafedra{
    public Kafedra(String name, String group, String spec){
        this.name = name;
        this.group = group;
        this.spec = spec;
    }
    String name;
    public String group;
    String spec;
}
class Raspis{
    public Raspis(String group, String obj){
        this.group = group;
        this.obj = obj;
    }
    public String group;
    String obj;
}
class Scores{
    public Scores(String Fio, String group, String obj, String score){
        this.Fio = Fio;
        this.group = group;
        this.obj = obj;
        this.score = score;
    }
    public String Fio;
    public String group;
    String obj;
    String score;
}
