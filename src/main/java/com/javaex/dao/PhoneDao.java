package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//1명 데이터 가져오기2
	public Map<String , Object> getPerson2(int person_id) {
		System.out.println("dao: getPerson2()" + person_id);
		
		
		Map<String , Object> personMap = sqlSession.selectOne("phonebook.selectOne2" , person_id);
		System.out.println("dao: personMap --> "+personMap.toString());
		
		/*
		String name = (String)personMap.get("name");
		System.out.println(name);
		
		int id = Integer.parseInt((String.valueOf((personMap.get("persin_id")))));
		형변환 시켜줘야함
		*/

		return personMap;
		
	}
	
	//등록
	public int personInsert(PersonVo personVo) {
		
		System.out.println("PhoneDao : personVo "+personVo);
		int count = sqlSession.insert("phonebook.insert",personVo);
		System.out.println(count + "건이 등록되었습니다.");
		
		return count;
		
	}
	
	//삭제
	public int personDelete(int person_id) {
		System.out.println("dao: personDelete()" + person_id);
		
		int count = sqlSession.delete("phonebook.delete",person_id);
		System.out.println(count + "건이 삭제되었습니다. ");
		
		return count;
	
	}
	
	//수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("dao: personUpdate()" + personVo);
		
		int count = sqlSession.update("phonebook.update",personVo);
		System.out.println(count + "건이 수정되었습니다. ");
	
		return count;
	}
	
	//수정2
	public int personUpdate2(int person_id, String name, String hp, String company) {
		System.out.println("dao: personUpdate2()" + person_id + "," +name + "," + hp + "," + company);
		
		//vo 대신 --> map
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("id", person_id);
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
				
		System.out.println(personMap.toString());
				
		return sqlSession.update("phonebook.update2", personMap);
	}

}
