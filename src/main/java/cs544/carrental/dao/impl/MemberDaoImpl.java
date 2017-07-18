package cs544.carrental.dao.impl;

 

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.MemberDao;
import cs544.carrental.domain.Member;


@SuppressWarnings("unchecked")
@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {

	public MemberDaoImpl() {
		super.setDaoType(Member.class );
		}

 
 }