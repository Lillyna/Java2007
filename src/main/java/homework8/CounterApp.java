package homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {

    private int value;
    private JLabel infoLabel;

    public CounterApp(int x, int y) {
        setBounds(x, y, 410, 170);
        setTitle("Counter app");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Шрифт
        Font font = new Font("Arial", Font.BOLD, 32);

        //Кнопки увеличения и уменьшения с шагом 10
        setLayout(null);
        JButton decrement10Button = new JButton("<<");
        decrement10Button.setFont(font);
        decrement10Button.setBounds(0, 20, 80, 120);
        add(decrement10Button);
        JButton increment10Button = new JButton(">>");
        increment10Button.setFont(font);
        increment10Button.setBounds(320, 20, 80, 120);
        add(increment10Button);
        //Кнопки увеличения и уменьшения с шагом 1
        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        decrementButton.setBounds(80, 20, 60, 120);
        add(decrementButton);
        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        incrementButton.setBounds(260, 20, 60, 120);
        add(incrementButton);

        //Текствое поле, нередактируемое
        JLabel label = new JLabel(String.valueOf(value));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(170, 20, 60, 120);
        add(label);

        // Добавление инфопанели
        // Будем показывать ошибку, если значение счетчика по модулю > 10
        infoLabel = new JLabel();
        infoLabel.setBounds(0, 0, 400, 20);
        add(infoLabel);


        decrement10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value -= 10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        increment10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value += 10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        setVisible(true);
    }


    private void validateRange() {
        if (Math.abs(value) > 10) {
            infoLabel.setText("Value out of range");
        } else {
            infoLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new CounterApp(100, 100);

    }
}
