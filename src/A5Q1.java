package assignment5; 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Parry Katodia
 */
public class A5Q1 {
    private IntNode head;
    private int numItems;

    public A5Q1() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {
        // start at beginning of list
        IntNode node = head;
        // see if it is first item
        if(head == null){
            // @ node just before the insert
        IntNode temp = new IntNode(num);
        head = temp;
        numItems++;
        }else if(numItems == 1 || node.getNum() > num){
            IntNode temp = new IntNode(num);
            if(node.getNum() < num){
                // change node pointer
                node.setNext(temp);
            }else{
                // set head as the temp
                head = temp;
                // change node pointer
                temp.setNext(node);
            }
            numItems++;
        }
        else{
        
            while(node.getNum() < num && node.getNext() != null && node.getNext().getNum() < num){
		node = node.getNext();
}
	if(node.getNext() == null){
            // create a new node
            IntNode temp = new IntNode(num);
            // insert it into the list
            node.setNext(temp);
}else{
	// @ node just before the insert
        IntNode temp = new IntNode(num);
        // create the after link first!
        temp.setNext(node.getNext());
        // change node pointer
        node.setNext(temp);
}
        // increase the size counter
        numItems++;
    }
    }
    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int position) {
        IntNode node = head;
        // move the number of times
        for (int i = 0; i < position; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    public void remove(int num) {
        IntNode node = head;
        if(node.getNum() > num){
	System.out.println("Number is not in the list.");
} else if(node.getNum() == num){
        head = node.getNext();
	numItems--;
}else{
	while(node.getNext() != null && node.getNext().getNum() != num){
		node = node.getNext();
}
        if(node.getNext() == null){
            System.out.println("Number is not in the list.");
        }else if(node.getNext().getNum() == num){
            // the node to remove
            IntNode toRemove = node.getNext();
            // its next node
            IntNode next = toRemove.getNext();
            // set all the links
            node.setNext(next);
            toRemove.setNext(null);
            numItems--;
}
    }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test the methods
        A5Q1 list = new A5Q1();
        
        list.add(2);
        list.remove(2);
        list.add(-5);
        list.add(13);
        list.add(3);
        list.remove(13);
        list.add(14);
        list.add(-10);
        list.remove(3);
        list.remove(15);
        
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

