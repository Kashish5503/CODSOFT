
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class Table {
    JFrame f;
    JTable j;

    Table() {
        f = new JFrame();

        f.setTitle("Table");

        String[][] data = {
                { "0011", "Kashish", "Goyal", "Male", "CSE", "Third Year" },
                { "0021", "Dhanisha", "Dhawan", "Female", "CSE", "Third Year" },
                { "0055", "Nitish", "Arora", "Male", "IT", "Third Year" }
        };

        String[] columnNames = { "Roll Number", "First Name", "Last Name", "Gender", "Stream", "Year" };

        j = new JTable(data, columnNames);
        j.setBounds(30, 20, 200, 300);

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(1200, 500);
        f.setVisible(true);
    }

}

public class Main1 {
    Main1() {

        Frame f = new Frame();
        f.setSize(1200, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setTitle("student");
        f.setBackground(Color.CYAN);

        Label l1 = new Label("Roll Number:");
        l1.setBounds(40, 100, 70, 20);
        f.add(l1);

        TextField t1 = new TextField(" ");
        t1.setBounds(120, 100, 100, 20);
        f.add(t1);

        Label l2 = new Label("First Name:");
        l2.setBounds(50, 150, 70, 20);
        f.add(l2);

        TextField t2 = new TextField(" ");
        t2.setBounds(120, 150, 100, 20);
        f.add(t2);

        Label l3 = new Label("Last Name:");
        l3.setBounds(50, 200, 70, 20);
        f.add(l3);

        TextField t3 = new TextField(" ");
        t3.setBounds(120, 200, 100, 20);
        f.add(t3);

        Label l4 = new Label("     Gender:");
        l4.setBounds(50, 250, 70, 20);
        f.add(l4);

        Checkbox ch1 = new Checkbox("male");
        ch1.setBounds(120, 250, 50, 20);
        f.add(ch1);

        Checkbox ch2 = new Checkbox("Female");
        ch2.setBounds(170, 250, 70, 20);
        f.add(ch2);

        Label l5 = new Label("Branch:");
        l5.setBounds(60, 300, 50, 20);
        f.add(l5);

        Choice c1 = new Choice();
        c1.add("CSE");
        c1.add("IT");
        c1.add("ECE");
        c1.add("AIDS");
        c1.add("AIML");
        c1.add("Civil");
        c1.add("Mechanical");
        c1.setBounds(120, 300, 100, 15);
        f.add(c1);

        Label l6 = new Label("Year:");
        l6.setBounds(60, 350, 50, 20);
        f.add(l6);

        Choice c2 = new Choice();
        c2.add("First Year");
        c2.add("Second Year");
        c2.add("Third Year");
        c2.add("Fourth Year");
        c2.setBounds(120, 350, 100, 15);
        f.add(c2);

        Button b1 = new Button("Add");
        b1.setBounds(70, 420, 60, 30);
        b1.setBackground(Color.yellow);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Label l8 = new Label("Added Successfully");
                l8.setBounds(50, 480, 120, 30);
                l8.setForeground(Color.red);
                f.add(l8);
            }
        });
        f.add(b1);

        Button b2 = new Button("Delete");
        b2.setBounds(150, 420, 60, 30);
        b2.setBackground(Color.yellow);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Label l9 = new Label("Deleted Successfully");
                l9.setBounds(150, 480, 120, 30);
                l9.setForeground(Color.red);
                f.add(l9);
            }
        });
        f.add(b2);

        Button b3 = new Button("Edit");
        b3.setBounds(230, 420, 60, 30);
        b3.setBackground(Color.yellow);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Label l10 = new Label("Edited Successfully");
                l10.setBounds(200, 480, 120, 30);
                l10.setForeground(Color.red);
                f.add(l10);
            }
        });
        f.add(b3);

        Label l7 = new Label("Search:");
        l7.setBounds(700, 100, 50, 20);
        f.add(l7);

        TextField t7 = new TextField(" ");
        t7.setBounds(750, 100, 300, 20);
        f.add(t7);

        Button b = new Button("View Table");
        b.setBounds(800, 200, 100, 30);
        b.setBackground(Color.ORANGE);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Table();
            }
        });
        f.add(b);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student", "root", "power123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from st_data");
            while (rs.next())
                System.out
                        .println(rs.getInt(1)
                                + "  " + rs.getString(2)
                                + "  " + rs.getString(3)
                                + "  " + rs.getString(4)
                                + "  " + rs.getString(5)
                                + "  " + rs.getString(6));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        new Main1();
    }
}
