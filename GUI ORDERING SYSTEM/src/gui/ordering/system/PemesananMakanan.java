/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.ordering.system;

/**
 *
 * @author victu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PemesananMakanan extends JFrame implements ActionListener {

    private JLabel labelTitle, labelName, labelAddress, labelPhone, labelMenu, labelCategory;
    private JTextField fieldName, fieldAddress, fieldPhone;
    private JCheckBox checkAppetizer1, checkAppetizer2, checkAppetizer3, checkMain1, checkMain2, checkMain3, checkDessert1, checkDessert2, checkDessert3, checkDrink1, checkDrink2, checkDrink3;
    private JButton buttonAdd, buttonReset;
    private JTextArea textAreaReceipt;
    private double totalAmount = 0;

    public PemesananMakanan() {
        setTitle("Order App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        labelTitle = new JLabel("Ordering Food");
        labelTitle.setFont(new Font("Serif", Font.BOLD, 25));
        labelTitle.setBounds(250, 20, 200, 50);
        panel.add(labelTitle);

        // customer data
        labelCategory = new JLabel("Customer Data");
        labelCategory.setFont(new Font("Serif", Font.BOLD, 18));
        labelCategory.setBounds(100, 80, 200, 30);
        panel.add(labelCategory);

        labelName = new JLabel("Name");
        labelName.setBounds(50, 120, 100, 20);
        panel.add(labelName);

        fieldName = new JTextField();
        fieldName.setBounds(150, 120, 150, 20);
        panel.add(fieldName);

        labelAddress = new JLabel("Address");
        labelAddress.setBounds(50, 150, 100, 20);
        panel.add(labelAddress);

        fieldAddress = new JTextField();
        fieldAddress.setBounds(150, 150, 150, 20);
        panel.add(fieldAddress);

        labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 180, 100, 20);
        panel.add(labelPhone);

        fieldPhone = new JTextField();
        fieldPhone.setBounds(150, 180, 150, 20);
        panel.add(fieldPhone);

        // menu category
        labelCategory = new JLabel("Menu Category");
        labelCategory.setFont(new Font("Serif", Font.BOLD, 18));
        labelCategory.setBounds(100, 220, 200, 30);
        panel.add(labelCategory);

        // appetizer
        labelMenu = new JLabel("Appetizer");
        labelMenu.setBounds(50, 260, 100, 20);
        panel.add(labelMenu);

        checkAppetizer1 = new JCheckBox("Salad (Rp 15,000)");
        checkAppetizer1.setBounds(150, 260, 200, 20);
        panel.add(checkAppetizer1);

        checkAppetizer2 = new JCheckBox("Fried Mushroom (Rp 20,000)");
        checkAppetizer2.setBounds(150, 280, 200, 20);
        panel.add(checkAppetizer2);

        checkAppetizer3 = new JCheckBox("Garlic Bread (Rp 10,000)");
        checkAppetizer3.setBounds(150, 300, 200, 20);
        panel.add(checkAppetizer3);
       
        // main course
        labelMenu = new JLabel("Main Course");
        labelMenu.setBounds(50, 340, 100, 20);
        panel.add(labelMenu);
        checkMain1 = new JCheckBox("Fried Rice (Rp 25,000)");
        checkMain1.setBounds(150, 340, 200, 20);
        panel.add(checkMain1);

        checkMain2 = new JCheckBox("Fried Noodle (Rp 30,000)");
        checkMain2.setBounds(150, 360, 200, 20);
        panel.add(checkMain2);

        checkMain3 = new JCheckBox("Grilled Chicken (Rp 35,000)");
        checkMain3.setBounds(150, 380, 200, 20);
        panel.add(checkMain3);

        // dessert
        labelMenu = new JLabel("Dessert");
        labelMenu.setBounds(350, 260, 100, 20);
        panel.add(labelMenu);

        checkDessert1 = new JCheckBox("Ice Cream (Rp 10,000)");
        checkDessert1.setBounds(450, 260, 200, 20);
        panel.add(checkDessert1);

        checkDessert2 = new JCheckBox("Cheesecake (Rp 20,000)");
        checkDessert2.setBounds(450, 280, 200, 20);
        panel.add(checkDessert2);

        checkDessert3 = new JCheckBox("Pudding (Rp 15,000)");
        checkDessert3.setBounds(450, 300, 200, 20);
        panel.add(checkDessert3);

        // drink
        labelMenu = new JLabel("Drink");
        labelMenu.setBounds(350, 340, 100, 20);
        panel.add(labelMenu);

        checkDrink1 = new JCheckBox("Mineral Water (Rp 5,000)");
        checkDrink1.setBounds(450, 340, 200, 20);
        panel.add(checkDrink1);

        checkDrink2 = new JCheckBox("Soft Drink (Rp 10,000)");
        checkDrink2.setBounds(450, 360, 200, 20);
        panel.add(checkDrink2);

        checkDrink3 = new JCheckBox("Juice (Rp 15,000)");
        checkDrink3.setBounds(450, 380, 200, 20);
        panel.add(checkDrink3);

        // receipt
        textAreaReceipt = new JTextArea();
        textAreaReceipt.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaReceipt);
        scrollPane.setBounds(100, 420, 500, 100);
        panel.add(scrollPane);

        // button add
        buttonAdd = new JButton("Add");
        buttonAdd.setBounds(200, 540, 100, 30);
        buttonAdd.addActionListener(this);
        panel.add(buttonAdd);

        // button reset
        buttonReset = new JButton("Reset");
        buttonReset.setBounds(350, 540, 100, 30);
        buttonReset.addActionListener(this);
        panel.add(buttonReset);

        add(panel);
        setVisible(true);
}
       public void actionPerformed(ActionEvent e) {
        String customerName = fieldName.getText();
        String customerAddress = fieldAddress.getText();
        String customerPhone = fieldPhone.getText();
        StringBuilder receipt = new StringBuilder();
        receipt.append("\nCustomer Data\n");
        receipt.append("Name: ").append(customerName).append("\n");
        receipt.append("Address: ").append(customerAddress).append("\n");
        receipt.append("Phone: ").append(customerPhone).append("\n");

        boolean isItemSelected = false;

        // appetizer
        double appetizerPrice = 0;

        if (checkAppetizer1.isSelected()) {
            appetizerPrice += 15000;
            receipt.append("Salad (Rp 15,000)\n");
            isItemSelected = true;
        }

        if (checkAppetizer2.isSelected()) {
            appetizerPrice += 20000;
            receipt.append("Fried Mushroom (Rp 20,000)\n");
            isItemSelected = true;
        }

        if (checkAppetizer3.isSelected()) {
            appetizerPrice += 10000;
            receipt.append("Garlic Bread (Rp 10,000)\n");
            isItemSelected = true;
        }

        // main course
        double mainPrice = 0;

        if (checkMain1.isSelected()) {
            mainPrice += 50000;
            receipt.append("Chicken Steak (Rp 50,000)\n");
            isItemSelected = true;
        }

        if (checkMain2.isSelected()) {
            mainPrice += 60000;
            receipt.append("Beef Steak (Rp 60,000)\n");
            isItemSelected = true;
        }

        if (checkMain3.isSelected()) {
            mainPrice += 40000;
            receipt.append("Fried Rice (Rp 40,000)\n");
            isItemSelected = true;
        }

        // dessert
        double dessertPrice = 0;

        if (checkDessert1.isSelected()) {
            dessertPrice += 25000;
            receipt.append("Chocolate Cake (Rp 25,000)\n");
            isItemSelected = true;
        }

        if (checkDessert2.isSelected()) {
            dessertPrice += 20000;
            receipt.append("Ice Cream (Rp 20,000)\n");
            isItemSelected = true;
        }

        if (checkDessert3.isSelected()) {
            dessertPrice += 15000;
            receipt.append("Pudding (Rp 15,000)\n");
            isItemSelected = true;
        }

        // drink
        double drinkPrice = 0;

        if (checkDrink1.isSelected()) {
            drinkPrice += 5000;
            receipt.append("Mineral Water (Rp 5,000)\n");
            isItemSelected = true;
        }

        if (checkDrink2.isSelected()) {
            drinkPrice += 15000;
            receipt.append("Lemonade (Rp 15,000)\n");
            isItemSelected = true;
        }

        if (checkDrink3.isSelected()) {
            drinkPrice += 10000;
            receipt.append("Ice Tea (Rp 10,000)\n");
            isItemSelected = true;
        }

        if (!isItemSelected) {
            JOptionPane.showMessageDialog(this, "Please select at least one item.");
            return;
        }

        totalAmount += appetizerPrice + mainPrice + dessertPrice + drinkPrice;

        receipt.append("Total: Rp ").append(totalAmount).append("\n\n");

        textAreaReceipt.append(receipt.toString());

        // clear the form
        fieldName.setText("");
        fieldAddress.setText("");
        fieldPhone.setText("");
        checkAppetizer1.setSelected(false);
        checkAppetizer2.setSelected(false);
        checkAppetizer3.setSelected(false);
        checkMain1.setSelected(false);
        checkMain2.setSelected(false);
        checkMain3.setSelected(false);
        checkDessert1.setSelected(false);
        checkDessert2.setSelected(false);
        checkDessert3.setSelected(false);
        checkDrink1.setSelected(false);
        checkDrink2.setSelected(false);
        checkDrink3.setSelected(false);
        totalAmount = 0.0;
        }
        }