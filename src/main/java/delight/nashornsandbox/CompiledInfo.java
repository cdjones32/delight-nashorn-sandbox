package delight.nashornsandbox;

import javax.script.CompiledScript;

/**
 * Created by bernal on 11/7/17.
 */
public class CompiledInfo {

    private CompiledScript compiledScript;

    private String scriptAsString;

    public CompiledScript getCompiledScript() {
        return compiledScript;
    }

    public void setCompiledScript(CompiledScript compiledScript) {
        this.compiledScript = compiledScript;
    }

    public String getScriptAsString() {
        return scriptAsString;
    }

    public void setScriptAsString(String scriptAsString) {
        this.scriptAsString = scriptAsString;
    }
}
