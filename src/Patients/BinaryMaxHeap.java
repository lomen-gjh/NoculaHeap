package Patients;

import java.util.Arrays;

public class BinaryMaxHeap {
    Patient[] data;
    int count;

    public BinaryMaxHeap(){
        data=new Patient[10];
        count=0;
    }

    void checkCapacity(){
        if (count==data.length){
            data= Arrays.copyOf(data, data.length*2);
        }
    }

    int getParent(int index){
        if (index==0 || index>=count)
            return -1;
        return (index-1)/2;
    }

    int getLeftChild(int index){
        if (index*2+1<count){
            return index*2+1;
        }
            return -1;
    }

    int getRightChild(int index){
        if (index*2+2<count){
            return index*2+2;
        }
        return -1;
    }

    void swap(int i1, int i2){
        Patient p=data[i1];
        data[i1]=data[i2];
        data[i2]=p;
    }

    void HeapifyUp(int index){
        try {

            while(index!=0 && data[index].priority>data[getParent(index)].priority){
                swap(index, getParent(index));
                index=getParent(index);

            }
        }
        catch (IndexOutOfBoundsException err){
            System.out.println(index);
            System.out.println("Si mimo");
        }
    }

    void insert(Patient p){
        data[count++]=p;
        checkCapacity();
        HeapifyUp(count-1);
    }

    void HeapifyDown(int index){
        while(getLeftChild(index)!=-1 && data[getLeftChild(index)].priority>data[index].priority){
            if (getRightChild(index)!=-1 && data[getRightChild(index)].priority>data[getLeftChild(index)].priority){
                swap(index, getRightChild(index));
                index=getRightChild(index);
            }
            else{
                swap(index, getLeftChild(index));
                index=getLeftChild(index);
            }
        }
    }
    void poll(){
        if (count==0)
        {
            System.out.println("Som prazdna haldicka");
            return;
        }
        swap(0, count-1);
        data[--count]=null;
        HeapifyDown(0);
    }

    void print(){
        for (int i=0; i<count; i++){
            data[i].details();
        }
    }

    public static void main(String[] args){
        BinaryMaxHeap priority_queue=new BinaryMaxHeap();
        priority_queue.insert(new Patient(50,22,"Ferko Mudry","Novohradska 3"));
        priority_queue.insert(new Patient(55,19,"Anna Sikovna","Hlavna 32"));
        priority_queue.insert(new Patient(22,23,"Ferko Mudry","Devinska 9"));
        priority_queue.insert(new Patient(80,99,"Ferko Nadherny","Gagarinova 13"));
        priority_queue.insert(new Patient(25,99,"Ferko Uzasny","Gagarinova 13"));
        priority_queue.insert(new Patient(68,99,"Ferko Priemerny","Gagarinova 13"));
        priority_queue.print();
        System.out.println("---------------");
        for (int i=0; i<10; i++){
            priority_queue.poll();
            priority_queue.print();
            System.out.println("---------------------");
        }

    }
}
