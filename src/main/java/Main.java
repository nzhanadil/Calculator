import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Calculator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setPreferredSize(new Dimension(600, 800));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        JButton button = new JButton("JBIB");
        button.setBounds(50, 200, 100, 30);

        JButton plusButton = new JButton("+");
        plusButton.setBounds(50, 50, 100, 30);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 200, 300);
        panel.add(button);
        panel.add(plusButton);

        jFrame.add(panel);

    }
}
