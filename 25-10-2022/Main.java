import javax.swing.*;

import java.math.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("My Window");
        frame.setSize(700, 300);
        frame.setLocation(200, 250);
        JLabel text = new JLabel("I am inside");
        frame.getContentPane().add(text);
        frame.setVisible(true);

    }
}