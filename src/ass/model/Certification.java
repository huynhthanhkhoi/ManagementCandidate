/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */

package ass.model;

import java.util.Date;

public class Certification {
	private String certificatedID;
	private String certificatedName;
	private String certificatedRank;
	private Date certificatedDate;
	private String candidateID;
	
	public Certification() {
		
	}

	public Certification(String certificatedID, String certificatedName, String certificatedRank,
			Date certificatedDate) {
		this.certificatedID = certificatedID;
		this.certificatedName = certificatedName;
		this.certificatedRank = certificatedRank;
		this.certificatedDate = certificatedDate;
	}

	public String getCertificatedID() {
		return certificatedID;
	}

	public void setCertificatedID(String certificatedID) {
		this.certificatedID = certificatedID;
	}

	public String getCertificatedName() {
		return certificatedName;
	}

	public void setCertificatedName(String certificatedName) {
		this.certificatedName = certificatedName;
	}

	public String getCertificatedRank() {
		return certificatedRank;
	}

	public void setCertificatedRank(String certificatedRank) {
		this.certificatedRank = certificatedRank;
	}

	public Date getCertificatedDate() {
		return certificatedDate;
	}

	public void setCertificatedDate(Date certificatedDate) {
		this.certificatedDate = certificatedDate;
	}

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateid) {
		this.candidateID = candidateid;
	}

}
