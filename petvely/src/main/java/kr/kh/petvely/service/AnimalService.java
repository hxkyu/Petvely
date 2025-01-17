package kr.kh.petvely.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.petvely.dao.AnimalDAO;
import kr.kh.petvely.model.vo.AnimalVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnimalService {
	
	@Autowired
	AnimalDAO animalDao;
	
	public List<AnimalVO> selectPetList(int me_num) {
		
		return animalDao.selectPetList(me_num);
	}

	public List<AnimalVO> selectDetailPetList(int po_num) {
		
		return animalDao.selectDetailPetList(po_num);
	}

	public List<AnimalVO> selectChoicePetList(int po_num) {
		
		return animalDao.selectChoicePetList(po_num);
	}

	public boolean insertMyPet(AnimalVO animalVo, int me_num) {
		
		return animalDao.insertMyPet(animalVo, me_num);
	}

	public boolean deleteMyPet(int ani_num) {
		return animalDao.deleteMyPet(ani_num);
	}

	public AnimalVO selectMyPet(int ani_num) {
		
		return animalDao.selectMyPet(ani_num);
	}

	public boolean updateMyPet(AnimalVO animal) {
		return animalDao.updateMyPet(animal);
	}

	public List<AnimalVO> selectOtherPetList(int me_num) {
		return animalDao.selectOtherPet(me_num);
	}
	

}
