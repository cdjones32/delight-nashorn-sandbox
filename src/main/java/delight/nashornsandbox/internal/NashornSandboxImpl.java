package delight.nashornsandbox.internal;

import javax.script.CompiledScript;
import javax.script.ScriptException;

@SuppressWarnings("all")
public class NashornSandboxImpl extends NashornSandboxAbstract {

  @Override
  public Object eval(final String js) {
    JsExecutor jsExecutor = new JsExecutor();
    jsExecutor.setJs(js);
    return securedExecution(jsExecutor);
  }

  @Override
  protected Object singleExecutionSimple(JsExecutor jsExecutor) throws ScriptException {
    return scriptEngine.eval(jsExecutor.getJs());
  }

  @Override
  protected Object singleExecutionSecured(JsExecutor jsExecutor) throws ScriptException {
    return scriptEngine.eval(jsExecutor.getJs());
  }

  @Override
  protected String printable(JsExecutor jsExecutor) {
    return jsExecutor.getJs();
  }

  @Override
  protected String printableSecured(JsExecutor jsExecutor) {
    return jsExecutor.getJs();
  }

  @Override
  protected int getRandomToken(JsExecutor jsExecutor) {
    return jsExecutor.getRandomToken();
  }

}
