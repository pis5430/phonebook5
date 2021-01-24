package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//전체리스트
	public List<PersonVo> getPersonList(){
		System.out.println("dao: getPersonList()");
		
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList2");
		
		System.out.println(personList.toString());
		
		return personList;
			
	}
	
	//1명 데이터 가져오기
	public PersonVo getPerson(int person_id) {
		System.out.println("dao: getPerson()" + person_id);
		
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne" , person_id);
		System.out.println("dao: personVo --> "+personVo.toString());
		
		return personVo;
		
	}
	
	//등록
	public void personInsert(PersonVo personVo) {
		
		System.out.println("PhoneDao : personVo "+personVo);
		int count = sqlSession.insert("phonebook.insert",personVo);
		System.out.println(count + "건이 등록되었습니다.");
		
		
	}
	
	//삭제
	public void personDelete(int person_id) {
		System.out.println("dao: personDelete()" + person_id);
		
		int count = sqlSession.delete("phonebook.delete",person_id);
		System.out.println(count + "건이 삭제되었습니다. ");
	
	}
	
	//수정
	public void personUpdate(PersonVo personVo) {
		System.out.println("dao: personUpdate()" + personVo);
		
		int count = sqlSession.update("phonebook.update",personVo);
		System.out.println(count + "건이 수정되었습니다. ");
	
	}

}
