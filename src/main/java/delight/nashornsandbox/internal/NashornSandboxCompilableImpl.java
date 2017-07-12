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

            CompiledScript simpleCscript = compilingEngine.compile(isr);
            simpleCscript.eval();
            compiledInfo.setSimpleCompiledScript(simpleCscript);

            String js = isr.toString();
            compiledInfo.setScriptAsString(js);

            // TODO enrichment before compiling



        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return compiledInfo;
    }

    @Override
    public void invokeFunction(CompiledInfo compiledInfo, String functionName, Object param) {
        JsExecutorCompilable jsExecutorCompilable = new JsExecutorCompilable();
        jsExecutorCompilable.setJs(compiledInfo.getScriptAsString());
        jsExecutorCompilable.setSimpleCompiledScript(compiledInfo.getSimpleCompiledScript());
        jsExecutorCompilable.setSecuredCompiledScript(compiledInfo.getSecuredCompiledScript());
        jsExecutorCompilable.setFunctionName(functionName);
        jsExecutorCompilable.addParams(JsExecutorCompilable.PARAM_FUNCTION, param);
        securedExecution(jsExecutorCompilable);
    }

    @Override
    protected Object singleExecutionSimple(JsExecutor jsExecutor) {
        JsExecutorCompilable jsExecutorCompilable = (JsExecutorCompilable)jsExecutor;
        // TODO
        return null;
    }

    @Override
    protected Object singleExecutionSecured(JsExecutor jsExecutor) {
        JsExecutorCompilable jsExecutorCompilable = (JsExecutorCompilable)jsExecutor;
        // TODO
        return null;
    }

}
