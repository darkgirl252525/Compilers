package compiler;

import java.util.*;



/**
 * Created by stefa on 23/5/2017.
 */
class SymbolTable {

    private Map<Integer,Integer> map;           //hashmap
    private Stack<ScopeObject> mystack;         //stack of obj:ScopeObject
    private Stack<FuncScope> funcStack;         //stack of obj:FuncScope
    private int position;                       //position of map

    public SymbolTable(){   //constructor
        map = new HashMap<Integer,Integer>();
        mystack = new Stack<ScopeObject>();
        position = -1;
    }

    public void print(){            //print stack
        System.out.println("printing stack");
        for (int i=0; i<this.mystack.size();i++){
            System.out.println(this.mystack.get(i).getName());
        }
        System.out.println("end of printing stack");
    }


    public void enter(ScopeObject obj){             //enter obj to new scope

        System.out.println("INSERT OBJECT TO MAP: ");
        try{
            if(lookupFunc(obj)) {
                throw new MyException("FOUND SAME FUNCTION");
            } else if (lookupDecl(obj)) {
                System.err.println("FOUND DIFFERENT TYPE");
                throw new MyException("FOUND DIFFERENT TYPE");
            } else {
                position++;
                System.out.println("ENTER");
                map.put(position, mystack.size());
                mystack.push(obj);
            }
        }catch (MyException e){
            //System.err.println("FOUND SAME VARIABLE");
            //throw new AssertionError();
            //throw new RuntimeException(e); //should not happen
            throw new IllegalStateException("FOUND SAME FUNCTION");
        }

    }

    public void insert(ScopeObject obj) {               //insert object to stack in same scope

        System.out.println("INSERT OBJECT TO STACK: ");

        if (obj.getGenre().equals("par")) {
            obj = this.findDecl(obj);
        }

        try{
            if(lookupVar(obj)){
                //System.err.println("FOUND SAME VARIABLE");
                throw new MyException("FOUND SAME VARIABLE");
            }
            else if (lookupVarAndFunc(obj)){
                //System.err.println("FOUND SAME VARIABLE AND FUNC");
                throw new MyException("FOUND SAME VARIABLE AND FUNC");
            }
            else if(lookupPar(obj)){
                throw new MyException("FOUND SAME PARAMETER AND FUNC");
            }
            else{
                map.put(position,mystack.size());
                mystack.push(obj);
            }
        }catch (MyException e){
            //System.err.println("FOUND SAME VARIABLE");
            //throw new AssertionError();
            //throw new RuntimeException(e); //should not happen
            throw new IllegalStateException("FOUND SAME VARIABLE");
        }


    }

    public boolean lookupVar(ScopeObject obj){              //search for same vars in same scope


        System.out.println("LOOKUP VAR:");
        int value = map.get(position);
        int value2 = 0;
        if (position!=0){
            value2  = map.get(position-1);
            for(int i=value;i>value2;i--){
                ScopeObject obj2 = (ScopeObject) mystack.get(i);
                if (obj.sameObject(obj2.getName(),obj2.getGenre())){
                    System.out.println("Same object found in if");
                    return true;
                }

            }
            return false;
        }
        else{
            for(int i=value;i>=0;i--){
                ScopeObject obj2 = (ScopeObject) mystack.get(i);
                if (obj.sameObject(obj2.getName(),obj2.getGenre())){
                    System.out.println("Same object found in else");
                    return true;
                }
            }
            return false;
        }
    }


    public boolean lookupPar(ScopeObject obj){      //search for same parameters inside function decl
        System.out.println("LOOKUP PARAMETERS:");
        if(!obj.getGenre().equals("par_decl"))
        {
            return false;
        }

        int i = mystack.size()-1;
        while (i>=0) {
            ScopeObject obj2 = (ScopeObject) mystack.get(i);
            if (!obj2.getGenre().equals("decl") && !obj2.getGenre().equals("par_decl")){
                break;
            }
            if(obj.sameObjectPar(obj2.getName(),obj2.getGenre()))
                return true;
            i--;
        }
        return false;

    }

    public boolean lookupDecl(ScopeObject obj){             //search for same func and decl names

        System.out.println("LOOKUP DECLARATION:");

        int i = mystack.size()-1;
        while (i>=0) {
            ScopeObject obj2 = (ScopeObject) mystack.get(i);
            if(obj.getName().equals(obj2.getName()) && obj2.getGenre().equals("decl")) {
                if(!obj.getType().equals(obj2.getType()))
                    return true;
            }
            i--;
        }
        return false;
    }




