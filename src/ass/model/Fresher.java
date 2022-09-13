/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */

package ass.model;

import java.util.Date;
import java.util.List;

public class Fresher extends Candidate {

	private Date graduationDate;

	private String graduationRank;

	private String education;

	public Fresher() {

	}

	public Fresher(String candidateID, String fullName, Date birthDay, String email, int candidateType,
			long candidatCount, List<Certification> certification, Date graduationDate, String graduationRank,
			String education) {
		super(candidateID, fullName, birthDay, email, candidateType, candidatCount, certification);
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
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

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString() +" , " +  this.education +" , " + this.graduationRank +" , " + this.graduationDate;
//	}

	@Override
	public String showMe() {
		return super.toString() + " , " + this.education + " , " + this.graduationRank + " , " + this.graduationDate;
	}

}
