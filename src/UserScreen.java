import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserScreen extends JFrame{
    private JPanel UserScreenRootPanel;
    private JPanel labelsPanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JLabel phraseLabel;
    private JLabel keyLabel;
    private JPanel titlePanel;
    private JTextField shiftTextField;
    private JButton submitButton;
    private JCheckBox affineCipherCheckBox;
    private JCheckBox ceaserCipherCheckBox;
    private JTextArea phraseTextArea;
    private JTextField keyTextField;

    public UserScreen() {

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // checks to make sure only ceaser check box is selected and performs encryption
                if(ceaserCipherCheckBox.isSelected()&& !affineCipherCheckBox.isSelected()){
                    Ceaser cipher = new Ceaser();
                    int shift = Integer.parseInt(shiftTextField.getText());
                    String ciphertext = cipher.ceasarCipher(phraseTextArea.getText(),shift);
                    JOptionPane.showMessageDialog(null, " Dear Destination IP,"+"\n" + ciphertext + "\n" + " From," +"\n" +" Origin IP");
                }
                // checks to make sure affine check box is selected and performs encryption
                else if(affineCipherCheckBox.isSelected() &&!ceaserCipherCheckBox.isSelected()) {
                    Affine acipher = new Affine();
                    int alphaKey = Integer.parseInt(shiftTextField.getText());
                    int betaKey = Integer.parseInt(keyTextField.getText());
                    boolean passCheck = acipher.keyCheck(alphaKey, betaKey);
                    if (!passCheck) {
                        JOptionPane.showMessageDialog(null, "Error: keys do not meet requirements ");
                    } else {
                        String ciphertext = acipher.affineCipher(phraseTextArea.getText(), alphaKey, betaKey);
                        JOptionPane.showMessageDialog(null, " Dear Destination IP," + "\n" + ciphertext + "\n" + " From," + "\n" + " Origin IP");
                    }
                }
                // if  no ciphers or both ciphers are checked an error message is displayed
                else{
                    JOptionPane.showMessageDialog(null, "error");
                }
            }

        });

//        when the ceaser cipher is choosen the second key textfield disappears
        ceaserCipherCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(ceaserCipherCheckBox.isSelected()){
                    keyTextField.setVisible(false);
                    UserScreen.this.revalidate();
                    UserScreen.this.repaint();
                }
                else{
                    keyTextField.setVisible(true);
                    UserScreen.this.revalidate();
                    UserScreen.this.repaint();
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cryptography in Work");
        frame.setContentPane(new UserScreen().UserScreenRootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}