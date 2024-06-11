import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HairSalonApp extends JFrame {
    // Define controls
    private JRadioButton rbJane, rbPat, rbRon, rbSue, rbLaurie;
    private JCheckBox cbCut, cbColour, cbHighlights, cbExtensions;
    private JRadioButton rbStandard, rbChild, rbStudent, rbSenior;
    private JTextField txtClientVisits;
    private JLabel lblTotalPrice;
    private JButton btnCalculate, btnClear, btnExit;
    private ButtonGroup hairdresserGroup, clientTypeGroup;

    public HairSalonApp() {
        setTitle("Perfect Cut Hair Salon");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Initialize group boxes
        JPanel panelHairdresser = new JPanel();
        panelHairdresser.setBorder(BorderFactory.createTitledBorder("Hairdresser"));
        panelHairdresser.setLayout(new BoxLayout(panelHairdresser, BoxLayout.Y_AXIS));

        JPanel panelServices = new JPanel();
        panelServices.setBorder(BorderFactory.createTitledBorder("Services"));
        panelServices.setLayout(new BoxLayout(panelServices, BoxLayout.Y_AXIS));

        JPanel panelClientType = new JPanel();
        panelClientType.setBorder(BorderFactory.createTitledBorder("Client Type"));
        panelClientType.setLayout(new BoxLayout(panelClientType, BoxLayout.Y_AXIS));

        JPanel panelClientVisits = new JPanel();
        panelClientVisits.setBorder(BorderFactory.createTitledBorder("Client Visits"));
        panelClientVisits.setLayout(new BoxLayout(panelClientVisits, BoxLayout.Y_AXIS));

        // Initialize hairdresser radio buttons
        rbJane = new JRadioButton("Jane Samley");
        rbPat = new JRadioButton("Pat Johnson");
        rbRon = new JRadioButton("Ron Chambers");
        rbSue = new JRadioButton("Sue Pallon");
        rbLaurie = new JRadioButton("Laura Renkins");

        hairdresserGroup = new ButtonGroup();
        hairdresserGroup.add(rbJane);
        hairdresserGroup.add(rbPat);
        hairdresserGroup.add(rbRon);
        hairdresserGroup.add(rbSue);
        hairdresserGroup.add(rbLaurie);

        panelHairdresser.add(rbJane);
        panelHairdresser.add(rbPat);
        panelHairdresser.add(rbRon);
        panelHairdresser.add(rbSue);
        panelHairdresser.add(rbLaurie);

        // Initialize services checkboxes
        cbCut = new JCheckBox("Cut");
        cbColour = new JCheckBox("Colour");
        cbHighlights = new JCheckBox("Highlights");
        cbExtensions = new JCheckBox("Extensions");

        panelServices.add(cbCut);
        panelServices.add(cbColour);
        panelServices.add(cbHighlights);
        panelServices.add(cbExtensions);

        // Initialize client type radio buttons
        rbStandard = new JRadioButton("Standard Adult");
        rbChild = new JRadioButton("Child (12 and under)");
        rbStudent = new JRadioButton("Student");
        rbSenior = new JRadioButton("Senior (over 65)");

        clientTypeGroup = new ButtonGroup();
        clientTypeGroup.add(rbStandard);
        clientTypeGroup.add(rbChild);
        clientTypeGroup.add(rbStudent);
        clientTypeGroup.add(rbSenior);

        panelClientType.add(rbStandard);
        panelClientType.add(rbChild);
        panelClientType.add(rbStudent);
        panelClientType.add(rbSenior);

        // Initialize client visits
        JLabel lblClientVisits = new JLabel("Number of Client Visits:");
        txtClientVisits = new JTextField(10);

        panelClientVisits.add(lblClientVisits);
        panelClientVisits.add(txtClientVisits);

        // Initialize buttons
        btnCalculate = new JButton("Calculate");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePrice();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Initialize total price label
        lblTotalPrice = new JLabel("Total Price:");

        // Add controls to form
        add(panelHairdresser);
        add(panelServices);
        add(panelClientType);
        add(panelClientVisits);
        add(btnCalculate);
        add(btnClear);
        add(btnExit);
        add(lblTotalPrice);

        // Set default selections
        rbJane.setSelected(true);
        rbStandard.setSelected(true);
    }

    private void calculatePrice() {
        // Calculate the total price based on the selected options
        double totalPrice = 0.0;

        // Base rate for hairdresser
        if (rbJane.isSelected()) totalPrice += 30;
        if (rbPat.isSelected()) totalPrice += 45;
        if (rbRon.isSelected()) totalPrice += 40;
        if (rbSue.isSelected()) totalPrice += 50;
        if (rbLaurie.isSelected()) totalPrice += 55;

        // Add services
        if (cbCut.isSelected()) totalPrice += 30;
        if (cbColour.isSelected()) totalPrice += 40;
        if (cbHighlights.isSelected()) totalPrice += 50;
        if (cbExtensions.isSelected()) totalPrice += 200;

        // Apply client type discount
        double discount = 0.0;
        if (rbChild.isSelected()) discount = 0.1;
        if (rbStudent.isSelected()) discount = 0.05;
        if (rbSenior.isSelected()) discount = 0.15;

        // Apply client visits discount
        int visits = Integer.parseInt(txtClientVisits.getText());
        if (visits >= 4 && visits <= 8) discount += 0.05;
        if (visits >= 9 && visits <= 13) discount += 0.1;
        if (visits >= 14) discount += 0.15;

        totalPrice -= totalPrice * discount;
        lblTotalPrice.setText("Total Price: $" + String.format("%.2f", totalPrice));
    }

    private void clearForm() {
        // Clear all selections
        hairdresserGroup.clearSelection();
        clientTypeGroup.clearSelection();
        cbCut.setSelected(false);
        cbColour.setSelected(false);
        cbHighlights.setSelected(false);
        cbExtensions.setSelected(false);
        txtClientVisits.setText("");
        lblTotalPrice.setText("Total Price:");
        rbJane.setSelected(true);
        rbStandard.setSelected(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HairSalonApp().setVisible(true);
            }
        });
    }
}
