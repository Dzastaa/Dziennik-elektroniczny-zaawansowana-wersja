import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//generyczny komponent na bazie AbstractTableModel
public class TableModel1 extends AbstractTableModel {
    public String[] column1;
    public List<Class> name1;


    public TableModel1(List<Class> listaClass1) throws MyException {

        if(listaClass1.isEmpty())
            throw new MyException();
        name1 = new ArrayList<>();

        for(Class class1 : listaClass1) {
            name1.add(class1);
        }
        column1 = new String[]{"Nazwa"};
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
    public String getColumnName(int column){
        return column1[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Class class1 = name1.get(rowIndex);

        switch(columnIndex){
            case 0: return class1.getNazwaGrupy();
            default: return null;
        }
    }

    public void addRow(Class class1) {
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

    public void show(int i) throws MyException {
        if(i<0)
            throw new MyException();
        else {
            Students s = new Students(name1.get(i).getListaStudentow());
        }

    }

    public void change(int i, String nazwa) throws MyException {
        if(i<0)
            throw new MyException();
        else {
            name1.get(i).setNazwaGrupy(nazwa);

            fireTableRowsUpdated(0, name1.size());
        }
    }

    public void sort(){
        Collections.sort(name1);
        fireTableRowsUpdated(0, name1.size());
    }

    public void addStudent(Student student1, int x) throws MyException {
        if(x<0)
            throw new MyException();
        else {
            name1.get(x).addStudent(student1);

            fireTableRowsUpdated(0, name1.size());
        }
    }

    public void removeStudent(Student student1, int x) throws MyException {
        if(x<0)
            throw new MyException();
        else {
            boolean spr = name1.get(x).removeStudent(student1);
            if(!spr)
                throw new MyException();

            fireTableRowsUpdated(0, name1.size());
        }
    }
}
