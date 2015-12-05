package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.ListModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class ShoppingGUI extends JList<Object> {

	public JFrame frmSushiBarkasetsart;
	public JTextField textField ;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public String sal = "", sal2 = "", tuna = "", tuna2 = "", tea = "";
	public String text;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void run() {
		try {
			ShoppingGUI window = new ShoppingGUI();
			window.frmSushiBarkasetsart.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		run();
	}

	/**
	 * Create the application.
	 */
	public ShoppingGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmSushiBarkasetsart = new JFrame();
		frmSushiBarkasetsart.getContentPane().setBackground(Color.WHITE);
		frmSushiBarkasetsart.setTitle("Sushi bar @kasetsart");
		frmSushiBarkasetsart.setBounds(100, 100, 804, 559);
		frmSushiBarkasetsart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSushiBarkasetsart.getContentPane().setLayout(null);
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sal = "salmon sushi = " + textField.getText();
			}
		});
		textField.setBounds(148, 221, 56, 19);
		textField.setText("0");
		frmSushiBarkasetsart.getContentPane().add(textField);
		textField.setColumns(10);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		// add all words from wordList to model
		model.addElement(tea);
		model.addElement(sal);
	    model.addElement(sal2);
	    model.addElement(tuna);
		model.addElement(tuna2);
		// create JList with model - model
		JList<String> list = new JList<String>(model);
		JScrollPane textPane = new JScrollPane(list);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JTextPane textPane_1 = new JTextPane();
		textPane.setViewportView(textPane_1);

		textPane.setBounds(465, 270, 284, 203);

		frmSushiBarkasetsart.getContentPane().add(textPane);

		JLabel lblSushiSalmon = new JLabel("Sushi Salmon");
		lblSushiSalmon.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblSushiSalmon.setBounds(35, 114, 116, 26);
		frmSushiBarkasetsart.getContentPane().add(lblSushiSalmon);

		JLabel lblSushiTuna = new JLabel("Sushi Tuna");
		lblSushiTuna.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblSushiTuna.setBounds(259, 114, 116, 26);
		frmSushiBarkasetsart.getContentPane().add(lblSushiTuna);

		JLabel lblSalmonUsuzukuri = new JLabel("Salmon usuzukuri");
		lblSalmonUsuzukuri.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblSalmonUsuzukuri.setBounds(500, 114, 169, 26);
		frmSushiBarkasetsart.getContentPane().add(lblSalmonUsuzukuri);

		JLabel lblTunaUsuzukuri = new JLabel("Tuna Usuzukuri");
		lblTunaUsuzukuri.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblTunaUsuzukuri.setBounds(35, 287, 138, 15);
		frmSushiBarkasetsart.getContentPane().add(lblTunaUsuzukuri);

		JLabel lblGreentea = new JLabel("Greentea");
		lblGreentea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblGreentea.setBounds(259, 287, 70, 15);
		frmSushiBarkasetsart.getContentPane().add(lblGreentea);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI main = new MainGUI();
				frmSushiBarkasetsart.setVisible(false);
				main.frame.setVisible(true);
			}
		});
		btnBack.setBounds(661, 484, 117, 25);
		frmSushiBarkasetsart.getContentPane().add(btnBack);

		JButton btnOrder = new JButton("");
		btnOrder.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = sal +"\n"+  tuna;
			}
		});
		btnOrder.setBounds(259, 221, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(btnOrder);

		JButton btnOrder_1 = new JButton("");
		btnOrder_1.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		btnOrder_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = sal +"\n"+  tuna +"\n"+  sal2;
			}
		});
		btnOrder_1.setBounds(498, 221, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(btnOrder_1);

		JButton btnOrder_3 = new JButton("");
		btnOrder_3.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		btnOrder_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = sal +"\n"+ tuna +"\n"+  sal2 +"\n"+  tuna2+"\n"+ tea;
			}
		});
		btnOrder_3.setBounds(259, 396, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(btnOrder_3);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/bioweb.jpg")));
		lblNewLabel.setBounds(34, 137, 106, 78);
		frmSushiBarkasetsart.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/IMG_0122.jpg")));
		label.setBounds(259, 132, 105, 78);

		frmSushiBarkasetsart.getContentPane().add(label);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/sushi1.jpg")));
		label_2.setBounds(500, 137, 100, 78);
		frmSushiBarkasetsart.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/sushi2.jpg")));
		label_3.setBounds(34, 307, 97, 78);
		frmSushiBarkasetsart.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/tea1.jpg")));
		label_4.setBounds(259, 307, 97, 78);
		frmSushiBarkasetsart.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/ku1.jpg")));
		label_5.setBounds(0, -3, 116, 106);
		frmSushiBarkasetsart.getContentPane().add(label_5);

		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tuna = "Tuna sushi = " + textField_1.getText();
				// text.add(tuna);
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(386, 223, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sal2 = "Salmon usuzukuri = " + textField_2.getText();
				// text.add(sal2);
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(614, 223, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tuna2 = "tuna usuzukuri = " + textField_3.getText();
				// text.add(tuna2);
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(148, 398, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tea = "Green tea = " + textField_4.getText();
				// text.add(tea);
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(386, 403, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = sal+"\n" ;
			}
		});
		btnNewButton.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		btnNewButton.setBounds(32, 220, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  text = sal +"\n"+ tuna +"\n"+  sal2 +"\n"+  tuna2 + "\n";
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		btnNewButton_1.setBounds(35, 395, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(btnNewButton_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/sushi-cartoon-facebook-cover-timeline-banner-for-fb.jpg")));
		label_6.setBounds(105, -17, 715, 126);
		frmSushiBarkasetsart.getContentPane().add(label_6);
		JComboBox comboBox = new JComboBox();
		textField_5 = new JTextField();
		textField_5.setBounds(35, 470, 88, 26);
		frmSushiBarkasetsart.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		
		comboBox.addItem("New food");
		comboBox.setBounds(259, 433, 130, 24);
		frmSushiBarkasetsart.getContentPane().add(comboBox);
		
		JButton btnOrderExtraProduct = new JButton("Order extra Product");
		btnOrderExtraProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			text = "Extra "+ comboBox.getSelectedItem() + " = " + textField_5.getText();
			}
		});
		btnOrderExtraProduct.setBounds(35, 433, 181, 25);
		frmSushiBarkasetsart.getContentPane().add(btnOrderExtraProduct);
		
		
		JButton btnPayOrder = new JButton("Pay order");
		btnPayOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmSushiBarkasetsart.setVisible(false);
			PaymentGUI  pay = new PaymentGUI();
		    pay.frame.setVisible(true);
			}
		});
		btnPayOrder.setBounds(475, 485, 139, 25);
		frmSushiBarkasetsart.getContentPane().add(btnPayOrder);
		
		JButton btnCheckStatus = new JButton("Check status");
		btnCheckStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textPane_1.setText(text);
			}
		});
		btnCheckStatus.setBounds(279, 484, 169, 25);
		frmSushiBarkasetsart.getContentPane().add(btnCheckStatus);

	}
}
