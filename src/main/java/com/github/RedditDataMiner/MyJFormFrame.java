/*
 * Created by JFormDesigner on Tue May 24 14:52:28 IST 2022
 */

package com.github.RedditDataMiner;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

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

	private void commentCountFilterCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			commentCountMinTextField.setEnabled(true);
			commentCountMaxTextField.setEnabled(true);
		}
		else {
			commentCountMinTextField.setEnabled(false);
			commentCountMaxTextField.setEnabled(false);
		}
	}

	private void noNsfwFilterCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			filterArrayList.add(new NoNsfwFilter());
		}
		else {
			filterArrayList.remove(new NoNsfwFilter());
		}
	}

	private void noSpamFilterCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			filterArrayList.add(new NoSpamFilter());
		}
		else {
			filterArrayList.remove(new NoSpamFilter());
		}
	}

	private void keywordCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			keywordTextField.setEnabled(true);
		}
		else {
		    keywordTextField.setEnabled(false);
		}
	}

	private void scoreFilterCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			scoreMinTextField.setEnabled(true);
			scoreMaxTextField.setEnabled(true);
		}
		else {
			scoreMinTextField.setEnabled(false);
			scoreMaxTextField.setEnabled(false);
		}
	}

	public JTextArea getResultTextArea() {
		return resultTextArea;
	}

	private void azSortItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			zaSort.setSelected(false);
		}
	}

	private void zaSortItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
		    azSort.setSelected(false);
		}
	}

	private void scoreSortMaxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
		    scoreSortMin.setSelected(false);
		}
	}

	private void scoreSortMinItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
		    scoreSortMax.setSelected(false);
		}
	}

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	private void thisWindowClosing() {
		System.exit(0);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		headingLabel = new JLabel();
		filterPanel = new JPanel();
		subredditFilterLabel = new JLabel();
		subredditTextField = new JTextField();
		noNsfwCheckBox = new JCheckBox();
		keywordCheckBox = new JCheckBox();
		noSpamCheckBox = new JCheckBox();
		keywordTextField = new JTextField();
		scoreFilterCheckBox = new JCheckBox();
		scoreMinTextField = new JTextField();
		scoreMinLabel = new JLabel();
		scoreMaxTextField = new JTextField();
		scoreMaxLabel = new JLabel();
		commentCountFilterCheckBox = new JCheckBox();
		commentCountMinTextField = new JTextField();
		commentCountMinLabel = new JLabel();
		commentCountMaxTextField = new JTextField();
		commentCountMaxLabel = new JLabel();
		redditSortSettingsCheckBox = new JLabel();
		redditSortComboBox = new JComboBox();
		azSort = new JCheckBox();
		zaSort = new JCheckBox();
		scoreSortMax = new JCheckBox();
		scoreSortMin = new JCheckBox();
		searchButton = new JButton();
		scrollPane1 = new JScrollPane();
		resultTextArea = new JTextArea();

		//======== this ========
		setBackground(new Color(255, 204, 204));
		setForeground(Color.orange);
		setMinimumSize(new Dimension(800, 500));
		setTitle("RedditDataMiner");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				thisWindowClosing();
			}
		});
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
			"[]" +
			"[]" +
			"[fill]" +
			"[fill]" +
			"[]" +
			"[]" +
			"[fill]" +
			"[fill]" +
			"[0,fill]" +
			"[86,grow 1,fill]" +
			"[21,grow 1,fill]"));

		//---- headingLabel ----
		headingLabel.setText("Welcome to Reddit Data Miner");
		contentPane.add(headingLabel, "cell 1 0 37 1,align center center,grow 0 0,hmin 0");

		//======== filterPanel ========
		{
			filterPanel.setLayout(new MigLayout(
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

			//---- subredditFilterLabel ----
			subredditFilterLabel.setText("Subreddit Filter");
			filterPanel.add(subredditFilterLabel, "cell 0 1");
			filterPanel.add(subredditTextField, "cell 1 1 9 1");

			//---- noNsfwCheckBox ----
			noNsfwCheckBox.setText("No NSFW Filter");
			noNsfwCheckBox.addItemListener(e -> noNsfwFilterCheckBoxItemStateChanged(e));
			filterPanel.add(noNsfwCheckBox, "cell 0 3 3 1");

			//---- keywordCheckBox ----
			keywordCheckBox.setText("Keyword Filter");
			keywordCheckBox.addItemListener(e -> keywordCheckBoxItemStateChanged(e));
			filterPanel.add(keywordCheckBox, "cell 5 3");

			//---- noSpamCheckBox ----
			noSpamCheckBox.setText("No Spam Filter");
			noSpamCheckBox.addItemListener(e -> noSpamFilterCheckBoxItemStateChanged(e));
			filterPanel.add(noSpamCheckBox, "cell 0 4 3 1");

			//---- keywordTextField ----
			keywordTextField.setEnabled(false);
			filterPanel.add(keywordTextField, "cell 5 4 5 1");

			//---- scoreFilterCheckBox ----
			scoreFilterCheckBox.setText("Score Filter");
			scoreFilterCheckBox.addItemListener(e -> scoreFilterCheckBoxItemStateChanged(e));
			filterPanel.add(scoreFilterCheckBox, "cell 0 6 4 1");

			//---- scoreMinTextField ----
			scoreMinTextField.setText("0");
			scoreMinTextField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			scoreMinTextField.setEnabled(false);
			scoreMinTextField.setMinimumSize(new Dimension(100, 38));
			filterPanel.add(scoreMinTextField, "cell 5 6");

			//---- scoreMinLabel ----
			scoreMinLabel.setText("Min");
			filterPanel.add(scoreMinLabel, "cell 6 6");

			//---- scoreMaxTextField ----
			scoreMaxTextField.setText("-1");
			scoreMaxTextField.setEnabled(false);
			scoreMaxTextField.setMinimumSize(new Dimension(100, 38));
			filterPanel.add(scoreMaxTextField, "cell 7 6 2 1");

			//---- scoreMaxLabel ----
			scoreMaxLabel.setText("Max");
			filterPanel.add(scoreMaxLabel, "cell 9 6");

			//---- commentCountFilterCheckBox ----
			commentCountFilterCheckBox.setText("Comment Count Filter");
			commentCountFilterCheckBox.addItemListener(e -> commentCountFilterCheckBoxItemStateChanged(e));
			filterPanel.add(commentCountFilterCheckBox, "cell 0 8 4 1");

			//---- commentCountMinTextField ----
			commentCountMinTextField.setText("0");
			commentCountMinTextField.setEnabled(false);
			commentCountMinTextField.setMinimumSize(new Dimension(100, 38));
			filterPanel.add(commentCountMinTextField, "cell 5 8");

			//---- commentCountMinLabel ----
			commentCountMinLabel.setText("Min");
			filterPanel.add(commentCountMinLabel, "cell 6 8");

			//---- commentCountMaxTextField ----
			commentCountMaxTextField.setText("-1");
			commentCountMaxTextField.setEnabled(false);
			commentCountMaxTextField.setMinimumSize(new Dimension(100, 38));
			filterPanel.add(commentCountMaxTextField, "cell 7 8 2 1");

			//---- commentCountMaxLabel ----
			commentCountMaxLabel.setText("Max");
			filterPanel.add(commentCountMaxLabel, "cell 9 8");
		}
		contentPane.add(filterPanel, "cell 1 1 18 11,hmax 250");

		//---- redditSortSettingsCheckBox ----
		redditSortSettingsCheckBox.setText("Reddit Sort Settings");
		contentPane.add(redditSortSettingsCheckBox, "cell 20 2 6 1");
		contentPane.add(redditSortComboBox, "cell 20 4 16 1");

		//---- azSort ----
		azSort.setText("A-Z Sort");
		azSort.addItemListener(e -> azSortItemStateChanged(e));
		contentPane.add(azSort, "cell 20 6 9 1");

		//---- zaSort ----
		zaSort.setText("Z-A Sort");
		zaSort.addItemListener(e -> zaSortItemStateChanged(e));
		contentPane.add(zaSort, "cell 30 6 7 1");

		//---- scoreSortMax ----
		scoreSortMax.setText("Score Sort by Max");
		scoreSortMax.addItemListener(e -> scoreSortMaxItemStateChanged(e));
		contentPane.add(scoreSortMax, "cell 20 8 9 1");

		//---- scoreSortMin ----
		scoreSortMin.setText("Score Sort by Min");
		scoreSortMin.addItemListener(e -> scoreSortMinItemStateChanged(e));
		contentPane.add(scoreSortMin, "cell 30 8 7 1");

		//---- searchButton ----
		searchButton.setText("Search");
		contentPane.add(searchButton, "cell 20 10 17 2");

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(resultTextArea);
		}
		contentPane.add(scrollPane1, "cell 2 13 35 2");
		setSize(1080, 500);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel headingLabel;
	private JPanel filterPanel;
	private JLabel subredditFilterLabel;
	private JTextField subredditTextField;
	private JCheckBox noNsfwCheckBox;
	private JCheckBox keywordCheckBox;
	private JCheckBox noSpamCheckBox;
	private JTextField keywordTextField;
	private JCheckBox scoreFilterCheckBox;
	private JTextField scoreMinTextField;
	private JLabel scoreMinLabel;
	private JTextField scoreMaxTextField;
	private JLabel scoreMaxLabel;
	private JCheckBox commentCountFilterCheckBox;
	private JTextField commentCountMinTextField;
	private JLabel commentCountMinLabel;
	private JTextField commentCountMaxTextField;
	private JLabel commentCountMaxLabel;
	private JLabel redditSortSettingsCheckBox;
	private JComboBox redditSortComboBox;
	private JCheckBox azSort;
	private JCheckBox zaSort;
	private JCheckBox scoreSortMax;
	private JCheckBox scoreSortMin;
	private JButton searchButton;
	private JScrollPane scrollPane1;
	private JTextArea resultTextArea;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

}
