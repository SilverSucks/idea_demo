package lkl.stack;

public class TestSqStack {
    public static void main(String[] args) {
        SqStack sqStack = new SqStack(5);
        for (int i = 0; i < 5; i++) {
            sqStack.push(i);
        }
        for (int i = 0; i < 5; i++) {
            sqStack.pop();
        }
    }
}
