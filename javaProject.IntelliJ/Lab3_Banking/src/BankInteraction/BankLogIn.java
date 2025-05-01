package BankInteraction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankLogIn extends JFrame implements ActionListener {

    private final JButton cancel;
    private final JButton ok;


    public BankLogIn(){
        JFrame frame = new JFrame();
        cancel = new JButton("Cancel");
        ok = new JButton("OK");


        ok.setBounds(130,150,90,40);
        ok.setFocusable(false);
        ok.addActionListener((ActionListener) this);
        frame.add(ok);

        cancel.setBounds(230,150,90,40);
        cancel.setFocusable(false);
        cancel.addActionListener((ActionListener) this);
        frame.add(cancel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,250);
        frame.setLayout(null);

        JLabel label = new JLabel("Bank Log In");
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);
        frame.add(label);


       // JOptionPane.showInternalOptionDialog(null,"password","Login",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,0);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ok)
            System.out.println("OK Button clicked");
        else if(e.getSource() == cancel)
            System.out.println("Cancel Button clicked");
    }
}
