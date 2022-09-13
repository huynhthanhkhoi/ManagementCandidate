/*
 * @author KhoiHT2
 * @date 12 thg 9, 2022
 * @version 1.0
 */



package ass.util;

import java.text.SimpleDateFormat;
import java.util.Comparator;

import ass.dto.CandidateDTO;

public class CandidateComparator implements Comparator<CandidateDTO>{

	@Override
	public int compare(CandidateDTO o1, CandidateDTO o2) {
		// TODO Auto-generated method stub
		int value1 = o1.getCandidateType()-o2.getCandidateType();
		if(value1!=0) {
			return value1;
		}else {
			SimpleDateFormat dfyear = new SimpleDateFormat("yyyy");
			int value2 = Integer.parseInt(dfyear.format(o2.getBirthDay())) - Integer.parseInt(dfyear.format(o1.getBirthDay()));
			return value2;
		}
		
	}

	

	


}
