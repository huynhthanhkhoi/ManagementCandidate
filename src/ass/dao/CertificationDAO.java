/*
 * @author KhoiHT2
 * @date 8 thg 9, 2022
 * @version 1.0
 */



package ass.dao;

import java.sql.SQLException;
import java.util.List;

import ass.model.Certification;

public interface CertificationDAO {
	
	boolean addCertification(List<Certification> ctList) throws SQLException;

}
