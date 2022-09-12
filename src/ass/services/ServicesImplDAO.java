/*
 * @author KhoiHT2
 * @date 10 thg 9, 2022
 * @version 1.0
 */

package ass.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ass.dbconfig.DbConnection;
import ass.model.Experience;
import ass.model.Fresher;
import ass.model.Intern;

public class ServicesImplDAO<T> implements ServicesDAO {

	@Override
	public List<?> query(String sql) {
		List<T> result = new ArrayList<>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection cnn = null;
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
						result.add((T)ex.showMe());
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
	

}
