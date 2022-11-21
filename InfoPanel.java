import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class InfoPanel extends JPanel {
    public JLabel delta = new JLabel("");
    public JLabel Delta = new JLabel("");
    public JLabel I = new JLabel("");
    public JLabel Delta1 = new JLabel("");
    public JLabel IDelta = new JLabel("");
    public JLabel type = new JLabel("");

    public void setData(String delta, String Delta, String I, String Delta1, String type) {
        System.out.println(Delta1);
        this.delta.setText(delta);
        this.Delta.setText(Delta);
        this.I.setText(I);
        this.Delta1.setText(Delta1);
        this.IDelta.setText(String.valueOf(Integer.parseInt(I) * Integer.parseInt(Delta)));
        this.type.setText(type);
    }

    public void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.SOUTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        add(new JLabel("<html>&delta; =</html>"), c);
        c.gridx = 1;
        c.gridy = 0;
        add(delta, c);
        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("<html>&Delta; =</html>"), c);
        c.gridx = 1;
        c.gridy = 1;
        add(Delta, c);
        c.gridx=0;
        c.gridy = 2;
        add(new JLabel("<html>I&Delta; =</code>"),c);
        c.gridx = 1;
        c.gridy = 2;
        add(IDelta,c);
        c.gridx =0;
        c.gridy = 3;
        add(new JLabel("<html>I =</html>"),c);
        c.gridx = 1;
        c.gridy = 3;
        add(I,c);
        c.gridx=0;
        c.gridy=4;
        add(new JLabel("<html>&Delta<sub>1</sub> =</html>"),c);
        c.gridx=1;
        c.gridy=4;
        add(Delta1,c);
        c.gridx=0;
        c.gridy=5;
        c.gridwidth=2;
        add(type,c);
    }

    public InfoPanel() {
        init();
    }

    @Override
    public void update(Graphics g) {
        System.out.println("update");
        super.update(g);
    }
}