import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Students extends JFrame {
    private JTable table;
    private JTextField tpunkty;
    private JTextField tnazwa;
    private JButton add;
    private JButton button1;
    private JPanel panel;
    private JTextField tnazwisko;
    private JButton zmien;
    private JButton sortuj;
    private JButton szukaj;
    private JComboBox Box;
    private JButton changeStudentStatus;
    private JTextField tstan;
    private JLabel nazwa;
    private JLabel Nazwisko;
    private JLabel stan;

    public Students(List<Student> listaStudentow1){
        setContentPane(panel);
        setTitle("Studenci");
        setSize(700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box.addItem("2");
        Box.addItem("3");
        Box.addItem("4");
        Box.addItem("5");

        try{
            TableModel2 t = new TableModel2(listaStudentow1, new String[]{"Imie", "Nazwisko", "Status", "Punkty"});
            table.setModel(t);

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student s = new Student(tnazwa.getText(), tnazwisko.getText(), tpunkty.getText());
                    t.addRow(s);
                }
            });

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.removeRow(i);
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie wybrano studenta!", "Błąd",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano studenta!");
                    }
                }
            });
            zmien.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    try {
                        t.change(i, tpunkty.getText());
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie wybrano studenta lub zla ilosc punktow!", "Błąd",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie wybrano studenta lub zla ilosc punktow!");
                    }

                }
            });

            sortuj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.sort();
                }
            });

            szukaj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        t.search(tnazwa.getText());
                    }
                    catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie znaleziono studenta!", "Błąd",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie znaleziono studenta!");
                    }
                }
            });

            Box.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String punkty = Box.getSelectedItem().toString();
                    try {
                        t.pokazWzgledemPunktow(punkty);
                    }catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Nie znaleziono studenta!", "Błąd",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie znaleziono studenta!");
                    }
                }
            });

            changeStudentStatus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        int x = table.getSelectedRow();
                        t.changeStatus(x, tstan.getText());
                    }catch(MyException e1){
                        JOptionPane.showMessageDialog(null, "Podano zly stan lub nie wybrano studenta!\n Mozliwe stany: Obency, Chory, Spozniony, Odrabiajacy.", "Błąd",JOptionPane.WARNING_MESSAGE);
                        e1.printError("Nie znaleziono studenta!");
                    }
                }
            });

            setVisible(true);
        } catch (MyException e) {
            JOptionPane.showMessageDialog(null, "Lista jest pusta!", "Błąd",JOptionPane.WARNING_MESSAGE);
            e.printError("Lista jest pusta!");
        }

    }
}
