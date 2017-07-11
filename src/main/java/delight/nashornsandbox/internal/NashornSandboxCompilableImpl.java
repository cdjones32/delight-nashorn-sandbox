package delight.nashornsandbox.internal;

import delight.nashornsandbox.CompiledInfo;
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
    public CompiledInfo compile(String jsPath) {
        CompiledInfo compiledInfo = new CompiledInfo();
        try {
            assertCompilable();
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(jsPath);
            InputStreamReader isr = new InputStreamReader(is);
            CompiledScript cscript = compilingEngine.compile(isr);
            cscript.eval();

            compiledInfo.setCompiledScript(cscript);
            compiledInfo.setScriptAsString(isr.toString());

        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return compiledInfo;
    }

    @Override
    public void invokeFunction(CompiledInfo compiledInfo, String functionName, Object param) {
        securedExecution(compiledInfo.getScriptAsString(), compiledInfo.getCompiledScript(), functionName, param);
    }

    @Override
    protected void execution(String js, CompiledScript csript, String functionName, Object param) {
        // TODO
    }
}
