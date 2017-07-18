package cs544.carrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.dao.MemberDao;
import cs544.carrental.domain.Member;
import cs544.carrental.service.UserCredentialsService;

@Service
@Transactional 
public class MemberServiceImpl implements cs544.carrental.service.MemberService {
	
 	@Autowired
	private MemberDao memberDao;

 	@Autowired
 	UserCredentialsService credentialsService;

    public void save( Member member) {  		
		memberDao.save(member);
	}
	
 	
    @Override
   	public void saveFull( Member member) {  		
  		credentialsService.save(member.getUserCredentials());
  		memberDao.save(member);
	}
  	

	public List<Member> findAll() {
		return (List<Member>)memberDao.findAll();
	}

 	public Member findOne(Long id) {
		return memberDao.findOne(id);
	}
	
 
}
