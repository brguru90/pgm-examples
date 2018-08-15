
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class guru extends JFrame {
    //declaring objects as global to all function in this class
    //label
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    //text field
    JTextField a = new JTextField();
    JTextField b = new JTextField();
    //text area
    JTextArea ans = new JTextArea("Answer:");
    //buttons
    JButton add = new JButton();
    JButton sub = new JButton();
    JButton mul = new JButton();
    JButton div = new JButton();
    //panel in which label,buttons,textfield & text area resides
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    //splitting a main pannel which contain other sub panel vertcally aligned
    JSplitPane js;
    JSplitPane js1;
    JSplitPane js2;

    public guru() {
        //A main panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        /*
        ImageIcon image = new ImageIcon("flight.gif");
        label = new JLabel("JLabel", image, SwingConstants.RIGHT);
        label.setVerticalTextPosition(SwingConstants.TOP);
        label.setOpaque(true);
        label.setBackground(Color.white);
        content.add(label);
         */
        createBanner();
        getValues();
        operations();
        putAns();
        //combination of first 2 panel(1,2)
        js1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//vertcal alignment
        topPanel.add(js1, BorderLayout.CENTER);
        js1.setLeftComponent(panel1);
        js1.setRightComponent(panel2);
        //combination of second 2 panel(2,3)
        js2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        topPanel.add(js2, BorderLayout.CENTER);
        js2.setLeftComponent(panel3);
        js2.setRightComponent(panel4);
        //combination of all(1,2,3,4)
        js = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        topPanel.add(js, BorderLayout.CENTER);
        js.setLeftComponent(js1);
        js.setRightComponent(js2);

        //button event listener to call addNum() function
        add.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ans.setText("0");
                addNum(e);
            }
        });
        sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ans.setText("0");
                subNum(e);
            }
        });
        mul.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ans.setText("0");
                mulNum(e);
            }
        });
        div.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ans.setText("0");
                divNum(e);
            }
        });

    }
    //body of declared adding function
    public void addNum(java.awt.event.ActionEvent e) {
        int val1 = Integer.parseInt(a.getText());
        int val2 = Integer.parseInt(b.getText());
        int val = val1 + val2;
        ans.setText("ans: " + val);
    }

    public void subNum(java.awt.event.ActionEvent e) {
        int val1 = Integer.parseInt(a.getText());
        int val2=Integer.parseInt(b.getText());
        int val = val1 - val2;
        ans.setText("ans:"+val);
    }
    
    public void mulNum(java.awt.event.ActionEvent e) {
        int val1 = Integer.parseInt(a.getText());
        int val2=Integer.parseInt(b.getText());
        int val = val1 * val2;
        ans.setText("ans:"+val);
    }
    
    public void divNum(java.awt.event.ActionEvent e) {
        int val1 = Integer.parseInt(a.getText());
        int val2=Integer.parseInt(b.getText());
        try{
            int val=val1/val2;
            ans.setText("ans: "+val);
        }
        catch(Exception evt){
            ans.setText("infinite");
        } 
    }
    //creating panel1 which hold label1 as a whole
    public void createBanner() {
        panel1.setLayout(new BorderLayout());
        label1.setText("");
        label1.setText("guru");
        label1.setOpaque(true);//if background color present
        label1.setBackground(Color.green);
        label1.setForeground(Color.red);
        //label1.setFont(new Font("Helvetica", Font.BOLD, 18));
        label1.setFont(new Font("Arial", Font.BOLD, 30));
        label1.setVerticalTextPosition(SwingConstants.CENTER);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.setLayout(new GridLayout(1, 1, 10, 10));
        panel1.add(label1);
    }
    //creating panel1 which hold label2 & label3 as a seperate 2
    public void getValues() {
        panel2.setLayout(new BorderLayout());

        panel2.setLayout(new BorderLayout());
        label2.setText("Enter value for A");
        label2.setOpaque(true);
        label2.setBackground(Color.white);
        label2.setForeground(Color.blue);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        label2.setVerticalTextPosition(SwingConstants.CENTER);
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        label3.setText("Enter value for B");
        label3.setOpaque(true);
        label3.setBackground(Color.white);
        label3.setForeground(Color.blue);
        label3.setFont(new Font("Arial", Font.BOLD, 12));
        label3.setVerticalTextPosition(SwingConstants.CENTER);
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        panel2.setLayout(new GridLayout(2, 2, 10, 10));//2row 2column hoizontal_rgap verticle_gap
        panel2.add(label2);
        panel2.add(a);
        panel2.add(label3);
        panel2.add(b);
    }

    public void operations() {
        panel3.setLayout(new BorderLayout());
        panel3.setLayout(new GridLayout(1, 4, 10, 10));
        add.setBackground(Color.blue);
        add.setForeground(Color.white);
        add.setFont(new Font("Arial", Font.BOLD, 14));
        sub.setBackground(Color.blue);
        sub.setForeground(Color.white);
        sub.setFont(new Font("Arial", Font.BOLD, 14));
        mul.setBackground(Color.blue);
        mul.setForeground(Color.white);
        mul.setFont(new Font("Arial", Font.BOLD, 14));
        div.setBackground(Color.blue);
        div.setForeground(Color.white);
        div.setFont(new Font("Arial", Font.BOLD, 14));
        add.setText("add");
        sub.setText("sub");
        mul.setText("mul");
        div.setText("div");
        panel3.add(add);
        panel3.add(sub);
        panel3.add(mul);
        panel3.add(div);
        panel3.setMinimumSize(new Dimension(150, 40));

    }

    public void putAns() {
        panel4.setLayout(new BorderLayout());
        panel4.setLayout(new GridLayout(1, 1, 10, 10));
        ans.setFont(new Font("Arial", Font.BOLD, 16));
        panel4.add(ans);
    }

    public static void main(String args[]) {
        guru g = new guru();
        g.setVisible(true);
        g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        g.setSize(300, 250);
        g.setTitle("guru");

    }

}
