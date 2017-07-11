package delight.nashornsandbox;

import javax.script.CompiledScript;

/**
 * Created by bernal on 11/7/17.
 */
public interface NashornSandboxCompilable extends NashornSandbox {



    /**
     * Compile JavaScript by resource path.
     */
    public abstract CompiledScript compile(final String jsPath);

    /**
     * Compile execute a compiled mathod of a js.
     */
    public abstract void invokeFunction(CompiledScript cscript, String functionName, Object param);

}
