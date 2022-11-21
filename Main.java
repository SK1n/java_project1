import java.awt.*;

import javax.swing.BorderFactory;

import javax.swing.JFrame;

import javax.swing.JPanel;


public class Main extends JFrame {

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
        
    }

    public Main() {
        init();
        Dimension res = new Dimension(1000,650);
        setPreferredSize(res);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    public void init() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        InfoPanel infoPanel = new InfoPanel();
        DataPanel dataPanel = new DataPanel(infoPanel);
       GraphPanel graphPanel = new GraphPanel();
       c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        dataPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        graphPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        c.gridx =0;
        c.gridy= 0;
        c.gridheight =1;    
        c.gridwidth =1;
        
        panel.add(dataPanel,c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight =2;
        c.gridwidth =2;
        panel.add(graphPanel,c);
        c.weightx = 0;
        c.gridx=0;
        c.gridy=1;
        c.gridheight=1;
        panel.add(infoPanel,c);
        add(panel);
    }
}