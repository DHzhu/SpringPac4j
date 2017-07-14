/**
 * 
 */
package com.security.oauth2;

import java.util.Map;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.redirect.RedirectAction;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.oauth.client.OAuth20Client;
import org.pac4j.oauth.profile.OAuth20Profile;
import org.pac4j.oauth.profile.generic.GenericOAuth20ProfileDefinition;
import org.pac4j.scribe.builder.api.GenericApi20;

import com.github.scribejava.core.model.Verb;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月14日
 */
public class CustomizeOAuth20Client extends OAuth20Client<OAuth20Profile>{
	
	private String authUrl;
    private String tokenUrl;
    private String profileUrl;
    private String profilePath;
    private Verb profileVerb;
    private Map<String, String> profileAttrs;
    private Map<String, String> customParams;
    
    private String logoutUrl;
    private String scope;
	
	public CustomizeOAuth20Client(){
		
	}
	
	public CustomizeOAuth20Client(final String key, final String secret){
		setKey(key);
        setSecret(secret);
	}
	
	@Override
    protected void clientInit(final WebContext context) {
		CommonHelper.assertNotBlank("scope", this.scope);
		configuration.setScope(this.scope);

        GenericApi20 genApi = new GenericApi20(authUrl, tokenUrl);
        configuration.setApi(genApi);

        configuration.setCustomParams(customParams);

        setConfiguration(configuration);

        GenericOAuth20ProfileDefinition profileDefinition = new GenericOAuth20ProfileDefinition();
        profileDefinition.setFirstNodePath(profilePath);
        profileDefinition.setProfileVerb(profileVerb);
        profileDefinition.setProfileUrl(profileUrl);

        if (profileAttrs != null) {
            for (Map.Entry<String,String> entry : profileAttrs.entrySet()) {
                profileDefinition.profileAttribute(entry.getKey(), entry.getValue(), null);
            }
        }

        configuration.setProfileDefinition(profileDefinition);
        
        defaultLogoutActionBuilder((ctx, profile, targetUrl) -> RedirectAction.redirect(logoutUrl));


        super.clientInit(context);
    }

	/**
	 * 
	 */
	public String getLogoutUrl() {
		return logoutUrl;
	}

	/**
	 * 
	 */
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	/**
	 * 
	 */
	public String getAuthUrl() {
		return authUrl;
	}

	/**
	 * 
	 */
	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	/**
	 * 
	 */
	public String getTokenUrl() {
		return tokenUrl;
	}

	/**
	 * 
	 */
	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	/**
	 * 
	 */
	public String getProfileUrl() {
		return profileUrl;
	}

	/**
	 * 
	 */
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	/**
	 * 
	 */
	public String getProfilePath() {
		return profilePath;
	}

	/**
	 * 
	 */
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	/**
	 * 
	 */
	public Verb getProfileVerb() {
		return profileVerb;
	}

	/**
	 * 
	 */
	public void setProfileVerb(Verb profileVerb) {
		this.profileVerb = profileVerb;
	}

	/**
	 * 
	 */
	public Map<String, String> getProfileAttrs() {
		return profileAttrs;
	}

	/**
	 * 
	 */
	public void setProfileAttrs(Map<String, String> profileAttrs) {
		this.profileAttrs = profileAttrs;
	}

	/**
	 * 
	 */
	public Map<String, String> getCustomParams() {
		return customParams;
	}

	/**
	 * 
	 */
	public void setCustomParams(Map<String, String> customParams) {
		this.customParams = customParams;
	}

	/**
	 * 
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * 
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
