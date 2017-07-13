package delight.nashornsandbox;

import javax.script.CompiledScript;

/**
 * Created by bernal on 11/7/17.
 */
public class CompiledInfo {

	// Simple Js info
    private String simpleScriptAsString;
    private CompiledScript simpleCompiledScript;

    // Secured Js info
    private String securedScriptAsString;
    private CompiledScript securedCompiledScript;
    private int randomToken;

    public CompiledScript getSimpleCompiledScript() {
        return simpleCompiledScript;
    }

    public void setSimpleCompiledScript(CompiledScript simpleCompiledScript) {
        this.simpleCompiledScript = simpleCompiledScript;
    }

    public CompiledScript getSecuredCompiledScript() {
        return securedCompiledScript;
    }

    public void setSecuredCompiledScript(CompiledScript securedCompiledScript) {
        this.securedCompiledScript = securedCompiledScript;
    }

	public String getSimpleScriptAsString() {
		return simpleScriptAsString;
	}

	public void setSimpleScriptAsString(String simpleScriptAsString) {
		this.simpleScriptAsString = simpleScriptAsString;
	}

	public String getSecuredScriptAsString() {
		return securedScriptAsString;
	}

	public void setSecuredScriptAsString(String securedScriptAsString) {
		this.securedScriptAsString = securedScriptAsString;
	}

	public int getRandomToken() {
		return randomToken;
	}

	public void setRandomToken(int randomToken) {
		this.randomToken = randomToken;
	}
    
}
