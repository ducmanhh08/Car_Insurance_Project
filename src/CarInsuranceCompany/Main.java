package CarInsuranceCompany;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends JFrame {
    InsuranceCompany insuranceCompany = new InsuranceCompany();
    private JButton jButton1;

    private JLabel jLabel1;

    private JLabel jLabel2;

    private JMenu jMenu1;

    private JMenu jMenu2;

    private JMenuBar jMenuBar1;

    private JMenuItem jMenuItem1;

    private JMenuItem jMenuItem2;

    private JPasswordField passText;

    private JTextField userText;

    public Main() throws PolicyException, PolicyHolderNameException {
        test();
        initComponents();
    }

    public void test() throws PolicyException, PolicyHolderNameException {

//        create company:
        this.insuranceCompany = new InsuranceCompany("My Cooperation", "uow", "2023");

//        MobilePhone mobilePhone = new MobilePhone("Galaxy S10", MobileType.Android, 8, 500.0D);
//        MobilePhone mobilePhone1 = new MobilePhone("Iphone X", MobileType.IOS, 4, 500.0D);
//        MobilePhone mobilePhone2 = new MobilePhone("LG S50", MobileType.Windows, 16, 500.0D);

//        create car models:

        Car carSUV = new Car(Car.CarType.SUV, "Mazda CX-5", 2020, 35000.00);
        Car carLUX = new Car(Car.CarType.LUX, "Audi Q8", 2021, 56000.00);
        Car carSPORTS = new Car(Car.CarType.SPORTS, "Porsche Taycan", 2023, 32000.00);
        Car carSED = new Car(Car.CarType.SED, "Honda Civic", 2019, 44000.00);
        Car carHATCH = new Car(Car.CarType.HATCH, "Volkswagen Golf", 2016, 15000.00);


//        MobilePlan plan0 = new PersonalPlan("OP123", 122, mobilePhone, 120, 22, new MyDate(2000, 5, 14), "Wollongong");
//        MobilePlan plan1 = new PersonalPlan("Sara12", 345, mobilePhone, 30, 38, new MyDate(1999, 4, 34), "Sydney");
//        MobilePlan plan2 = new PersonalPlan("John342", 435, mobilePhone1, 100, 20, new MyDate(2004, 3, 23), "Dubbo");
//        MobilePlan plan3 = new BusinessPlan("Alex123", 679, mobilePhone1, 50, 80, new MyDate(2020, 6, 21), 20, 123568);
//        MobilePlan plan4 = new BusinessPlan("Gh546", 356, mobilePhone2, 20, 30, new MyDate(2021, 7, 29), 10, 666555);
//        MobilePlan plan5 = new BusinessPlan("S9845", 457, mobilePhone2, 200, 46, new MyDate(2024, 2, 17), 200, 222333);

//        create policies:

        ThirdPartyPolicy thirdPartyPolicy1 = new ThirdPartyPolicy("John John", 345678, carLUX, 1, new MyDate(8, 11, 2020), "Repairing accessories");
        ThirdPartyPolicy thirdPartyPolicy2 = new ThirdPartyPolicy("Sara Sara", 387654, carSPORTS, 4, new MyDate(30, 12, 2021), "Returning products");
        ComprehensivePolicy comprehensivePolicy3 = new ComprehensivePolicy("Robert Rob", 300000, carSUV, 2, new MyDate(2, 5, 2022), 22, 2);
        ThirdPartyPolicy thirdPartyPolicy4 = new ThirdPartyPolicy("Alex Ash", 333333, carSED, 4, new MyDate(21, 10, 2023), "Repairing accessories");
        ComprehensivePolicy comprehensivePolicy5 = new ComprehensivePolicy("Matthew Nguyen", 351792, carHATCH, 5, new MyDate(22, 12, 2024), 27, 1);

//        create users:

        User user1 = new User("John Smith", 1,new Address(12, "Princs Hwy", "Fairy Meadow", "Wollongong"), "john123", "password1");
        User user2 = new User("Sara Lawson", 2,new Address(43, "Illawara Avenue", "Gwynneville", "Wollongong"), "sara123", "password1");
        User user3 = new User("Robert London", 3, new Address(22, "Edward st", "Coniston", "Wollongong"), "robert12", "123");
        User user4 = new User("Alex Niton", 4, new Address(330, "Smith st", "Liverpool", "Sydney"), "Alex", "12345");
        User user5 = new User("Matthew Nguyen", 5, new Address(20, "Rose st", "North Sydney", "Sydney"), "Joe12", "123");

//        add users:
        this.insuranceCompany.addUser(user1);
        this.insuranceCompany.addUser(user2);
        this.insuranceCompany.addUser(user3);
        this.insuranceCompany.addUser(user4);
        this.insuranceCompany.addUser(user5);
//        this.insuranceCompany.addUser("Mark", 56236, new Address(9, "Wind St", "West Wollongong", "Wollognong"), "bg657", "pass123");

        this.insuranceCompany.addPolicy(user1.getUserID(), thirdPartyPolicy1);
        this.insuranceCompany.addPolicy(user1.getUserID(), thirdPartyPolicy4);
        this.insuranceCompany.addPolicy(user1.getUserID(), comprehensivePolicy3);
        this.insuranceCompany.addPolicy(user1.getUserID(), thirdPartyPolicy2);
        this.insuranceCompany.addPolicy(user2.getUserID(), thirdPartyPolicy1);
        this.insuranceCompany.addPolicy(user2.getUserID(), thirdPartyPolicy4);
        this.insuranceCompany.addPolicy(user2.getUserID(), comprehensivePolicy5);
        this.insuranceCompany.addPolicy(user2.getUserID(), comprehensivePolicy3);
        this.insuranceCompany.addPolicy(user3.getUserID(), thirdPartyPolicy1);
        this.insuranceCompany.addPolicy(user3.getUserID(), thirdPartyPolicy2);
        this.insuranceCompany.addPolicy(user3.getUserID(), comprehensivePolicy3);
        this.insuranceCompany.addPolicy(user3.getUserID(), comprehensivePolicy5);

//        this.insuranceCompany.createPersonalPlan(user3.getUserID(), "Frank", 12314, mobilePhone, 25, 2, new MyDate(2019, 9, 14), "Churchville");
//        this.insuranceCompany.createPersonalPlan(user3.getUserID(), "Wanqing", 90909, mobilePhone1, 30, 50, new MyDate(2021, 10, 18), "Springfield");
//        this.insuranceCompany.createPersonalPlan(user4.getUserID(), "Natasha", 88978, mobilePhone2, 140, 57, new MyDate(2021, 11, 22), "Wuhan");
//        this.insuranceCompany.createBusinessPlan(user4.getUserID(), "Edward", 89900, mobilePhone1, 8, 2, new MyDate(2019, 8, 11), 150, 1212121);
//        this.insuranceCompany.createBusinessPlan(user5.getUserID(), "Micheal", 45674, mobilePhone, 200, 34, new MyDate(2020, 9, 31), 4000, 3434344);
//        this.insuranceCompany.createBusinessPlan(user5.getUserID(), "Mary", 67656, mobilePhone2, 5000, 80, new MyDate(2020, 12, 1), 2000, 5656565);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.userText = new JTextField();
        this.jButton1 = new JButton();
        this.passText = new JPasswordField();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jMenu2 = new JMenu();
        setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Tahoma", 0, 18));
        this.jLabel1.setText("Username");
        this.jLabel2.setFont(new Font("Tahoma", 0, 18));
        this.jLabel2.setText("Password");
        this.userText.setFont(new Font("Tahoma", 1, 18));
        this.jButton1.setFont(new Font("Tahoma", 1, 18));
        this.jButton1.setForeground(new Color(255, 102, 102));
        this.jButton1.setText("Login");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Main.this.jButton1ActionPerformed(evt);
            }
        });
        this.passText.setFont(new Font("Tahoma", 1, 18));
        this.passText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Main.this.passTextActionPerformed(evt);
            }
        });
        this.jMenu1.setText("File");
        this.jMenu1.setFont(new Font("Segoe UI", 1, 18));
        this.jMenuItem1.setFont(new Font("Segoe UI", 1, 18));
        this.jMenuItem1.setText("Load");
        this.jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Main.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setFont(new Font("Segoe UI", 1, 18));
        this.jMenuItem2.setText("Save");
        this.jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Main.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu1);
        this.jMenu2.setText("List of Users");
        this.jMenu2.setFont(new Font("Segoe UI", 1, 18));
        this.jMenu2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Main.this.jMenu2MouseClicked(evt);
            }
        });
        this.jMenuBar1.add(this.jMenu2);
        setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jButton1)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(this.jLabel1, -2, 110, -2)
                                                .addComponent(this.jLabel2))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(this.userText)
                                                .addComponent(this.passText, -1, 125, 32767))))
                        .addContainerGap(298, 32767)));
        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel1, -2, 29, -2)
                                .addComponent(this.userText, -2, -1, -2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel2)
                                .addComponent(this.passText, -2, -1, -2))
                        .addGap(34, 34, 34)
                        .addComponent(this.jButton1)
                        .addContainerGap(126, 32767)));
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        login();
    }

    private void passTextActionPerformed(ActionEvent evt) {
        login();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        try {
            this.insuranceCompany = insuranceCompany.load("company.ser");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        try {
            this.insuranceCompany.save("company.ser");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }

    private void jMenu2MouseClicked(MouseEvent evt) {
        String output = "";
        for (User user : this.insuranceCompany.getUsers().values()) {
            output = output + "username: " + user.getUserUsername() + " pass: " + user.getUserPassword() + "\n";
        }
        JOptionPane.showMessageDialog(this, output);
    }

    public void login() {
        User user = this.insuranceCompany.validateUser(this.userText.getText(), this.passText.getText());
        this.passText.setText("");
        if (user != null) {
            ArrayList<String> cities = this.insuranceCompany.populateDistinctCityNames();
            UserUI userUI = new UserUI(user, this, cities);
            userUI.setVisible(true);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Username or password is wrong");
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    (new Main()).setVisible(true);
                } catch (PolicyException e) {
                    throw new RuntimeException(e);
                } catch (PolicyHolderNameException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}

