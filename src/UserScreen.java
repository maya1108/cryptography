import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserScreen extends JFrame{
    private JPanel UserScreenRootPanel;
    private JPanel labelsPanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JLabel phraseLabel;
    private JLabel shiftsLabel;
    private JPanel titlePanel;
    private JTextField phraseTextField;
    private JTextField shiftTextField;
    private JButton submitButton;

    public UserScreen() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ceaser cipher = new Ceaser();
                int shift = Integer.parseInt(shiftTextField.getText());
                String ciphertext = cipher.ceasarCipher(phraseTextField.getText(),shift);
                JOptionPane.showMessageDialog(null, " Dear Destination IP,"+"\n" + ciphertext + "\n" + " From," +"\n" +" Origin IP");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreen");
        frame.setContentPane(new UserScreen().UserScreenRootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
