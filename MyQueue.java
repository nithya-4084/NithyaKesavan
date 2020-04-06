import java.io.*;

 class MyQueue {
    int end;
    int front;
    int[] c;
    static final int Q_MAX = 30;
    
    public MyQueue() {
        this.end = 0;
        this.front = 0;
        this.c = new int[Q_MAX];
    }
    
    public static void exit(String code) {
        System.out.println(code);
        System.exit(1);
    }
    
    public void enqueue(int elem) {
        if (this.isFull())
            exit("-1");
        
        this.c[this.front] = elem;
        this.front = (this.front + 1) % Q_MAX;
    }
    
    public int dequeue() {
        if (this.isEmpty())
            exit("-2");
        int value = this.c[this.end];
        this.end = (this.end + 1) % Q_MAX;
        return value;
    }
    
    public int front() {
        if (this.isEmpty())
            exit("-3");
        
        if (this.front > 0)
           return this.c[this.front - 1];
       
        return this.c[Q_MAX - 1];
    }
    
    public int getSize() {
        if (this.isEmpty())
            return 0;
        if (this.end < this.front)
            return this.front - this.end;
        
        return Q_MAX - this.end + this.front;
    }
    
    public boolean isEmpty() {
        return this.front == this.end;
    }
    
    public boolean isFull() {
        return this.getSize() == Q_MAX - 1;
    }
    
    public void display() {
        int i = 0;
        int curr = this.end;
        int qSize = this.getSize();
        
        for (i = 0; i < qSize; i++) {
            System.out.print(this.c[curr] + " ");
            curr = (curr + 1) % Q_MAX;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            exit("IO Exception");
        }
        
        int queries = Integer.parseInt(input.trim());
        
        for (int i = 0; i < queries; i++) {
            try {
                input = reader.readLine();
            } catch (IOException e) {
                exit("IO Exception");
            }
            String[] inputArr = input.trim().split(" ");
            int operation = Integer.parseInt(inputArr[0]);
            switch (operation) {
                case 1:
                    queue.enqueue(Integer.parseInt(inputArr[1]));
                break;
                case 2:
                    System.out.println(queue.dequeue());
                break;
                case 3:
                    System.out.println(queue.front());
                break;
                case 4:
                    queue.display();
                break;
                case 5:
                    if (queue.isEmpty())
                        System.out.println("1");
                    else
                        System.out.println("0");
                break;
                case 6:
                    System.out.println(queue.getSize());
                break;
                case 7:
                    if (queue.isFull())
                        System.exit(0);
                    System.out.println("0");
                break;
            }
        }
    }
}