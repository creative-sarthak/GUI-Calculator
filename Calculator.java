import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame {
    Label num1, num2, title, chLabel, resLabel;
    TextField n1, n2, resField;
    Choice ch;
    Button calc, clr;

    Calculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setLayout(null);
        setBackground(Color.lightGray);

        // title
        title = new Label("Simple Calculator");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(60, 40, 250, 30);

        // num 1
        num1 = new Label("Enter first number : ");
        num1.setBounds(50, 100, 130, 25);
        n1 = new TextField();
        n1.setBounds(180, 100, 50, 25);

        // num 2
        num2 = new Label("Enter Second number : ");
        num2.setBounds(50, 150, 130, 25);
        n2 = new TextField();
        n2.setBounds(180, 150, 50, 25);

        // choice
        chLabel = new Label("Select Operation");
        chLabel.setBounds(50, 200, 100, 30);
        ch = new Choice();
        ch.setBounds(180, 200, 50, 50);
        ch.add("+");
        ch.add("-");
        ch.add("*");
        ch.add("/");
        ch.add("%");

        // Result
        resLabel = new Label("Result is ");
        resLabel.setBounds(50, 250, 50, 50);
        resField = new TextField();
        resField.setBounds(150, 258, 80, 25);

        // Buttons
        calc = new Button("Calculate");
        calc.setBounds(50, 310, 80, 25);
        clr = new Button("Clear");
        clr.setBounds(150, 310, 80, 25);

        // adding components on frame
        add(title);
        add(num1);
        add(n1);
        add(num2);
        add(n2);
        add(chLabel);
        add(ch);
        add(calc);
        add(clr);
        add(resLabel);
        add(resField);

        // Add window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        clr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n1.setText("");
                n2.setText("");
                resField.setText("");
            }
        });

        calc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(n1.getText());
                double b = Double.parseDouble(n2.getText());
                String op = ch.getSelectedItem(); // Get the selected operation
        
                double result = 0;
                
                switch (op) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = (b != 0) ? a / b : 0; break;
                    case "%": result = (b != 0) ? a % b : 0; break;
                }
        
                System.out.println("Result: " + result);
                resField.setText(String.valueOf(result));
            }
        });
        
    }

    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.setVisible(true);
    }
}
