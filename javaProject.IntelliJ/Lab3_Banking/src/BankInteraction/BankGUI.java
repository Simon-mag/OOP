package BankInteraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BankGUI extends JFrame {
    private final JTextArea outputArea;
    private final JButton depositButton;
    private final JButton withdrawButton;
    private final JButton transferButton;
    private final JRadioButton hideHistoryButton;
    private final JRadioButton showHistoryButton;

    private final BankFunctions manager;

    private ArrayList<String> history;


    public BankGUI(){
        super("Simple Banking System");
        manager = new BankFunctions();
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon image = new ImageIcon("BankFront.png");
        setIconImage(image.getImage());

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("\n <><>Welcome to the Banking System <><>");
        welcomeLabel.setSize(100,50);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(welcomeLabel, BorderLayout.NORTH);
        add(topPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        topPanel.add(scrollPane, BorderLayout.CENTER);


        JPanel radioPanel = new JPanel(new FlowLayout());
        showHistoryButton = new JRadioButton("Show History",true);
        hideHistoryButton = new JRadioButton("Hide History");
        ButtonGroup group = new ButtonGroup();
        group.add(showHistoryButton);
        group.add(hideHistoryButton);
        radioPanel.add(showHistoryButton);
        radioPanel.add(hideHistoryButton);
        topPanel.add(radioPanel, BorderLayout.SOUTH);

        hideHistoryButton.addActionListener(new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                outputArea.setText("Current balance : " + String.valueOf(manager.getBalance()));
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(transferButton);
        add(buttonPanel, BorderLayout.SOUTH);

        ButtonHandler handler = new ButtonHandler();
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);


        setVisible(true);
    }

    public class ButtonHandler implements ActionListener {
//
        @Override
        public void actionPerformed(ActionEvent e) {


        }
//
//        String input = JOptionPane.showInputDialog(
//                BankGUI.this,
//                "Enter amount to " + transactionType + ":",
//                "Input Amount",
//                JOptionPane.PLAIN_MESSAGE
//        );
//
//
//        if(input == null) return;
//
//        try {
//            int amount = Integer.parseInt(input.trim());
//            manager.processTransaction(transactionType, amount);
//            if (hideHistoryButton.isSelected()) {
//                outputArea.setText("Current Balance: " + manager.getBalance() + "\n");
//            } else {
//                outputArea.append(transactionType.substring(0, 1).toUpperCase() +
//                                  transactionType.substring(1) + "ed " + amount + "\n");
//                                  outputArea.append("Updated Balance: " + manager.getBalance() + "\n");
//            }
//        }catch(NumberFormatException e){
//            JOptionPane.showMessageDialog(BankGUI.this, "Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(
//                    BankGUI.this, e.getMessage(), "Transaction Error", JOptionPane.ERROR_MESSAGE
//            );
//        }
    }



    public void run(){
        history = new ArrayList<>();

    }

}
