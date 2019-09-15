package lkl.stack;
/*
数据结构--栈
顺序栈：一般用数组来实现，主要有四个元素：2状态2操作
 */
public class SqStack {
    private int data[];  //用数组表示栈元素
    private int maxSize; //栈空间大小
    private int top;     //栈顶指针（指向栈顶元素）

    public SqStack(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
        this.top = -1;
    }
    //判断栈是否为空
    public boolean isNull(){
        boolean flag = this.top<=-1?true:false;
        return flag;
    }
    //判断栈是否已满
    public boolean isFull(){
        boolean flag = this.top==maxSize-1?true:false;
        return flag;
    }
    //压栈
    public boolean push(int value){
        if (isFull()){
            return false;
        }else{
            data[++top] = value;
            return true;
        }
    }
    //弹栈（出栈）
    public void pop(){
        if (isNull()){
            return ;
        }else{
            int top_value = data[top];
            System.out.print(top_value+" ");
            --top;
        }
    }
}
