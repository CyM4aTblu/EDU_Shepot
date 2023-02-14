import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class TestStudyFrame extends JPanel{
    Color LtPurple = new Color(103, 82, 128);
    Color background = new Color(237, 239, 246);
    Color textColor = new Color(0x6e67a0);
    Color btmTopBars = new Color(193, 197, 220);
    private int rightAnswers;
    int slidesSequence[] = new int[20];
    int currentSlide;
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel welcomeSlide, finalSlide, firstSlide, secondSlide, thirdSlide, founthLide, fifthSlide, sixthSlide, seventhSlide, eighthSlide, ninethSlide;
    private JPanel Slide10, Slide11, Slide12, Slide13, Slide14, Slide15, Slide16, Slide17, Slide18, Slide19, Slide20;
    TestStudyFrame(ActionListener onReturn){
        startTest();
        crd = new CardLayout();
        createComposition();
        createFirstSlide();
        createWelcomeSlide();

// set up for screens panels containers

        slideShow.add("welcome", welcomeSlide);
        slideShow.add("1", firstSlide);
        slideShow.add("2", secondSlide);
        slideShow.add("3", thirdSlide);
        slideShow.add("4", founthLide);
        slideShow.add("5", fifthSlide);
        slideShow.add("6", sixthSlide);
        slideShow.add("7", seventhSlide);
        slideShow.add("8", eighthSlide);
        slideShow.add("9", ninethSlide);
        slideShow.add("10", Slide10);
        slideShow.add("11", Slide11);
        slideShow.add("12", Slide12);
        slideShow.add("13", Slide13);
        slideShow.add("14", Slide14);
        slideShow.add("15", Slide15);
        slideShow.add("16", Slide16);
        slideShow.add("17", Slide17);
        slideShow.add("18", Slide18);
        slideShow.add("19", Slide19);
        slideShow.add("20", Slide20);
        crd.show(slideShow, "welcome");

        returnToMenu.addActionListener(onReturn);
    }
    public void startTest(){
        currentSlide = 0;
        rightAnswers = 0;
        for(int i = 0; i < 20; i++)
        {
            slidesSequence[i] = i + 1;
        }
        //System.out.println(Arrays.toString(slidesSequence));

        Random rand = new Random();

        for (int i = 0; i < slidesSequence.length; i++) {
            int randomIndexToSwap = rand.nextInt(slidesSequence.length);
            int temp = slidesSequence[randomIndexToSwap];
            slidesSequence[randomIndexToSwap] = slidesSequence[i];
            slidesSequence[i] = temp;
        }
        //System.out.println(Arrays.toString(slidesSequence));
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
    private JPanel createSlideWithRadioButtons(String nameofSlide, String question, String texta, String textb, String textc, String textd, String rightAns){
        JPanel slide = createSlide("", nameofSlide, false, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(50, 100, 350, 360);
        instructions.setFont(new Font("Calibri", Font.BOLD, 35));
        instructions.setVerticalAlignment(JLabel.TOP);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>"+question+"</html>");
        slide.add(instructions);

        final Boolean[] isRightSelected = {false};

        JRadioButton a = new JRadioButton("<html>"+ texta +"</html>");
        JRadioButton b = new JRadioButton("<html>"+ textb +"</html>");
        JRadioButton c = new JRadioButton("<html>"+ textc +"</html>");
        JRadioButton d = new JRadioButton("<html>"+ textd +"</html>");

        ButtonGroup group = new ButtonGroup();
        group.add(a);
        group.add(b);
        group.add(c);
        group.add(d);

        AbstractAction action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == a && Objects.equals(rightAns, "a")){
                    isRightSelected[0] = true;
                }
                else if ((e.getSource() == b && Objects.equals(rightAns, "b"))) {
                    isRightSelected[0] = true;
                }
                else if ((e.getSource() == c && Objects.equals(rightAns, "c"))) {
                    isRightSelected[0] = true;
                    //System.out.println("rght");
                }
                else if ((e.getSource() == d && Objects.equals(rightAns, "d"))) {
                    isRightSelected[0] = true;
                    //System.out.println("rght");
                }
                else {
                    isRightSelected[0] = false;
                    //System.out.println("wronk");
                }
            }
        };

        a.setBounds(420, 100, 800, 125);
        a.setFocusable(false);
        a.setIcon(new ImageIcon(".\\assets\\RadioIcon.png"));
        a.setSelectedIcon(new ImageIcon(".\\assets\\RadioIconSelected.png"));
        a.setBackground(background);
        a.setForeground(textColor);
        a.setFont(new Font("Calibri", Font.BOLD, 22));
        a.addActionListener(action);

        b.setBounds(420, 225, 800, 125);
        b.setFocusable(false);
        b.setIcon(new ImageIcon(".\\assets\\RadioIcon.png"));
        b.setSelectedIcon(new ImageIcon(".\\assets\\RadioIconSelected.png"));
        b.setBackground(background);
        b.setForeground(textColor);
        b.setFont(new Font("Calibri", Font.BOLD, 22));
        b.addActionListener(action);

        c.setBounds(420, 350, 800, 125);
        c.setFocusable(false);
        c.setIcon(new ImageIcon(".\\assets\\RadioIcon.png"));
        c.setSelectedIcon(new ImageIcon(".\\assets\\RadioIconSelected.png"));
        c.setBackground(background);
        c.setForeground(textColor);
        c.setFont(new Font("Calibri", Font.BOLD, 22));
        c.addActionListener(action);

        d.setBounds(420, 475, 800, 125);
        d.setFocusable(false);
        d.setIcon(new ImageIcon(".\\assets\\RadioIcon.png"));
        d.setSelectedIcon(new ImageIcon(".\\assets\\RadioIconSelected.png"));
        d.setBackground(background);
        d.setForeground(textColor);
        d.setFont(new Font("Calibri", Font.BOLD, 22));
        d.addActionListener(action);

        slide.add(a);
        slide.add(b);
        if(!Objects.equals(textc, ""))
        {
            slide.add(c);
        }
        if(!Objects.equals(textd, ""))
        {
            slide.add(d);
        }


        JButton btn = new JButton("<html>>></html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 60));
        btn.setForeground(textColor);
        btn.setBounds(50, 450, 300, 100);
        btn.setBackground(btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isRightSelected[0]){
                    rightAnswers++;
                }
                System.out.println(rightAnswers);
                if(currentSlide != 19)
                {
                    currentSlide++;
                    crd.show(slideShow, Integer.toString(slidesSequence[currentSlide])); //TODO:Uncomment
                }
                else {
                    createFinalSlide();
                    slideShow.add("final", finalSlide);
                    crd.show(slideShow, "final");
                }
            }
        });
        slide.add(btn);

        return slide;
    }
    int getGrade(){
        if (rightAnswers == 20)
        {
            return 5;
        }
        if(rightAnswers > 15)
        {
            return 4;
        }
        if(rightAnswers > 11)
        {
            return 3;
        }
        return 2;
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

//        ImageIcon nxt = new ImageIcon(".\\assets\\ArrowNextPRPL.png");
//        JButton nextSlide = new JButton(nxt);
//        nextSlide.setFocusable(false);
//        nextSlide.setBounds(680, 5, 65, 65);
//        nextSlide.addActionListener(e -> crd.next(slideShow));
//        nextSlide.setContentAreaFilled(false);
//        nextSlide.setFocusPainted(false);
//        nextSlide.setBorderPainted(false);
//        bottomNavBar.add(nextSlide);
//
//        ImageIcon prv = new ImageIcon(".\\assets\\ArrowBackPRPL.png");
//        JButton prevSlide = new JButton(prv);
//        prevSlide.setFocusable(false);
//        prevSlide.setBounds(550, 5, 65, 65);
//        prevSlide.addActionListener(e -> crd.previous(slideShow));
//        prevSlide.setContentAreaFilled(false);
//        prevSlide.setFocusPainted(false);
//        prevSlide.setBorderPainted(false);
//        bottomNavBar.add(prevSlide);

    }
    private void createWelcomeSlide() {
        welcomeSlide = createSlide("", "Тестирование", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(100, 100, 700, 500);
        instructions.setFont(new Font("Calibri", Font.BOLD, 30));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>   Данное тестирование проверяет полученные пользователем знания при ознакомлении с предыдущими секциями тренажера." +
                " Следующие вопросы могут иметь как один, так и несколько вариантов ответа. Всего в тесте 20 вопросов, финальный балл выставляется в зависимости от количества верных ответов:<br>" +
                "5 – 20 верных ответов;<br>" +
                "4 – не менее 16 верных ответов;<br>" +
                "3 – не менее 12 верных ответов;<br>" +
                "2 – менее 12 верных ответов\n<br>Для начала нажимте кнопку \"Начать теситирование\"</html>");
        welcomeSlide.add(instructions);

        JButton btn = new JButton("<html>Начать теситирование</html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 40));
        btn.setForeground(textColor);
        btn.setBounds(850, 300, 350, 100);
        btn.setBackground(btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crd.show(slideShow, Integer.toString(slidesSequence[currentSlide])); //TODO:Uncomment
            }
        });
        welcomeSlide.add(btn);
    }
    private void createFinalSlide() {
        finalSlide=createSlide("", "Результаты", false, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(100, 100, 1000, 250);
        instructions.setFont(new Font("Calibri", Font.BOLD, 45));
        instructions.setForeground(textColor);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html> Вы закончили тестировние и смогли набрать " + Integer.toString(rightAnswers) +
                " баллов из 20 возможных, что соответствует оценке " + Integer.toString(getGrade()) +"</html>");
        finalSlide.add(instructions);

        JButton btn = new JButton("<html>Пройти теситирование заново</html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 37));
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setForeground(textColor);
        btn.setBounds(440, 350, 400, 130);
        btn.setBackground(btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTest();
                createFirstSlide();
                crd.show(slideShow, Integer.toString(slidesSequence[0])); //TODO:Uncomment
            }
        });
        finalSlide.add(btn);

    }
    private void createFirstSlide() {
        firstSlide = createSlideWithRadioButtons("Вопрос#1","Что необходимо сделать до начала измерений?",
                "А) Подключить генератор шумовых помех к акустическому излучателю и к коммутатору, подключить микрофоны к коммутатору по каналам 1 и 2" +
                " соответственно, откалибровать оборудование, подключить ПЭВМ к коммутатору через разъем USB", "Б) Подключить генератор" +
                " шумовых помех к акустическому излучателю, подключить микрофоны к коммутатору по каналам 1 и 2 соответственно, подключить ПЭВМ" +
                " к коммутатору через разъем USB, запустить СПО на ПЭВМ", "В) Подключить генератор шумовых помех к акустическому" +
                " излучателю и к коммутатору, подключить микрофоны к коммутатору по каналам 1 и 2 соответственно, откалибровать оборудование, подключить" +
                " ПЭВМ к коммутатору через разъем USB, запустить и настроить СПО на ПЭВМ", "Г) Подключить генератор шумовых помех к" +
                " акустическому излучателю и к коммутатору, подключить микрофоны к коммутатору по каналам 1 и 2 соответственно, откалибровать оборудование", "c");

        secondSlide = createSlideWithRadioButtons("Вопрос#2","Каким образом происходит калибровка шумомера?",
                "А) Калибруется посредством создания в звуковой камере калибратора давления до 94 дБ, используя подключенный микрофон в цепи системы «излучатель – генератор»",
                "Б) Калибровка шумомера не происходит", "В) Калибруется посредством установления в звуковой камере калибратора максимально возможное звуковое давление",
                "Г) Калибруется посредством создания в звуковой камере калибратора давления 94 или 114 дБ, используя подключенный микрофон в цепи системы «излучатель – генератор»", "d");

        thirdSlide = createSlideWithRadioButtons("Вопрос#3","Какие мероприятия необходимо проводить каждый раз перед началом измерений?",
                "A) Калибровка микрофона, измеряющего шум до измеряемой ограждающей конструкции", "Б) Калибровка всех микрофонов, использующихся в измерениях"
                , "В) Калибровка микрофона, измеряющий шум до ограждающей конструкции, и калибровка шумомера вместе с настройкой программного обеспечения"
                , "Г) Калибровка всего микрофонов и настройка шумомера вместе с программным обеспечением", "c");

        founthLide = createSlideWithRadioButtons("Вопрос#4","По какому разъему подключается генератор шума «Шорох-2МИ» к коммутатору?",
                "А) USB", "Б) Канал 1", "В) Канал 2", "Г) Управление", "d");

        fifthSlide = createSlideWithRadioButtons("Вопрос#5","Какой тип микрофонов используется в измерениях?","А) Динамический микрофон (электродинамический)","Б)" +
                " Конденсаторный предполяризованный микрофон (ICP)","В) Пьезомикрофон","Г) Ламповый конденсаторный микрофон","b");

        sixthSlide = createSlideWithRadioButtons("Вопрос#6","Для чего использует приемник?","А) Для преобразования принятого аналогового сигнала в радиосигнал ","Б) " +
                "Для преобразования принятого радиосигнала в аналоговый","","","b");

        seventhSlide = createSlideWithRadioButtons("Вопрос#7","На каком расстоянии должны быть расположены микрофон и акселерометр от ограждающей конструкции?","А) Микрофон" +
                " должен быть на расстоянии 0,5 м, акселерометр же должен быть прикреплен к конструкции","Б) Микрофон и акселерометр должны быть на расстоянии 0,5 м соответственно от" +
                " ограждающей конструкции","В) Микрофон должен быть на расстоянии 1,5 м, акселерометр же должен быть прикреплен к конструкции","","a");

        eighthSlide = createSlideWithRadioButtons("Вопрос#8","Для чего НЕ используется СПО «Шепот-Интерфейс»?","А) Создания отчетов на основе полученных измерений",
                "Б) Для непосредственных измерений уровней звука","В) Калибровки шумомера и микрофона","Г) Настройка времени измерений и значений «сигнал/шум»","b");//TODO:multiple answers

        ninethSlide = createSlideWithRadioButtons("Вопрос#9","На какой высоте устанавливаются микрофоны?","А) На высоте 0,5 м","Б) На высоте 1 м","В) На высоте 1,5 м","","c");

        Slide10 = createSlideWithRadioButtons("Вопрос#10","С помощью какого микрофона измеряется звуковой фон?","А) С помощью микрофона 1 (стоящего перед ограждением)","Б)" +
                " С помощью микрофона 2 (стоящего после ограждения)","","","b");

        Slide11 = createSlideWithRadioButtons("Вопрос#11","На основе какого преобразования происходит работа синтезатора акустического излучателя?","А) Цифроаналоговое","Б) " +
                "Аналого-цифровое","","","a");

        Slide12 = createSlideWithRadioButtons("Вопрос#12","За что отвечает гетеродин в генераторе шума?","А) За подачу опорного" +
                " сигнала для перемножения при преобразовании звуковых частот в радиочастоты","Б) За повышение линейного сигнала до уровня напряжения линейного входа",
                "В) За изменение и исправления спектральной плотности сигнала для его дальнейшего перевода из звуковых частот в радиочастоты изменение и исправления спектральной плотности сигнала для его дальнейшего перевода из звуковых частот в радиочастоты","","a");

        Slide13 = createSlideWithRadioButtons("Вопрос#13","Когда включается второй микрофон, стоящей за ограждающей конструкцией?","А) Во время измерений, пока работает первый микрофон","Б)" +
                " Вместе с первым микрофоном","В) После окончания работы первого микрофона","","c");

        Slide14 = createSlideWithRadioButtons("Вопрос#14","На основе какого преобразования происходит работа средства измерения (шумомера) ?","А) Цифроаналоговое","Б) Аналого-цифровое",
                "","","b");

        Slide15 = createSlideWithRadioButtons("Вопрос#15","Какой расстояние должно быть между ограждением и акустическим излучателем?","А) 0,5 м","Б) 1 м","В) 1,5 м","","c");

        Slide16 = createSlideWithRadioButtons("Вопрос#16","Для чего используется приемник?","А) Для преобразования принятого цифрового сигнала, уже сформированного в радиосигнал, в аналоговый",
                "Б) Для преобразования принятого аналогового сигнала в цифровой сигнал и формирования радиосигнала","","","b");

        Slide17 = createSlideWithRadioButtons("Вопрос#17","Что делает акселерометр?","А) Акселерометр преобразует виброускорения в твердой среде в электрический сигнал, в дальнейшем посылая их в коммутатор",
                "Б) Акселерометр преобразует механическую нагрузку в окружающей среде в электрический сигнал","","","a");

        Slide18 = createSlideWithRadioButtons("Вопрос#18","Какой режим средства измерения «Larson&Davis 824» наиболее подходит для акустических и виброакустических измерений комплекса «Шепот»?",
                "А) LOG&ISM","Б) SSA","В) RTA&SLS","","b");//TODO:multiple answers

        Slide19 = createSlideWithRadioButtons("Вопрос#19","На каких центральных частотах НЕ может работать генератор шума «Шорох-2МИ», Гц?",
                "А) 250","Б) 500","В)2000","Г) 8000","d");

        Slide20 = createSlideWithRadioButtons("Вопрос#20","Что такое пьезоэлемент?","А) датчик из цирконата или титаната" +
                        " свинца или монокристалл, определенной формы и ориентации относительно кристаллографических осей, с помощью которого механическая энергия преобразуется в электрическую, а электрическая в механическую",
                "Б) датчик из цирконата или титаната свинца или монокристалл, определенной формы и ориентации относительно кристаллографических осей, с помощью которого только механическая энергия преобразуется в электрическую",
                "В) датчик из цирконата или титаната лития или монокристалл, приводится в движение посредством ускорения и таким образом меняет  вокруг себя потенциал электрического поля","","a");

        //= createSlideWithRadioButtons("Вопрос#","","","","","","");
        //"<html></html>", "<html></html>", "<html></html>", "<html></html>", "<html></html>"
    }
}
