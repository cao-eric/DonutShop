//Made by Eric Cao
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DonutShop implements ActionListener {

    static Item[] donutsArray = new Item[12];
    static Item[] kolacheArray = new Item[4];
    static Item[] drinkArray = new Item[5];
    static Item[] pastryArray = new Item[6];

    JFrame frame;

    JLabel[] labelArray = new JLabel[10]; //displays for our menu
    JLabel label0, label1, label2, label3, label4, label5; //for sub menus
    JLabel label6, label7, label8, label9; //for total menu
    JLabel totalPrice;

    JTextField[] textFieldArray = new JTextField[6]; //for customers to enter in the number of items they want
    JTextField textField0, textField1, textField2, textField3, textField4, textField5;
    JTextArea textArea0, textArea1, textArea2, textArea3;
    JScrollPane sp0, sp1, sp2, sp3;

    JButton[] mainButtons = new JButton[5]; //array for main menu buttons
    JButton donutMain, pastryMain, kolacheMain, drinkMain, cart; //main menu buttons

    JButton[] donutButtons = new JButton[12]; //Buttons for donuts below
    JButton glaze, chocIce, vanIce, strawIce, chocSpr, vanSpr,
            strawSpr, pSugar, cSugar, wSugar, creamFill, bavFill;

    JButton[] kolacheButtons = new JButton[4]; //buttons for kolaches
    JButton plainK, scK, jalK, hamK;

    JButton[] drinkButtons = new JButton[5];
    JButton smCofButton, medCofButton, lrgCofButton, pepsiButton, spriteButton;

    JButton[] pastryButtons = new JButton[6];
    JButton cRollButton, glazeTwButton, chocTwButton, fBarButton, appFritterButton, bearCButton;

    JButton backButton, submitButton;
    JPanel mPanel, donutPanel, labelPanel, kSetPanel, drinkPanel, pastryPanel, totalPanel;

    Font setFont = new Font("Times New Roman", Font.BOLD, 30);
    Font twentyFiveFont = new Font("Times New Roman", Font.BOLD, 25);
    Font mainMenuFont = new Font("Times New Roman", Font.BOLD, 40);



    DonutShop(){
        Item glazeDonut = new Item("Glaze", .95f, 0);
        Item chocDonut = new Item("Chocolate Iced", 1, 0);
        Item vanDonut = new Item("Vanilla Iced", 1, 0);
        Item strawDonut = new Item("Strawberry Iced", 1, 0);
        Item chocSprDonut = new Item("Chocolate Sprinkles", 1, 0);
        Item vanSprDonut = new Item("Vanilla Sprinkles", 1, 0);
        Item strawSprDonut = new Item("Strawberry Sprinkles", 1, 0);
        Item pSugarDonut = new Item("Plain Sugar", 1, 0);
        Item cSugarDonut = new Item("Cinnamon Sugar", 1, 0);
        Item wSugarDonut = new Item("Powdered Sugar", 1, 0);
        Item creamFDonut = new Item("Cream Filled", 1, 0);
        Item bavFDonut = new Item("Bavarian Filled", 1, 0);

        donutsArray[0] = glazeDonut;
        donutsArray[1] = chocDonut;
        donutsArray[2] = vanDonut;
        donutsArray[3] = strawDonut;
        donutsArray[4] = chocSprDonut;
        donutsArray[5] = vanSprDonut;
        donutsArray[6] = strawSprDonut;
        donutsArray[7] = pSugarDonut;
        donutsArray[8] = cSugarDonut;
        donutsArray[9] = wSugarDonut;
        donutsArray[10] = creamFDonut;
        donutsArray[11] = bavFDonut;

        //Item array for Kolaches, initialized
        Item plainKolache = new Item("Plain Kolache", 1.85, 0);
        Item scKolache = new Item("Sausage and Cheese Kolache", 1.85, 0);
        Item jalKolache = new Item("SC and Jalapeno Kolache", 1.85, 0);
        Item hamKolache = new Item("Ham and Cheese Kolache", 1.85, 0);

        kolacheArray[0] = plainKolache;
        kolacheArray[1] = scKolache;
        kolacheArray[2] = jalKolache;
        kolacheArray[3] = hamKolache;

        Item smCoffee = new Item("Small Coffee", 1.65, 0);
        Item medCoffee = new Item("Medium Coffee", 1.95, 0);
        Item larCoffee = new Item("Large Coffee", 2.20, 0);
        Item pepsi = new Item("Pepsi Bottle", 2, 0);
        Item sprite = new Item("Sprite Bottle", 2, 0);

        drinkArray[0] = smCoffee;
        drinkArray[1] = medCoffee;
        drinkArray[2] = larCoffee;
        drinkArray[3] = pepsi;
        drinkArray[4] = sprite;

        Item cinnamonRoll = new Item("Cinnamon Roll", 1.85, 0);
        Item glazeTwist = new Item("Glaze Twist", 1.85, 0);
        Item chocTwist = new Item("Chocolate Twist", 1.85, 0);
        Item filledBar = new Item("Filled Bar", 1.85, 0);
        Item appleFritter = new Item("Apple Fritter", 1.85, 0);
        Item bearClaw = new Item("Bear Claw", 1.85, 0);

        pastryArray[0] = cinnamonRoll;
        pastryArray[1] = glazeTwist;
        pastryArray[2] = chocTwist;
        pastryArray[3] = filledBar;
        pastryArray[4] = appleFritter;
        pastryArray[5] = bearClaw;


        frame = new JFrame("Shipley"); //Creates frame with Calculator title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes when window is closed
        frame.setSize(800, 650); //width x height of frame
        frame.setLayout(null); //no layout

        //initializes main menu buttons with image
        donutMain = new JButton("Donuts");
        ImageIcon donutImage = new ImageIcon("images/donutIcon.png");
        donutMain.setIcon(donutImage);
        donutMain.setHorizontalTextPosition(JButton.CENTER);
        donutMain.setVerticalTextPosition(JButton.BOTTOM);

        pastryMain = new JButton("Pastries");
        ImageIcon pastryImage = new ImageIcon("images/pastryIcon.png");
        pastryMain.setIcon(pastryImage);
        pastryMain.setHorizontalTextPosition(JButton.CENTER);
        pastryMain.setVerticalTextPosition(JButton.BOTTOM);

        kolacheMain = new JButton("Kolaches");
        ImageIcon kolacheImage = new ImageIcon("images/kolacheIcon.png");
        kolacheMain.setIcon(kolacheImage);
        kolacheMain.setHorizontalTextPosition(JButton.CENTER);
        kolacheMain.setVerticalTextPosition(JButton.BOTTOM);

        drinkMain = new JButton("Drinks");
        ImageIcon drinkImage = new ImageIcon("images/drinksIcon.png");
        drinkMain.setIcon(drinkImage);
        drinkMain.setHorizontalTextPosition(JButton.CENTER);
        drinkMain.setVerticalTextPosition(JButton.BOTTOM);

        cart = new JButton();
        ImageIcon cartImage = new ImageIcon("images/cartIcon.png");
        cart.setIcon(cartImage);

        mainButtons[0] = donutMain;
        mainButtons[1] = pastryMain;
        mainButtons[2] = kolacheMain;
        mainButtons[3] = drinkMain;
        mainButtons[4] = cart;

        //gives main menu button attributes
        for(int x = 0; x < 5; x++){
            mainButtons[x].addActionListener(this); //each button now has action listener
            mainButtons[x].setFont(mainMenuFont); //sets the font
            mainButtons[x].setFocusable(false); //removes outline around buttons when clicked
        }

        cart.setBounds(650, 5, 100, 70); //adds cart button to top right

        //initializes panel for main menu
        mPanel = new JPanel();
        mPanel.setBounds(5, 100, 775, 500);
        mPanel.setLayout(new GridLayout(2, 2, 10, 10));
        mPanel.setBackground(Color.LIGHT_GRAY);

        //adds 4 sections to panel
        mPanel.add(donutMain);
        mPanel.add(pastryMain);
        mPanel.add(kolacheMain);
        mPanel.add(drinkMain);


        //initializes back button
        backButton = new JButton();
        backButton.setBounds(5, 5, 100, 70); //adds cart button to top left
        ImageIcon backImage = new ImageIcon("images/backIcon.png");
        backButton.setIcon(backImage);
        backButton.addActionListener(this); //each button now has action listener
        backButton.setFocusable(false); //removes outline around buttons when clicked
        backButton.setVisible(false);

        //initializes submit button
        submitButton = new JButton("Submit Order");
        submitButton.setBounds(590, 480, 150, 70); //adds submit button to bottom right
        submitButton.addActionListener(this); //each button now has action listener
        submitButton.setFocusable(false); //removes outline around buttons when clicked
        submitButton.setVisible(false);

        //initializes panel for subsections
        labelPanel = new JPanel(); //panel for labels
        labelPanel.setBounds(5, 100, 500, 500);
        labelPanel.setLayout(new GridLayout(6, 1, 10, 10)); //6x1 grid for labels (one column)
        labelPanel.setBackground(Color.LIGHT_GRAY);

        label0 = new JLabel(""); //initializes label and adds to array
        label1 = new JLabel("");
        label2 = new JLabel("");
        label3 = new JLabel("");
        label4 = new JLabel("");
        label5 = new JLabel("");
        label6 = new JLabel("");
        label7 = new JLabel("");
        label8 = new JLabel("");
        label9 = new JLabel("");
        totalPrice = new JLabel("");

        labelArray[0] = label0;
        labelArray[1] = label1;
        labelArray[2] = label2;
        labelArray[3] = label3;
        labelArray[4] = label4;
        labelArray[5] = label5;
        labelArray[6] = label6;
        labelArray[7] = label7;
        labelArray[8] = label8;
        labelArray[9] = label9;


        kSetPanel = new JPanel(); //panels for setting quantity
        kSetPanel.setBounds(530, 100, 250, 500);
        kSetPanel.setLayout(new GridLayout(6, 2, 10, 10)); //1 column for textbox, other for set
        kSetPanel.setBackground(Color.LIGHT_GRAY);

        textField0 = new JTextField(); //initializes text fields
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();

        textFieldArray[0] = textField0;
        textFieldArray[1] = textField1;
        textFieldArray[2] = textField2;
        textFieldArray[3] = textField3;
        textFieldArray[4] = textField4;
        textFieldArray[5] = textField5;

        for(int x = 0; x < 6; x++){
            labelArray[x].setFont(setFont);
            textFieldArray[x].setFont(setFont);
            labelPanel.add(labelArray[x]);
        }

        label6.setFont(setFont);
        label7.setFont(setFont);
        label8.setFont(setFont);
        label9.setFont(setFont);
        totalPrice.setFont(twentyFiveFont);
        totalPrice.setBounds(590, 400, 200, 100); //adds cart button to top left
        totalPrice.setVisible(false);

        //kolache buttons
        plainK = new JButton("Save");
        scK = new JButton("Save");
        jalK = new JButton("Save");
        hamK = new JButton("Save");

        kolacheButtons[0] = plainK;
        kolacheButtons[1] = scK;
        kolacheButtons[2] = jalK;
        kolacheButtons[3] = hamK;


        //initializes donut buttons
        glaze = new JButton("Save");
        chocIce = new JButton("Save");
        vanIce = new JButton("Save");
        strawIce = new JButton("Save");
        chocSpr = new JButton("Save");
        vanSpr = new JButton("Save");
        strawSpr = new JButton("Strawberry Sprinkle");
        pSugar = new JButton("Plain Sugar");
        cSugar = new JButton("Cinnamon Sugar");
        wSugar = new JButton("Powdered Sugar");
        creamFill = new JButton("Cream Filled");
        bavFill = new JButton("Bavarian Filled");

        donutButtons[0] = glaze;
        donutButtons[1] = chocIce;
        donutButtons[2] = vanIce;
        donutButtons[3] = strawIce;
        donutButtons[4] = chocSpr;
        donutButtons[5] = vanSpr;
        donutButtons[6] = strawSpr;
        donutButtons[7] = pSugar;
        donutButtons[8] = cSugar;
        donutButtons[9] = wSugar;
        donutButtons[10] = creamFill;
        donutButtons[11] = bavFill;

        //donut set panel
        donutPanel = new JPanel();
        donutPanel.setBounds(530, 100, 250, 500);
        donutPanel.setLayout(new GridLayout(6, 2, 10, 10)); //1 column for textbox, other for set
        donutPanel.setBackground(Color.LIGHT_GRAY);

        //drink buttons
        smCofButton = new JButton("Save");
        medCofButton = new JButton("Save");
        lrgCofButton = new JButton("Save");
        pepsiButton = new JButton("Save");
        spriteButton = new JButton("Save");

        drinkButtons[0] = smCofButton;
        drinkButtons[1] = medCofButton;
        drinkButtons[2] = lrgCofButton;
        drinkButtons[3] = pepsiButton;
        drinkButtons[4] = spriteButton;


        //drink set panel
        drinkPanel = new JPanel();
        drinkPanel.setBounds(530, 100, 250, 500);
        drinkPanel.setLayout(new GridLayout(6, 2, 10, 10)); //1 column for text box, other for set
        drinkPanel.setBackground(Color.LIGHT_GRAY);

        //pastry buttons
        cRollButton = new JButton("Save");
        glazeTwButton = new JButton("Save");
        chocTwButton = new JButton("Save");
        fBarButton = new JButton("Save");
        appFritterButton = new JButton("Save");
        bearCButton = new JButton("Save");

        pastryButtons[0] = cRollButton;
        pastryButtons[1] = glazeTwButton;
        pastryButtons[2] = chocTwButton;
        pastryButtons[3] = fBarButton;
        pastryButtons[4] = appFritterButton;
        pastryButtons[5] = bearCButton;

        //pastry set panel
        pastryPanel = new JPanel();
        pastryPanel.setBounds(530, 100, 250, 500);
        pastryPanel.setLayout(new GridLayout(6, 2, 10, 10)); //1 column for text box, other for set
        pastryPanel.setBackground(Color.LIGHT_GRAY);


        //total panel for cart
        totalPanel = new JPanel();
        totalPanel.setBounds(5, 100, 500, 500);
        totalPanel.setLayout(new GridLayout(8, 1, 10, 10)); //1 column for text box, other for set
        totalPanel.setBackground(Color.LIGHT_GRAY);

        textArea0 = new JTextArea("");
        textArea0.setBounds(5, 100, 100, 300);
        textArea0.setLayout(null);
        textArea0.setEditable(false);
        sp0 = new JScrollPane(textArea0);

        textArea1 = new JTextArea("");
        textArea1.setBounds(5, 100, 100, 300);
        textArea1.setLayout(null);
        textArea1.setEditable(false);
        sp1 = new JScrollPane(textArea1);

        textArea2 = new JTextArea("");
        textArea2.setBounds(5, 100, 100, 300);
        textArea2.setLayout(null);
        textArea2.setEditable(false);
        sp2 = new JScrollPane(textArea2);

        textArea3 = new JTextArea("");
        textArea3.setBounds(5, 100, 100, 300);
        textArea3.setLayout(null);
        textArea3.setEditable(false);
        sp3 = new JScrollPane(textArea3);


        //Adding things to the frame
        frame.add(cart);
        frame.add(backButton);
        frame.add(submitButton);
        frame.add(totalPrice);
        frame.add(mPanel);


        frame.add(labelPanel);
        frame.add(donutPanel); //donut set panel
        frame.add(kSetPanel); //kolache set panel
        frame.add(drinkPanel); //drink set panel
        frame.add(pastryPanel); //pastry set panel
        frame.add(totalPanel); //total cart panel
        labelPanel.setVisible(false);
        kSetPanel.setVisible(false);
        donutPanel.setVisible(false);
        drinkPanel.setVisible(false);
        pastryPanel.setVisible(false);
        totalPanel.setVisible(false);

        frame.setVisible(true);

        //gives donut buttons attributes
        for(int x = 0; x < 12; x++){
            donutButtons[x].addActionListener(this); //each button now has action listener
            donutButtons[x].setFont(setFont); //sets the font
            donutButtons[x].setFocusable(false); //removes outline around buttons when clicked
        }

        //gives kolache buttons attributes
        for(int x = 0; x < 4; x++){
            kolacheButtons[x].addActionListener(this); //each button now has action listener
            kolacheButtons[x].setFont(setFont); //sets the font
            kolacheButtons[x].setFocusable(false); //removes outline around buttons when clicked
        }

        //gives drink buttons attributes
        for(int x = 0; x < 5; x++){
            drinkButtons[x].addActionListener(this); //each button now has action listener
            drinkButtons[x].setFont(setFont); //sets the font
            drinkButtons[x].setFocusable(false); //removes outline around buttons when clicked
        }

        //gives drink buttons attributes
        for(int x = 0; x < 6; x++){
            pastryButtons[x].addActionListener(this); //each button now has action listener
            pastryButtons[x].setFont(setFont); //sets the font
            pastryButtons[x].setFocusable(false); //removes outline around buttons when clicked
        }

    }

    static int quantityCalc(Item[] itemArray){
        int total = 0;
        for(int x = 0; x < itemArray.length; x++){
            total += itemArray[x].quantity;
        }
        return total;
    }

    static String itemList(Item[] itemArray){
        String str = "";
        for(int x = 0; x < itemArray.length; x++){
            if (itemArray[x].quantity > 0){
                String sub = itemArray[x].name + "\t\tX" + itemArray[x].quantity;
                str = str + sub + "\n";
            }
        }
        return str;
    }

    static double priceCalc(){
        double total = 0;
        for(int x = 0; x < donutsArray.length; x++){
            total += donutsArray[x].quantity * donutsArray[x].price;
        }
        for(int x = 0; x < pastryArray.length; x++){
            total += pastryArray[x].quantity * pastryArray[x].price;
        }
        for(int x = 0; x < kolacheArray.length; x++){
            total += kolacheArray[x].quantity * kolacheArray[x].price;
        }
        for(int x = 0; x < drinkArray.length; x++){
            total += drinkArray[x].quantity * drinkArray[x].price;
        }

        return total;
    }

    static void wipeOrder(){
        for(int x = 0; x < donutsArray.length; x++){
            donutsArray[x].quantity = 0;
        }
        for(int x = 0; x < pastryArray.length; x++){
            pastryArray[x].quantity = 0;
        }
        for(int x = 0; x < kolacheArray.length; x++){
            kolacheArray[x].quantity = 0;
        }
        for(int x = 0; x < drinkArray.length; x++){
            drinkArray[x].quantity = 0;
        }
    }
    public static void main(String[] args){
        DonutShop shipley = new DonutShop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == donutMain) {
            //Configures donut set panel 1
            donutPanel.add(textField0);
            donutPanel.add(glaze);
            donutPanel.add(textField1);
            donutPanel.add(chocIce);
            donutPanel.add(textField2);
            donutPanel.add(vanIce);
            donutPanel.add(textField3);
            donutPanel.add(strawIce);
            donutPanel.add(textField4);
            donutPanel.add(chocSpr);
            donutPanel.add(textField5);
            donutPanel.add(vanSpr);

            mPanel.setVisible(false); //exit from main menu
            donutPanel.setVisible(true); //label and set button visible
            labelPanel.setVisible(true);
            backButton.setVisible(true); //back button exists

            //set labels
            label0.setText("Glaze Donut $.90");
            label1.setText("Chocolate Iced $1.00");
            label2.setText("Vanilla Iced $1.00");
            label3.setText("Strawberry Iced $1.00");
            label4.setText("Chocolate Sprinkles $1.00");
            label5.setText("Vanilla Sprinkles $1.00");

            //set textfields
            textField0.setText(String.valueOf(donutsArray[0].quantity));
            textField1.setText(String.valueOf(donutsArray[1].quantity));
            textField2.setText(String.valueOf(donutsArray[2].quantity));
            textField3.setText(String.valueOf(donutsArray[3].quantity));
            textField4.setText(String.valueOf(donutsArray[4].quantity));
            textField5.setText(String.valueOf(donutsArray[5].quantity));
        }
        if(e.getSource() == glaze){
            donutsArray[0].quantity = Integer.parseInt(textField0.getText()); //saves number of glaze
            System.out.println(donutsArray[0].quantity);
        }
        if(e.getSource() == chocIce){
            donutsArray[1].quantity = Integer.parseInt(textField1.getText()); //saves number of choc iced
            System.out.println(donutsArray[1].quantity);
        }
        if(e.getSource() == vanIce){
            donutsArray[2].quantity = Integer.parseInt(textField2.getText()); //saves number of vanilla iced
            System.out.println(donutsArray[2].quantity);
        }
        if(e.getSource() == strawIce){
            donutsArray[3].quantity = Integer.parseInt(textField3.getText()); //saves number of strawberry iced
            System.out.println(donutsArray[3].quantity);
        }
        if(e.getSource() == chocSpr){
            donutsArray[4].quantity = Integer.parseInt(textField4.getText()); //saves number of choc sprinkles
            System.out.println(donutsArray[4].quantity);
        }
        if(e.getSource() == vanSpr){
            donutsArray[5].quantity = Integer.parseInt(textField5.getText()); //saves number of van sprinkles
            System.out.println(donutsArray[5].quantity);
        }

        if (e.getSource() == kolacheMain) {
            //configures the kolache set panel
            kSetPanel.add(textField0);
            kSetPanel.add(plainK);
            kSetPanel.add(textField1);
            kSetPanel.add(scK);
            kSetPanel.add(textField2);
            kSetPanel.add(jalK);
            kSetPanel.add(textField3);
            kSetPanel.add(hamK);

            mPanel.setVisible(false); //exit from main menu
            backButton.setVisible(true); //back button exists
            labelPanel.setVisible(true); //label and set button visible
            kSetPanel.setVisible(true);

            //sets labels
            label0.setText("Plain Kolaches $1.85");
            label1.setText("Sausage and Cheese Kolaches $1.85");
            label2.setText("SC and Jalapeno Kolaches $1.85");
            label3.setText("Ham and Cheese Kolaches $1.85");
            label4.setText("");
            label5.setText("");


            //sets textfields
            textField0.setText(String.valueOf(kolacheArray[0].quantity));
            textField1.setText(String.valueOf(kolacheArray[1].quantity));
            textField2.setText(String.valueOf(kolacheArray[2].quantity));
            textField3.setText(String.valueOf(kolacheArray[3].quantity));
        }
        if (e.getSource() == plainK) {
            kolacheArray[0].quantity = Integer.parseInt(textField0.getText()); //saves number of plain kolaches
            System.out.println(kolacheArray[0].quantity);
        }
        if (e.getSource() == scK) {
            kolacheArray[1].quantity = Integer.parseInt(textField1.getText()); //saves number of SC kolaches
            System.out.println(kolacheArray[1].quantity);
        }
        if (e.getSource() == jalK) {
            kolacheArray[2].quantity = Integer.parseInt(textField2.getText()); //saves number of jal kolaches
            System.out.println(kolacheArray[2].quantity);
        }
        if (e.getSource() == hamK) {
            kolacheArray[3].quantity = Integer.parseInt(textField3.getText()); //saves number of ham kolaches
            System.out.println(kolacheArray[3].quantity);
        }

        if(e.getSource() == drinkMain){
            //configures the drink set panel
            drinkPanel.add(textField0);
            drinkPanel.add(smCofButton);
            drinkPanel.add(textField1);
            drinkPanel.add(medCofButton);
            drinkPanel.add(textField2);
            drinkPanel.add(lrgCofButton);
            drinkPanel.add(textField3);
            drinkPanel.add(pepsiButton);
            drinkPanel.add(textField4);
            drinkPanel.add(spriteButton);

            mPanel.setVisible(false); //exit from main menu
            backButton.setVisible(true); //back button exists
            labelPanel.setVisible(true); //label and set buttons visible
            drinkPanel.setVisible(true);

            //sets labels
            label0.setText("Small Coffee 12oz $1.65");
            label1.setText("Medium Coffee 16oz $1.95");
            label2.setText("Large Coffee 20oz $2.20");
            label3.setText("Pepsi $2.00");
            label4.setText("Sprite Bottle $2.00");
            label5.setText("");

            //sets text fields
            textField0.setText(String.valueOf(drinkArray[0].quantity));
            textField1.setText(String.valueOf(drinkArray[1].quantity));
            textField2.setText(String.valueOf(drinkArray[2].quantity));
            textField3.setText(String.valueOf(drinkArray[3].quantity));
            textField4.setText(String.valueOf(drinkArray[4].quantity));
        }
        if(e.getSource() == smCofButton){
            drinkArray[0].quantity = Integer.parseInt(textField0.getText()); //saves number of small coffee
            System.out.println(drinkArray[0].quantity);
        }
        if(e.getSource() == medCofButton){
            drinkArray[1].quantity = Integer.parseInt(textField1.getText()); //saves number of medium coffee
            System.out.println(drinkArray[1].quantity);
        }
        if(e.getSource() == lrgCofButton){
            drinkArray[2].quantity = Integer.parseInt(textField2.getText()); //saves number of large coffee
            System.out.println(drinkArray[2].quantity);
        }
        if(e.getSource() == pepsiButton){
            drinkArray[3].quantity = Integer.parseInt(textField3.getText()); //saves number of pepsi
            System.out.println(drinkArray[3].quantity);
        }
        if(e.getSource() == spriteButton){
            drinkArray[4].quantity = Integer.parseInt(textField4.getText()); //saves number of sprite
            System.out.println(drinkArray[4].quantity);
        }

        if(e.getSource() == pastryMain){
            //configures the pastry set panel
            pastryPanel.add(textField0);
            pastryPanel.add(cRollButton);
            pastryPanel.add(textField1);
            pastryPanel.add(glazeTwButton);
            pastryPanel.add(textField2);
            pastryPanel.add(chocTwButton);
            pastryPanel.add(textField3);
            pastryPanel.add(fBarButton);
            pastryPanel.add(textField4);
            pastryPanel.add(appFritterButton);
            pastryPanel.add(textField5);
            pastryPanel.add(bearCButton);

            mPanel.setVisible(false); //exit from main menu
            backButton.setVisible(true); //back button exists
            labelPanel.setVisible(true); //label and set buttons visible
            pastryPanel.setVisible(true);

            //sets labels
            label0.setText("Cinnamon Roll $1.85");
            label1.setText("Glaze Twist $1.85");
            label2.setText("Chocolate Twist $1.85");
            label3.setText("Filled Bar $1.85");
            label4.setText("Apple Fritter $1.85");
            label5.setText("Bear Claw $1.85");

            //sets text fields
            textField0.setText(String.valueOf(pastryArray[0].quantity));
            textField1.setText(String.valueOf(pastryArray[1].quantity));
            textField2.setText(String.valueOf(pastryArray[2].quantity));
            textField3.setText(String.valueOf(pastryArray[3].quantity));
            textField4.setText(String.valueOf(pastryArray[4].quantity));
            textField5.setText(String.valueOf(pastryArray[5].quantity));
        }
        if(e.getSource() == cRollButton){
            pastryArray[0].quantity = Integer.parseInt(textField0.getText()); //saves number of cinnamon roll
            System.out.println(pastryArray[0].quantity);
        }
        if(e.getSource() == glazeTwButton){
            pastryArray[1].quantity = Integer.parseInt(textField1.getText()); //saves number of glaze twist
            System.out.println(pastryArray[1].quantity);
        }
        if(e.getSource() == chocTwButton){
            pastryArray[2].quantity = Integer.parseInt(textField2.getText()); //saves number of choc twist
            System.out.println(pastryArray[2].quantity);
        }
        if(e.getSource() == fBarButton){
            pastryArray[3].quantity = Integer.parseInt(textField3.getText()); //saves number of filled bar
            System.out.println(pastryArray[3].quantity);
        }
        if(e.getSource() == appFritterButton){
            pastryArray[4].quantity = Integer.parseInt(textField4.getText()); //saves number of apple fritter
            System.out.println(pastryArray[4].quantity);
        }
        if(e.getSource() == bearCButton){
            pastryArray[5].quantity = Integer.parseInt(textField5.getText()); //saves number of bear claw
            System.out.println(pastryArray[5].quantity);
        }

        if (e.getSource() == backButton) { //goes from sub menu back to main
            donutPanel.setVisible(false);
            backButton.setVisible(false);
            labelPanel.setVisible(false);
            kSetPanel.setVisible(false);
            drinkPanel.setVisible(false);
            pastryPanel.setVisible(false);
            totalPanel.setVisible(false);
            submitButton.setVisible(false);
            totalPrice.setVisible(false);
            mPanel.setVisible(true);
        }

        if(e.getSource() == cart){
            mPanel.setVisible(false);
            donutPanel.setVisible(false);
            backButton.setVisible(true);
            kSetPanel.setVisible(false);
            drinkPanel.setVisible(false);
            pastryPanel.setVisible(false);
            labelPanel.setVisible(false);
            submitButton.setVisible(true);

            double total = priceCalc();
            totalPrice.setText("Total: $" + String.format("%.2f", total));
            totalPrice.setVisible(true);

            int quantityTotalD = quantityCalc(donutsArray);
            String totalDText = itemList(donutsArray);

            int quantityTotalP = quantityCalc(pastryArray);
            String totalPText = itemList(pastryArray);

            int quantityTotalDr = quantityCalc(drinkArray);
            String totalDrText = itemList(drinkArray);

            int quantityTotalK = quantityCalc(kolacheArray);
            String totalKText = itemList(kolacheArray);

            totalPanel.add(label6);
            totalPanel.add(sp0);
            label6.setText("Total donuts: " + String.valueOf(quantityTotalD));
            textArea0.setText(totalDText);

            totalPanel.add(label7);
            totalPanel.add(sp1);
            label7.setText("Total pastries: " + String.valueOf(quantityTotalP));
            textArea1.setText(totalPText);

            totalPanel.add(label8);
            totalPanel.add(sp2);
            label8.setText("Total kolaches: " + String.valueOf(quantityTotalK));
            textArea2.setText(totalKText);

            totalPanel.add(label9);
            totalPanel.add(sp3);
            label9.setText("Total drinks: " + String.valueOf(quantityTotalDr));
            textArea3.setText(totalDrText);

            totalPanel.setVisible(true);


        }
        if(e.getSource() == submitButton){
            JOptionPane.showMessageDialog(null,"Order Submitted!","Order Status",1);
            donutPanel.setVisible(false);
            backButton.setVisible(false);
            labelPanel.setVisible(false);
            kSetPanel.setVisible(false);
            drinkPanel.setVisible(false);
            pastryPanel.setVisible(false);
            totalPanel.setVisible(false);
            submitButton.setVisible(false);
            totalPrice.setVisible(false);
            mPanel.setVisible(true);

            wipeOrder();
        }
    }
}

