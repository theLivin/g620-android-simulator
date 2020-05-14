import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class ContactDetailsPage extends PhonePresetWithNoWallpaper implements ActionListener{
    // Variable declarations and definitions
    private static final Font font = new Font("lato", Font.PLAIN, 14);

    private JButton backBtn = new JButton("Back");
    private JButton editBtn = new JButton("Edit");
    private JButton msgBtn = new JButton("Send Message");
    private JLabel nameLabel;
    private JButton dialBtn;

    private String contactName;
    
    // Constructor -->
    public ContactDetailsPage(String contactName){ 
        setLayout(null);

        this.contactName = contactName;

        // back Button
        backBtn.setFont(font);
        backBtn.setForeground(Color.BLUE);
        backBtn.setBounds(150, 60, 80, 20);
        backBtn.setHorizontalAlignment(SwingConstants.LEFT);
        makeButtonTransparent(backBtn, false);
        add(backBtn);
        backBtn.addActionListener(this);

        // edit Button
        editBtn.setFont(font);
        editBtn.setForeground(Color.BLUE);
        editBtn.setBounds(190, 60, 80, 20);
        editBtn.setHorizontalAlignment(SwingConstants.RIGHT);
        makeButtonTransparent(editBtn, false);
        add(editBtn);
        editBtn.addActionListener(this);

        // Contacts
        showContactDetails(contactName, "0545712836");

    }// <-- end Constructor

    // Show contacts on screen from param array
    public void showContactDetails(String name, String number){
        // Load user icon
        Icon user;
        if ( name == "Titus" || name == "Ahornam" || name == "Nii")
            user = new ImageIcon(getClass().getResource("./images/icons/user-m.png"));
        else
            user = new ImageIcon(getClass().getResource("./images/icons/user-f.png"));

        // Contacts List
        // -- load dial icon
        Icon dial = new ImageIcon(getClass().getResource("./images/icons/dial.png"));

        int x = 23, y = 120, w = 235, h = 150;

        // -- name button
        nameLabel = new JLabel(name, user, JLabel.CENTER);
        nameLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        nameLabel.setBounds(200, y, w, h);
        nameLabel.setIconTextGap(10);
        nameLabel.setVerticalTextPosition(JLabel.BOTTOM);
        nameLabel.setHorizontalTextPosition(JLabel.CENTER);
        add(nameLabel);

        // -- dial button
        y = y+h+10;
        h = 35;
        dialBtn = new JButton(number, dial);
        dialBtn.setFont(font);
        dialBtn.setBounds(200, y, w, h);
        dialBtn.setHorizontalAlignment(SwingConstants.LEFT);
        dialBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        dialBtn.setIconTextGap(95);
        dialBtn.setBackground(Color.WHITE);                  
        add(dialBtn);
        dialBtn.addActionListener(this);

        // -- send message Button
        y = y+h+10;
        msgBtn.setFont(font);
        msgBtn.setForeground(Color.BLUE);
        msgBtn.setBounds(200, y, w, h);
        msgBtn.setHorizontalAlignment(SwingConstants.LEFT);
        msgBtn.setBackground(Color.WHITE);
        add(msgBtn);
        msgBtn.addActionListener(this);

    }// <-- end showContactDetails

    // Make a button transparent
    public void makeButtonTransparent(JButton btn, boolean visibleBorder){
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(visibleBorder);
    }// <-- end makeButtonTransparent

    // Handle ActionListener events
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == backBtn){
            // -- go back to contacts page
            ContactsPage panel = new ContactsPage();
            NewWindowFrame frame = new NewWindowFrame(panel);
            frame.setVisible(true);
            ((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
        }
        if (e.getSource() == editBtn){
            System.out.println("we'll edit later");
        }
        if (e.getSource() == dialBtn){
            System.out.println("dialing "+contactName+"...");
        }
        if (e.getSource() == msgBtn){
            System.out.println("we'll start messaging "+contactName+" shortly");
        }
    }// <-- end actionPerformed

}