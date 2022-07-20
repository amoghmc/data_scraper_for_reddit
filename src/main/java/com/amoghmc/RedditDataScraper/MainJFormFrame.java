/*
 * Created by JFormDesigner on Tue May 24 14:52:28 IST 2022
 */

package com.amoghmc.RedditDataScraper;

import net.dean.jraw.models.SearchSort;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.models.TimePeriod;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.text.NumberFormat;

/**
 * @author unknown
 */
public class MainJFormFrame extends JFrame {
	private final RedditResult redditResult;

	public MainJFormFrame(MyRedditClient myRedditClient, String user, String cientId) {
		initComponents();
		loginLabel.setText("User: " + user);
		clientIdLabel.setText("Client ID: " + cientId);
		redditResult = new RedditResult(this, myRedditClient);
	}

	private void commentCountFilterCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			commentCountMinTextField.setEnabled(true);
			commentCountMaxTextField.setEnabled(true);
		} else {
			commentCountMinTextField.setEnabled(false);
			commentCountMaxTextField.setEnabled(false);
		}
	}

	private void keywordCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			regexCheckBox.setSelected(false);
			keywordTextField.setEnabled(true);
			redditSortComboBox.removeAllItems();
			redditSortComboBox.addItem(SearchSort.RELEVANCE);
			redditSortComboBox.addItem(SearchSort.HOT);
			redditSortComboBox.addItem(SearchSort.NEW);
			redditSortComboBox.addItem(SearchSort.TOP);
			redditSortComboBox.addItem(SearchSort.COMMENTS);
		} else {
			keywordTextField.setEnabled(false);
			regexCheckBox.setEnabled(true);
			addRedditComboBoxItems();
		}
	}

	private void addRedditComboBoxItems() {
		redditSortComboBox.removeAllItems();
		redditSortComboBox.addItem(SubredditSort.BEST);
		redditSortComboBox.addItem(SubredditSort.HOT);
		redditSortComboBox.addItem(SubredditSort.NEW);
		redditSortComboBox.addItem(SubredditSort.TOP);
		redditSortComboBox.addItem(SubredditSort.RISING);
		redditSortComboBox.addItem(SubredditSort.CONTROVERSIAL);
	}

	private void scoreFilterCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			scoreMinTextField.setEnabled(true);
			scoreMaxTextField.setEnabled(true);
		} else {
			scoreMinTextField.setEnabled(false);
			scoreMaxTextField.setEnabled(false);
		}
	}

	private void azSortItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			zaSort.setSelected(false);
			scoreSortMax.setSelected(false);
			scoreSortMin.setSelected(false);
		}
	}

	private void zaSortItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			azSort.setSelected(false);
			scoreSortMax.setSelected(false);
			scoreSortMin.setSelected(false);
		}
	}

	private void scoreSortMaxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			scoreSortMin.setSelected(false);
			azSort.setSelected(false);
			zaSort.setSelected(false);
		}
	}

	private void scoreSortMinItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			scoreSortMax.setSelected(false);
			azSort.setSelected(false);
			zaSort.setSelected(false);
		}
	}

	public JComboBox getRedditSortComboBox() {
		return redditSortComboBox;
	}

	public JTextArea getResultTextArea() {
		return resultTextArea;
	}

	public JComboBox getTimeComboBox() {
		return timeComboBox;
	}

	private void reset() {
		noNsfwCheckBox.setSelected(true);
		noSpoilerCheckBox.setSelected(true);
		scoreFilterCheckBox.setSelected(false);
		commentCountFilterCheckBox.setSelected(false);
		keywordCheckBox.setSelected(false);
		regexCheckBox.setSelected(false);

		subredditTextField.setText("");
		keywordTextField.setText("");
		keywordTextField.setText("");
		scoreMinTextField.setText("0");
		scoreMaxTextField.setText("0");
		commentCountMinTextField.setText("0");
		commentCountMaxTextField.setText("0");

		redditSortComboBox.setSelectedIndex(0);
		timeComboBox.setSelectedIndex(1);
		azSort.setSelected(false);
		zaSort.setSelected(false);
		scoreSortMin.setSelected(false);
		scoreSortMax.setSelected(false);
		resultTextArea.setText("");
	}

	public JTextField getSubredditTextField() {
		return subredditTextField;
	}

	public JCheckBox getNoNsfwCheckBox() {
		return noNsfwCheckBox;
	}

	public JCheckBox getKeywordCheckBox() {
		return keywordCheckBox;
	}

	public JCheckBox getNoSpoilerCheckBox() {
		return noSpoilerCheckBox;
	}

	public JTextField getKeywordTextField() {
		return keywordTextField;
	}

	public JCheckBox getScoreFilterCheckBox() {
		return scoreFilterCheckBox;
	}

	public JFormattedTextField getScoreMinTextField() {
		return scoreMinTextField;
	}

	public JFormattedTextField getScoreMaxTextField() {
		return scoreMaxTextField;
	}

	public JCheckBox getCommentCountFilterCheckBox() {
		return commentCountFilterCheckBox;
	}

	public JFormattedTextField getCommentCountMinTextField() {
		return commentCountMinTextField;
	}

	public JFormattedTextField getCommentCountMaxTextField() {
		return commentCountMaxTextField;
	}

	public JCheckBox getAzSort() {
		return azSort;
	}

	public JCheckBox getZaSort() {
		return zaSort;
	}

	public JCheckBox getScoreSortMax() {
		return scoreSortMax;
	}

	public JCheckBox getScoreSortMin() {
		return scoreSortMin;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public JButton getSearchButton2() {
		return searchButton2;
	}

	public JButton getSearchButton3() {
		return searchButton3;
	}

	private void save() {
		MyCsvWriter myCsvWriter = new MyCsvWriter(this);
		myCsvWriter.createCsvData();
		myCsvWriter.writeCsvData();
	}

	private void search() {
		redditResult.addFilters();
		redditResult.display();
	}

	private void regexCheckBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			keywordCheckBox.setSelected(false);
			keywordTextField.setEnabled(true);
			redditSortComboBox.setEnabled(false);
			timeComboBox.setEnabled(false);
		} else {
			keywordTextField.setEnabled(false);
			redditSortComboBox.setEnabled(true);
			timeComboBox.setEnabled(true);
		}
	}

	public JCheckBox getRegexCheckBox() {
		return regexCheckBox;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		filterPanel = new JPanel();
		subredditFilterLabel = new JLabel();
		subredditTextField = new JTextField();
		noNsfwCheckBox = new JCheckBox();
		keywordCheckBox = new JCheckBox();
		regexCheckBox = new JCheckBox();
		noSpoilerCheckBox = new JCheckBox();
		keywordTextField = new JTextField();
		scoreFilterCheckBox = new JCheckBox();
		//Source: https://stackoverflow.com/questions/11093326/restricting-jtextfield-input-to-integers
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);

		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		// End of Source
		scoreMinTextField = new JFormattedTextField(formatter);
		commentCountMinTextField = new JFormattedTextField(formatter);
		scoreMinLabel = new JLabel();
		scoreMaxLabel = new JLabel();
		commentCountFilterCheckBox = new JCheckBox();
		commentCountMinLabel = new JLabel();
		scoreMaxTextField = new JFormattedTextField(formatter);
		commentCountMaxTextField = new JFormattedTextField(formatter);
		commentCountMaxLabel = new JLabel();
		redditSortSettingsCheckBox = new JLabel();
		searchButton3 = new JButton();
		redditSortComboBox = new JComboBox();
		timeComboBox = new JComboBox();
		azSort = new JCheckBox();
		zaSort = new JCheckBox();
		scoreSortMax = new JCheckBox();
		scoreSortMin = new JCheckBox();
		searchButton = new JButton();
		searchButton2 = new JButton();
		scrollPane1 = new JScrollPane();
		resultTextArea = new JTextArea();
		loginLabel = new JLabel();
		clientIdLabel = new JLabel();

		//======== this ========
		setBackground(new Color(255, 204, 204));
		setForeground(Color.orange);
		setTitle("RedditDataScraper");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
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
			"[]" +
			"[]" +
			"[]" +
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
			"[21,grow 1,fill]" +
			"[]" +
			"[86,grow 1,fill]" +
			"[21,grow 1,fill]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

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
				"[]"));

			//---- subredditFilterLabel ----
			subredditFilterLabel.setText("Subreddit Filter");
			filterPanel.add(subredditFilterLabel, "cell 0 1");
			filterPanel.add(subredditTextField, "cell 1 1 8 1");

			//---- noNsfwCheckBox ----
			noNsfwCheckBox.setText("No NSFW Filter");
			noNsfwCheckBox.setSelected(true);
			filterPanel.add(noNsfwCheckBox, "cell 0 3 3 1");

			//---- keywordCheckBox ----
			keywordCheckBox.setText("Keyword Filter");
			keywordCheckBox.addItemListener(e -> keywordCheckBoxItemStateChanged(e));
			filterPanel.add(keywordCheckBox, "cell 5 3");

			//---- regexCheckBox ----
			regexCheckBox.setText("Regex Filter");
			regexCheckBox.addItemListener(e -> regexCheckBoxItemStateChanged(e));
			filterPanel.add(regexCheckBox, "cell 7 3 4 1");

			//---- noSpoilerCheckBox ----
			noSpoilerCheckBox.setText("No Spoiler Filter");
			noSpoilerCheckBox.setSelected(true);
			filterPanel.add(noSpoilerCheckBox, "cell 0 4 3 1");

			//---- keywordTextField ----
			keywordTextField.setEnabled(false);
			filterPanel.add(keywordTextField, "cell 5 4 4 1");

			//---- scoreFilterCheckBox ----
			scoreFilterCheckBox.setText("Score Filter");
			scoreFilterCheckBox.addItemListener(e -> scoreFilterCheckBoxItemStateChanged(e));
			filterPanel.add(scoreFilterCheckBox, "cell 0 6 4 1");

			//---- scoreMinTextField ----
			scoreMinTextField.setText("0");
			scoreMinTextField.setEnabled(false);
			scoreMinTextField.setMinimumSize(new Dimension(100, 38));
			filterPanel.add(scoreMinTextField, "cell 5 6");

			//---- commentCountMinTextField ----
			commentCountMinTextField.setText("0");
			commentCountMinTextField.setEnabled(false);
			commentCountMinTextField.setMinimumSize(new Dimension(100, 38));
			filterPanel.add(commentCountMinTextField, "cell 5 8");

			//---- scoreMinLabel ----
			scoreMinLabel.setText("Min");
			filterPanel.add(scoreMinLabel, "cell 6 6");

			//---- scoreMaxLabel ----
			scoreMaxLabel.setText("Max");
			filterPanel.add(scoreMaxLabel, "cell 9 6");

			//---- commentCountFilterCheckBox ----
			commentCountFilterCheckBox.setText("Comment Count Filter");
			commentCountFilterCheckBox.addItemListener(e -> commentCountFilterCheckBoxItemStateChanged(e));
			filterPanel.add(commentCountFilterCheckBox, "cell 0 8 4 1");

			//---- commentCountMinLabel ----
			commentCountMinLabel.setText("Min");
			filterPanel.add(commentCountMinLabel, "cell 6 8");

			//---- scoreMaxTextField ----
			scoreMaxTextField.setText("0");
			scoreMaxTextField.setEnabled(false);
			scoreMaxTextField.setMinimumSize(new Dimension(100, 38));
			filterPanel.add(scoreMaxTextField, "cell 7 6 2 1");

			//---- commentCountMaxTextField ----
			commentCountMaxTextField.setText("0");
			commentCountMaxTextField.setEnabled(false);
			commentCountMaxTextField.setMinimumSize(new Dimension(100, 38));
			filterPanel.add(commentCountMaxTextField, "cell 7 8 2 1");

			//---- commentCountMaxLabel ----
			commentCountMaxLabel.setText("Max");
			filterPanel.add(commentCountMaxLabel, "cell 9 8");
		}
		contentPane.add(filterPanel, "cell 1 2 18 12,hmax 250");

		//---- redditSortSettingsCheckBox ----
		redditSortSettingsCheckBox.setText("Reddit Sort Settings");
		contentPane.add(redditSortSettingsCheckBox, "cell 20 3 6 1");

		//---- searchButton3 ----
		searchButton3.setText("Reset");
		searchButton3.addActionListener(e -> reset());
		contentPane.add(searchButton3, "cell 30 3 7 2");

		//---- redditSortComboBox ----
		addRedditComboBoxItems();
		contentPane.add(redditSortComboBox, "cell 20 5 9 1");

		//---- timeComboBox ----
		timeComboBox.addItem(TimePeriod.HOUR);
		timeComboBox.addItem(TimePeriod.DAY);
		timeComboBox.addItem(TimePeriod.WEEK);
		timeComboBox.addItem(TimePeriod.MONTH);
		timeComboBox.addItem(TimePeriod.YEAR);
		timeComboBox.addItem(TimePeriod.ALL);
		timeComboBox.setSelectedIndex(1);
		contentPane.add(timeComboBox, "cell 30 5 7 1");

		//---- azSort ----
		azSort.setText("Title Sort");
		azSort.addItemListener(e -> azSortItemStateChanged(e));
		contentPane.add(azSort, "cell 20 7 9 1");

		//---- zaSort ----
		zaSort.setText("Title Sort Reverse");
		zaSort.addItemListener(e -> zaSortItemStateChanged(e));
		contentPane.add(zaSort, "cell 30 7 7 1");

		//---- scoreSortMax ----
		scoreSortMax.setText("Score Sort by Max");
		scoreSortMax.setSelected(true);
		scoreSortMax.addItemListener(e -> scoreSortMaxItemStateChanged(e));
		contentPane.add(scoreSortMax, "cell 20 9 9 2");

		//---- scoreSortMin ----
		scoreSortMin.setText("Score Sort by Min");
		scoreSortMin.addItemListener(e -> scoreSortMinItemStateChanged(e));
		contentPane.add(scoreSortMin, "cell 30 9 7 2");

		//---- searchButton ----
		searchButton.setText("Search");
		searchButton.addActionListener(e -> search());
		contentPane.add(searchButton, "cell 20 11 9 3");

		//---- searchButton2 ----
		searchButton2.setText("Save Result");
		searchButton2.addActionListener(e -> save());
		contentPane.add(searchButton2, "cell 30 11 7 3");

		//======== scrollPane1 ========
		{

			//---- resultTextArea ----
			resultTextArea.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			resultTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			resultTextArea.setForeground(Color.black);
			scrollPane1.setViewportView(resultTextArea);
		}
		contentPane.add(scrollPane1, "cell 2 14 35 9");
		contentPane.add(loginLabel, "cell 2 23 12 2,alignx left,growx 0");
		contentPane.add(clientIdLabel, "cell 20 23 17 2,alignx right,growx 0");
		setSize(1080, 750);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel filterPanel;
	private JLabel subredditFilterLabel;
	private JTextField subredditTextField;
	private JCheckBox noNsfwCheckBox;
	private JCheckBox keywordCheckBox;
	private JCheckBox regexCheckBox;
	private JCheckBox noSpoilerCheckBox;
	private JTextField keywordTextField;
	private JCheckBox scoreFilterCheckBox;
	private JFormattedTextField scoreMinTextField;
	private JFormattedTextField commentCountMinTextField;
	private JLabel scoreMinLabel;
	private JLabel scoreMaxLabel;
	private JCheckBox commentCountFilterCheckBox;
	private JLabel commentCountMinLabel;
	private JFormattedTextField scoreMaxTextField;
	private JFormattedTextField commentCountMaxTextField;
	private JLabel commentCountMaxLabel;
	private JLabel redditSortSettingsCheckBox;
	private JButton searchButton3;
	private JComboBox redditSortComboBox;
	private JComboBox timeComboBox;
	private JCheckBox azSort;
	private JCheckBox zaSort;
	private JCheckBox scoreSortMax;
	private JCheckBox scoreSortMin;
	private JButton searchButton;
	private JButton searchButton2;
	private JScrollPane scrollPane1;
	private JTextArea resultTextArea;
	private JLabel loginLabel;
	private JLabel clientIdLabel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
