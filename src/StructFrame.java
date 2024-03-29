import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StructFrame extends JPanel {
    Color LtPurple = new Color(103, 82, 128);
    Color background = new Color(237, 239, 246);
    Color textColor = new Color(0x6e67a0);
    Color btmTopBars = new Color(193, 197, 220);
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel firstSlide, secondSlide, thirdSlide, founthLide, fifthSlide;
    StructFrame(ActionListener onReturn){
        crd = new CardLayout();
        createComposition();
        createFirstSlide();
        createSecondSlide();
        createThirdSlide();
        createFourthSlide();
        createFifthSlide();
//        createSixthSlide();
//        createSeventhSlide();
//        createEighthSlide();
//        createNinethSlide();
//        createlastSlide();

// set up for screens panels containers

        slideShow.add("1", firstSlide);
        slideShow.add("2", secondSlide);
        slideShow.add("3", thirdSlide);
        slideShow.add("4", founthLide);
        slideShow.add("5", fifthSlide);
//        slideShow.add("6", sixthSlide);
//        slideShow.add("7", seventhSlide);
//        slideShow.add("8", eighthSlide);
//        slideShow.add("9", ninethSlide);
//        slideShow.add("10", lastSlide);
        crd.show(slideShow, "1");

        returnToMenu.addActionListener(onReturn);
    }
    private JLabel hitbox(int x, int y, int width, int height, JLabel parent){
        JLabel part1 = new JLabel();
        part1.setBounds(x, y,width,height);
        part1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                parent.setVisible(true);
                parent.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                parent.setVisible(false);
            }
        });
        return part1;
    }
    private JLabel advHitBox(int x, int y, int width, int height, JLabel parent, String slide) {
        JLabel part1 = new JLabel();
        part1.setBounds(x, y,width,height);
        part1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                crd.show(slideShow, slide);

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                parent.setVisible(true);
                parent.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                parent.setVisible(false);
            }
        });
        return part1;
    }
    private JLabel createPanel(int x, int y, int widh, int height){
        JLabel pnl = new JLabel();
        pnl.setBounds(x, y, widh, height);
        pnl.setFont(new Font("Calibri", Font.BOLD, 18));
        pnl.setBackground(background);
        pnl.setForeground(textColor);
        pnl.setHorizontalAlignment(JLabel.LEFT);
        pnl.setOpaque(true);
        pnl.setBorder(BorderFactory.createLineBorder(LtPurple, 5));
        pnl.setVisible(false);
        return pnl;
    }
    private JPanel createCompSlide(Color color) {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(color);
        slide.setBounds(0, 0, 1280, 605);
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

        ImageIcon nxt = new ImageIcon(".\\assets\\ArrowNextPRPL.png");
        JButton nextSlide = new JButton(nxt);
        nextSlide.setFocusable(false);
        nextSlide.setBounds(680, 5, 65, 65);
        nextSlide.addActionListener(e -> crd.next(slideShow));
        nextSlide.setContentAreaFilled(false);
        nextSlide.setFocusPainted(false);
        nextSlide.setBorderPainted(false);
        bottomNavBar.add(nextSlide);

        ImageIcon prv = new ImageIcon(".\\assets\\ArrowBackPRPL.png");
        JButton prevSlide = new JButton(prv);
        prevSlide.setFocusable(false);
        prevSlide.setBounds(550, 5, 65, 65);
        prevSlide.addActionListener(e -> crd.previous(slideShow));
        prevSlide.setContentAreaFilled(false);
        prevSlide.setFocusPainted(false);
        prevSlide.setBorderPainted(false);
        bottomNavBar.add(prevSlide);

        JButton rtrnCont = new JButton("На главную");
        rtrnCont.setFocusable(false);
        rtrnCont.setBounds(950, 5, 265, 65);
        rtrnCont.setFont(new Font("Calibri", Font.BOLD, 43));
        rtrnCont.setForeground(textColor);
        rtrnCont.setVerticalAlignment(JButton.CENTER);
        rtrnCont.addActionListener(e -> crd.show(slideShow, "1"));
        rtrnCont.setContentAreaFilled(false);
        rtrnCont.setFocusPainted(false);
        rtrnCont.setBorderPainted(false);
        bottomNavBar.add(rtrnCont);
    }
    private void createFirstSlide() {
        firstSlide = createSlide(".\\assets\\MainStruct.png", "Структура", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(830, 80, 430, 250);
        instructions.setFont(new Font("Calibri", Font.BOLD, 28));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>На данном рисунке изображена схема работы комплекса при акустических и виброакустических измерениях.</html>");
        firstSlide.add(instructions);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(830, 270, 430, 250);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 28));
        generalInfo.setHorizontalTextPosition(JLabel.CENTER);
        generalInfo.setForeground(textColor);
        generalInfo.setHorizontalAlignment(JLabel.LEFT);
        generalInfo.setText("<html>Нажмите на элемент комплекса для получения большей информации о нем.</html>");
        firstSlide.add(generalInfo);

        JLabel micro = createPanel(256,194,150,60);
        micro.setText("<html>Измерительный микрофон</html>");
        JLabel htb1 = advHitBox(107,154,244-107,253-154, micro, "2");
        JLabel htb11 = advHitBox(412,155,549-412,254-155, micro, "2");
        firstSlide.add(micro);
        firstSlide.add(htb11);
        firstSlide.add(htb1);

        JLabel acustic = createPanel(483,91,150,60);
        acustic.setText("<html>Акустический излучатель</html>");
        JLabel htb2 = advHitBox(597,152,740-597,257-152, acustic, "3");
        firstSlide.add(acustic);
        firstSlide.add(htb2);

        JLabel noise = createPanel(584,412, 150,60);
        noise.setText("<html>Генератор шума</html>");
        JLabel htb3 = advHitBox(603,292,746-603,400-292, noise, "4");
        firstSlide.add(noise);
        firstSlide.add(htb3);

        JLabel pom = createPanel(512,431, 170,60);
        pom.setText("<html>Средство измерения помех</html>");
        JLabel htb4 = advHitBox(247,405,491-247,531-405,pom, "5");
        firstSlide.add(pom);
        firstSlide.add(htb4);

        JLabel wall = createPanel(391,269, 150,130);
        wall.setText("<html>Ограждающая конструкция, для которой проводятся измерения</html>");
        JLabel htb5 = hitbox(287,121,362-287,346-121, wall);
        firstSlide.add(wall);
        firstSlide.add(htb5);
    }
    private void createSecondSlide() {
        secondSlide = createSlide("", "Измерительный микрофон", false, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(830, 180, 430, 250);
        instructions.setFont(new Font("Calibri", Font.BOLD, 28));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Для измерений комплекса «Шепот» используются два измерительных PCB микрофона. Далее дана структурная схема работы микрофона такого типа.</html>");
        secondSlide.add(instructions);

        JLabel msg1 = createPanel(391,187,150,60);
        msg1.setText("<html>Кабель</html>");
        JLabel htb1 = hitbox(336,248,454-336,325-248, msg1);
        secondSlide.add(msg1);
        secondSlide.add(htb1);

        JLabel msg2  = createPanel(445,178,100,60);
        msg2.setText("<html>Питание</html>");
        JLabel htb2 = hitbox(484,248,579-484,275-248, msg2);
        secondSlide.add(msg2);
        secondSlide.add(htb2);

        JLabel msg3  = createPanel(409,342,150,60);
        msg3.setText("<html>Заземление</html>");
        JLabel htb3 = hitbox(477,275,578-477,299-275, msg3);
        secondSlide.add(msg3);
        secondSlide.add(htb3);

        JLabel msg4  = createPanel(513,346,150,60);
        msg4.setText("<html>Защитная оболочка кабеля</html>");
        JLabel htb4 = hitbox(454,297,577-454,316-297, msg4);
        secondSlide.add(msg4);
        secondSlide.add(htb4);

        JLabel msg5  = createPanel(63,180,150,60);
        msg5.setText("<html>Источник питания</html>");
        JLabel htb5 = hitbox(46,275,93-46,322-278, msg5);
        secondSlide.add(msg5);
        secondSlide.add(htb5);

        JLabel msg6  = createPanel(239,432,150,60);
        msg6.setText("<html>Одиночный аудио-канал</html>");
        JLabel htb6 = hitbox(190,244,315-190,353-244, msg6);
        secondSlide.add(msg6);
        secondSlide.add(htb6);

        JLabel msg7  = createPanel(629,166,150,60);
        msg7.setText("<html>Микрофонная система</html>");
        JLabel htb7 = hitbox(581,248,703-581,317-248, msg7);
        secondSlide.add(msg7);
        secondSlide.add(htb7);

        JLabel msg11 = createPanel(260,80,300,200);
        msg11.setText("<html>Параметры барьера:<br>" +
                "Voc/Uo ≤ VMAX / UI<br>" +
                " Isc/Io ≤ IMAX/ II <br>" +
                "Ca/Co > CI + CCABLE<br>" +
                " La/Lo > LI + LCABL<br>" +
                "Ui = 30V, Ii = 100mA, Pi = 0.75W, Ci = 0, Li = 0.36uH – барьер серии EX378XYYY\n</html>");
        JLabel htb11 = hitbox(516,200,560-516,246-200, msg11);
        secondSlide.add(msg11);
        secondSlide.add(htb11);

        JLabel msg12  = createPanel(30,108,200,160);
        msg12.setText("<html>Барьер устанавливается в корпусе, соответствующим стандартам властей данной страны</html>");
        JLabel htb12 = hitbox(221,205,263-221,242-205, msg12);
        secondSlide.add(msg12);
        secondSlide.add(htb12);

        JLabel msg13  = createPanel(445,399,200,100);
        msg13.setText("<html>Защитные экраны заземляются на концах барьера</html>");
        JLabel htb13 = hitbox(516,318,557-516,357-318, msg13);
        secondSlide.add(msg13);
        secondSlide.add(htb13);

        JLabel msg14  = createPanel(699,467,180,120);
        msg14.setText("<html>Утвержденный картридж для микрофона – картридж серии EX377XYYY</html>");
        JLabel htb14 = hitbox(661,355,701-661,392-355, msg14);
        secondSlide.add(msg14);
        secondSlide.add(htb14);

        JLabel msg15  = createPanel(555,463,200,120);
        msg15.setText("<html>Утвержденный усилитель для микрофона – усилитель серии EX426XYYY</html>");
        JLabel htb15 = hitbox(580,357,616-580,393-357, msg15);
        secondSlide.add(msg15);
        secondSlide.add(htb15);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\MicroStruct.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(0, 200, 750, 250);
        newimg = image.getScaledInstance(750, 250, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        secondSlide.add(img);
    }
    private void createThirdSlide() {
        thirdSlide = createSlide("", "Акустический излучатель", false, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(830, 80, 430, 450);
        instructions.setFont(new Font("Calibri", Font.BOLD, 28));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Для создания звука подаваемого от генератора шума, акустический излучатель синтезирует получаемые сигналы," +
                " используя цифроаналоговое преобразование. Далее даны схемы работы цифроаналогового преобразования и синтезирования звука для" +
                " его дальнейшего воспроизведения излучателем.</html>");
        thirdSlide.add(instructions);

        JLabel instructions1 = new JLabel();
        instructions1.setBounds(100,240, 630, 100);
        instructions1.setFont(new Font("Calibri", Font.BOLD, 28));
        instructions1.setHorizontalTextPosition(JLabel.CENTER);
        instructions1.setForeground(textColor);
        instructions1.setHorizontalAlignment(JLabel.CENTER);
        instructions1.setText("<html>«Схема цифроаналогового преобразования»</html>");
        thirdSlide.add(instructions1);

        JLabel instructions2 = new JLabel();
        instructions2.setBounds(226,428, 430, 100);
        instructions2.setFont(new Font("Calibri", Font.BOLD, 28));
        instructions2.setHorizontalTextPosition(JLabel.CENTER);
        instructions2.setForeground(textColor);
        instructions2.setHorizontalAlignment(JLabel.CENTER);
        instructions2.setText("<html>«Схема синтезатора»</html>");
        thirdSlide.add(instructions2);

        JLabel msg1 = createPanel(125,82,250,60);
        msg1.setText("<html>Дискретный по времени и значению сигнал с ошибками</html>");
        JLabel htb1 = hitbox(136,143,170-136,172-143, msg1);
        thirdSlide.add(msg1);
        thirdSlide.add(htb1);

        JLabel msg2  = createPanel(169,201,150,60);
        msg2.setText("<html>Канальный декодер</html>");
        JLabel htb2 = hitbox(169,126,232-169,189-126, msg2);
        thirdSlide.add(msg2);
        thirdSlide.add(htb2);

        JLabel msg3  = createPanel(223,82,250,60);
        msg3.setText("<html>Дискретный по времени и значению сигнал без ошибок</html>");
        JLabel htb3 = hitbox(230,143,274-230,170-143, msg3);
        thirdSlide.add(msg3);
        thirdSlide.add(htb3);

        JLabel msg4  = createPanel(274,190,150,60);
        msg4.setText("<html>Декодер</html>");
        JLabel htb4 = hitbox(272,124,336-272,187-124, msg4);
        thirdSlide.add(msg4);
        thirdSlide.add(htb4);

        JLabel msg5  = createPanel(323,82,250,60);
        msg5.setText("<html>Дискретный по значению сигнал</html>");
        JLabel htb5 = hitbox(336,140,379-336,172-140, msg5);
        thirdSlide.add(msg5);
        thirdSlide.add(htb5);

        JLabel msg6  = createPanel(372,189,150,60);
        msg6.setText("<html>Сглаживание</html>");
        JLabel htb6 = hitbox(379,124,443-379,186-124, msg6);
        thirdSlide.add(msg6);
        thirdSlide.add(htb6);

        JLabel msg7  = createPanel(434,82,150,60);
        msg7.setText("<html>Непрерывный сигнал</html>");
        JLabel htb7 = hitbox(442,140,515-442,169-140, msg7);
        thirdSlide.add(msg7);
        thirdSlide.add(htb7);

        JLabel msg11 = createPanel(514,191,150,60);
        msg11.setText("<html>Фильтрация</html>");
        JLabel htb11 = hitbox(515,123,574-515,189-123, msg11);
        thirdSlide.add(msg11);
        thirdSlide.add(htb11);

        JLabel msg12  = createPanel(243,259,300,160);
        msg12.setText("<html>На данном этапе из потока цифровых данных с помощью цифроаналогового" +
                " преобразователя (ЦАП) выделяют отсчеты сигнала, следующие с частотой дискретизации</html>");
        JLabel htb12 = hitbox(255,214,455-255,258-214, msg12);
        thirdSlide.add(msg12);
        thirdSlide.add(htb12);

        JLabel msg13  = createPanel(465,265,300,200);
        msg13.setText("<html>На данном этапе из дискретных отсчетов путем сглаживания (интерполяции)" +
                " формируется непрерывный аналоговый сигнал с помощью фильтра низкой частоты, который" +
                " подавляет периодические составляющие спектра дискретного сигнала</html>");
        JLabel htb13 = hitbox(462,214,659-462,259-214, msg13);
        thirdSlide.add(msg13);
        thirdSlide.add(htb13);

        JLabel msg21  = createPanel(21,317,250,60);
        msg21.setText("<html>В случае комплекса «Шепот» - генератор шума</html>");
        JLabel htb21 = hitbox(59,380,172-59,449-380, msg21);
        thirdSlide.add(msg21);
        thirdSlide.add(htb21);

        JLabel msg22  = createPanel(206,462,250,120);
        msg22.setText("<html>Сигнал возбуждения подается на фильтр, имитирующий необходимую амплитудно-частотную характеристику</html>");
        JLabel htb22 = hitbox(201,378,298-201,449-378, msg22);
        thirdSlide.add(msg22);
        thirdSlide.add(htb22);

        JLabel msg23  = createPanel(328,456,330,150);
        msg23.setText("<html>На другой вход фильтра подается сигнал амплитудной огибающей, а совокупность сигналов" +
                " обрабатывается с целью получения специальных звуковых эффектов, например, эха</html>");
        JLabel htb23 = hitbox(326,376,410-326,447-376, msg23);
        thirdSlide.add(msg23);
        thirdSlide.add(htb23);

        JLabel msg24  = createPanel(448,456,250,120);
        msg24.setText("<html>Фильтрация сигнала с помощью фильтра низких частот</html>");
        JLabel htb24 = hitbox(444,374,506-444,447-374, msg24);
        thirdSlide.add(msg24);
        thirdSlide.add(htb24);

        JLabel msg25  = createPanel(543,455,270,120);
        msg25.setText("<html>Генерирует ADSR огибающую - функцию, описывающую изменения какого-либо параметра во времени</html>");
        JLabel htb25 = hitbox(538,374,589-538,445-374, msg25);
        thirdSlide.add(msg25);
        thirdSlide.add(htb25);

        JLabel msg26  = createPanel(42,531,150,60);
        msg26.setText("<html>Канальный декодер</html>");
        JLabel htb26 = hitbox(57,470,173-57,523-470, msg26);
        thirdSlide.add(msg26);
        thirdSlide.add(htb26);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\AcusticStruct.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(0, 80, 750, 200);
        newimg = image.getScaledInstance(750, 200, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        thirdSlide.add(img);

        JLabel img2 = new JLabel();
        ImageIcon unit2 = new ImageIcon(".\\assets\\AcusticStruct2.png");
        Image image2 = unit2.getImage();
        Image newimg2;
        img2.setBounds(0, 350, 750, 200);
        newimg2 = image2.getScaledInstance(750, 200, java.awt.Image.SCALE_SMOOTH);
        unit2 = new ImageIcon(newimg2);
        img2.setVerticalAlignment(JLabel.TOP);
        img2.setIcon(unit2);
        thirdSlide.add(img2);
    }
    private void createFourthSlide() {
        founthLide = createSlide("", "Генератор шума", false, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(830, 180, 430, 250);
        instructions.setFont(new Font("Calibri", Font.BOLD, 28));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>В комплекте «Шепот» поставляется генератор шума «Шорох-2МИ». Далее дана структурная схема генератора шума</html>");
        founthLide.add(instructions);

        JLabel msg1 = createPanel(37,138,250,60);
        msg1.setText("<html>Источник шумового сигнала, выполненный на резисторе</html>");
        JLabel htb1 = hitbox(71,198,218-71,333-198, msg1);
        founthLide.add(msg1);
        founthLide.add(htb1);

        JLabel msg2  = createPanel(222,132,270,80);
        msg2.setText("<html>Повышает сигнал до уровня напряжения линейного входа</html>");
        JLabel htb2 = hitbox(258,198,407-258,330-198, msg2);
        founthLide.add(msg2);
        founthLide.add(htb2);

        JLabel msg3  = createPanel(395,78,300,120);
        msg3.setText("<html>Пассивное сверхвысокочастотное устройство, которое изменяет и исправляет спектральные плотности сигнала</html>");
        JLabel htb3 = hitbox(447,199,595-447,330-199, msg3);
        founthLide.add(msg3);
        founthLide.add(htb3);

        JLabel msg4  = createPanel(5,360,250,200);
        msg4.setText("<html>Маломощный генератор электрических колебаний, применяемый для преобразования частот сигнала, а данном случае источник опорного сигнала для перемножения</html>");
        JLabel htb4 = hitbox(259,371,406-259,502-371, msg4);
        founthLide.add(msg4);
        founthLide.add(htb4);

        JLabel msg5  = createPanel(390,514,250,80);
        msg5.setText("<html>Переводит сигнал из области звуковых частот в радиочастоты</html>");
        JLabel htb5 = hitbox(447,369,593-447,502-369, msg5);
        founthLide.add(msg5);
        founthLide.add(htb5);

        JLabel msg6  = createPanel(589,511,250,80);
        msg6.setText("<html>Усиливает мощность сигнала для его перенаправления на акустический излучатель</html>");
        JLabel htb6 = hitbox(630,370,781-630,503-370, msg6);
        founthLide.add(msg6);
        founthLide.add(htb6);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\GeneratorStruct.png");
        Image image = unit.getImage();
        Image newimg;
            img.setBounds(50, 200, 750, 300);
            newimg = image.getScaledInstance(750, 300, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        founthLide.add(img);
    }
    private void createFifthSlide() {
        fifthSlide = createSlide(".\\assets\\MeasuringToolStruct.png", "Средство измерения помех", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(830, 80, 430, 450);
        instructions.setFont(new Font("Calibri", Font.BOLD, 30));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>В случае комплекса «Шепот» для измерения помех используется средство измерения «Larson&Davis 824». Его структурная схема</html>");
        fifthSlide.add(instructions);

        JLabel msg1 = createPanel(37,138,150,60);
        msg1.setText("<html>Микрофон и предусилитель</html>");
        JLabel htb1 = hitbox(96,94,216-94,142-94, msg1);
        fifthSlide.add(msg1);
        fifthSlide.add(htb1);

        JLabel msg2  = createPanel(229,186,200,60);
        msg2.setText("<html>Коэффициент передачи от 0 до 50 дБ</html>");
        JLabel htb2 = hitbox(264,85,327-264,193-85, msg2);
        fifthSlide.add(msg2);
        fifthSlide.add(htb2);

        JLabel msg3  = createPanel(344,203,300,190);
        msg3.setText("<html>Электронный или любой другой фильтр, пропускающий высокие частоты входного сигнала, при этом подавляя" +
                " частоты сигнала ниже частоты среза. Степень подавления зависит от конкретного типа фильтра</html>");
        JLabel htb3 = hitbox(330,89,484-330,192-89, msg3);
        fifthSlide.add(msg3);
        fifthSlide.add(htb3);

        JLabel msg4  = createPanel(376,197,300,120);
        msg4.setText("<html>Аналого-цифровой преобразователь - устройство, преобразующее входной аналоговый сигнал в дискретный код/цифровой сигнал</html>");
        JLabel htb4 = hitbox(527,88,603-527,191-88, msg4);
        JLabel htb44 = hitbox(267,206,343-267,307-206, msg4);
        fifthSlide.add(msg4);
        fifthSlide.add(htb44);
        fifthSlide.add(htb4);

        JLabel msg5  = createPanel(635,195,300,200);
        msg5.setText("<html>Цифровой процессор обработки сигналов - специализированный программируемый микропроцессор," +
                " предназначенный для манипулирования в реальном масштабе времени потоком цифровых данных</html>");
        JLabel htb5 = hitbox(633,89,708-633,191-89, msg5);
        fifthSlide.add(msg5);
        fifthSlide.add(htb5);

        JLabel msg6  = createPanel(2,196,150,60);
        msg6.setText("<html>Внешнее питание</html>");
        msg6.repaint();
        JLabel htb6 = hitbox(109,183,167-109,220-183, msg6);
        fifthSlide.add(msg6);
        fifthSlide.add(htb6);

        JLabel msg7  = createPanel(639,207,170,60);
        msg7.setText("<html>Подача переменного тока</html>");
        JLabel htb7 = hitbox(546,207,626-546,286-207, msg7);
        fifthSlide.add(msg7);
        fifthSlide.add(htb7);

        JLabel msg8  = createPanel(639,291,170,60);
        msg8.setText("<html>Подача постоянного тока</html>");
        JLabel htb8 = hitbox(541,286,627-541,325-286, msg8);
        fifthSlide.add(msg8);
        fifthSlide.add(htb8);

        JLabel msg9  = createPanel(701,321,300,170);
        msg9.setText("<html>Мультиплексор - позволяет передавать сигнал с одного из входов на выход;" +
                " при этом выбор желаемого входа осуществляется подачей соответствующей комбинации управляющих сигналов</html>");
        JLabel htb9 = hitbox(636,207,701-636,321-207, msg9);
        fifthSlide.add(msg9);
        fifthSlide.add(htb9);

        JLabel msg10  = createPanel(779,288,180,60);
        msg10.setText("<html>Выход постоянного и переменного тока</html>");
        JLabel htb10 = hitbox(739,241,779-739,288-241, msg10);
        fifthSlide.add(msg10);
        fifthSlide.add(htb10);

        JLabel msg11 = createPanel(166,419,150,60);
        msg11.setText("<html>Контроллер ввода/вывода</html>");
        JLabel htb11 = hitbox(119,376,166-119,419-376, msg11);
        fifthSlide.add(msg11);
        fifthSlide.add(htb11);

        JLabel msg12  = createPanel(221,530,300,60);
        msg12.setText("<html>RAM – оперативная память – от ½ до 2 МБ</html>");
        JLabel htb12 = hitbox(276,476,344-276,521-476, msg12);
        fifthSlide.add(msg12);
        fifthSlide.add(htb12);

        JLabel msg13  = createPanel(297,359,300,100);
        msg13.setText("<html>Flash ROM - электрически-стираемая программируемая постоянная память</html>");
        JLabel htb13 = hitbox(343,477,412-343,521-477, msg13);
        fifthSlide.add(msg13);
        fifthSlide.add(htb13);

        JLabel msg14  = createPanel(374,530,300,60);
        msg14.setText("<html>Календарь и счетчик реального времени</html>");
        JLabel htb14 = hitbox(412,477,512-412,521-477, msg14);
        fifthSlide.add(msg14);
        fifthSlide.add(htb14);

        JLabel msg15  = createPanel(455,320,300,150);
        msg15.setText("<html>Серийный контроллер ввода/вывода - метод последовательной передачи элементов данных между устройствами</html>");
        JLabel htb15 = hitbox(512,478,580-512,521-478, msg15);
        fifthSlide.add(msg15);
        fifthSlide.add(htb15);

        JLabel msg16  = createPanel(777,474,150,120);
        msg16.setText("<html>Графический жидкокристаллический экран 128х64 мм с подсветкой</html>");
        JLabel htb16 = hitbox(656,394,777-656,494-394, msg16);
        fifthSlide.add(msg16);
        fifthSlide.add(htb16);

        JLabel msg17  = createPanel(685,541,150,60);
        msg17.setText("<html>Передатчик RS-422/232</html>");
        JLabel htb17 = hitbox(607,518,685-607,561-518, msg17);
        fifthSlide.add(msg17);
        fifthSlide.add(htb17);

        JLabel msg18  = createPanel(776,424,300,150);
        msg18.setText("<html>Серийный контроллер ввода/вывода – метод последовательной передачи элементов данных между устройствами</html>");
        JLabel htb18 = hitbox(736,514,776-736,562-514, msg18);
        fifthSlide.add(msg18);
        fifthSlide.add(htb18);
    }

}
