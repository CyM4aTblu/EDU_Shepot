import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    //---- GLOBAL ELEMENTS ------
    CardLayout crd;
    JPanel menu, about, review;
    Container boxWithMenuSectionPanels;
    // ---- ELEMENTS OF REVIEW SCREEN ----

//    CardLayout reviewCrd;
//    JPanel rw1,rw2,rw3,rw4,rw5,rw6,rw7;
//    Container reviewSlides;

    MainFrame() {
        boxWithMenuSectionPanels = getContentPane();// set up for screens panels containers
        crd = new CardLayout();
        boxWithMenuSectionPanels.setLayout(crd);

        createMenu();//calling constructors of screen panels
        createAbout();
        createReview();
        //setRw1();

        boxWithMenuSectionPanels.add("menu", menu);//adding elements in container
        boxWithMenuSectionPanels.add("about", about);
        boxWithMenuSectionPanels.add("review", review);
        //box.add("rw1", rw1);

        //----------------------------------------------------------------------------

//        reviewSlides = getContentPane();// set up for slides
//        reviewCrd = new CardLayout();
//        reviewSlides.setLayout(reviewCrd);
//
//        setRw1();
//
//        reviewSlides.add("1", rw1);

        //---------------------------------------------------------------------------

        this.setVisible(true); //set up frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.setTitle("Edu SHEPOT");

        ImageIcon image = new ImageIcon(".\\src\\Logo.png");
        this.setIconImage(image.getImage());


    }

    private JPanel createBottomBar(boolean isBackButton){
        JPanel btmBar = new JPanel();
        btmBar.setLayout(null);
        btmBar.setBounds(0, 605 , 1280, 75);
        btmBar.setBackground(topBtmBarBackground);

        if(isBackButton) {
            JButton returnToMenu = new JButton();
            returnToMenu.setFocusable(false);
            ImageIcon img = new ImageIcon(".\\src\\ReturnArrow.png");
            returnToMenu.setBounds(50, 15, 100, 45);
            returnToMenu.setIcon(img);
            returnToMenu.setContentAreaFilled(false);
            returnToMenu.setFocusPainted(false);
            returnToMenu.setBorderPainted(false);
            returnToMenu.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    crd.show(boxWithMenuSectionPanels, "menu");

                }
            });
            btmBar.add(returnToMenu);
        }
        return btmBar;
    }
    private void createMenu() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(new Color(224, 255, 255));

        JLabel img = new JLabel();
        img.setBounds(0, 50 ,500, 500);
        menu.add(img);
        ImageIcon unit = new ImageIcon(".\\src\\shepot.png");
        img.setIcon(unit);
        menu.setLayout(null);

        JLabel txt = new JLabel();
        txt.setText("<html>Автоматизированный комплекс<br>для проведения акустических<br>и виброакустических измерений<br>''ШЕПОТ''</html>");
        txt.setForeground(textColor);
        txt.setFont(new Font("Calibri", Font.BOLD, 40 ));
        //txt.setVerticalAlignment(JLabel.TOP);
        txt.setBounds(500, 0, 700, 200);
        menu.add(txt);

        JPanel buttons = new JPanel();
        buttons.setBackground(backGround);
        buttons.setBounds(550, 250, 650, 350);
        //buttons.setLayout(new GridLayout(2, 1));
        menu.add(buttons);
        buttons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        buttons.setLayout(new GridLayout(3, 3, 10, 10));

        JButton rewiewBtn = getMainMenuButton("Обзор",345, 220, 280, 90);
        rewiewBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { crd.show(boxWithMenuSectionPanels, "review");

            }
        });
        buttons.add(rewiewBtn);

        JButton contBtn = getMainMenuButton("Состав",345, 220, 280, 90);
        buttons.add(contBtn);

        JButton lrnBtn = getMainMenuButton("Обучение",345, 220, 280, 90);
        buttons.add(lrnBtn);

        JButton hlpBtn = getMainMenuButton("Справка",345, 220, 280, 90);
        buttons.add(hlpBtn);

        JButton abtBtn = getMainMenuButton("О программе",345, 220, 280, 90);
        abtBtn.setFont(new Font("Calibri", Font.BOLD, 40 ));
        abtBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { crd.show(box, "about");

            }
        });
        buttons.add(abtBtn);

        JButton extBtn = new JButton("Выход");
        extBtn.setFont(new Font("Calibri", Font.BOLD, 50 ));
        extBtn.setFocusable(false);
        extBtn.setForeground(new Color(53, 66, 75));
        extBtn.setBounds(345, 220, 280, 90);
        extBtn.setBackground(new Color(81, 90, 101));
        extBtn.addActionListener(e -> super.dispose());
        buttons.add(extBtn);
    }

    private JButton getMainMenuButton(String text, int x, int y, int width, int height) {
        JButton btn = new JButton(text);
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 50 ));
        btn.setForeground(buttonForeground); // TODO: bring colour from global variables
        btn.setBounds(x, y, width, height);
        btn.setBackground(buttonBackground);
        return btn;
    }
    private void createAbout() {
        about = new JPanel();
        about.setLayout(null);
        about.setBackground(backGround);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0 , 1280, 75);
        topBar.setBackground(topBtmBarBackground);
        about.add(topBar);

        JLabel txt = new JLabel();
        txt.setText("О программе");
        txt.setFont(new Font("Calibri", Font.BOLD, 70 ));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setForeground(textColor);
        topBar.add(txt);

        JPanel btmBar = createBottomBar(true);
        about.add(btmBar);
    }

    private void createReview() {
        review = new JPanel();
        review.setLayout(null);
        review.setBackground(backGround);

        JPanel btmBar = createBottomBar(true);
        review.add(btmBar);

        ImageIcon nxt = new ImageIcon(".\\src\\ArrowNext.png");
        JButton nextSlide = new JButton(nxt);
        nextSlide.setFocusable(false);
        // mid X = 640
        nextSlide.setBounds(680, 5, 65, 65);
        nextSlide.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel page = reviewPage(1);
                page.repaint();
                review.add(page);
                review.repaint();
            }
        });
        nextSlide.setContentAreaFilled(false);
        nextSlide.setFocusPainted(false);
        nextSlide.setBorderPainted(false);
        btmBar.add(nextSlide);
    }

    private JPanel reviewPage(int numberOfPage){
        switch (numberOfPage){
            case 1:
                JPanel page = new JPanel();
                page.setLayout(null);
                page.setBackground(backGround);
                page.setBounds(0,0 , 1280, 605);
                JPanel topBar = new JPanel();
                topBar.setBounds(0, 0 , 1280, 75);
                topBar.setBackground(topBtmBarBackground);

                JLabel txt = new JLabel();
                txt.setText("Спрут-6МА");
                txt.setFont(new Font("Calibri", Font.BOLD, 70 ));
                txt.setHorizontalTextPosition(JLabel.CENTER);
                txt.setForeground(textColor);
                topBar.add(txt);
                topBar.repaint();
                page.add(topBar);
                page.repaint();
                return page;
            default:
                return new JPanel();
        }
    }

