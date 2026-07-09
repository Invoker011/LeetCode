package Skip_List_1206;
import java.util.Random;
public class Skiplist {
    //Maximum Level for this Skip list;
    private static final int MAX_LEVEL = 32;
    //probability to decide which level to insert
    private static final double P = 0.5;

    private Node head;
    private Random rand;
    //Node Class representation for skip list;
    private class Node{
        int val;
        Node[] next;
        public Node(int val, int level){
            this.val = val;
            this.next = new Node[level];
        }
    }

    public Skiplist(){
        head = new Node(-1, MAX_LEVEL);
        rand = new Random();
    }

    public boolean search(int target){
        Node curr = head;

        for(int level = MAX_LEVEL-1; level >= 0; level--){
            while(curr.next[level] != null && curr.next[level].val < target){
                curr = curr.next[level];
            }
        }
        curr = curr.next[0];

        return curr != null && curr.val == target;
    }

    public  void add(int num){
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;

        for(int level = MAX_LEVEL-1; level >=0;level--){
            while(curr.next[level] != null && curr.next[level].val < num){
                curr = curr.next[level];
            }
            update[level] = curr;
        }
        // generate random level for new node;
        int newlevel = randomLevel();
        Node newNode = new Node(num, newlevel);
        //add newNode each level it belong to 
        for(int level = 0; level < newlevel; level++){
            newNode.next[level] = update[level].next[level];
            update[level].next[level] = newNode;
        }

    }

    public boolean erase(int num){
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;

        for(int level = MAX_LEVEL -1; level >=0;level--){
            while(curr.next[level] != null && curr.next[level].val < num ){
                curr = curr.next[level];
            }
            update[level] = curr;
        }
        curr = curr.next[0];

        if(curr == null || curr.val != num) return false;

        for(int level =0; level<curr.next.length;level++){
            if(update[level].next[level] == curr){
                update[level].next[level] = curr.next[level];
            }
        }
        return true;
    }

    private int randomLevel(){
        int level = 1;
        //keep increasing level with probability 0.5;
        while(level < MAX_LEVEL && rand.nextDouble() < P){
            level++;
        }
        return level;
    }

    
}