    public boolean lookupFunc(ScopeObject obj){             //search for same func in all stack

        System.out.println("LOOKUP FUNCTION: ");

        for(int i = mystack.size()-1;i>=0;i--){

            ScopeObject obj2 = (ScopeObject) mystack.get(i);
            if (obj.sameObject(obj2.getName(),obj2.getGenre()) ){
                return true;
            }
        }
        return false;

    }

    public boolean lookupVarAndFunc(ScopeObject obj){               //search for same function and variable names in all stack

        System.out.println("LOOKUP VARIABLE AND FUNC: ");

        for(int i = mystack.size()-1;i>=0;i--){
            ScopeObject obj2 = (ScopeObject) mystack.get(i);
            if (obj.sameObjectFunc(obj2.getName(),obj2.getGenre()) ){
                return true;
            }
        }
        return false;

    }



    public boolean lookupVarAndType(ScopeObject obj){                   //search variable in order to find the same variable in stack with diff type(true)


        System.out.println("LOOKUP VAR AND TYPE:");
        int value = map.get(position);
        int value2 = 0;
        if (position!=0){
            value2  = map.get(position-1);
            for(int i=value;i>value2;i--){
                ScopeObject obj2 = (ScopeObject) mystack.get(i);

                if (obj.getName().equals(obj2.getName())){
                    if (!obj.getType().equals(obj2.getType())){
                        System.out.println("DIFFERENT TYPES in if");
                        return true;            //diaforetikoi tupoi
                    }
                    else return false;
                }

            }
            System.out.println("error2");
            return true;    //den to vrhke
        }
        else{
            for(int i=value;i>=0;i--){
                System.out.println(i);
                ScopeObject obj2 = (ScopeObject) mystack.get(i);
                if (obj.getName().trim().equals(obj2.getName().trim())){
                    if (!obj.getType().equals(obj2.getType())){
                        System.out.println("DIFFERENT TYPES in else");
                        return true;
                    }
                    else return false;
                }
            }
            System.out.println("NOT FOUND");
            return true;  //den to vrhke
        }
    }





    public String FindVariableType(String name){


        System.out.println("FIND VARIABLE TYPE:");
        System.out.println(name);
        int value = map.get(position);
        int value2 = 0;
        if (position!=0){
            value2  = map.get(position-1);
            for(int i=value;i>value2;i--){
                ScopeObject obj = (ScopeObject) mystack.get(i);
                if (obj.getName().equals(name)){
                    System.out.println("Found");
                    return obj.getType();
                }

            }
            return null;    //den to vrhke
        }
        else{
            for(int i=value;i>=0;i--){
                ScopeObject obj = (ScopeObject) mystack.get(i);
                System.out.println("item = " +obj.getName() + obj.getType() + " " + name + "!");
                if (obj.getName().equals(name)){
                    System.out.println("Found");
                    return obj.getType();
                }
            }
            System.out.println("Not found");
            return null;  //den to vrhke
        }
    }





    public ScopeObject findDecl(ScopeObject obj){               //search and set parameter of decl as "par_decl" and return it

        System.out.println("FIND DECL:");
        ScopeObject obj2 = (ScopeObject) mystack.get(mystack.size()-1);
        if(obj2.getGenre().equals("decl")){
            obj.setGenre("par_decl");

        }
        else if(obj2.getGenre().equals("par_decl")){
            obj.setGenre("par_decl");
        }
        return obj;
    }



    public void exit(){             //remove scopes

        System.out.println("EXIT:");
        int value = map.get(position);
        int value2 = 0;
        if (position!=0){
            value2  = map.get(position-1);
        }
        for(int i=value;i>value2;i--){
            mystack.pop();
        }
        map.remove(position);
        position--;

    }

    public void insertFuncStack(String funcName,int scope,Map parameters){      //insert funcScope obj to stack

        FuncScope funcObj = new FuncScope(funcName,scope,parameters);

        funcStack.push(funcObj);
    }

    public int getPosition() {
        return position;
    }                   //get position

    public Map<Integer, Integer> getMap() {
        return map;
    }           //get hashmap

    public Stack<ScopeObject> getMystack() {
        return mystack;
    }      //get stack
}