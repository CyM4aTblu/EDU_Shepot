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
    Color textColor = new Color(0x76AFD0);
    Color btmTopBars = new Color(197, 230, 236);
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel firstSlide,secondSlide, thirdSlide, founthLide;
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
        bottomNavBar.setBounds(0, 605 , 1280, 75);
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
    generalInfo.setFont(new Font("Calibri", Font.BOLD, 19 ));
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
    partName.setBounds(575, 425,600,150);
    partName.setFont(new Font("Calibri", Font.BOLD, 25 ));
    partName.setVerticalAlignment(JLabel.CENTER);
    partName.setForeground(textColor);
    partName.setHorizontalAlignment(JLabel.LEFT);
    firstSlide.add(partName);

    JLabel part1 = new JLabel();
    part1.setBounds(100,380,100, 100);
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
    part2.setBounds(200,285, 200, 540-288);
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
    part3.setBounds(120,485, 55, 50);
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
    part4.setBounds(58,77, 130, 300);
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
    part5.setBounds(410,250, 127, 210);
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
    part6.setBounds(402,460, 58, 67);
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
    part7.setBounds(477,471, 100, 100);
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
        secondSlide = createSlide(".\\assets\\Sprut-7A.png", "Спрут-7A", true,70);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(575, 75, 600, 350);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 19 ));
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
        partName.setBounds(575, 425,600,150);
        partName.setFont(new Font("Calibri", Font.BOLD, 25 ));
        partName.setVerticalAlignment(JLabel.CENTER);
        partName.setForeground(textColor);
        partName.setHorizontalAlignment(JLabel.LEFT);
        secondSlide.add(partName);

        JLabel part1 = new JLabel();
        part1.setBounds(71, 199,157,235);
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
        part2.setBounds(105,158, 70, 43);
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
        part3.setBounds(142,487, 198-142, 569-487);
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
        part4.setBounds(236,227, 400-236, 500-227);
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
        part5.setBounds(408,493, 464-408, 558-493);
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
        part6.setBounds(454,372, 554-454, 465-372);
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
        part7.setBounds(469,458, 504-469, 495-458);
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
        part8.setBounds(505,488, 558-505, 550-488);
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
        newimg = image.getScaledInstance(620, 500,  java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        thirdSlide.add(img);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(575, 75, 600, 350);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 25 ));
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
        partName.setBounds(575, 425,600,150);
        partName.setFont(new Font("Calibri", Font.BOLD, 25 ));
        partName.setVerticalAlignment(JLabel.CENTER);
        partName.setForeground(textColor);
        partName.setHorizontalAlignment(JLabel.LEFT);
        thirdSlide.add(partName);

        JLabel part1 = new JLabel();
        part1.setBounds(118, 77,305-118,548-77);
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
        part2.setBounds(473,236, 531-473, 495-236);
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
        part3.setBounds(328,99, 469-328, 464-129);
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
        part4.setBounds(270,454, 521-270, 538-454);
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
        part5.setBounds(289,360, 399-289, 463-360);
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
        founthLide = createSlide(".\\assets\\Shepot-T.png", "Система оценки защищенности выделенных помещений по виброакустическому каналу \"ШЕПОТ-Т\"", true,40);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(575, 75, 600, 350);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 19 ));
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
        partName.setBounds(575, 425,600,150);
        partName.setFont(new Font("Calibri", Font.BOLD, 25 ));
        partName.setVerticalAlignment(JLabel.CENTER);
        partName.setForeground(textColor);
        partName.setHorizontalAlignment(JLabel.LEFT);
        founthLide.add(partName);

        JLabel part1 = new JLabel();
        part1.setBounds(145,74,290-145,191-74);
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
        part2.setBounds(481,230, 569-481,320-230);
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
        part3.setBounds(81,306,190-81,515-306);
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
        part4.setBounds(276,326,459-276,511-326);
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
        part5.setBounds(205,514,247-205,554-514);
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
        part6.setBounds(296,513, 348-296,566-513);
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
        part7.setBounds(377,516, 466-377,579-516);
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
    private JPanel createSlide(String path, String name, boolean SideLayout, int fontsize){
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(background);
        slide.setBounds(0,0 , 1280, 605);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0 , 1280, 75);
        topBar.setBackground(btmTopBars);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(path);
        Image image = unit.getImage();
        Image newimg;
        if(!SideLayout) {
            img.setBounds(0, 75 ,900, 350);
            newimg = image.getScaledInstance(900, 350,  java.awt.Image.SCALE_SMOOTH);
        }
        else {
            img.setBounds(75, 75 ,500, 500);
            newimg = image.getScaledInstance(500, 500,  java.awt.Image.SCALE_SMOOTH);
        }
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        slide.setLayout(null);
        slide.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x=e.getX();
                int y=e.getY();
                System.out.println(x+","+y);
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
        txt.setFont(new Font("Calibri", Font.BOLD, fontsize ));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setForeground(textColor);
        topBar.add(txt);
        slide.add(topBar);
        slide.repaint();
        return slide;
    }
    //REVIEW PREVIOUS VERSION
