package kr.kh.petvely.model.vo;

import java.util.Date;

import kr.kh.petvely.model.vo.CommunityVO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommunityVO {
	
	private int co_num;
	private String co_name;
	private int co_count;
}