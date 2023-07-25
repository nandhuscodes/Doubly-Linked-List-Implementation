import java.util.Scanner;

class Node{
    int value;
    Node prev;
    Node next;
    Node(int value){
        this.value = value;
    }
}
class DoublyLinkedList{
    Node head;
    Node tail;
    int length;

    // create doubly linked list
    DoublyLinkedList(){

    }

    // Display
    void printDLL(){
        Node temp = head;
        for(int i = 0; i < length; i++){
            System.out.print(temp.value+" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Insert at beginning
    void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    // Insert at end
    void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    // Insert at index
    boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after = before.next;
        newNode.prev = after.prev;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    // Get Node
    Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        if(index < length/2){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for(int i = length-1; i > index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }
    void getLength(){
        System.out.println(length);
    }
    void getHead(){
        System.out.println(head.value);
    }
    void getTail(){
        System.out.println(tail.value);
    }

    // Remove from First
    Node removeFromFirst(){
        if(length == 0){
            return  null;
        }
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }
    // Remove from last
    Node removeFromLast(){
        if(length == 0){
            return null;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }
    // Remove from index
    Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }
        if(index == 0){
            return removeFromFirst();
        }
        if(index == length-1){
            return removeFromLast();
        }
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    // Set Node
    boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }
}
public class DoublyLinkedListImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Linked List Implementations");
        DoublyLinkedList myList = new DoublyLinkedList();
        int data = 0, i = 0;
        System.out.println("Enter your linked list elements and type -1 to stop");
        while(true){
            data = scanner.nextInt();
            if(data == -1){
                break;
            }
            myList.insert(i++, data);
        }
        System.out.println("Your linked list looks like...");
        myList.printDLL();
        char choice = 'y';
        while(choice == 'y'){
            System.out.println("Implementations on Linked List\n1 -> Display\n2 -> Insert at beginning (prepend)\n3 -> Insert at end (append)\n4 -> Insert at index\n5 -> Remove from first\n6 -> Remove from Last\n7 -> Remove from index\n8 -> Get the value of given node\n9 -> Get Size of the linked List\n10 -> Get value that HEAD pointing to\n11 -> Get the value pointing to TAIL\n12 -> Update the value of given index");
            System.out.print("Enter one of the following options to see its implementation: ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Display...");
                    myList.printDLL();
                    break;
                case 2:
                    System.out.println("before insertion: ");
                    myList.printDLL();
                    System.out.print("Enter the value to prepend: ");
                    myList.prepend(scanner.nextInt());
                    System.out.println("after insertion");
                    myList.printDLL();
                    break;
                case 3:
                    System.out.println("before insertion: ");
                    myList.printDLL();
                    System.out.print("Enter the value to append: ");
                    myList.append(scanner.nextInt());
                    System.out.println("after insertion");
                    myList.printDLL();
                    break;
                case 4:
                    System.out.println("before insertion: ");
                    myList.printDLL();
                    System.out.print("Enter the index, value to insert: ");
                    while(!myList.insert(scanner.nextInt(), scanner.nextInt())){
                        System.out.print("Enter valid index, value to insert: ");
                    }
                    System.out.println("after insertion");
                    myList.printDLL();
                    break;
                case 5:
                    System.out.println("before deletion: ");
                    myList.printDLL();
                    System.out.println("Removing first element...");
                    myList.removeFromFirst();
                    System.out.println("after deletion");
                    myList.printDLL();
                    break;
                case 6:
                    System.out.println("before deletion: ");
                    myList.printDLL();
                    System.out.println("Removing last element...");
                    myList.removeFromLast();
                    System.out.println("after deletion");
                    myList.printDLL();
                    break;
                case 7:
                    System.out.println("before deletion: ");
                    myList.printDLL();
                    System.out.print("Enter the index you want to remove: ");
                    myList.remove(scanner.nextInt());
                    System.out.println("after deletion");
                    myList.printDLL();
                    break;
                case 8:
                    System.out.print("Enter the index of the node you want to get: ");
                    System.out.println("Value: "+myList.get(scanner.nextInt()).value);
                    break;
                case 9:
                    System.out.print("Size of the linked list: ");
                    myList.getLength();
                    break;
                case 10:
                    System.out.print("Head element: ");
                    myList.getHead();
                    break;
                case 11:
                    System.out.print("Tail element: ");
                    myList.getTail();
                    break;
                case 12:
                    System.out.println("before updating");
                    myList.printDLL();
                    System.out.print("Enter the index, value to update: ");
                    while (!myList.set(scanner.nextInt(), scanner.nextInt())){
                        System.out.print("Enter valid index, value to update: ");
                    }
                    System.out.println("after updating");
                    myList.printDLL();
                    break;
            }
            System.out.print("You want to explore more implementation (y/n): ");
            choice = scanner.next().charAt(0);
        }
        scanner.close();
    }
}
