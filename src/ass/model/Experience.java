/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */

package ass.model;

import java.util.Date;
import java.util.List;

public class Experience extends Candidate {
	private int expInYear;
	private String proSkill;

	public Experience() {

	}

	public Experience(int expInYear, String proSkill) {
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public Experience(String candidateID, String fullName, Date birthDay, String email, int candidateType,
			long candidatCount, List<Certification> certification, int expInYear, String proSkill) {
		super(candidateID, fullName, birthDay, email, candidateType, candidatCount, certification);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
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

	

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString() + " , " + this.expInYear + " , " + this.proSkill;
//	}

	@Override
	public String showMe() {
		return super.toString() + " , " + this.expInYear + " , " + this.proSkill;
	}
	
	
	
	

}
