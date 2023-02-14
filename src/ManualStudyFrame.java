import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Objects;

public class ManualStudyFrame extends JPanel {
    Color LtPurple = new Color(103, 82, 128);
    Color background = new Color(237, 239, 246);
    Color textColor = new Color(0x6e67a0);
    Color btmTopBars = new Color(193, 197, 220);
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel firstSlide, secondSlide, thirdSlide, founthLide, fifthSlide;
    private String color;
    private int[] rightConnetions = new int[8];
    private boolean isPassedA= false;
    private boolean isPassedB = false;
    ManualStudyFrame(ActionListener onReturn){
        crd = new CardLayout();
        createComposition();
        createFirstSlide();
        createSecondSlide();
        createThirdSlide();

// set up for screens panels containers

        slideShow.add("1", firstSlide);
        slideShow.add("2", secondSlide);
        slideShow.add("3", thirdSlide);
        crd.show(slideShow, "1");

        returnToMenu.addActionListener(onReturn);
    }
    private JLabel maleConnect(int x, int y, int width, int height, String NewColor){
        final boolean[] isClicked = {false};
        JLabel part1 = new JLabel();
        part1.setBounds(x, y,width,height);
        part1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isClicked[0]){
                    color = NewColor;
                    part1.setIcon(new ImageIcon(new ImageIcon(".\\assets\\"+NewColor+"Circle.png")
                            .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
                    part1.revalidate();
                    isClicked[0] = true;
                }else {
                    color = "";
                    part1.setIcon(null);
                    part1.revalidate();
                    isClicked[0] = false;
                }

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("succ");
            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        return part1;
    }
    private JLabel femaleConnect(int x, int y, int width, int height, int i, String rightAnswer){
        final boolean[] isClicked = {false};
        JLabel part1 = new JLabel();
        part1.setBounds(x, y,width,height);
        part1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isClicked[0]){
                    part1.setIcon(new ImageIcon(new ImageIcon(".\\assets\\"+color+"Circle.png")
                            .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
                    part1.revalidate();
                    isClicked[0] = true;
                    if(rightAnswer.equals(color)){
                        rightConnetions[i] = 1;
                        System.out.println(Arrays.toString(rightConnetions));
                    }else {
                        rightConnetions[i] = 0;
                    }
                }else {
                    part1.setIcon(null);
                    part1.revalidate();
                    isClicked[0] = false;
                    rightConnetions[i] = 0;
                }

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
        return part1;
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
        JPanel bottomNavBar = new JPanel();
        bottomNavBar.setLayout(null);
        bottomNavBar.setBounds(0, 605, 1280, 75);
        bottomNavBar.setBackground(btmTopBars);
        this.add(bottomNavBar);

        returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrowPRPL.png");
        returnToMenu.setBounds(50, 15, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.setContentAreaFilled(false);
        returnToMenu.setFocusPainted(false);
        returnToMenu.setBorderPainted(false);
        bottomNavBar.add(returnToMenu);
    }
    public class DragPanel extends JPanel{
//        ImageIcon micro1 = new ImageIcon(".\\assets\\micro.png");
        ImageIcon micro1 = new ImageIcon(new ImageIcon(".\\assets\\micro.png").getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
        Point imageCorner;
        Point PrevPt;
        JLabel instructions;


        DragPanel(){
            imageCorner = new Point(150, 500);
            ClickListener clickListener = new ClickListener();
            DragListener dragListener = new DragListener();
            instructions = new JLabel();
            this.addMouseListener(clickListener);
            this.setOpaque(false);
            this.addMouseMotionListener(dragListener);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            micro1.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
        }

        private class ClickListener extends MouseAdapter{
            public void mousePressed(MouseEvent e){
                PrevPt = e.getPoint();
            }
        }
        private class DragListener extends MouseMotionAdapter{
            public void mouseDragged(MouseEvent e){
                Point currentPt = e.getPoint();
                imageCorner.translate((int)(currentPt.getX() - PrevPt.getX()), (int)(currentPt.getY() - PrevPt.getY()));
                PrevPt = currentPt;
                instructions.setText("<html>Расстояние от пола:<br>" + (427 - ((int)imageCorner.getY())) +" В См.<br>Расстояние от стенки:<br>" + (int)((190 - (int)imageCorner.getX()) / 2.8) +" В См.</html>");
                repaint();
           }
        }
    }
    public class DragPanel2 extends JPanel{
        //        ImageIcon micro1 = new ImageIcon(".\\assets\\micro.png");
        ImageIcon micro1 = new ImageIcon(new ImageIcon(".\\assets\\microRev.png").getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
        Point imageCorner;
        Point PrevPt;
        JLabel instructions;
        DragPanel2(){
            imageCorner = new Point(150, 500);
            ClickListener clickListener = new ClickListener();
            DragListener dragListener = new DragListener();
            instructions = new JLabel();
            this.addMouseListener(clickListener);
            this.setOpaque(false);
            this.addMouseMotionListener(dragListener);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            micro1.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
        }

        private class ClickListener extends MouseAdapter{
            public void mousePressed(MouseEvent e){
                PrevPt = e.getPoint();
            }
        }
        private class DragListener extends MouseMotionAdapter{
            public void mouseDragged(MouseEvent e){
                Point currentPt = e.getPoint();
                imageCorner.translate((int)(currentPt.getX() - PrevPt.getX()), (int)(currentPt.getY() - PrevPt.getY()));
                PrevPt = currentPt;
                instructions.setText("<html>Расстояние от пола:<br>" + (427 - ((int)imageCorner.getY())) +" В См.<br>Расстояние от стенки:<br>" + (int)((((int)imageCorner.getX()) / 2.8)) +" В См.</html>");
                repaint();
            }
        }
    }
    public class DragPanel3 extends JPanel{
        //        ImageIcon micro1 = new ImageIcon(".\\assets\\micro.png");
        ImageIcon micro1 = new ImageIcon(new ImageIcon(".\\assets\\microRev.png").getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
        Point imageCorner;
        Point PrevPt;
        JLabel instructions;
        DragPanel3(){
            imageCorner = new Point(150, 500);
            ClickListener clickListener = new ClickListener();
            DragListener dragListener = new DragListener();
            instructions = new JLabel();
            this.addMouseListener(clickListener);
            this.setOpaque(false);
            this.addMouseMotionListener(dragListener);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            micro1.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
        }

        private class ClickListener extends MouseAdapter{
            public void mousePressed(MouseEvent e){
                PrevPt = e.getPoint();
            }
        }
        private class DragListener extends MouseMotionAdapter{
            public void mouseDragged(MouseEvent e){
                Point currentPt = e.getPoint();
                imageCorner.translate((int)(currentPt.getX() - PrevPt.getX()), (int)(currentPt.getY() - PrevPt.getY()));
                PrevPt = currentPt;
                instructions.setText("<html>Расстояние от стенки:<br>" + (int)(50 + (((int)imageCorner.getX()) / 2.8)) +" В См.</html>");
                repaint();
            }
        }
    }
    private void createFirstSlide() {
        firstSlide = createSlide("", "Задание №1", true, 70);

        DragPanel dragPanel = new DragPanel();
        dragPanel.setBounds(0, 75, 330, 530);
        dragPanel.instructions = new JLabel();
        dragPanel.instructions.setBounds(30, 60, 300, 150);
        dragPanel.instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        dragPanel.instructions.setForeground(textColor);
        dragPanel.instructions.setVerticalTextPosition(JLabel.TOP);
        dragPanel.instructions.setVisible(true);
        dragPanel.imageCorner.setLocation(100, 400);
        firstSlide.add(dragPanel.instructions);
        firstSlide.add(dragPanel);

        DragPanel2 dragPanel1 = new DragPanel2();
        dragPanel1.setBounds(330,75,240,530);
        dragPanel1.instructions = new JLabel();
        dragPanel1.instructions.setBounds(360, 60, 300, 150);
        dragPanel1.instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        dragPanel1.instructions.setForeground(textColor);
        dragPanel1.instructions.setVerticalTextPosition(JLabel.TOP);
        dragPanel1.instructions.setVisible(true);
        dragPanel1.imageCorner.setLocation(100, 400);
        firstSlide.add(dragPanel1.instructions);
        firstSlide.add(dragPanel1);

        DragPanel3 dragPanel2 = new DragPanel3();
        dragPanel2.setBounds(560,75,330, 530);
        dragPanel2.micro1 = new ImageIcon(new ImageIcon(".\\assets\\kolonka.png").getImage().getScaledInstance(50, 250, Image.SCALE_DEFAULT));
        dragPanel2.instructions = new JLabel();
        dragPanel2.instructions.setBounds(660, 40, 300, 150);
        dragPanel2.instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        dragPanel2.instructions.setForeground(textColor);
        dragPanel2.instructions.setVerticalTextPosition(JLabel.TOP);
        dragPanel2.instructions.setVisible(true);
        dragPanel2.imageCorner.setLocation(100, 400);
        firstSlide.add(dragPanel2.instructions);
        firstSlide.add(dragPanel2);


        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\FloorTask1.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(0, 180, 600, 450);
        newimg = image.getScaledInstance(600, 450, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        firstSlide.add(img);

        JLabel instructions = new JLabel();
        instructions.setBounds(900, 25, 380, 330);
        instructions.setFont(new Font("Calibri", Font.BOLD, 35));
        instructions.setForeground(textColor);
        instructions.setVerticalTextPosition(JLabel.TOP);
        instructions.setText("<html>Задание 1: <br>" +
                "Установить микрофоны и акустический излучатель на нужные расстояния от стены</html>");
        firstSlide.add(instructions);

        JLabel instructions2 = new JLabel();
        instructions2.setBounds(910, 205, 380, 330);
        instructions2.setFont(new Font("Calibri", Font.BOLD, 45));
        instructions2.setForeground(textColor);
        instructions2.setVerticalTextPosition(JLabel.TOP);
        instructions2.setText("<html>Не Верно!</html>");
        int delay = 2500;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructions2.setVisible(false);
            }
        };
        instructions2.setVisible(false);
        firstSlide.add(instructions2);

        JButton btn = new JButton("<html>Проверить ответы</html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 37));
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setForeground(textColor);
        btn.setBounds(920, 450, 300, 100);
        btn.setBackground(btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((int)(50 + (((int)dragPanel2.imageCorner.getX()) / 2.8)) == 100 && (427 - ((int)dragPanel1.imageCorner.getY())) == 150 &&
                        (int)((((int)dragPanel1.imageCorner.getX()) / 2.8)) == 50 && (427 - ((int)dragPanel.imageCorner.getY())) == 150 && (int)((190 - (int)dragPanel.imageCorner.getX()) / 2.8) == 50){
                    System.out.println("right");
                    crd.show(slideShow, "2");
                }else{
                    instructions2.setVisible(true);
                    new javax.swing.Timer(delay, taskPerformer).start();
                    System.out.println(delay);
                }
            }
        });
        firstSlide.add(btn);
    }
    private void createSecondSlide(){
        secondSlide = createSlide("", "Задание №2", true, 70);

        JLabel micro1 = maleConnect(44,162,146-44,214-162, "R");
        secondSlide.add(micro1);

        JLabel micro2 = maleConnect(268,173,363-268,205-173, "FG");
        secondSlide.add(micro2);

        JLabel speaker = maleConnect(497,233,534-497,270-233, "O");
        secondSlide.add(speaker);

        JLabel box = maleConnect(664,219,701-664,263-219, "G");
        secondSlide.add(box);

        JLabel laptop = maleConnect(516,502,549-516,564-502, "B");
        secondSlide.add(laptop);

        JLabel cnnctr1 = femaleConnect(749,191,775-745,213-191, 0, "O");
        secondSlide.add(cnnctr1);

        JLabel cnnctr2 = femaleConnect(358,363,383-358,381-360, 1, "FG");
        secondSlide.add(cnnctr2);

        JLabel cnnctr3 = femaleConnect(359,384 ,386-359,403-384, 2, "R");
        secondSlide.add(cnnctr3);

        JLabel cnnctr4 = femaleConnect(362,404,382-362,424-404, 3, "G");
        secondSlide.add(cnnctr4);

        JLabel cnnctr5 = femaleConnect(325,422,349-325,443-422, 4, "B");
        secondSlide.add(cnnctr5);


        JLabel img2 = new JLabel();
        ImageIcon unit2 = new ImageIcon(".\\assets\\gen-shuma2.png");
        Image image2 = unit2.getImage();
        Image newimg2;
        img2.setBounds(534,85, 867-507,309-88);
        newimg2 = image2.getScaledInstance(867-507,309-88, java.awt.Image.SCALE_SMOOTH);
        unit2 = new ImageIcon(newimg2);
        img2.setVerticalAlignment(JLabel.TOP);
        img2.setIcon(unit2);
        img2.setVisible(false);
        secondSlide.add(img2);

        JLabel part1 = new JLabel();
        part1.setBounds(595,213, 616-595,235-213);
        part1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(isPassedA){
                    img2.setVisible(true);
                    rightConnetions[5] = 1;
                }
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
        secondSlide.add(part1);

        JLabel img4 = new JLabel();
        ImageIcon unit4 = new ImageIcon(".\\assets\\commutator2.png");
        Image image4 = unit4.getImage();
        Image newimg4;
        img4.setBounds(56,306,439-56,270);
        newimg4 = image4.getScaledInstance(439-56,270, java.awt.Image.SCALE_SMOOTH);
        unit4 = new ImageIcon(newimg4);
        img4.setVerticalAlignment(JLabel.TOP);
        img4.setIcon(unit4);
        img4.setVisible(false);
        secondSlide.add(img4);

        JLabel part2 = new JLabel();
        part2.setBounds(84,497, 112-84,529-497);
        part2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(isPassedA){
                    img4.setVisible(true);
                    rightConnetions[6] = 1;
                }
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
        secondSlide.add(part2);

        JLabel img7 = new JLabel();
        ImageIcon unit7 = new ImageIcon(".\\assets\\laptop2.png");
        Image image7 = unit7.getImage();
        Image newimg7;
        img7.setBounds(524,331,849-524,582-331);
        newimg7 = image7.getScaledInstance(849-524,582-331, java.awt.Image.SCALE_SMOOTH);
        unit7 = new ImageIcon(newimg7);
        img7.setVerticalAlignment(JLabel.TOP);
        img7.setIcon(unit7);
        img7.setVisible(false);
        secondSlide.add(img7);

        JLabel img6 = new JLabel();
        ImageIcon unit6 = new ImageIcon(".\\assets\\CheckMark.png");
        Image image6 = unit6.getImage();
        Image newimg6;
        img6.setBounds(1169,230, 40, 40);
        newimg6 = image6.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        unit6 = new ImageIcon(newimg6);
        img6.setVerticalAlignment(JLabel.TOP);
        img6.setIcon(unit6);
        img6.setVisible(false);
        secondSlide.add(img6);

        JLabel part3 = new JLabel();
        part3.setBounds(663,434,734-663,450-434);
        part3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(isPassedA){
                    img7.setVisible(true);
                    img6.setVisible(true);
                    rightConnetions[7] = 1;
                }
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
        secondSlide.add(part3);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Task2.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(-30, 75, 900, 530);
        newimg = image.getScaledInstance(900, 530, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        secondSlide.add(img);

        JLabel img3 = new JLabel();
        ImageIcon unit3 = new ImageIcon(".\\assets\\CheckMark.png");
        Image image3 = unit3.getImage();
        Image newimg3;
        img3.setBounds(1121,129, 40, 40);
        newimg3 = image3.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        unit3 = new ImageIcon(newimg3);
        img3.setVerticalAlignment(JLabel.TOP);
        img3.setIcon(unit3);
        img3.setVisible(false);
        secondSlide.add(img3);

        JLabel img5 = new JLabel();
        ImageIcon unit5 = new ImageIcon(".\\assets\\CheckMark.png");
        Image image5 = unit5.getImage();
        Image newimg5;
        img5.setBounds(1040,193, 40, 40);
        newimg5 = image5.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        unit5 = new ImageIcon(newimg5);
        img5.setVerticalAlignment(JLabel.TOP);
        img5.setIcon(unit5);
        img5.setVisible(false);
        secondSlide.add(img5);

        JLabel instructions = new JLabel();
        instructions.setBounds(900, 0, 380, 330);
        instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions.setForeground(textColor);
        instructions.setText("<html>Задание 2: <br>" +
                "А) Соединить все предметы правильным путем<br>" +
                "Б) Запустить генератор шума и коммутатор<br>" +
                "В) Запустить программу<br></html>");
        secondSlide.add(instructions);

        JLabel instructions4 = new JLabel();
        instructions4.setBounds(463,450, 100, 150);
        instructions4.setFont(new Font("Calibri", Font.BOLD, 35));
        instructions4.setForeground(textColor);
        instructions4.setText("<html>-><br>USB</html>");
        secondSlide.add(instructions4);

        JLabel instructions5 = new JLabel();
        instructions5.setBounds(536,236, 100, 50);
        instructions5.setFont(new Font("Calibri", Font.BOLD, 35));
        instructions5.setForeground(textColor);
        instructions5.setText("<-");
        secondSlide.add(instructions5);

        JLabel instructions2 = new JLabel();
        instructions2.setBounds(910, 190, 380, 330);
        instructions2.setFont(new Font("Calibri", Font.BOLD, 45));
        instructions2.setForeground(textColor);
        instructions2.setVerticalTextPosition(JLabel.TOP);
        instructions2.setText("<html>Неверно подсоединены провода!</html>");
        int delay = 3500;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructions2.setVisible(false);
            }
        };
        instructions2.setVisible(false);
        secondSlide.add(instructions2);

        JLabel instructions3 = new JLabel();
        instructions3.setBounds(910, 200, 380, 330);
        instructions3.setFont(new Font("Calibri", Font.BOLD, 45));
        instructions3.setForeground(textColor);
        instructions3.setVerticalTextPosition(JLabel.TOP);
        instructions3.setText("<html>Не включено нужное оборудование!</html>");
        ActionListener taskPerformer2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructions3.setVisible(false);
            }
        };
        instructions3.setVisible(false);
        secondSlide.add(instructions3);

        JButton btn = new JButton("<html>Проверить ответы (нажимать после выполнения каждого пункта)</html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 25));
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setForeground(textColor);
        btn.setBounds(920, 450, 300, 130);
        btn.setBackground(btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rightConnetions[0] == 1 && rightConnetions[1] == 1 && rightConnetions[2] == 1 && rightConnetions[3] == 1 && rightConnetions[4] == 1){
                    img3.setVisible(true);
                    isPassedA = true;
                    if (rightConnetions[5] == 1 && rightConnetions[6] == 1){
                        img5.setVisible(true);
                        isPassedB = true;
                        if (rightConnetions[7] == 1){
                            crd.show(slideShow, "3");
                        }
                    }else{
                        instructions3.setVisible(true);
                        new javax.swing.Timer(delay, taskPerformer2).start();
                        System.out.println(delay);
                    }
                }else{
                    instructions2.setVisible(true);
                    new javax.swing.Timer(delay, taskPerformer).start();
                    System.out.println(delay);
                }
            }
        });
        secondSlide.add(btn);
    }
    private JPanel createCompSlide(Color color) {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(color);
        slide.setBounds(0, 0, 1280, 605);
        return slide;
    }
    public void reset(){
        isPassedA= false;
        isPassedB = false;
        Arrays.fill(rightConnetions, 0);
        color = "";
        createFirstSlide();
        createSecondSlide();
        crd.show(slideShow, "1");
    }
    private void createThirdSlide() {
        thirdSlide = createSlide("", "Тест пройден", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(120, 80, 1120, 430);
        instructions.setFont(new Font("Calibri", Font.BOLD, 42));
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Поздравляем с успешным завершением тестирования!<br><br>" +
                "Для повторного прохождения тестирования необходимо вернуться на главную страницу раздела</html>");
        thirdSlide.add(instructions);

    }
}
