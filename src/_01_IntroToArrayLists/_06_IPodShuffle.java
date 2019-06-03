package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	
	ArrayList<Song> songs;
	JFrame window;
	JPanel panel;
	JButton surpriseMe;
	JButton stopSong;
	Song currentSong;
	ArrayList<JButton> songButtons = new ArrayList<JButton>();
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				songs = new ArrayList<Song>();
				songs.add(new Song("demo.mp3"));
				songs.add(new Song("PriceCheck.mp3"));
				songs.add(new Song("SchoolShuffle.mp3"));
				run();
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	void run() {
		window = new JFrame();
		panel = new JPanel();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		surpriseMe = new JButton();
		surpriseMe.setText("Surprise Me!");
		surpriseMe.addActionListener(this);
		stopSong = new JButton();
		stopSong.setText("Stop Song");
		stopSong.addActionListener(this);
		panel.add(surpriseMe);
		panel.add(stopSong);
		createSongButtons();
		window.pack();
	}
	
	void createSongButtons() {
		for(int j = 0; j < songs.size(); j++) {
			songButtons.add(new JButton());
			songButtons.get(songButtons.size()-1).setText(songs.get(j).songAddress);
			panel.add(songButtons.get(songButtons.size()-1));
			songButtons.get(songButtons.size()-1).addActionListener(this);
		}
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton clicked = (JButton) arg0.getSource();
		if(clicked == surpriseMe) {
			Random random = new Random();
			currentSong = songs.get(random.nextInt(songs.size()));
			currentSong.play();
		}
		else if(clicked == stopSong) {
			currentSong.stop();
		}
		else if(songButtons.contains(clicked)) {
			if(currentSong != null) {
				currentSong.stop();
			}
			currentSong = songs.get(songButtons.indexOf(clicked));
			currentSong.play();
		}
	}
}