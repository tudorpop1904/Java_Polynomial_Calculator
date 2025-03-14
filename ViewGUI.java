package Model;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class ViewGUI extends JFrame implements ActionListener {
    JFrame frame;
    JLabel label1, label2, label3, label4, nonDivision, resultLabel, divisionLabel, quotient, remainder;
    JButton adunare, scadere, inmultire, impartire, derivata, integrala;
    JTextField poly1, poly2, result, polyQ, polyR;
    public ViewGUI(){
        frame = new JFrame("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        label1 = new JLabel("First Polynomial:");
        label1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        label1.setBounds(10, 10,120, 30);
        poly1 = new JTextField();
        poly1.setBounds(130, 15, 200, 20);
        poly1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        frame.setSize(450, 450);
        label2 = new JLabel("Second Polynomial:");
        label2.setBounds(10, 50, 130, 30);
        label2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        poly2 = new JTextField();
        poly2.setBounds(130, 55, 200, 20);
        poly2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        label3 = new JLabel("NOTE! For the operations of differentiation and integration,");
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setBounds(10, 80, 430, 20);
        label3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        label4 = new JLabel("only the first entered polynomial will be considered!");
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        label4.setBounds(10, 95, 430, 20);
        adunare = new JButton("Add");
        scadere = new JButton("Subtract");
        inmultire = new JButton("Multiply");
        impartire = new JButton("Divide");
        derivata = new JButton("Differentiate");
        integrala = new JButton("Integrate");
        adunare.setBounds(20, 130, 100, 30);
        adunare.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        scadere.setBounds(120, 130, 100, 30);
        scadere.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        inmultire.setBounds(220, 130, 100, 30);
        inmultire.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        impartire.setBounds(320, 130, 100, 30);
        impartire.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        derivata.setBounds(100, 160, 120, 30);
        derivata.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        integrala.setBounds(220, 160, 120, 30);
        integrala.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        nonDivision = new JLabel("The result for any operation BUT DIVISION will be displayed below.");
        nonDivision.setBounds(10, 210, 450, 30);
        nonDivision.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 240, 50, 30);
        resultLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        result = new JTextField();
        result.setEditable(false);
        result.setBounds(130, 245, 200, 20);
        result.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        divisionLabel = new JLabel("The result pair for the DIVISION operation will be displayed below.");
        divisionLabel.setBounds(10, 270, 450, 30);
        divisionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        quotient = new JLabel("Quotient:");
        quotient.setBounds(10, 300, 100, 30);
        quotient.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        polyQ = new JTextField();
        polyQ.setEditable(false);
        polyQ.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        polyQ.setBounds(130, 305, 200, 20);
        remainder = new JLabel("Remainder:");
        remainder.setBounds(10, 330, 100, 30);
        remainder.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        polyR = new JTextField();
        polyR.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        polyR.setEditable(false);
        polyR.setBounds(130, 335, 200, 20);
        adunare.addActionListener(this);
        scadere.addActionListener(this);
        inmultire.addActionListener(this);
        impartire.addActionListener(this);
        derivata.addActionListener(this);
        integrala.addActionListener(this);
        adunare.setFocusable(false);
        scadere.setFocusable(false);
        inmultire.setFocusable(false);
        impartire.setFocusable(false);
        derivata.setFocusable(false);
        integrala.setFocusable(false);
        frame.add(label1);
        frame.add(poly1);
        frame.add(label2);
        frame.add(poly2);
        frame.add(label3);
        frame.add(label4);
        frame.add(adunare);
        frame.add(scadere);
        frame.add(inmultire);
        frame.add(impartire);
        frame.add(derivata);
        frame.add(integrala);
        frame.add(nonDivision);
        frame.add(resultLabel);
        frame.add(result);
        frame.add(divisionLabel);
        frame.add(quotient);
        frame.add(polyQ);
        frame.add(remainder);
        frame.add(polyR);
        frame.getContentPane().setBackground(new Color(0xCDB891));
        ImageIcon image = new ImageIcon("polynomial.png");
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adunare) {
            String Ps = poly1.getText();
            String Qs = poly2.getText();
            Polynomial P = new Polynomial(Ps);
            Polynomial Q = new Polynomial(Qs);
            Polynomial R = P.addPolynomial(Q);
            result.setText(String.valueOf(R));
        }
        if (e.getSource() == scadere) {
            String Ps = poly1.getText();
            String Qs = poly2.getText();
            Polynomial P = new Polynomial(Ps);
            Polynomial Q = new Polynomial(Qs);
            Polynomial R = P.subtractPolynomial(Q);
            result.setText(String.valueOf(R));
        }
        if (e.getSource() == inmultire) {
            String Ps = poly1.getText();
            String Qs = poly2.getText();
            Polynomial P = new Polynomial(Ps);
            Polynomial Q = new Polynomial(Qs);
            Polynomial R = P.multiplyPolynomial(Q);
            result.setText(String.valueOf(R));
        }
        if (e.getSource() == impartire) {
            String Ps = poly1.getText();
            String Qs = poly2.getText();
            Polynomial P = new Polynomial(Ps);
            Polynomial Q = new Polynomial(Qs);
            PolynomialDivision R = new PolynomialDivision(P, Q);
            polyQ.setText(R.getQuotient().toString());
            polyR.setText(R.getRemainder().toString());
        }
        if (e.getSource() == derivata) {
            String Ps = poly1.getText();
            Polynomial P = new Polynomial(Ps);
            Polynomial R = P.diffPolynomial();
            result.setText(String.valueOf(R));
        }
        if (e.getSource() == integrala) {
            String Ps = poly1.getText();
            Polynomial P = new Polynomial(Ps);
            DoublePolynomial R = P.integratePolynomial();
            result.setText(R.toString());
        }
    }
}
