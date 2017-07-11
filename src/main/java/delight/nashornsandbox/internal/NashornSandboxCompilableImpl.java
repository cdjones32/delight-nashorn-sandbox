package delight.nashornsandbox.internal;

import delight.nashornsandbox.NashornSandboxCompilable;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by bernal on 11/7/17.
 */
public class NashornSandboxCompilableImpl extends NashornSandboxImpl implements NashornSandboxCompilable {

    private Compilable compilingEngine;

    public void assertCompilable() {
        super.assertScriptEngine();
        if (compilingEngine != null)
            return;
        compilingEngine = (Compilable)scriptEngine;
    }

    @Override
    public CompiledScript compile(String jsPath) {
        CompiledScript cscript = null;
        try {
            assertCompilable();
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(jsPath);
            InputStreamReader isr = new InputStreamReader(is);
            cscript = compilingEngine.compile(isr);
            cscript.eval();
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return cscript;
    }

    @Override
    public void invokeFunction(CompiledScript cscript, String functionName, Object param) {

    }

}
