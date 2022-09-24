public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if(this.head == null) {
            this.head = newNode;
        } else {
            Node runner = this.head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        int y = 0;
        Node runner2 = this.head;
        while(runner2.next != null){
            y++;
            runner2 = runner2.next;
        }
    }

    public String remove(){
        int n = 1;
        if (this.head == null){
            return ("No values to delete!");
        }
        Node runner3 = this.head;
        Node deleted;
        if (this.head.next == null){
            deleted = this.head;
            this.head = null;
            System.out.println("Deleted item was index: 0 -> value: "+ deleted.value + "\n");
            return ("");
        }
        else if(this.head.next.next == null){
            deleted = this.head.next;
            this.head.next = null;
            System.out.println("Deleted item was index: 1 -> value: "+ deleted.value + "\n");
            return ("");
        }
        while (runner3.next.next != null){
            runner3 = runner3.next;
            n++;
        }
        deleted = runner3.next;
        runner3.next = null;
            System.out.println("Deleted item was index: "+ n + " -> value: "+ deleted.value + "\n");
            return ("");
    }
    
    public String printValues(){

        if( this.head == null){
        System.out.println("B");
            String listEmpty = "This list is empty!";
            System.out.println(listEmpty);
            return listEmpty;
        } else {
            int n = 0;
            Node runner4 = this.head;
            String printList = ("node " + n + ": "+ runner4.value);
            while( runner4.next != null){
                runner4 = runner4.next;
                n++;
                String temp = ("node " + n + ": "+runner4.value);
                printList = printList +"\n"+ temp;
            }
        System.out.println(printList + "\n");
        return printList;
        }
    }

    public Node find(int x){
        int foundAt = 0;
        if (this.head.value == x){
            System.out.println("We found your object with the value: " + x + "-> at index: " + foundAt + "\n");
            return this.head;
        }
        Node runner5 = this.head;
        while (runner5.next != null){
            runner5 = runner5.next;
            foundAt++;
            if(runner5.value == x){
                System.out.println("We found your object with the value: " + x + "-> at index: " + foundAt +"\n");
                return runner5;
            }
        }
        System.out.println("There is no object in this list with the value "+ x + "\n");
        return null;
    }

    public String removeAt(int y){
        int index = y;
        String removed;
        Node runner6 = this.head;
        if (this.head == null){
            System.out.println("The list is empty!\n");
            return "The list is empty!";
        }
        if (index == 0){
            printValues();
            this.head = runner6.next;
            removed = ("We deleted item at index: " + y + " -> value: " + runner6.value + "\n");
            System.out.println(removed);
            return removed;
        }
        while (index > 1){
            if (runner6.next == null){
                runner6 = this.head;
                printValues();
                System.out.println("There is no item at an index that far!\n");
                return ("There is no item at an index that far!");
            }            
            runner6 = runner6.next;
            index--;
        }
        if (runner6.next == null){
            System.out.println("You only have 1 item in this list, at index 0");
            return ("You only have 1 item in this list, at index 0");
        }
        printValues();
        removed = ("Removed item at index: " + y + "- value " + runner6.next.value);
        runner6.next = runner6.next.next;
        System.out.println(removed);
        return removed;
    }
    
}
