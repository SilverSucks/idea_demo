package lkl.queue;
/*
顺序队列：里面维持一个数组，两状态：判断队列是否为空，判断队列是否已满，两操作：进队列和出队列
 */
public class SqQueue {
    int[] data;
    int maxnum;  //队列可容纳的最大值
    int front;   //队头指针，始终指向队列的第一个元素
    int rail;    //队尾指针，始终指向队列的最后一个元素

    //初始化队列，队列的长度，队头指针和队尾指针都指向第一个元素
    public SqQueue(int maxnum) {
        this.maxnum = maxnum;
        data = new int[maxnum];
        front = 0;
        rail = -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rail==-1?true:false;
    }
    //判断队列是否已满
    public boolean isFull(){
        return rail-front+1 == maxnum ? true:false;
    }
    //进队列
    public void InQueue(int num){
        //进队列的每个元素总是插入到队列的后面
        ++rail;
        data[rail] = num;

    }
    //出队列：总是队头先出
    public void OutQueue(){
        if (isEmpty()){  //队列为空，不做任何操作
            return ;
        }else{
            System.out.printf("出队列元素：%d\n",data[front]);
            //队列中的后一个元素依次覆盖前面的元素
            for (int i = 1; i <= rail; i++) {
                data[i-1] = data[i];
            }
            //修改rail指针的指向
            --rail;
        }
    }
    //打印队列中都有哪些值
    public void printQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else{
            for (int i = 0; i <= rail; i++) {
                System.out.printf("%3d",data[i]);
            }
            System.out.println();
        }
    }
}
