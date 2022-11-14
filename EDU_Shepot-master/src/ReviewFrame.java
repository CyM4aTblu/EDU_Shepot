import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReviewFrame extends JPanel {
    // --------------COLORS-----------
    Color darkCyan = new Color(66, 122, 171, 134);
    Color lightBlueBtn = new Color(162, 226, 245);
    Color greyCyan = new Color(53, 66, 75);
    Color greyExitButton = new Color(81, 90, 101);
    Color background = new Color(224, 255, 255);
    Color textColor = new Color(0x3d74a6);
    Color btmTopBars = new Color(197, 230, 236);
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
        bottomNavBar.setBackground(new Color(209, 241, 255));
        this.add(bottomNavBar);

        returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrow.png");
        returnToMenu.setBounds(50, 15, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.setContentAreaFilled(false);
        returnToMenu.setFocusPainted(false);
        returnToMenu.setBorderPainted(false);
        bottomNavBar.add(returnToMenu);

        ImageIcon nxt = new ImageIcon(".\\assets\\ArrowNext.png");
        JButton nextSlide = new JButton(nxt);
        nextSlide.setFocusable(false);
        nextSlide.setBounds(680, 5, 65, 65);
        nextSlide.addActionListener(e -> crd.next(slideShow));
        nextSlide.setContentAreaFilled(false);
        nextSlide.setFocusPainted(false);
        nextSlide.setBorderPainted(false);
        bottomNavBar.add(nextSlide);

        ImageIcon prv = new ImageIcon(".\\assets\\ArrowBack.png");
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
        firstSlide = createSlide(".\\assets\\sprut-6ma.png", "Спрут-6МА", true, 70);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(575, 75, 600, 350);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 19));
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
                " акустических и виброакустических сигналов анализ и так далее</center></html>");
        firstSlide.add(generalInfo);

        JLabel partName = new JLabel();
        partName.setBounds(575, 425, 600, 150);
        partName.setFont(new Font("Calibri", Font.BOLD, 25));
        partName.setVerticalAlignment(JLabel.CENTER);
        partName.setForeground(textColor);
        partName.setHorizontalAlignment(JLabel.LEFT);
        firstSlide.add(partName);

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
                partName.setText("<html>Носитель информации на диске типа Flash с СПО \"CПРУТ\"</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>ПЭВМ типа ноутбук</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Устройство сопряжения с измерительным модулем \"S8W\"</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Вибро-акустический анализатор \"СПРУТ-ВАА-1\"<br>" +
                        "(одноканальный шумомер - анализатор спектра - виброметр)</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Активная акуститеская система со встроенным усилителем в экранированном контейнере</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Блок питания для ПЭВМ с сетевым кабелем</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Блок измерительный \"Спрут\"</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        firstSlide.add(part7);
    }

    private void createSecondSlide() {
        secondSlide = createSlide(".\\assets\\Sprut-7A.png", "Спрут-7A", true, 70);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(575, 75, 600, 350);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 19));
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

        JLabel partName = new JLabel();
        partName.setBounds(575, 425, 600, 150);
        partName.setFont(new Font("Calibri", Font.BOLD, 25));
        partName.setVerticalAlignment(JLabel.CENTER);
        partName.setForeground(textColor);
        partName.setHorizontalAlignment(JLabel.LEFT);
        secondSlide.add(partName);

        JLabel part1 = new JLabel();
        part1.setBounds(71, 199, 157, 235);
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
                partName.setText("<html>Акустическая система</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        secondSlide.add(part1);

        JLabel part2 = new JLabel();
        part2.setBounds(105, 158, 70, 43);
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
                partName.setText("<html>Модуль источника тестового акустического сигнала</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        secondSlide.add(part2);

        JLabel part3 = new JLabel();
        part3.setBounds(142, 487, 198 - 142, 569 - 487);
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
                partName.setText("<html>Модуль сопряжения с ПК</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        secondSlide.add(part3);

        JLabel part4 = new JLabel();
        part4.setBounds(236, 227, 400 - 236, 500 - 227);
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
                partName.setText("<html>ПЭВМ типа ноутбук</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        secondSlide.add(part4);

        JLabel part5 = new JLabel();
        part5.setBounds(408, 493, 464 - 408, 558 - 493);
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
                partName.setText("<html>Устройство сопряжения с измерительным модулем</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        secondSlide.add(part5);

        JLabel part6 = new JLabel();
        part6.setBounds(454, 372, 554 - 454, 465 - 372);
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
                partName.setText("<html>Измерительный модуль с октавным анализом, третьоктавным анализом и функцией БПФ</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        secondSlide.add(part6);

        JLabel part7 = new JLabel();
        part7.setBounds(469, 458, 504 - 469, 495 - 458);
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
                partName.setText("<html>Модуль сопряжения с ПК</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        secondSlide.add(part7);

        JLabel part8 = new JLabel();
        part8.setBounds(505, 488, 558 - 505, 550 - 488);
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
                partName.setText("<html>Зарядное устройство</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        secondSlide.add(part8);
    }

    private void createThirdSlide() {
        thirdSlide = createSlide("", "Комплекс акустического и виброакустического контроля \"Колибри\"", true, 40);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(".\\assets\\Calibri.png");
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(-40, 80, 620, 500);
        newimg = image.getScaledInstance(620, 500, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        thirdSlide.add(img);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(575, 75, 600, 350);
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

        JLabel partName = new JLabel();
        partName.setBounds(575, 425, 600, 150);
        partName.setFont(new Font("Calibri", Font.BOLD, 25));
        partName.setVerticalAlignment(JLabel.CENTER);
        partName.setForeground(textColor);
        partName.setHorizontalAlignment(JLabel.LEFT);
        thirdSlide.add(partName);

        JLabel part1 = new JLabel();
        part1.setBounds(118, 77, 305 - 118, 548 - 77);
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
                partName.setText("<html>Источник тестового акустического сигнала\"Колибри2\"</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        thirdSlide.add(part1);

        JLabel part2 = new JLabel();
        part2.setBounds(473, 236, 531 - 473, 495 - 236);
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
                partName.setText("<html>Компакт-диск (Flash-накопитель) с програмным обеспечинием</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        thirdSlide.add(part2);

        JLabel part3 = new JLabel();
        part3.setBounds(328, 99, 469 - 328, 464 - 129);
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
                partName.setText("<html>Многоканальный анализатор-концентратор сигналов \"СКМ-8\"</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        thirdSlide.add(part3);

        JLabel part4 = new JLabel();
        part4.setBounds(270, 454, 521 - 270, 538 - 454);
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
                partName.setText("<html>Измерительный микрофон \"МР201\" с предусилителем \"Р410\"</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        thirdSlide.add(part4);

        JLabel part5 = new JLabel();
        part5.setBounds(289, 360, 399 - 289, 463 - 360);
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
                partName.setText("<html>Пульт дистанционного управления</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        thirdSlide.add(part5);


    }

    private void createFourthSlide() {
        founthLide = createSlide(".\\assets\\Shepot-T.png", "<html>Система оценки защищенности выделенных помещений по виброакустическому каналу \"ШЕПОТ-Т\"</html>", true, 28);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(575, 75, 600, 350);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 19));
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

        JLabel partName = new JLabel();
        partName.setBounds(575, 425, 600, 150);
        partName.setFont(new Font("Calibri", Font.BOLD, 25));
        partName.setVerticalAlignment(JLabel.CENTER);
        partName.setForeground(textColor);
        partName.setHorizontalAlignment(JLabel.LEFT);
        founthLide.add(partName);

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
                partName.setText("<html>Измерительный микрофон</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Шумомер</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Генератор тестового акустического сигнала</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Переносная ЭВМ (ноутбук)</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Акселерометр</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Кабель USB</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                partName.setText("<html>Компакт-Диск с програмным обеспечением</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        founthLide.add(part7);
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