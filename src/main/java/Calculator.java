import com.sun.jdi.event.StepEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator {

    JFrame frame;
    JPanel panel;
    JPanel btnPanel;
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
        btnPanel = new JPanel();

        btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        btnPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
//        if (shouldFill) {
//            //natural height, maximum width
//            c.fill = GridBagConstraints.HORIZONTAL;
//        }

//        if (shouldWeightX) {
//            c.weightx = 0.5;
//        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;

//        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(5, 4));

        label = new JLabel(String.valueOf(firstValue));
        label.setSize(500, 100);

        label.setFont(label.getFont().deriveFont(30.0F));

        btnPanel.add(label, c);
        createButtons();

        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 5;

        btnPanel.add(panel, c);

        frame.add(btnPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
//        frame.setMaximumSize(new Dimension(500, 700));
//        frame.setMinimumSize(new Dimension(500, 700));
        frame.setVisible(true);
    }


    public void createButtons() {
        for (String symbol : buttonSymbols) {
            JButton button = new JButton(symbol);
            button.addActionListener(this::actionEvent);
            button.setFont(button.getFont().deriveFont(20.0F));
            panel.add(button);
        }
    }

    public void actionEvent(ActionEvent actionEvent) {
        if (isNumeric(actionEvent.getActionCommand())) {
            label.setText(label.getText().equals("0") ? actionEvent.getActionCommand() : label.getText() + actionEvent.getActionCommand());
        } else if(actionEvent.getActionCommand().equals("AC")){
            label.setText("0");
            firstValue = 0;
            secondValue = 0;
            operation = "";
        } else if(actionEvent.getActionCommand().equals("+/-")){
            label.setText(label.getText().startsWith("-") ? label.getText().substring(1) : "-" + label.getText());
        } else if(actionEvent.getActionCommand().equals("=")){
            secondValue = Integer.parseInt(label.getText());
            label.setText(String.valueOf(calculate()));
        }
        else {
            operation = actionEvent.getActionCommand();
            firstValue = Integer.parseInt(label.getText());
            label.setText("");
        }

//
//        switch (actionEvent.getActionCommand()){
//            case "AC":
//                label.setText("0");
//                firstValue = 0;
//                secondValue = 0;
//                operation = "";
//                break;
//            case "+/-":
//                label.setText(label.getText().startsWith("-") ? label.getText().substring(1) : "-" + label.getText());
//                break;
//            case "=":
//                secondValue = Integer.parseInt(label.getText());
//                label.setText(String.valueOf(calculate()));
//                break;
//            default:
//                operation = actionEvent.getActionCommand();
//                firstValue = Integer.parseInt(label.getText());
//                label.setText("");
//        }
    }

    public Integer calculate(){
        int result = 0;
        switch (operation){
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "x":
                result = firstValue * secondValue;
                break;
            case "÷":
                result = firstValue / secondValue;
                break;
            case "%":
                result = firstValue / 100;
                break;
        }
        operation = "";
        firstValue = result;
        return result;
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
