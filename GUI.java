import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 27.09.2023
 * @author 
 */

public class GUI extends JFrame {
    // start attributes
    private JLabel lEinkaufsliste1 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JButton bHinzufuegen1 = new JButton();
    private JButton bAusgeben1 = new JButton();
    private JTextArea jTextArea1 = new JTextArea();
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
    private Einkaufsliste liste;
    // end attributes

    public GUI() { 
        // Frame init
        super("Einkaufsliste");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("GUI");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        liste = new Einkaufsliste();
        // start components

        lEinkaufsliste1.setBounds(8, 8, 265, 25);
        lEinkaufsliste1.setText("Einkaufsliste");
        cp.add(lEinkaufsliste1);
        jTextField1.setBounds(8, 48, 265, 24);
        cp.add(jTextField1);
        bHinzufuegen1.setBounds(8, 80, 121, 25);
        bHinzufuegen1.setText("Hinzufügen");
        bHinzufuegen1.setMargin(new Insets(2, 2, 2, 2));
        bHinzufuegen1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bHinzufuegen1_ActionPerformed(evt);
                }
            });
        cp.add(bHinzufuegen1);
        bAusgeben1.setBounds(160, 80, 113, 25);
        bAusgeben1.setText("Ausgeben");
        bAusgeben1.setMargin(new Insets(2, 2, 2, 2));
        bAusgeben1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    bAusgeben1_ActionPerformed(evt);
                }
            });
        cp.add(bAusgeben1);
        jTextArea1ScrollPane.setBounds(8, 112, 265, 145);
        cp.add(jTextArea1ScrollPane);
        // end components

        setVisible(true);
    } // end of public GUI

    // start methods

    public static void main(String[] args) {
        new GUI();
    } // end of main

    public void bHinzufuegen1_ActionPerformed(ActionEvent evt) {
        liste.neuerArtikel(new Artikel(jTextField1.getText()));
        jTextField1.setText(null);
    } // end of bHinzufuegen1_ActionPerformed

    public void bAusgeben1_ActionPerformed(ActionEvent evt) {
        liste.einkaufsliste.toFirst();
        while(liste.einkaufsliste.hasAccess())
        {
            jTextArea1.setText(jTextArea1.getText() + liste.einkaufsliste.getContent().getArtikelname() +"\n");
            liste.einkaufsliste.next();
        }
        

    } // end of bAusgeben1_ActionPerformed

    // end methods
} // end of class GUI
