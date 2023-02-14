import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReviewFrame extends JPanel {
    // --------------COLORS-----------
    Color lightBlueBtn = new Color(103, 82, 128);
    Color background = new Color(237, 239, 246);
    Color textColor = new Color(0x6e67a0);
    Color btmTopBars = new Color(193, 197, 220);
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel firstSlide, secondSlide, thirdSlide, founthLide;
    //fifthSlide, sixthSlide, seventhSlide, eighthSlide, ninethSlide, lastSlide;

    ReviewFrame(ActionListener onReturn) {
        crd = new CardLayout();
        createReview();
        createFirstSlide();
        createSecondSlide();
        createThirdSlide();
        createFourthSlide();
//        createFifthSlide();
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
//        slideShow.add("5", fifthSlide);
//        slideShow.add("6", sixthSlide);
//        slideShow.add("7", seventhSlide);
//        slideShow.add("8", eighthSlide);
//        slideShow.add("9", ninethSlide);
//        slideShow.add("10", lastSlide);
        crd.show(slideShow, "1");

        returnToMenu.addActionListener(onReturn);
    }

    private JPanel createRewSlide(Color color) {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(color);
        slide.setBounds(0, 0, 1280, 605);
        return slide;
    }

    private void createReview() {
        this.setLayout(null);
        slideShow = createRewSlide(Color.BLACK);
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

    private JLabel createPanel(int x, int y, int height){
        JLabel pnl = new JLabel();
        pnl.setBounds(x, y, 250, height);
        pnl.setFont(new Font("Calibri", Font.BOLD, 18));
        pnl.setBackground(background);
        pnl.setForeground(textColor);
        pnl.setHorizontalAlignment(JLabel.LEFT);
        pnl.setOpaque(true);
        pnl.setBorder(BorderFactory.createLineBorder(lightBlueBtn, 5));
        pnl.setVisible(false);
        return pnl;
    }
    private void createFirstSlide() {
        firstSlide = createSlide(".\\assets\\sprut-6ma.png", "Спрут-6МА", true, 70);
        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(585, 75, 600, 550);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 23));
        generalInfo.setHorizontalTextPosition(JLabel.CENTER);
        generalInfo.setForeground(textColor);
        generalInfo.setHorizontalAlignment(JLabel.LEFT);
        generalInfo.setText("<html>Программно-аппаратный комплекс для проверки выполнения норм эффективности" +
                " защиты речевой информации от утечки по акустическому, виброакустическому каналам, а также за" +
                " счет низкочастотных наводок на токопроводящих элементах ограждающих конструкций и линиях ТСПИ" +
                " за счет побочных электромагнитных излучений от технических средств в речевом диапазоне. Позволяет" +
                " проводить измерение звуко- и виброизоляционных измерений конструкций исследования характеристик" +
                " и проверку эффективности систем акустического и виброакустического зашумления; измерения уровней" +
                " электрического и магнитного полей и наводок на проводные коммуникации; измерения характеристик" +
                " акустических и виброакустических сигналов анализ и так далее.</center></html>");
        firstSlide.add(generalInfo);

        JLabel sprutBaa1 = createPanel(200, 100, 270);
        sprutBaa1.setText("<html>Виброакустический анализатор «СПРУТ-ВАА-1» (одноканальный шумомер – анализатор спектра – виброметр)" +
                " предназначен для эстетической визуализации аудиосигнала, замеров спектра шумовых сигналов и общего" +
                " анализа шумового, вибрационного и электрического полей.</html>");
        firstSlide.add(sprutBaa1);

        JLabel acustic = createPanel(150, 115, 450);
        acustic.setText("<html>Активная акустическая система со встроенным усилителем в экранированном контейнере АС-9" +
                " является двух полосной АС с фазоинвертором. Ее диапазон воспроизводимых частот 63-18000 Гц," +
                " чувствительность 85 дБ, сопротивление 4 Ом, а номинальная и максимальная мощность 10 и 25" +
                " Вт соответственно. Для АС в комплексе предполагается аудио кабель Jack 3,5 мм – Jack 3,5" +
                " мм и переходник Jack 3,5 мм – Jack 6,3 мм.</html>");
        firstSlide.add(acustic);

        JLabel laptop = createPanel(200, 80, 200);
        laptop.setText("<html>ПЭВМ, специализированно разработанная для дальнейшей" +
                " работы на ней с соответствующей СПО для проведения измерений." +
                " В комплект «Спрут-6М» для этого входит СПО «Спрут»</html>");
        firstSlide.add(laptop);

        JLabel disc =createPanel(200, 200, 340);
        disc.setText("<html>Носитель информации на диске типа Flash с СПО «Спрут» - СПО," +
                " предназначенное для управления измерительным модулем и модулем источника" +
                " тестового акустического сигнала, проведения измерений и получениях их" +
                " результатов, их редактирования и сохранения для дальнейшего создания отчетов.</html>");
        firstSlide.add(disc);

        JLabel acdc = createPanel(150, 200, 350);
        acdc.setText("<html>Внешний аккумулятор модуля радиоканала «SDA», предназначен для" +
                " электропитания проверяемых устройств постоянным напряжением. Подключение" +
                " ПЭВМ к блоку питания происходит через сетевой кабель. В составе «Спрут-6М»" +
                " также есть соединительный и интерфейсный кабели для высокоскоростной передачи" +
                " информации и кабель питания от сети 220 Вт.</html>");
        firstSlide.add(acdc);

        JLabel sprut = createPanel(180, 160, 430);
        sprut.setText("<html>Блок измерительный «Спрут» Измеритель шума и вибраций 1-го класса точности, предназначен" +
                " для сопряжения внешних источников маломощных электрических низкочастотных" +
                " сигналов со встроенными в него устройствами аналогово-цифрового преобразования," +
                " проведения измерений, цифровой обработки полученных результатов измерений," +
                " их отображения и передачи полученных результатов в управляющую ПЭВМ.</html>");
        firstSlide.add(sprut);

        JLabel s8w = createPanel(200, 300, 280);
        s8w.setText("<html>Устройство сопряжения с измерительным модулем «S8W» " +
                "Совместно с модулем сопряжения c ПК обеспечивают передачу данных между" +
                " измерительным модулем и ПЭВМ и с помощью соединительного кабеля — адаптера SV-55," +
                " подключается к разъему USB-Host измерительного модуля.</html>");
        firstSlide.add(s8w);

        JLabel part1 = new JLabel();
        part1.setBounds(100, 380, 100, 100);
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
                //partName.setText("<html>Носитель информации на диске типа Flash с СПО \"CПРУТ\"</html>");
                disc.setVisible(true);
                disc.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                disc.setVisible(false);
            }
        });
        firstSlide.add(part1);

        JLabel part2 = new JLabel();
        part2.setBounds(200, 285, 200, 540 - 288);
        part2.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>ПЭВМ типа ноутбук</html>");
                laptop.setVisible(true);
                laptop.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                laptop.setVisible(false);
            }
        });
        firstSlide.add(part2);

        JLabel part3 = new JLabel();
        part3.setBounds(120, 485, 55, 50);
        part3.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Устройство сопряжения с измерительным модулем \"S8W\"</html>");
                s8w.setVisible(true);
                s8w.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                s8w.setVisible(false);
            }
        });
        firstSlide.add(part3);

        JLabel part4 = new JLabel();
        part4.setBounds(58, 77, 130, 300);
        part4.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Вибро-акустический анализатор \"СПРУТ-ВАА-1\"<br>" +"(одноканальный шумомер - анализатор спектра - виброметр)</html>");
                sprutBaa1.setVisible(true);
                sprutBaa1.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sprutBaa1.setVisible(false);
            }
        });
        firstSlide.add(part4);

        JLabel part5 = new JLabel();
        part5.setBounds(410, 250, 127, 210);
        part5.addMouseListener(new MouseListener() {
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
                acustic.setVisible(true);
                acustic.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                acustic.setVisible(false);
            }
        });
        firstSlide.add(part5);

        JLabel part6 = new JLabel();
        part6.setBounds(402, 460, 58, 67);
        part6.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Блок питания для ПЭВМ с сетевым кабелем</html>");
                acdc.setVisible(true);
                acdc.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                acdc.setVisible(false);
            }
        });
        firstSlide.add(part6);

        JLabel part7 = new JLabel();
        part7.setBounds(477, 471, 100, 100);
        part7.addMouseListener(new MouseListener() {
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
                sprut.setVisible(true);
                sprut.updateUI();

                //partName.setText("<html>Блок измерительный \"Спрут\"</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sprut.setVisible(false);
            }
        });
        firstSlide.add(part7);
    }

    private void createSecondSlide() {
        secondSlide = createSlide("", "Спрут-7A", true, 70);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Sprut-7A.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(75, 75, 700, 500);
        newimg = image.getScaledInstance(700, 500, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        secondSlide.setLayout(null);
        secondSlide.add(img);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(775, 75, 420, 500);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 20));
        generalInfo.setHorizontalTextPosition(JLabel.CENTER);
        generalInfo.setForeground(textColor);
        generalInfo.setHorizontalAlignment(JLabel.LEFT);
        generalInfo.setText("<html>Программно-аппаратный комплекс для проверки выполнения норм" +
                " эффективности защиты речевой информации от её утечки по акустическому и виброакустическому" +
                " каналам, а также за счет низкочастотных наводок на токопроводящие элементы ограждающих" +
                " конструкций зданий и сооружений и наводок от технических средств в речевом диапазон" +
                "е частот, образованных за счет акусто-электрических преобразований. Управление комплексом" +
                " осуществляется по радиоканалу. Комплекс использует измерительную подсистему на базе анализатора" +
                " шума и вибраций 1-го класса точности SVAN-947 с двумя антеннами типа АИ 4-1 и АИР 3-1, а" +
                " измерения происходят с использованием функции быстрого преобразования Фурье (БПФ).</html>");
        secondSlide.add(generalInfo);

        JLabel sprut7a = createPanel(170, 80, 520);
        sprut7a.setBounds(170, 80, 350, 420);
        sprut7a.setText("<html>Измерительный модуль с октавным анализом, третьоктавным анализом и функцией" +
                " БЭПФ «Спрут-7А». Вместе с измерительным модулем в комплекте идет штатив для его установки." +
                " Измерительный модуль обеспечивает формирование питающих напряжений и токов, усиление маломощных" +
                " электрических сигналов от датчиков, аналогово-цифровое преобразование и измерение, предварительную" +
                " цифровую обработку и отображение результатов на собственном дисплее, их передачу в управляющую ПЭВМ" +
                " в цифровом виде и проверку значений напряжения встроенного источника электропитания и индикацию его состояния.</html>");
        secondSlide.add(sprut7a);

        JLabel acustic = createPanel(350, 100, 400);
        acustic.setText("<html>Экранированная акустическая система, используемая при проведении измерений акустоэлектрических" +
                " преобразований, в «Спрут-7А» модулем источника акустического сигнала является ультракомпактный ноутбук." +
                " Также в составе даны соединительный кабель для подключения модуля источника тестового акустического" +
                " сигнала к акустической системе и стойка для установки акустической системы.</html>");
        secondSlide.add(acustic);

        JLabel laptop = createPanel(50, 100, 300);
        laptop.setText("<html>ПЭВМ, специализированно разработанная для дальнейшей работы на ней с соответствующей" +
                " СПО для проведения измерений и управления комплексом. В комплекте также прилагается CD-диск со" +
                " специальным программным обеспечением программно-аппаратного комплекса «Спрут-7А»</html>");
        secondSlide.add(laptop);

        JLabel emco = createPanel(300, 100, 500);
        emco.setText("<html>Антенна с рабочим диапазоном частот 0,2-5000 кГц, разработана для измерения напряженности" +
                " магнитной составляющей синусоидальных, шумовых и импульсных радиопомех в лабораторных помещениях," +
                " экранированных камерах и на открытых площадках в комплекте с измерительными приемниками, анализаторами " +
                "спектра, селективными микровольтметрами любого типа в задачах обеспечения электромагнитной совместимости" +
                " радиоэлектронных средств, защиты информации.</html>");
        secondSlide.add(emco);

        JLabel acdc = createPanel(300, 200, 300);
        acdc.setText("<html>Источник автономного питания предназначен для электропитания проверяемых устройств постоянным" +
                " напряжением 12, 24, 36, 48 или 60 вольт и током до 200 мА, а также для обеспечения заряда встроенных в" +
                " источник питания собственных аккумуляторов.</html>");
        secondSlide.add(acdc);

        JLabel sza = createPanel(1,1,1);
        sza.setBounds(270, 150, 350, 450);
        sza.setText("<html>Измерительный усилитель № 1 «SZA 1-01» и измерительный усилитель № 2 «SZA2-01» с режекторным фильтром " +
                "Измерительные усилители предназначены для подключения к измерительному\n" +
                "модулю различных источников низковольтных сигналов, в том числе измерительных\n" +
                "антенн, пробников, осциллографических щупов, токосъемников и т.п. Подключаются" +
                " усилители к измерительному модулю с помощью кабеля. Электропитание усилителей" +
                " осуществляется от встроенных аккумуляторов. Зарядка встроенных аккумуляторов" +
                " производится от входящего в комплект зарядного устройства. Также в комплекс" +
                " входит комплект щупов, тройник BNC и заглушка 50 Ом для усилителя.\n</html>");
        secondSlide.add(sza);

        JLabel s8w = createPanel(250, 200, 360);
        s8w.setText("<html>Устройство сопряжения с измерительным модулем «SZPCC-04» с антенной представляет собой внешний" +
                " радиомодем и совместно с модулем сопряжения c ПК обеспечивают передачу данных между измерительным" +
                " модулем и ПЭВМ. Подключается помощью соединительного кабеля - адаптера SV-55 к разъему USB-Host измерительного модуля.</html>");
        secondSlide.add(s8w);

        JLabel micro = createPanel(250,200, 330);
        micro.setText("<html>Измерительный микрофон - Микрофон является датчиком, предназначенным для измерения уровней акустических сигналов. Он подключается к" +
                " измерительному модулю при помощи специального кабеля. В комплект измерительного микрофона " +
                "входят микрофон «SV22» и микрофонный предусилитель «SV12L».</html>");
        secondSlide.add(micro);

        JLabel axel = createPanel(1,1,1);
        axel.setBounds(250, 250, 380, 350);
        axel.setText("<html>Измерительный акселерометр «АР-98-100-01»\n" +
                "Вибропреобразователь предназначен для преобразования механических колебаний контролируемого объекта в электрический сигнал, пропорциональный вибрационному" +
                " или ударному ускорению механической системы. Принцип его действия основан на генерации электрического сигнала, пропорционального воздействующему ускорению." +
                " Вместе с ним в комплекте поставляется кабель «АК 15» для подключения акселерометра к измерительному модулю и комплект крепежных изделий к измерительному акселерометру.</html>");
        secondSlide.add(axel);

        JLabel part1 = new JLabel();
        part1.setBounds(85,122,152-85,443-122);
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
                //partName.setText("<html>Акустическая система</html>");
                sprut7a.setVisible(true);
                sprut7a.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sprut7a.setVisible(false);
            }
        });
        secondSlide.add(part1);

        JLabel part2 = new JLabel();
        part2.setBounds(152,135,325-152,365-135);
        part2.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Модуль источника тестового акустического сигнала</html>");
                acustic.setVisible(true);
                acustic.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                acustic.setVisible(false);
            }
        });
        secondSlide.add(part2);

        JLabel part3 = new JLabel();
        part3.setBounds(332,168,543-332,433-168);
        part3.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Модуль сопряжения с ПК</html>");
                laptop.setVisible(true);
                laptop.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                laptop.setVisible(false);
            }
        });
        secondSlide.add(part3);

        JLabel part4 = new JLabel();
        part4.setBounds(597,147,754-597,313-147);
        part4.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>ПЭВМ типа ноутбук</html>");
                emco.setVisible(true);
                emco.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                emco.setVisible(false);
            }
        });
        secondSlide.add(part4);

        JLabel part5 = new JLabel();
        part5.setBounds(594,309,727-594,410-309);
        part5.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Устройство сопряжения с измерительным модулем</html>");
                acdc.setVisible(true);
                acdc.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                acdc.setVisible(false);
            }
        });
        secondSlide.add(part5);

        JLabel part6 = new JLabel();
        part6.setBounds(639,410,725-639,483-410);
        part6.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Измерительный модуль с октавным анализом, третьоктавным анализом и функцией БПФ</html>");
                sza.setVisible(true);
                sza.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sza.setVisible(false);
            }
        });
        secondSlide.add(part6);

        JLabel part7 = new JLabel();
        part7.setBounds(543,426,611-543,482-426);
        part7.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Модуль сопряжения с ПК</html>");
                s8w.setVisible(true);
                s8w.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                s8w.setVisible(false);
            }
        });
        secondSlide.add(part7);

        JLabel part8 = new JLabel();
        part8.setBounds(581,487,657-581,539-487);
        part8.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Зарядное устройство</html>");
                micro.setVisible(true);
                micro.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                micro.setVisible(false);
            }
        });
        secondSlide.add(part8);

        JLabel part9 = new JLabel();
        part9.setBounds(663,496,696-663,542-496);
        part9.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Зарядное устройство</html>");
                axel.setVisible(true);
                axel.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                axel.setVisible(false);
            }
        });
        secondSlide.add(part9);
    }

    private void createThirdSlide() {
        thirdSlide = createSlide("", "Комплекс акустического и виброакустического контроля \"Колибри\"", true, 40);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Calibri.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(-40, 80, 820, 500);
        newimg = image.getScaledInstance(820, 500, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        thirdSlide.add(img);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(775, 75, 400, 500);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 25));
        generalInfo.setHorizontalTextPosition(JLabel.CENTER);
        generalInfo.setForeground(textColor);
        generalInfo.setHorizontalAlignment(JLabel.LEFT);
        generalInfo.setText("<html>Программно-аппаратный комплекс для оценки эффективности" +
                " защиты речевой информации по виброакустическим каналам, параметров акустических," +
                " вибрационных и маломощных электрических сигналов и акустических свойств помещений." +
                " При решении задач по оценке эффективности защиты речевой информации комплекс позволяет" +
                " проводить детальное исследование акустических и виброакустических каналов утечки" +
                " речевой информации.</html>");
        thirdSlide.add(generalInfo);

        JLabel tk16m = createPanel(180, 100, 400);
        tk16m.setBounds(180, 100, 300, 350);
        tk16m.setText("<html>Измерительный токосъемник ТК-16М\n" +
                "Предназначен для измерения силы тока радиопомех в сетях электропитания, линиях связи, управления и передачи" +
                " данных без разрыва электрических цепей в сочетании с измерительными приемниками и анализаторами спектра." +
                " ТК-16М является изделием неремонтируемым и соответствует по условиям эксплуатации группе 3 ГОСТ 22261-82." +
                " В комплекте «Колибри» токосъемник поставляется с кабелем.\n</html>");
        thirdSlide.add(tk16m);

        JLabel calibiIy = createPanel(20, 100, 250);
        calibiIy.setText("<html>Исполнительное устройство «Колибри-ИУ»\n" +
                "Устройство контролируется дистанционно при помощи пульта ДУ2." +
                " Применяется для измерений уровней фона, акустических и виброакустических сигналов средств активной защиты.\n</html>");
        thirdSlide.add(calibiIy);

        JLabel at2 = createPanel(420, 80, 1);
        at2.setSize(350, 490);
        at2.setText("<html>Источник тестового акустического сигнала «АТ2»\n" +
                "Генератор тестовых акустических сигналов «АТ2» предназначен для формирования тестового акустического сигнала типа" +
                " «белый шум» высокого качества, а также излучения акустического сигнала, формируемого внешним источником." +
                " Вместе с генератором поставляется экранирующий короб «Матрешка», созданный для обеспечения повышенных" +
                " экранирующих свойств генератора по электрической и магнитной составляющей электромагнитного поля, пульт" +
                " дистанционного управления «АТ2» и тренога с переходником для крепления генератора.\n</html>");
        thirdSlide.add(at2);

        JLabel mdu1 = createPanel(30, 100,1);
        mdu1.setSize(350, 490);
        mdu1.setText("<html>Пульт дистанционного управления и брелок\n" +
                "«Колибри-МДУ1» и брелок – пульт управления ДУ, предназначены для дистанционного управления анализатором посредством" +
                " приема их команд внешней антенной, которая подключается к нему заранее через разъем «Антенна». Модуль дистанционного" +
                " управления «Колибри-МДУ1» подключается к анализатору и работает под его управлением в автоматическом режиме – в" +
                " зависимости от измеряемого параметра осуществляет включение/выключение дистанционно управляемого генератора шума «КОЛИБРИ-АТ1»." +
                "В ручном режиме включение/выключение генератора осуществляется с помощью брелока.\n</html>");
        thirdSlide.add(mdu1);

        JLabel micro = createPanel(100, 100, 480);
        micro.setText("<html>Измерительный микрофон «MP201» с предусилителем «P410» \n" +
                "Микрофон является преполяризованным микрофоном свободного поля. Номинальная чувствительность микрофона – 50 мВ/Па," +
                " частотный диапазон 6,3 – 20000 Гц, а максимально измеряемый уровень звукового давления 146 дБ. Часто используется" +
                " для измерений шумомерами класса 1. Микрофон вместе с предусилитель подключается к анализатору." +
                " В состав также входит штатив с держателем для микрофона.\n</html>");
        thirdSlide.add(micro);

        JLabel skm8 = createPanel(180, 100, 400);
        skm8.setText("<html>Многоканальный анализатор-концентратор сигналов «СКМ-8»\n" +
                "Предназначен для проведения измерений параметров вероятных технических каналов утечки информации, а также расчёта показателей" +
                " оценки эффективности защиты речевой информации. Изделие может применяться совместно с ПЭВМ для формирования отчетов" +
                " и повышения качественного уровня визуализации информации.\n</html>");
        thirdSlide.add(skm8);

        JLabel disc = createPanel(200, 100, 1);
        disc.setSize(400, 500);
        disc.setText("<html>Компакт-диск (Flash-накопитель) с программным обеспечением «СКМ-8 ПО» и «Колибри ПО»\n" +
                "«СКМ-8 ПО» устанавливается в ПЭВМ на базе операционной системы «MS Windows-XP» («Vista»)." +
                "Формируемые в задачах выходные отчеты представляются в формате *.rtf или *.db8. Для работы с ПЭВМ комплекс «Колибри»" +
                " должен быть подключен к свободному разъему USB порта ПЭВМ с использованием кабеля.\n" +
                "«Колибри ПО» расширяет функциональные возможности комплекса «Колибри», что обеспечивает проведение спектрального" +
                " (узкополосного) анализа в полосе до 1,5 Гц любым из измерительных каналов комплекса, проведение оценки эффективности" +
                " защиты речевой информации от утечки за счет АЭП в элементах ВТСС для различных типов линий ВТСС, измерение уровней" +
                " акустического теста, фона, сигнала и фона.\n</html>");
        thirdSlide.add(disc);

        JLabel ar2098 = createPanel(400, 90, 510);
        ar2098.setText("<html>Измерительный акселерометр АР2098 -100\n" +
                "Вибропреобразователь предназначен для преобразования механических колебаний контролируемого объекта в электрический сигнал," +
                " пропорциональный вибрационному или ударному ускорению механической системы. Принцип его действия основан на генерации" +
                " электрического сигнала, пропорционального воздействующему ускорению. Вместе с ним в комплекте поставляется кабель для подключения акселерометра к анализатору.\n</html>");
        thirdSlide.add(ar2098);

        JLabel part1 = new JLabel();
        part1.setBounds(5,203,159-5,376-203);
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
                //partName.setText("<html>Источник тестового акустического сигнала\"Колибри2\"</html>");
                tk16m.setVisible(true);
                tk16m.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                tk16m.setVisible(false);
            }
        });
        thirdSlide.add(part1);

        JLabel part2 = new JLabel();
        part2.setBounds(60,383,212-60,533-383);
        part2.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Компакт-диск (Flash-накопитель) с програмным обеспечинием</html>");
                calibiIy.setVisible(true);
                calibiIy.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                calibiIy.setVisible(false);
            }
        });
        thirdSlide.add(part2);

        JLabel part3 = new JLabel();
        part3.setBounds(161,121 ,413-161,493-121);
        part3.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Многоканальный анализатор-концентратор сигналов \"СКМ-8\"</html>");
                at2.setVisible(true);
                at2.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                at2.setVisible(false);
            }
        });
        thirdSlide.add(part3);

        JLabel part4 = new JLabel();
        part4.setBounds(374,337,533-374,408-337);
        part4.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Измерительный микрофон \"МР201\" с предусилителем \"Р410\"</html>");
                mdu1.setVisible(true);
                mdu1.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mdu1.setVisible(false);
            }
        });
        thirdSlide.add(part4);

        JLabel part5 = new JLabel();
        part5.setBounds(356,406 ,678-356,469-406);
        part5.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Пульт дистанционного управления</html>");
                micro.setVisible(true);
                micro.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                micro.setVisible(false);
            }
        });
        thirdSlide.add(part5);

        JLabel part6 = new JLabel();
        part6.setBounds(436,121, 618-436,403-121);
        part6.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Пульт дистанционного управления</html>");
                skm8.setVisible(true);
                skm8.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                skm8.setVisible(false);
            }
        });
        thirdSlide.add(part6);

        JLabel part7 = new JLabel();
        part7.setBounds(620,228,698-620,431-228);
        part7.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Пульт дистанционного управления</html>");
                disc.setVisible(true);
                disc.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                disc.setVisible(false);
            }
        });
        thirdSlide.add(part7);

        JLabel part8 = new JLabel();
        part8.setBounds(684,395,730-684,497-395);
        part8.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Пульт дистанционного управления</html>");
                ar2098.setVisible(true);
                ar2098.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ar2098.setVisible(false);
            }
        });
        thirdSlide.add(part8);
    }

    private void createFourthSlide() {
        founthLide = createSlide(".\\assets\\Shepot-T.png", "<html>Система оценки защищенности выделенных помещений по виброакустическому каналу \"ШЕПОТ-Т\"</html>", true, 28);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(650, 75, 550, 500);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 25));
        generalInfo.setHorizontalTextPosition(JLabel.CENTER);
        generalInfo.setForeground(textColor);
        generalInfo.setHorizontalAlignment(JLabel.LEFT);
        generalInfo.setText("<html>Программно-аппаратный комплекс для проведения специальных акустических и" +
                " вибрационных измерений в выделенных помещениях с целью оценки их защищенности от утечки" +
                " речевой информации по виброакустическому каналу. Система «Шепот-T» обеспечивает автоматические" +
                " измерения уровней звукового давления тестового сигнала и наведенного им виброускорений," +
                " расчет показателей защищенности выделенных помещений от утечки информации по виброакустическому" +
                " каналу и облегчение настройки системы защиты выделенных помещений объекта от утечки речевой" +
                " информации по данному каналу.\n</html>");
        founthLide.add(generalInfo);

        JLabel micro= createPanel(1,1,1);
        micro.setBounds(300,80,350,400);
        micro.setText("<html>Измерительный микрофон\n" +
                "Микрофон ICP типа от компании PCB Piezotronics, состоит из чувствительного элемента, выполненного из пьезоэлектрического материала," +
                " который преобразует механическую нагрузку в электрический сигнал, а также из микросхемы, используемой для усиления сигнала и его передачи" +
                " на внешние устройства. Используемый предусилитель определяет скорость утечки генерируемого пьезоэлементами акселерометра электрического" +
                " сигнала. Вместе с микрофоном в комплекте идут предусилитель, ветрозащитный экран и штатив с держателем для микрофона.\n</html>");
        founthLide.add(micro);

        JLabel LD824 = createPanel(1,1,1);
        LD824.setBounds(160,100,300,350);
        LD824.setText("<html>Измерительный блок «LarsonDavis 824»\n" +
                "Модель включает в себя функции интегрирующего шумомера-анализатора спектра и шумомера-регистратора. В режиме шумомер-анализатор прибор " +
                "одновременно измеряет общие и корректированные уровни звука (А, С, Лин - Быстро, Медленно, Импульс), эквивалентные, максимальные и минимальные " +
                "уровни звука и уровни звукового давления в октавных или третьоктавных полосах частот в звуковом диапазоне.\n</html>");
        founthLide.add(LD824);

        JLabel shelest = createPanel(1,1,1);
        shelest.setBounds(200,250,230,280);
        shelest.setText("<html>Колонка акустическая активная «Шелест-М3»\n" +
                "Экранированная акустическая система, используемая при проведении измерений акустоэлектрических преобразований." +
                " В комплекте также идет штатив и стойка для установки колонки. \n</html>");
        founthLide.add(shelest);

        JLabel laptop = createPanel(1,1,1);
        laptop.setBounds(30,280,230,300);
        laptop.setText("<html>ПЭВМ типа ноутбук\n" +
                "ПЭВМ, специализированно разработанная для дальнейшей работы с соответствующей СПО для проведения измерений. К ней подключается измерительный микрофон/акселерометр и генератор шума.\n</html>");
        founthLide.add(laptop);

        JLabel B352 = createPanel(1,1,1);
        B352.setBounds(300,250,330,280);
        B352.setText("<html>Измерительный акселерометр «352B»\n" +
                "Вибропреобразователь предназначен для преобразования механических колебаний контролируемого объекта в" +
                " электрический сигнал, пропорциональный вибрационному или ударному ускорению механической системы." +
                " Принцип его действия основан на генерации электрического сигнала, пропорционального воздействующему ускорению. \n</html>");
        founthLide.add(B352);

        JLabel cables = createPanel(1,1,1);
        cables.setBounds(50,250,250,350);
        cables.setText("<html>Соединительные и измерительные кабели\n" +
                "Электрические и оптоволоконные кабели, используемые для электрического соединения электрических" +
                " устройств между собой, а также  для передачи сигналов низкого уровня, в том числе в системах сбора" +
                " информации и линий связи сборок внутриреакторных детекторов и термоконтроля.\n</html>");
        founthLide.add(cables);

        JLabel software = createPanel(1,1,1);
        software.setBounds(100,250,300,350);
        software.setText("<html>Программная оболочка «Шепот-Лайт» и Программный модуль «Шепот-Вариант»\n" +
                "Специальное программное обеспечение, устанавливающееся на ПЭВМ. Предназначено для управления" +
                " измерительным блоком и модулем источника тестового акустического сигнала, проведения измерений" +
                " и получениях их результатов, их редактирования и сохранения для дальнейшего создания отчетов.\n</html>");
        founthLide.add(software);

        JLabel ist = createPanel(1,1,1);
        ist.setBounds(230,270,400,250);
        ist.setText("<html>Источник калиброванного звукового давления\n" +
                "Малогабаритный источник звука, работающий от батарей, состоящий из измерительного блока и камеры малого" +
                " объема с отверстием для подсоединения микрофона. Принцип работы основан на обратной связи с ICP-микрофоном," +
                " используя его в цепи системы «излучатель – генератор»," +
                " поддерживая, таким образом, постоянный уровень звукового давления в 94 или 114 дБ.\n</html>");
        founthLide.add(ist);

        JLabel part1 = new JLabel();
        part1.setBounds(145, 74, 290 - 145, 191 - 74);
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
                //partName.setText("<html>Измерительный микрофон</html>");
                micro.setVisible(true);
                micro.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                micro.setVisible(false);
            }
        });
        founthLide.add(part1);

        JLabel part2 = new JLabel();
        part2.setBounds(481, 230, 569 - 481, 320 - 230);
        part2.addMouseListener(new MouseListener() {
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
                LD824.setVisible(true);
                LD824.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LD824.setVisible(false);
            }
        });
        founthLide.add(part2);

        JLabel part3 = new JLabel();
        part3.setBounds(81, 306, 190 - 81, 515 - 306);
        part3.addMouseListener(new MouseListener() {
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
                //partName.setText("<html>Измерительный микрофон</html>");
                shelest.setVisible(true);
                shelest.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                shelest.setVisible(false);
            }
        });
        founthLide.add(part3);

        JLabel part4 = new JLabel();
        part4.setBounds(276, 326, 459 - 276, 511 - 326);
        part4.addMouseListener(new MouseListener() {
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
                laptop.setVisible(true);
                laptop.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                laptop.setVisible(false);
            }
        });
        founthLide.add(part4);

        JLabel part5 = new JLabel();
        part5.setBounds(205, 514, 247 - 205, 554 - 514);
        part5.addMouseListener(new MouseListener() {
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
                ist.setVisible(true);
                ist.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ist.setVisible(false);
            }
        });
        founthLide.add(part5);

        JLabel part6 = new JLabel();
        part6.setBounds(296, 513, 348 - 296, 566 - 513);
        part6.addMouseListener(new MouseListener() {
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
                cables.setVisible(true);
                cables.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cables.setVisible(false);
            }
        });
        founthLide.add(part6);

        JLabel part7 = new JLabel();
        part7.setBounds(377, 516, 466 - 377, 579 - 516);
        part7.addMouseListener(new MouseListener() {
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
                software.setVisible(true);
                software.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                software.setVisible(false);
            }
        });
        founthLide.add(part7);

        JLabel part8 = new JLabel();
        part8.setBounds(235,458,271-235,509-458);
        part8.addMouseListener(new MouseListener() {
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
                B352.setVisible(true);
                B352.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                B352.setVisible(false);
            }
        });
        founthLide.add(part8);
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
            img.setBounds(0, 75, 900, 350);
            newimg = image.getScaledInstance(900, 350, java.awt.Image.SCALE_SMOOTH);
        } else {
            img.setBounds(75, 75, 500, 500);
            newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
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
}