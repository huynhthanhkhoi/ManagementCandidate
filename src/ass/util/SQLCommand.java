/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */



package ass.util;

public class SQLCommand {
	 public static final String EX_QUERY_ADD = "INSERT INTO dbo.Candidate(candidateid, fullname, birthday, email,candidatetype, expinyear, proskill) VALUES (?, ?, ?, ?, ?, ?, ?)";
	  
	 public static String FR_QUERY_ADD = "INSERT INTO dbo.Candidate(candidateid, fullname, birthday, email,candidatetype, graduationdate, graduationrank, education) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	 
	 public static String IT_QUERY_ADD = "INSERT INTO dbo.Candidate(candidateid, fullname, birthday, email, candidatetype, major, semester, universityname) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	 
	 
	 public static final String CT_ADD_QUERY = "INSERT INTO dbo.Certification(certificatedid,certificatedname,certificatedrank,certificateddate,candidateid) VALUES (?, ?, ?, ?, ?)";
	 
	 public static final String GET_NAME = "SELECT fullname FROM dbo.Candidate";
	 
	 public static final String GET_ALL = "SELECT * FROM dbo.Candidate";
	 
	 
	 public static final String UPDATE_CANDIDATE_BY_ID = "SELECT * FROM dbo.Candidate WHERE candidateid = ?";
	 
	 public static final String UPDATE_FRESHER_BY_ID = "SELECT * FROM dbo.Candidate WHERE candidateid = ? AND candidatetype = 1";
	 
	 public static final String UPDATE_INTERN_BY_ID = "SELECT * FROM dbo.Candidate WHERE candidateid = ? AND candidatetype = 2";
	 
	 public static final String INSERT_CANDIDATE = "SELECT * FROM dbo.Candidate";
}
