/*
 * @author KhoiHT2
 * @date 8 thg 9, 2022
 * @version 1.0
 */



package ass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ass.dbconfig.DbConnection;
import ass.model.Intern;
import ass.util.SQLCommand;

public class InternImplDAO implements InternDAO{
    private Connection cnn = null;
    private PreparedStatement stm = null;
	@Override
	public boolean addIntern(Intern it) throws SQLException {
		boolean check = false;
		try {
			cnn = DbConnection.getInstance().getConnection();
			stm = cnn.prepareStatement(SQLCommand.FR_QUERY_ADD);
			stm.setString(1, it.getCandidateID());
			stm.setString(2, it.getFullName());
			stm.setDate(3, new java.sql.Date(it.getBirthDay().getTime()));
			stm.setString(4, it.getEmail());
			stm.setInt(5, it.getCandidateType());
			stm.setString(6,it.getMajor());
			stm.setInt(7, it.getSemester());
			stm.setString(8, it.getUniversityName());
			if (!stm.execute()) {
				check = true;
			} 
		} finally {
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
			return check;
	}
	

}
