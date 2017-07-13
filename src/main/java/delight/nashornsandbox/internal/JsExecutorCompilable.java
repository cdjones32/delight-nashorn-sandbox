package delight.nashornsandbox.internal;

import javax.script.CompiledScript;

/**
 * Created by bernal on 12/7/17.
 */
public class JsExecutorCompilable extends JsExecutor {

    public static String PARAM_FUNCTION = "PARAM_FUNCTION";

    private CompiledScript simpleCompiledScript;

    private CompiledScript SecuredCompiledScript;    
    private String securedJs;
    

    private String functionName;

    public JsExecutorCompilable() {
        super();
        this.transformableInRuntime = false;
    }

    public CompiledScript getSimpleCompiledScript() {
        return simpleCompiledScript;
    }

    public void setSimpleCompiledScript(CompiledScript simpleCompiledScript) {
        this.simpleCompiledScript = simpleCompiledScript;
    }

    public CompiledScript getSecuredCompiledScript() {
        return SecuredCompiledScript;
    }

    public void setSecuredCompiledScript(CompiledScript securedCompiledScript) {
        SecuredCompiledScript = securedCompiledScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

	public String getSecuredJs() {
		return securedJs;
	}

	public void setSecuredJs(String securedJs) {
		this.securedJs = securedJs;
	}
    
}
