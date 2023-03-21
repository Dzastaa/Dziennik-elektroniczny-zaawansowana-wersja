import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//uzycie JTable
public class Groups extends JFrame {
    private JTable table;
    private JTextField tnazwa;
    private JButton add;
    private JPanel Panel1;
    private JButton button1;
    private JButton pokaz;
    private JButton change;
    private JButton sort;
    private JTextField timie;
    private JTextField tnazwisko;
    private JTextField tpunkty;
    private JLabel imie;
    private JLabel punkty;
    private JLabel nazwisko;
    private JButton addStudentToGroup;
    private JButton removeStudentFromGroup;
    private JButton showAllStudents;

    public Groups(List<Class> listaClass1, List<Student> listaStudentow1) {

        setContentPane(Panel1);
        setTitle("Grupy");
        setSize(700, 700);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            TableModel1 t = new TableModel1(listaClass1);
            table.setModel(t);

            setVisible(true);

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Class c = new Class(tnazwa.getText());
                    t.addRow(c);
                }
            });

            //usuwanie wybranej grupy
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.removeRow(i);
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Grupa nie została wybrana!", "Błąd",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Grupa nie została wybrana!");
                    }
                }
            });

            pokaz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.show(i);
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Grupa nie została wybrana!", "Błąd",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Grupa nie została wybrana!");
                    }
                }
            });

            //zmiana nazwy grupy
            change.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.change(i, tnazwa.getText());
                    }
                    catch(MyException e1) {
                        JOptionPane.showMessageDialog(null, "Grupa nie została wybrana!", "Błąd", JOptionPane.WARNING_MESSAGE);
                        e1.printError("Grupa nie została wybrana!");
                    }
                }
            });

            //sortowanie grupy po nazwie
            sort.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.sort();
                }
            });

            //dodawanie studenta do grupy
            addStudentToGroup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student s = new Student(timie.getText(), tnazwisko.getText(), tpunkty.getText());
                    int x = table.getSelectedRow();
                    try {
                        t.addStudent(s, x);
                        listaStudentow1.add(s);
                    }
                    catch(MyException e1) {
                        JOptionPane.showMessageDialog(null, "Grupa nie została wybrana!", "Błąd", JOptionPane.WARNING_MESSAGE);
                        e1.printError("Grupa nie została wybrana!");
                    }
                }
            });

            //usuwanie studenta z grupy
            removeStudentFromGroup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student s = new Student(timie.getText(), tnazwisko.getText(), tpunkty.getText());
                    int x = table.getSelectedRow();
                    try {
                        t.removeStudent(s, x);
                    }
                    catch(MyException e1) {
                        JOptionPane.showMessageDialog(null, "Grupa nie została wybrana / Nie istnieje taki student!", "Błąd", JOptionPane.WARNING_MESSAGE);
                        e1.printError("Grupa nie została wybrana!");
                    }
                }
            });

        } catch (MyException e) {
            JOptionPane.showMessageDialog(null, "Lista jest pusta!", "Błąd",JOptionPane.WARNING_MESSAGE);
            e.printError("Lista jest pusta!");
        }

        //wszyscy studenci
        showAllStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students s = new Students(listaStudentow1);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
