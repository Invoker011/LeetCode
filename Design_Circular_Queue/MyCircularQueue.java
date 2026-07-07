package Design_Circular_Queue;
import java.util.*;
public class MyCircularQueue {
    int front;
    int rear;
    int size;
    int[] q;
    public MyCircularQueue(int queueLength){
        front = 0;
        rear = 0;
        size =0;
        q = new int[queueLength];
        Arrays.fill(q, -1);
    }
    public int Front(){
        return q[front];
    }
    public int Rear(){
        return q[rear];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == q.length;
    }
    public boolean EnQueue(int value){
        if(isFull()) return false;
        if(isEmpty()){
            front = rear = 0;
            q[rear] = value;
            rear++;
            size++;
            return true;
        }
        rear++;
        rear = rear % q.length;
        q[rear] = value;
        size++;
        return true;
    }
    public boolean DeQueue(){
        if(isEmpty()) return false;
        q[front] = -1;
        size--;
        front++;
        front = front % q.length;
        return true;
    }
}
