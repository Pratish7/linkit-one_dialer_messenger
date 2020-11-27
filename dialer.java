import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class dialer {
    private static JFrame window;
    private static JButton btn0;
    private static JButton btn1;
    private static JButton btn2;
    private static JButton btn3;
    private static JButton btn4;
    private static JButton btn5;
    private static JButton btn6;
    private static JButton btn7;
    private static JButton btn8;
    private static JButton btn9;
    private static JButton btnclr;
    private static JButton btnclrall;
    private static JButton btncall;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel panel3;
    private static JTextField num;
    private static JFrame callwindow;
    private static JButton endcall;
    private static JLabel callstatus;
    private static JPanel callpanel1;
    private static JPanel callpanel2;
    private static Thread get_call;
    private static Thread status_thread;
    private static Thread call_thread;

    public static void main(String args[]) {

        window = new JFrame();
        window.setLayout(new BorderLayout());
        window.setBackground(Color.BLACK);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel1.setLayout(new GridLayout(1, 1));
        window.getContentPane().add(panel1, BorderLayout.NORTH);

        num = new JTextField();
        num.setPreferredSize(new Dimension(500, 70));
        num.setBackground(Color.black);
        num.setForeground(Color.YELLOW);
        num.setEditable(false);
        num.setHighlighter(null);
        num.setHorizontalAlignment(JTextField.CENTER);
        num.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
        num.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel1.add(num);

        panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        panel2.setLayout(new GridLayout(4, 3));
        window.getContentPane().add(panel2, BorderLayout.CENTER);

        btn1 = new JButton();
        btn1.setText("1");
        btn1.setBackground(null);
        btn1.setPreferredSize(new Dimension(100, 70));
        btn1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn1.setForeground(Color.YELLOW);
        btn1.setFocusPainted(false);
        btn1.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "1");
            }
        });

        btn2 = new JButton();
        btn2.setText("2");
        btn2.setBackground(null);
        btn2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn2.setForeground(Color.YELLOW);
        btn2.setFocusPainted(false);
        btn2.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn2);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "2");
            }
        });

        btn3 = new JButton();
        btn3.setText("3");
        btn3.setBackground(null);
        btn3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn3.setForeground(Color.YELLOW);
        btn3.setFocusPainted(false);
        btn3.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn3);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "3");
            }
        });

        btn4 = new JButton();
        btn4.setText("4");
        btn4.setBackground(null);
        btn4.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn4.setForeground(Color.YELLOW);
        btn4.setFocusPainted(false);
        btn4.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn4);
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "4");
            }
        });

        btn5 = new JButton();
        btn5.setText("5");
        btn5.setBackground(null);
        btn5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn5.setForeground(Color.YELLOW);
        btn5.setFocusPainted(false);
        btn5.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn5);
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "5");
            }
        });

        btn6 = new JButton();
        btn6.setText("6");
        btn6.setBackground(null);
        btn6.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn6.setForeground(Color.YELLOW);
        btn6.setFocusPainted(false);
        btn6.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn6);
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "6");
            }
        });

        btn7 = new JButton();
        btn7.setText("7");
        btn7.setBackground(null);
        btn7.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn7.setForeground(Color.YELLOW);
        btn7.setFocusPainted(false);
        btn7.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn7);
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "7");
            }
        });

        btn8 = new JButton();
        btn8.setText("8");
        btn8.setBackground(null);
        btn8.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn8.setForeground(Color.YELLOW);
        btn8.setFocusPainted(false);
        btn8.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn8);
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "8");
            }
        });

        btn9 = new JButton();
        btn9.setText("9");
        btn9.setBackground(null);
        btn9.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn9.setForeground(Color.YELLOW);
        btn9.setFocusPainted(false);
        btn9.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn9);
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "9");
            }
        });

        btnclr = new JButton();
        btnclr.setText("CLEAR");
        btnclr.setBackground(null);
        btnclr.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btnclr.setForeground(Color.YELLOW);
        btnclr.setFocusPainted(false);
        btnclr.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btnclr);
        btnclr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (num.getText().length() > 0) {
                    num.setText(num.getText().substring(0, num.getText().length() - 1));
                }
            }
        });

        btn0 = new JButton();
        btn0.setText("0");
        btn0.setBackground(null);
        btn0.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btn0.setForeground(Color.YELLOW);
        btn0.setFocusPainted(false);
        btn0.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btn0);
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(num.getText() + "0");
            }
        });

        btnclrall = new JButton();
        btnclrall.setText("CLEAR ALL");
        btnclrall.setBackground(null);
        btnclrall.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btnclrall.setForeground(Color.YELLOW);
        btnclrall.setFocusPainted(false);
        btnclrall.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel2.add(btnclrall);
        btnclrall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num.setText(null);
            }
        });

        panel3 = new JPanel();
        panel3.setBackground(Color.BLACK);
        panel3.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        panel3.setLayout(new GridLayout(1, 1));
        window.getContentPane().add(panel3, BorderLayout.SOUTH);

        btncall = new JButton();
        btncall.setPreferredSize(new Dimension(50, 70));
        btncall.setText("CALL");
        btncall.setBackground(Color.black);
        btncall.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btncall.setForeground(Color.YELLOW);
        btncall.setFocusPainted(false);
        btncall.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        panel3.add(btncall);
        btncall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String to_send = "C" + (num.getText());
                    to_hardware.send(to_send);
                } catch (Exception e1) {
                }

                get_call = new Thread(new Runnable() {
                    public void run() {

                        try {
                            BufferedReader br1 = new BufferedReader(
                                    new InputStreamReader(to_hardware.sp.getInputStream()));
                            String line;
                            while ((line = br1.readLine()) != null) {
                                call_open(line);
                                window.setVisible(false);
                                break;

                            }
                            get_call.stop();
                        } catch (IOException eio) {
                            eio.printStackTrace();
                        }
                    }
                });
                get_call.start();

            }
        });

        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    private static void call_open(String data_rec) {
        callwindow = new JFrame();
        callwindow.setUndecorated(true);
        callwindow.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        callwindow.setLayout(new BorderLayout());
        callwindow.getContentPane().setBackground(Color.BLACK);
        callwindow.setResizable(false);

        callpanel1 = new JPanel();
        callpanel1.setBackground(Color.BLACK);
        callpanel1.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        callpanel1.setLayout(new GridLayout(1, 1));
        callwindow.getContentPane().add(callpanel1, BorderLayout.NORTH);

        callstatus = new JLabel();
        callstatus.setPreferredSize(new Dimension(300, 50));
        callstatus.setHorizontalAlignment(JTextField.CENTER);
        callstatus.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
        callstatus.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        callstatus.setBackground(Color.black);
        callstatus.setForeground(Color.yellow);
        callpanel1.add(callstatus);

        //if (data_rec==("called").toString()){
        
            
         callstatus.setText("CALL RUNNING");
       // }
            
            
        callpanel2 = new JPanel();
        callpanel2.setBackground(Color.BLACK);
        callpanel2.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 100));
        callpanel2.setLayout(new GridLayout(1, 1));
        callwindow.getContentPane().add(callpanel2, BorderLayout.SOUTH);

        endcall = new JButton();
        endcall.setPreferredSize(new Dimension(90, 60));
        endcall.setBackground(null);
        endcall.setText("END CALL");
        endcall.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        endcall.setForeground(Color.YELLOW);
        endcall.setFocusPainted(false);
        endcall.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        callpanel2.add(endcall);
        endcall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                callstatus.setText("ENDING CALL");
                status_thread.stop();
                
                // try {
				//  	Thread.sleep(3000);
				//  } catch (InterruptedException e1) {
                //     e1.printStackTrace();
                //  }
                window.setVisible(true);
                callwindow.dispose();
                try{
                String i = "0";
                to_hardware.sp.getOutputStream().write(i.getBytes());
                to_hardware.sp.getOutputStream().flush();
                to_hardware.sp.closePort();
                }catch(IOException en){
                    en.printStackTrace();
                }
            }
        });

        callwindow.pack();
        callwindow.setVisible(true);
        callwindow.setLocationRelativeTo(null);

        status_thread = new Thread(new Runnable() {
            public void run() {
                try {
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(to_hardware.sp.getInputStream()));
                    String line;
                    while ((line = br2.readLine()) != null) {
                    if (line == "called"){
                        //endcall.setText("CALL RUNNING");
                    }
                    }

                } catch (Exception eio) {
                }
            }
        });
        status_thread.start();

    }
}