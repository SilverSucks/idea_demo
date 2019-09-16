package lkl.stack;

public class TestLinkStack {
    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        linkStack.initStack();


        linkStack.pushStack(new Node(1));
        linkStack.pushStack(new Node(2));
        linkStack.pushStack(new Node(3));
        while (!linkStack.isEmpty()){
            linkStack.popStack();
        }

        /*linkStack.PushStack(new Node(2));
        System.out.println(linkStack.isEmpty());*/
    }
}
