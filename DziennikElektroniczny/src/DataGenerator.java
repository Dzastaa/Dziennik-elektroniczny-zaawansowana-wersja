import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    List<Student> listaStudentowBasic = new ArrayList<>();

    public List<Student> listOfStudents(){
        Student student0 = new Student("0", "Justyna", "Q", StudentCondition.chory, 2000, 2.6);
        Student student1 = new Student("1", "Anna", "W", StudentCondition.odrabiajacy, 2000, 5);
        Student student2 = new Student("2", "Weronika", "E", StudentCondition.nieobecny, 2000, 2.3);
        Student student3 = new Student("3", "Izabela", "R", StudentCondition.nieobecny, 2000, 2.3);
        Student student4 = new Student("4", "Robert", "T", StudentCondition.chory, 2000, 2.3);
        Student student5 = new Student("5", "Krzysztof", "X", StudentCondition.odrabiajacy, 2000, 2.3);
        Student student6 = new Student("6", "Danuta", "A", StudentCondition.chory, 2000, 2.3);
        Student student7 = new Student("7", "Agata", "S", StudentCondition.nieobecny, 2000, 2.3);
        Student student8 = new Student("8", "Maria", "D", StudentCondition.odrabiajacy, 2000, 2.3);
        Student student9 = new Student("9", "Bogumiła", "F", StudentCondition.chory, 2000, 2.3);
        Student student10 = new Student("10", "Helena", "G", StudentCondition.odrabiajacy, 2000, 2.3);
        Student student11 = new Student("11", "Marcin", "H", StudentCondition.odrabiajacy, 2000, 2.3);
        Student student12 = new Student("12", "Michał", "Z", StudentCondition.odrabiajacy, 2000, 2.3);
        Student student13 = new Student("13", "Bogdan", "C", StudentCondition.chory, 2000, 2.3);
        Student student14 = new Student("14", "Stanisław", "V", StudentCondition.nieobecny, 2000, 2.3);
        Student student15 = new Student("15", "Michał", "N", StudentCondition.nieobecny, 2000, 2.3);
        Student student16 = new Student("16", "Grzegorz", "M", StudentCondition.nieobecny, 2000, 2.3);

        List<Student> listaStudentow = new ArrayList<>();

        listaStudentow.add(student0);
        listaStudentow.add(student1);
        listaStudentow.add(student2);
        listaStudentow.add(student3);
        listaStudentow.add(student4);
        listaStudentow.add(student5);
        listaStudentow.add(student6);
        listaStudentow.add(student7);
        listaStudentow.add(student8);

        listaStudentowBasic = listaStudentow;
        return listaStudentow;
    }

    public List<Class> listaKlas(){
        Class grupa1 = new Class("GL01", 12);
        grupa1.addStudent(listaStudentowBasic.get(0));
        grupa1.addStudent(listaStudentowBasic.get(1));
        grupa1.addStudent(listaStudentowBasic.get(2));

        Class grupa2 = new Class("GL02", 12);
        grupa2.addStudent(listaStudentowBasic.get(3));
        grupa2.addStudent(listaStudentowBasic.get(4));
        grupa2.addStudent(listaStudentowBasic.get(5));
        grupa2.addStudent(listaStudentowBasic.get(6));

        Class grupa3 = new Class("GL03", 12);
        grupa3.addStudent(listaStudentowBasic.get(7));
        grupa3.addStudent(listaStudentowBasic.get(8));

        List<Class> listaClass = new ArrayList<>();
        listaClass.add(grupa1);
        listaClass.add(grupa2);
        listaClass.add(grupa3);
        return listaClass;
    }
}
