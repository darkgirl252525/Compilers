package compiler;

import javax.xml.bind.ValidationEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class JavaBytecode {
    private List<Quad> InitialQuadList;
    private List<Quad> quadList;
    private List<String> bytecodeList;
    private int counter;
    private List<funcBeggining> funcScope;
    private List<FuncScopeHelper> myFuncScopeHelperList;
    private Stack<FuncScope> funcStack;         //stack of obj:FuncScope
    private int istoreCounter;
    private List<placeHelper> registers;
    private List<VarLocal> VarLocalList;
    private List<ScopeObject> allVars;

    private Stack<quadCounter> jumpStack;
    private Stack<quadCounter> ifbStack;

    public JavaBytecode(List<Quad> quadList, Stack<FuncScope> funcStack, List<placeHelper> registers, List<ScopeObject> allVars) {
        this.quadList = new ArrayList<Quad>(quadList);
        this.bytecodeList = new ArrayList<String>();
        this.counter = 0;
        this.InitialQuadList = new ArrayList<Quad>(quadList);
        this.funcStack = new Stack<FuncScope>();
        this.registers = new ArrayList<placeHelper>(registers);
        this.allVars = new ArrayList<ScopeObject>(allVars);


        for (int i = 0; i < funcStack.size(); i++) {

            this.funcStack.push(funcStack.get(i));
        }
    }

    public List<Quad> getQuadList() {
        return quadList;
    }

    public void produceJavaBytecode() {


        this.bytecodeList.add(".class public Grace");
        this.bytecodeList.add(".super java/lang/Object");

        //constructor
        this.bytecodeList.add(".method public <init>()V");
        this.bytecodeList.add(" aload_0");
        this.bytecodeList.add("invokenonvirtual java/lang/Object/<init>()V");
        this.bytecodeList.add("return");
        this.bytecodeList.add(".end method");

        this.createFuncScope();
        this.findFunctionScope();


        for (int i = 0; i < this.funcScope.size(); i++) {     //for each function
            this.counter = 0;

            VarLocalList = new ArrayList<VarLocal>();
            String method;

            jumpStack = new Stack<quadCounter>();
            ifbStack = new Stack<quadCounter>();

            //entolh first

            int first = funcScope.get(i).getFirst();

            istoreCounter = getNoOfParams(quadList.get(first).getArg1().toString()) + 1;

            //unit
            if (first == 0) {
                if (!quadList.get(first).getArg1().equals("main")) {     //must create main

                } else {
                    method = ".method public static " + quadList.get(first).getArg1();
                    method += "([Ljava/lang/String;)V";
                    this.bytecodeList.add(method);
                    this.bytecodeList.add(".limit stack 20");
                    this.bytecodeList.add(".limit locals 100");
                    this.bytecodeList.add(this.counter + " : aload_0 ");    //stack: this
                    this.counter++;
                }
            } else {
                method = ".method " + quadList.get(first).getArg1();
                method += this.setMethodPar((String) quadList.get(first).getArg1()) + this.setMethodRet((String) quadList.get(first).getArg1());
                this.bytecodeList.add(method);
                this.bytecodeList.add(".limit stack 20");
                this.bytecodeList.add(".limit locals 100");
                this.bytecodeList.add(this.counter + " : aload_0 ");    //stack: this
                this.counter++;
            }


            int second = funcScope.get(i).getSecond();
            int last = funcScope.get(i).getLast();

            Quad command = null;
            String retType = setMethodRet((String) quadList.get(first).getArg1());
            for (int counter = second; counter < last; counter++) {
                //entoles
                command = new Quad(quadList.get(counter));
                handleQuad(command, counter, retType);
            }

            if (retType.equals("V")) {
                this.bytecodeList.add(this.counter + " : return");
                this.counter++;
            }

                if (command != null) {
                    if (!this.previousRet(command)) {

                        if (retType.equals("I")) {
                            this.counter--;
                            this.bytecodeList.add("ireturn");
                        }
                        else if (retType.equals("C"))
                        {
                            this.counter--;

                            this.bytecodeList.add("ireturn");
                        }
                    }
            }

            for (int counter = second; counter <= last; counter++) {         //check jumpStack
                jumpHelper(counter);
            }

            this.bytecodeList.add(".end method");
        }
        try {
            PrintWriter writer = new PrintWriter("bytecode.j", "ASCII");
            for (int j = 0; j < this.bytecodeList.size(); j++) {
                writer.println(this.bytecodeList.get(j));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void jumpHelper(int countQuad){
        String countQuadStr = Integer.toString(countQuad);

        if(jumpStack.size()>0) {

            for(int i=this.jumpStack.size()-1; i>=0; i--){

                if (countQuadStr.equals(this.jumpStack.get(i).getQuad().getArg3().toString())) {

                    for (int byteCounter = 0; byteCounter < this.bytecodeList.size(); byteCounter++) {
                        String line = this.bytecodeList.get(byteCounter);
                        String tempStr = "*" + this.jumpStack.get(i).getPosition();

                        if (line.contains(tempStr)) {
                            if(this.quadList.get(countQuad).getOp().toString().equals("endu")){
                                line = line.replace(tempStr, Integer.toString(counter-1));
                            }
                            else{
                                line = line.replace(tempStr, Integer.toString(counter));
                            }
                            this.bytecodeList.set(byteCounter, line);
                        }
                    }
                    this.jumpStack.remove(i);
                }
            }
        }
    }


    public void ifbHelper(int countQuad){
        String countQuadStr = Integer.toString(countQuad);

        if(ifbStack.size()>0) {

            for(int i=this.ifbStack.size()-1; i>=0; i--){

                if (countQuadStr.equals(this.ifbStack.get(i).getQuad().getArg3().toString())) {

                    for (int byteCounter = 0; byteCounter < this.bytecodeList.size(); byteCounter++) {
                        String line = this.bytecodeList.get(byteCounter);
                        String tempStr = "@" + this.ifbStack.get(i).getPosition();

                        if (line.contains(tempStr)) {
                            line = line.replace(tempStr, Integer.toString(counter));
                            this.bytecodeList.set(byteCounter, line);
                        }
                    }
                    this.ifbStack.remove(i);
                }
            }
        }
    }



    public void handleQuad(Quad q, int countQuad, String retType) {

        this.jumpHelper(countQuad);
        this.ifbHelper(countQuad);

        operator p;
        if (q.getOp().getClass().getSimpleName().equals("operator")) {
            p = (operator) q.getOp();
            if (p.getName().equals("relop")) {

                List<String> regExpr = this.getRegRelop(countQuad);

                this.VarLocalList.add(new VarLocal(regExpr.get(0), istoreCounter, regExpr.get(1)));

                if (returnRegExpr(q.getArg1().toString().trim()) != null) {

                    String expr = returnRegExpr(q.getArg1().toString().trim());

                    if (expr.contains("[")) {
                        if (!(expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/") || expr.contains("mod"))) {

                            String var = this.getVar(expr);
                            String dim = this.getArrayDim(expr);


                            int sc = this.VarLocalExists(var);

                            this.bytecodeList.add(this.counter + " : aload " + sc);
                            this.counter++;

                            this.bytecodeList.add(this.counter + " : ldc " + dim);
                            this.counter++;


                            this.bytecodeList.add(this.counter + " : iaload ");
                            this.counter++;
                        }
                    }
                }

                if (returnRegExpr(q.getArg2().toString().trim()) != null) {

                    String expr2 = returnRegExpr(q.getArg2().toString().trim());
                    if (expr2.contains("[")) {
                        if (!(expr2.contains("+") || expr2.contains("-") || expr2.contains("*") || expr2.contains("/") || expr2.contains("mod"))) {

                            String var = this.getVar(expr2);
                            String dim = this.getArrayDim(expr2);


                            int sc = this.VarLocalExists(var);

                            this.bytecodeList.add(this.counter + " : aload " + sc);
                            this.counter++;

                            this.bytecodeList.add(this.counter + " : ldc " + dim);
                            this.counter++;


                            this.bytecodeList.add(this.counter + " : iaload ");
                            this.counter++;
                        }
                    }
                }

                int sc1 = this.VarLocalExists(q.getArg1().toString().trim());
                int sc2 = this.VarLocalExists(q.getArg2().toString().trim());

                if (this.isNumeric(q.getArg1().toString().trim()) && this.isNumeric(q.getArg2().toString().trim())) {
                    this.bytecodeList.add(this.counter + " : ldc " + q.getArg1());
                    this.counter++;
                    this.bytecodeList.add(this.counter + " : ldc " + q.getArg2());
                    this.counter++;

                } else if (sc1 != -1 && this.isNumeric(q.getArg2().toString().trim())) {

                    if (returnRegExpr(q.getArg1().toString().trim()) != null) {

                        String myexpr = returnRegExpr(q.getArg1().toString().trim());
                        if (myexpr.contains("+") || myexpr.contains("-") || myexpr.contains("*") || myexpr.contains("/") || myexpr.contains("mod")) {
                            this.bytecodeList.add(this.counter + " : iload " + sc1);
                            this.counter++;
                        }
                    }
                    else {
                        this.bytecodeList.add(this.counter + " : iload " + sc1);
                        this.counter++;
                    }
                    this.bytecodeList.add(this.counter + " : ldc " + q.getArg2());
                    this.counter++;

                } else if (this.isNumeric(q.getArg1().toString().trim()) && sc2 != -1) {

                    this.bytecodeList.add(this.counter + " : ldc " + q.getArg1());
                    this.counter++;
                    if (returnRegExpr(q.getArg2().toString().trim()) != null) {
                        String myexpr = returnRegExpr(q.getArg2().toString().trim());
                        if (myexpr.contains("+") || myexpr.contains("-") || myexpr.contains("*") || myexpr.contains("/") || myexpr.contains("mod")) {
                            this.bytecodeList.add(this.counter + " : iload " + sc2);
                            this.counter++;
                        }
                    }
                    else {
                        this.bytecodeList.add(this.counter + " : iload " + sc2);
                        this.counter++;
                    }
                } else if (sc1 != -1 && sc2 != -1) {

                    if (returnRegExpr(q.getArg1().toString().trim()) != null) {
                        String myexpr = returnRegExpr(q.getArg1().toString().trim());
                        if (myexpr.contains("+") || myexpr.contains("-") || myexpr.contains("*") || myexpr.contains("/") || myexpr.contains("mod")) {
                            this.bytecodeList.add(this.counter + " : iload " + sc1);
                            this.counter++;
                        }
                    }
                    else {
                        this.bytecodeList.add(this.counter + " : iload " + sc1);
                        this.counter++;
                    }

                    if (returnRegExpr(q.getArg2().toString().trim()) != null) {
                        String myexpr = returnRegExpr(q.getArg2().toString().trim());
                        if (myexpr.contains("+") || myexpr.contains("-") || myexpr.contains("*") || myexpr.contains("/") || myexpr.contains("mod")) {
                            this.bytecodeList.add(this.counter + " : iload " + sc2);
                            this.counter++;
                        }
                    }
                    else {
                        this.bytecodeList.add(this.counter + " : iload " + sc2);
                        this.counter++;
                    }

                }
            } else if (p.getName().equals("op")) {

                String value = p.getValue();

                if (value.equals("+")) {

                    this.op(q, "iadd");


                } else if (value.equals("-")) {
                    this.op(q, "isub");

                } else if (value.equals("*")) {
                    this.op(q, "imul");

                } else if (value.equals("/")) {
                    this.op(q, "idiv");

                } else if (value.equals("mod")) {
                    this.op(q, "irem");
                }
            }
        } else {

            if (q.getOp().equals("par")) {              //load parametrous analoga me tupo

                if (isNumeric(q.getArg1().toString().trim()) || q.getArg1().toString().trim().contains("'")) {
                    this.bytecodeList.add(this.counter + " : ldc " + q.getArg1());
                    this.counter++;
                } else {

                    boolean flag = false;
                    for (int j = VarLocalList.size() - 1; j >= 0; j--) {

                        if (VarLocalList.get(j).getName().trim().equals(q.getArg1().toString())) {

                            this.bytecodeList.add(this.counter + " : iload " + VarLocalList.get(j).getStoreCounter());
                            this.counter++;

                            flag = true;
                            break;
                        }
                    }

                    try {
                        if (!flag) {
                            throw new MyException("ERROR! VARIABLE NOT INITIALIZED");
                        }
                    } catch (MyException e) {
                        throw new IllegalStateException("ERROR! VARIABLE NOT INITIALIZED");
                    }
                }
            } else if (q.getOp().equals("call")) {        //invoke function


                bytecodeList.add(this.counter + " : new Grace");
                this.counter++;

                bytecodeList.add(this.counter + " : dup");
                this.counter++;

                bytecodeList.add(this.counter + " : invokespecial Grace/<init>()V");
                this.counter++;

                bytecodeList.add(this.counter + " : invokespecial Grace/" + q.getArg3() + setMethodPar((String) q.getArg3()) + setMethodRet((String) q.getArg3()));
                this.counter++;

            } else if (q.getOp().equals(":=")) {

                //get value
                if (this.isNumeric(q.getArg1().toString().trim()) || q.getArg1().toString().contains("'")) {
                    this.bytecodeList.add(this.counter + " : ldc " + q.getArg1());
                    this.counter++;
                } else {


                    boolean flag = false;
                    if (!q.getArg1().toString().contains("$")) {

                        int sc = this.VarLocalExists(q.getArg1().toString().trim());
                        if (sc != -1) {
                            this.bytecodeList.add(this.counter + " : iload " + sc);
                            this.counter++;
                            flag = true;
                        }

                    } else {

                        String expr = "";

                        for (int k = 0; k < registers.size(); k++) {
                            if (registers.get(k).getPosition().equals(q.getArg1().toString())) {

                                expr = registers.get(k).getExpr();
                                flag = true;
                                break;
                            }
                        }
                        int sc = this.VarLocalExists(q.getArg1().toString().trim());

                        if (!(expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/") || expr.contains("mod"))) {
                            if (expr.contains("[")) {
                                this.bytecodeList.add(this.counter + " : iaload ");
                                this.counter++;
                            }
                        } else if (expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/") || expr.contains("mod")) {

                            this.bytecodeList.add(this.counter + " : iload " + sc);
                            this.counter++;


                        }

                    }


                    try {
                        if (!flag) {
                            throw new MyException("ERROR! VARIABLE NOT INITIALIZED");
                        }
                    } catch (MyException e) {
                        throw new IllegalStateException("ERROR! VARIABLE NOT INITIALIZED");
                    }

                }


                VarLocal obj;
                if (q.getArg3().toString().trim().contains("$")) { //is register
                    String value = returnRegExpr(q.getArg3().toString().trim());
                    obj = new VarLocal(q.getArg3().toString().trim(), istoreCounter, value);
                } else {
                    obj = new VarLocal(q.getArg3().toString().trim(), istoreCounter);
                }

                int sc = VarLocalExists(q.getArg3().toString().trim());

                if (sc != -1) {


                    //array already exists
                    if (obj.getValue() != null) {


                        if (obj.getValue().contains("[")) {

                            this.bytecodeList.add(this.counter + " : iastore ");
                            this.counter++;
                            this.istoreCounter++;

                        } else if (obj.getValue().contains("+") || obj.getValue().contains("-") || obj.getValue().contains("*") || obj.getValue().contains("/") || obj.getValue().contains("mod")) {
                            this.bytecodeList.add(this.counter + " : iastore ");
                            this.counter++;
                            this.istoreCounter++;
                        }
                    } else {
                        if (this.isNumeric(q.getArg1().toString().trim())) {
                            this.bytecodeList.add(this.counter + " : istore " + sc);
                            this.counter++;
                        } else {
                            this.bytecodeList.add(this.counter + " : istore " + sc);
                            this.counter++;
                        }

                    }

                } else {

                    if (this.isNumeric(q.getArg3().toString().trim())) {
                        this.bytecodeList.add(this.counter + " : istore " + istoreCounter);
                        this.istoreCounter++;
                    } else if (returnRegExpr(q.getArg3().toString().trim()) != null) {
                        if (returnRegExpr(q.getArg3().toString().trim()).contains("[")) {
                            this.bytecodeList.add(this.counter + " : iastore ");
                            this.istoreCounter++;
                        }
                    }
                    else{
                        this.bytecodeList.add(this.counter + " : istore " + istoreCounter);
                        this.istoreCounter++;
                    }
                    VarLocalList.add(obj);
                    this.counter++;

                }

            } else if (q.getOp().equals("array")) {         //store se arg3 to arg1[arg2]

                //if array doesnt exist

                int sc = this.VarLocalExists(q.getArg1().toString().trim());
                if (sc == -1) {
                    String dimensionOfArray = this.getArrayDimVar(q.getArg1().toString().trim());
                    this.bytecodeList.add(this.counter + " : ldc " + dimensionOfArray);
                    this.counter++;

                    this.bytecodeList.add(this.counter + " : newarray " + this.getTypeArray(q.getArg1().toString().trim()));
                    this.counter++;

                    this.bytecodeList.add(this.counter + " : astore " + this.istoreCounter);
                    this.VarLocalList.add(new VarLocal(q.getArg1().toString(), istoreCounter));
                    this.counter++;
                    this.istoreCounter++;

                    //then assign in the given index a value(numeric/char or not)

                    //get arrayref

                    this.bytecodeList.add(this.counter + " : aload " + (istoreCounter - 1));
                    this.counter++;

                    //get index
                    String count = q.getArg2().toString();
                    this.bytecodeList.add(this.counter + " : ldc " + count);
                    this.counter++;

                    VarLocal obj;

                    //value = apo i[3] to i -> getArg2()

                    String value = this.returnRegExpr(q.getArg3().toString().trim());
                    obj = new VarLocal(q.getArg3().toString().trim(), istoreCounter, value);
                    VarLocalList.add(obj);
                } else {
                    //then assign in the given index a value(numeric/char or not)

                    //get arrayref
                    this.bytecodeList.add(this.counter + " : aload " + sc);
                    this.counter++;

                    //get index
                    String count = q.getArg2().toString();
                    this.bytecodeList.add(this.counter + " : ldc " + count);
                    this.counter++;

                    VarLocal obj;
                    String value = this.returnRegExpr(q.getArg3().toString().trim());
                    obj = new VarLocal(q.getArg3().toString().trim(), istoreCounter, value);
                    VarLocalList.add(obj);
                }

            } else if (q.getOp().equals("ifb")) {

                String expr = returnRegExpr(q.getArg1().toString());
                if (expr.contains("<")) {
                    this.bytecodeList.add(this.counter + " : if_icmplt " + "@" + countQuad);
                    ifbStack.push(new quadCounter(q,countQuad));
                    this.counter++;
                }
                else if (expr.contains(">")) {
                    this.bytecodeList.add(this.counter + " : if_icmpgt " + "@" + countQuad);
                    ifbStack.push(new quadCounter(q,countQuad));
                    this.counter++;
                }
                else if (expr.contains("<=")) {
                    this.bytecodeList.add(this.counter + " : if_icmple " + "@" + countQuad);
                    ifbStack.push(new quadCounter(q,countQuad));
                    this.counter++;
                }
                else if (expr.contains(">=")) {
                    this.bytecodeList.add(this.counter + " : if_icmpge " + "@" + countQuad);
                    ifbStack.push(new quadCounter(q,countQuad));
                    this.counter++;
                }
                else if (expr.contains("=")) {
                    this.bytecodeList.add(this.counter + " : if_icmpeq " + "@" + countQuad);
                    ifbStack.push(new quadCounter(q,countQuad));
                    this.counter++;
                }
                else if (expr.contains("#")) {
                    this.bytecodeList.add(this.counter + " : if_icmpne " + "@" + countQuad);
                    ifbStack.push(new quadCounter(q,countQuad));
                    this.counter++;
                }


            } else if (q.getOp().equals("ret")) {       // ireturn/return

                if (retType.equals("V")) {
                    this.bytecodeList.add(this.counter + " : return");
                    this.counter++;
                } else if (retType.equals("I")) {
                    this.counter--;
                    this.bytecodeList.add("ireturn");
                }
                else if (retType.equals("C"))
                {
                    this.counter--;
                    this.bytecodeList.add("ireturn");
                }
            }
            else if(q.getOp().equals("jump")){

                this.bytecodeList.add(this.counter + " : goto " + "*" + countQuad);
                jumpStack.push(new quadCounter(q,countQuad));

                this.counter++;
            }

        }


    }









    public boolean previousRet(Quad q) {
        if (q.getOp().equals("ret")) {
            return true;
        }
        return false;
    }


    public void changeQuadList() {
        if (quadList.get(0).getOp().equals("unit") && !quadList.get(0).getArg1().equals("main")) {
            //must change quadlist

            int noOfParams = this.getNoOfParamsForQuad(quadList.get(0).getArg1().toString().trim());
            try {
                if (noOfParams != 0) {
                    throw new MyException("ERROR! INITIAL FUNCTION IS NOT MAIN AND HAS PARAMETERS");
                }
            } catch (MyException e) {
                throw new IllegalStateException("ERROR! INITIAL FUNCTION IS NOT MAIN AND HAS PARAMETERS");
            }


            Quad q1 = new Quad("unit", "main", null, null);
            Quad q2 = new Quad("call", null, null, quadList.get(0).getArg1());
            Quad q3 = new Quad("endu", "main", null, null);

            quadList.add(0, q1);
            quadList.add(q2);
            quadList.add(q3);

            this.setQuadListLabels();

        }
    }

    public void setQuadListLabels() {
        for (int i = 0; i < quadList.size(); i++) {
            if (quadList.get(i).getOp().equals("jump")) {
                Integer temp = (Integer) quadList.get(i).getArg3() + 1;
                quadList.get(i).setArg3(temp);
            } else if (quadList.get(i).getOp().equals("jumpl")) {
                Integer temp = (Integer) quadList.get(i).getArg3() + 1;
                quadList.get(i).setArg3(temp);
            } else if (quadList.get(i).getOp().equals("label")) {
                Integer temp = (Integer) quadList.get(i).getArg1() + 1;
                quadList.get(i).setArg1(temp);
            } else if (quadList.get(i).getOp().equals("ifb")) {
                Integer temp = (Integer) quadList.get(i).getArg3() + 1;
                quadList.get(i).setArg3(temp);
            } else {
                if (quadList.get(i).getOp().getClass().getSimpleName().equals("operator")) {
                    operator p = (operator) quadList.get(i).getOp();
                    if (p.getName().equals("relop")) {
                        Integer temp = (Integer) quadList.get(i).getArg3() + 1;
                        quadList.get(i).setArg3(temp);
                    }
                }
            }

        }
    }

    public void printRegisters() {
        System.out.println("\n Printing Registers\n");
        for (int i = 0; i < this.registers.size(); i++) {
            System.out.println(registers.get(i).getPosition() + " " + registers.get(i).getExpr());
        }
    }

    public void printQuadList() {            //print list
        for (int i = 0; i < this.quadList.size(); i++) {
            if (this.quadList.get(i).getOp().getClass().getSimpleName().equals("operator")) {
                operator myOp = (operator) this.quadList.get(i).getOp();
                System.out.println(i + ": " + myOp.getValue() + ", " + this.quadList.get(i).getArg1() + ", " + this.quadList.get(i).getArg2() + ", " + this.quadList.get(i).getArg3());

            } else
                System.out.println(i + ": " + this.quadList.get(i).getOp() + ", " + this.quadList.get(i).getArg1() + ", " + this.quadList.get(i).getArg2() + ", " + this.quadList.get(i).getArg3());
        }
    }


    public void createFuncScope() {
        this.funcScope = new ArrayList<funcBeggining>();

        this.changeQuadList();

        for (int i = 0; i < this.quadList.size(); i++) { //get unit

            if (quadList.get(i).getOp().equals("unit")) {
                int first = i;
                String name = (String) quadList.get(i).getArg1();
                int j = i;
                while (j < quadList.size()) {
                    if (quadList.get(j).getOp().equals("endu") && quadList.get(j).getArg1().equals(name))
                        break;
                    j++;
                }
                int last = j;
                int k = last;
                while (k > first) {
                    if (quadList.get(k).getOp().equals("endu") && !quadList.get(k).getArg1().equals(name))
                        break;
                    k--;
                }
                int second = k + 1;
                funcBeggining obj = new funcBeggining(name, first, second, last);
                funcScope.add(obj);
            }
        }


        this.orderFuncScope();

    }

    public void orderFuncScope() {

        int n = funcScope.size();
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (funcScope.get(j - 1).getLast() > funcScope.get(j).getLast()) {
                    Collections.swap(funcScope, j - 1, j);
                }

            }
        }


    }




    public void op(Quad q, String operator) {
        this.VarLocalList.add(new VarLocal(q.getArg3().toString(), istoreCounter, returnRegExpr(q.getArg3().toString())));

        if (returnRegExpr(q.getArg1().toString().trim()) != null) {
            String expr = returnRegExpr(q.getArg1().toString().trim());

            if (expr.contains("[")) {
                if (!(expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/") || expr.contains("mod"))) {

                    String var = this.getVar(expr);
                    String dim = this.getArrayDim(expr);


                    int sc = this.VarLocalExists(var);

                    this.bytecodeList.add(this.counter + " : aload " + sc);
                    this.counter++;

                    this.bytecodeList.add(this.counter + " : ldc " + dim);
                    this.counter++;


                    this.bytecodeList.add(this.counter + " : iaload ");
                    this.counter++;
                }
            }
        }

        if (returnRegExpr(q.getArg2().toString().trim()) != null) {

            String expr2 = returnRegExpr(q.getArg2().toString().trim());
            if (expr2.contains("[")) {
                if (!(expr2.contains("+") || expr2.contains("-") || expr2.contains("*") || expr2.contains("/") || expr2.contains("mod"))) {

                    String var = this.getVar(expr2);
                    String dim = this.getArrayDim(expr2);


                    int sc = this.VarLocalExists(var);

                    this.bytecodeList.add(this.counter + " : aload " + sc);
                    this.counter++;

                    this.bytecodeList.add(this.counter + " : ldc " + dim);
                    this.counter++;


                    this.bytecodeList.add(this.counter + " : iaload ");
                    this.counter++;
                }
            }
        }

        int sc1 = this.VarLocalExists(q.getArg1().toString().trim());
        int sc2 = this.VarLocalExists(q.getArg2().toString().trim());

        if (this.isNumeric(q.getArg1().toString().trim()) && this.isNumeric(q.getArg2().toString().trim())) {
            this.bytecodeList.add(this.counter + " : ldc " + q.getArg1());
            this.counter++;
            this.bytecodeList.add(this.counter + " : ldc " + q.getArg2());
            this.counter++;
            this.bytecodeList.add(this.counter + " : " + operator);
            this.counter++;
            this.bytecodeList.add(this.counter + " : istore " + this.istoreCounter);
            this.counter++;
            this.istoreCounter++;

        } else if (sc1 != -1 && this.isNumeric(q.getArg2().toString().trim())) {

            if (returnRegExpr(q.getArg1().toString().trim()) != null) {
                String myexpr = returnRegExpr(q.getArg1().toString().trim());
                if (myexpr.contains("+") || myexpr.contains("-") || myexpr.contains("*") || myexpr.contains("/") || myexpr.contains("mod")) {
                    this.bytecodeList.add(this.counter + " : iload " + sc1);
                    this.counter++;
                }
            }
            else {
                this.bytecodeList.add(this.counter + " : iload " + sc1);
                this.counter++;
            }
            this.bytecodeList.add(this.counter + " : ldc " + q.getArg2());
            this.counter++;
            this.bytecodeList.add(this.counter + " : " + operator);
            this.counter++;
            this.bytecodeList.add(this.counter + " : istore " + this.istoreCounter);
            this.counter++;
            this.istoreCounter++;
        } else if (this.isNumeric(q.getArg1().toString().trim()) && sc2 != -1) {

            this.bytecodeList.add(this.counter + " : ldc " + q.getArg1());
            this.counter++;
            if (returnRegExpr(q.getArg2().toString().trim()) != null) {
                String myexpr = returnRegExpr(q.getArg2().toString().trim());
                if (myexpr.contains("+") || myexpr.contains("-") || myexpr.contains("*") || myexpr.contains("/") || myexpr.contains("mod")) {
                    this.bytecodeList.add(this.counter + " : iload " + sc2);
                    this.counter++;
                }
            }
            else {
                this.bytecodeList.add(this.counter + " : iload " + sc2);
                this.counter++;
            }


            this.bytecodeList.add(this.counter + " : " + operator);
            this.counter++;
            this.bytecodeList.add(this.counter + " : istore " + this.istoreCounter);
            this.counter++;
            this.istoreCounter++;
        } else if (sc1 != -1 && sc2 != -1) {

            if (returnRegExpr(q.getArg1().toString().trim()) != null) {
                String myexpr = returnRegExpr(q.getArg1().toString().trim());
                if (myexpr.contains("+") || myexpr.contains("-") || myexpr.contains("*") || myexpr.contains("/") || myexpr.contains("mod")) {
                    this.bytecodeList.add(this.counter + " : iload " + sc1);
                    this.counter++;
                }
            }
            else {
                this.bytecodeList.add(this.counter + " : iload " + sc1);
                this.counter++;
            }

            if (returnRegExpr(q.getArg2().toString().trim()) != null) {
                String myexpr = returnRegExpr(q.getArg2().toString().trim());
                if (myexpr.contains("+") || myexpr.contains("-") || myexpr.contains("*") || myexpr.contains("/") || myexpr.contains("mod")) {
                    this.bytecodeList.add(this.counter + " : iload " + sc2);
                    this.counter++;
                }
            }
            else {
                this.bytecodeList.add(this.counter + " : iload " + sc2);
                this.counter++;
            }


            this.bytecodeList.add(this.counter + " : " + operator);
            this.counter++;
            this.bytecodeList.add(this.counter + " : istore " + this.istoreCounter);
            this.counter++;
            this.istoreCounter++;
        }

    }

    public String getTypeArray(String name) {
        String type = "";
        for (int i = 0; i < this.allVars.size(); i++) {
            if (this.allVars.get(i).getName().equals(name)) {
                type = this.allVars.get(i).getType();
            }
        }

        if (type.contains("int")) {
            type = "int";
        } else if (type.contains("char")) {
            type = "char";
        }

        return type;
    }

    public String getArrayDim(String name) {

        int j = 0;
        String dim = "";

        while (j < name.length()) {

            char c = name.charAt(j);
            if (c == '[') {
                while (c != ']') {
                    j++;
                    c = name.charAt(j);
                    if (c == ']') {
                        break;
                    }
                    dim += c;
                }
                break;
            }
            j++;
        }
        return dim;
    }

    public String getArrayDimVar(String name) {

        String type = "";
        for (int i = 0; i < this.allVars.size(); i++) {
            if (this.allVars.get(i).getName().equals(name)) {
                type = this.allVars.get(i).getType();
                break;
            }
        }

        int j = 0;
        String dim = "";

        while (j < type.length()) {

            char c = type.charAt(j);
            if (c == '[') {
                while (c != ']') {
                    j++;
                    c = type.charAt(j);
                    if (c == ']') {
                        break;
                    }
                    dim += c;
                }
                break;
            }
            j++;
        }
        return dim;
    }


    public void printAllVars() {
        System.out.println("\n Printing all vars\n");
        for (int i = 0; i < this.allVars.size(); i++) {
            System.out.println(this.allVars.get(i).getName() + " " + this.allVars.get(i).getType());
        }
    }


    public String getVar(String name) {

        int j = 0;
        String varName = "";
        while (j < name.length()) {
            char c = name.charAt(j);
            if (c == '[') {
                break;
            }
            varName += c;
            j++;
        }
        return varName;
    }


    public int VarLocalExists(String name) {

        for (int i = 0; i < VarLocalList.size(); i++) {
            if (VarLocalList.get(i).getName().equals(name) && !name.contains("$"))
                return VarLocalList.get(i).getStoreCounter();
            else if (name.contains(("$"))) {
                if (returnRegExpr(name).equals(VarLocalList.get(i).getValue())) {
                    return VarLocalList.get(i).getStoreCounter();
                }
            }
        }
        return -1;      //doesn't exist
    }


    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public void findFunctionScope() {
        int scope = 0;
        myFuncScopeHelperList = new ArrayList<FuncScopeHelper>();

        for (int i = 0; i < this.InitialQuadList.size(); i++) {
            if (InitialQuadList.get(i).getOp().equals("unit")) {
                FuncScopeHelper helper = new FuncScopeHelper((String) InitialQuadList.get(i).getArg1(), scope);
                scope++;
                myFuncScopeHelperList.add(helper);
            }
            if (InitialQuadList.get(i).getOp().equals("endu")) {
                scope--;
            }
        }

    }

    public String setMethodRet(String name) {
        int scope = 0;
        for (int i = 0; i < this.myFuncScopeHelperList.size(); i++) {
            if (this.myFuncScopeHelperList.get(i).getFuncName().equals(name)) {
                scope = myFuncScopeHelperList.get(i).getScope();
            }
        }
        String type = "";
        for (int i = 0; i < funcStack.size(); i++) {
            if (funcStack.get(i).getFuncName().equals(name) && funcStack.get(i).getScope() == scope) {
                type = funcStack.get(i).getType();
            }
        }

        if (type.equals("int")) {
            return "I";
        } else if (type.equals("char")) {
            return "C";
        } else
            return "V";
    }


    public int getNoOfParamsForQuad(String name) {
        int scope = 0;


        for (int i = 0; i < funcStack.size(); i++) {
            if (funcStack.get(i).getFuncName().equals(name) && funcStack.get(i).getScope() == scope) {
                return funcStack.get(i).getTypesOfPatameters().size();
            }
        }
        return 0;
    }


    public int getNoOfParams(String name) {
        int scope = 0;

        for (int i = 0; i < this.myFuncScopeHelperList.size(); i++) {
            if (this.myFuncScopeHelperList.get(i).getFuncName().equals(name)) {
                scope = myFuncScopeHelperList.get(i).getScope();
            }
        }

        for (int i = 0; i < funcStack.size(); i++) {
            if (funcStack.get(i).getFuncName().equals(name) && funcStack.get(i).getScope() == scope) {
                return funcStack.get(i).getTypesOfPatameters().size();
            }
        }
        return 0;
    }

    public String setMethodPar(String name) {
        int scope = 0;
        for (int i = 0; i < this.myFuncScopeHelperList.size(); i++) {
            if (this.myFuncScopeHelperList.get(i).getFuncName().equals(name)) {
                scope = myFuncScopeHelperList.get(i).getScope();
            }
        }
        List<String> types = new ArrayList<String>();
        for (int i = 0; i < funcStack.size(); i++) {
            if (funcStack.get(i).getFuncName().equals(name) && funcStack.get(i).getScope() == scope) {
                types = funcStack.get(i).getTypesOfPatameters();
            }
        }
        String parameters = "(";
        for (int i = 0; i < types.size(); i++) {
            int counterBr = 0;
            if (types.get(i).contains("[")) {
                int j = 0;
                char c;

                while (j < types.get(i).length()) {
                    c = types.get(i).charAt(j);
                    if (c == '[') {
                        counterBr++;
                    }
                    j++;
                }
            }

            if (types.get(i).equals("int")) {
                parameters += "I";
            } else if (types.get(i).equals("char")) {
                parameters += "C";
            } else if (types.get(i).contains("int[")) {
                for (int k = 0; k < counterBr; k++) {
                    parameters += "[";
                }
                parameters += "I";
            } else if (types.get(i).contains("char[")) {
                for (int k = 0; k < counterBr; k++) {
                    parameters += "[";
                }
                parameters += "C";
            }
        }
        parameters += ")";


        return parameters;

    }


    public void printFuncScopeHelper() {
        for (int i = 0; i < myFuncScopeHelperList.size(); i++) {
            System.out.println("Name: " + myFuncScopeHelperList.get(i).getFuncName() + " scope: " + myFuncScopeHelperList.get(i).getScope());
        }
    }


    public String returnRegExpr(String name) {
        boolean exprFound = false;

        while (name.contains("$")) {
            exprFound = false;
            for (int i = 0; i < this.registers.size(); i++) {
                if (this.registers.get(i).getPosition().equals(name)) {
                    name = this.registers.get(i).getExpr();
                    exprFound = true;
                    break;

                }
            }
            if (!exprFound) {
                break;
            }
        }
        if (exprFound) return name;
        return null;
    }

    public void PrintVarLocal() {

        System.out.println("\n\n Printing VarLocalList \n");
        for (int i = 0; i < VarLocalList.size(); i++) {
            String forPrint = VarLocalList.get(i).getName() + " " + VarLocalList.get(i).getStoreCounter() + " " + VarLocalList.get(i).getValue();
            System.out.println(forPrint);
        }
    }

    public List<String> getRegRelop(int count) {
        count++;        //get next quad
        Quad nextQuad = this.quadList.get(count);
        String reg = nextQuad.getArg1().toString();
        String expr = this.returnRegExpr(reg);
        List<String> regExpr = new ArrayList<String>();
        regExpr.add(reg);
        regExpr.add(expr);
        return regExpr;
    }

    public int branchFinder(int jumpArg) {
        Quad getBranchedQuad = this.quadList.get(jumpArg);


        return 0;
    }

}
