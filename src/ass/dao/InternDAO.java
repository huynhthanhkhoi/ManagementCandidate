/*
 * @author KhoiHT2
 * @date 8 thg 9, 2022
 * @version 1.0
 */



package ass.dao;

import java.sql.SQLException;

import ass.model.Intern;

public interface InternDAO {
    boolean addIntern(Intern it) throws SQLException;
}
