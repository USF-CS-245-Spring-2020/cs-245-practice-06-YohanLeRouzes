public class ArrayList<T> implements List<T>
{
    T[] a; //a is a Template object
    int size; //size defined to be the size of a

    public ArrayList() {
        a = (T[]) new Object[10]; //a defined as a list of 10 Objects T
        size = 0;
    }

    public void add(T item) { //Add item to the end
        if(size == a.length) { //If the size is equal to the length of a
            doubleArray(); //Double the array
        }
        a[size++] = item; //The last object of the array takes the value of item
    }

    public void add(int pos, T item) { //Add item to specific position
        if(size == a.length) {//Double the array if the size is equal to the length of a
            doubleArray();
        }
        for(int i=size-1; i>pos; i--) { //Every element after the position specified is changing index by one
            a[i+1] = a[i];
        }
        a[pos] = item; //The element at position pos takes the value of item
        size++; //Increment the size
    }

    public T get(int pos) { //Get value at position pos
        if(pos >= size || pos < 0) { //If the specified position is out of bound, display error
            throw new IndexOutOfBoundsException();
        }
        return a[pos]; //Return the object at position pos
    }

    public T remove(int pos) { //Remove element at position pos
        if(pos >= size || pos < 0) { //If the specified position is out of bound, display error
            throw new IndexOutOfBoundsException();
        }
        T temp = a[pos]; //temp object T takes value of the element to remove
        for(int i=pos; i<size-1; i++) { //Every element after the position specified is changing index by one
            a[i] = a[i+1];
        }
        size--; //size of the array decrements by one
        return temp; //Return the removed value
    }

    public int size() { //Return the size of the list
        return size;
    }

    void doubleArray() {
        T[] newArray = (T[])new Object[a.length*2]; //Doubles the length of the array a
        for(int i = 0; i < size; i++) { //places all the elements of the array a into array newArray
            newArray[i] = a[i];
        }
        a = newArray; //places all the elements back into a
    }
}