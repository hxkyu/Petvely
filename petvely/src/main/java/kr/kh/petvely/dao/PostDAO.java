package kr.kh.petvely.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.petvely.model.vo.PostVO;

public interface PostDAO {

	boolean insertPost(PostVO post);

	List<PostVO> selectPostList();

	PostVO selectPost(int po_num);

	boolean updatePost(PostVO post);

	boolean deletePost(int po_num);

}