//    private void setRw1(){
//        rw1 = new JPanel();
//        rw1.setLayout(null);
//        rw1.setBackground(new Color(221, 255, 209));
//        rw1.setBounds(0,75 , 1280, 500);
//    }
    
//    private JPanel getBaseReviewSlide(boolean setRightButton, boolean setLeftButton, AbstractAction rBtnAction, AbstractAction lBtnAction) {
//        JPanel baseSlide = new JPanel();
//        baseSlide.setLayout(null);
//        baseSlide.setBackground(new Color(224, 255, 255));
//
//        JPanel btmNavBar = new JPanel();
//        btmNavBar.setLayout(null);
//        btmNavBar.setBounds(0, 605 , 1280, 75);
//        btmNavBar.setBackground(new Color(209, 241, 255));
//        baseSlide.add(btmNavBar);
//
//        JButton returnToMenu = new JButton();
//        returnToMenu.setFocusable(false);
//        ImageIcon img = new ImageIcon(".\\src\\ReturnArrow.png");
//        returnToMenu.setBounds(50, 15, 100, 45);
//        returnToMenu.setIcon(img);
//        returnToMenu.setContentAreaFilled(false);
//        returnToMenu.setFocusPainted(false);
//        returnToMenu.setBorderPainted(false);
//        returnToMenu.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) { crd.show(box, "menu");
//
//            }
//        });
//        btmNavBar.add(returnToMenu);
//
//        return baseSlide;
//    }
//
//    private AbstractAction showSlide(String slideId) {
//        crd.show(box, slideId);
//        return null;
//    }



//    JPanel slide1 = getBaseReviewSlide(true, true,
//                new AbstractAction() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                    }
//                },
//                new AbstractAction() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                    }
//                });
}