import java.io.*; 

class Node {
    int data;
    Node next;
    
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList {
    Node head;
    int length;
    
    public LinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    public static void myExit(String code) {
        System.out.println(code);
        System.exit(1);
    }
    
    public void insertEnd(int data) {
        if (head == null) {
            head = new Node(data, null);
            length++;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        Node newNode = new Node(data, null);
        tmp.next = newNode;
        length++;
    }
    
    public boolean insertAtInd(int index, int data) {
        if (isEmpty() || index < 0 || index > length) {
            return false;
        }
        Node tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        Node newNode = new Node(data, tmp.next);
        tmp.next = newNode;
        length++;
        return true;
    }
    
    public int count() {
        return length;
    }
    
    boolean isEmpty() {
        return head == null;
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("null");
            return;
        }
        Node tmp = head;
        
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    
    void deleteNext(Node node) {
        Node tmp = node.next;
        node.next = tmp.next;
        length--;
    }
    
    public int deleteAll(int data) {
        int count = 0;
        
        if (isEmpty())
            return 0;
        
        while (head.data == data) {
            head = head.next;
            count++;
            length--;
            if (isEmpty())
                return count;
        }
        
        Node node = head;
        while (node.next != null) {
            if (node.next.data == data) {
                deleteNext(node);
                count++;
                continue;
            }
            node = node.next;
        }
        return count;
    }
    
    Node reverseAll(Node node) {
        Node prev = null;
        Node curr = node;
        Node next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
    
    public void reverse() {
        if (isEmpty())
            return;
        head = reverseAll(head);
    }
    
    void printAtIndex(int index, int count) {
        if (isEmpty()) {
            System.out.println("NONE");
            return;
        }
        Node tmp = new Node(head.data, head.next);
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    
    public void midValue() {
        if (length % 2 == 0)
            printAtIndex(length / 2 - 1, 2);
        else
            printAtIndex(length / 2, 1);
        
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        
        while (true) {
            try {
                input = reader.readLine();
            } catch (IOException e) {
                myExit("IO Exception");
            }
            
            String[] inputArr = input.trim().split(" ");
            char operation = inputArr[0].charAt(0);
            
            switch (operation) {
                case 'i':
                    list.insertEnd(Integer.parseInt(inputArr[1]));
                break;
                case 'n':
                    int status = list.insertAtInd(Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2]))? 1 : 0;
                    System.out.println(status);
                break;
                case 'p':
                    list.print();
                break;
                case 'r':
                    list.reverse();
                break;
                case 'c':
                    System.out.println(list.count());
                break;
                case 'm':
                    list.midValue();
                break;
                case 'd':
                    System.out.println(list.deleteAll(Integer.parseInt(inputArr[1])));
                break;
                case 'q':
                    System.exit(0);
                break;
            }
        }
    }
}