package compiler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stefa on 28/5/2017.
 */
public class FuncScope {

    private String funcName;                //name of function
    private int scope;                      //scope of function
    private Map<String,List> parameters;    //parameters of function(in map formation)
    private String type;                    //type of function
    private int numOfParams;

    public FuncScope(String funcName,int scope,Map parameters,String type,int numOfParams){     //constructor
        this.funcName = funcName;
        this.scope = scope;
        this.parameters = new HashMap<String, List>(parameters);
        this.type = type;
        this.numOfParams = numOfParams;
    }

    public int getScope() {         //get scope
        return scope;
    }

    public Map<String, List> getParameters() {      //get map of parameters
        return parameters;
    }

    public String getFuncName() {                   //get function name
        return funcName;
    }

    public String getType() {
        return type;
    }

    public int getNumOfParams() {
        return numOfParams;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public void setParameters(Map<String, List> parameters) {
        this.parameters = parameters;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public void setType(String type) {
        this.type = type;
    }
}
