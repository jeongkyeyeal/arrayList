import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class arryList<String> implements List<String> {
    private String[] array;
    private int size=0;

    public arryList(){
        this.array = (String[])new Object[1];
        this.size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0 ? true : false;
    }

    @Override
    public boolean add(String s) {
        if(size >= array.length){
            String[] bigger = (String[])new Object[array.length*2];
            System.arraycopy(array,0,bigger,0,array.length);
            array=bigger;
        }
        array[size]=s;
        size++;
        return true;
    }

    @Override
    public void add(int index, String element) {
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException();
        }
        add(element);

        for(int i=size-1;i>index;i--){
            array[i]=array[i-1];
        }
        array[index] = element;
    }




    @Override
    public boolean addAll(Collection<? extends String> c) {
        boolean flag = true;
        for(String s: c){
            flag &= add(s);
        }
        return flag;
    }


    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        int i=0;
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(String s: c){
            add(index+i,s);
            i++;
        }
        return true;
    }


    @Override
    public void clear() {
        size=0;
    }

    @Override
    public String get(int index) {
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public String set(int index, String element) {
        add(index,element);
        return array[index];
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c){
            if(!contains(o))
                return false;
        }

        return true;
    }


    @Override
    public int indexOf(Object o) {
        for(int i=0;i<size;i++){
            if(equals(o,array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if( equals(o,array[size-1]) ){
            return size-1;
        }
        return -1;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }


    @Override
    public String remove(int index) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        String s = array[index];
        for(int i=index+1;i<size;i++){
            array[i-1] = array[i];
        }
        size--;
        array[size]=null;
        return s;
    }

    @Override
    public boolean remove(Object o) {
        for(int i=0;i<size;i++){
            if(equals(o,array[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(containsAll(c)){
            for(Object s: c){
                remove(s);
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    private boolean equals(Object arg1,Object arg2){
        if(arg1==null){
            return arg2 == null;
        }
        else {
            return arg1.equals(arg2);
        }
    }



}
