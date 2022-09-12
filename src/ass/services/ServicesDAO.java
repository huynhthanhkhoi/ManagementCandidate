/*
 * @author KhoiHT2
 * @date 10 thg 9, 2022
 * @version 1.0
 */



package ass.services;

import java.util.List;

public interface ServicesDAO<T> {
	
	public  List<?> query(String sql);
	
	
	public String getFullName(String sql);

}
