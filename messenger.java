import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class messenger {
    private static JFrame window;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel panel3;
    private static JButton sendbtn;
    private static JTextPane txt_field;
    private static JTextField number;
    private static JLabel label1;
    private static JFrame msgwindow;
    private static JPanel msgpanel1;
    private static JLabel msgstatus;
    private static JPanel msgpanel2;
    private static JButton okbtn;
    private static Thread status_thread;
    private static Thread group_thread;

    public static void main(String args[]) {

        window = new JFrame();
        window.setLayout(new BorderLayout());
        window.setResizable(true);
        window.setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel1.setBackground(Color.black);
        panel1.setLayout(new GridLayout(2, 1));
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        window.getContentPane().add(panel1, BorderLayout.NORTH);

        label1 = new JLabel("SEND TO");
        label1.setForeground(Color.yellow);
        panel1.add(label1);

        number = new JTextField();
        number.setPreferredSize(new Dimension(500, 50));
        number.setBackground(Color.black);
        number.setForeground(Color.YELLOW);
        number.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        number.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        number.setCaretColor(Color.yellow);
        panel1.add(number);

        panel2 = new JPanel();
        panel2.setBackground(Color.black);
        panel2.setLayout(new GridLayout(1, 1));
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        window.getContentPane().add(panel2, BorderLayout.CENTER);

        txt_field = new JTextPane();
        txt_field.setPreferredSize(new Dimension(500, 500));
        txt_field.setBackground(Color.black);
        txt_field.setForeground(Color.YELLOW);
        txt_field.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        txt_field.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        txt_field.setCaretColor(Color.yellow);
        panel2.add(txt_field);

        panel3 = new JPanel();
        panel3.setBackground(Color.black);
        panel3.setLayout(new GridLayout(1, 2));
        panel3.setBorder(BorderFactory.createEmptyBorder(0, 140, 20, 140));
        window.getContentPane().add(panel3, BorderLayout.SOUTH);

        sendbtn = new JButton();
        sendbtn.setText("Send");
        sendbtn.setBackground(null);
        sendbtn.setPreferredSize(new Dimension(30, 50));
        sendbtn.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        sendbtn.setForeground(Color.YELLOW);
        sendbtn.setFocusPainted(false);
        sendbtn.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel3.add(sendbtn);
        sendbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number.getText().contains(";")) {
                    group_msg();
                } else {
                    single_msg();
                }
            }
        });
        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    private static void single_msg() {
        try {

            window.setVisible(false);
            String to_send = "S" + number.getText() + "T" + txt_field.getText();
            to_hardware.send(to_send);
            status();

        } catch (Exception eio) {
            eio.printStackTrace();
        }
    }

    private static void group_msg() {
        String[] numbers = (number.getText()).split(";");
        group_thread = new Thread(new Runnable() {
            public void run() {
                status();

                for (int i = 0; i < numbers.length; i++) {

                    try {
                        System.out.println(i);
                        String to_send = "S" + numbers[i] + "T" + txt_field.getText();
                        to_hardware.send(to_send);
                        System.out.println("sending to" + numbers[i]);
                        BufferedReader br2 = new BufferedReader(new InputStreamReader(to_hardware.sp.getInputStream()));
                        while ((br2.readLine()) != null) {
                            if (br2.readLine().equals("ready")) {
                                System.out.println("ready");
                                to_hardware.sp.closePort();
                                Thread.sleep(3000);
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        group_thread.start();

    }

    private static void status() {

        status_thread = new Thread(new Runnable() {
            public void run() {
                try {

                    BufferedReader status_reader = new BufferedReader(
                            new InputStreamReader(to_hardware.sp.getInputStream()));
                    while (status_reader.readLine() != null) {
                       String line = status_reader.readLine();
                        if (line.equals("MESSAGE SENT") || line.equals("FAILED")) {
                            msgstatus.setText(line);
                            okbtn.setEnabled(true);
                            System.out.println(line);
                        }
                    }

                } catch (Exception eio) {
                    eio.printStackTrace();
                }
            }
        });
        status_thread.start();

        msgwindow = new JFrame();
        msgwindow.setUndecorated(true);
        msgwindow.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        msgwindow.setLayout(new BorderLayout());
        msgwindow.getContentPane().setBackground(Color.BLACK);
        msgwindow.setResizable(false);

        msgpanel1 = new JPanel();
        msgpanel1.setBackground(Color.BLACK);
        msgpanel1.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        msgpanel1.setLayout(new GridLayout(1, 1));
        msgwindow.getContentPane().add(msgpanel1, BorderLayout.NORTH);

        msgstatus = new JLabel();
        msgstatus.setText("SENDING");
        msgstatus.setPreferredSize(new Dimension(300, 50));
        msgstatus.setHorizontalAlignment(JTextField.CENTER);
        msgstatus.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
        msgstatus.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        msgstatus.setBackground(Color.black);
        msgstatus.setForeground(Color.yellow);
        msgpanel1.add(msgstatus);

        msgpanel2 = new JPanel();
        msgpanel2.setBackground(Color.BLACK);
        msgpanel2.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 100));
        msgpanel2.setLayout(new GridLayout(1, 1));
        msgwindow.getContentPane().add(msgpanel2, BorderLayout.SOUTH);

        okbtn = new JButton();
        okbtn.setPreferredSize(new Dimension(90, 60));
        okbtn.setBackground(null);
        okbtn.setText("OK");
        okbtn.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        okbtn.setForeground(Color.YELLOW);
        okbtn.setFocusPainted(false);
        okbtn.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        okbtn.setEnabled(false);
        msgpanel2.add(okbtn);
        okbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                status_thread.stop();
                msgwindow.dispose();
                to_hardware.sp.closePort();
                number.setText(null);
                txt_field.setText(null);
                window.setVisible(true);

            }

        });

        msgwindow.pack();
        msgwindow.setVisible(true);
        msgwindow.setLocationRelativeTo(null);

        
    }
}