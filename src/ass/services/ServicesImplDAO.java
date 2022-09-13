/*
 * @author KhoiHT2
 * @date 10 thg 9, 2022
 * @version 1.0
 */

package ass.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ass.dbconfig.DbConnection;
import ass.dto.CandidateDTO;
import ass.exception.BirthDayException;
import ass.exception.EmailException;
import ass.model.Experience;
import ass.model.Fresher;
import ass.model.Intern;
import ass.util.SQLCommand;
import ass.util.UserInput;

public class ServicesImplDAO<T> implements ServicesDAO<Object> {	
	private PreparedStatement stm = null;
	private ResultSet rs = null;
	private Connection cnn = null;
	@Override
	public List<?> query(String sql) {
		List<T> result = new ArrayList<>();
		
		try {
			cnn = DbConnection.getInstance().getConnection();
			if (cnn != null) {
				stm = cnn.prepareStatement(sql);
				rs = stm.executeQuery();
				while (rs.next()) {
					if((rs.getInt("candidatetype"))==0){
						Experience ex = new Experience();
						ex.setCandidateID(rs.getString("candidateid"));
						ex.setBirthDay(rs.getDate("birthday"));
						ex.setCandidateType(rs.getInt("candidatetype"));
						ex.setEmail(rs.getString("email"));
						ex.setFullName(rs.getString("fullname"));
						ex.setExpInYear(rs.getInt("expinyear"));
						ex.setProSkill(rs.getString("proskill"));
						result.add((T) ex.showMe());
					}else if((rs.getInt("candidatetype"))==1) {
						Fresher fr = new Fresher();
						fr.setCandidateID(rs.getString("candidateid"));
						fr.setBirthDay(rs.getDate("birthday"));
						fr.setCandidateType(rs.getInt("candidatetype"));
						fr.setEmail(rs.getString("email"));
						fr.setFullName(rs.getString("fullname"));
						fr.setEducation(rs.getString("education"));
						fr.setGraduationDate(rs.getDate("graduationdate"));
						fr.setGraduationRank(rs.getString("graduationrank"));
						result.add((T) fr.showMe());
					}else {
						Intern it = new Intern();
						it.setCandidateID(rs.getString("candidateid"));
						it.setBirthDay(rs.getDate("birthday"));
						it.setCandidateType(rs.getInt("candidatetype"));
						it.setEmail(rs.getString("email"));
						it.setFullName(rs.getString("fullname"));
						it.setMajor(rs.getString("major"));
						it.setSemester(rs.getInt("semester"));
						it.setUniversityName(rs.getString("universityname"));
						result.add((T) it.showMe());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String getFullName(String sql) {
		StringBuffer sb = new StringBuffer();
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection cnn = null;
		try {
			cnn = DbConnection.getInstance().getConnection();
			if (cnn != null) {
				stm = cnn.prepareStatement(sql);
				rs = stm.executeQuery();
				while (rs.next()) {
					sb.append(rs.getString("fullname"));
					sb.append(",");
					}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public List<CandidateDTO> queryGetAllCandidate(String sql) {
		List<CandidateDTO> result = new ArrayList<>();		
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection cnn = null;		
		try {
			cnn = DbConnection.getInstance().getConnection();
			if (cnn != null) {
				stm = cnn.prepareStatement(sql);
				rs = stm.executeQuery();								
				while (rs.next()) {											
						CandidateDTO candidatedto = new CandidateDTO();
						candidatedto.setExpInYear(rs.getInt("expinyear"));
						candidatedto.setProSkill(rs.getString("proskill"));												
						candidatedto.setCandidateID(rs.getString("candidateid"));
						candidatedto.setBirthDay(rs.getDate("birthday"));
						candidatedto.setCandidateType(rs.getInt("candidatetype"));
						candidatedto.setEmail(rs.getString("email"));
						candidatedto.setFullName(rs.getString("fullname"));						
						candidatedto.setEducation(rs.getString("education"));
						candidatedto.setGraduationDate(rs.getDate("graduationdate"));
						candidatedto.setGraduationRank(rs.getString("graduationrank"));
						candidatedto.setMajor(rs.getString("major"));
						candidatedto.setSemester(rs.getInt("semester"));
						candidatedto.setUniversityName(rs.getString("universityname"));						
						result.add(candidatedto);
			         }
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


// update using resultSet
	@Override
	public void updateCandidateByID(String candidateID) throws SQLException {		
		try {
			cnn = DbConnection.getInstance().getConnection();
			stm = cnn.prepareStatement(SQLCommand.UPDATE_CANDIDATE_BY_ID,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stm.setString(1, candidateID);
			rs = stm.executeQuery();
			if(rs==null) {
				System.out.println("ID not found");
				System.exit(0);
			}else {
				rs.beforeFirst();
				while (rs.next()) {					
					if((rs.getInt("candidatetype")) ==0){					
						Experience candidate = inputEXperience();					
						rs.updateString("fullname", candidate.getFullName());
						rs.updateString("email", candidate.getEmail());
						rs.updateString("proskill", candidate.getProSkill());
						rs.updateInt("expinyear", candidate.getExpInYear());
						rs.updateDate("birthday", new java.sql.Date(candidate.getBirthDay().getTime()));					
						rs.updateRow();
					}else if((rs.getInt("candidatetype")) ==1){	
						Fresher candidate = inputFresher();
						rs.updateString("fullname", candidate.getFullName());
						rs.updateString("email", candidate.getEmail());
						rs.updateDate("graduationdate", new java.sql.Date(candidate.getGraduationDate().getTime()));
						rs.updateString("education", candidate.getEducation());
						rs.updateDate("birthday", new java.sql.Date(candidate.getBirthDay().getTime()));
						rs.updateString("graduationrank", candidate.getGraduationRank());
						rs.updateRow();
					}else {
						Intern candidate = inputIntern();
						rs.updateString("fullname", candidate.getFullName());
						rs.updateString("email", candidate.getEmail());
						rs.updateDate("birthday", new java.sql.Date(candidate.getBirthDay().getTime()));
						rs.updateString("major", candidate.getMajor());
						rs.updateInt("semester", candidate.getSemester());					
						rs.updateString("universityname", candidate.getUniversityName());
						rs.updateRow();
					}
					
				}
			}			
			
		}finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Update sucessful !");
									
	}
	
	// insert using ResultSet
		@Override
		public void insertCandidate(int candidateType) throws SQLException {
			try {
				Scanner sc = new Scanner(System.in);
				cnn = DbConnection.getInstance().getConnection();
				stm = cnn.prepareStatement(SQLCommand.INSERT_CANDIDATE,
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);				
				rs = stm.executeQuery();				
				rs.moveToInsertRow();				
				if(candidateType ==0){					
					Experience candidate = inputEXperience();
					System.out.println("Enter candidateID :");
					String candidateID = sc.nextLine();
					rs.updateInt("candidatetype",candidateType);
					rs.updateString("candidateid", candidateID);
					rs.updateString("fullname", candidate.getFullName());
					rs.updateString("email", candidate.getEmail());
					rs.updateString("proskill", candidate.getProSkill());
					rs.updateInt("expinyear", candidate.getExpInYear());
					rs.updateDate("birthday", new java.sql.Date(candidate.getBirthDay().getTime()));					
					rs.insertRow();
				}else if(candidateType ==1){	
					Fresher candidate = inputFresher();
					System.out.println("Enter candidateID :");
					String candidateID = sc.nextLine();
					rs.updateInt("candidatetype",candidateType);
					rs.updateString("candidateid", candidateID);
					rs.updateString("fullname", candidate.getFullName());
					rs.updateString("email", candidate.getEmail());
					rs.updateDate("graduationdate", new java.sql.Date(candidate.getGraduationDate().getTime()));
					rs.updateString("education", candidate.getEducation());
					rs.updateDate("birthday", new java.sql.Date(candidate.getBirthDay().getTime()));
					rs.updateString("graduationrank", candidate.getGraduationRank());
					rs.insertRow();
				}else {
					Intern candidate = inputIntern();
					System.out.println("Enter candidateID :");
					String candidateID = sc.nextLine();
					rs.updateInt("candidatetype",candidateType);
					rs.updateString("candidateid", candidateID);
					rs.updateString("fullname", candidate.getFullName());
					rs.updateString("email", candidate.getEmail());
					rs.updateDate("birthday", new java.sql.Date(candidate.getBirthDay().getTime()));
					rs.updateString("major", candidate.getMajor());
					rs.updateInt("semester", candidate.getSemester());					
					rs.updateString("universityname", candidate.getUniversityName());
					rs.insertRow();
				}
				
				sc.close();
			}finally {
				try {
					if (cnn != null) {
						cnn.close();
					}
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Insert sucessful !");
			
		}
	

	
// input dữ liệu khi update 	
	public Experience inputEXperience() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Scanner sc = new Scanner(System.in);
		Experience exp0 = new Experience();
		try {
			System.out.println("Enter new fullname :");
			exp0.setFullName(sc.nextLine());
			String birthday;
			try {
				birthday = UserInput.checkBirthday1(sc);
				date = df.parse(birthday);
				exp0.setBirthDay(date);
				
			} catch (BirthDayException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.exit(0);
			}										
			try {
				exp0.setEmail(UserInput.checkEmail1(sc));
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
			System.out.println("Enter new ExpInyear: ");
			exp0.setExpInYear(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter new proskill: ");
			exp0.setProSkill(sc.nextLine());	
		}catch(Exception e){
			System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!”");
			System.exit(0);
		}
		return exp0;
	}
		
	public Fresher inputFresher() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Scanner sc = new Scanner(System.in);
		Fresher f1 = new Fresher();
		try {			
			System.out.println("Enter new fullname: ");
			f1.setFullName(sc.nextLine());
			String birthday = UserInput.checkBirthday(sc);					
			date = df.parse(birthday);
			f1.setBirthDay(date);			
			f1.setEmail(UserInput.checkEmail(sc));
			System.out.println("Enter new Fresher graduationdate use string format like (01/01/1990)");
			String graduationDate = sc.nextLine();
			f1.setGraduationDate(df.parse(graduationDate));
			System.out.println("Enter new graduation rank :");
			f1.setGraduationRank(sc.nextLine());
			System.out.println("Enter new education :");
			f1.setEducation(sc.nextLine());
		} catch (Exception e) {
			System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
		    System.exit(0);
		}
		return f1;
	}
	
	public Intern inputIntern() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Scanner sc = new Scanner(System.in);
		Intern it1 = new Intern();
		try {			
			System.out.println("Enter new Intern fullname: ");
			it1.setFullName(sc.nextLine());
			String birthday = UserInput.checkBirthday(sc);
			date = df.parse(birthday);
			it1.setBirthDay(date);			
			it1.setEmail(UserInput.checkEmail(sc));
			System.out.println("Enter new  major:");
			it1.setMajor(sc.nextLine());
			sc.nextLine();
			System.out.println("Enter new semester :");
			it1.setSemester(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter new Universityname :");
			it1.setUniversityName(sc.nextLine());
		} catch (Exception e) {
			System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
		    System.exit(0);
		}
		return it1;
	}


	
//	@Override
//	public List<Object> queryGetAllCandidate1(String sql) {
//		List<T> result = new ArrayList<>();		
//		PreparedStatement stm = null;
//		ResultSet rs = null;
//		Connection cnn = null;	
//		Candidate c =null;
//		try {
//			cnn = DbConnection.getInstance().getConnection();
//			if (cnn != null) {
//				stm = cnn.prepareStatement(sql);
//				rs = stm.executeQuery();
//				System.out.println(rs);
//				while (rs.next()) {		
//					if((rs.getInt("candidatetype"))==0){
//						c = new Experience();
//						c.setCandidateID(rs.getString("candidateid"));
//						c.setBirthDay(rs.getDate("birthday"));
//						c.setCandidateType(rs.getInt("candidatetype"));
//						c.setEmail(rs.getString("email"));
//						c.setFullName(rs.getString("fullname"));
//						((Experience) c).setExpInYear(rs.getInt("expinyear"));
//						((Experience) c).setProSkill(rs.getString("proskill"));
//						result.add((T) c);
//					}else if((rs.getInt("candidatetype"))==1) {
//						c = new Fresher();
//						c.setCandidateID(rs.getString("candidateid"));
//						c.setBirthDay(rs.getDate("birthday"));
//						c.setCandidateType(rs.getInt("candidatetype"));
//						c.setEmail(rs.getString("email"));
//						c.setFullName(rs.getString("fullname"));
//						((Fresher) c).setEducation(rs.getString("education"));
//						((Fresher) c).setGraduationDate(rs.getDate("graduationdate"));
//						((Fresher) c).setGraduationRank(rs.getString("graduationrank"));
//						result.add((T) c);
//					}else {
//						c = new Intern();
//						c.setCandidateID(rs.getString("candidateid"));
//						c.setBirthDay(rs.getDate("birthday"));
//						c.setCandidateType(rs.getInt("candidatetype"));
//						c.setEmail(rs.getString("email"));
//						c.setFullName(rs.getString("fullname"));
//						((Intern) c).setMajor(rs.getString("major"));
//						((Intern) c).setSemester(rs.getInt("semester"));
//						((Intern) c).setUniversityName(rs.getString("universityname"));
//						result.add((T) c);
//					}
//			   }
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return (List<Object>) result;
//	}
//
//	@Override
//	public Candidate candidate(ResultSet rs) {
//		Candidate result =null;
//		try {
//			
//			String candidateID = rs.getString("candidateid");
//			String fullName = rs.getString("fullname");
//			String email = rs.getString("email");
//			Date birthDay = rs.getDate("birthday");
//			if(rs.getInt("candidatetype")==0) {
//				int expInYear = rs.getInt("expinyear");
//				String proSkill = rs.getNString("proskill");
//				result = new Experience(candidateID,fullName,birthDay, email,0,0l, null, expInYear, proSkill);
//			}else if(rs.getInt("candidatetype")==1) {
//				Date graduationDate = rs.getDate("graduationdate");
//				String graduationRank = rs.getString("graduationrank");
//				String education = rs.getString("education");
//				result = new Fresher(candidateID, fullName, birthDay , email, 0,0l, null, graduationDate, graduationRank, education);
//			}else {
//				String major = rs.getString("major");
//				int semester = rs.getInt("semester");
//				String universityName = rs.getString("universityname");
//				result = new Intern (candidateID, fullName, birthDay , email, 0,0l, null, major, semester, universityName);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
}