//    private void createFirstSlide() {
//        firstSlide = createSlide(".\\assets\\sprut-6ma.png", "Спрут-6МА");
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(400, 75 ,750, 400);
//        mainInfo.setText("<html> Программно-аппаратный комплекс для проверки выполнения норм" +
//                " эффективности защиты речевой информации от утечки по акустическому, виброакустическому" +
//                " каналам, а также за счет низкочастотных наводок на токопроводящих элементах ограждающих" +
//                " конструкций и линиях ТСПИ за счет побочных электромагнитных излучений от технических" +
//                " средств в речевом диапазоне. Позволяет проводить измерения параметров звуко- и" +
//                " виброизоляционных свойств конструкций; исследования характеристик и проверку эффективности" +
//                " систем акустического и виброакустического зашумления; измерения уровней электрического и" +
//                " магнитного полей и наводок на проводные коммуникации; измерения характеристик акустических" +
//                " и виброакустических сигналов, в том числе октавный и третьоктавный анализ; статистическую" +
//                " обработку результатов измерений и т.д.Управление комплексом осуществляется по радиоканалу.</html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 15 ));
//        firstSlide.add(mainInfo);
//
//        JLabel contentInfo = new JLabel();
//        contentInfo.setBounds(15, 300 ,306, 450);
//        contentInfo.setText("<html>Состав:<br>" +
//                "Измерительная подсистема в составе:<br>" +
//                "- измерительный модуль;<br>" +
//                "- измерительный микрофон;<br>" +
//                "- измерительный акселерометр;<br>" +
//                "- адаптер – усилитель для подключения различных датчиков<br>" +
//                " (антенны, токосъемники, осциллографические щупы);<br>" +
//                "- стойка для установки измерительного модуля;<br>" +
//                "- зарядное устройство.<br>" +
//                "Подсистема источника тестового акустического сигнала в составе:<br>" +
//                "- модуль источника тестового акустического сигнала;<br>" +
//                "- акустическая система;<br>" +
//                "- стойка для установки акустической системы;<br>" +
//                "- зарядное устройство.<br>" +
//                "Подсистема управления:<br>" +
//                "- модуль сопряжения с ПК;<br>" +
//                "- ПЭВМ типа ноутбук;<br>" +
//                "- специальное программное обеспечение.<br></html>");
//        contentInfo.setVerticalAlignment(JLabel.TOP);
//        contentInfo.setForeground(textColor);
//        contentInfo.setFont(new Font("Calibri", Font.BOLD, 12 ));
//        firstSlide.add(contentInfo);
//
//        JLabel content2Info = new JLabel();
//        content2Info.setBounds(800, 450 ,450, 450);
//        content2Info.setText("<html>Принадлежности:<br>" +
//                "- комплект оснастки для крепления акселерометра (вибродатчика) к исследуемым поверхностям" +
//                ": шпилька (винт) с резьбой М5, специальные площадки с резьбовым соединением М5," +
//                " циакриновый клей для установки самих площадок," +
//                " газовая горелка для снятия площадок с поверхности, струбцины, монтажные хомуты, мастика);<br>" +
//                "- сумки для хранения и транспортировки комплекса и компьютера.</html>");
//        content2Info.setVerticalAlignment(JLabel.TOP);
//        content2Info.setForeground(textColor);
//        content2Info.setFont(new Font("Calibri", Font.BOLD, 13 ));
//        firstSlide.add(content2Info);
//
//        JLabel subInfo = new JLabel();
//        subInfo.setBounds(800, 300 ,450, 600);
//        subInfo.setText("<html> Акустическая система:<br>" +
//                "Виды тестового сигнала: белый шум; розовый шум; шум в октавных<br>" +
//                "полосах 250, 500, 1000, 2000, 4000 Гц; набор синусоидальных сигналов с частотами от 20 до 20000 Гц.<br>" +
//                "Максимальное звуковое давление на расстоянии 1м: 116 дБ (пиковое).<br>" +
//                "Питание – от сети переменного тока 220В, 50 Гц.<br>" +
//                "Общая масса комплекса составляет не более 15 кг.<br></html>");
//        subInfo.setVerticalAlignment(JLabel.TOP);
//        subInfo.setForeground(textColor);
//        subInfo.setFont(new Font("Calibri", Font.BOLD, 12));
//        firstSlide.add(subInfo);
//
//        JLabel content3Info = new JLabel();
//        content3Info.setBounds(400, 300 ,350, 450);
//        content3Info.setText("<html>Основные технические характеристики:<br>" +
//                "Измерительный модуль:<br>" +
//                "Выполняет функции анализатора шума и вибраций 1-го класса точности и отвечает требованиям ГОСТ 17187-81 и ГОСТ 17168-82.<br>" +
//                "Режимы работы:<br>" +
//                "- спектральный анализ;<br>" +
//                "- октавный анализ;<br>" +
//                "- 1/3 октавный анализ.<br>" +
//                "Диапазон частот фильтров:<br>" +
//                "- 1/1-октавные фильтры по ГОСТ 17168: от 2 до 1,6•10 ;<br>" +
//                "- 1/3-октавные фильтры по ГОСТ17168: от 20 до 2 •10 .<br>" +
//                "Диапазон измеряемых уровней:<br>" +
//                "- звукового давления: 24÷130 дБ;<br>" +
//                "- виброускорения: 0,01÷708 м•с .<br>" +
//                "Пределы основной погрешности измерений:<br>" +
//                "- уровня звукового давления: ± 0,7 дБ;<br>" +
//                "- виброускорения: ± 0,7 дБ.<br>" +
//                "Коэффициент усиления адаптера-усилителя: 20 дБ, 40 дБ.<br>" +
//                "Электропитание от встроенного аккумулятора. Время работы не менее 4,5 часов.<br></html>");
//        content3Info.setVerticalAlignment(JLabel.TOP);
//        content3Info.setForeground(textColor);
//        content3Info.setFont(new Font("Calibri", Font.BOLD, 12 ));
//        firstSlide.add(content3Info);
//
//    }
//    private void createSecondSlide() {
//        secondSlide = createSlide("", "Спрут-6МА");
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(100, 75 ,450, 600);
//        mainInfo.setText("<html> Специальное программное обеспечение:<br>" +
//                "Специальное программное обеспечение совместно с управляющей" +
//                " подсистемой осуществляет управление всем комплексом в целом" +
//                " и на основе полученных результатов измерений в соответствии" +
//                " со «Сборником нормативно-методических документов по противодействию" +
//                " речевой разведке (НМД АРР)» оценивает разборчивость речи." +
//                " Управление подсистемами и передача измерительной информации" +
//                " осуществляются по радиоканалу в цифровом виде. По результатам" +
//                " выполненных измерений формируется протокол в виде таблиц" +
//                " (таблица 1, таблица 2), в которой отображаются уровни измеренных" +
//                " сигналов и рассчитанные значения интегрального индекса артикуляции" +
//                " «R» и словесной разборчивости речи «W».<br></html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 15));
//        secondSlide.add(mainInfo);
//
//        JLabel sub2Info = new JLabel();
//        sub2Info.setBounds(650, 75 ,450, 600);
//        sub2Info.setText("<html>Дополнительно:<br>" +
//                "Монтажное устройство «Краб» для установки измерительного оборудования в оконные проемы с наружной стороны промышленных, офисных и жилых зданий при проведении аттестации выделенных помещений. - 35 000 руб.<br>" +
//                "Состав оборудования:<br>" +
//                "- регулируемая по длине штанга с устройством гарантированного усилия;<br>" +
//                "- высокопрочные наконечники к штанге;<br>" +
//                "- специальное зажимное устройство для крепления шумомера;<br>" +
//                "- микрофонная штанга с зажимным устройством для крепления измерительного микрофона;<br>" +
//                "- электрическая дрель с функцией перфоратора и шуруповерта;<br>" +
//                "- страховочный трос;<br>" +
//                "- транспортная упаковка;<br>" +
//                "- эксплуатационная документация.<br></html>");
//        sub2Info.setVerticalAlignment(JLabel.TOP);
//        sub2Info.setForeground(textColor);
//        sub2Info.setFont(new Font("Calibri", Font.BOLD, 15 ));
//        secondSlide.add(sub2Info);
//
//        JLabel sub3Info = new JLabel();
//        sub3Info.setBounds(100, 400 ,450, 600);
//        sub3Info.setText("<html>Документация:\n" +
//                "- руководство по эксплуатации комплекса СПРУТ-6;\n" +
//                "- формуляр на комплекс СПРУТ-6;\n" +
//                "- сертификат об утверждении типа средств измерений военного назначения на комплекс;\n" +
//                "- сертификат ФСТЭК РОССИИ на расчетную часть программного обеспечения комплекса СПРУТ-6 в системе сертификации средств защиты информации по требованиям безопасности информации.\n</html>");
//        sub3Info.setVerticalAlignment(JLabel.TOP);
//        sub3Info.setForeground(textColor);
//        sub3Info.setFont(new Font("Calibri", Font.BOLD, 15 ));
//        secondSlide.add(sub3Info);
//    }
//    private void createThirdSlide() {
//        thirdSlide = createSlide(".\\assets\\Sprut-7A.png", "Спрут-7А");
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(400, 75 ,850, 400);
//        mainInfo.setText("<html> Программно-аппаратный комплекс для проверки выполнения норм" +
//                " эффективности защиты речевой информации от её утечки по акустическому и" +
//                " виброакустическому каналам, а также за счет низкочастотных наводок на токопроводящие" +
//                " элементы ограждающих конструкций зданий и сооружений и наводок от технических средств" +
//                " в речевом диапазоне частот, образованных за счет акусто-электрических преобразований." +
//                " Управление комплексом осуществляется по радиоканалу.</html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 20 ));
//        thirdSlide.add(mainInfo);
//
//        JLabel contentInfo = new JLabel();
//        contentInfo.setBounds(15, 250 ,400, 450);
//        contentInfo.setText("<html>Возможности комплекса:<br>" +
//                "- измерение характеристик акустических и виброакустических сигналов, в том числе октавный, треть октавный анализ и анализ с использованием функции быстрого преобразования Фурье (БПФ).<br>" +
//                "- проведение исследований характеристик и проверка эффективности систем акустического и виброакустического зашумления.<br>" +
//                "- измерение уровней сигналов акустоэлектрических преобразователей с использованием функции БПФ.<br>" +
//                "- измерение и гигиеническая оценка шумов и вибрации в жилых и производственных помещениях на соответствие санитарным нормам.<br>" +
//                "- проведение измерений параметров звуко- и виброизоляционных свойств конструкций.<br>" +
//                "- измерение уровней электрического и магнитного полей и наводок на проводные коммуникации.<br>" +
//                "- проведение статистической обработки результатов измерений и т.д.<br>" +
//                "Особенности комплекса<br>" +
//                "Впервые на практике реализовано расширение возможностей комплекса, связанное с использованием" +
//                " функции быстрого преобразования Фурье, что позволяет с высокой точностью производить" +
//                " измерения слабых сигналов акустоэлектрических преобразований.\n</html>");
//        contentInfo.setVerticalAlignment(JLabel.TOP);
//        contentInfo.setForeground(textColor);
//        contentInfo.setFont(new Font("Calibri", Font.BOLD, 13 ));
//        thirdSlide.add(contentInfo);
//
//        JLabel content2Info = new JLabel();
//        content2Info.setBounds(450, 250 ,450, 450);
//        content2Info.setText("<html>Основные технические характеристики:<br>" +
//                "Измерительный модуль:<br>" +
//                "Выполняет функции анализатора шума и вибраций 1-го класса точности и отвечает требованиям ГОСТ 17187-81 и ГОСТ 17168-82.<br>" +
//                "Режимы работы:<br>" +
//                "- спектральный анализ;<br>" +
//                "- октавный анализ;<br>" +
//                "- 1/3 октавный анализ;<br>" +
//                "- быстрое преобразование Фурье.<br>" +
//                "Диапазон частот фильтров:<br>" +
//                "- 1/1-октавные фильтры по ГОСТ 17168: от 2 до 16000;<br>" +
//                "- 1/3-октавные фильтры по ГОСТ 17168: от 20 до 20000.<br>" +
//                "Диапазон измеряемых уровней:<br>" +
//                "- звукового давления: 24÷130 дБ;<br>" +
//                "- виброускорения: 0,01÷708 м•с .<br>" +
//                "Пределы основной погрешности измерений:<br>" +
//                "- уровня звукового давления: ± 0,7 дБ;<br>" +
//                "- виброускорения: ± 0,7 дБ.<br>" +
//                "Коэффициент усиления адаптера-усилителя: 40 дБ, 80 дБ.<br>" +
//                "Электропитание от встроенного аккумулятора.<br> Время работы не менее 7 часов.\n</html>");
//        content2Info.setVerticalAlignment(JLabel.TOP);
//        content2Info.setForeground(textColor);
//        content2Info.setFont(new Font("Calibri", Font.BOLD, 13 ));
//        thirdSlide.add(content2Info);
//
//        JLabel content3Info = new JLabel();
//        content3Info.setBounds(900, 250 ,306, 450);
//        content3Info.setText("<html>Специальное программное обеспечение:<br>" +
//                "Специальное программное обеспечение позволяет работать с комплексом как с измерительным прибором, " +
//                "а также проводить измерения и обрабатывать результаты в соответствии с методикой Государственной технической комиссии РФ (НМД АРР).<br><br>" +
//                "Акустическая система:<br>" +
//                "Виды тестового сигнала: белый шум; розовый шум; шум в октавных полосах 250, 500, 1000, 2000, 4000 Гц; набор синусоидальных сигналов с частотами от 20 до 20000 Гц.<br><br>" +
//                "Максимальное звуковое давление на расстоянии 1м: 116 дБ (пиковое).<br>" +
//                "Экранированная акустическая система обеспечивает работу комплекса при измерении сигналов акусто-электрических преобразований.<br><br>" +
//                "Питание – от сети переменного тока 220В, 50 Гц.<br>" +
//                "Общая масса комплекса составляет не более 23 кг.<br>" +
//                "Экранированная акустическая система обеспечивает работу комплекса при измерении сигналов акусто-электрических преобразований.<br></html>");
//        content3Info.setVerticalAlignment(JLabel.TOP);
//        content3Info.setForeground(textColor);
//        content3Info.setFont(new Font("Calibri", Font.BOLD, 12 ));
//        thirdSlide.add(content3Info);
//
//    }
//    private void createFourthSlide(){
//        founthLide = createSlide("", "Спрут-7А");
//
//        JLabel contentInfo = new JLabel();
//        contentInfo.setBounds(15, 100 ,600, 500);
//        contentInfo.setText("<html>Особенности комплекса<br>" +
//                "Впервые на практике реализовано расширение" +
//                " возможностей комплекса, связанное с" +
//                " использованием функции быстрого преобразования" +
//                " Фурье, что позволяет с высокой точностью" +
//                " производить измерения слабых сигналов" +
//                " акустоэлектрических преобразований.<br>" +
//                "Базовый состав:<br>" +
//                "Измерительная подсистема на базе анализатора шума и вибраций 1-го класса точности SVAN в составе:<br>" +
//                "- измерительный модуль с октавным анализом, третьоктавным анализом и функцией БПФ;<br>" +
//                "- измерительный микрофон;<br>" +
//                "- измерительный акселерометр;<br>" +
//                "- измерительные щупы;<br>" +
//                "- адаптер – усилитель для подключения измерительных щупов и антенн;<br>" +
//                "- стойка для установки измерительного модуля;<br>" +
//                "- зарядное устройство.<br>" +
//                "Подсистема источника тестового акустического сигнала в составе:<br>" +
//                "- модуль источника тестового акустического сигнала;<br>" +
//                "- экранированная акустическая система, используемая при проведении измерений акусто –электрических преобразований;<br>" +
//                "- стойка для установки акустической системы;<br>" +
//                "- зарядное устройство.<br>" +
//                "Подсистема управления:<br>" +
//                "- модуль сопряжения с ПК.<br>" +
//                "- ПЭВМ типа ноутбук;<br>" +
//                "- специальное программное обеспечение.<br>" +
//                "Комплект оборудования для обеспечения автономного электропитания объектов ВТСС.<br>" +
//                "Принадлежности:<br>" +
//                "- комплект оснастки для крепления акселерометра (вибродатчика) к исследуемым поверхностям:" +
//                " шпилька (винт) с резьбой М5, специальные площадки с резьбовым соединением М5, циакриновый" +
//                " клей для установки самих площадок, газовая горелка для снятия площадок с поверхности, струбцины, монтажные хомуты, мастика;<br>" +
//                "- сумки для хранения и транспортировки комплекса и компьютера.<br></html>");
//        contentInfo.setVerticalAlignment(JLabel.TOP);
//        contentInfo.setForeground(textColor);
//        contentInfo.setFont(new Font("Calibri", Font.BOLD, 13 ));
//        founthLide.add(contentInfo);
//
//        JLabel sub2Info = new JLabel();
//        sub2Info.setBounds(650, 100 ,500, 600);
//        sub2Info.setText("<html>Дополнительно:<br>" +
//                "Монтажное устройство «Краб» для установки измерительного" +
//                " оборудования в оконные проемы с наружной стороны промышленных," +
//                " офисных и жилых зданий при проведении аттестации выделенных помещений. - 35 000 руб.<br>" +
//                "<br>" +
//                "Состав оборудования:<br>" +
//                "- регулируемая по длине штанга с устройством гарантированного усилия;<br>" +
//                "- высокопрочные наконечники к штанге;<br>" +
//                "- специальное зажимное устройство для крепления шумомера;<br>" +
//                "- микрофонная штанга с зажимным устройством для крепления измерительного микрофона;<br>" +
//                "- электрическая дрель с функцией перфоратора и шуруповерта;<br>" +
//                "- страховочный трос;<br>" +
//                "- транспортная упаковка;<br>" +
//                "- эксплуатационная документация.<br>" +
//                "Документация:<br>" +
//                "- руководство по эксплуатации комплекса СПРУТ-7;<br>" +
//                "- формуляр на комплекс СПРУТ-7;<br>" +
//                "- сертификат об утверждении типа средств измерений военного назначения на комплекс СПРУТ-7;<br>" +
//                "- сертификат ФСТЭК РОССИИ на расчетную часть программного обеспечения" +
//                " комплекса СПРУТ-6 в системе сертификации средств защиты информации по" +
//                " требованиям безопасности информации (разработан на базе ПО Спрут-6).<br></html>");
//        sub2Info.setVerticalAlignment(JLabel.TOP);
//        sub2Info.setForeground(textColor);
//        sub2Info.setFont(new Font("Calibri", Font.BOLD, 15 ));
//        founthLide.add(sub2Info);
//    }
//    private void createFifthSlide(){
//        fifthSlide = createSlide(".\\assets\\Sprut-Mini-A.png", "Спрут мини А");
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(300, 75 ,950, 400);
//        mainInfo.setText("<html> Программно-аппаратный комплекс для проверки выполнения" +
//                " норм эффективности защиты речевой информации от утечки по акустическому," +
//                " виброакустическому каналам, а также за счет низкочастотных наводок на" +
//                " токопроводящих элементах ограждающих конструкций, электроакустических" +
//                " преобразований в линиях ТСПИ и за счет побочных электромагнитных излучений" +
//                " от технических средств в речевом диапазоне. Позволяет проводить проверку" +
//                " выполнения мероприятий по защите речевой информации от её утечки по акустическому," +
//                " виброакустическому каналам, а также за счет побочных электромагнитных излучений" +
//                " и наводок от технических средств в речевом диапазоне частот; измерение параметров" +
//                " звуко- и виброизоляционных свойств конструкций; исследование характеристик и" +
//                " проверка эффективности систем акустического и виброакустического зашумления;" +
//                " измерение параметров электрического и магнитного поля и уровней наводок на проводные коммуникации.</html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 15 ));
//        fifthSlide.add(mainInfo);
//
//        JLabel contentInfo = new JLabel();
//        contentInfo.setBounds(15, 250 ,315, 450);
//        contentInfo.setText("<html>Состав:<br>" +
//                "- многоканальный сигнальный концентратор СПРУТ-М3 с комплектом кабелей;<br>" +
//                "- генератор тестовых сигналов СПРУТ-Г3 с усилителем мощности 3 Вт и комплектом кабелей;<br>" +
//                "- акустический излучатель с комплектом кабелей;<br>" +
//                "- специальное программное обеспечение управления аппаратурой комплекса и обработки измеряемых сигналов;<br>" +
//                "- измерительный микрофон (базовый тип – ECM 8000);<br>" +
//                "- измерительный акселерометр (базовый тип – ENDEVCO 751-100).</html>");
//        contentInfo.setVerticalAlignment(JLabel.TOP);
//        contentInfo.setForeground(textColor);
//        contentInfo.setFont(new Font("Calibri", Font.BOLD, 15 ));
//        fifthSlide.add(contentInfo);
//
//        JLabel content2Info = new JLabel();
//        content2Info.setBounds(420, 250 ,450, 450);
//        content2Info.setText("<html>Основные технические характеристики:<br>" +
//                "Режимы работы – спектральный и октавный анализ.<br>" +
//                "Диапазон рабочих частот – от 20 до 20 000 Гц.<br>" +
//                "Диапазон измеряемых уровней (обеспечиваемый при использовании датчиков базовой комплектации):<br>" +
//                "– звукового давления: 10–105 дБ;<br>" +
//                "– виброускорений: 5*10-5–1 м/с2;<br>" +
//                "– напряженности электрического поля: 10-105 мкВ/м;<br>" +
//                "– напряженности магнитного поля: 0,2-104 мкА/м;<br>" +
//                "– напряжений наведенного электрического сигнала: 5*10-2–103 мкВ.<br>" +
//                "Погрешность измерения (обеспечивается при использовании датчиков базовой комплектации), не более:<br>" +
//                "– уровней звукового давления: 0,7 дБ;<br>" +
//                "– виброускорений: 10-5 м/с2;<br>" +
//                "– напряженности электрического поля: 2 мкВ/м;<br>" +
//                "– напряженности магнитного поля: 4*10-2 мкА/м;<br>" +
//                "– наведенного электрического сигнала: 10-2 мкВ;<br>" +
//                "– частоты (в режиме спектрального анализа): 2%.<br>" +
//                "Дальность управления элементами комплекса по последовательному интерфейсу до 12 м.</html>");
//        content2Info.setVerticalAlignment(JLabel.TOP);
//        content2Info.setForeground(textColor);
//        content2Info.setFont(new Font("Calibri", Font.BOLD, 13 ));
//        fifthSlide.add(content2Info);
//
//        JLabel content3Info = new JLabel();
//        content3Info.setBounds(850, 250 ,400, 450);
//        content3Info.setText("<html>Комплекс работает с антеннами типа ЕМСО 6511, АИ 4-1 и АИР 3-1 (при измерениях наведенных электрических сигналов).<br>" +
//                "Время развертывания и подготовки комплекса к работе не более 20 минут.<br>" +
//                "Документация:<br>" +
//                "- руководство по эксплуатации комплекса СПРУТ-мини;<br>" +
//                "- формуляр на комплекс СПРУТ-мини;<br>" +
//                "- сертификат об утверждении типа средств измерений военного назначения на комплекс СПРУТ-мини;<br>" +
//                "- сертификат ФСТЭК РОССИИ на программные обеспечения комплекса СПРУТ-мини в системе сертификации средств защиты информации по требованиям безопасности информации.<br>" +
//                "Дополнительно:<br>" +
//                "Комплект крепежных принадлежностей для крепления измерительного модуля к конструкциям здания. Состав: хомут со специальной площадкой для установки акселерометра" +
//                " на трубы центрального отопления, комплект площадок для установки акселерометра на стекла, комплект площадок для установки акселерометра на стены, клей для площадок," +
//                " газовая горелка для снятия площадок, комплект дюбелей со шпильками для установки акселерометра на многослойные и неоднородные стены - 4 000 руб.<br>" +
//                "ПЭВМ типа ноутбук - от 48 000 руб.<br>" +
//                "Сумка для хранения и транспортировки ПК - 3 200 руб.<br></html>");
//        content3Info.setVerticalAlignment(JLabel.TOP);
//        content3Info.setForeground(textColor);
//        content3Info.setFont(new Font("Calibri", Font.BOLD, 12 ));
//        fifthSlide.add(content3Info);
//    }
//    private void createSixthSlide(){
//        sixthSlide = createSlide(".\\assets\\Shepot-T.png", "Шепот Т");
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(400, 75 ,750, 400);
//        mainInfo.setText("<html> Система оценки защищенности выделенных помещений по виброакустическому каналу" +
//                " «Шепот-Т» предназначена для проведения специальных акустических и вибрационных измерений в" +
//                " выделенных помещениях с целью оценки их защищенности от утечки речевой информации по виброакустическому каналу.</html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 20 ));
//        sixthSlide.add(mainInfo);
//
//        JLabel contentInfo = new JLabel();
//        contentInfo.setBounds(35, 300 ,306, 450);
//        contentInfo.setText("<html>Особенности системы «ШЕПОТ-T»:\n" +
//                "В качестве основного средства измерения используется анализатор спектра Тритон, производства ООО «ЦБИ «МАСКОМ»;\n" +
//                "Автоматизированный двухканальный режим проведения измерений;\n" +
//                "Наличие радиоканалов для передачи данных от измерительных датчиков к анализатору спектра;\n" +
//                "Формирование базы данных проведенных измерений и расчетов;\n" +
//                "Автоматизированная оценка эффективности систем активной защиты;\n" +
//                "Автоматический учет АЧХ микрофонов и акселерометра;\n</html>");
//        contentInfo.setVerticalAlignment(JLabel.TOP);
//        contentInfo.setForeground(textColor);
//        contentInfo.setFont(new Font("Calibri", Font.BOLD, 13 ));
//        sixthSlide.add(contentInfo);
//
//
//        JLabel subInfo = new JLabel();
//        subInfo.setBounds(400, 180 ,800, 600);
//        subInfo.setText("<html> Система «Шепот-T» обеспечивает:<br>" +
//                "•Автоматические измерения уровней звукового давления тестового сигнала и наведенного им виброускорения в стандартном диапазоне частот в соответствии с требованиями" +
//                " ФСТЭК России и в расширенном от 125 Гц до 8 кГц в 1/1 и 1/3-октавных полосах;<br>" +
//                "•Расчет показателей защищенности выделенных помещений от утечки информации по виброакустическому каналу при заданных нормируемых показателях защищенности информации;<br>" +
//                "•Расчет показателей защищенности выделенных помещений от утечки информации в соответствии с действующими НМД, ключая расчет защищенности при лазерном зондировании;<br>" +
//                "•Облегчение настройки системы защиты выделенных помещений объекта (САЗ) от утечки речевой информации по акустическим и вибрационным каналам;<br>" +
//                "•Формирование и ведение базы данных о результатах выполненных измерений, включающей информацию о месте проведения измерений (объект, помещение, контрольная точка)" +
//                " и о результатах измерений и расчетов в каждой контрольной точке.<br>" +
//                "Комплект поставки:" +
//                "Рабочая укладка со средствами измерений;" +
//                "Генератор акустических сигналов;" +
//                "Акустическая колонка;" +
//                "Кабели, штативы;" +
//                "Рулетка 2м;<br>" +
//                "Комплект программного обеспечения «Шепот-Интерфейс».<br>" +
//                "Технические характеристики:<br>" +
//                "Диапазон измерения звукового давления\t24–132 дБ / 20 мкПа<br>" +
//                "Максимальный уровень звукового давления тестового<br>" +
//                "акустического сигнала в свободном пространстве на расстоянии 1 м от излучателя\tне менее 94 дБ<br>" +
//                "Диапазоны измеряемого виброускорения, дБ (относительно 1x10-6 м/с2 ):<br>" +
//                "    - акселерометром АP98-100\t40÷160<br>" +
//                "    - с акселерометром РСВ 352В\t30÷150<br>" +
//                "Диапазон частот тестового акустического сигнала\t88-12500 Гц<br>" +
//                "Среднее время проведения одного цикла измерений\t3 мин<br>" +
//                "Электропитание\t220+10%-15% В 50± 2 Гц<br>" +
//                "Мощность, потребляемая системой\tне более 40 Вт<br></html>");
//        subInfo.setVerticalAlignment(JLabel.TOP);
//        subInfo.setForeground(textColor);
//        subInfo.setFont(new Font("Calibri", Font.BOLD, 13));
//        sixthSlide.add(subInfo);
//
//    }
//    private void createSeventhSlide() {
//        seventhSlide = new JPanel();
//        seventhSlide.setLayout(null);
//        seventhSlide.setBackground(background);
//        seventhSlide.setBounds(0,0 , 1280, 605);
//
//        JPanel topBar = new JPanel();
//        topBar.setBounds(0, 0 , 1280, 75);
//        topBar.setBackground(btmTopBars);
//
//        JLabel img = new JLabel();
//        img.setBounds(0, 75 ,555, 450);
//        ImageIcon unit = new ImageIcon(".\\assets\\ACA-Shepot.png");
//        img.setVerticalAlignment(JLabel.TOP);
//        img.setIcon(unit);
//        seventhSlide.setLayout(null);
//        seventhSlide.add(img);
//
//        JLabel txt = new JLabel();
//        txt.setText("Шепот для провед. акуст. и виброакуст. изм.");
//        txt.setFont(new Font("Calibri", Font.BOLD, 60 ));
//        txt.setHorizontalTextPosition(JLabel.CENTER);
//        txt.setForeground(textColor);
//        topBar.add(txt);
//        seventhSlide.add(topBar);
//        seventhSlide.repaint();
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(400, 75 ,750, 400);
//        mainInfo.setText("<html> Автоматизированный виброакустический комплекс предназначен" +
//                " для измерений акустических и виброакустических параметров ограждающих" +
//                " и инженерных конструкций выделенных помещений. Полностью реализует методику Гостехкомиссии России.</html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 20 ));
//        seventhSlide.add(mainInfo);
//
//        JLabel main2Info = new JLabel();
//        main2Info.setBounds(400, 180 ,750, 400);
//        main2Info.setText("<html> В состав комплекса включены:\n" +
//                "шумомер (основной измерительный прибор);\n" +
//                "универсальный управляемый генератор - усилитель звукового сигнала с выходной мощностью до 30 Вт;\n" +
//                "акустический излучатель (колонка);\n" +
//                "измерительные микрофоны;\n" +
//                "акселерометр;\n" +
//                "управляющий компьютер;\n" +
//                "управляемый коммутатор входных каналов.\n</html>");
//        main2Info.setVerticalAlignment(JLabel.TOP);
//        main2Info.setForeground(textColor);
//        main2Info.setFont(new Font("Calibri", Font.BOLD, 16 ));
//        seventhSlide.add(main2Info);
//
//        JLabel contentInfo = new JLabel();
//        contentInfo.setBounds(35, 300 ,1200, 450);
//        contentInfo.setText("<html>Комплекс построен на базе прецизионного интегрирующего шумомера Larson&Davis модели 824," +
//                " дополненного необходимыми элементами, обеспечивающими проведение измерений в автоматическом режиме.<br>" +
//                "Большинство компонентов комплекса поставляются с автономным или универсальным электропитанием, остальные" +
//                " (усилитель - генератор) могут поставляться с автономным электропитанием опционно. При проведении измерений" +
//                " микрофоны и акселерометр могут быть отнесены на значительное расстояние от коммутатора (до 1000 м при измерениях" +
//                " на частотах не выше 5 кГц). Длины соединительных кабелей оговариваются при поставке. Все элементы комплекса," +
//                " включая датчики (микрофоны, акселерометр), измерительный интерфейс, имеют калибровочные сертификаты и" +
//                " свидетельства о поверке. Входящий в состав комплекса шумомер Larson&Davis тип 824 введён в Госреестр измерительных приборов." +
//                "Комплекс полностью реализует методику Гостехкомиссии России по проведении акустических и вибрационных замеров" +
//                " ограждающих и инженерных конструкций, позволяя получить готовые результаты расчёта, которые включаются в состав типового протокола измерений." +
//                "Измерения в каждой октавной полосе производятся непрерывно в течение заданного оператором промежутка времени" +
//                " с усреднением результата, что практически полностью исключает искажения результатов случайными громкими" +
//                " звуками или вибрациями (минимум 240 замеров). При измерении фоновых значений акустического или вибрационного" +
//                " сигнала в комплексе реализовано выявление минимальных значений за период измерения, что соответствует методическим" +
//                " требованиям к такого рода измерениям. Результаты замеров и расчётов могут быть сохранены в виде файлов на жёстком" +
//                " диске управляющего компьютера и использованы для последующего применения. Предусмотрен экспорт результатов в формате \"EXCEL 97/2000\".<br>" +
//                "Сохранённые результаты измерения и расчётов могут быть загружены в управляющую программу вновь для внесения оператором" +
//                " изменений с последующим перерасчётом. Это позволяет оперативно оценить количественно необходимые изменения в виброакустических" +
//                " параметрах объекта для выполнения условий защищённости.Дополнительно, комплекс может быть использован для контроля уровня" +
//                " зашумлённости помещений, уровня вибраций различных конструкций и т. д." +
//                "Интерфейс управляющей программы позволяет оператору произвольно устанавливать все варьируемые параметры измерений, выбирать" +
//                " режимы, проводить измерения в полностью автоматическом, или полуавтоматическом режимах." +
//                "Управляющий компьютер подключается к измерительному комплексу через стандартные COM (RS 232) и LPT порты." +
//                " Все необходимые измерения производятся комплексом в автоматическом режиме, включая управление акустическим" +
//                " тест-сигналом и переключение датчиков. Задачей оператора является только правильное размещение датчиков комплекса" +
//                " (микрофонов, акселерометра и акустического излучателя) и ручное включение (при необходимости) системы акустического" +
//                " или виброакустического зашумления по команде комплекса. Расчёт значений защищённости помещения по окончании цикла" +
//                " измерений выполняется также автоматически. Программный модуль расчёта результатов позволяет ручное занесение данных" +
//                " оператором и перерасчёт значений после их занесения или коррекции.<br>" +
//                "Измерения могут проводится при достаточном удалении датчиков от комплекса, поскольку длинна соединительных кабелей" +
//                " может достигать сотен метров, что позволяет выполнить весь цикл исследований без переноса самого комплекса в любом" +
//                " помещении. Наличие у всех составляющих комплекса автономного электропитания увеличивает его мобильность и расширяет сферу применения.<br>" +
//                "Построение программного обеспечения позволяет, с минимальными доработками, адаптировать его к другой" +
//                " модели шумомера, имеющего управление по стыку RS-232.<br></html>");
//        contentInfo.setVerticalAlignment(JLabel.TOP);
//        contentInfo.setForeground(textColor);
//        contentInfo.setFont(new Font("Calibri", Font.BOLD, 12 ));
//        seventhSlide.add(contentInfo);
//
//    }
//    private void createEighthSlide(){
//        eighthSlide = createSlide(".\\assets\\shepot-m1.png", "Шепот-М1");
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(400, 75 ,750, 400);
//        mainInfo.setText("<html> Система Шепот-М1 предназначена для проведения специальных " +
//                "акустических и вибрационных измерений в помещениях с целью оценки их защищенности" +
//                " от утечки речевой информации по акустическому и вибрационному каналам. </html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 20 ));
//        eighthSlide.add(mainInfo);
//
//        JLabel contentInfo = new JLabel();
//        contentInfo.setBounds(400, 180 ,750, 590);
//        contentInfo.setText("<html>Система «Шепот-М1» обеспечивает:<br>" +
//                "•\tавтоматическое измерение уровня звукового давления тестового сигнала вблизи и на удалении от его источника в 7-ми октавных полосах с центральными частотами 125, 250, 500, 1000, 2000, 4000 и 8000 Гц;<br>" +
//                "•\tавтоматические измерения уровня звукового давления тестового сигнала вблизи от его источника и уровня наведенного им виброускорения в 7-ти октавных полосах с центральными частотами 125, 250, 500, 1000, 2000, 4000 и 8000 Гц;<br>" +
//                "•\tавтоматические измерения уровня звукового давления тестового сигнала вблизи и на удалении от его источника в 19 третьоктавных полосах с центральными частотами 125, 160, 200, 250, 315, 400, 500, 630, 800, 1000, 1250, 1600, 2000, 2500, 3150, 4000, 5000, 6300 и 8000 Гц;<br>" +
//                "•\tавтоматические измерения уровня звукового давления тестового сигнала вблизи от его источника и уровня наведенного им виброускорения в 19 третьоктавных полосах с центральными частотами 125, 160, 200, 250, 315, 400, 500, 630, 800, 1000, 1250, 1600, 2000, 2500, 3150, 4000, 5000, 6300 и 8000 Гц;<br>" +
//                "•\tиспользование данных измерений по 5-ти, 6-ти либо 7-ми октавным полосам для расчета показателей защищенности выделенных помещений по виброакустическому каналу утечки речевой информации;<br>" +
//                "•\tформирование и ведение базы данных о результатах выполненных измерений, включающей информацию о месте проведения измерений (объект, помещение, контрольная точка) и о результатах измерений и расчетов в каждой контрольной точке;<br>" +
//                "•\tсоставление отчета по результатам измерений в форме, отвечающей требованиям нормативных документов;<br>" +
//                "•\tавтоматический и/или ручной режим ввода данных для расчета показателей защищенности выделенных помещений по виброакустическому каналу;<br>" +
//                "•\tвозможность перехода на ручное управление аппаратурой системы;<br>" +
//                "•\tустановку параметров проведения измерений для каждого измерительного цикла;<br>" +
//                "•\tввод калибровочных значений измерительных микрофонов и акселерометра, их сохранение и корректировку.<br>" +
//                "•\tформирование акустических сигналов различных видов при использовании звуковой карты ПЭВМ в качестве генератора шумового сигнала.<br></html>");
//        contentInfo.setVerticalAlignment(JLabel.TOP);
//        contentInfo.setForeground(textColor);
//        contentInfo.setFont(new Font("Calibri", Font.BOLD, 13 ));
//        eighthSlide.add(contentInfo);
//
//        JLabel conten2tInfo = new JLabel();
//        conten2tInfo.setBounds(25, 320 ,320, 450);
//        conten2tInfo.setText("<html>Комплект поставки<br>" +
//                "Измерительный блок (шумомер) - 2<br>" +
//                "ICP микрофон - 2<br>" +
//                "ICP-акселерометр - 1<br>" +
//                "Источник калиброванного звукового давления - 1<br>" +
//                "Управляющая ПЭВМ ноутбук - 1<br>" +
//                "Программная оболочка «Шепот-Лайт» - 1<br>" +
//                "Программный модуль «Шепот-Вариант» - 1<br>" +
//                "Колонка акустическая активная «Шелест-М3» - 1<br>" +
//                "Полужесткая транспортная укладка - 1<br>" +
//                "Штатив для громкоговорителя и микрофонов - 3<br></html>");
//        conten2tInfo.setVerticalAlignment(JLabel.TOP);
//        conten2tInfo.setForeground(textColor);
//        conten2tInfo.setFont(new Font("Calibri", Font.BOLD, 15 ));
//        eighthSlide.add(conten2tInfo);
//    }
//    private void createNinethSlide(){
//        ninethSlide = createSlide("", "Шепот-М1");
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(130, 100 ,1000, 600);
//        mainInfo.setText("<html> Технические характеристики<br><br>" +
//                "- Диапазон рабочих частот, Гц - 80 - 11300<br>" +
//                "- Диапазон измерений звукового давления, не менее, дБ (20 мкПа) - 24 - 132<br>" +
//                "- Диапазон измерений виброускорения, не менее, м·с-2 - 2∙10-3 - 200<br>" +
//                "- Погрешность измерений уровня звукового давления и виброускорения, не более, дБ - ± 0,7<br>" +
//                "- Неравномерность частотной характеристики при измерении звукового давления - соответствует шумомерам 1-го класса" +
//                "точности по ГОСТ Р 53188.1-2008<br>" +
//                "- Максимальное звуковое давление тест-сигнала на расстоянии 1 м<br>" +
//                "- от излучателя (интегральное, в полосе частот 80-11300 Гц), не менее, дБ - 106<br>" +
//                "- Нестабильность излучателя тест-сигнала (при измерении в 7 октавных полосах<br>" +
//                "-  с центральными частотами 250, 500, 1000, 2000 и 4000 Гц) за 10 мин, не более, дБ - ±1<br>" +
//                "- Неравномерность АЧХ излучателя тест-сигнала в полосе частот 80 – 11300 Гц<br>" +
//                "- (при измерении в 7 октавных полосах с центральными частотами" +
//                "125, 250, 500, 1000, 2000, 4000 и 8000 Гц), не более,  дБ - ±12<br>" +
//                "- Точность расчета показателей защищенности выделенных помещений" +
//                "по виброакустическому каналу, не хуже - не хуже заданных предельных значений<br>" +
//                "- Напряжение электропитания от сети переменного тока, В - 198 - 242<br>" +
//                "- Частота сети переменного тока, Гц - 50±1<br></html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 20));
//        ninethSlide.add(mainInfo);
//    }
//
//    private void  createlastSlide() {
//        lastSlide = new JPanel();
//        lastSlide.setLayout(null);
//        lastSlide.setBackground(background);
//        lastSlide.setBounds(0,0 , 1280, 605);
//
//        JPanel topBar = new JPanel();
//        topBar.setBounds(0, 0 , 1280, 75);
//        topBar.setBackground(btmTopBars);
//
//        JLabel img = new JLabel();
//        img.setBounds(0, 75 ,555, 450);
//        ImageIcon unit = new ImageIcon(".\\assets\\shepot-rew.png");
//        img.setVerticalAlignment(JLabel.TOP);
//        img.setIcon(unit);
//        lastSlide.setLayout(null);
//        lastSlide.add(img);
//
//        JLabel txt = new JLabel();
//        txt.setText("Система \"ШЕПОТ\" для оценки защищённости выделенных помещений по виброакуст. каналу");
//        txt.setFont(new Font("Calibri", Font.BOLD, 30 ));
//        txt.setHorizontalTextPosition(JLabel.CENTER);
//        txt.setForeground(textColor);
//        topBar.add(txt);
//        lastSlide.add(topBar);
//        lastSlide.repaint();
//
//        JLabel mainInfo = new JLabel();
//        mainInfo.setBounds(400, 75 ,750, 400);
//        mainInfo.setText("<html> Система «Шепот» предназначена для проведения измерений специальных" +
//                " акустических и вибрационных сигналов с целью оценки защищенности помещении от утечки" +
//                " речевой информации по акустическому и вибрационному каналам.</html>");
//        mainInfo.setVerticalAlignment(JLabel.TOP);
//        mainInfo.setForeground(textColor);
//        mainInfo.setFont(new Font("Calibri", Font.BOLD, 20 ));
//        lastSlide.add(mainInfo);
//
//        JLabel contentInfo = new JLabel();
//        contentInfo.setBounds(15, 300 ,306, 450);
//        contentInfo.setText("<html>Преимущества:<br>" +
//                "Наличие двух измерительных каналов, позволяющих выполнять измерения в полностью автоматическом режиме, включая оценку эффективности систем активной защиты (САЗ)<br>" +
//                "Автоматическое выполнение цикла измерений за малое время позволяет оперативно выполнить большое количество измерений и оптимально настраивать систему САЗ<br>" +
//                "Наличие функции автоматического контроля корректности условий измерений<br>" +
//                "Реализована возможность расчета оценки защищенности речевой информации от съема с использованием оптико-электронной аппаратуры дистанционного лазерного зондирования<br>" +
//                "Реализована возможность измерений в октавных полосах с центральными частотами 125, 250, 500, 1000, 2000, 4000, 8000 Гц<br><br></html>");
//        contentInfo.setVerticalAlignment(JLabel.TOP);
//        contentInfo.setForeground(textColor);
//        contentInfo.setFont(new Font("Calibri", Font.BOLD, 12 ));
//        lastSlide.add(contentInfo);
//
//        JLabel content3Info = new JLabel();
//        content3Info.setBounds(400, 200 ,350, 450);
//        content3Info.setText("<html>Основные технические характеристики:<br>" +
//                "Диапазон измеряемого уровня звукового давления и виброускорения" +
//                " тестового сигнала октавных полос с центральными частотами," +
//                "а также 19 третьоктавных  полос с центральными частотами - 250, 500, 1000, 2000 и 4000 Гц" +
//                "от 125 до 8000 Гц<br>" +
//                "Диапазон измерения виброускорения  - от 0,01 до 708 м/с 2<br>" +
//                "Диапазон измерения звукового давления  - от 24 до 132 дБ<br>" +
//                "Максимальное звуковое давление тест-сигнала в<br>" +
//                "свободном пространстве на расстоянии 1 м от излучателя - не менее 106 дБ<br>" +
//                "Электропитание от сети переменного тока напряжением<br>" +
//                "или от автономного источника  постоянного тока  напряжением - 220В 50 Гц " +
//                "24В<br></html>");
//        content3Info.setVerticalAlignment(JLabel.TOP);
//        content3Info.setForeground(textColor);
//        content3Info.setFont(new Font("Calibri", Font.BOLD, 15 ));
//        lastSlide.add(content3Info);
//
//        JLabel subInfo = new JLabel();
//        subInfo.setBounds(800, 200 ,450, 600);
//        subInfo.setText("<html> Сертификаты<br>" +
//                "-  Сертификат об утверждении типа средств измерений военного назначения № 22288<br>" +
//                "-  Сертификат соответствия ФСТЭК России № 643 на систему «Шепот»<br>" +
//                "-  Сертификат соответствия ФСТЭК России № 644 на программу управления «Шепот-Интерфейс»<br>" +
//                "-  Сертификат соответствия № 06.0001.0248 на программное обеспечение<br>" +
//                "-  Свидетельство Федерального агентства по техническому регулированию и метрологии об утверждении типа средств измерений RU.C.36.018.A  №43092 от 5 июля 2011г.<br></html>");
//        subInfo.setVerticalAlignment(JLabel.TOP);
//        subInfo.setForeground(textColor);
//        subInfo.setFont(new Font("Calibri", Font.BOLD, 15));
//        lastSlide.add(subInfo);
//    }
//    private JPanel createSlide(String path, String name){
//        JPanel slide = new JPanel();
//        slide.setLayout(null);
//        slide.setBackground(background);
//        slide.setBounds(0,0 , 1280, 605);
//
//        JPanel topBar = new JPanel();
//        topBar.setBounds(0, 0 , 1280, 75);
//        topBar.setBackground(btmTopBars);
//
//        JLabel img = new JLabel();
//        img.setBounds(0, 75 ,555, 450);
//        ImageIcon unit = new ImageIcon(path);
//        img.setVerticalAlignment(JLabel.TOP);
//        img.setIcon(unit);
//        slide.setLayout(null);
//        slide.add(img);
//
//        JLabel txt = new JLabel();
//        txt.setText(name);
//        txt.setFont(new Font("Calibri", Font.BOLD, 70 ));
//        txt.setHorizontalTextPosition(JLabel.CENTER);
//        txt.setForeground(textColor);
//        topBar.add(txt);
//        slide.add(topBar);
//        slide.repaint();
//        return slide;
//    }
}