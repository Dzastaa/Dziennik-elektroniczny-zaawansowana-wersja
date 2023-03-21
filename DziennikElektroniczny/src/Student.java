public class Student implements Comparable<Student> {
    String imie;
    String nazwisko;
    StudentCondition stanStudenta;
    int rokUrodzenia;
    double iloscPunktow;
    private String numerAlbumu;

    Student(String nrAlbumu1 ,String imie1, String nazwisko1, StudentCondition stanStudenta1, int rokUrodzenia1, double iloscPunktow1){
        numerAlbumu = nrAlbumu1;
        imie=imie1;
        nazwisko=nazwisko1;
        stanStudenta=stanStudenta1;
        iloscPunktow=iloscPunktow1;
        rokUrodzenia=rokUrodzenia1;
    }

    Student(String imie1, String nazwisko1, String iloscPunktow1) {
        imie = imie1;
        nazwisko = nazwisko1;
        iloscPunktow = Double.parseDouble(iloscPunktow1);
    }

    //punkty
    public double getPunkty(){
        return iloscPunktow;
    }
    public void setPunkty(double iloscPunktow1){
        this.iloscPunktow=iloscPunktow1;
    }

    //stan studenta
    public void setStanStudenta(StudentCondition stanStudenta1){
        this.stanStudenta=stanStudenta1;
    }
    public StudentCondition getStanStudenta(){
        return this.stanStudenta;
    }

    //nazwisko i imie
    public String getNazwisko(){
        return this.nazwisko;
    }

    public String getImie() { return this.imie; }



    public void print(){
        System.out.println("Imię studenta: "+imie);
        System.out.println("Nazwisko studenta: "+nazwisko);
        System.out.println("Stan studenta: "+stanStudenta);
        System.out.println("Rok urodzenia: "+rokUrodzenia);
        System.out.println("Ilość punktów: "+iloscPunktow);
    }

    @Override
    public int compareTo(Student o) {
        return this.nazwisko.compareTo(o.nazwisko);
    }
}
