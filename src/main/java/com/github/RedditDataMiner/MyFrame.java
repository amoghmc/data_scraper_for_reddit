package com.github.RedditDataMiner;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
	public MyFrame() {
		this.setTitle("Data Miner for Reddit");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(600, 600);
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(245, 235, 220));
	}
}
