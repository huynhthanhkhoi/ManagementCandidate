/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */



package ass.model;

import java.util.Date;
import java.util.List;

public abstract class Candidate {
private String candidateID;
private String fullName;
private Date birthDay;
private String email;
private int candidateType;
static long candidateCount;
private  List<Certification> certification;



public Candidate() {
	
}

/**
 * @param candidateID
 * @param fullName
 * @param birthDay
 * @param email
 * @param candidateType
 * @param candidatCount
 * @param certification
 */
public Candidate(String candidateID, String fullName, Date birthDay, String email, int candidateType,
		long candidatCount, List<Certification> certification) {
	this.candidateID = candidateID;
	this.fullName = fullName;
	this.birthDay = birthDay;
	this.email = email;
	this.candidateType = candidateType;
	Candidate.candidateCount++;
	this.certification = certification;
}

// tao setter and getter

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


public static long getCandidateCount() {
	return candidateCount;
}

public static void setCandidateCount(long candidateCount) {
	Candidate.candidateCount = candidateCount;
}

public List<Certification> getCertification() {
	return certification;
}


public void setCertification(List<Certification> certification) {
	this.certification = certification;
}


/**
 * phuong thuc abstract showMe() cho cac lop ke thua
 */
public abstract String showMe();

@Override
public String toString() {
	
	return this.candidateID + " , "  + this.candidateType +" , "  + this .fullName  +" , " + this .email +" , " + this.birthDay;
}



}
