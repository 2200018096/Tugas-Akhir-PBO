import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2, b3;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    JMenuItem helpMenuItem;

    OnlineTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
            jb[i].setFont(new Font("Arial", Font.PLAIN, 14));
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b3 = new JButton("Back");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        add(b1);
        add(b2);
        add(b3);

        // Tambahkan menu "Bantuan"
        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Bantuan");
        helpMenuItem = new JMenuItem("Petunjuk Penggunaan");
        helpMenuItem.addActionListener(this);
        helpMenu.add(helpMenuItem);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        set();
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 250, 20);
        jb[1].setBounds(50, 110, 250, 20);
        jb[2].setBounds(50, 140, 250, 20);
        jb[3].setBounds(50, 170, 250, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        b3.setBounds(180, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
        getContentPane().setBackground(new Color(255, 228, 225)); // Background color

        b1.setBackground(new Color(135, 206, 250));
        b2.setBackground(new Color(144, 238, 144));
        b3.setBackground(new Color(255, 182, 193));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }

        if (e.getSource() == b3) {
            current--;
            set();

            if (current == 0) {
                b3.setEnabled(false);
            } else {
                b3.setEnabled(true);
                b1.setEnabled(true);
            }
        }
        if (e.getSource() == b1) {
            b3.setEnabled(true);
        }

        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        } else if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct answers: " + count);
            System.exit(0);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }

        if (e.getSource() == helpMenuItem) {
            JOptionPane.showMessageDialog(this, "Ini adalah petunjuk penggunaan. Silakan ikuti instruksi dengan cermat.");
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Pertanyaan 1: Yang mana di antara ini bukan tipe data primitif?");
            jb[0].setText("int");
            jb[1].setText("Float");
            jb[2].setText("boolean");
            jb[3].setText("char");
        }
        if (current == 1) {
            l.setText("Pertanyaan 2: Kelas mana yang tersedia secara otomatis untuk semua kelas?");
            jb[0].setText("Swing");
            jb[1].setText("Applet");
            jb[2].setText("Object");
            jb[3].setText("ActionEvent");
        }
        if (current == 2) {
            l.setText("Pertanyaan 3: Paket mana yang tersedia langsung untuk kelas kita tanpa mengimpor?");
            jb[0].setText("swing");
            jb[1].setText("applet");
            jb[2].setText("net");
            jb[3].setText("lang");
        }
        if (current == 3) {
            l.setText("Pertanyaan 4: Kelas String didefinisikan dalam paket mana?");
            jb[0].setText("lang");
            jb[1].setText("Swing");
            jb[2].setText("Applet");
            jb[3].setText("awt");
        }
        if (current == 4) {
            l.setText("Pertanyaan 5: Institut mana yang terbaik untuk pelatihan Java?");
            jb[0].setText("Utek");
            jb[1].setText("Aptech");
            jb[2].setText("SSS IT");
            jb[3].setText("jtek");
        }
        if (current == 5) {
            l.setText("Pertanyaan 6: Yang mana di antara ini bukan kata kunci?");
            jb[0].setText("class");
            jb[1].setText("int");
            jb[2].setText("get");
            jb[3].setText("if");
        }
        if (current == 6) {
            l.setText("Pertanyaan 7: Yang mana di antara ini bukan kelas?");
            jb[0].setText("Swing");
            jb[1].setText("Actionperformed");
            jb[2].setText("ActionEvent");
            jb[3].setText("Button");
        }
        if (current == 7) {
            l.setText("Pertanyaan 8: Yang mana di antara ini bukan fungsi dari kelas Object?");
            jb[0].setText("toString");
            jb[1].setText("finalize");
            jb[2].setText("equals");
            jb[3].setText("getDocumentBase");
        }
        if (current == 8) {
            l.setText("Pertanyaan 9: Fungsi mana yang tidak ada dalam kelas Applet?");
            jb[0].setText("init");
            jb[1].setText("main");
            jb[2].setText("start");
            jb[3].setText("destroy");
        }
        if (current == 9) {
            l.setText("Pertanyaan 10: Yang mana di antara ini bukan komponen yang valid?");
            jb[0].setText("JButton");
            jb[1].setText("JList");
            jb[2].setText("JButtonGroup");
            jb[3].setText("JTextArea");
        }
        l.setBounds(30, 40, 1000, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[2].isSelected());
        if (current == 2)
            return (jb[3].isSelected());
        if (current == 3)
            return (jb[0].isSelected());
        if (current == 4)
            return (jb[2].isSelected());
        if (current == 5)
            return (jb[2].isSelected());
        if (current == 6)
            return (jb[1].isSelected());
        if (current == 7)
            return (jb[3].isSelected());
        if (current == 8)
            return (jb[1].isSelected());
        if (current == 9)
            return (jb[2].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test Of Java");
    }
}
