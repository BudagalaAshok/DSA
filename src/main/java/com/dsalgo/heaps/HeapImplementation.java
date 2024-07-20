package com.dsalgo.heaps;

import java.io.*;
import java.util.*;

public class HeapImplementation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc=new Scanner(System.in);
        int noOfOperations=sc.nextInt();
        MinHeap minHeap=new MinHeap();
        for(int i=0;i<noOfOperations;i++){
            String operation=sc.next();
            switch(operation){
                case "getMin":
                    minHeap.getMin();
                    break;
                case "insert":
                    int element=sc.nextInt();
                    minHeap.insert(element);
                    break;
                case "delMin":
                    minHeap.deleteMin();
                    break;
            }

        }
    }
}


class MinHeap{

    private List<Integer> heap;
    private int size;

    public MinHeap(){
        heap=new ArrayList<>();
    }

    public void insert(int value){
        heap.add(value);
        heapifyUp(heap.size()-1);
    }

    private void heapifyUp(int index){
        int p=parent(index);
        while(index>1 && heap.get(index)<heap.get(parent(index))){
            swap(index,parent(index));
            index=parent(index);
        }
    }

    private void swap(int i, int j){
        int temp=heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    public int size(){
        return heap.size();
    }
    public int parent(int index){
        return (index-1)/2;
    }

    public int left(int index){
        return index *2 +1;
    }

    public int right(int index){
        return index *2 +2;
    }

    public void getMin(){
        if(heap.size()<1){
            System.out.println("Empty");
            return;
        }
        System.out.println(heap.get(0));
    }

    public void deleteMin(){
        if(heap.size()<1){
            System.out.println("Empty");
            return;
        }
        heap.set(0,heap.get(size()-1));
        heap.remove(size()-1);
        heapifyDown(0);
    }

    private void heapifyDown(int index){
        int smallest=index;
        int left=left(index);
        int right=right(index);
        if(left<size() && heap.get(left) < heap.get(smallest)){
            smallest=left;
        }
        if(right<size() && heap.get(right) < heap.get(smallest)){
            smallest=right;
        }
        if(smallest!=index){
            swap(index,smallest);
            heapifyDown(smallest);
        }
    }



}
