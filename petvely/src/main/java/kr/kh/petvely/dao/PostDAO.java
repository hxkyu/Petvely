package kr.kh.petvely.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Param;

import kr.kh.petvely.model.vo.CommunityVO;
import kr.kh.petvely.model.vo.FileVO;
import kr.kh.petvely.model.vo.PostVO;
import kr.kh.petvely.model.vo.RecommendVO;

public interface PostDAO {
	
	public static final DataSource dataSource = null;
	
	boolean insertPost(PostVO post); //게시글 저장

	// 게시글 목록 조회 (po_delete가 0인 것만)
	List<PostVO> selectPostList(int co_num);
	
	// 특정 게시글 조회 (po_delete가 0인 것만 메퍼 추후처리)
	PostVO selectPost(int po_num);

	boolean updatePost(@Param("po")PostVO post);

	boolean deletePost(int po_num);

	boolean insertBookmark(@Param("po_num")int po_num, @Param("bm_me_num")int bm_me_num);
	
	List<CommunityVO> selectCommunityList();

	void insertFile(FileVO fileVo);
	
	// 게시글 논리적 삭제 (po_delete 값을 1로 업데이트)
	boolean logicalDeletePost(int po_num);
	
	//조회수
	void updateView(int po_num);
    // 추천 정보를 가져오는 메서드
    RecommendVO selectRecommend(RecommendVO recommend);

    // 추천 정보를 추가하는 메서드
    int insertRecommend(RecommendVO recommend);

    // 추천 정보를 삭제하는 메서드
    int deleteRecommend(int re_num);

    // 게시글의 추천수를 업데이트하는 메서드
    int updateRecommendCount(int po_num);
    
    // 게시글 총 개수를 가져오는 메서드
	int selectCountPostList(int co_num);
	
	boolean deleteBookmark(@Param("po_num")int po_num, @Param("bm_me_num")int bm_me_num);

	Integer selectBookmark(@Param("bm_me_num")int bm_me_num, @Param("po_num")int po_num);

	RecommendVO selectRecommendState(@Param("me_num")int me_num, @Param("po_num")int po_num);

	void insertPost(@Param("po_title") String po_title, 
		            @Param("po_content") String po_content, 
		            @Param("co_num") int co_num);

	List<FileVO> selectFileList(int po_num);

	FileVO selectFile(int fi_num);

	void deleteFile(int fi_num);
}
