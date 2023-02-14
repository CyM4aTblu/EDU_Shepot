import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Container;
import java.io.File;
import java.io.IOException;

public class StudyFrame extends JPanel{
    Color LtPurple = new Color(103, 82, 128);
    Color background = new Color(237, 239, 246);
    Color textColor = new Color(0x6e67a0);
    Color btmTopBars = new Color(193, 197, 220);
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel firstSlide;
    JPanel auto, manual, test, theory;
    StudyFrame(ActionListener onReturn){
        slideShow = new Container();
        crd = new CardLayout();
        slideShow.setLayout(crd);

        createComposition();
        createFirstSlide();
        returnToMenu.addActionListener(onReturn);

        test = new TestStudyFrame(e -> crd.show(slideShow, "1"));
        manual = new ManualStudyFrame(e -> crd.show(slideShow, "1"));
        theory = new TheoryStudyFrame(e -> crd.show(slideShow, "1"));
// set up for screens panels containers

        slideShow.add("theory", theory);
        slideShow.add("manual", manual);
        slideShow.add("test", test);
        slideShow.add("1", firstSlide);
        crd.show(slideShow, "1");
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
    private JPanel createCompSlide(Color color) {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(color);
        slide.setBounds(0, 0, 1280, 720);
        return slide;
    }
    private JPanel createSlide(String path, String name, boolean SideLayout, int fontsize) {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(background);
        slide.setBounds(0, 0, 1280, 605);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0, 1280, 75);
        topBar.setBackground(btmTopBars);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(path);
        Image image = unit.getImage();
        Image newimg;
        if (!SideLayout) {
            img.setBounds(50, 150, 750, 400);
            newimg = image.getScaledInstance(750, 400, java.awt.Image.SCALE_SMOOTH);
        } else {
            img.setBounds(50, 85, 750, 500);
            newimg = image.getScaledInstance(750, 500, java.awt.Image.SCALE_SMOOTH);
        }
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        slide.setLayout(null);
        slide.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + "," + y);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        slide.add(img);

        JLabel txt = new JLabel();
        txt.setText(name);
        txt.setFont(new Font("Calibri", Font.BOLD, fontsize));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setForeground(textColor);
        topBar.add(txt);
        slide.add(topBar);
        slide.repaint();
        return slide;
    }
    private void createComposition() {
        this.setLayout(null);
        slideShow = createCompSlide(Color.BLACK);
        slideShow.setLayout(crd);
        this.add(slideShow);
    }
    private void createFirstSlide() {
        firstSlide = createSlide("", "Обучение", true, 70);

        returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrowPRPL.png");
        returnToMenu.setBounds(50, 600, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.setContentAreaFilled(false);
        returnToMenu.setFocusPainted(false);
        returnToMenu.setBorderPainted(false);
        firstSlide.add(returnToMenu);

        JLabel instructions = new JLabel();
        instructions.setBounds(200, 50, 880, 200);
        instructions.setFont(new Font("Calibri", Font.BOLD, 50));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Выберите режим обучения:</html>");
        firstSlide.add(instructions);


        JPanel buttons = new JPanel();
        buttons.setBackground(background);
        buttons.setBounds(240, 250, 800, 350);
        firstSlide.add(buttons);
        buttons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        buttons.setLayout(new GridLayout(3, 3, 10, 10));

        JButton reviewBtn = createMainMenuButton("Автоматический", textColor, btmTopBars, 25, 10, 280, 90);
        reviewBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(".\\assets\\tutorial.mp4");
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttons.add(reviewBtn);

        JButton contBtn = createMainMenuButton("Тестирование", textColor, btmTopBars, 345, 10, 280, 90);
        contBtn.addActionListener(e ->  {
            crd.show(slideShow, "test");
        });
        buttons.add(contBtn);

        JButton learnBtn = createMainMenuButton("Ручной", textColor, btmTopBars, 25, 110, 280, 90);
        learnBtn.addActionListener(e -> {
            this.remove(manual);
            manual = new ManualStudyFrame(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    crd.show(slideShow, "1");
                }
            });
            slideShow.add("manual", manual);
            crd.show(slideShow, "manual");}); // TODO: fill w/ proper action
        buttons.add(learnBtn);

        JButton helpBtn = createMainMenuButton("Теория", textColor, btmTopBars, 345, 110, 280, 90);
        helpBtn.addActionListener(e -> crd.show(slideShow, "theory")); // TODO: fill w/ proper action
        buttons.add(helpBtn);

    }
}
