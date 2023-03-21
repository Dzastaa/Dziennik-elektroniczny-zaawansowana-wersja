import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame implements ActionListener {
    List<Class> listaClass = new ArrayList<>();
    List<Student> listaStudentow = new ArrayList<>();
    JButton przycisk1, przycisk2;
    public MainWindow(List<Class> listaClass1, List<Student> listaStudentow1){
        listaStudentow = listaStudentow1;
        listaClass = listaClass1;

        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Dziennik");
        setLayout(new GridLayout());
        getContentPane().setBackground(Color.black);
        przycisk1 = new JButton("Zacznij pracę z dziennikiem");
        przycisk2 = new JButton("Wyjście");

        add(przycisk1);
        add(przycisk2);
        setVisible(true);
        przycisk1.addActionListener(this);
        przycisk2.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent event){
        Object object1 = event.getSource();
        if(object1 == przycisk1){
            Groups group1 = new Groups(listaClass, listaStudentow);
        }
        else if(object1==przycisk2){
            dispose();
        }
    }


}
