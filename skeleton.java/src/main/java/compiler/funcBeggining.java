package compiler;

public class funcBeggining {        //first, second and last line of function
    private String name;
    private int first;
    private int second;
    private int last;

    public funcBeggining(String name, int first, int second, int last){
        this.name = name;
        this.first = first;
        this.second = second;
        this.last = last;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public String getName() {
        return name;
    }

    public int getLast() {
        return last;
    }

    public void print(){
        System.out.println("Name: "+ name + " First: " + first + " Second: " + second + " Last: "+ last);
    }


}
