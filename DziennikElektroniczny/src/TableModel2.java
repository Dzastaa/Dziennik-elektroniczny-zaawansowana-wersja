import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//generyczny komponent
public class TableModel2 extends AbstractTableModel {
    public String[] column1;
    public List<Student> name1;

    public TableModel2(List<Student> listaStudentow1, String[] columns) throws MyException {
        if(listaStudentow1.isEmpty())
            throw new MyException();
        name1 = new ArrayList<>();
        for(Student student1 : listaStudentow1) {
            name1.add(student1);
        }
        column1 = columns;
    }

    @Override
    public int getRowCount() {
        return name1.size();
    }

    @Override
    public int getColumnCount() {
        return column1.length;
    }

    @Override
    public String getColumnName(int col){
        return column1[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student1 = name1.get(rowIndex);

        switch(columnIndex){
            case 0: return student1.getImie();
            case 1: return student1.getNazwisko();
            case 2: return student1.getStanStudenta();
            case 3: return student1.getPunkty();
            default: return null;
        }
    }

    public void addRow(Student class1) {
        name1.add(class1);
        fireTableRowsInserted(name1.size() - 1, name1.size() - 1);
    }

    public void removeRow(int i) throws MyException {
        if(i<0)
            throw new MyException();
        else {
            name1.remove(i);
            fireTableRowsDeleted(i - 1, name1.size() - 1);
        }
    }

    public void change(int i, String x) throws MyException {
        if(i<0)
            throw new MyException();
        else{
            double x1 = Double.parseDouble(x);
            if(x1<0)
                throw new MyException();
            else {
                name1.get(i).setPunkty(x1);
                fireTableRowsUpdated(0, name1.size());
            }
        }
    }

    public void sort(){
        Collections.sort(name1);
        fireTableRowsUpdated(0, name1.size());
    }

    List<Student> searchPartial(String s) throws MyException {
        List<Student> temp = new ArrayList<>();
        for (Student s2 : name1) {
            if (s2.getImie().contains(s)) {
                temp.add(s2);
            }
        }
        return temp;
    }

    public void search(String s) throws MyException {
        List<Student> listaZnalezionych = searchPartial(s);
        if(listaZnalezionych.isEmpty())
            throw new MyException();
        Students st = new Students(listaZnalezionych);
    }

    public void pokazWzgledemPunktow(String x) throws MyException {
        double x1 = Double.parseDouble(x);
        List<Student> s1 = new ArrayList<>();
        for(Student s : name1){
            if(s.getPunkty()>=x1){
                s1.add(s);
            }
        }
        if(s1.isEmpty())
            throw new MyException();
        Students stud = new Students(s1);
    }

    public void changeStatus(int x, String s) throws MyException {
        if(x<0)
            throw new MyException();
        else {
            if (s.equals("Obecny"))
                name1.get(x).setStanStudenta(StudentCondition.obecny);
            else if (s.equals("Nieobecny"))
                name1.get(x).setStanStudenta(StudentCondition.nieobecny);
            else if (s.equals("Chory"))
                name1.get(x).setStanStudenta(StudentCondition.chory);
            else if (s.equals("Odrabiajacy"))
                name1.get(x).setStanStudenta(StudentCondition.odrabiajacy);
            else
                throw new MyException();
            fireTableRowsUpdated(0, name1.size());
        }
    }

}
