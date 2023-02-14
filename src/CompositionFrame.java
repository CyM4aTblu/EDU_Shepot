import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CompositionFrame extends JPanel {
    // --------------COLORS-----------
    Color LtPurple = new Color(103, 82, 128);
    Color background = new Color(237, 239, 246);
    Color textColor = new Color(0x6e67a0);
    Color btmTopBars = new Color(193, 197, 220);
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel firstSlide, secondSlide, thirdSlide, founthLide,
            fifthSlide, sixthSlide, seventhSlide, eighthSlide, ninethSlide, lastSlide;

    CompositionFrame(ActionListener onReturn) {
        crd = new CardLayout();
        createComposition();
        createFirstSlide();
        createSecondSlide();
        createThirdSlide();
        createFourthSlide();
        createFifthSlide();
        createSixthSlide();
        createSeventhSlide();
        createEighthSlide();
        createNinethSlide();
        createlastSlide();
// set up for screens panels containers
        slideShow.add("1", firstSlide);
        slideShow.add("2", secondSlide);
        slideShow.add("3", thirdSlide);
        slideShow.add("4", founthLide);
        slideShow.add("5", fifthSlide);
        slideShow.add("6", sixthSlide);
        slideShow.add("7", seventhSlide);
        slideShow.add("8", eighthSlide);
        slideShow.add("9", ninethSlide);
        slideShow.add("10", lastSlide);
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
            img.setBounds(0, 75, 900, 400);
            newimg = image.getScaledInstance(900, 400, java.awt.Image.SCALE_SMOOTH);
        } else {
            img.setBounds(50, 85, 650, 500);
            newimg = image.getScaledInstance(650, 500, java.awt.Image.SCALE_SMOOTH);
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
    private void createFirstSlide() {
        firstSlide = createSlide("", "Состав", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(730, 80, 550, 100);
        instructions.setFont(new Font("Calibri", Font.BOLD, 22));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Для получения более подробной информации об элементах комплекса, нажмите на соответствующий элемент слева или на его название в списке справа.</html>");
        firstSlide.add(instructions);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(750, 170, 500, 350);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 22));
        generalInfo.setHorizontalTextPosition(JLabel.CENTER);
        generalInfo.setForeground(textColor);
        generalInfo.setHorizontalAlignment(JLabel.LEFT);
        generalInfo.setText("<html>Средство измерения «Larson&Davis 824»<br>" +
                "Рабочая укладка с управляемым коммутатором<br>" +
                "Штатив, соединительные и измерительные кабели<br>" +
                "Микрофон «РСВ Piezotronics TMS130D20»<br>" +
                "Портативный компьютер<br>" +
                "Приемник<br>" +
                "Передатчик<br>" +
                "Генератор шума «Шорох-2МИ»<br>" +
                "Калибратор CAL-200<br>" +
                "Акселерометр «АР98-100»<br>" +
                "Акустический излучатель</html>");
        firstSlide.add(generalInfo);

        JLabel msg1 = createPanel(405,339, 200, 100);
        msg1.setText("<html>Средство измерения «Larson&Davis 824»</html>");
        JLabel htb1 = advHitBox(465,452,639-465,511-452, msg1, "2");
        firstSlide.add(msg1);
        firstSlide.add(htb1);

        JLabel msg2  = createPanel(400, 250, 200, 100);
        msg2.setText("<html>Рабочая укладка с управляемым коммутатором</html>");
        JLabel htb2 = advHitBox(427, 330, 670 - 427, 447 - 330, msg2, "3");
        firstSlide.add(msg2);
        firstSlide.add(htb2);

        JLabel msg3  = createPanel(496,104, 200, 100);
        msg3.setText("<html>Штатив, соединительные и измерительные кабели</html>");
        JLabel htb3 = advHitBox(280, 93, 488 - 280, 295 - 93, msg3, "4");
        firstSlide.add(msg3);
        firstSlide.add(htb3);

        JLabel msg4  = createPanel(282,412, 200, 100);
        msg4.setText("<html>Микрофон «РСВ Piezotronics TMS130D20»</html>");
        JLabel htb4 = advHitBox(316,354,409-316,416-354, msg4, "4");
        firstSlide.add(msg4);
        firstSlide.add(htb4);

        JLabel msg5  = createPanel(311,309, 150, 80);
        msg5.setText("<html>Портативный компьютер</html>");
        JLabel htb5 = advHitBox(160, 415, 396 - 160, 556 - 415, msg5, "5");
        firstSlide.add(msg5);
        firstSlide.add(htb5);

        JLabel msg6  = createPanel(141,145, 100, 50);
        msg6.setText("<html>Приемник</html>");
        JLabel htb6 = advHitBox(132, 218, 285 - 132, 286 - 218, msg6, "6");
        firstSlide.add(msg6);
        firstSlide.add(htb6);

        JLabel msg7  = createPanel(141,175, 130, 50);
        msg7.setText("<html>Передатчик</html>");
        JLabel htb7 = advHitBox(119, 285, 283 - 119, 315 - 285, msg7, "6");
        firstSlide.add(msg7);
        firstSlide.add(htb7);

        JLabel msg8  = createPanel(141,235, 200, 70);
        msg8.setText("<html>Генератор шума «Шорох-2МИ»</html>");
        JLabel htb8 = advHitBox(110, 312, 292 - 110, 392 - 312, msg8, "7");
        firstSlide.add(msg8);
        firstSlide.add(htb8);

        JLabel msg9  = createPanel(100,320, 150, 70);
        msg9.setText("<html>Калибратор CAL-200</html>");
        JLabel htb9 = advHitBox(100, 396, 154 - 100, 475 - 396, msg9, "8");
        firstSlide.add(msg9);
        firstSlide.add(htb9);

        JLabel msg10  = createPanel(100,380, 150, 70);
        msg10.setText("<html>Акселерометр «АР98-100»</html>");
        JLabel htb10 = advHitBox(103, 474, 147 - 103, 525 - 474, msg10, "9");
        firstSlide.add(msg10);
        firstSlide.add(htb10);

        JLabel msg11  = createPanel(141,145, 200, 70);
        msg11.setText("<html>Акустический излучатель</html>");
        JLabel htb11 = advHitBox(68,170,109-60,340-170, msg11, "10");
        firstSlide.add(msg11);
        firstSlide.add(htb11);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Shepot_composition.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(50, 85, 650, 500);
        newimg = image.getScaledInstance(650, 500, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        firstSlide.setLayout(null);
        firstSlide.add(img);
    }
    private void createSecondSlide() {
        secondSlide = createSlide(".\\assets\\Larson&Davis 824.png", "Средство измерения «Larson&Davis 824»", false, 70);

        JLabel upInfo = new JLabel();
        upInfo.setBounds(900, 100, 340, 600);
        upInfo.setFont(new Font("Calibri", Font.BOLD, 19));
        upInfo.setVerticalAlignment(JLabel.TOP);
        upInfo.setForeground(textColor);
        upInfo.setHorizontalAlignment(JLabel.LEFT);
        upInfo.setText("<html>Шумомер включает в себя функции интегрирующего шумомера-анализатора спектра и шумомера-регистратора." +
                " В режиме шумомер-анализатор прибор одновременно измеряет общие и корректированные уровни звука, эквивалентные," +
                " максимальные и минимальные уровни звука и уровни звукового давления в октавных или третьоктавных полосах частот в звуковом диапазоне.\n" +
                "В режиме шумомер-регистратор прибор не проводит частотный анализ, но позволяет осуществлять длительный мониторинг" +
                " шума с автоматической записью в память большого количества параметров - эквивалентные, максимальные, пиковые и минимальные уровни звука.\n<html>");
        secondSlide.add(upInfo);

        JLabel msg1 = createPanel(100, 300, 300, 170);
        msg1.setText("<html>Сигнал от измерителя звукового давления или виброускорения, которыми могут" +
                " быть измерительные микрофоны или акселерометры, проходит через предусилитель прибора и доходит до шумомера. </html>");
        JLabel htb1 = hitbox(18,95,308-18,289-95, msg1);
        secondSlide.add(msg1);
        secondSlide.add(htb1);

        JLabel msg2  = createPanel(400, 300, 400, 300);
        msg2.setText("<html>Сигнал преобразуется в аналого-цифровом преобразователе," +
                " далее в шумомере проходит через набор октавных фильтров чтобы" +
                " затем их параметры можно было измерить и использовать для других операций." +
                " У шумомера есть несколько режимов работы, все управляющиеся с помощью клавиатуры," +
                " но для работы с «Шепот» основным является SLM+RTA (Sound Level Measure +" +
                " Real Time Analysis), позволяющий измерение звукового уровня и анализ а" +
                " реальном времени, иными словами, частотный анализ. </html>");
        JLabel htb2 = hitbox(313,84,867-313,312-84, msg2);
        secondSlide.add(msg2);
        secondSlide.add(htb2);

        JLabel msg3  = createPanel(400, 200, 400, 120);
        msg3.setText("<html>Цифровые значения, полученные впоследствии работы шумомера," +
                " проходят к ПЭВМ, где используется для создания отчетов и результатов измерений</html>");
        JLabel htb3 = hitbox(463,314,865-463,484-314, msg3);
        secondSlide.add(msg3);
        secondSlide.add(htb3);

        JLabel msg4  = createPanel(100, 300, 300, 250);
        msg4.setText("<html>Долгое зажатие этой кнопки отключает шумомер, в то время как быстрое включает и," +
                " при включенном состоянии, включает экран PWR, которое позволяет поменять контраст," +
                " включить/выключить фонарик или изменить настройки при включении шумомера.</html>");
        JLabel htb4 = hitbox(36,411,87-36,463-411, msg4);
        secondSlide.add(msg4);
        secondSlide.add(htb4);

        JLabel msg5  = createPanel(250, 250, 220, 140);
        msg5.setText("<html>При нажатии шумомер или начинает или окончательно заканчивает свои измерения.</html>");
        JLabel htb5 = hitbox(187,301,251-187,359-301, msg5);
        secondSlide.add(msg5);
        secondSlide.add(htb5);

        JLabel msg6  = createPanel(200, 250, 400, 120);
        msg6.setText("<html>При нажатии в зависимости от типа измерений приостанавливает измерения," +
                " стирает ненужную информацию из измерений и позволяет посмотреть информацию идущую" +
                " в шумомер до ее регистрации в память.</html>");
        JLabel htb6 = hitbox(126,308,184-126,359-308, msg6);
        secondSlide.add(msg6);
        secondSlide.add(htb6);
        JLabel msg7  = createPanel(150, 300, 400, 100);
        msg7.setText("<html>Позволяет отчистить память шумомера от всех значений последнего измерения.</html>");
        JLabel htb7 = hitbox(72,339,125-72,395-339, msg7);
        secondSlide.add(msg7);
        secondSlide.add(htb7);

        JLabel msg8  = createPanel(300, 300, 300, 180);
        msg8.setText("<html>Стрелки используются для навигации в меню по списку , для открытия дополнительных" +
                " опций меню и для смены дисплеев. Центральная кнопка позволяет" +
                " выбрать элемент в меню или сохранить опции.</html>");
        JLabel htb8 = hitbox(136,381,251-136,497-381, msg8);
        secondSlide.add(msg8);
        secondSlide.add(htb8);

        JLabel msg9  = createPanel(110, 500, 400, 100);
        msg9.setText("<html>Открывает меню всех возможных способов показать результаты на дисплее.</html>");
        JLabel htb9 = hitbox(76,465,110-76,504-465, msg9);
        secondSlide.add(msg9);
        secondSlide.add(htb9);

        JLabel msg10  = createPanel(150, 500, 300, 100);
        msg10.setText("<html>Открывает меню с сохраненной информацией о результатах, такой как:" +
                " время измерений, время интервалов измерений и т.д.</html>");
        JLabel htb10 = hitbox(108,496,144-108,534-496, msg10);
        secondSlide.add(msg10);
        secondSlide.add(htb10);

        JLabel msg11  = createPanel(180, 500, 400, 100);
        msg11.setText("<html>Открывает меню SETUP, где можно создать," +
                " изменять и удалять группы инструментов известные как instrument definitions (ID)</html>");
        JLabel htb11 = hitbox(146,520,186-146,558-520, msg11);
        secondSlide.add(msg11);
        secondSlide.add(htb11);

        JLabel msg12  = createPanel(220, 500, 300, 100);
        msg12.setText("<html>Позволяет зайти в управление калибровкой, использования батареи, памятью, таймером и т.д.</html>");
        JLabel htb12 = hitbox(188,534,230-188,571-534, msg12);
        secondSlide.add(msg12);
        secondSlide.add(htb12);

        JLabel msg13  = createPanel(270, 500, 300, 100);
        msg13.setText("<html>Открывает меню Print для изменения настроек печати результатов</html>");
        JLabel htb13 = hitbox(234,544,272-234,581-544, msg13);
        secondSlide.add(msg13);
        secondSlide.add(htb13);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\LD_interface.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(20, 300, 300, 300);
        newimg = image.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        secondSlide.add(img);

    }
    private void createThirdSlide() {
        thirdSlide = createSlide("", "Рабочая укладка", true, 70);

        JLabel msg1 = createPanel(150, 320, 300, 220);
        msg1.setText("<html>К разъему «КАНАЛ 1» подключается микрофон, измеряющий тестовый сигнал исходящий из" +
                " генератора тестовых сигналов. Зеленый индикатор «ВКЛ» сигнализирует о том, подключен ли" +
                " микрофон к коммутатору. Если он подключен, то индикатор загорается.</html>");
        JLabel htb1 = hitbox(168,208,427-168,324-208, msg1);
        thirdSlide.add(msg1);
        thirdSlide.add(htb1);

        JLabel msg2  = createPanel(50, 207, 400, 150);
        msg2.setText("<html>К разъему  «КАНАЛ 2» подключаются микрофон или акселерометр," +
                " измеряющий уровень информативного сигнала, фона и помехи. Зеленый индикатор" +
                " «ВКЛ» сигнализирует о том, подключен ли микрофон к коммутатору. Если он подключен," +
                " то индикатор загорается. </html>");
        JLabel htb2 = hitbox(165,91,425-165,207-91, msg2);
        thirdSlide.add(msg2);
        thirdSlide.add(htb2);

        JLabel msg3  = createPanel(50, 436, 400, 170);
        msg3.setText("<html>К разъему «Управление» подключается генератор тестового сигнала." +
                " При подключенной к коммутатору ПЭВМ работой генератора можно управлять через" +
                " установленное на компьютер СПО «Шепот-Интерфейс».  Зеленый индикатор сигнализирует о работе генератора.</html>");
        JLabel htb3 = hitbox(161,321, 427-161,436-321, msg3);
        thirdSlide.add(msg3);
        thirdSlide.add(htb3);

        JLabel msg4  = createPanel(30, 150, 300, 310);
        msg4.setText("<html>К разъему «USB» подключается ПЭВМ, в комплектации «Шепота» ее роль играет ноутбук который входит в состав." +
                " С помощью СПО «Шепот-Интерфейс» пользователь может контролировать работу генератора тестового сигнала и подключенных" +
                " к рабочей укладке микрофонов/акселерометров. Индикатор «НОРМА» собщает о работоспособности ПЭВМ и, при ее удачном" +
                " подключении к рабочей укладке, он загорается зеленым. </html>");
        JLabel htb4 = hitbox(34,446,235-34,573-446, msg4);
        thirdSlide.add(msg4);
        thirdSlide.add(htb4);

        JLabel msg5  = createPanel(150, 150, 250, 230);
        msg5.setText("<html>Два индикатора красного цвета «ПИТ МКФ», сигнализирующие о том, подано ли питание на микрофон/акселерометр." +
                " Если питание подано на один из двух каналов, соответствующий ему индикатор загорается.</html>");
        JLabel htb5 = hitbox(37,91,151-37,298-91, msg5);
        thirdSlide.add(msg5);
        thirdSlide.add(htb5);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Work_Layout.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(30, 80, 500, 500);
        newimg = image.getScaledInstance(400, 500,  java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        thirdSlide.add(img);

        JLabel upInfo = new JLabel();
        upInfo.setBounds(550, 75,670,600);
        upInfo.setFont(new Font("Calibri", Font.BOLD, 28));
        upInfo.setVerticalAlignment(JLabel.TOP);
        upInfo.setForeground(textColor);
        upInfo.setHorizontalAlignment(JLabel.LEFT);
        upInfo.setText("<html>Коммутатор смонтирован в рабочей укладке и предназначен для" +
                " обеспечения управления элементами системы, включение / отключение генератора" +
                " шума, подключение/отключение микрофонов/акселерометров, а также передачу" +
                " значений сигналов на подключенную к коммутатору ПЭВМ.\n" +
                "У коммутатора 2 канала для подключения измерительных устройств – микрофонов" +
                " или акселерометров, USB выход для подключения ПЭВМ и Разъем «управления»" +
                " для подключения генератора тестового сигнала.\n<html>");
        thirdSlide.add(upInfo);
    }
    private void createFourthSlide() {
        founthLide = createSlide("", "Соединительные кабели/Микрофон", true, 70);

        JLabel upInfo = new JLabel();
        upInfo.setBounds(75, 75, 1000, 600);
        upInfo.setFont(new Font("Calibri", Font.BOLD, 25));
        upInfo.setVerticalAlignment(JLabel.TOP);
        upInfo.setForeground(textColor);
        upInfo.setHorizontalAlignment(JLabel.LEFT);
        upInfo.setText("<html> Соединительные кабели<br>" +
                "Электрические и оптоволоконные кабели, используемые для электрического соединения устройств между" +
                " собой, а также  для передачи сигналов низкого уровня, в том числе в системах сбора информации и" +
                " линий связи сборок внутриреакторных детекторов и термоконтроля. В комплект «Шепота» входят" +
                "  соединительные и измерительные кабели, блок аккумуляторных батарей «БА-ШМ», два штатива и зарядные устройства.<br><br>" +
                "Микрофон<br>" +
                "В комплекте «Шепот» предоставляются два конденсаторных микрофона «РСВ Piezotronics TMS130D20»." +
                "  Микрофоны необходимы для проведения измерений уровней тестового сигнала от акустического излучателя (звуковой колонки)." +
                "  В микрофоны встроен тефлоновый кабель, а их чувствительность составляет 10mV/g.\n" +
                "В комплект измерительного микрофона также входит предусилитель, чтобы присоединить его необходимо без приложения" +
                " больших усилий аккуратно вставить штекер разъема предусилителя в разъем измерительного модуля и закрутить блокировочное кольцо по часовой стрелке.\n<html>");
        founthLide.add(upInfo);
    }
    private void createFifthSlide() {
        fifthSlide = createSlide("", "Портативный компьютер", true, 70);

        JLabel upInfo = new JLabel();
        upInfo.setBounds(730, 150, 550, 500);
        upInfo.setFont(new Font("Calibri", Font.BOLD, 30));
        upInfo.setVerticalAlignment(JLabel.TOP);
        upInfo.setForeground(textColor);
        upInfo.setHorizontalAlignment(JLabel.LEFT);
        upInfo.setText("<html>Компьютер с программным обеспечением  «Шепот-Интерфейс» предназначен для" +
                " управления компонентами системы, ведения базы данных об исследуемых объектах и " +
                "результатах измерений, выполнения необходимых расчетов и подготовки отчета.<br>" +
                "<br>Главное окно программы «Шепот-Интерфейс»<html>");
        fifthSlide.add(upInfo);

        JLabel msg1 = createPanel(52,180,301-52,553-180);
        msg1.setFont(new Font("Calibri", Font.BOLD, 30));
        msg1.setText("<html>«Добавление объекта»</html>");
        JLabel htb1 = hitbox(54,141,125-87,175-141, msg1);
        fifthSlide.add(msg1);
        fifthSlide.add(htb1);

        JLabel msg2  = createPanel(52,180,301-52,553-180);
        msg2.setFont(new Font("Calibri", Font.BOLD, 30));
        msg2.setText("<html>«Просмотреть/ Изменить параметры объекта»</html>");
        JLabel htb2 = hitbox(87,141,125-87,175-141, msg2);
        fifthSlide.add(msg2);
        fifthSlide.add(htb2);

        JLabel msg3  = createPanel(52,180,301-52,553-180);
        msg3.setFont(new Font("Calibri", Font.BOLD, 30));
        msg3.setText("<html>«Добавление помещения»</html>");
        JLabel htb3 = hitbox(128,144,166-128,174-144, msg3);
        fifthSlide.add(msg3);
        fifthSlide.add(htb3);

        JLabel msg4  = createPanel(52,180,301-52,553-180);
        msg4.setFont(new Font("Calibri", Font.BOLD, 30));
        msg4.setText("<html>«Просмотреть/ Изменить параметры помещения»</html>");
        JLabel htb4 = hitbox(166,142,202-166,173-142, msg4);
        fifthSlide.add(msg4);
        fifthSlide.add(htb4);

        JLabel msg5  = createPanel(52,180,301-52,553-180);
        msg5.setFont(new Font("Calibri", Font.BOLD, 30));
        msg5.setText("<html>«Добавить контрольную точку»</html>");
        JLabel htb5 = hitbox(211,143,248-211,174-143, msg5);
        fifthSlide.add(msg5);
        fifthSlide.add(htb5);

        JLabel msg6  = createPanel(52,180,301-52,553-180);
        msg6.setFont(new Font("Calibri", Font.BOLD, 30));
        msg6.setText("<html>«Просмотр контрольной точки»</html>");
        JLabel htb6 = hitbox(247,142,282-247,173-142, msg6);
        fifthSlide.add(msg6);
        fifthSlide.add(htb6);
        JLabel msg7  = createPanel(309,182,688-309,551-182);
        msg7.setFont(new Font("Calibri", Font.BOLD, 30));
        msg7.setText("<html>«Копирование контрольной точки»</html>");
        JLabel htb7 = hitbox(283,143,319-283,172-143, msg7);
        fifthSlide.add(msg7);
        fifthSlide.add(htb7);

        JLabel msg8  = createPanel(309,182,688-309,551-182);
        msg8.setFont(new Font("Calibri", Font.BOLD, 30));
        msg8.setText("<html>«Удаление элемента»</html>");
        JLabel htb8 = hitbox(324,143,319-283,172-143, msg8);
        fifthSlide.add(msg8);
        fifthSlide.add(htb8);

        JLabel msg9  = createPanel(309,182,688-309,551-182);
        msg9.setFont(new Font("Calibri", Font.BOLD, 30));
        msg9.setText("<html>«Отчет по объектам»</html>");
        JLabel htb9 = hitbox(369,143,319-283,172-143, msg9);
        fifthSlide.add(msg9);
        fifthSlide.add(htb9);

        JLabel msg10  = createPanel(309,182,688-309,551-182);
        msg10.setFont(new Font("Calibri", Font.BOLD, 30));
        msg10.setText("<html>«Параметры соединения с шумомером и контрольной точки»\n</html>");
        JLabel htb10 = hitbox(406,143,319-283,172-143, msg10);
        fifthSlide.add(msg10);
        fifthSlide.add(htb10);

        JLabel msg11  = createPanel(309,182,688-309,551-182);
        msg11.setFont(new Font("Calibri", Font.BOLD, 30));
        msg11.setText("<html>«Тест коммутатора»</html>");
        JLabel htb11 = hitbox(444,143,319-283,172-143, msg11);
        fifthSlide.add(msg11);
        fifthSlide.add(htb11);

        JLabel msg12  = createPanel(309,182,688-309,551-182);
        msg12.setFont(new Font("Calibri", Font.BOLD, 30));
        msg12.setText("<html>«Выход из программы»</html>");
        JLabel htb12 = hitbox(490,143,319-283,172-143, msg12);
        fifthSlide.add(msg12);
        fifthSlide.add(htb12);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Interface.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(50, 85, 650, 500);
        newimg = image.getScaledInstance(650, 500, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        fifthSlide.setLayout(null);
        fifthSlide.add(img);
    }
    private void createSixthSlide() {
        sixthSlide = createSlide("", "Приемник и передатчик", false, 70);

        JLabel msg1 = createPanel(200,200,250,100);
        msg1.setText("<html>Индикатор желтого цвета, загорается при разрядке батарей</html>");
        JLabel htb1 = hitbox(268,129,307-268,203-129, msg1);
        sixthSlide.add(msg1);
        sixthSlide.add(htb1);

        JLabel msg2  = createPanel(240,200,250,100);
        msg2.setText("<html>Индикатор зеленого цвета, горит пока идет стабильный прием данных</html>");
        JLabel htb2 = hitbox(314,135,352-314,201-135, msg2);
        sixthSlide.add(msg2);
        sixthSlide.add(htb2);

        JLabel msg3  = createPanel(280,200,250,100);
        msg3.setText("<html>Индикатор красного цвета, загорается при перегрузке</html>");
        JLabel htb3 = hitbox(353,130,404-353,197-130, msg3);
        sixthSlide.add(msg3);
        sixthSlide.add(htb3);

        JLabel msg4  = createPanel(330,200,250,100);
        msg4.setText("<html>Индикатор неустойчивого приема сигнала, загорается при разрыве цепи</html>");
        JLabel htb4 = hitbox(407,128,444-407,196-128, msg4);
        sixthSlide.add(msg4);
        sixthSlide.add(htb4);

        JLabel msg5  = createPanel(390,200,250,130);
        msg5.setText("<html>Кнопка «СБР», нажимается, если цепь была разорвана и индикатор" +
                " неустойчивого приема сигнала непрерывно горит красным</html>");
        JLabel htb5 = hitbox(464,127,520-464,203-127, msg5);
        sixthSlide.add(msg5);
        sixthSlide.add(htb5);

        JLabel msg6  = createPanel(470,200,250,100);
        msg6.setText("<html>Индикатор зеленого цвета, загорается при подключении питания</html>");
        JLabel htb6 = hitbox(545,128,580-545,204-128, msg6);
        sixthSlide.add(msg6);
        sixthSlide.add(htb6);

        JLabel msg7  = createPanel(500,190,250,100);
        msg7.setText("<html>Разъем для подключения внешнего источника питания</html>");
        JLabel htb7 = hitbox(578,81,670-578,185-81, msg7);
        sixthSlide.add(msg7);
        sixthSlide.add(htb7);

        JLabel msg8  = createPanel(600,190,250,100);
        msg8.setText("<html>Выключатель питания</html>");
        JLabel htb8 = hitbox(684,84,785-684,187-84, msg8);
        sixthSlide.add(msg8);
        sixthSlide.add(htb8);

        JLabel msg9  = createPanel(900,230,250,100);
        msg9.setText("<html>Выходной разъем для подключения к рабочей укладке</html>");
        JLabel htb9 = hitbox(995,90,1099-995,216-90, msg9);
        sixthSlide.add(msg9);
        sixthSlide.add(htb9);

        JLabel msg10  = createPanel(180,470,250,100);
        msg10.setText("<html>Выходной разъем для подключения к рабочей укладке</html>");
        JLabel htb10 = hitbox(177,394,241-177,475-394, msg10);
        sixthSlide.add(msg10);
        sixthSlide.add(htb10);

        JLabel msg11  = createPanel(300,240,250,150);
        msg11.setText("<html>Индикатор перегрузки красного цвета, загорается, если " +
                "динамический диапазон входного сигнала превышает предельно допустимый</html>");
        JLabel htb11 = hitbox(326,388,393-326,471-388, msg11);
        sixthSlide.add(msg11);
        sixthSlide.add(htb11);

        JLabel msg12  = createPanel(450,470,250,120);
        msg12.setText("<html>Индикатор зеленого цвета, загорается при подключении питания</html>");
        JLabel htb12 = hitbox(484,389,539-484,473-389, msg12);
        sixthSlide.add(msg12);
        sixthSlide.add(htb12);

        JLabel msg13  = createPanel(500,470,250,100);
        msg13.setText("<html>Выключатель питания</html>");
        JLabel htb13 = hitbox(537,339,636-537,458-339, msg13);
        sixthSlide.add(msg13);
        sixthSlide.add(htb13);

        JLabel msg14  = createPanel(620,470,250,100);
        msg14.setText("<html>Разъем для подключения антенны</html>");
        JLabel htb14 = hitbox(655,342,782-655,461-342, msg14);
        sixthSlide.add(msg14);
        sixthSlide.add(htb14);

        JLabel msg15  = createPanel(1000,490,250,100);
        msg15.setText("<html>Разъем для подключения измерительного микрофона или акселерометра</html>");
        JLabel htb15 = hitbox(1035,340,1140-1035,480-340, msg15);
        sixthSlide.add(msg15);
        sixthSlide.add(htb15);

        JLabel priem = new JLabel(new ImageIcon(".\\assets\\Priemnik.png"));
        priem.setBounds(150, 80, 1000, 150);
        sixthSlide.add(priem);

        JLabel btmTxt = new JLabel("<html><center>Приемник предназначен для преобразования принятого радиосигнала" +
                " в аналоговый. На панели приемника расположены индикаторы разряда батарей, устойчивого " +
                "или неустойчивого приема данных и перегрузки. Также есть разъем для подключения внешнего " +
                "источника питания и разъем для подключения к рабочей укладке. На задней панели приемника" +
                " расположен разъем для подключения антенны.</html>");
        btmTxt.setBounds(150, 240, 1000, 200);
        btmTxt.setFont(new Font("Calibri", Font.BOLD, 20));
        btmTxt.setVerticalAlignment(JLabel.TOP);
        btmTxt.setForeground(textColor);
        btmTxt.setHorizontalAlignment(JLabel.LEFT);
        sixthSlide.add(btmTxt);

        JLabel peredatchik = new JLabel(new ImageIcon(".\\assets\\Peredatchik.png"));
        peredatchik.setBounds(150, 340, 1000, 150);
        sixthSlide.add(peredatchik);

        JLabel btm2Txt = new JLabel("<html><center>Передатчик предназначен для преобразования аналогового электрического" +
                " сигнала от измерительного устройства (микрофона или акселерометра) в цифровой сигнал и формирования" +
                " радиосигнала. На панели передатчика расположены индикаторы разряда батарей, подключения источника" +
                " питания и перегрузки, а также разъем для подключения микрофона и выключатель питания. На задней панели " +
                "передатчика расположен разъем для подключения антенны.</html>");
        btm2Txt.setBounds(100, 490, 1100, 100);
        btm2Txt.setFont(new Font("Calibri", Font.BOLD, 19));
        btm2Txt.setVerticalAlignment(JLabel.TOP);
        btm2Txt.setForeground(textColor);
        btm2Txt.setHorizontalAlignment(JLabel.LEFT);
        sixthSlide.add(btm2Txt);
    }
    private void createSeventhSlide() {
        seventhSlide = createSlide("", "Генератор шума «Шорох-2МИ»", true, 70);

        JLabel msg1 = createPanel(100,100,250,100);
        msg1.setText("<html>Разъем для подключения внешнего питания</html>");
        JLabel htb1 = hitbox(279,181,355-279,349-181, msg1);
        seventhSlide.add(msg1);
        seventhSlide.add(htb1);

        JLabel msg2  = createPanel(240,200,250,100);
        msg2.setText("<html>Кнопка для ручного отключения генератора</html>");
        JLabel htb2 = hitbox(374,111,430-374,179-111, msg2);
        seventhSlide.add(msg2);
        seventhSlide.add(htb2);

        JLabel msg3  = createPanel(320,100,250,100);
        msg3.setText("<html>Разъем для подключения генератора к рабочей укладке</html>");
        JLabel htb3 = hitbox(370,197,432-370,265-197, msg3);
        seventhSlide.add(msg3);
        seventhSlide.add(htb3);

        JLabel msg4  = createPanel(330,200,250,100);
        msg4.setText("<html>Разъем для подключения акустического излучателя</html>");
        JLabel htb4 = hitbox(516,108,570-516,186-108, msg4);
        seventhSlide.add(msg4);
        seventhSlide.add(htb4);

        JLabel msg5  = createPanel(390,200,250,130);
        msg5.setText("<html>Переключатель для подключения выхода к внутреннему или внешнему источнику шума</html>");
        JLabel htb5 = hitbox(447,112,502-447,198-112, msg5);
        seventhSlide.add(msg5);
        seventhSlide.add(htb5);

        JLabel msg6  = createPanel(130,200,250,100);
        msg6.setText("<html>Выключатель питания</html>");
        JLabel htb6 = hitbox(56,188,121-56,300-188, msg6);
        seventhSlide.add(msg6);
        seventhSlide.add(htb6);

        JLabel msg7  = createPanel(130,190,250,100);
        msg7.setText("<html>Регулятор уровня сигнала</html>");
        JLabel htb7 = hitbox(177,118,245-177,194-118, msg7);
        seventhSlide.add(msg7);
        seventhSlide.add(htb7);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Sheroh-2MI.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(30, 80, 700, 300);
        newimg = image.getScaledInstance(700, 300,  java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        seventhSlide.add(img);

        JLabel btm2Txt = new JLabel("<html>Генератор шума предназначен для генерации электрического сигнала с возможностью регулировки" +
                " его уровня на центральных октавных частотах 250, 500, 1000, 2000, 4000 Гц. </html>");
        btm2Txt.setBounds(780, 90, 420, 500);
        btm2Txt.setFont(new Font("Calibri", Font.BOLD, 30));
        btm2Txt.setVerticalAlignment(JLabel.TOP);
        btm2Txt.setForeground(textColor);
        btm2Txt.setHorizontalAlignment(JLabel.LEFT);
        seventhSlide.add(btm2Txt);

        JLabel btm3Txt = new JLabel("<html>На панели генератора имеются: разъем «Выход»" +
                " для подключения звукового излучателя, переключатель «Внутр-Внеш» для подключения выхода к источнику шума, регулятор уровня" +
                " сигнала и кнопка «Упр» для ручного отключения генератора. Уровень сигнала можно изменить до 20 дБ с помощью эквалайзера" +
                " находящегося под крышкой генератора.</html>");
        btm3Txt.setBounds(30, 400, 1000, 200);
        btm3Txt.setFont(new Font("Calibri", Font.BOLD, 30));
        btm3Txt.setVerticalAlignment(JLabel.TOP);
        btm3Txt.setForeground(textColor);
        btm3Txt.setHorizontalAlignment(JLabel.LEFT);
        seventhSlide.add(btm3Txt);
    }
    private void createEighthSlide() {
        eighthSlide = createSlide("", "Калибратор CAL-200", true, 70);

        JLabel msg10  = createPanel(50,327,688-309,220);
        msg10.setText("<html>Малогабаритный источник звука, работающий от батарей," +
                " состоящий из измерительного блока и камеры малого объема с отверстием" +
                " для подсоединения микрофона. Его воспроизводимый уровень звукового давления" +
                " 94 и 114 дБ, пределы допускаемой абсолютной погрешности воспроизведения УЗД" +
                " ±10 Гц, а коэффициент нелинейных искажений – 2%</html>");
        JLabel htb10 = hitbox(62,109,378-62,447-109, msg10);
        eighthSlide.add(msg10);
        eighthSlide.add(htb10);

        JLabel msg11  = createPanel(10,300,688-309,230);
        msg11.setText("<html>Принцип работы основан на обратной связи с ICP-микрофоном," +
                " используя его в цепи системы «излучатель – генератор», поддерживая," +
                " таким образом, постоянный уровень звукового давления. CAL 200 имеет" +
                " номинальный диаметр отверстия под ½’’ микрофон, для микрофонов других" +
                " диаметров работа осуществляется с помощью переходников.</html>");
        JLabel htb11 = hitbox(379,311,455-379,418-311, msg11);
        eighthSlide.add(msg11);
        eighthSlide.add(htb11);

        JLabel msg12  = createPanel(150,170,688-309,200);
        msg12.setText("<html>Измерительный микрофон TMS130D20 ," +
                " прикреплённый к калибратору. Для калибровки микрофона" +
                " его следует соединить с рабочей укладкой для работы" +
                " с ним через СПО «Шепот-Интерфейс». Также при креплении" +
                " микрофона к калибратору не стоит прикладывать много силы," +
                " чтобы не сломать хрупкие детали микрофона.</html>");
        JLabel htb12 = hitbox(457,347,680-457,578-347, msg12);
        eighthSlide.add(msg12);
        eighthSlide.add(htb12);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\CAL200.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(50, 85, 650, 500);
        newimg = image.getScaledInstance(650, 500, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        eighthSlide.setLayout(null);
        eighthSlide.add(img);

        JLabel btm2Txt = new JLabel("<html>Калибратор предназначен для калибровки шумомера созданием в камере звукового" +
                " давления 94 или 114 дБ на частоте 1000 Гц в течении двух минут. Для получения наиболее точного результата," +
                " с помощью акустического калибратора проводится юстировка шумомера. Данная процедура выполняется перед " +
                "проведением замеров и после них.</html>");
        btm2Txt.setBounds(780, 90, 420, 500);
        btm2Txt.setFont(new Font("Calibri", Font.BOLD, 25));
        btm2Txt.setVerticalAlignment(JLabel.TOP);
        btm2Txt.setForeground(textColor);
        btm2Txt.setHorizontalAlignment(JLabel.LEFT);
        eighthSlide.add(btm2Txt);
    }
    private void createNinethSlide() {
        ninethSlide = createSlide("", "Акселерометр «АР98-100»", true, 70);

        JLabel msg1 = createPanel(140,180,301-52,120);
        msg1.setText("<html>Встроенный усилитель, обеспечивающий широкий диапазон питающего напряжения и тока</html>");
        JLabel htb1 = hitbox(456,176,517-456,212-176, msg1);
        ninethSlide.add(msg1);
        ninethSlide.add(htb1);

        JLabel msg2  = createPanel(140,210,301-52,150);
        msg2.setText("<html>Встроенный усилитель, обеспечивающий широкий диапазон питающего напряжения и тока</html>");
        JLabel htb2 = hitbox(548,210,603-548,266-210, msg2);
        ninethSlide.add(msg2);
        ninethSlide.add(htb2);

        JLabel msg3  = createPanel(140,266,301-52,150);
        msg3.setText("<html>Встроенный усилитель, обеспечивающий широкий диапазон питающего напряжения и тока</html>");
        JLabel htb3 = hitbox(456,266,691-456,354-266, msg3);
        ninethSlide.add(msg3);
        ninethSlide.add(htb3);

        JLabel msg4  = createPanel(140,317,301-52,200);
        msg4.setText("<html>Пьезоэлемент – датчик из цирконата или титаната свинца или монокристалл, " +
                "приводится в движения посредством ускорения и таким образом меняет  вокруг себя уровень напряженности поля</html>");
        JLabel htb4 = hitbox(470,357,680-470,384-357, msg4);
        ninethSlide.add(msg4);
        ninethSlide.add(htb4);

        JLabel msg5  = createPanel(140,383,301-52,150);
        msg5.setText("<html>Основание, вместе с пьезоэлементом служит демпфером и гасит колебания пружины</html>");
        JLabel htb5 = hitbox(429,383,718-429,524-383, msg5);
        ninethSlide.add(msg5);
        ninethSlide.add(htb5);

        JLabel msg6  = createPanel(140,440,301-52,150);
        msg6.setText("<html>Крепежная шпилька, с помощью нее акселерометр крепится к поверхности для которой проводятся измерения</html>");
        JLabel htb6 = hitbox(547,525,605-547,578-525, msg6);
        ninethSlide.add(msg6);
        ninethSlide.add(htb6);

//        JLabel msg7  = createPanel(309,182,688-309,551-182);
//        msg7.setFont(new Font("Calibri", Font.BOLD, 30));
//        msg7.setText("<html>«Копирование контрольной точки»</html>");
//        JLabel htb7 = hitbox(512,79,639-512,180-79, msg7);
//        ninethSlide.add(msg7);
//        ninethSlide.add(htb7);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\P98-100.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(10, 85, 400, 300);
        newimg = image.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        ninethSlide.setLayout(null);
        ninethSlide.add(img);

        JLabel img2 = new JLabel();
        ImageIcon unit2 = new ImageIcon(".\\assets\\P98-100-Boardview.png");
        Image image2 = unit2.getImage();
        Image newimg2;
        img2.setBounds(420, 85, 300, 500);
        newimg2 = image2.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
        unit2 = new ImageIcon(newimg2);
        img2.setVerticalAlignment(JLabel.TOP);
        img2.setIcon(unit2);
        ninethSlide.setLayout(null);
        ninethSlide.add(img2);


        JLabel btm2Txt = new JLabel("<html>Вибропреобразователь, предназначенный для преобразования механических" +
                " колебаний объекта в электрический сигнал, пропорциональный вибрационному или ударному ускорению" +
                " механической системы. Принцип действия акселерометра заключается в следующем: в его конструкции" +
                " используется механическая схема с пьезоэлементом, работающим на сдвиг, и встроенный усилитель," +
                " обеспечивающий широкий диапазон питающего напряжения и тока. Крепление к объекту контроля осуществляется" +
                " с помощью шпильки.</html>");
        btm2Txt.setBounds(780, 90, 420, 500);
        btm2Txt.setFont(new Font("Calibri", Font.BOLD, 22));
        btm2Txt.setVerticalAlignment(JLabel.TOP);
        btm2Txt.setForeground(textColor);
        btm2Txt.setHorizontalAlignment(JLabel.LEFT);
        ninethSlide.add(btm2Txt);
    }
    private void createlastSlide() {
        lastSlide = createSlide("", "Акустический излучатель", true, 70);

        JLabel peredatchik = new JLabel(new ImageIcon(".\\assets\\Transmittor.png"));
        peredatchik.setBounds(75, 80, 150, 550);
        lastSlide.add(peredatchik);

        JLabel btmTxt = new JLabel("<html>«Громкоговоритель «Шорох-2МИ, установленный на стойку»</html>");
        btmTxt.setBounds(20, 80, 350, 100);
        btmTxt.setFont(new Font("Calibri", Font.BOLD, 21));
        btmTxt.setVerticalAlignment(JLabel.TOP);
        btmTxt.setForeground(textColor);
        btmTxt.setHorizontalAlignment(JLabel.LEFT);
        lastSlide.add(btmTxt);

        JLabel btm2Txt = new JLabel("<html>Экранированный акустический излучатель, используемый при проведении" +
                " измерений акустоэлектрических преобразований. Акустическим излучателем в комплекте «Шепот» служит" +
                " громкоговоритель «Шорох-2МИ». Используется для создания тестового сигнала, исходящего от" +
                " генератора тестового сигнала, при проверке помещений и материалов. Также в составе даны" +
                " соединительный кабель для подключения модуля источника тестового акустического сигнала" +
                " к акустической системе и стойка для установки акустической системы.</html>");
        btm2Txt.setBounds(380, 90, 720, 500);
        btm2Txt.setFont(new Font("Calibri", Font.BOLD, 30));
        btm2Txt.setVerticalAlignment(JLabel.TOP);
        btm2Txt.setForeground(textColor);
        btm2Txt.setHorizontalAlignment(JLabel.LEFT);
        lastSlide.add(btm2Txt);
    }
}