/**
 * 
 */
package com.security;

import org.pac4j.core.context.Pac4jConstants;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.UsernamePasswordCredentials;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.exception.CredentialsException;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.util.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.User;
import com.service.UserService;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月11日
 */
public class CustomizeUsrPwdAuthenticator implements Authenticator<UsernamePasswordCredentials>{
	
	@Autowired
	private UserService userService;

	/**
	 * @desc : TODO
	 * @date : 2017年7月11日
	 */
	public void validate(UsernamePasswordCredentials credentials, WebContext context)
			throws HttpAction, CredentialsException {
		// TODO Auto-generated method stub
		if (credentials == null) {
            throwsException("No credential");
        }
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        if (CommonHelper.isBlank(username)) {
            throwsException("Username cannot be blank");
        }
        if (CommonHelper.isBlank(password)) {
            throwsException("Password cannot be blank");
        }
        User user = new User();
        user.setUserName(username);
        User admin = userService.getUser(user);
        
        if(admin == null){
        	throwsException("Username : '" + username + "' does not exits");
        }
        
        if (CommonHelper.areNotEquals(password, admin.getPassword())) {
            throwsException("Username : '" + username + "' does not match password");
        }
        final CommonProfile profile = new CommonProfile();
        profile.setId(username);
        profile.addAttribute(Pac4jConstants.USERNAME, username);
        credentials.setUserProfile(profile);
	}
	
	protected void throwsException(final String message) throws CredentialsException {
        throw new CredentialsException(message);
    }
}
