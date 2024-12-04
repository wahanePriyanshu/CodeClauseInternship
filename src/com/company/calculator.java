package com.company;

import javax.swing.*;
import java.awt.event.*;

public class calculator implements ActionListener {
    JFrame frame;
    JTextField textfield1, textfield2, textfield3;
    JButton addButton, subButton, multiplyButton, divideButton;

    calculator() {
        frame = new JFrame("Calculator App");
        frame.setSize(520, 450);
        frame.setLayout(null);

        textfield1 = new JTextField();
        textfield1.setBounds(50, 25, 370, 30);
        textfield1.setToolTipText("Enter the first number");

        textfield2 = new JTextField();
        textfield2.setBounds(50, 75, 370, 30);
        textfield2.setToolTipText("Enter the second number");

        textfield3 = new JTextField();
        textfield3.setBounds(50, 125, 370, 30);
        textfield3.setToolTipText("Result");
        textfield3.setEditable(false);

        addButton = new JButton("ADD");
        addButton.setBounds(50, 200, 70, 50);
        addButton.addActionListener(this);

        subButton = new JButton("SUB");
        subButton.setBounds(130, 200, 70, 50);
        subButton.addActionListener(this);

        multiplyButton = new JButton("MUL");
        multiplyButton.setBounds(210, 200, 70, 50);
        multiplyButton.addActionListener(this);

        divideButton = new JButton("DIV");
        divideButton.setBounds(290, 200, 70, 50);
        divideButton.addActionListener(this);

        frame.add(textfield1);
        frame.add(textfield2);
        frame.add(textfield3);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(multiplyButton);
        frame.add(divideButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textfield1.getText());
            double num2 = Double.parseDouble(textfield2.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textfield3.setText("Error: Divide by 0");
                    return;
                }
            }

            textfield3.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            textfield3.setText("Error: Invalid Input");
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}
