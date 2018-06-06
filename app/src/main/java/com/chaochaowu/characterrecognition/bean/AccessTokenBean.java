package com.chaochaowu.characterrecognition.bean;

/**
 * @author chaochaowu
 * @Description : AccessTokenBean
 * @class : AccessTokenBean
 * @time Create at 6/4/2018 4:27 PM
 */


public class AccessTokenBean {

    /**
     * refresh_token : 25.b55fe1d287227ca000.1798284651.282335-8574074
     * expires_in : 2592000
     * scope : public wise_adapt
     * session_key : 9mzdDZXu3dENdFZQurfg0Vz8slgSgvvOAUebNFzyzcpQ5EnbxbF+hfG9DQkpUVQdh4p6HbQcAiz5RmuBAja1JJGgIdJI
     * access_token : 24.6c5e1ff107f0e8bcef8c46d3424a0e78.2592000.1485516651.282335-8574074
     * session_secret : dfac94a3489fe9fca7c3221cbf7525ff
     */

    private String refresh_token;
    private int expires_in;
    private String scope;
    private String session_key;
    private String access_token;
    private String session_secret;

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getSession_secret() {
        return session_secret;
    }

    public void setSession_secret(String session_secret) {
        this.session_secret = session_secret;
    }
}
