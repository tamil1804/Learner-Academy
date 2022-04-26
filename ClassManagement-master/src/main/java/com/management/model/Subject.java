package com.management.model;

public class Subject {
	private int subjectID;
	private String name;
	private String teacherName;
	
	public Subject(int subjectID,String name,String teacherName) {
		this.subjectID = subjectID;
		this.name = name;
		this.teacherName = teacherName;
	}
	
	/**
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	private String batchID;
	/**
	 * @return the subjectID
	 */
	public int getSubjectID() {
		return subjectID;
	}

	/**
	 * @param subjectID the subjectID to set
	 */
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	/**
	 * @return the batchID
	 */
	public String getBatchID() {
		return batchID;
	}

	/**
	 * @param batchID the batchID to set
	 */
	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}
	
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
