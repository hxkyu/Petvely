package kr.kh.petvely.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.petvely.dao.PostDAO;
import kr.kh.petvely.dao.PostHostSelectedPetsDAO;
import kr.kh.petvely.dao.WalkMatePostDAO;
import kr.kh.petvely.model.vo.PostHostSelectedPetsVO;
import kr.kh.petvely.model.vo.WalkMatePostVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WalkMatePostService {
	
	@Autowired
	private PostDAO postDao;
	
	@Autowired
	private WalkMatePostDAO walkMatePostDao;
	
	@Autowired
	private PostHostSelectedPetsDAO postHostSelectedPetsDao;
	
	@Autowired
	public List<WalkMatePostVO> getWalkMatePostList() {
		return walkMatePostDao.selectWalkMatePostList();
	}

	public boolean insertWalkMatePost(WalkMatePostVO walkMatePost, int[] selectedHostAniNums) {
		
		int po_num;
		
		if(walkMatePost == null) {
			return false;
		}
		 try {
		        // 포스트를 데이터베이스에 저장
		        postDao.insertPost(walkMatePost);
		        System.out.println(walkMatePost);
		        // po_num = post.getPo_num(); // DB에 저장 후 po_num을 가져옴

		        // walkMatePost에 포스트 번호를 설정
		        // walkMatePost.setPo_num(po_num);
		        System.out.println(walkMatePost);

		        // walkMatePost를 데이터베이스에 저장
		        walkMatePostDao.insertWalkMatePost(walkMatePost);

		        // selectedHostAniNums 저장
		        for (int num : selectedHostAniNums) {
		        	PostHostSelectedPetsVO pet = new PostHostSelectedPetsVO();
		        	System.out.println("num : " + num);
		        	pet.setPhsp_ani_num(num);
		            pet.setPhsp_po_num(walkMatePost.getPo_num()); // phsp_po_num 설정
		            System.out.println("Inserting animal: " + pet.getPhsp_ani_num() + " with po_num: " + walkMatePost.getPo_num());
		            postHostSelectedPetsDao.insertPostHostSelectedPets(pet); // DB에 저장
		        }

		        return true;

		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
	}

	public WalkMatePostVO getWalkMatePost(int po_num) {
		return walkMatePostDao.selectWalkMatePost(po_num);
	}

	public boolean updateWalkMatePost(WalkMatePostVO walkMatePost, int[] selectedHostAniNums) {
		if(walkMatePost == null) {
			return false;
		}
		try {
			postHostSelectedPetsDao.deletePostHostSelectedPets(walkMatePost.getPo_num());
			
			
			for (int num : selectedHostAniNums) {
	        	PostHostSelectedPetsVO pet = new PostHostSelectedPetsVO();
	        	System.out.println("num : " + num);
	        	pet.setPhsp_ani_num(num);
	            pet.setPhsp_po_num(walkMatePost.getPo_num()); // phsp_po_num 설정
	            System.out.println("Inserting animal: " + pet.getPhsp_ani_num() + " with po_num: " + walkMatePost.getPo_num());
	            postHostSelectedPetsDao.insertPostHostSelectedPets(pet); // DB에 저장
	        }
			return walkMatePostDao.updateWalkMatePost(walkMatePost);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}