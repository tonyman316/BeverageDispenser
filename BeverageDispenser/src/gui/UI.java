package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import coffee.Coffee;

public class UI extends JFrame{

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private Coffee coffee;

	public UI() {
		prepareGUI();
		showMainMenu();
		coffee = new Coffee();
		coffee.printCurrentStock();
		//coffee.resetAllAfterRefill();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Beverage Dispenser");
		mainFrame.setSize(350, 420);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.out.println("\nThank you! Have a nice day!");
				System.exit(0);
			}
		});
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);

		statusLabel.setSize(350, 100);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}
	
	private void showMainMenu() {
		headerLabel.setText("	What do you like today?");

		JPanel panel = new JPanel();
		// panel.setBackground(Color.darkGray);
		panel.setSize(100, 100);
		GridLayout layout = new GridLayout(3, 1);
		layout.setHgap(10);
		layout.setVgap(10);

		JButton coffeeButton = new JButton("Coffee");
		JButton hcButton = new JButton("Hot Chocolate");
		JButton hwButton = new JButton("Hot Water");
		

		coffeeButton.setActionCommand("Coffee");
		hcButton.setActionCommand("Hot Chocolate");
		hwButton.setActionCommand("Hot Water");

		coffeeButton.addActionListener(new ButtonClickListener());
		hcButton.addActionListener(new ButtonClickListener());
		hwButton.addActionListener(new ButtonClickListener());

		hwButton.setForeground(Color.RED);
		
		controlPanel.add(coffeeButton);
		controlPanel.add(hcButton);
		controlPanel.add(hwButton);
		controlPanel.add(panel);
		mainFrame.setVisible(true);

	}
    
    private void showCoffeeMenu(){
    	JPanel panel = new JPanel();
		panel.setSize(100, 100);
		GridLayout layout = new GridLayout(3, 1);
		layout.setHgap(10);
		layout.setVgap(10);

		JButton verButton = new JButton("Verona");
		JButton ppButton = new JButton("Pike Place");
		JButton ppdButton = new JButton("Pike Place Decaf");
		JButton mixTwoButton = new JButton("Mix Two");

		verButton.setActionCommand("Verona");
		ppButton.setActionCommand("Pike Place");
		ppdButton.setActionCommand("Pike Place Decaf");
		mixTwoButton.setActionCommand("Mix Two");

		verButton.addActionListener(new ButtonClickListener());
		ppButton.addActionListener(new ButtonClickListener());
		ppdButton.addActionListener(new ButtonClickListener());
		mixTwoButton.addActionListener(new ButtonClickListener());
		
		verButton.setForeground(Color.BLUE);
		ppButton.setForeground(Color.BLUE);
		ppdButton.setForeground(Color.BLUE);
		mixTwoButton.setForeground(Color.BLUE);

		controlPanel.add(verButton);
		controlPanel.add(ppButton);
		controlPanel.add(ppdButton);
		controlPanel.add(mixTwoButton);
		controlPanel.add(panel);
		mainFrame.setVisible(true);

    }
    
    private void showCondimentsMenu(){
    	JPanel panel = new JPanel();
		panel.setSize(100, 100);
		GridLayout layout = new GridLayout(3, 1);
		layout.setHgap(10);
		layout.setVgap(10);

		JButton sugarButton = new JButton("sugar");
		JButton splendaButton = new JButton("splenda");
		JButton creamButton = new JButton("cream");

		sugarButton.setActionCommand("sugar");
		splendaButton.setActionCommand("splenda");
		creamButton.setActionCommand("cream");

		sugarButton.addActionListener(new ButtonClickListener());
		splendaButton.addActionListener(new ButtonClickListener());
		creamButton.addActionListener(new ButtonClickListener());

		controlPanel.add(sugarButton);
		controlPanel.add(splendaButton);
		controlPanel.add(creamButton);
		controlPanel.add(panel);
		mainFrame.setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           String command = e.getActionCommand();   	
           
           switch (command) {
           case "Coffee":
        	   statusLabel.setText("What kinds of coffee do you like?");
        	   showCoffeeMenu(); 
        	   break;
           case "Hot Chocolate":
               statusLabel.setText("8oz Hot Chocolate is pouring out..."); 
               System.out.println("8oz Hot Chocolate is pouring out...\n");
               coffee.subtractStock("Hot Chocolate");
               coffee.subtractStock("Hot Water");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCoffeeAndBeans());
               break;
           case "Hot Water":
               statusLabel.setText("8oz Hot Water is pouring out...");
               System.out.println("8oz Hot Water is pouring out...\n");
               coffee.subtractStock("Hot Water");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCoffeeAndBeans());
               break;
           case "Verona":
               statusLabel.setText("8oz Verona Coffee is pouring out...");
               System.out.println("8oz Verona Coffee is pouring out...\n");
               showCondimentsMenu();
               coffee.subtractStock("Verona");
               coffee.subtractStock("Hot Water");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCoffeeAndBeans());
               break;
           case "Pike Place":
               statusLabel.setText("8oz Pike Place Coffee is pouring out...");
               System.out.println("8oz Pike Place Coffee is pouring out...\n");
               showCondimentsMenu();
               coffee.subtractStock("Pike Place");
               coffee.subtractStock("Hot Water");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCoffeeAndBeans());
               break;
           case "Pike Place Decaf":
               statusLabel.setText("8oz Pike Place Decaf Coffee is pouring out...");
               System.out.println("8oz Pike Place Decaf Coffee is pouring out...\n");
               showCondimentsMenu();
               coffee.subtractStock("Pike Place Decaf");
               coffee.subtractStock("Hot Water");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCoffeeAndBeans());
               break;
           case "Mix Two":
               statusLabel.setText("8oz Mix Two Coffee is pouring out...");
               System.out.println("8oz Mix Two Coffee is pouring out...\n");
               showCondimentsMenu();
               coffee.subtractStock("Mix Two");
               coffee.subtractStock("Hot Water");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCoffeeAndBeans());
               break;
           case "sugar":
               statusLabel.setText("1 teaspoon of sugar is pouring out...");
               System.out.println("1 teaspoon of sugar is pouring out...\n");
               coffee.subtractStock("sugar");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCondimentsAndAmount());
               break;
           case "splenda":
               statusLabel.setText("1 teaspoon of splenda is pouring out...");
               System.out.println("1 teaspoon of splenda is pouring out...\n");
               coffee.subtractStock("splenda");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCondimentsAndAmount());
               break;
           case "cream":
               statusLabel.setText("1 teaspoon of cream is pouring out...");
               System.out.println("1 teaspoon of cream is pouring out...\n");
               coffee.subtractStock("cream");
               coffee.printCurrentStock();
               coffee.hashMapSerialization(coffee.getCondimentsAndAmount());
               break;
           }
        }		
     }

    	
}
