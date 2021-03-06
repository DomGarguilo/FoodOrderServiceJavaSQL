import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Pasta_GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pasta = "";
	String sauce = "";
	String ingredients = "";
	String seasonings = "";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pasta_GUI frame = new Pasta_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pasta_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPastaType = new JLabel("Pasta");
		lblPastaType.setForeground(Color.WHITE);
		lblPastaType.setHorizontalAlignment(SwingConstants.CENTER);
		lblPastaType.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPastaType.setBounds(309, 34, 212, 35);
		contentPane.add(lblPastaType);
		
		JRadioButton rdbtnPenne = new JRadioButton("Penne");
		rdbtnPenne.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnPenne.setForeground(Color.WHITE);
		rdbtnPenne.setBackground(Color.DARK_GRAY);
		rdbtnPenne.setBounds(236, 148, 127, 25);
		rdbtnPenne.setEnabled(Tools.getIngredientStatus("Penne"));
		contentPane.add(rdbtnPenne);
		
		JRadioButton rdbtnBowtie = new JRadioButton("Bowtie");
		rdbtnBowtie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnBowtie.setForeground(Color.WHITE);
		rdbtnBowtie.setBackground(Color.DARK_GRAY);
		rdbtnBowtie.setBounds(503, 148, 127, 25);
		rdbtnBowtie.setEnabled(Tools.getIngredientStatus("Bowtie"));
		contentPane.add(rdbtnBowtie);
		
		ButtonGroup G3 = new ButtonGroup();
		
		G3.add(rdbtnBowtie);
		G3.add(rdbtnPenne);
		
		Label label = new Label("Select Sauce");
		label.setFont(new Font("Dialog", Font.PLAIN, 24));
		label.setAlignment(Label.CENTER);
		label.setBounds(334, 179, 156, 43);
		contentPane.add(label);
		
		Label label_1 = new Label("Select Pasta Type");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(309, 99, 212, 43);
		contentPane.add(label_1);
		
		JCheckBox chckbxAlfredo = new JCheckBox("Alfredo");
		chckbxAlfredo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxAlfredo.setBackground(Color.DARK_GRAY);
		chckbxAlfredo.setForeground(Color.WHITE);
		chckbxAlfredo.setBounds(358, 243, 113, 25);
		chckbxAlfredo.setEnabled(Tools.getIngredientStatus("Alfredo"));
		contentPane.add(chckbxAlfredo);
		
		JCheckBox chckbxPesto = new JCheckBox("Pesto");
		chckbxPesto.setForeground(Color.WHITE);
		chckbxPesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxPesto.setBackground(Color.DARK_GRAY);
		chckbxPesto.setBounds(568, 243, 113, 25);
		chckbxPesto.setEnabled(Tools.getIngredientStatus("Pesto"));
		contentPane.add(chckbxPesto);
		
		JCheckBox chckbxMarinara = new JCheckBox("Marinara");
		chckbxMarinara.setForeground(Color.WHITE);
		chckbxMarinara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxMarinara.setBackground(Color.DARK_GRAY);
		chckbxMarinara.setBounds(172, 243, 113, 25);
		chckbxMarinara.setEnabled(Tools.getIngredientStatus("Marinara"));
		contentPane.add(chckbxMarinara);
		
		Label label_2 = new Label("Select Ingredients");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 24));
		label_2.setAlignment(Label.CENTER);
		label_2.setBounds(279, 296, 267, 43);
		contentPane.add(label_2);
		
		JCheckBox chckbxCheese = new JCheckBox("Cheese");
		chckbxCheese.setForeground(Color.WHITE);
		chckbxCheese.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxCheese.setBackground(Color.DARK_GRAY);
		chckbxCheese.setBounds(236, 345, 113, 25);
		chckbxCheese.setEnabled(Tools.getIngredientStatus("Cheese"));
		contentPane.add(chckbxCheese);
		
		JCheckBox chckbxMushroom = new JCheckBox("Mushroom");
		chckbxMushroom.setForeground(Color.WHITE);
		chckbxMushroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxMushroom.setBackground(Color.DARK_GRAY);
		chckbxMushroom.setBounds(517, 345, 113, 25);
		chckbxMushroom.setEnabled(Tools.getIngredientStatus("Mushroom"));
		contentPane.add(chckbxMushroom);
		
		JCheckBox chckbxOnions = new JCheckBox("Onions");
		chckbxOnions.setForeground(Color.WHITE);
		chckbxOnions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxOnions.setBackground(Color.DARK_GRAY);
		chckbxOnions.setBounds(236, 395, 113, 25);
		chckbxOnions.setEnabled(Tools.getIngredientStatus("Onion"));
		contentPane.add(chckbxOnions);
		
		JCheckBox chckbxChicken = new JCheckBox("Chicken");
		chckbxChicken.setForeground(Color.WHITE);
		chckbxChicken.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxChicken.setBackground(Color.DARK_GRAY);
		chckbxChicken.setBounds(517, 395, 113, 25);
		chckbxChicken.setEnabled(Tools.getIngredientStatus("Chicken"));
		contentPane.add(chckbxChicken);
		
		Label label_3 = new Label("Select Seasonings");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 24));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(279, 440, 267, 43);
		contentPane.add(label_3);
		
		JCheckBox chckbxOldBay = new JCheckBox("Old Bay");
		chckbxOldBay.setForeground(Color.WHITE);
		chckbxOldBay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxOldBay.setBackground(Color.DARK_GRAY);
		chckbxOldBay.setBounds(236, 489, 113, 25);
		chckbxOldBay.setEnabled(Tools.getIngredientStatus("Old Bay"));
		contentPane.add(chckbxOldBay);
		
		JCheckBox chckbxSalt = new JCheckBox("Salt");
		chckbxSalt.setForeground(Color.WHITE);
		chckbxSalt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxSalt.setBackground(Color.DARK_GRAY);
		chckbxSalt.setBounds(517, 489, 113, 25);
		chckbxSalt.setEnabled(Tools.getIngredientStatus("Salt"));
		contentPane.add(chckbxSalt);
		
		JCheckBox chckbxCajun = new JCheckBox("Cajun");
		chckbxCajun.setForeground(Color.WHITE);
		chckbxCajun.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxCajun.setBackground(Color.DARK_GRAY);
		chckbxCajun.setBounds(236, 547, 113, 25);
		chckbxCajun.setEnabled(Tools.getIngredientStatus("Cajun"));
		contentPane.add(chckbxCajun);
		
		JCheckBox chckbxGarlic = new JCheckBox("Garlic");
		chckbxGarlic.setForeground(Color.WHITE);
		chckbxGarlic.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxGarlic.setBackground(Color.DARK_GRAY);
		chckbxGarlic.setBounds(517, 547, 113, 25);
		chckbxGarlic.setEnabled(Tools.getIngredientStatus("Garlic"));
		contentPane.add(chckbxGarlic);
		
		
		
		// Set all of the data to whatever is selected and push to the DB. Sends user to order confirmation page.
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String q = "SELECT order_num FROM dgargu1db.pasta ORDER BY order_num DESC LIMIT 1;";
				ResultSet rs = QueryClass.query(q);
				int orderNum = 0;
				try {
					rs.next();
					orderNum = Integer.parseInt(rs.getString("order_num")) + 1;
					System.out.println("here" + orderNum);
				} catch (NumberFormatException e1) {
					orderNum = 4423;
					e1.printStackTrace();
				} catch (SQLException e1) {
					orderNum = 4423;
					e1.printStackTrace();
				}
				
				// Adds pasta type
				String pasta = "";
				if (rdbtnBowtie.isSelected()) {
					pasta = "Bowtie";
				}
				if (rdbtnPenne.isSelected()) {
					pasta = "Penne";
				}
				
				
				// Adds sauce types
				String sauces = new String();
				if (chckbxAlfredo.isSelected()) {
					sauces += "Alfredo ";
				}
				if (chckbxMarinara.isSelected()) {
					sauces += "Marinara ";
				}
				if (chckbxPesto.isSelected()) {
					sauces += "Pesto ";
				}
				
				
				// Adds ingredients
				String ingredients = new String();
				if (chckbxCheese.isSelected()) {
					ingredients += "Cheese ";
				}
				if (chckbxMushroom.isSelected()) {
					ingredients += "Mushroom ";
				}
				if (chckbxOnions.isSelected()) {
					ingredients += "Onions ";
				}
				if (chckbxChicken.isSelected()) {
					ingredients += "Chicken ";
				}
				
				
				// Adds seasonings 
				String seasonings = new String();
				if (chckbxOldBay.isSelected()) {
					seasonings += "Old Bay ";
				}
				if (chckbxSalt.isSelected()) {
					seasonings += "Salt ";
				}
				if (chckbxCajun.isSelected()) {
					seasonings += "Cajun ";
				}
				if (chckbxOldBay.isSelected()) {
					seasonings += "Garlic ";
				}
				
				
				PastaOrder order = new PastaOrder(orderNum,0,pasta,sauces,ingredients,seasonings);
				order.pushToDatabase();
				
				End bk = new End();
				bk.setVisible(true);
				dispose();
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(378, 614, 97, 25);
		contentPane.add(btnSubmit);
		// End of submit
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_GUI bk = new Customer_GUI();
				bk.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(78, 34, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start start = new Start();
				start.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogout.setBounds(684, 34, 97, 25);
		contentPane.add(btnLogout);
	}
}
