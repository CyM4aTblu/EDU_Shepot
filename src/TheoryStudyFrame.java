import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TheoryStudyFrame extends JPanel {
    Color LtPurple = new Color(103, 82, 128);
    Color background = new Color(237, 239, 246);
    Color textColor = new Color(0x6e67a0);
    Color btmTopBars = new Color(193, 197, 220);
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel firstSlide, secondSlide, thirdSlide, founthLide, fifthSlide, slide6, slide7, slide8, slide9, slide10;
    private JPanel slide11, slide12, slide13;
    TheoryStudyFrame(ActionListener onReturn){
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
        createSlide10();
        createSlide11();
        createSlide12();
        createSlide13();

// set up for screens panels containers

        slideShow.add("1", firstSlide);
        slideShow.add("2", secondSlide);
        slideShow.add("3", thirdSlide);
        slideShow.add("4", founthLide);
        slideShow.add("5", fifthSlide);
        slideShow.add("6", slide6);
        slideShow.add("7", slide7);
        slideShow.add("8", slide8);
        slideShow.add("9", slide9);
        slideShow.add("10", slide10);
        slideShow.add("11", slide11);
        slideShow.add("12", slide12);
        slideShow.add("13", slide13);
        crd.show(slideShow, "1");

        returnToMenu.addActionListener(onReturn);
    }
    private JPanel createCompSlide(Color color) {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(color);
        slide.setBounds(0, 0, 1280, 605);
        return slide;
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

    }
    private void createFirstSlide() {
        firstSlide = createSlide(".\\assets\\Study1.png", "Раздел 1", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(800, 80, 450, 500);
        instructions.setFont(new Font("Calibri", Font.BOLD, 22));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Для проведения измерительных мероприятий комплекс должен содержать: генератор шума, усилитель мощности, акустический излучатель," +
                " где минимальный уровень звукового давления на расстоянии метра от него должен быть 90 дБ, два измерительных микрофона, шумомер, акселерометр," +
                " электронную вычислительную машину с установленным ПО «Шепот-Интерфейс»<br>" +
                "Калибровка системы проводится всегда перед началом измерений.<br>" +
                "Для начала проводится калибрвока микрофона. Для нее необходимо подключить один из микрофонов к шумомеру. Сделать это можно, собрав систему «Шепот» следующим образом.\n</html>");
        firstSlide.add(instructions);

        JLabel msg1 = createPanel(438,308,250,130);
        msg1.setText("<html>Средство измерения (шумомер) – используется для калибровки микрофона после настройки СПО «Шепот-Интерфейс»</html>");
        JLabel htb1 = hitbox(242,234 ,438-242,308-234, msg1);
        firstSlide.add(msg1);
        firstSlide.add(htb1);

        JLabel msg2  = createPanel(492,266,300,290);
        msg2.setText("<html>Рабочая укладка с управляемым коммутатором\n" +
                "По первому каналу с помощью кабеля микрофон, который необходимо откалибровать," +
                " подключается к коммутатору, в то время как персональная электронная вычислительная машина" +
                " с настроенный СПО «шепот-Интерфейс» подключается к коммутатору через USB </html>");
        JLabel htb2 = hitbox(187,110,492-187,326-110, msg2);
        firstSlide.add(msg2);
        firstSlide.add(htb2);

        JLabel msg3  = createPanel(350,130,250,250);
        msg3.setText("<html>Калибратор CAL-200\n" +
                "Для калибровки микрофона TMS130D20 его прикрепляют к калибратору CAL-200," +
                " затем при помощи соединительного кабеля микрофон подключается к первому каналу рабочей укладки  </html>");
        JLabel htb3 = hitbox(621,111,781-621,232-111, msg3);
        firstSlide.add(msg3);
        firstSlide.add(htb3);

        JLabel msg4  = createPanel(200,170,300,420);
        msg4.setText("<html>Микрофон «РСВ Piezotronics TMS130D20»\n" +
                "Микрофон ICP типа от компании PCB Piezotronics, состоит из чувствительного элемента," +
                " выполненного из пьезоэлектрического материала, который преобразует механическую" +
                " нагрузку в электрический сигнал, а также из микросхемы, используемой для усиления" +
                " сигнала и его передачи на внешние устройства. Используемый предусилитель" +
                " определяет скорость утечки генерируемого пьезоэлементами акселерометра" +
                " электрического сигнала \n</html>");
        JLabel htb4 = hitbox(548,200,643-548,273-200, msg4);
        firstSlide.add(msg4);
        firstSlide.add(htb4);

        JLabel msg5  = createPanel(475,200,300,380);
        msg5.setText("<html>ПЭВМ с установленной СПО «Шепот-Интерфейс».\n" +
                " Подключение компьютера в данном случае необходимо," +
                " так как подключение микрофона к шумомеру осуществляется" +
                " через коммутатор, а тот, в свою очередь, управляется" +
                " при помощи программного обеспечения «Шепот-Интерфейс»," +
                " которое устанавливается на ЭВМ. После сбора схемы нужно" +
                " включить шумомер и коммутатор, то есть, рабочую укладку" +
                " системы «Шепот», а также запустить «Шепот-Интерфейс» \n</html>");
        JLabel htb5 = hitbox(209,412,475-209,557-412, msg5);
        firstSlide.add(msg5);
        firstSlide.add(htb5);
    }
    private void createSecondSlide(){
        secondSlide = createSlide("", "", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(450, 80, 390, 375);
        instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Вернувшись на экран главного меню, нужно нажать «Тест коммутатора». Таким образом," +
                " системой «Шепот» возможно управлять в ручном режиме. Для включения первого канала нужно нажать на " +
                "соответствующую кнопку меню, далее, чтобы включить источник ICP-питания измерительных датчиков, " +
                "необходимо также выбрать флаг «ICP-питание». </html>");
        secondSlide.add(instructions);

        JLabel instructions2 = new JLabel();
        instructions2.setBounds(21,435,1250-221,591-435);
        instructions2.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions2.setHorizontalTextPosition(JLabel.CENTER);
        instructions2.setForeground(textColor);
        instructions2.setHorizontalAlignment(JLabel.CENTER);
        instructions2.setText("<html> Если выбрать этот флаг, то при открытии окна «Тест коммутатора»" +
                " активируется полоса индикации времени задержки. Время ее заполнения" +
                " в дальнейшем используется для установления номинального режима электропитания измерительных датчиков.</html>");
        secondSlide.add(instructions2);

        JLabel instructions3 = new JLabel();
        instructions3.setBounds(23,384,417-23,464-384);
        instructions3.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions3.setHorizontalTextPosition(JLabel.CENTER);
        instructions3.setForeground(textColor);
        instructions3.setHorizontalAlignment(JLabel.CENTER);
        instructions3.setText("<html> Окно для введения поверочных данных</html>");
        secondSlide.add(instructions3);

        JLabel instructions4 = new JLabel();
        instructions4.setBounds(850,384,1251-850,468-384);
        instructions4.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions4.setHorizontalTextPosition(JLabel.CENTER);
        instructions4.setForeground(textColor);
        instructions4.setHorizontalAlignment(JLabel.CENTER);
        instructions4.setText("<html> Окно для тестирования коммутатора</html>");
        secondSlide.add(instructions4);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\DataInterface.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(20, 80, 400, 300);
        newimg = image.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        secondSlide.add(img);

        JLabel img2 = new JLabel();
        ImageIcon unit2 = new ImageIcon(".\\assets\\TestInterface.png");
        Image image2 = unit2.getImage();
        Image newimg2;
        img2.setBounds(850, 80, 400, 300);
        newimg2 = image2.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);
        unit2 = new ImageIcon(newimg2);
        img2.setVerticalAlignment(JLabel.TOP);
        img2.setIcon(unit2);
        secondSlide.add(img2);

    }
    private void createThirdSlide() {
        thirdSlide = createSlide("", "", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(20, 50, 390, 200);
        instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>1. На шумомере нужно нажать клавишу «TOOLS»," +
                " далее выбрать опцию «Calibration» и нажать на кнопку «CHECK», таким образом попав в меню калибровки.  </html>");
        thirdSlide.add(instructions);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\NoiseInterface1.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(420, 80, 300, 170);
        newimg = image.getScaledInstance(300, 170, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        thirdSlide.add(img);

        JLabel instructions2 = new JLabel();
        instructions2.setBounds(20, 270, 700, 150);
        instructions2.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions2.setHorizontalTextPosition(JLabel.CENTER);
        instructions2.setForeground(textColor);
        instructions2.setHorizontalAlignment(JLabel.CENTER);
        instructions2.setText("<html>2. Далее ввести в калибратор первый микрофон, перевести курсор на положение «94дБ» и" +
                " проверить уровень калибратора. Для изменения уровня калибровки курсор нужно перевести на опцию «CAL LEVEL»" +
                " и отредактировать значения в меню данной опции.</html>");
        thirdSlide.add(instructions2);

        JLabel img2 = new JLabel();
        ImageIcon unit2 = new ImageIcon(".\\assets\\NoiseInterface2.png");
        Image image2 = unit2.getImage();
        Image newimg2;
        img2.setBounds(720, 270, 300, 170);
        newimg2 = image2.getScaledInstance(300, 170, java.awt.Image.SCALE_SMOOTH);
        unit2 = new ImageIcon(newimg2);
        img2.setVerticalAlignment(JLabel.TOP);
        img2.setIcon(unit2);
        thirdSlide.add(img2);

        JLabel instructions3 = new JLabel();
        instructions3.setBounds(20, 440, 400, 150);
        instructions3.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions3.setHorizontalTextPosition(JLabel.CENTER);
        instructions3.setForeground(textColor);
        instructions3.setHorizontalAlignment(JLabel.CENTER);
        instructions3.setText("<html>3. Далее шумомер переводится в режим «CHECK», при включении калибратора на шумомере нужно нажать кнопку «OK». </html>");
        thirdSlide.add(instructions3);

        JLabel img3 = new JLabel();
        ImageIcon unit3 = new ImageIcon(".\\assets\\NoiseInterface3.png");
        Image image3 = unit3.getImage();
        Image newimg3;
        img3.setBounds(400, 420, 300, 170);
        newimg3 = image3.getScaledInstance(300, 170, java.awt.Image.SCALE_SMOOTH);
        unit3 = new ImageIcon(newimg3);
        img3.setVerticalAlignment(JLabel.TOP);
        img3.setIcon(unit3);
        thirdSlide.add(img3);

    }
    private void createFourthSlide(){
        founthLide = createSlide("", "", true, 70);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\NoiseInterface4.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(500, 80, 440, 250);
        newimg = image.getScaledInstance(300, 170, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        founthLide.add(img);

        JLabel instructions3 = new JLabel();
        instructions3.setBounds(20, 250, 1240, 200);
        instructions3.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions3.setHorizontalTextPosition(JLabel.CENTER);
        instructions3.setForeground(textColor);
        instructions3.setHorizontalAlignment(JLabel.CENTER);
        instructions3.setText("<html>Если все действия были проведены верно," +
                " то прибор должен показать уровень звука «94дБ» с возможной погрешностью" +
                " в ±0,3 дБ, если этого не происходит, необходимо вновь включить калибратор" +
                " и на шумомере изменить калибровку. Далее, после нажатия «ОК», прибор перейдет" +
                " в режим калибровки, который подразумевает проверку стабильности уровня сигнала," +
                " а затем автоматическую перенастройку для того чтобы измеряемое значение равнялось" +
                " введенному уровню в 94дБ. Во время калибровки на экране шумомера появится сообщение" +
                " «Wait», подразумевающее что процесс не должен быть прерван. </html>");
        founthLide.add(instructions3);

        JLabel instructions4 = new JLabel();
        instructions4.setBounds(20, 400, 740, 200);
        instructions4.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions4.setHorizontalTextPosition(JLabel.CENTER);
        instructions4.setForeground(textColor);
        instructions4.setHorizontalAlignment(JLabel.CENTER);
        instructions4.setText("<html>Второй микрофон не калибруется, но его проверка осуществляется схожим способом, погрешность второго микрофона не может превышать 1 дБ, акселерометр не калибруется вовсе.</html>");
        founthLide.add(instructions4);

        JButton btn = new JButton("<html>К началу раздела</html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 40));
        btn.setForeground(textColor);
        btn.setBounds(850, 470, 200, 100);
        btn.setBackground(btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crd.show(slideShow, "1");
            }
        });
        founthLide.add(btn);
    }
    private void createFifthSlide(){
        fifthSlide = createSlide(".\\assets\\Study2.png", "Раздел 2", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(800, 80, 450, 500);
        instructions.setFont(new Font("Calibri", Font.BOLD, 28));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Затем собирается схема системы «Шепот» следующим образом<br><br><br>" +
                "После сборки включаются генератор и устанавливается максимально возможный уровень" +
                " звукового давления тестового сигнала. </html>");
        fifthSlide.add(instructions);

        JLabel msg1 = createPanel(324,352,250,160);
        msg1.setText("<html>Средство измерения (шумомер) – используется для калибровки и" +
                "  последующих акустических и виброакустических измерений </html>");
        JLabel htb1 = hitbox(154,467,324-154,532-467, msg1);
        fifthSlide.add(msg1);
        fifthSlide.add(htb1);

        JLabel msg2  = createPanel(236,211,250,250);
        msg2.setText("<html>Микрофон «РСВ Piezotronics TMS130D20» - должен быть расположен на высоте 1,5 метров над" +
                " полом и на расстоянии метра от акустического излучателя. Между микрофоном и излучателем не" +
                " должно быть никаких лишних объектов </html>");
        JLabel htb2 = hitbox(105,162,236-105,211-162, msg2);
        fifthSlide.add(msg2);
        fifthSlide.add(htb2);

        JLabel msg3  = createPanel(300,300,250,250);
        msg3.setText("<html>ПЭВМ с настроенным СПО «Шепот-Интерфейс»- с помощью «Шепот-Интерфейс» пользователь" +
                " может настроить схему для калибровки, программа настраивается пользователем перед началом" +
                " всех последующих операций </html>");
        JLabel htb3 = hitbox(530,414,747-530,541-414, msg3);
        fifthSlide.add(msg3);
        fifthSlide.add(htb3);

        JLabel msg4  = createPanel(500,260,250,260);
        msg4.setText("<html>Генератор шума «Шорох-2МИ» - подает нужной частоты сигнал на акустический излучатель," +
                " который подключен к нему через разъем «ВЫХОД», сам генератор" +
                " подключен к коммутатору по разъему «УПРАВЛЕНИЕ» </html>");
        JLabel htb4 = hitbox(584,143,759-584,260-143, msg4);
        fifthSlide.add(msg4);
        fifthSlide.add(htb4);

        JLabel msg5  = createPanel(493,294,200,200);
        msg5.setText("<html>Акустический излучатель – звуковая колонка," +
                " способная передать шумовой тест-сигнал от генератора шума в пяти октавных полосах </html>");
        JLabel htb5 = hitbox(415,94,493-415,294-94, msg5);
        fifthSlide.add(msg5);
        fifthSlide.add(htb5);

        JLabel msg6  = createPanel(353,259,300,260);
        msg6.setText("<html>Рабочая укладка с управляемым коммутатором – калибруемый микрофон подключается" +
                " к первому каналу коммутатора, ПЭВМ подключается к коммутатору через USB-разъем," +
                " а генератор шума подключается соединительным кабелем к разъему «УПРАВЛЕНИЕ» </html>");
        JLabel htb6 = hitbox(114,358,353-114,559-358, msg6);
        fifthSlide.add(msg6);
        fifthSlide.add(htb6);
    }
    private void createSixthSlide(){
        slide6 = createSlide("", "", true, 70);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\NoiseInterface5.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(780, 80, 440, 230);
        newimg = image.getScaledInstance(440, 230, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        slide6.add(img);

        JLabel instructions3 = new JLabel();
        instructions3.setBounds(50, 80, 740, 270);
        instructions3.setFont(new Font("Calibri", Font.BOLD, 30));
        instructions3.setHorizontalTextPosition(JLabel.CENTER);
        instructions3.setForeground(textColor);
        instructions3.setHorizontalAlignment(JLabel.CENTER);
        instructions3.setText("<html>Для измерения уровня сигнала используется шумомер в режиме «SLM»," +
                " где измерение звукового давления проходит по пяти октавам и информация сохраняется вручную.\n" +
                "Для выбора режима «SLM», нужно на шумомере нажать кнопку «SETUP», и тогда появится следующее меню:\n</html>");
        slide6.add(instructions3);

        JLabel instructions4 = new JLabel();
        instructions4.setBounds(50, 350, 1240, 170);
        instructions4.setFont(new Font("Calibri", Font.BOLD, 30));
        instructions4.setHorizontalTextPosition(JLabel.CENTER);
        instructions4.setForeground(textColor);
        instructions4.setHorizontalAlignment(JLabel.CENTER);
        instructions4.setText("<html>Далее выбирается нужный режим и при нажатии кнопки «RUN/STOP»" +
                " шумомер начнет собирать данные, что будет видно на соответствующем графе, который" +
                " высветится на его экране.</html>");
        slide6.add(instructions4);


    }
    private void createSeventhSlide(){
        slide7 = createSlide("", "", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(50, 20, 1200, 570);
        instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>В программе «Шепот-Интерфейс», которая должна" +
                " быть установлена на соответствующую электронную вычислительную машину," +
                " нужно настроить определенные значения и условия для проведения измерений." +
                " Для этого необходимо:<br>1)\tНастроить значения отношений «сигнал/шум»." +
                " Для этого в программе нужно зайти в «Параметры» и далее в «Настройки уровней и" +
                " отчета». Для уровней A, B и C с центральными частотами 250, 500, 1000, 2000 и" +
                " 4000 Гц можно ввести собственные значения. Эти значения будут использованы " +
                "программой для обработки полученных от шумомера значений измерений. Если их" +
                " не настроить, то они будут равны нулю. <br>2)\tВ «Настройки отчета» следует " +
                "выбрать текстовый редактор для работы, ввести места проведения измерений, " +
                "иными словами, помещения и контрольные точки. В секции помещения будут несколько " +
                "вкладок требующих заполнения – ограждающие и инженерные конструкции, окна, двери и " +
                "параметры средств активной защиты (САЗ). Вся эта информация сохраняется в базе данных. " +
                "В помещения можно добавлять контрольные точки, но по умолчанию одна точка всегда в " +
                "помещении будет существовать по умолчанию. Начальные установки контрольной точки зависят " +
                "от уже вбитых значений в окне «Начальные установки» как условия по умолчанию.</html>");
        slide7.add(instructions);
//        JButton btn = new JButton("<html>К началу раздела</html>");
//        btn.setFocusable(false);
//        btn.setFont(new Font("Calibri", Font.BOLD, 40));
//        btn.setForeground(textColor);
//        btn.setBounds(850, 490, 200, 100);
//        btn.setBackground(btmTopBars);
//        btn.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                crd.show(slideShow, "5");
//            }
//        });
//        slide7.add(btn);
    }
    private void createEighthSlide(){
        slide8 = createSlide("", "", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(50, 20, 1200, 570);
        instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>3)\tВ «Параметры соединения с шумомером и контрольной точки» и в" +
                " «Начальные установки» заполнить сведения о шумомере – время измерения тест-сигнала," +
                " сигнала, фона и САЗ. В зависимости от выставленных флагов включаются только определенные" +
                " виды измерений при включении автоматического режима измерений. Время цикла измерений" +
                " зависит от внесенных значений, по умолчанию он будет равен 61 секунде." +
                "<br>4)\tВ секции «Тип измерений» задать установки проводимых измерений в зависимости" +
                " от типа исследуемого канала утечки информации и средства измерения. Есть всего" +
                " 4 окна установки временных параметров измерения: время измерения тест-сигнала," +
                " сигнала, фона и САЗ, и 2 типа измерений: акустика и виброакустика. Время измерений" +
                " тест-сигнала отвечает за продолжительность измерений уровня звукового давления шумомером," +
                " время измерений сигнала, фона и САЗ отвечают за продолжительность работы, расположенного на" +
                " расстоянии от источника акустического сигнала, микрофона при типе измерений «Акустика» или" +
                " акселерометра при типе измерений «Виброакустика» соответственно.</html>");
        slide8.add(instructions);
//        JButton btn = new JButton("<html>К началу раздела</html>");
//        btn.setFocusable(false);
//        btn.setFont(new Font("Calibri", Font.BOLD, 40));
//        btn.setForeground(textColor);
//        btn.setBounds(850, 490, 200, 100);
//        btn.setBackground(btmTopBars);
//        btn.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                crd.show(slideShow, "5");
//            }
//        });
//        slide8.add(btn);
    }
    private void createNinethSlide(){
        slide9 = createSlide("", "", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(50, 120, 1200, 370);
        instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>5)\tВ «Уровень нормирования» можно задать определенный уровень " +
                "нормирования для всех пяти октавных полос, например, 74 дБ для помещений без средств звукоусиления" +
                " и 84 дБ в другом случае. Для симуляции речи также рассчитаны типовые интегральные уровни речевых " +
                "сигналов, где 70 дБ будет соответствовать речи средней громкости. Для исследований можно использовать" +
                " распределение речевых сигналов в октавных полосах определенное в НМД АРР. Поле «Расчет интегральной" +
                " оценки» определяет, будет в дальнейшем использовано минимальное из измеренных значений или значение" +
                " равное полученным результатам измерений уровня фона. По НМД АРР" +
                " учитывается минимальное значение уровня фона.</html>");
        slide9.add(instructions);
        JButton btn = new JButton("<html>К началу раздела</html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 40));
        btn.setForeground(textColor);
        btn.setBounds(850, 490, 200, 100);
        btn.setBackground(btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crd.show(slideShow, "5");
            }
        });
        slide9.add(btn);
    }
    private void createSlide10(){
        slide10 = createSlide(".\\assets\\Study3.png", "Раздел 3", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(800, 80, 450, 500);
        instructions.setFont(new Font("Calibri", Font.BOLD, 23));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>После калибровки оборудования и настройки" +
                " программного обеспечения собирается следующая схема для проведения измерений<br>" +
                "Генератор шума передает тестовый сигнал через звуковую колонку, который принимает" +
                " первый микрофон, в это время второй микрофон не включен. Через коммутатор электрический" +
                " сигнал первого микрофона попадает в шумомер, который впоследствии измеряет его уровень," +
                " после чего полученные измерения записываются в базу данных электронной вычислительной" +
                " машины. После этого первый микрофон выключается и включается второй, который измеряет" +
                " тестовый сигнал и фон за ограждением. </html>");
        slide10.add(instructions);

        JLabel msg1 = createPanel(398,150,290,380);
        msg1.setText("<html>Микрофон «РСВ Piezotronics TMS130D20» - должен быть расположен на высоте 1,5" +
                " метров над полом и на расстоянии 0,5 метра от ограждающей конструкции. Между микрофоном" +
                " и ограждающей конструкцией не должно быть никаких лишних объектов. В начале работы" +
                " запускается лишь этот микрофон, улавливающий сигнал от излучателя" +
                " до его прохода сквозь ограждающую конструкцию</html>");
        JLabel htb1 = hitbox(282,148,398-282,236-148, msg1);
        slide10.add(msg1);
        slide10.add(htb1);

        JLabel msg2  = createPanel(198,150,380,380);
        msg2.setText("<html>2 Микрофон «РСВ Piezotronics TMS130D20»" +
                " - должен быть расположен на высоте 1,5 метров над полом и на расстоянии 0,5 метра от ограждающей" +
                " конструкции. Между микрофоном и ограждающей конструкцией не должно быть никаких лишних объектов." +
                " Если вместо второго микрофона используется акселерометр, то его крепят на ограждающую конструкцию" +
                " на высоте 1,5 м. Такая высота выбрана, чтобы имитировать гортань человека. В начале работы этот" +
                " микрофон/акселерометр остается выключенным и включается в ходе работы </html>");
        JLabel htb2 = hitbox(46,146,198-46,239-146, msg2);
        slide10.add(msg2);
        slide10.add(htb2);

        JLabel msg3  = createPanel(500,309,250,230);
        msg3.setText("<html>Акустический излучатель – звуковая колонка, способная передать шумовой тест-сигнал от" +
                " генератора шума в пяти октавных полосах, должен находиться" +
                " на расстоянии метра от ограждающей конструкции </html>");
        JLabel htb3 = hitbox(523,119,591-523,309-119, msg3);
        slide10.add(msg3);
        slide10.add(htb3);

        JLabel msg4  = createPanel(500,279,250,220);
        msg4.setText("<html>Генератор шума «Шорох-2МИ» - подает нужной частоты сигнал на акустический излучатель," +
                " который подключен к нему через разъем «ВЫХОД», генератор подключен" +
                " к коммутатору через разъем «УПРАВЛЕНИЕ»</html>");
        JLabel htb4 = hitbox(606,142,781-606,279-142, msg4);
        slide10.add(msg4);
        slide10.add(htb4);

        JLabel msg5  = createPanel(150,340,280,200);
        msg5.setText("<html>ПЭВМ с настроенным СПО «Шепот-Интерфейс»- с помощью «Шепот-Интерфейс» пользователь" +
                " может настроить схему для калибровки, программа настраивается" +
                " пользователем перед началом всех последующих операций</html>");
        JLabel htb5 = hitbox(470,422,680-470,540-422, msg5);
        slide10.add(msg5);
        slide10.add(htb5);

        JLabel msg6  = createPanel(331,368,250,160);
        msg6.setText("<html>Средство измерения (шумомер) – используется для акустических" +
                " и виброакустических измерений, подключен к коммутатору </html>");
        JLabel htb6 = hitbox(141,480,294-141,545-480, msg6);
        slide10.add(msg6);
        slide10.add(htb6);

        JLabel msg7  = createPanel(331,308,300,250);
        msg7.setText("<html>Рабочая укладка с управляемым коммутатором – для работы ПЭВМ подключается" +
                " к коммутатору через разъем «USB», генератор шумовых сигналов подключается по" +
                " разъему «УПРАВЛЕНИЕ», а первый и второй микрофон подключаются по первому и второму каналу соответственно</html>");
        JLabel htb7 = hitbox(105,380,331-105,568-380, msg7);
        slide10.add(msg7);
        slide10.add(htb7);
    }
    private void createSlide11(){
        slide11 = createSlide(".\\assets\\Study4.png", "", true, 70);
        JLabel msg1 = createPanel(398,150,290,220);
        msg1.setText("<html>Микрофон «РСВ Piezotronics TMS130D20» - должен быть расположен на высоте 1,5" +
                " метров над полом и на расстоянии 0,5 метра от ограждающей конструкции. Первый микрофон" +
                " включается в начале измерений и в дальнейшем отключается </html>");
        JLabel htb1 = hitbox(282,148,398-282,236-148, msg1);
        slide11.add(msg1);
        slide11.add(htb1);

        JLabel instructions = new JLabel();
        instructions.setBounds(800, 80, 450, 500);
        instructions.setFont(new Font("Calibri", Font.BOLD, 23));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>После этого первый микрофон выключается и включается второй, который измеряет" +
                " тестовый сигнал и фон за ограждением. </html>");
        slide11.add(instructions);

        JLabel msg2  = createPanel(198,150,420,380);
        msg2.setText("<html>Микрофон «РСВ Piezotronics TMS130D20» - должен быть расположен на высоте 1,5" +
                " метров над полом и на расстоянии 0,5 метра от ограждающей конструкции. Между микрофоном" +
                " и ограждающей конструкцией не должно быть никаких лишних объектов. Если вместо второго" +
                " микрофона используется акселерометр, то его крепят на ограждающую конструкцию на высоте" +
                " 1,5 м. Такая высота выбрана, чтобы имитировать гортань человека. Второй микрофон/акселерометр" +
                " включается для измерения звука от акустического излучателя, уже прошедшего через ограждающую" +
                " конструкцию, а также для измерения фона после окончания подачи сигнала</html>");
        JLabel htb2 = hitbox(46,146,198-46,239-146, msg2);
        slide11.add(msg2);
        slide11.add(htb2);

        JLabel msg3  = createPanel(400,309,300,280);
        msg3.setText("<html>Акустический излучатель – звуковая колонка, способная передать шумовой тест-сигнал" +
                " от генератора шума в пяти октавных полосах, должен находиться на расстоянии метра от ограждающей" +
                " конструкции, в определенный момент измерений перестает излучать сигнал, чтобы вторым микрофоном" +
                " возможно было измерить фон</html>");
        JLabel htb3 = hitbox(523,119,591-523,309-119, msg3);
        slide11.add(msg3);
        slide11.add(htb3);

        JLabel msg4  = createPanel(481,279,300,280);
        msg4.setText("<html>Генератор шума «Шорох-2МИ» - подает нужной частоты сигнал на акустический излучатель," +
                " который подключен к нему через разъем «ВЫХОД», генератор подключен к коммутатору через" +
                " разъем «УПРАВЛЕНИЕ», в определенный момент измерений передает передавать электрический" +
                " сигнал излучателю</html>");
        JLabel htb4 = hitbox(606,142,781-606,279-142, msg4);
        slide11.add(msg4);
        slide11.add(htb4);

