import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataGenerator dataGen = new DataGenerator();

        List<Student> listaStudentow = new ArrayList<>();
        listaStudentow = dataGen.listOfStudents();

        List<Class> listaClass = new ArrayList<>();
        listaClass = dataGen.listaKlas();

        for(Student student1 : listaStudentow)
            System.out.println(student1);

        for(Class class1 : listaClass)
            class1.summary();

        MainWindow window = new MainWindow(listaClass, listaStudentow);
    }
}