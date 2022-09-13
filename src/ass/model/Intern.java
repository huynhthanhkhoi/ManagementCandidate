/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */

package ass.model;

import java.util.Date;
import java.util.List;

public class Intern extends Candidate {

	private String major;

	private int semester;

	private String universityName;
	
	
	public Intern() {
		
	}

	public Intern(String candidateID, String fullName, Date birthDay, String email, int candidateType,
			long candidatCount, List<Certification> certification,String major, int semester, String universityName) {
	super(candidateID, fullName, birthDay, email, candidateType, candidatCount, certification);
		this.major = major;
		this.semester = semester;
		this.universityName = universityName;
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

	

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString() +" , " + this.major +" , " + this.semester +" , " + this.universityName;
//	}

	@Override
	public String showMe() {
		return super.toString() +" , " + this.major +" , " + this.semester +" , " + this.universityName;
	}

	
	
	
}
