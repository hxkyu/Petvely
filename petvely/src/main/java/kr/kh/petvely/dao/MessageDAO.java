package kr.kh.petvely.dao;

import java.util.List;

import kr.kh.petvely.model.vo.MarketPostVO;
import kr.kh.petvely.model.vo.MemberVO;
import kr.kh.petvely.model.vo.MessageVO;
import kr.kh.petvely.model.vo.PostVO;

public interface MessageDAO {

	boolean insertMessage(MessageVO message);

	List<MessageVO> selectMessages(int mes_num);

	List<MemberVO> selectMemberIds(int senderNum);

	Integer selectReceiverId(String receiverId);

	Integer selectsenderId(String senderId);

	PostVO selectPostUserNum(int po_num);

	boolean insertMarketMessage(MessageVO message);





	
}
