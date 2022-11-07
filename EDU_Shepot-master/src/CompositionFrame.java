import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CompositionFrame extends JPanel {
    // --------------COLORS-----------
    Color darkCyan = new Color(66, 122, 171, 134);
    Color lightBlueBtn = new Color(162, 226, 245);
    Color greyCyan = new Color(53, 66, 75);
    Color greyExitButton = new Color(81, 90, 101);
    Color background = new Color(213, 216, 228);
    Color textColor = new Color(165, 168, 224
    );
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
            img.setBounds(0, 75, 600, 300);
            newimg = image.getScaledInstance(600, 300, java.awt.Image.SCALE_SMOOTH);
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
        firstSlide = createSlide(".\\assets\\Shepot_composition.png", "Состав", true, 70);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(750, 100, 470, 350);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 19));
        generalInfo.setHorizontalTextPosition(JLabel.CENTER);
        generalInfo.setForeground(textColor);
        generalInfo.setHorizontalAlignment(JLabel.LEFT);
        generalInfo.setText("<html>1 - Средство измерения «Larson&Davis 824»<br>" +
                "2 – Рабочая укладка с управляемым коммутатором<br>" +
                "3 – Штатив, соединительные и измерительные кабели<br>" +
                "4 - Микрофон «РСВ Piezotronics TMS130D20»<br>" +
                "5 – Портативный компьютер<br>" +
                "6 – Приемник<br>" +
                "7 – Передатчик<br>" +
                "8 – Генератор шума «Шорох-2МИ»<br>" +
                "9 – Калибратор CAL-200<br>" +
                "10 – Акселерометр «АР98-100»<br>" +
                "11 – Акустический излучатель</html>");
        firstSlide.add(generalInfo);

        JLabel partName = new JLabel();
        partName.setBounds(700, 450, 550, 150);
        partName.setFont(new Font("Calibri", Font.BOLD, 30));
        partName.setVerticalAlignment(JLabel.CENTER);
        partName.setForeground(textColor);
        partName.setHorizontalAlignment(JLabel.LEFT);
        firstSlide.add(partName);

        JLabel part1 = new JLabel();
        part1.setBounds(434, 452, 655 - 434, 517 - 452);
        part1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "2");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Средство измерения «Larson&Davis 824»</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part1);

        JLabel part2 = new JLabel();
        part2.setBounds(427, 330, 670 - 427, 447 - 330);
        part2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "3");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Рабочая укладка с управляемым коммутатором</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part2);

        JLabel part3 = new JLabel();
        part3.setBounds(280, 93, 488 - 280, 295 - 93);
        part3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "4");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Штатив, соединительные и измерительные кабели</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part3);

        JLabel part4 = new JLabel();
        part4.setBounds(303, 343, 413 - 303, 414 - 343);
        part4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "4");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Микрофон «РСВ Piezotronics TMS130D20»</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part4);

        JLabel part5 = new JLabel();
        part5.setBounds(160, 415, 396 - 160, 556 - 415);
        part5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "5");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Портативный компьютер</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part5);

        JLabel part6 = new JLabel();
        part6.setBounds(132, 218, 285 - 132, 286 - 218);
        part6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "6");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Приемник</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part6);

        JLabel part7 = new JLabel();
        part7.setBounds(119, 285, 283 - 119, 315 - 285);
        part7.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "6");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Передатчик</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part7);

        JLabel part8 = new JLabel();
        part8.setBounds(110, 312, 292 - 110, 392 - 312);
        part8.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "7");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Генератор шума «Шорох-2МИ»</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part8);

        JLabel part9 = new JLabel();
        part9.setBounds(100, 396, 154 - 100, 475 - 396);
        part9.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "8");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Калибратор CAL-200</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part9);

        JLabel part10 = new JLabel();
        part10.setBounds(103, 474, 147 - 103, 525 - 474);
        part10.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "9");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Акселерометр «АР98-100»</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part10);

        JLabel part11 = new JLabel();
        part11.setBounds(67, 170, 114 - 67, 345 - 170);
        part11.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crd.show(slideShow, "10");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                partName.setText("<html>Акустический излучатель</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part11);
    }

    private void createSecondSlide() {
        secondSlide = createSlide(".\\assets\\Larson&Davis 824.png", "Средство измерения «Larson&Davis 824»", false, 70);

        JLabel upInfo = new JLabel();
        upInfo.setBounds(630, 150, 550, 600);
        upInfo.setFont(new Font("Calibri", Font.BOLD, 16));
        upInfo.setVerticalAlignment(JLabel.TOP);
        upInfo.setForeground(textColor);
        upInfo.setHorizontalAlignment(JLabel.LEFT);
        upInfo.setText("<html>По дополнительному заказу Модель 824 может оснащаться опцией частотного анализатора" +
                " 824-RTA с автоматической записью в память спектров (1/1- или 1/3-октавных). Эта опция" +
                " реализует также вычисление специальных величин, необходимых при исследовании акустики" +
                " помещений - времени реверберации RT60, критериев NC, RC и др.<br>" +
                "Опция 824-FFT - позволяет производить БПФ анализ с разрешением до 400 линий.<br>" +
                "Опция 824-AUD превращает Модель 824 в систему калибровки аудиометров. Модель 824 оснащена" +
                " цифровым интерфейсом RS-422. В комплект поставки входит программное обеспечение для связи" +
                " прибора с персональным компьютером, передачи данных из прибора в ПК и их трансляции в текстовые форматы.<br>" +
                "Принцип действия шумомера заключается в следующем:<br>" +
                "Предварительно усиленный электрический сигнал от, например, микрофона, преобразуется в" +
                " аналого-цифровом преобразователе, далее пропускается через набор октавных фильтров, " +
                "чтобы затем их параметры можно было измерить и использовать для других операций. У шумомера" +
                " есть несколько режимов работы, все управляющиеся с помощью клавиатуры, но для работы с «Шепот»" +
                " основным является SLM+RTA (Sound Level Measure + Real Time Analysis), позволяющий измерение" +
                " звукового уровня и анализ а реальном времени, иными словами, частотный анализ.<html>");
        secondSlide.add(upInfo);

        JLabel sideInfo = new JLabel();
        sideInfo.setBounds(30, 330, 550, 300);
        sideInfo.setFont(new Font("Calibri", Font.BOLD, 15));
        sideInfo.setVerticalAlignment(JLabel.CENTER);
        sideInfo.setForeground(textColor);
        sideInfo.setHorizontalAlignment(JLabel.LEFT);
        sideInfo.setText("<html>Модель включает в себя функции интегрирующего шумомера-анализатора спектра" +
                " и шумомера-регистратора. В режиме шумомер-анализатор прибор одновременно измеряет общие " +
                "и корректированные уровни звука (А, С, Лин - Быстро, Медленно, Импульс), эквивалентные," +
                " максимальные и минимальные уровни звука и уровни звукового давления в октавных или " +
                "третьоктавных полосах частот в звуковом диапазоне.<br>" +
                "В режиме шумомер-регистратор прибор не проводит частотный анализ, но позволяет осуществлять" +
                " длительный мониторинг шума с автоматической записью в память большого количества параметров" +
                " - эквивалентные, максимальные, пиковые, минимальные уровни звука, дозу, моменты превышения" +
                " установленных порогов и т.д.\n<</html>");
        secondSlide.add(sideInfo);
    }

    private void createThirdSlide() {
        thirdSlide = createSlide("", "Рабочая укладка", true, 70);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Work_Layout.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(30, 80, 400, 500);
        newimg = image.getScaledInstance(400, 500,  java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        thirdSlide.add(img);

        JLabel upInfo = new JLabel();
        upInfo.setBounds(530, 75,700,600);
        upInfo.setFont(new Font("Calibri", Font.BOLD, 22));
        upInfo.setVerticalAlignment(JLabel.TOP);
        upInfo.setForeground(textColor);
        upInfo.setHorizontalAlignment(JLabel.LEFT);
        upInfo.setText("<html>Коммутатор смонтирован в рабочей укладке и предназначен для обеспечения управления элементами" +
                " системы, включение / отключение генератора шума и микрофонов вместе с" +
                " акселерометром, а также передачу значений от их сигнала на компьютер. <br>" +
                "К разъемам «КАНАЛ 1» и «КАНАЛ 2» подключаются микрофоны, к первому измеряющий тестовый сигнал," +
                " а ко второму измеряющий уровень информативного сигнала, фона и помехи. Два индикатора красного" +
                " цвета «ПИТ МКФ» сигнализируют о том, что на микрофоны (акселерометр) соответствующего канала" +
                " подано питание. Зеленые индикаторы «ВКЛ» показывают какой измерительный канал (первый или второй) подключен к входу шумомера.<br>" +
                "К разъему «УПРАВЛЕНИЕ» подключается генератор тестового сигнала, USB же предназначен для" +
                " подключения укладки к компьютеру, индикаторы зеленого цвета рядом с ними сигнализируют, " +
                "Также в рабочей укладке размещаются две бобины с микрофонным кабелем, каждый длиной 20м.<html>");
        thirdSlide.add(upInfo);
    }

    private void createFourthSlide() {
        founthLide = createSlide("", "Соединительные кабели/Микрофон", true, 70);

        JLabel upInfo = new JLabel();
        upInfo.setBounds(75, 75, 1000, 600);
        upInfo.setFont(new Font("Calibri", Font.BOLD, 25));
        upInfo.setVerticalAlignment(JLabel.CENTER);
        upInfo.setForeground(textColor);
        upInfo.setHorizontalAlignment(JLabel.LEFT);
        upInfo.setText("<html> Соединительные кабели <br>В комплект входят  соединительные и измерительные кабели," +
                " блок аккумуляторных батарей «БА-ШМ», два штатива и зарядные устройства.<br> <br> <br>" +
                "Микрофон<br> В комплекте «Шепот» предоставляются два конденсаторных микрофона «РСВ Piezotronics" +
                " TMS130D20».  Микрофоны необходимы для проведения измерений уровней тестового сигнала от " +
                "акустического излучателя (звуковой колонки).  В микрофоны встроен тефлоновый кабель, а их чувствительность составляет 10mV/g.<html>");
        founthLide.add(upInfo);
    }

    private void createFifthSlide() {
        fifthSlide = createSlide(".\\assets\\Interface.png", "Портативный компьютер", true, 70);

        JLabel upInfo = new JLabel();
        upInfo.setBounds(730, 150, 550, 500);
        upInfo.setFont(new Font("Calibri", Font.BOLD, 30));
        upInfo.setVerticalAlignment(JLabel.TOP);
        upInfo.setForeground(textColor);
        upInfo.setHorizontalAlignment(JLabel.LEFT);
        upInfo.setText("<html>Компьютер с программным обеспечением  «Шепот-Интерфейс» предназначен для" +
                " управления компонентами системы, ведения базы данных об исследуемых объектах и " +
                "результатах измерений, выполнения необходимых расчетов и подготовки отчета.<br>" +
                "<br><br>Главное окно программы «Шепот-Интерфейс»<html>");
        fifthSlide.add(upInfo);
    }

    private void createSixthSlide() {
        sixthSlide = createSlide("", "Приемник и передатчик", false, 70);

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
        btm2Txt.setBounds(100, 490, 1100, 200);
        btm2Txt.setFont(new Font("Calibri", Font.BOLD, 20));
        btm2Txt.setVerticalAlignment(JLabel.TOP);
        btm2Txt.setForeground(textColor);
        btm2Txt.setHorizontalAlignment(JLabel.LEFT);
        sixthSlide.add(btm2Txt);
    }

    private void createSeventhSlide() {
        seventhSlide = createSlide("", "Генератор шума «Шорох-2МИ»", true, 70);

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

    private void createNinethSlide() {
        ninethSlide = createSlide(".\\assets\\P98-100.png", "Акселерометр «АР98-100»", true, 70);

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

    private void createEighthSlide() {
        eighthSlide = createSlide(".\\assets\\CAL200.png", "Калибратор CAL-200", true, 70);

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

    private void createlastSlide() {
        lastSlide = createSlide("", "Акустический излучатель", true, 70);

        JLabel peredatchik = new JLabel(new ImageIcon(".\\assets\\Transmittor.png"));
        peredatchik.setBounds(75, 80, 150, 550);
        lastSlide.add(peredatchik);

        JLabel btm2Txt = new JLabel("<html>Акустическим излучателем в комплекте «Шепот» служит громкоговоритель" +
                " «Шорох-2МИ». Используется для создания тестового сигнала при проверке помещений и материалов," +
                " в анучно-исследовательских работах и так далее.</html>");
        btm2Txt.setBounds(380, 90, 720, 500);
        btm2Txt.setFont(new Font("Calibri", Font.BOLD, 35));
        btm2Txt.setVerticalAlignment(JLabel.TOP);
        btm2Txt.setForeground(textColor);
        btm2Txt.setHorizontalAlignment(JLabel.LEFT);
        lastSlide.add(btm2Txt);
    }
}