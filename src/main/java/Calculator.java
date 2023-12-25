import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator {


    JFrame frame;
    JPanel panel;
    JLabel label;

    int firstValue = 0;
    int secondValue = 0;
    String operation = "";


    private static String[] buttonSymbols = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "x",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "="
    };

    public Calculator() {
        frame = new JFrame("Calculator");
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(5, 4));

        label = new JLabel(String.valueOf(firstValue));
        label.setSize(500, 100);

        panel.add(label);
        createButtons();


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setMaximumSize(new Dimension(500, 700));
        frame.setMinimumSize(new Dimension(500, 700));
        frame.setVisible(true);
    }


    public void createButtons() {
        for (String symbol : buttonSymbols) {
            JButton button = new JButton(symbol);
            button.addActionListener(this::actionEvent);
            panel.add(button);
        }
    }

    public void actionEvent(ActionEvent actionEvent) {
        if (isNumeric(actionEvent.getActionCommand())) {
            label.setText(label.getText().equals("0") ? actionEvent.getActionCommand() : label.getText() + actionEvent.getActionCommand());
        }

        switch (actionEvent.getActionCommand()){
            case "AC":
                label.setText("0");
                firstValue = 0;
                secondValue = 0;
                operation = "";
                break;
            case "+/-":
                label.setText(Integer.parseInt(label.getText()) < 0 ? label.getText().substring(1) : "-" + label.getText());
                break;
            case "=":

        }


//        if (actionEvent.getActionCommand().equals("=")) {
//            secondValue = Integer.parseInt(label.getText());
//
//
//        }
//
//        firstValue = Integer.parseInt(label.getText());
//        operation = actionEvent.getActionCommand();
    }

    public boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        new Calculator();
    }


}
