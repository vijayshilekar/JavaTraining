package com.synerzip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.model.StudentModel;
import com.serviceImpl.StudentServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class JugglerButtonHandler.
 */
public class JugglerButtonHandler implements ActionListener {

	/** The studentimpl. */
	StudentServiceImpl studentimpl = new StudentServiceImpl();

	/** The gender. */
	Integer rollNumber;
	
	/** The marks. */
	Integer marks;
	
	/** The age. */
	Integer age;
	
	/** The gender. */
	Integer gender;

	/** The txt filed 2. */
	Integer txtFiled2;

	/** The txt filed 3. */
	Integer txtFiled3;

	/** The address. */
	String name, address;

	/** The my frame. */
	private MyFrame myFrame;

	/** The from button. */
	private String fromButton;

	/**
	 * Instantiates a new juggler button handler.
	 *
	 * @param myFrame
	 *            the my frame
	 * @param fromButton
	 *            the from button
	 */
	public JugglerButtonHandler(MyFrame myFrame, String fromButton) {
		this.myFrame = myFrame;
		this.fromButton = fromButton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		switch (fromButton) {
		case "Save":
			name = myFrame.tf2.getText();
			address = myFrame.address.getText();
			marks = Integer.parseInt(myFrame.marks.getText());
			age = Integer.parseInt(myFrame.age.getSelectedItem());
			gender = myFrame.cbg.getSelectedCheckbox().getLabel().equals("Male") ? 1 : 0;
			StudentModel student = new StudentModel(rollNumber, name, address, marks, age, gender);
			try {
				studentimpl.saveStudent(student);
			} catch (Exception e2) {

			}

			break;
		case "Update":

			rollNumber = Integer.parseInt(myFrame.tf.getText());
			name = myFrame.tf2.getText();
			address = myFrame.address.getText();
			marks = Integer.parseInt(myFrame.marks.getText());
			age = Integer.parseInt(myFrame.age.getItem(age));
			gender = myFrame.cbg.getSelectedCheckbox().getLabel().equals("Male") ? 1 : 0;
			StudentModel studentUpdate = new StudentModel(rollNumber, name, address, marks, age, gender);
			try {
				studentimpl.updateStudent(studentUpdate);
			} catch (Exception e2) {
			}
			break;
		case "First":
			try {
				ResultSet res = studentimpl.getFirstStudent();
				while (res.next()) {
					String roll_number = res.getString("roll_number");
					String name = res.getString("name");
					String address = res.getString("address");
					String marks = res.getString("marks");
					String age = res.getString("age");
					int gender = res.getInt("gender");

					String preId = res.getString("pre");
					String nextId = res.getString("next");
					if (roll_number != null) {
						myFrame.update.setEnabled(true);
						myFrame.delete.setEnabled(true);
					} else {
						myFrame.update.setEnabled(false);
						myFrame.delete.setEnabled(false);
					}
					myFrame.previousId.setText(preId);
					myFrame.nextId.setText(nextId);
					if (nextId != null) {
						myFrame.next.setEnabled(true);
					} else
						myFrame.next.setEnabled(false);

					if (preId != null) {
						myFrame.pre.setEnabled(true);
					} else
						myFrame.pre.setEnabled(false);

					// set values
					myFrame.tf.setText(roll_number);
					myFrame.tf2.setText(name);
					myFrame.address.setText(address);
					myFrame.marks.setText(marks);
					myFrame.age.select(age);
					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
			} catch (Exception e2) {
			}
			break;
		case "Last":
			try {
				ResultSet res = studentimpl.getLastStudent();
				while (res.next()) {
					String roll_number = res.getString("roll_number");
					String name = res.getString("name");
					String address = res.getString("address");
					String marks = res.getString("marks");
					String age = res.getString("age");
					int gender = res.getInt("gender");
					String preId = res.getString("pre");
					String nextId = res.getString("next");
					myFrame.previousId.setText(preId);
					myFrame.nextId.setText(nextId);

					if (roll_number != null) {
						myFrame.update.setEnabled(true);
						myFrame.delete.setEnabled(true);
					} else {
						myFrame.update.setEnabled(false);
						myFrame.delete.setEnabled(false);
					}

					if (nextId != null) {
						myFrame.next.setEnabled(true);
					} else
						myFrame.next.setEnabled(false);

					if (preId != null) {
						myFrame.pre.setEnabled(true);
					} else
						myFrame.pre.setEnabled(false);
					// set values
					myFrame.tf.setText(roll_number);
					myFrame.tf2.setText(name);
					myFrame.address.setText(address);
					myFrame.marks.setText(marks);
					myFrame.age.select(age);
					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
			} catch (Exception e2) {

			}
			break;
		case "Pre":
			try {
				int id = Integer.parseInt(myFrame.previousId.getText());
				ResultSet res = studentimpl.getPreviousOrNextStudent(id);
				while (res.next()) {
					String roll_number = res.getString("roll_number");
					String name = res.getString("name");
					String address = res.getString("address");
					String marks = res.getString("marks");
					String age = res.getString("age");
					int gender = res.getInt("gender");
					String preId = res.getString("pre");
					String nextId = res.getString("next");
					myFrame.previousId.setText(preId);
					myFrame.nextId.setText(nextId);
					if (roll_number != null) {
						myFrame.update.setEnabled(true);
						myFrame.delete.setEnabled(true);
					} else {
						myFrame.update.setEnabled(false);
						myFrame.delete.setEnabled(false);
					}
					if (nextId != null) {
						myFrame.next.setEnabled(true);
					} else
						myFrame.next.setEnabled(false);

					if (preId != null) {
						myFrame.pre.setEnabled(true);
					} else
						myFrame.pre.setEnabled(false);

					// set values
					myFrame.tf.setText(roll_number);
					myFrame.tf2.setText(name);
					myFrame.address.setText(address);
					myFrame.marks.setText(marks);
					myFrame.age.select(age);
					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
			} catch (Exception e2) {
			}
			break;
		case "Next":
			try {
				int id = Integer.parseInt(myFrame.nextId.getText());
				ResultSet res = studentimpl.getPreviousOrNextStudent(id);
				while (res.next()) {
					String roll_number = res.getString("roll_number");
					String name = res.getString("name");
					String address = res.getString("address");
					String marks = res.getString("marks");
					String age = res.getString("age");
					int gender = res.getInt("gender");
					String preId = res.getString("pre");
					String nextId = res.getString("next");

					if (roll_number != null) {
						myFrame.update.setEnabled(true);
						myFrame.delete.setEnabled(true);
					} else {
						myFrame.update.setEnabled(false);
						myFrame.delete.setEnabled(false);
					}

					myFrame.previousId.setText(preId);
					myFrame.nextId.setText(nextId);
					if (nextId != null) {
						myFrame.next.setEnabled(true);
					} else
						myFrame.next.setEnabled(false);

					if (preId != null) {
						myFrame.pre.setEnabled(true);
					} else
						myFrame.pre.setEnabled(false);

					// set values
					myFrame.tf.setText(roll_number);
					myFrame.tf2.setText(name);
					myFrame.address.setText(address);
					myFrame.marks.setText(marks);
					myFrame.age.select(age);
					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
			} catch (Exception e2) {
			}
			break;
		case "Delete":
			try {
				int id = Integer.parseInt(myFrame.tf.getText());
				studentimpl.deleteStudent(id);
			} catch (Exception e2) {
			}
			break;
		case "Search":
			try {
				int rollNumber = Integer.parseInt(myFrame.searchText.getText());
				ResultSet res = studentimpl.searchStudent(rollNumber);
				while (res.next()) {
					String roll_number = res.getString("roll_number");
					String name = res.getString("name");
					String address = res.getString("address");
					String marks = res.getString("marks");
					String age = res.getString("age");
					int gender = res.getInt("gender");
					String preId = res.getString("pre");
					String nextId = res.getString("next");

					if (roll_number != null) {
						myFrame.update.setEnabled(true);
						myFrame.delete.setEnabled(true);
					} else {
						myFrame.update.setEnabled(false);
						myFrame.delete.setEnabled(false);
					}

					myFrame.previousId.setText(preId);
					myFrame.nextId.setText(nextId);
					if (nextId != null) {
						myFrame.next.setEnabled(true);
					} else
						myFrame.next.setEnabled(false);

					if (preId != null) {
						myFrame.pre.setEnabled(true);
					} else
						myFrame.pre.setEnabled(false);

					// set values
					myFrame.tf.setText(roll_number);
					myFrame.tf2.setText(name);
					myFrame.address.setText(address);
					myFrame.marks.setText(marks);
					myFrame.age.select(age);
					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
			} catch (Exception e2) {

			}
			break;
		default:
			break;
		}
	}
}
