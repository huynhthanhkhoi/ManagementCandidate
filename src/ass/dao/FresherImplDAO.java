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
import ass.model.Fresher;
import ass.util.SQLCommand;

public class FresherImplDAO implements FresherDAO {
	private Connection cnn = null;
	private PreparedStatement stm = null;

	@Override
	public boolean addFresher(Fresher f) throws SQLException {
		boolean check = false;
		try {
			cnn = DbConnection.getInstance().getConnection();
			stm = cnn.prepareStatement(SQLCommand.FR_QUERY_ADD);
			stm.setString(1, f.getCandidateID());
			stm.setString(2, f.getFullName());
			stm.setDate(3, new java.sql.Date(f.getBirthDay().getTime()));
			stm.setString(4, f.getEmail());
			stm.setInt(5, f.getCandidateType());
			stm.setDate(6, new java.sql.Date(f.getGraduationDate().getTime()));
			stm.setString(7, f.getGraduationRank());
			stm.setString(8, f.getEducation());
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
