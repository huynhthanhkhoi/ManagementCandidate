/*
 * @author KhoiHT2
 * @date 8 thg 9, 2022
 * @version 1.0
 */



package ass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ass.dbconfig.DbConnection;
import ass.model.Certification;
import ass.util.SQLCommand;

public class CertificationImplDAO implements CertificationDAO{
    private Connection cnn=null;
    private PreparedStatement stm = null;
	@Override
	public boolean addCertification(List<Certification> ctList) throws SQLException {
		boolean check = false;
        int rs[] = null;
        try {
		cnn = DbConnection.getInstance().getConnection();
		stm = cnn.prepareStatement(SQLCommand.CT_ADD_QUERY);
		ctList.stream().forEach((ct) ->{
			 try {
				 stm.setString(1, ct.getCertificatedID());
				 stm.setString(2, ct.getCertificatedName());
				 stm.setString(3, ct.getCertificatedRank());
				 stm.setDate(4, new java.sql.Date(ct.getCertificatedDate().getTime()));
				 stm.setString(5, ct.getCandidateID());
				 stm.addBatch();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
		});
		rs =stm.executeBatch();
		cnn.commit();
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
        if(rs.length>0) {
        	check=true;
        }
		return check;
	}

	

}
