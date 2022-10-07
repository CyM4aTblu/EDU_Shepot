import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

    // Colors
    Color darkCyan = new Color(66, 122, 171, 134);
    Color lightBlueBtn = new Color(162, 226, 245);
    Color greyCyan = new Color(53, 66, 75);
    Color greyExitButton = new Color(81, 90, 101);

    //---- GLOBAL ELEMENTS ------
    CardLayout crd;
    JPanel menu, about, review;
    Container box;
    // ---- ELEMENTS OF REVIEW SCREEN ----

    CardLayout reviewCrd;
    JPanel rw1,rw2,rw3,rw4,rw5,rw6,rw7;
    Container reviewSlides;

    MainFrame() {
        box = getContentPane();// set up for screens panels containers
        crd = new CardLayout();
        box.setLayout(crd);

        createMenu();//calling constructors of screen panels
        createAbout();
        createReview();
        setRw1();

        box.add("menu", menu);//adding elements in container
        box.add("about", about);
        box.add("review", review);
        //box.add("rw1", rw1);

        //----------------------------------------------------------------------------

        reviewSlides = new Container() ;// set up for slides
        reviewCrd = new CardLayout();
        reviewSlides.setLayout(reviewCrd);

        setRw1();

        reviewSlides.add("1", rw1);

        //---------------------------------------------------------------------------

        this.setVisible(true); //set up frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.setTitle("Edu SHEPOT");

        ImageIcon image = new ImageIcon(".\\assets\\Logo.png");
        this.setIconImage(image.getImage());


    }

    private void createMenu() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(new Color(224, 255, 255));

        JLabel img = new JLabel();
        img.setBounds(0, 50 ,500, 500);
        menu.add(img);
        ImageIcon unit = new ImageIcon(".\\assets\\shepot.png");
        img.setIcon(unit);
        menu.setLayout(null);

        JLabel txt = new JLabel();
        txt.setText("<html>Автоматизированный комплекс<br>для проведения акустических<br>и виброакустических измерений<br>''ШЕПОТ''</html>");
        txt.setForeground(new Color(0x76AFD0));
        txt.setFont(new Font("Calibri", Font.BOLD, 40 ));
        //txt.setVerticalAlignment(JLabel.TOP);
        txt.setBounds(500, 0, 700, 200);
        menu.add(txt);

        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(200, 243, 255, 255));
        buttons.setBounds(550, 250, 650, 350);
        //buttons.setLayout(new GridLayout(2, 1));
        menu.add(buttons);
        buttons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        buttons.setLayout(new GridLayout(3, 3, 10, 10));

        // Creating review button
        JButton reviewBtn = createMainMenuButton("Обзор", darkCyan, lightBlueBtn, 25, 10, 280, 90);
        reviewBtn.addActionListener(e -> crd.show(box, "review"));
        buttons.add(reviewBtn);

        // Creating Contents button
        JButton contBtn = createMainMenuButton("Состав", darkCyan, lightBlueBtn, 345, 10, 280, 90);
        contBtn.addActionListener(e -> {}); // TODO: fill w/ proper action
        buttons.add(contBtn);

        // Creating Learn button
        JButton learnBtn = createMainMenuButton("Обучение", darkCyan, lightBlueBtn, 25, 110, 280, 90);
        learnBtn.addActionListener(e -> {}); // TODO: fill w/ proper action
        buttons.add(learnBtn);

        // Creating Help button
        JButton helpBtn = createMainMenuButton("Справка", darkCyan, lightBlueBtn, 345, 110, 280, 90);
        helpBtn.addActionListener(e -> {}); // TODO: fill w/ proper action
        buttons.add(helpBtn);

        // Creating About button
        JButton aboutBtn = createMainMenuButton("О программе", darkCyan, lightBlueBtn, 25, 220, 280, 90);
        aboutBtn.addActionListener(e -> crd.show(box, "about"));
        buttons.add(aboutBtn);

        // Creating Exit Button
        JButton exitBtn = createMainMenuButton("Выход", greyCyan, greyExitButton, 345, 220, 280, 90);
        exitBtn.addActionListener(e -> super.dispose());
        buttons.add(exitBtn);
    }

    private void createAbout() {
        about = new JPanel();
        about.setLayout(null);
        about.setBackground(new Color(224, 255, 255));

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0 , 1280, 75);
        topBar.setBackground(new Color(197, 230, 236));
        about.add(topBar);

        JLabel txt = new JLabel();
        txt.setText("О программе");
        txt.setFont(new Font("Calibri", Font.BOLD, 70 ));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setForeground(new Color(140, 184, 225));
        topBar.add(txt);

        JPanel btmBar = new JPanel();
        btmBar.setLayout(null);
        btmBar.setBounds(0, 605 , 1280, 75);
        btmBar.setBackground(new Color(197, 230, 236));
        about.add(btmBar);

        JButton returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrow.png");
        returnToMenu.setBackground(new Color(209, 241, 255));
        returnToMenu.setBounds(50, 15, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { crd.show(box, "menu");

            }
        });
        btmBar.add(returnToMenu);
    }

    private void createReview() {


        //-----------------------------------------------------------------------

        review = new JPanel();
        review.setLayout(null);
        review.setBackground(new Color(224, 255, 255));

        JPanel btmBar = new JPanel();
        btmBar.setLayout(null);
        btmBar.setBounds(0, 605 , 1280, 75);
        btmBar.setBackground(new Color(209, 241, 255));
        review.add(btmBar);

        JButton returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrow.png");
        returnToMenu.setBounds(50, 15, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.setContentAreaFilled(false);
        returnToMenu.setFocusPainted(false);
        returnToMenu.setBorderPainted(false);
        returnToMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { crd.show(box, "menu");

            }
        });
        btmBar.add(returnToMenu);

        ImageIcon nxt = new ImageIcon(".\\assets\\ArrowNext.png");
        JButton nextSlide = new JButton(nxt);
        nextSlide.setFocusable(false);
        //nextSlide.setBackground(new Color(209, 241, 255));
        // mid X = 640
        nextSlide.setBounds(680, 5, 65, 65);
        nextSlide.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { reviewCrd.show(reviewSlides, "1");

            }
        });
        nextSlide.setContentAreaFilled(false);
        nextSlide.setFocusPainted(false);
        nextSlide.setBorderPainted(false);
        btmBar.add(nextSlide);
    }

    private JButton createMainMenuButton(String text, Color foreground, Color background, int x, int y, int width, int height) {
        JButton btn = new JButton(text);
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 45));
        btn.setForeground(foreground);
        btn.setBounds(x, y, width, height);
        btn.setBackground(background);
        return btn;
    }

    private void setRw1(){
        rw1 = new JPanel();
        rw1.setLayout(null);
        rw1.setBackground(new Color(221, 255, 209));
        rw1.setBounds(0,75 , 1280, 500);
    }
}