/**
 * 
 */
package com.security;

import java.util.List;

import org.pac4j.core.authorization.authorizer.ProfileAuthorizer;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.CommonProfile;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月11日
 */
public class CustomizeAuthorizer extends ProfileAuthorizer<CommonProfile>{

	/**
	 * @desc : TODO
	 * @date : 2017年7月11日
	 */
	public boolean isAuthorized(WebContext context, List<CommonProfile> profiles) throws HttpAction {
		// TODO Auto-generated method stub
		return isAnyAuthorized(context, profiles);
	}

	/**
	 * @desc : TODO
	 * @date : 2017年7月11日
	 */
	@Override
	protected boolean isProfileAuthorized(WebContext context, CommonProfile profile) throws HttpAction {
		// TODO Auto-generated method stub
		return profile == null;
	}

}
