package com.synerzip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.model.StudentModel;
import com.serviceImpl.StudentServiceImpl;

public class JugglerButtonHandler implements ActionListener {

	StudentServiceImpl studentimpl = new StudentServiceImpl();
	int rollNumber, marks, age, gender;
	int txtFiled2;
	int txtFiled3;
	String name, address;

	private MyFrame myFrame;
	private String fromButton;

	public JugglerButtonHandler(MyFrame myFrame, String fromButton) {
		this.myFrame = myFrame;
		this.fromButton = fromButton;
	}

	public void actionPerformed(ActionEvent e) {
		switch (fromButton) {
		case "Save":
			/*if ((!myFrame.tf.getText().equals("") && !myFrame.tf2.getText().equals("")
					&& !myFrame.tf2.getText().equals("") && !myFrame.address.getText().equals("")
					&& !myFrame.marks.getText().equals(""))) {
				System.out.println("empty");
				if (myFrame.tf.getText().matches("[0-9]+")) {
					rollNumber = Integer.parseInt(myFrame.tf.getText());
					System.out.println(rollNumber);
				} else {
					JOptionPane.showMessageDialog(null, "Roll Number should be Number");
					return;
				}
				if (myFrame.tf2.getText().matches("[a-zA-Z]+") && myFrame.tf2.getText().length() > 2) {
					rollNumber = Integer.parseInt(myFrame.tf.getText());
					System.out.println(rollNumber);
				} else {
					JOptionPane.showMessageDialog(null, "Name should be String !!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Field Should not be empty");
				return;
			}*/

			name = myFrame.tf2.getText(); 
			address = myFrame.address.getText(); 
			marks = Integer.parseInt(myFrame.marks.getText()); 
			age =Integer.parseInt(myFrame.age.getSelectedItem()); 
			gender =myFrame.cbg.getSelectedCheckbox().getLabel().equals("Male") ? 1 :0; 
			System.out.println("id = " + myFrame.previousId.getText());
			StudentModel student = new StudentModel(rollNumber, name, address, marks, age, gender); 
			try {
				studentimpl.saveStudent(student); System.out.println(
						"Student Data save SuccessFully !!"); 
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
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
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
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
					System.out.println(age);
					myFrame.age.select(age);
					if (gender == 1)
						myFrame.cbg.setSelectedCheckbox(myFrame.male);
					else
						myFrame.cbg.setSelectedCheckbox(myFrame.female);
				}
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
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
					System.out.println("next:" + nextId + "Pre:" + preId);
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
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
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
					System.out.println("next:" + nextId + "Pre:" + preId);
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
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
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
					System.out.println("next:" + nextId + "Pre:" + preId);

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
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
			}
			break;
		case "Delete":
			try {
				int id = Integer.parseInt(myFrame.tf.getText());
				studentimpl.deleteStudent(id);
				System.out.println("Student Data Deleted SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to Deleted !!" + e2);
			}
			break;
		case "Search":
			try {
				System.out.println("Search!!");
				int rollNumber = Integer.parseInt(myFrame.searchText.getText());
				System.out.println(rollNumber);
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
					System.out.println("next:" + nextId + "Pre:" + preId);

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
				System.out.println("Student Data Update SuccessFully !!");
			} catch (Exception e2) {
				System.out.println("Not Able to save !!" + e2);
			}
			break;
		default:
			break;
		}
	}
}
