package com.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comman.DbHelper;
import com.model.StudentModel;
import com.service.StudentService;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentServiceImpl.
 */
public class StudentServiceImpl implements StudentService {

	/** The res. */
	ResultSet res;

	/** The roll number. */
	private int rollNumber;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#saveStudent(com.model.StudentModel)
	 */
	@Override
	public void saveStudent(StudentModel s) {
		try {
			Connection con = DbHelper.getConnection();
			String q = "insert into studentDetails(roll_number,name,address,marks,age,gender) value(?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setInt(1, s.getRollNo());
			stmt.setString(2, s.getName());
			stmt.setString(3, s.getAddress());
			stmt.setInt(4, s.getMarks());
			stmt.setInt(5, s.getAge());
			stmt.setInt(6, s.getGender());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#updateStudent(com.model.StudentModel)
	 */
	@Override
	public void updateStudent(StudentModel s) {

		try {
			Connection con = DbHelper.getConnection();

			String checkQuery = "select roll_number from studentDetails where roll_number =" + s.getRollNo();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);

			while (res.next()) {
				rollNumber = res.getInt(1);
			}
			if (rollNumber == s.getRollNo()) {
				String q = "Update studentDetails set roll_number =" + s.getRollNo() + ", name ='" + s.getName()
				+ "', address= '" + s.getAddress() + "' ,marks=" + s.getMarks() + ", age=" + s.getAge()
				+ ", gender=" + s.getGender() + " where roll_number =" + s.getRollNo();
				PreparedStatement preparedStatment = con.prepareStatement(q);
				int count = preparedStatment.executeUpdate(q);
			} else {
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#getFirstStudent()
	 */
	@Override
	public ResultSet getFirstStudent() {
		res = null;
		try {
			Connection con = DbHelper.getConnection();
			String presubQuery = "(select max(id) from studentDetails where id < (SELECT id FROM studentDetails ORDER BY id ASC LIMIT 1)) as pre, ";
			String nextSubQuery = "(select MIN(id) from studentDetails where id > (SELECT id FROM studentDetails ORDER BY id Asc LIMIT 1)) as next, ";
			String checkQuery = "select " + presubQuery + " " + nextSubQuery
					+ " roll_number,name,address,marks,age,gender from studentDetails ORDER BY id ASC LIMIT 1";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#getLastStudent()
	 */
	@Override
	public ResultSet getLastStudent() {
		res = null;
		try {
			Connection con = DbHelper.getConnection();
			String presubQuery = "(select max(id) from studentDetails where id < (SELECT id FROM studentDetails ORDER BY id DESC LIMIT 1)) as pre, ";
			String nextSubQuery = "(select MIN(id) from studentDetails where id > (SELECT id FROM studentDetails ORDER BY id DESC LIMIT 1)) as next, ";
			String checkQuery = "select " + presubQuery + " " + nextSubQuery
					+ " roll_number,name,address,marks,age,gender from studentDetails ORDER BY id DESC LIMIT 1";

			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#getPreviousOrNextStudent(int)
	 */
	@Override
	public ResultSet getPreviousOrNextStudent(int id) {
		res = null;
		try {
			Connection con = DbHelper.getConnection();
			String presubQuery = "(select max(id) from studentDetails where id < " + id + ") as pre, ";
			String nextSubQuery = "(select MIN(id) from studentDetails where id > " + id + ") as next, ";
			String checkQuery = "select " + presubQuery + " " + nextSubQuery
					+ " roll_number,name,address,marks,age,gender from studentDetails where id =" + id;

			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#deleteStudent(int)
	 */
	@Override
	public void deleteStudent(int id) {
		try {
			Connection con = DbHelper.getConnection();
			String checkQuery = "DELETE FROM studentDetails where id =" + id;

			Statement stmt = con.createStatement();
			stmt.executeUpdate(checkQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.StudentService#searchStudent(int)
	 */
	@Override
	public ResultSet searchStudent(int rollNumber) {
		res = null;
		try {
			Connection con = DbHelper.getConnection();
			String presubQuery = "(select max(id) from studentDetails where id < (SELECT id FROM studentDetails where roll_number= "
					+ rollNumber + " ORDER BY id DESC LIMIT 1)) as pre, ";
			String nextSubQuery = "(select min(id) from studentDetails where id > (SELECT id FROM studentDetails where roll_number= "
					+ rollNumber + " ORDER BY id DESC LIMIT 1)) as next, ";
			String checkQuery = "select " + presubQuery + " " + nextSubQuery
					+ " roll_number,name,address,marks,age,gender from studentDetails where roll_number =" + rollNumber;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
