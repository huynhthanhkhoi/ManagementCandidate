/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */

package ass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ass.dbconfig.DbConnection;
import ass.model.Experience;
import ass.util.SQLCommand;

public class ExperienceImplDAO implements ExperienceDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
//	private ResultSet rs = null;
//    private CallableStatement caStatement = null;
//    private ResultSet results = null;

	@Override
	public boolean addExperience(Experience ex) throws SQLException {
		boolean check = false;
		try {
			connection = DbConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.EX_QUERY_ADD);
			preparedStatement.setString(1, ex.getCandidateID());
			preparedStatement.setString(2, ex.getFullName());
			preparedStatement.setDate(3, new java.sql.Date(ex.getBirthDay().getTime()));
			preparedStatement.setString(4, ex.getEmail());
			preparedStatement.setInt(5, ex.getCandidateType());
			preparedStatement.setInt(6, ex.getExpInYear());
			preparedStatement.setString(7, ex.getProSkill());
			if (!preparedStatement.execute()) {
				check = true;
			}

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;

	}

	
	
	
}
