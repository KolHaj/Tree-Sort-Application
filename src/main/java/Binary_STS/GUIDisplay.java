package Binary_STS;

/**
* File: GUIDisplay.java
* Author: Kolger Hajati
* Date: February 22, 2019
* Purpose: This file holds GUI details for user menu.
*/

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUIDisplay extends JFrame {

	//Variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField inputText;
	private static JTextField resultText;
	private JButton sortButton;
	private JLabel inputLabel;
	private JLabel resultLabel;
	private JLabel sortLabel;
	private JLabel numericLabel;
	private JRadioButton ascendRadio;
	private JRadioButton descendRadio;
	private JRadioButton intRadio;
	private JRadioButton fractionRadio;
	private ButtonGroup groupOne; 
	private ButtonGroup groupTwo; 
    private String data;
    private String result;
    private int current = 0;
    private String token;
    
	//Main and runs GUI
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GUIDisplay frame = new GUIDisplay();
				frame.setVisible(true);
				}
		});
	}

	private GUIDisplay() {

		//Content Bounds
		setTitle("Binary Search Tree Sort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Perform Sort Button
		sortButton = new JButton("Perform Sort");
		sortButton.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		sortButton.setBounds(185, 170, 120, 25);
		contentPane.add(sortButton);

		//Original list label
		inputLabel = new JLabel("Original List");
		inputLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		inputLabel.setBounds(45, 10, 150, 20);
		contentPane.add(inputLabel);

		//Sorted list label
		resultLabel = new JLabel("Sorted List");
		resultLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		resultLabel.setBounds(55, 90, 150, 20);
		contentPane.add(resultLabel);

		//Original text field
		inputText = new JTextField();
		inputText.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		inputText.setBounds(130, 10, 300, 20);
		contentPane.add(inputText);
		inputText.setColumns(10);

		//Sorted text field
		resultText = new JTextField();
		resultText.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		resultText.setBounds(130, 90, 300, 20);
		contentPane.add(resultText);
		resultText.setColumns(10);
		resultText.setEditable(false);
		
		//groupOne radio label
		sortLabel = new JLabel("");
		sortLabel.setBounds(5, 225, 235, 90);
		contentPane.add(sortLabel);
		
		//groupTwo radio label
		numericLabel = new JLabel("");
		numericLabel.setBounds(245, 225, 235, 90);
		contentPane.add(numericLabel);
		
		//Ascend Radio
		ascendRadio = new JRadioButton("Ascending");
		ascendRadio.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		ascendRadio.setBounds(10, 250, 100, 20);
		contentPane.add(ascendRadio);
		//Descend Radio
		descendRadio = new JRadioButton("Descending");
		descendRadio.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		descendRadio.setBounds(10, 280, 100, 20);
		contentPane.add(descendRadio);
		
		groupOne = new ButtonGroup(); 
		groupTwo = new ButtonGroup();
		
		//Grouping for ascend and descend
		groupOne.add(ascendRadio); 
		groupOne.add(descendRadio);
		ascendRadio.setSelected(true);
		//Border for sortLabel
		TitledBorder label1;
		label1 = BorderFactory.createTitledBorder("Sort Order");
		sortLabel.setBorder(label1);
		
		//Integer radio
		intRadio = new JRadioButton("Integer");
		intRadio.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		intRadio.setBounds(250, 250, 100, 20);
		contentPane.add(intRadio);
		//Fraction Radio
		fractionRadio = new JRadioButton("Fraction");
		fractionRadio.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		fractionRadio.setBounds(250, 280, 100, 20);
		contentPane.add(fractionRadio);
		
		//Grouping for integer and fraction radio
		groupTwo.add(intRadio); 
		groupTwo.add(fractionRadio);
		intRadio.setSelected(true);
		//Border for numericLabel
		TitledBorder label2;
		label2 = BorderFactory.createTitledBorder("Numeric Type");
		numericLabel.setBorder(label2);

		//Action listener sent to ActionInput
		sortButton.addActionListener(new ActionInput());
		inputText.addActionListener(new ActionInput());
		resultText.addActionListener(new ActionInput());
		ascendRadio.addActionListener(new ActionInput());
		descendRadio.addActionListener(new ActionInput());
		intRadio.addActionListener(new ActionInput());
		fractionRadio.addActionListener(new ActionInput());
	}

	/**
	* Action listener that handles input and output of GUI values
	* Also handles error check for number format expression and empty input
	*/
	private class ActionInput implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == sortButton) {
				try {
					if (GUIDisplay.inputText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter value!", "Error", JOptionPane.ERROR_MESSAGE);
					} 
					else {
						//Input Data and tokenizer
						data = GUIDisplay.inputText.getText();
						String[] tokens = data.split(" ");
	
						//Integer radio button is selected
						if (intRadio.isSelected()) {
							//Creates instance
							MethodData <Integer> binary = new MethodData<>();
	
							//While loop to insert integer values
							while (current < tokens.length) {
								token = tokens[current];
								binary.insertNode(Integer.parseInt(token));
								current++;
							}
							//If statments to return ascending or descending
							if (ascendRadio.isSelected()) {
								result = binary.getAscending();
							} 
							else if (descendRadio.isSelected()) {
								result = binary.getDescending();
							}
						}
	
						//Fraction radio button is selected
						if (fractionRadio.isSelected()) {
							//Creates instance
							MethodData<FractionData> binary = new MethodData<>();
	
							//While loop to insert fraction values
							while (current < tokens.length) {
								token = tokens[current];
								FractionData fraction = new FractionData(token);
								binary.insertNode(fraction);
								current++;
							}
							//If statments to return ascending or descending
							if (ascendRadio.isSelected()) {
								result = binary.getAscending();
							} 
							else if (descendRadio.isSelected()) {
								result = binary.getDescending();
							}
						}
						//Sets the output to the GUI
						resultText.setText(result);
						current = 0;
					}
				} 
				//Catch for number format exception
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Non Numeric Input", "Error", JOptionPane.ERROR_MESSAGE);
					current = 0;
				}
			}
		}
	}
}