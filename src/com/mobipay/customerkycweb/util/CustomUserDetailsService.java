package com.mobipay.customerkycweb.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.mobipay.customerkycweb.service.UserService;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserService appUserService;
	private transient  final Log log = LogFactory.getLog(this.getClass());
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		List<com.mobipay.customerkycweb.model.User> user = appUserService.searchByMDN(username);
		if(user != null && user.size() > 0){ 
		    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		    authorities.add(new GrantedAuthorityImpl( user.get(0).getRole().getRolename() ) );
			boolean enabled = Boolean.TRUE;
			
			boolean accountNonExpired = Boolean.TRUE;
		    boolean credentialsNonExpired = enabled;
		    boolean accountNonLocked = enabled;
		    String password = user.get(0).getPassword();		    
		    
		    User myUser = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);	 
		    
		    return myUser; 
		}

		throw new BadCredentialsException("Bad Credential");					
	}

}
