import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    // --------------COLORS-----------
    Color darkCyan = new Color(66, 122, 171, 134);
    Color lightBlueBtn = new Color(162, 226, 245);
    Color greyCyan = new Color(53, 66, 75);
    Color greyExitButton = new Color(81, 90, 101);
    Color background = new Color(224, 255, 255);
    Color textColor = new Color(0x76AFD0);
    Color btmTopBars = new Color(197, 230, 236);
    //---- GLOBAL ELEMENTS ------
    CardLayout crd;
    JPanel menu, about, review;
    Container box;

    MainFrame() {
        box = getContentPane();// set up for screens panels containers
        crd = new CardLayout();
        box.setLayout(crd);

        createMenu();//calling constructors of screen panels
        createAbout();
        review = new ReviewFrame(e -> crd.show(box, "menu"));

        box.add("menu", menu);//adding elements in container
        box.add("about", about);
        box.add("review", review);

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
        menu.setBackground(background);

        JLabel img = new JLabel();
        img.setBounds(0, 50 ,500, 500);
        menu.add(img);
        ImageIcon unit = new ImageIcon(".\\assets\\shepot.png");
        img.setIcon(unit);
        img.setVerticalAlignment(JLabel.TOP);
        menu.setLayout(null);

        JLabel txt = new JLabel();
        txt.setText("<html>Автоматизированный комплекс<br>для проведения акустических<br>и виброакустических измерений<br>''ШЕПОТ''</html>");
        txt.setForeground(textColor);
        txt.setFont(new Font("Calibri", Font.BOLD, 40 ));
        txt.setBounds(500, 0, 700, 200);
        menu.add(txt);

        JPanel buttons = new JPanel();
        buttons.setBackground(background);
        buttons.setBounds(550, 250, 650, 350);
        menu.add(buttons);
        buttons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        buttons.setLayout(new GridLayout(3, 3, 10, 10));

        // Creating Review button
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
        about.setBackground(background);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0 , 1280, 75);
        topBar.setBackground(btmTopBars);
        about.add(topBar);

        JLabel txt = new JLabel();
        txt.setText("О программе");
        txt.setFont(new Font("Calibri", Font.BOLD, 70 ));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setForeground(textColor);
        topBar.add(txt);

        JPanel btmBar = new JPanel();
        btmBar.setLayout(null);
        btmBar.setBounds(0, 605 , 1280, 75);
        btmBar.setBackground(btmTopBars);
        about.add(btmBar);

        JButton returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrow.png");
        returnToMenu.setContentAreaFilled(false);
        returnToMenu.setFocusPainted(false);
        returnToMenu.setBorderPainted(false);
        returnToMenu.setBounds(50, 15, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { crd.show(box, "menu");

            }
        });
        btmBar.add(returnToMenu);
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
}