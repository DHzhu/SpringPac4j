/**
 * 
 */
package com.security;

import org.pac4j.core.context.HttpConstants;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.http.client.indirect.FormClient;



/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月13日
 */
public class CustomizeFormClient extends FormClient{
	
	public CustomizeFormClient(final String loginUrl, @SuppressWarnings("rawtypes") final Authenticator usernamePasswordAuthenticator){
		super(loginUrl, usernamePasswordAuthenticator);
	}
	
	@Override
	protected String computeErrorMessage(final Exception e) {
        return e.getMessage();
    }
	
	@Override
	protected HttpAction handleInvalidCredentials(final WebContext context, final String username, String message, String errorMessage) throws HttpAction {
        // it's an AJAX request -> unauthorized (instead of a redirection)
        if (getAjaxRequestResolver().isAjax(context)) {
            final String msg = "AJAX request detected -> returning 401";
            logger.info(msg);
            return HttpAction.status(msg, HttpConstants.UNAUTHORIZED, context);
        } else {
            String redirectionUrl = CommonHelper.addParameter(getLoginUrl(), getUsernameParameter(), username);
            redirectionUrl = CommonHelper.addParameter(redirectionUrl, ERROR_PARAMETER, errorMessage);
            logger.debug("redirectionUrl: {}", redirectionUrl);
            logger.debug(message);
            return HttpAction.redirect(message, context, redirectionUrl);
        }
    }
	
}
