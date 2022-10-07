import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewFrame extends JPanel {
    private CardLayout crd = new CardLayout();
    private Container box = new Container();
    private JButton returnToMenu;

    ReviewFrame(ActionListener onReturn) {
        box.setLayout(crd); // set up for screens panels containers
        createReview();
        box.add("1", createSlide(new Color(221, 255, 209)));
        returnToMenu.addActionListener(onReturn);
    }

    private void createReview() {
        this.setLayout(null);
        this.setBackground(new Color(224, 255, 255));

        JPanel bottomNavBar = new JPanel();
        bottomNavBar.setLayout(null);
        bottomNavBar.setBounds(0, 605 , 1280, 75);
        bottomNavBar.setBackground(new Color(209, 241, 255));
        this.add(bottomNavBar);

        returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrow.png");
        returnToMenu.setBounds(50, 15, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.setContentAreaFilled(false);
        returnToMenu.setFocusPainted(false);
        returnToMenu.setBorderPainted(false);
        bottomNavBar.add(returnToMenu);

        ImageIcon nxt = new ImageIcon(".\\assets\\ArrowNext.png");
        JButton nextSlide = new JButton(nxt);
        nextSlide.setFocusable(false);
        //nextSlide.setBackground(new Color(209, 241, 255));
        // mid X = 640
        nextSlide.setBounds(680, 5, 65, 65);
        nextSlide.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nextSlide.setContentAreaFilled(false);
        nextSlide.setFocusPainted(false);
        nextSlide.setBorderPainted(false);
        bottomNavBar.add(nextSlide);

        ImageIcon prv = new ImageIcon(".\\assets\\ArrowBack.png");
        JButton prevSlide = new JButton(prv);
        prevSlide.setFocusable(false);
        //nextSlide.setBackground(new Color(209, 241, 255));
        // mid X = 640
        prevSlide.setBounds(615, 5, 65, 65);
        prevSlide.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        prevSlide.setContentAreaFilled(false);
        prevSlide.setFocusPainted(false);
        prevSlide.setBorderPainted(false);
        bottomNavBar.add(prevSlide);
    }

    private JPanel createSlide(Color color){
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(color);
        slide.setBounds(0,75 , 1280, 500);
        return slide;
    }
}
