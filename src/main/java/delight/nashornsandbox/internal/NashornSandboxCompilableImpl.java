package delight.nashornsandbox.internal;

import delight.nashornsandbox.CompiledInfo;
import delight.nashornsandbox.NashornSandboxCompilable;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
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
            compiledInfo.setSimpleScriptAsString(js);

            // Secured compilation
            JsExecutor aux = new JsExecutor();
            aux.setJs(js);
            JsExecutor auxSecured = transformJs(aux);
            
            String securedJs = auxSecured.getJs();
            CompiledScript securedCscript = compilingEngine.compile(securedJs);
            securedCscript.eval();
            compiledInfo.setSecuredScriptAsString(securedJs);
            compiledInfo.setSecuredCompiledScript(securedCscript);
            compiledInfo.setRandomToken(auxSecured.getRandomToken());

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
        jsExecutorCompilable.setJs(compiledInfo.getSimpleScriptAsString());        
        jsExecutorCompilable.setSimpleCompiledScript(compiledInfo.getSimpleCompiledScript());
        jsExecutorCompilable.setSecuredJs(compiledInfo.getSecuredScriptAsString());
        jsExecutorCompilable.setSecuredCompiledScript(compiledInfo.getSecuredCompiledScript());
        jsExecutorCompilable.setRandomToken(compiledInfo.getRandomToken());
        jsExecutorCompilable.setFunctionName(functionName);
        jsExecutorCompilable.addParams(JsExecutorCompilable.PARAM_FUNCTION, param);
        securedExecution(jsExecutorCompilable);
    }

    @Override
    protected Object singleExecutionSimple(JsExecutor jsExecutor) throws ScriptException {
        JsExecutorCompilable jsExecutorCompilable = (JsExecutorCompilable)jsExecutor;
        Invocable invocable = (Invocable) jsExecutorCompilable.getSimpleCompiledScript().getEngine();
        try {
			return invocable.invokeFunction(jsExecutorCompilable.getFunctionName(), jsExecutorCompilable.getParam(JsExecutorCompilable.PARAM_FUNCTION));
		} catch (NoSuchMethodException e) {
			throw new ScriptException(e);
		}
    }

    @Override
    protected Object singleExecutionSecured(JsExecutor jsExecutor) throws ScriptException {
        JsExecutorCompilable jsExecutorCompilable = (JsExecutorCompilable)jsExecutor;
        Invocable invocable = (Invocable) jsExecutorCompilable.getSecuredCompiledScript().getEngine();
        try {
			return invocable.invokeFunction(jsExecutorCompilable.getFunctionName(), jsExecutorCompilable.getParam(JsExecutorCompilable.PARAM_FUNCTION));
		} catch (NoSuchMethodException e) {
			throw new ScriptException(e);
		}
    }
    
    @Override
    protected String printableSecured(JsExecutor jsExecutor) {
        JsExecutorCompilable jsExecutorCompilable = (JsExecutorCompilable)jsExecutor;
      return jsExecutorCompilable.getSecuredJs();
    }
    

}
