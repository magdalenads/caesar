
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class CaesartGUI extends JFrame {
    // Anfang Attribute
    private JLabel jLKlartext = new JLabel();
    private JTextArea jTAKlartext = new JTextArea("");
    private JLabel jLGeheim = new JLabel();
    private String[] jList1Data = {};
    private JTextArea jTAGeheimtext = new JTextArea("");
    private JButton jBcodieren = new JButton();
    private JButton jBdecode = new JButton();
    private JLabel jLkey1 = new JLabel();
    private JLabel jLkey2 = new JLabel();
    private JTextField jTkey1= new JTextField();
    private JTextField jTkey2 = new JTextField();
    private JLabel jLAnleitug = new JLabel();
    private Caesar caesar = new Caesar();
    // Ende Attribute

    public CaesartGUI() {
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 538;
        int frameHeight = 382;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        jLKlartext.setBounds(24, 24, 100, 16);
        jLKlartext.setText("Klartext");
        jLKlartext.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(jLKlartext);
        jTAKlartext.setBounds(24, 48, 121, 185);
        cp.add(jTAKlartext);
        jLGeheim.setBounds(315, 24, 100, 16);
        jLGeheim.setText("Geheimtext");
        jLGeheim.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(jLGeheim);
        jTAGeheimtext.setBounds(315, 48, 121, 185);
        cp.add(jTAGeheimtext);
        jLkey1.setBounds(152, 50, 100, 16);
        jLkey1.setText("Key:");
        jLkey1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(jLkey1);
        jTkey1.setBounds(152, 70, 150, 25);
        jTkey1.setText("5");
        jTkey1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(jTkey1);

        jBcodieren.setBounds(152, 100, 150, 25);
        jBcodieren.setText(">verschlüsseln>");
        jBcodieren.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jBcodieren_ActionPerformed(evt);
                }
            });

        cp.add(jBcodieren);
        jLkey2.setBounds(152, 130, 100, 16);
        jLkey2.setText("Key:");
        jLkey2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(jLkey2);
        jTkey2.setBounds(152, 150, 150, 25);
        jTkey2.setText("5");
        jTkey2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(jTkey2);

        jBdecode.setBounds(152, 180, 150, 25);
        jBdecode.setText("<entschlüsseln<");
        jBdecode.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jBdecode_ActionPerformed(evt);
                }
            });
        cp.add(jBdecode);
        jLAnleitug.setBounds(24, 248, 319, 16);
        jLAnleitug.setText("Texte ohne Leerzeichen eingeben");
        jLAnleitug.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(jLAnleitug);
        // Ende Komponenten

        setResizable(false);
        setVisible(true);
    }

    // Anfang Methoden
    public void jBcodieren_ActionPerformed(ActionEvent evt) {
        char[] klartext = jTAKlartext.getText().toCharArray();
        String vkey = jTkey1.getText();
        int key = Integer.parseInt(vkey);
        char[] geheimtext = caesar.verschluesseln(klartext,key);
        String lCode = String.valueOf(geheimtext);
        jTAGeheimtext.setText(lCode);
    }

    public void jBdecode_ActionPerformed(ActionEvent evt) {
        char[] geheimtext = jTAGeheimtext.getText().toCharArray();
        String vkey = jTkey2.getText();
        int key = Integer.parseInt(vkey);
        char[] klartext = caesar.entschluesseln(geheimtext, key);
        String lText = String.valueOf(klartext);
        jTAKlartext.setText(lText);
    }

}
