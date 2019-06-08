package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	 /* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	 JFrame frame;
	 JPanel panel;
	 JLabel label;
	Stack<Character> characters = new Stack<Character>();
	Stack<Character> undos = new Stack<Character>();
	
	public static void main(String[] args) {
		_02_TextUndoRedo asdf = new _02_TextUndoRedo();
		asdf.setup();
	}
	
	 void setup() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		label.setText("");
		frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getKeyCode() == KeyEvent.VK_5) {
			if(characters.isEmpty() == false) {
				char toAdd = characters.pop();
				if(toAdd == '\b') {
					undos.push(label.getText().toCharArray()[label.getText().length()-1]);
					label.setText(label.getText().substring(0, label.getText().length()-1));
				}
				else {
					undos.push('\b');
					label.setText(label.getText()+toAdd);
				}
			}
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_6) {
			if(undos.isEmpty() == false) {
				char toDo = undos.pop();
				if(toDo == '\b') {
					characters.push(label.getText().toCharArray()[label.getText().toCharArray().length-1]);
					label.setText(label.getText().substring(0, label.getText().length()-1));
				}
				else {
					characters.push('\b');
					label.setText(label.getText()+toDo);
				}
			}
		}
		else {
		if(arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				if(label.getText().length() > 0) {
					characters.push(label.getText().toCharArray()[label.getText().toCharArray().length-1]);
					label.setText(label.getText().substring(0, label.getText().length()-1));
				}
			}
			else {
				characters.push('\b');
				label.setText(label.getText()+arg0.getKeyChar());
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
