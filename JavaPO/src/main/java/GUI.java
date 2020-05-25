import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

//enum GUIState {
//    cos(0),
//    CHORY(1),
//    CHORY_NIEWYKRYTY(2),
//    WYLECZONY(3),
//    USUNIETY(4);
//
//
//}

public class GUI extends JFrame {
    private JSlider sliderRange;
    private JSlider sliderDetection;
    private JSlider sliderChance;
    private JLabel RangeText;
    private JLabel DetectionText;
    private JLabel InfectionChanceText;
    private JButton Accept;
    private JTextField PopulationValue;
    private JLabel Text1;
    private JLabel Text3;
    private JPanel Panel;
    private JLabel text2;
    private String value;


    public GUI(Community community, Virus virus) {
        add(Panel);
        setTitle("Virus simulation");
        setSize(1200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        sliderRange.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                RangeText.setText("Range:" + sliderRange.getValue());
            }
        });

        sliderDetection.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                DetectionText.setText("Duration: " + sliderDetection.getValue());
            }
        });

        sliderChance.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                InfectionChanceText.setText("Infection chance: " + ((100 - sliderChance.getValue() * 10) + 10) + "%");
            }
        });

        PopulationValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = PopulationValue.getText();
            }
        });

        Accept.addActionListener(e -> {
            boolean error = true;
            virus.setInfectionChance(sliderChance.getValue());
            virus.setRange(sliderRange.getValue());
            virus.setDetection(sliderDetection.getValue());

            try {
                community.setPopulation(Integer.parseInt(PopulationValue.getText()));
            } catch (Exception f) {
                JOptionPane.showMessageDialog(this, "Wrong population value",
                        "Błąd", JOptionPane.ERROR_MESSAGE);
                error = false;
            }
            if (error) {
                JOptionPane.showMessageDialog(this, "Correct informations",
                        "Confirm", JOptionPane.INFORMATION_MESSAGE);
            }

        });
    }

    public static void DataFromUser(Community community, Virus virus) {
        Scanner scanner = new Scanner(System.in); //create scanner for user input
        System.out.println("How many people do you want in a simulation (<your value> ^2 " +
                "[value more than 100 may not fit in screen])"); //print

        boolean error;
        do {
            error = false;
            try {
                community.setPopulation(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);
        System.out.println("How big range you want for virus [best value is between 1 and 3]"); //print
        do {
            error = false;
            try {
                virus.setRange(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);

        System.out.println("give infection chance [1-100%,5-50%, 10-10%][best value is 5<x<10]"); //print
        /**
         * Get correct value from user
         * @param SetFalse reset boolean
         * @param GetValue Wait for input from user
         * @param Check Check value is correct
         * @retrun print "vrong value" or accept it
         */
        do {
            error = false;
            try {
                virus.setInfectionChance(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);
        System.out.println("Set detection delay [after how many days it will be detected]"); //print
        do {
            error = false;
            try {
                virus.setDetection(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);
    }

}
