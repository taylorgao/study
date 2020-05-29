package guardclauses;
//卫语句
//即代码逻辑先考虑失败、异常、中断、退出等直接返回的情况，以方法多个出口的方式，解决代码中判断
//分支嵌套的问题，这是逆向思维的体现。
public class TestGuardClause {
    public static void main(String[] args) {
        new TestGuardClause().test();
    }

    /*
    * 任何人都看的懂以上代码（只要理解英文单词即可），
    * 因为条件判断与结果产生一种映射关系，大脑里不用堆砌任何代码栈，
    * 傻瓜式看代码就行。
    * */
    public int test(){
        if (isDead()) return deadPayAmount();
        if (isSeparated()) return separatedPayAmount();
        if (isRetired()) return retiredPayAmount();
        return normalPayAmount();
    }

    /**
     * @return test  注释必须使用 Javadoc 规范
     */
    private int normalPayAmount() {
        return 0;
    }

    private int retiredPayAmount() {
        return 0;
    }

    private int separatedPayAmount() {
        return 0;
    }

    private int deadPayAmount() {
        return 0;
    }

    private boolean isRetired() {
        return true;
    }

    private boolean isSeparated() {
        return true;
    }

    private boolean isDead() {
        return true;
    }
}
