import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReviewFrame extends JPanel {
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;

    ReviewFrame(ActionListener onReturn) {
        crd = new CardLayout();
        createReview();
         // set up for screens panels containers
        slideShow.add("1", createSlide(new Color(221, 255, 209)));
        slideShow.add("2", createSlide(new Color(150, 240, 209)));
        slideShow.add("3", createSlide(new Color(100, 225, 209)));
        slideShow.add("4", createSlide(new Color(70, 210, 209)));
        slideShow.add("5", createSlide(new Color(50, 195, 209)));
        slideShow.add("6", createSlide(new Color(30, 180, 209)));
        slideShow.add("7", createSlide(new Color(0, 165, 209)));
        crd.show(slideShow, "1");

        returnToMenu.addActionListener(onReturn);
    }

    private void createReview() {
        this.setLayout(null);
        slideShow = createSlide(Color.BLACK);
        slideShow.setLayout(crd);
        this.add(slideShow);
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
        nextSlide.addActionListener(e -> crd.next(slideShow));
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
        prevSlide.addActionListener(e -> crd.previous(slideShow));
        prevSlide.setContentAreaFilled(false);
        prevSlide.setFocusPainted(false);
        prevSlide.setBorderPainted(false);
        bottomNavBar.add(prevSlide);
    }

    private JPanel createSlide(Color color){
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(color);
        slide.setBounds(0,0 , 1280, 605);
        return slide;
    }
}
