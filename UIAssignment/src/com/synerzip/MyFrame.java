package com.synerzip;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// TODO: Auto-generated Javadoc
/**
 * The Class MyFrame.
 */
public class MyFrame extends Frame implements WindowListener {

	/** The search text. */
	TextField tf;
	
	/** The tf 2. */
	TextField tf2;
	
	/** The tf 3. */
	TextField tf3;
	
	/** The marks. */
	TextField marks;
	
	/** The previous id. */
	TextField previousId;
	
	/** The next id. */
	TextField nextId;
	
	/** The search text. */
	TextField searchText;

	/** The search text lable. */
	Label rollNumberLable;
	
	/** The name lable. */
	Label nameLable;
	
	/** The address lable. */
	Label addressLable;
	
	/** The marks lable. */
	Label marksLable;
	
	/** The age lable. */
	Label ageLable;
	
	/** The gender lable. */
	Label genderLable;
	
	/** The search text lable. */
	Label searchTextLable;

	/** The address. */
	TextArea address;

	/** The age. */
	Choice age;

	/** The cbg. */
	CheckboxGroup cbg;

	/** The female. */
	Checkbox male, female;

	/** The delete. */
	Button pre;
	
	/** The next. */
	Button next;
	
	/** The first. */
	Button first;
	
	/** The last. */
	Button last;
	
	/** The save. */
	Button save;
	
	/** The update. */
	Button update;
	
	/** The search. */
	Button search;
	
	/** The delete. */
	Button delete;

	/**
	 * Instantiates a new my frame.
	 *
	 * @param title
	 *            the title
	 */
	public MyFrame(String title) {
		this.setBounds(100, 100, 800, 800);
		setVisible(true);
		setBackground(Color.white);
		setTitle(title);
		setLayout(null);

		// search Field
		searchText = new TextField();
		searchTextLable = new Label("search : ");
		searchTextLable.setBounds(50, 50, 50, 20);
		add(searchTextLable);
		searchText.setBounds(150, 50, 200, 30);
		add(searchText);
		add(searchText);

		// roll number
		tf = new TextField();
		rollNumberLable = new Label("Roll No : ");
		rollNumberLable.setBounds(50, 100, 50, 20);
		add(rollNumberLable);
		tf.setBounds(150, 100, 200, 30);
		add(rollNumberLable);
		add(tf);

		// Name
		nameLable = new Label("Name:");
		nameLable.setBounds(50, 150, 50, 20);
		add(nameLable);
		tf2 = new TextField();
		tf2.setBounds(150, 150, 200, 30);
		add(tf2);

		// Address
		addressLable = new Label("Address:");
		addressLable.setBounds(50, 200, 50, 20);
		add(addressLable);
		address = new TextArea();
		address.setBounds(150, 200, 200, 75);
		add(address);

		// Marks
		marksLable = new Label("Marks:");
		marksLable.setBounds(50, 300, 50, 20);
		add(marksLable);
		marks = new TextField();
		marks.setBounds(150, 300, 200, 30);
		add(marks);

		// age
		ageLable = new Label("Age:");
		ageLable.setBounds(50, 350, 50, 20);
		add(ageLable);
		age = new Choice();

		// add items to the choice
		age.add("20");
		age.add("21");
		age.add("22");
		age.add("23");

		age.setBounds(150, 350, 50, 30);
		add(age);

		// Gender
		genderLable = new Label("Gender:");
		genderLable.setBounds(50, 350, 120, 20);
		add(genderLable);

		cbg = new CheckboxGroup();
		male = new Checkbox("Male", cbg, true);
		male.setBounds(150, 370, 70, 50);
		female = new Checkbox(" Female", cbg, false);
		female.setBounds(225, 370, 70, 50);
		add(male);
		add(female);

		save = new Button("Save");
		save.setBounds(100, 420, 70, 30);

		update = new Button("Update");
		update.setBounds(200, 420, 70, 30);

		delete = new Button("Delete");
		delete.setBounds(300, 420, 70, 30);

		search = new Button("Search");
		search.setBounds(400, 420, 70, 30);

		add(save);
		add(update);
		add(delete);
		add(search);

		first = new Button("First");
		first.setBounds(100, 500, 70, 30);

		pre = new Button("Pre");
		pre.setBounds(200, 500, 70, 30);

		next = new Button("Next");
		next.setBounds(300, 500, 70, 30);

		last = new Button("Last");
		last.setBounds(400, 500, 70, 30);
		// hidden field
		previousId = new TextField();
		previousId.setBounds(500, 500, 50, 50);
		add(previousId);
		previousId.setVisible(false);

		nextId = new TextField();
		nextId.setBounds(500, 500, 50, 50);
		add(nextId);
		nextId.setVisible(false);

		add(first);
		add(pre);
		add(next);
		add(last);
		pre.setEnabled(false);
		next.setEnabled(false);
		update.setEnabled(false);
		delete.setEnabled(false);

		save.addActionListener(new JugglerButtonHandler(this, "Save"));
		update.addActionListener(new JugglerButtonHandler(this, "Update"));
		first.addActionListener(new JugglerButtonHandler(this, "First"));
		last.addActionListener(new JugglerButtonHandler(this, "Last"));
		pre.addActionListener(new JugglerButtonHandler(this, "Pre"));
		next.addActionListener(new JugglerButtonHandler(this, "Next"));
		delete.addActionListener(new JugglerButtonHandler(this, "Delete"));
		search.addActionListener(new JugglerButtonHandler(this, "Search"));
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		MyFrame mf = (MyFrame) e.getSource();
		mf.dispose();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
