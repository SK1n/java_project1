import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class DataPanel extends JPanel {
    private JTextField a11 = new JTextField(10);
    private JTextField a12 = new JTextField(10);
    private JTextField a22 = new JTextField(10);
    private JTextField a13 = new JTextField(10);
    private JTextField a23 = new JTextField(10);
    private JTextField a33 = new JTextField(10);
    private JButton calculate = new JButton();
    public DataPanel(InfoPanel infoPanel) {
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx =1;
        c.gridwidth = 2;
        JLabel header = new JLabel(
                "<html>Ecuatia generala: a<sub>11</sub>x<sup>2</sup>+2a<sub>12</sub>xy+a<sub>22</sub>y<sup>2</sup>+2a<sub>13</sub>x+2a<sub>23</sub>y+a<sub>33</sub>=0</html>");
        header.setFont(new Font("Serif", Font.BOLD, 16));
        add(header, c);
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridy = 1;
        add(new JLabel("a11:"), c); // label
        c.gridx = 1;
        add(a11, c); // textbox
        c.gridx = 0;
        c.gridy = 2;
        add(new JLabel("a12:"), c); // label
        c.gridx = 1;
        add(a12, c);
        c.gridx = 0;
        c.gridy = 3;
        add(new JLabel("a22:"), c);
        c.gridx = 1;
        add(a22, c);
        c.gridx = 0;
        c.gridy = 4;
        add(new JLabel("a13:"), c);
        c.gridx = 1;
        add(a13, c);
        c.gridx = 0;
        c.gridy = 5;
        add(new JLabel("a23:"), c);
        c.gridx = 1;
        add(a23, c);
        c.gridx = 0;
        c.gridy = 6;
        add(new JLabel("a33:"), c);
        c.gridx = 1;
        add(a33, c);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 7;
        calculate.setText("Calculate");
        add(calculate, c);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculate(infoPanel);
            }
        });

    }

    private void Calculate(InfoPanel infoPanel) {

            int value11 = Integer.parseInt(a11.getText());
            int value12 = Integer.parseInt(a12.getText());
            int value22 = Integer.parseInt(a22.getText());
            int value13 = Integer.parseInt(a13.getText());
            int value23 = Integer.parseInt(a23.getText());
            int value33 = Integer.parseInt(a33.getText());
            String type = "";
            int A[][] = { { value11, value12 }, { value12, value22, } };
            int D[][] = { { value11, value12, value13 }, { value12, value22, value23 }, { value13, value23, value33 } };
            int detA = A[0][0] * A[1][1] - A[0][1] * A[1][0];
            int detD = D[0][0] * D[1][1] * D[2][2] + D[1][0] * D[2][1] * D[0][2] + D[0][1] * D[1][2] * D[2][0]
                    - D[0][2] * D[1][1] * D[2][0] - D[0][1] * D[1][0] * D[2][2] - D[1][2] * D[2][1] * D[0][0];
            int I = A[0][0] + A[1][1];
            int d1 = value11 * value22 - value12 * value12 + value11 * value33 - value13 * value13 + value22 * value33
                    - value23 * value23;

            if (detA > 0 && detD != 0 && I * detD < 0) {
                System.out.println("elipsa");
                type = "Elipsa";
            } else if (detA > 0 && detD != 0 && I * detD > 0) {
                System.out.println("elipsa imaginara");
                type = "Elipsa Imaginara";
            } else if (detA > 0 && detD == 0) {
                System.out.println("punct dublu");
                type = "Punct Dublu";
            } else if (detA < 0 && detD != 0) {
                System.out.println("hiperbola");
                type = "Hiperbola";
            } else if (detA < 0 && detD == 0) {
                System.out.println("drepte concurente");
                type = "Drepte Concurente";
            } else if (detA == 0 && detD != 0) {
                System.out.println("parabola");
                type = "Parabola";
            } else if (detA == 0 && detD == 0) {
                if (d1 < 0) {
                    System.out.println("drepte paralele");
                    type = "Drepte paralele";
                } else if (d1 == 0) {
                    System.out.println("dreapta dubla");
                    type = "Dreapta dubla";
                } else if (d1 > 0) {
                    type = "Drepte imaginare paralele";
                    System.out.println("drepte imaginare paralele");
                }
            }
            String sdetA = String.valueOf(detA);
            String sdetD = String.valueOf(detD);
            String sI = String.valueOf(I);
            String sd1 = String.valueOf(d1);
            infoPanel.setData(sdetA, sdetD, sI, sd1,"Tipul conicii: " + type);
            
    }

  
}