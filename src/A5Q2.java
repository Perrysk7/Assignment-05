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
public class A5Q2 {
    // use a resizeable array
    // initial array can have a size of 10
    // move numbers down when new one is added
    // double the array size when the array becomes full
    // copy everything from the array and move it to the larger one
    // set array pointer to the new array
    // add the item back in
    
    // array to store all the numbers
    private int[] rArray;
    // stores the number of items in the array
    private int numItems;
    
    public A5Q2(){
        // give the array 10 spots to start
        rArray = new int[10];
        // set number of items in array to zero
        numItems = 0;
    }
    
    public void add(int index, int num){
        // if the array fills up and more numbers are wanted to be put in
        if(numItems+1 >= rArray.length){
            // create a temporary array double the original arrays size
            int[] temp = new int[rArray.length*2];
            // copy the original array into the temporary array
            for (int i = 0; i < rArray.length; i++) {
                temp[i] = rArray[i];
            }
            // set the original array to the temporary array
            rArray = temp;
        }
        // go through the array and shift everything down one
        // from the spot where the new number is being put
        for (int i = rArray.length-2; i > index; i--) {
            rArray[i] = rArray[i-1];
        }
        // put the new number in its desired position
        rArray[index] = num;
        // add one to the number of items in the array
        numItems++;
    }
    
    public void remove(int index){
        // find if the position exists
        if(index < numItems){
            // move all numbers down one spot
            for (int i = index; i <= numItems; i++) {
                rArray[i] = rArray[i+1];
            }
            // remove item
            numItems--;
        }
    }

     public int size(){
        return numItems; 
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public int get(int index){
        return rArray[index];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test the method 
        A5Q2 list = new A5Q2();
        
        list.add(0, 5);
        list.add(1, 6);
        list.add(2, 2);
        list.add(3, 3);
        list.add(4, 1);
        list.add(5, 4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // print 
        System.out.println("--------------");
        
        list.remove(1);
        list.remove(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }  
}
