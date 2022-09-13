/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */



package ass.dao;

import java.sql.SQLException;

import ass.model.Experience;

public interface ExperienceDAO {
	
	boolean addExperience(Experience ex) throws SQLException;
	
	

}
