import org.w3c.dom.Text;

import java.awt.*;       // Using AWT layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.concurrent.Flow;
import javax.swing.*;    // Using Swing components and containers

public class PizzaDesigner extends JFrame{
    JLabel sizeQuestion = new JLabel("Choose your size");
    Font bigFont = new Font("Arial", Font.BOLD, 20);
    final int FRAME_WIDTH = 250;
    final int FRAME_HEIGHT = 215;

    double priceNumber = 0;

    private static final DecimalFormat df = new DecimalFormat(".00");

    public PizzaDesigner(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton confirm = new JButton("CONFIRM");


        // Setting up the slider with custom labels
        JSlider slider1 = new JSlider(JSlider.HORIZONTAL,0,3, 1);
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put(0, new JLabel("Small") );
        labelTable.put(1, new JLabel("Medium") );
        labelTable.put(2, new JLabel("Large") );
        labelTable.put(3, new JLabel("Super") );

        slider1.setLabelTable(labelTable);
        slider1.setPaintLabels(true);
        slider1.setMajorTickSpacing(1);
        slider1.setMaximum(3);
        slider1.setMinimum(0);
        slider1.setPaintTicks(true);
        slider1.setSnapToTicks(true);

        JLabel returnSize = new JLabel("");

        JCheckBox topping1 = new JCheckBox("Peperoni");
        topping1.setBounds(150,100, 50,50);
        JCheckBox topping2 = new JCheckBox("Olive");
        topping2.setBounds(150,100, 50,50);
        JCheckBox topping3 = new JCheckBox("Tomato");
        topping2.setBounds(150,100, 50,50);
        JCheckBox cheese = new JCheckBox("Extra Cheese");
        topping2.setBounds(150,100, 50,50);

        JLabel price = new JLabel("");



        confirm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int size = slider1.getValue();

                // Telling you what size you picked
                if (size == 0) {
                    returnSize.setText("Small Pizza");}
                if (size == 1) {
                    returnSize.setText("Medium Pizza");}
                if (size == 2) {
                    returnSize.setText("Large Pizza");}
                if (size == 3) {
                    returnSize.setText("Super Pizza");}



                // Getting price for the option
                if (size == 0)
                    priceNumber = 5;
                if (size == 1)
                    priceNumber = 10;
                if (size == 2)
                    priceNumber = 15;
                if (size == 3)
                    priceNumber = 20;
                price.setText(priceNumber+"");


                if (topping1.isSelected())
                    priceNumber += .5;
                else if (topping2.isSelected())
                    priceNumber += .5;
                else if (topping3.isSelected())
                    priceNumber += .5;

                if(topping1.isSelected() && topping2.isSelected())
                    priceNumber += .5;
                else if(topping2.isSelected() && topping3.isSelected())
                    priceNumber += .5;
                else if(topping1.isSelected() && topping3.isSelected())
                    priceNumber += .5;

                if(topping3.isSelected() && topping2.isSelected() && topping1.isSelected())
                    priceNumber += .25;
                price.setText((priceNumber+""));

                double afterTax = priceNumber + (priceNumber / 15);


                    JFrame dialog = new JFrame();
                    setSize(FRAME_WIDTH, FRAME_HEIGHT);
                    setLayout(new FlowLayout(FlowLayout.LEFT));
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dialog.setSize(new Dimension(250, 10000));
                    dialog.setPreferredSize(new Dimension(475, 215));
                    dialog.setLocationRelativeTo(confirm);
                    dialog.add(new JLabel("A tip of 15% has been added, thank you for the tip\n Your new price is "+ String.format("%.2f", afterTax)));
                    dialog.pack();
                    dialog.setVisible(true);



            }
        });

        sizeQuestion.setFont(bigFont);
        add(sizeQuestion);
        add(slider1);
        add(topping1);
        add(topping2);
        add(topping3);
        add(cheese);
        add(confirm);
    }


    public static void main(String[] args) {
        PizzaDesigner example = new PizzaDesigner();
        example.setVisible(true);

    }
}