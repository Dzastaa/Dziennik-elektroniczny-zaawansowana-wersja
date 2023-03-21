import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Class implements Comparable<Class>{
    String nazwaGrupy;
    List<Student> listaStudentow = new ArrayList<>();
    int maxIloscStudentow;

    Class(String nazwaGrupy1, List<Student> listaStudentow1, int maxIloscStudentow1){
        nazwaGrupy=nazwaGrupy1;
        listaStudentow=listaStudentow1;// new ArrayList<Student>();
        maxIloscStudentow=maxIloscStudentow1;
    }

    Class(String nazwaGrupy1, int maxIloscStudentow1){
        nazwaGrupy = nazwaGrupy1;
        maxIloscStudentow = maxIloscStudentow1;
    }

    Class(String nazwaGrupy1){
        nazwaGrupy = nazwaGrupy1; maxIloscStudentow = 15;
    }

    public List<Student> getListaStudentow() {
        return this.listaStudentow;
    }

    void addStudent(Student student1){
        boolean check = false;
        for(Student s1 : listaStudentow){
            if(s1.equals(student1)){
                check = true;
            }
        }

        if(check){
            System.out.println("Student: "+ student1.imie + " "+student1.nazwisko +" znajduje się na liście!");
        }
        else if(listaStudentow.size()>=this.maxIloscStudentow){
            System.err.println("Na liście brakuje miejsc!");
        }
        else{
            listaStudentow.add(student1);
            System.out.println("Student: "+ student1.imie + " "+student1.nazwisko +" został dodany!");
        }
    }

    public  void addPoints(Student student1, double iloscPunktow1){
        for(Student singleStudent : listaStudentow){
            if(singleStudent.equals(student1)){
                student1.setPunkty(student1.getPunkty()+iloscPunktow1);
            }
        }
    }
    public  void getStudent(Student student1){
        if(student1.getPunkty()<=0){
            listaStudentow.remove(student1);
        }
    }


    public void changeCondition(Student student1, StudentCondition stanStudenta1){
        for (Student singleStudent : listaStudentow){
            if (singleStudent.equals(student1)){
                student1.setStanStudenta(stanStudenta1);
            }
        }
    }
    public void removePoints(Student student1, double iloscPunktow1){
    for (Student singleStudent : listaStudentow){
        if (singleStudent.equals(student1)){
            singleStudent.setPunkty(singleStudent.getPunkty()-iloscPunktow1);
        }
    }
    }


    public Student search(String studentS){
        for (Student singleStudent : listaStudentow) {
            if (singleStudent.nazwisko.compareTo(studentS)==0){
                System.out.println("Student znajduje się w bazie!");
                return singleStudent;
            }
            else {
                System.out.println("Student nie znajduje się w bazie!");
            }
        }
        return null;
    }

    public List<Student> searchPartial(String fragment1){

        List <Student> wynikowaLista = new ArrayList();
        for( Student singleStudent : listaStudentow){
            if(singleStudent.getNazwisko().toUpperCase().contains(fragment1) || singleStudent.getImie().toUpperCase().contains(fragment1)){
                wynikowaLista.add(singleStudent);
                singleStudent.print();
            }
            if(singleStudent.getNazwisko().toLowerCase().contains(fragment1) || singleStudent.getImie().toLowerCase().contains(fragment1)){
                wynikowaLista.add(singleStudent);
                singleStudent.print();
            }
        }
        return wynikowaLista;
    }

    public int countByCondition(StudentCondition stanStudenta1){
        int iloscOsobStan=0;
        for (Student singleStudent : listaStudentow){
            if(singleStudent.getStanStudenta()==stanStudenta1){
                iloscOsobStan++;
            }
        }
        System.out.println(iloscOsobStan);
        return iloscOsobStan;
    }

    public void summary() {
        for(Student singleStudent : listaStudentow){
            singleStudent.print();
        }

    }

    public void sortByName(){

        listaStudentow.sort(new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.imie.compareTo(student2.imie);
            }
        });

    }

    public void sortByPoints(){ //sortowanie malejace
        listaStudentow.sort(this::compare);
    }

    public void max(){
        Student student =  Collections.max(listaStudentow, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.iloscPunktow, o2.iloscPunktow);
            }
        });
        System.out.println(student.iloscPunktow);
    }

    public void show(Student student1){
        student1.print();
    }


    public int compare(Student o1, Student o2) {
        return (-1)*Double.compare(o1.iloscPunktow, o2.iloscPunktow);
    }

    String getNazwaGrupy() {
        return nazwaGrupy;
    }

    void setNazwaGrupy(String s){
        this.nazwaGrupy=s;
    }

    public boolean removeStudent(Student s){
        boolean spr = false;
        int x=0;
        for(Student s1 : listaStudentow){
            System.out.println(s1.getImie()+"=="+s.getImie()+ "&&"+ s1.getPunkty()+"=="+s.getPunkty() +"&&"+ s1.getNazwisko()+"=="+s.getNazwisko());
            if(s1.getImie().equals(s.getImie()) && s1.getPunkty()==s.getPunkty() && s1.getNazwisko().equals(s.getNazwisko())){
                System.out.println("1");
                listaStudentow.remove(x);
                spr=true;
            }
            x++;
        }
        return spr;
    }


    @Override
    public int compareTo(Class o) {
        return this.nazwaGrupy.compareTo(o.nazwaGrupy);
    }
}
