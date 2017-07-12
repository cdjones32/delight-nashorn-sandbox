package delight.nashornsandbox.internal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bernal on 12/7/17.
 */
public class JsExecutor {

    public static String PARAM_TOKEN = "PARAM_TOKEN";

    private String js;

    private Map<String, Object> params = new HashMap<String, Object>();

    protected int randomToken;

    protected boolean transformableInRuntime;

    public JsExecutor() {
        this.transformableInRuntime = true;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public void addParams(String paramKey, Object paramValue) {
        params.put(paramKey, paramValue);
    }

    public String getJs() {
        return js;
    }

    public String getParam(String paramKey) {
        return (String)params.get(paramKey);
    }

    public boolean isTransformableInRuntime() {
        return transformableInRuntime;
    }

    public int getRandomToken() {
        return randomToken;
    }

    public void setRandomToken(int randomToken) {
        this.randomToken = randomToken;
    }
}
