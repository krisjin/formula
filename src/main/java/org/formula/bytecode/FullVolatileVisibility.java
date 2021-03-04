package org.formula.bytecode;

/**
 * 测试volatile关键字特性
 * <p>
 * 当程序执行到volatile变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经进行，且结果已经对后面的操作可见；在其后面的操作肯定还没有进行；
 * 在进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行。
 * <p>
 * volatile 可以保证内存可见性，怎么保证的，是否有示例
 * <p>
 * 1、重排序含义：CPU为了提高程序的运行效率，对原序输入的代码进行顺序优化，但它保证程序的最终执行结果与原序执行结果一致。譬如你在上午放学后，为了精力充沛地完成下午的课堂。
 * 需要进行1、吃饭；2、洗头；3、睡午觉；由于食堂排队的人多，你的大脑（CPU）可以为了提高效率，选择了213的执行顺序，但不影响“精力充沛地完成下午的课堂”这个最终结果。
 * 为了CPU的执行效率而对代码顺序进行优化的一种操作。
 * 2、volatile 禁止重排序含义：
 *
 * 顺序性与重排序的关系
 *
 * <p>
 * <p>
 * cpu执行重排序问题
 * User:krisjin
 * Date:2020-05-01
 */
public class FullVolatileVisibility {

    private String varA;
    private String varB;
    private volatile String varC;//声明volatile


    /**
     * 读取数据
     */
    public void readVar() {
        String strVar = this.varC;//我在开始
        strVar += varA;
        strVar += varB;
    }

    /**
     * 更新数据
     *
     * @param varA
     * @param varB
     * @param varC
     */
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
