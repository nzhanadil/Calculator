import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI {

    int count = 0;
    JLabel label;
    JFrame frame;
    JPanel panel;

    int value = 0;

    public void createButtons() {

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));

            button.addActionListener(this::setNumber);
            panel.add(button);
        }
    }

    private void setNumber(ActionEvent actionEvent) {
        label.setText(label.getText() + actionEvent.getActionCommand());
    }

    public static void main(String[] args) {
       GUI gui = new GUI();

       gui.GUI();
    }

    public void GUI(){
        frame = new JFrame("Calculator");
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridBagLayout());

        label = new JLabel(String.valueOf(count));
        label.setSize(500, 100);

        JButton button = new JButton("MY");

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        panel.add(button);
        panel.add(label);
        createButtons();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setMaximumSize(new Dimension(500, 700));
        frame.setMinimumSize(new Dimension(500, 700));
        frame.setVisible(true);

    }



    public GUI() {
        frame = new JFrame("Calculator");
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(10, 0));

        label = new JLabel("0");


        label.setForeground(Color.red);
        label.setBackground(Color.black);
        label.setSize(500, 100);

        panel.add(label);

//        createLabel();
        createButtons();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setMaximumSize(new Dimension(500, 700));
        frame.setMinimumSize(new Dimension(500, 700));
        frame.setVisible(true);
    }
}
