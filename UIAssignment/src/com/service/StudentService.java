package com.service;

import java.sql.ResultSet;

import com.model.StudentModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentService.
 */
public interface StudentService {

	/**
	 * Save student.
	 *
	 * @param s
	 *            the s
	 */
	public void saveStudent(StudentModel s);

	/**
	 * Update student.
	 *
	 * @param s
	 *            the s
	 */
	public void updateStudent(StudentModel s);

	/**
	 * Gets the first student.
	 *
	 * @return the first student
	 */
	public ResultSet getFirstStudent();

	/**
	 * Gets the last student.
	 *
	 * @return the last student
	 */
	public ResultSet getLastStudent();

	/**
	 * Gets the previous or next student.
	 *
	 * @param id
	 *            the id
	 * @return the previous or next student
	 */
	public ResultSet getPreviousOrNextStudent(int id);

	/**
	 * Delete student.
	 *
	 * @param id
	 *            the id
	 */
	public void deleteStudent(int id);

	/**
	 * Search student.
	 *
	 * @param rollNumber
	 *            the roll number
	 * @return the result set
	 */
	public ResultSet searchStudent(int rollNumber);
}
