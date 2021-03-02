package org.formula.bytecode;

/**
 * 当程序执行到volatile变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经进行，且结果已经对后面的操作可见；在其后面的操作肯定还没有进行；
 * 在进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行。
 * User:krisjin
 * Date:2020-05-01
 */
public class FullVolatileVisibility {

    private String varA;
    private String varB;
    private volatile String varC;//声明volatile

    public void readVar() {
        String strVar = this.varC;//我在开始
        strVar += varA;
        strVar += varB;
    }

    public void updateVar(String varA, String varB, String varC) {
        this.varA = varA;
        this.varB = varB;
        this.varC = varC;//我在最后
    }

    public static void main(String[] args) {
        FullVolatileVisibility fullVolatileVisibility = new FullVolatileVisibility();

        fullVolatileVisibility.updateVar("a", "b", "c");
    }

}
