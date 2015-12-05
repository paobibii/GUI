package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;

public class PaymentGUI {

	public JFrame frame;
	ShoppingGUI shop2 = new ShoppingGUI();
    int debt =  Integer.parseInt(shop2.textField.getText().trim()) * 25;
	int debt1 = Integer.parseInt(shop2.textField_1.getText().trim()) * 30;
	int debt2 = Integer.parseInt(shop2.textField_2.getText().trim()) * 169;
	int debt3 = Integer.parseInt(shop2.textField_3.getText().trim()) * 189;
	int debt4 = Integer.parseInt(shop2.textField_4.getText().trim()) * 20;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentGUI window = new PaymentGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 826, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTotalDept = new JLabel("Total Dept");
		lblTotalDept.setFont(new Font("DokChampa", Font.BOLD, 22));
		lblTotalDept.setBounds(31, 275, 134, 33);
		frame.getContentPane().add(lblTotalDept);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("CheckBox.background"));
		textPane.setBounds(41, 315, 769, 132);

		textPane.setText("Total price  =  %s" + this.toString());
		frame.getContentPane().add(textPane);

		JButton btnBack = new JButton("Proceed");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ShippingGUI ship = new ShippingGUI();
				ship.frame.setVisible(true);
			}
		});
		btnBack.setBounds(31, 448, 117, 25);
		frame.getContentPane().add(btnBack);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaymentGUI.class.getResource("/image/PaymenBG.jpg")));
		label.setBounds(0, 0, 810, 494);
		frame.getContentPane().add(label);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public ShoppingGUI getShop2() {
		return shop2;
	}

	public void setShop2(ShoppingGUI shop2) {
		this.shop2 = shop2;
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	public int getDebt1() {
		return debt1;
	}

	public void setDebt1(int debt1) {
		this.debt1 = debt1;
	}

	public int getDebt2() {
		return debt2;
	}

	public void setDebt2(int debt2) {
		this.debt2 = debt2;
	}

	public int getDebt3() {
		return debt3;
	}

	public void setDebt3(int debt3) {
		this.debt3 = debt3;
	}

	public int getDebt4() {
		return debt4;
	}

	public void setDebt4(int debt4) {
		this.debt4 = debt4;
	}

	public String toString() {
		return String.format("%d", (this.getDebt() + this.getDebt1() + this.getDebt2() + this.getDebt3() + this.getDebt4()));
	}
}
