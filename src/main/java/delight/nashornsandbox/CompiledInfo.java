package delight.nashornsandbox;

import javax.script.CompiledScript;

/**
 * Created by bernal on 11/7/17.
 */
public class CompiledInfo {

    private CompiledScript simpleCompiledScript;

    private CompiledScript securedCompiledScript;

    private String scriptAsString;

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

    public String getScriptAsString() {
        return scriptAsString;
    }

    public void setScriptAsString(String scriptAsString) {
        this.scriptAsString = scriptAsString;
    }
}
