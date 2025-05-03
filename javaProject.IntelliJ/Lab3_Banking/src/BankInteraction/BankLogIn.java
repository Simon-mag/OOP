package BankInteraction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankLogIn extends JFrame{

    private final JButton cancel;
    private final JButton ok;
    private final JTextField usernameText;
    private final JPasswordField passwordText;
    private int loginAttempts = 0;


    public BankLogIn(){
        //Create basic login Frame//
        super("Bank Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,250);
        setLayout(null);

        //2 Buttons: Cancel and OK//
        ok = new JButton("OK");
        ok.setBounds(130,150,90,40);
        ok.setFocusable(false);
        cancel = new JButton("Cancel");
        cancel.setBounds(230,150,90,40);
        cancel.setFocusable(false);
        add(ok);
        add(cancel);

        //User\password textFields//
        usernameText = new JTextField("");
        usernameText.setBounds(230,60,120,25);
        passwordText = new JPasswordField("");
        passwordText.setBounds(230,90,120,25);
        add(usernameText);
        add(passwordText);


        //User\password labels//
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(130,60,120,25);
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(130,90,120,25);
        add(usernameLabel);
        add(passwordLabel);

        //Images//
        ImageIcon login = new ImageIcon("LoginMan.png");
        ImageIcon loginFrame = new ImageIcon("LoginIcon.jpg");
        setIconImage(login.getImage());
        JLabel imageLabel = new JLabel(loginFrame);
        imageLabel.setBounds(15,35,100,100);
        add(imageLabel);

        //Button Handler//
        LoginHandler loginHandler = new LoginHandler();
        ok.addActionListener(loginHandler);
        cancel.addActionListener(loginHandler);

        //Set enter key to press OK button//
        getRootPane().setDefaultButton(ok);
        setVisible(true);
    }

    public class LoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ok) {
                String username = "user123";
                String password = "1234";
                //CALL NEW CLASSES AND CHECK IF ITS VALID INFO//
                if (usernameText.getText().equals(username) &&
                        String.valueOf(passwordText.getPassword()).equals(password)){
                    //OPEN THE CORRECT USER WITH THEIR INFO//
                    BankLogIn.this.dispose();
                    BankGUI bank = new BankGUI();
                } else{
                    ++loginAttempts;
                    if(loginAttempts < 3) {
                        JOptionPane.showMessageDialog(
                                BankLogIn.this,
                                "Invalid Username or Password",
                                "Login Failed",
                                JOptionPane.ERROR_MESSAGE);
                    }else if(loginAttempts == 3){
                        JOptionPane.showMessageDialog(
                                BankLogIn.this,
                                "Too many failed attempts, Program will exit",
                                "Access Denied",
                                JOptionPane.ERROR_MESSAGE);
                        BankLogIn.this.dispose();
                    }
                }
            } else if (e.getSource() == cancel) {
                BankLogIn.this.dispose();
            }
        }
    }
}