//        JLabel msg5  = createPanel(680,340,280,200);
//        msg5.setText("<html>ПЭВМ с настроенным СПО «Шепот-Интерфейс»- с помощью «Шепот-Интерфейс» пользователь" +
//                " может настроить схему для калибровки, программа настраивается" +
//                " пользователем перед началом всех последующих операций</html>");
//        JLabel htb5 = hitbox(470,422,680-470,540-422, msg5);
//        slide11.add(msg5);
//        slide11.add(htb5);
//
//        JLabel msg6  = createPanel(331,368,250,160);
//        msg6.setText("<html>Средство измерения (шумомер) – используется для акустических" +
//                " и виброакустических измерений, подключен к коммутатору </html>");
//        JLabel htb6 = hitbox(141,480,294-141,545-480, msg6);
//        slide11.add(msg6);
//        slide11.add(htb6);
//
//        JLabel msg7  = createPanel(331,308,300,250);
//        msg7.setText("<html>Рабочая укладка с управляемым коммутатором – для работы ПЭВМ подключается" +
//                " к коммутатору через разъем «USB», генератор шумовых сигналов подключается по" +
//                " разъему «УПРАВЛЕНИЕ», а первый и второй микрофон подключаются по первому и второму каналу соответственно</html>");
//        JLabel htb7 = hitbox(105,380,331-105,568-380, msg7);
//        slide11.add(msg7);
//        slide11.add(htb7);
    }
    private void createSlide12(){
        slide12 = createSlide("", "", true, 70);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Study5.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(80, 80, 600, 400);
        newimg = image.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        slide12.add(img);

        JLabel instructions = new JLabel();
        instructions.setBounds(720, 80, 530, 500);
        instructions.setFont(new Font("Calibri", Font.BOLD, 19));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Все полученные данные записываются в базу данных программы" +
                " «Шепот-Интерфейс» и могут быть показаны в табличном виде и в виде графов.<br>" +
                " При запуске программы автоматически запускается база данных «Acst.mdb», но подключенную" +
                " базу можно сменить в поле «Файл с БД». Кнопка «Выполнить» отвечает за начало процедуры измерений" +
                " с установленными параметрами, она находится во вкладке «Выполнить измерения». Чтобы посмотреть" +
                " результаты нужно зайти во вкладку «Результаты измерений». Если необходимо пересчитать с новыми" +
                " введенными данными в октавных полосах, необходимо нажать «Пересчитать», чтобы новые результаты " +
                "были сохранены в базе данных то необходимо также нажать «Изменить в БД». «Отчет по объектам» при" +
                " нажатии начинает формирование протокола с результатами измерений, этот протокол можно изменять" +
                " и сохранить под другим именем. Отчет откроется в окне текстового редактора выбранного ранее в" +
                " «Выбор отчета» и выбор шаблона в «Вид таблицы»</html>");
        slide12.add(instructions);

        JLabel instructions2 = new JLabel();
        instructions2.setBounds(80, 480, 600, 70);
        instructions2.setFont(new Font("Calibri", Font.BOLD, 23));
        instructions2.setHorizontalTextPosition(JLabel.CENTER);
        instructions2.setForeground(textColor);
        instructions2.setHorizontalAlignment(JLabel.CENTER);
        instructions2.setText("<html>«Табличный вид результатов измерений»</html>");
        slide12.add(instructions2);

    }
    private void createSlide13(){
        slide13 = createSlide("", "", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(50, 20, 1200, 570);
        instructions.setFont(new Font("Calibri", Font.BOLD, 25));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Если же необходимо измерить систему отопления или трубы на выявление" +
                " акустических каналов утечки информации, то акселерометр крепится на расстоянии 10-15" +
                " см от места выхода трубы из помещения. <br>" +
                "Если нужно проводить измерения окон для тех же целей, то вместо акселерометра используется второй " +
                "микрофон с ветрозащитной накладкой, из-за которой, соответственно, к нему подключаются передатчик и" +
                " приемник, последний в свою очередь соединяется с коммутатором по второму входу. Из-за того что на" +
                " стекле резонансные частоты зависят от выбора точки измерения, для перепроверки на возможную" +
                " погрешность иногда проверяют верхнюю и нижнюю часть стекла, или же выбирают контрольные точки" +
                " на расстоянии 0,5 метром друг от друга. Для этого используются микрофон на расстоянии 0,5 от" +
                " стекла и акселерометр, прикрепленный на той же высоте к стеклу. Обычно проверяется внутренняя" +
                " часть окна, так как с данной стороны соотношение сигнал/шум всегда выше чем с внешней.\n</html>");
        slide13.add(instructions);

        JButton btn = new JButton("<html>К началу раздела</html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 40));
        btn.setForeground(textColor);
        btn.setBounds(850, 490, 200, 100);
        btn.setBackground(btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crd.show(slideShow, "10");
            }
        });
        slide13.add(btn);
    }
}
