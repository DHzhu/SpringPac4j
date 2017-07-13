/**
 * 
 */
package com.security;

import org.pac4j.core.authorization.generator.AuthorizationGenerator;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月11日
 */
public class RoleAdminAuthGenerator implements AuthorizationGenerator<CommonProfile>{

	/**
	 * @desc : TODO
	 * @date : 2017年7月11日
	 */
	public CommonProfile generate(WebContext context, CommonProfile profile) {
		profile.addRole("ROLE_ADMIN");
        profile.clearSensitiveData(); // remove the access token to reduce size and make the remember-me work
        profile.setRemembered(true);
        return profile;
	}

}
