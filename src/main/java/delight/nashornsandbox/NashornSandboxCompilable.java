package delight.nashornsandbox;

import javax.script.CompiledScript;

/**
 * Created by bernal on 11/7/17.
 */
public interface NashornSandboxCompilable extends NashornSandbox {

    /**
     * Compile JavaScript by resource path.
     */
    public CompiledInfo compile(final String jsPath);

    /**
     * Compile execute a compiled mathod of a js.
     */
    public void invokeFunction(CompiledInfo compiledInfo, String functionName, Object param);

}
