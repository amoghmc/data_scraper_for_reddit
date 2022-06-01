/*
 * Created by JFormDesigner on Wed Jun 01 20:43:27 IST 2022
 */

package com.RedditDataScraper;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class LoginFrame extends JFrame {
	public LoginFrame() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		formattedTextField1 = new JFormattedTextField();
		label2 = new JLabel();
		passwordField1 = new JPasswordField();
		button1 = new JButton();
		button2 = new JButton();

		//======== this ========
		setTitle("Login");
		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//---- label1 ----
		label1.setText("Username");
		contentPane.add(label1, "cell 2 1 4 1");
		contentPane.add(formattedTextField1, "cell 6 1 10 1");

		//---- label2 ----
		label2.setText("Password");
		contentPane.add(label2, "cell 2 3 4 1");
		contentPane.add(passwordField1, "cell 6 3 10 1");

		//---- button1 ----
		button1.setText("Login");
		contentPane.add(button1, "cell 2 5 6 2");

		//---- button2 ----
		button2.setText("Register");
		contentPane.add(button2, "cell 10 5 6 2");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JFormattedTextField formattedTextField1;
	private JLabel label2;
	private JPasswordField passwordField1;
	private JButton button1;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
