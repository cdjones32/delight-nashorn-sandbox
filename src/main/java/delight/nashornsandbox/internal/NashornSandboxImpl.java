package delight.nashornsandbox.internal;

import javax.script.CompiledScript;
import javax.script.ScriptException;

@SuppressWarnings("all")
public class NashornSandboxImpl extends NashornSandboxAbstract {

  @Override
  public Object eval(final String js) {
    return securedExecution(js, null, null, null);
  }

  @Override
  protected void execution(String js, CompiledScript csript, String functionName, Object param) throws ScriptException {
    // TODO Check this
    //scriptEngine.eval(js);
  }
}
