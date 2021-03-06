package com.deloitte.tms.pl.security.security.decision;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import com.deloitte.tms.pl.security.model.SecurityUser;

/**
 * @since 2013-1-28
 * @author Jacky.gao
 */
public class ComponentAccessDecisionManager {
	public static final String BEAN_ID="ling2.componentAccessDecisionManager";
	private List<AccessDecisionVoter<Object>> decisionVoters;
	public ComponentAccessDecisionManager(List<AccessDecisionVoter<Object>> decisionVoters){
		this.decisionVoters=decisionVoters;
	}
	
	public boolean decide(Authentication authentication,Collection<ConfigAttribute> configAttributes){
		if((authentication.getPrincipal() instanceof SecurityUser)){
			SecurityUser loginUser=(SecurityUser)authentication.getPrincipal();
			if(loginUser.isAdministrator())return true;			
		}
		int result=10;
		for (AccessDecisionVoter<Object> voter : decisionVoters) {
			result = voter.vote(authentication,null, configAttributes);
			if(result==AccessDecisionVoter.ACCESS_ABSTAIN){
				continue;
			}
			if(result==AccessDecisionVoter.ACCESS_DENIED){
				return false;
			}
			if(result==AccessDecisionVoter.ACCESS_GRANTED){
				break;
			}
		}
		if(result==AccessDecisionVoter.ACCESS_ABSTAIN && configAttributes.size()>0){
			return false;
		}else{
			return true;
		}
	}
}
