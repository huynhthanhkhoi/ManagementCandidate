/*
 * @author KhoiHT2
 * @date 12 thg 9, 2022
 * @version 1.0
 */

package ass.dto;

import java.util.Date;

public class CandidateDTO {
	private String candidateID;
	private String fullName;
	private Date birthDay;
	private String email;
	private int candidateType;
	private int expInYear;
	private String proSkill;
	private Date graduationDate;
	private String graduationRank;
	private String education;
	private String major;
	private int semester;
	private String universityName;
	public String getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCandidateType() {
		return candidateType;
	}
	public void setCandidateType(int candidateType) {
		this.candidateType = candidateType;
	}
	public int getExpInYear() {
		return expInYear;
	}
	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
	public String getProSkill() {
		return proSkill;
	}
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	public Date getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	public String getGraduationRank() {
		return graduationRank;
	}
	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	@Override
	public String toString() {
		
		return this.candidateID + "," + this.candidateType + "," + this.fullName + "," + this.birthDay
				+ "," +this.email + "," + this.expInYear + "," + this.proSkill + "," +this.major + "," + this.semester + "," + this.universityName
				+ "," + this.graduationRank + this.graduationDate + "," + this.education;
	}
	
	

}
