package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton("add task");
	JButton viewTasks = new JButton("view tasks");
	JButton removeTask = new JButton("remove task");
	JButton saveList = new JButton("save list");
	JButton loadList = new JButton("load list");
	ArrayList<String> list = new ArrayList<String>();

	void run() {
		frame.setVisible(true);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.add(panel);
		frame.pack();
		

		addTask.addActionListener((s) -> {
			list.add(JOptionPane.showInputDialog("Add a task"));
		});
		viewTasks.addActionListener((s) -> {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		});
		removeTask.addActionListener((s) -> {
			list.remove(JOptionPane.showInputDialog("Remove a task"));
		});
		saveList.addActionListener((s) -> {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/test.txt");
				for (int i = 0; i < list.size(); i++) {
					fw.write("\n" + list.get(i));
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		loadList.addActionListener((s) -> {
			try {
				BufferedReader br = new BufferedReader(
						new FileReader("src/_03_To_Do_List/" + JOptionPane.showInputDialog("File name")));
				String line = br.readLine();
				while (line != null) {
					list.add(line);
					line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
