import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guicalculator extends JFrame implements ActionListener {

    //Declare global text field
    static JTextField tf;

    //Create a constructor for calculations (number, operation, number)
    String s0, s1, s2;
    guicalculator(){
        s0 = s1 = s2 = "";
    }

    public static void main(String args[]) {
        //Create a frame for our work
        JFrame f = new JFrame("My Calculator");
        f.setSize(200, 220);
        f.setResizable(false);

        //Set the look and feel to match the compuer OS
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //Create an object of our guicalculator class
        guicalculator c = new guicalculator();

        //Create a panel to add buttons and fields
        JPanel panel = new JPanel();
        panel.setBackground(Color.pink);

        //Create a text field for our calculaions
        tf = new JTextField(16);
        tf.setEditable(false);
        tf.setText("0");

        //Create number buttons
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        //Create operation buttons
        JButton pl, su, di, mu;
        pl = new JButton("+");
        su = new JButton("-");
        di = new JButton("/");
        mu = new JButton("*");

        //Create equals, clear, and decimal buttons
        JButton equals, clear, decimal;
        equals = new JButton("=");
        clear = new JButton("C");
        decimal = new JButton(".");

        //Add action listeners to buttons
        pl.addActionListener(c);
        su.addActionListener(c);
        di.addActionListener(c);
        mu.addActionListener(c);
        equals.addActionListener(c);
        clear.addActionListener(c);
        decimal.addActionListener(c);
        b0.addActionListener(c);
        b1.addActionListener(c);
        b2.addActionListener(c);
        b3.addActionListener(c);
        b4.addActionListener(c);
        b5.addActionListener(c);
        b6.addActionListener(c);
        b7.addActionListener(c);
        b8.addActionListener(c);
        b9.addActionListener(c);

        //Add items to the panel
        panel.add(tf);
        panel.add(pl);
        panel.add(su);
        panel.add(di);
        panel.add(mu);
        panel.add(b0);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(decimal);
        panel.add(equals);
        panel.add(clear);

        //Add the panel to the frame
        f.add(panel);

        //Show frame
        f.show();
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();

        //If the clear button is pressed
        if (s.charAt(0) == 'C'){
            s0 = s1 = s2 = "";
            tf.setText("0");
        }

        //If the value is a number or decimal
        else if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.'){
            //If an operation has already been chosen
            if (!s1.equals("")){
                s2 = s2 + s;
            }
            //If an operation has NOT already been chosen
            else{
                s0 = s0 + s;
            }
            tf.setText(s0+s1+s2);
        }

        //If the equals button is pressed
        else if (s.charAt(0) == '='){
            double te;
            if (s1.equals("+")){
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            }
            else if (s1.equals("-")){
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            }
            else if (s1.equals("/")){
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            }
            else {
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
            }
            //Present the results by updating the test field
            tf.setText(s0 + s1 + s2 + " = " + te);
            //Set s0 value to the equation answer
            s0 = Double.toString(te);
            //Assing s1 and s2 empty strings
            s1 = s2 = "";
        }

        //If the button pressed is an operation
        else{
            //If no operatino has been chosen, OR second number has been chosen
            if (s1.equals("") || s2.equals("")){
                s1 = s;
            }
            //If an operation has already been chosen, then solve the equation
            else {
                double te;
                if (s1.equals("+")){
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                }
                else if (s1.equals("-")){
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                }
                else if (s1.equals("/")){
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                }
                else {
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                }
                //Prep the calculator for the next calculation using the result
                s0 = Double.toString(te);
                s1 = s;
                s2 = "";
            }
            tf.setText(s0 + s1 + s2);
        }
    }
}

