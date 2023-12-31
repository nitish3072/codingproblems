package helpers;

public class MaxHeap {


    private int[] elements;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        elements = new int[this.maxsize + 1];
        elements[0] = Integer.MAX_VALUE;
    }

    public void addElement(int elem) {
        elements[size] = elem;
        size++;
        heapify(size-1);
    }

    public int removeElement(int index) {
        int temp = elements[index];
        elements[index] = Integer.MIN_VALUE;
        elements[index] = elements[size-1];
        elements[--size] = 0;
        heapify(index);
        return temp;
    }

    public int topElement() {
        return elements[0];
    }

    private void heapify(int index) {
        int current = elements[index];
        int parentIndex = (index -1) / 2;
        int parentNode = index==0?Integer.MAX_VALUE:elements[parentIndex];
        int leftIndex = (2*index) + 1;
        int leftNode = (leftIndex<size)?elements[leftIndex]:Integer.MIN_VALUE;
        int rightIndex = (2*index) + 2;
        int rightNode = (rightIndex<size)?elements[rightIndex]:Integer.MIN_VALUE;


        /*
          1) if current Node is less than parent node then swap
          2) if current node is greater than leftnode and less than rightnode then swap with leftnode
          3) if current node is greater than rightnode and less than leftnode then swap with rightnode
          4) if current node is greater than rightnode and greater than leftnode then swap with smaller of rightnode and leftnode

          after that send to heapify the heap again with the swapped element under observation and going through above process again
         */
        if(current>parentNode) {
            swap(index, parentIndex);
            heapify(parentIndex);
        } else if(current<leftNode && current>rightNode) {
            swap(index, leftIndex);
            heapify(leftIndex);
        } else if(current>leftNode && current<rightNode) {
            swap(index, rightIndex);
            heapify(rightIndex);
        } else if(current<leftNode && current<rightNode) {
            if(leftNode>rightNode) {
                swap(index, leftIndex);
                heapify(leftIndex);
            } else {
                swap(index, rightIndex);
                heapify(rightIndex);
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for(int elem: arr) {
            maxHeap.addElement(elem);
        }
        System.out.println("Here");
    }
}
