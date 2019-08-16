import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class arrayListTest {

    @Test
    public void testArrayList(){
        arryList<String> myList = new arryList<>();
        assertNotNull(myList);
    }

    @Test
    public void testArrayListAdd(){
        arryList<String> myList1 = new arryList<>();
        myList1.add("String1");
        myList1.add("String2");
        assertEquals(myList1.size(),2);
    }

    @Test
    public void testArrayListAddIndex(){
        arryList<String> myList1 = new arryList<>();
        myList1.add("String3");
        myList1.add("String4");
        myList1.add(1,"String5");
        assertEquals(myList1.get(1),"String5");
    }
    @Test
    public void testArrayListAddAll(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        arryList<String> myList1 = new arryList<>();
        assertEquals(myList1.addAll(stringList),true);
        assertEquals(myList1.get(1),"World");
    }
    @Test
    public void testArrayListIndexAddAll(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        arryList<String> myList1 = new arryList<>();
        myList1.add("String1");
        myList1.add("String2");
        myList1.addAll(1,stringList);
        assertEquals(myList1.get(1),"Hello");
    }


}
