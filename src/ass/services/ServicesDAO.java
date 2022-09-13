/*
 * @author KhoiHT2
 * @date 10 thg 9, 2022
 * @version 1.0
 */



package ass.services;

import java.sql.SQLException;
import java.util.List;

import ass.dto.CandidateDTO;

public interface ServicesDAO<T> {
	
	public  List<?> query(String sql);
	
	
	public String getFullName(String sql);
	
	public List<CandidateDTO> queryGetAllCandidate(String sql);
	
//	public List<T> queryGetAllCandidate1(String sql);
//	// Khởi tạo đối tượng candidate
//	public Candidate candidate(ResultSet rs);

	void updateCandidateByID(String candidateID) throws SQLException;	
	
	void insertCandidate(int candidateType) throws SQLException;	
	

}
