package xupt.se.ttms.service;

import java.util.Stack;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyStack<E> extends Stack<E> {
	private final static MyStack<JPanel> stack = new MyStack<JPanel>();
	
	private MyStack() {
		
	}
	
	public static MyStack<JPanel> getInstance() {
		return stack;
	}
			
}