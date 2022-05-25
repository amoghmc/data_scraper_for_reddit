/*
 * Created by JFormDesigner on Tue May 24 14:52:28 IST 2022
 */

package com.github.RedditDataMiner;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class MyJFormFrame extends JFrame {
	private ArrayList<Filter> filterArrayList;
	public MyJFormFrame() {
		initComponents();
		filterArrayList = new ArrayList<Filter>();
	}

	private void checkBox3ItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			textField1.setEnabled(true);
			textField2.setEnabled(true);
		}
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			textField1.setEnabled(false);
			textField2.setEnabled(false);
		}
	}

	private void checkBox4ItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			textField3.setEnabled(true);
			textField4.setEnabled(true);
		}
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			textField3.setEnabled(false);
			textField4.setEnabled(false);
		}
	}

	private void checkBox1ItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			filterArrayList.add(new NoNsfwFilter());
		}
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			filterArrayList.remove(new NoNsfwFilter());
		}
	}

	private void checkBox2ItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			filterArrayList.add(new NoSpamFilter());
		}
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			filterArrayList.remove(new NoSpamFilter());
		}
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		panel1 = new JPanel();
		label10 = new JLabel();
		textField6 = new JTextField();
		checkBox1 = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		textField1 = new JTextField();
		label3 = new JLabel();
		textField2 = new JTextField();
		label4 = new JLabel();
		checkBox4 = new JCheckBox();
		textField3 = new JTextField();
		label7 = new JLabel();
		textField4 = new JTextField();
		label8 = new JLabel();

		//======== this ========
		setMinimumSize(new Dimension(800, 500));
		setBackground(new Color(255, 204, 204));
		setForeground(Color.orange);
		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"insets 0,hidemode 3,gap 7 7",
			// columns
			"[grow 1,fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[grow 1,fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[grow 1,fill]" +
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
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]",
			// rows
			"[18:0,grow 1,fill]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[0,fill]" +
			"[86,grow 1,fill]" +
			"[50,grow 1,fill]"));

		//---- label1 ----
		label1.setText("Welcome to Reddit Data Miner");
		contentPane.add(label1, "cell 0 0 39 1,align center center,grow 0 0,hmin 0");

		//======== panel1 ========
		{
			panel1.setLayout(new MigLayout(
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
				"[fill]",
				// rows
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[21]" +
				"[27]" +
				"[]"));

			//---- label10 ----
			label10.setText("Subreddit Filter");
			panel1.add(label10, "cell 0 1");
			panel1.add(textField6, "cell 1 1 9 1");

			//---- checkBox1 ----
			checkBox1.setText("No NSFW Filter");
			checkBox1.addItemListener(e -> {
			checkBox1ItemStateChanged(e);
			checkBox1ItemStateChanged(e);
		});
			panel1.add(checkBox1, "cell 0 3 4 1");

			//---- checkBox2 ----
			checkBox2.setText("No Spam Filter");
			checkBox2.addItemListener(e -> checkBox2ItemStateChanged(e));
			panel1.add(checkBox2, "cell 0 4 11 1");

			//---- checkBox3 ----
			checkBox3.setText("Score Filter");
			checkBox3.addItemListener(e -> {
			checkBox3ItemStateChanged(e);
			checkBox3ItemStateChanged(e);
		});
			panel1.add(checkBox3, "cell 0 6 4 1");

			//---- textField1 ----
			textField1.setText("0");
			textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			textField1.setEnabled(false);
			textField1.setMinimumSize(new Dimension(100, 38));
			panel1.add(textField1, "cell 5 6");

			//---- label3 ----
			label3.setText("Min");
			label3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			panel1.add(label3, "cell 6 6");

			//---- textField2 ----
			textField2.setText("-1");
			textField2.setEnabled(false);
			textField2.setMinimumSize(new Dimension(100, 38));
			panel1.add(textField2, "cell 7 6 2 1");

			//---- label4 ----
			label4.setText("Max");
			panel1.add(label4, "cell 9 6");

			//---- checkBox4 ----
			checkBox4.setText("Comment Count Filter");
			checkBox4.addItemListener(e -> checkBox4ItemStateChanged(e));
			panel1.add(checkBox4, "cell 0 8 4 1");

			//---- textField3 ----
			textField3.setText("0");
			textField3.setEnabled(false);
			textField3.setMinimumSize(new Dimension(100, 38));
			panel1.add(textField3, "cell 5 8");

			//---- label7 ----
			label7.setText("Min");
			panel1.add(label7, "cell 6 8");

			//---- textField4 ----
			textField4.setText("-1");
			textField4.setEnabled(false);
			textField4.setMinimumSize(new Dimension(100, 38));
			panel1.add(textField4, "cell 7 8 2 1");

			//---- label8 ----
			label8.setText("Max");
			panel1.add(label8, "cell 9 8");
		}
		contentPane.add(panel1, "cell 1 1 18 9,hmax 250");
		setSize(1080, 525);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JPanel panel1;
	private JLabel label10;
	private JTextField textField6;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JTextField textField1;
	private JLabel label3;
	private JTextField textField2;
	private JLabel label4;
	private JCheckBox checkBox4;
	private JTextField textField3;
	private JLabel label7;
	private JTextField textField4;
	private JLabel label8;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
