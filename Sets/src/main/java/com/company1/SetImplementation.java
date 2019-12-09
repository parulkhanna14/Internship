package com.company1;

import java.util.*;

public class SetImplementation {
    public static void main(String[] args) {

        //Sets are implemented using hashset,treeset,linkedhashset,etc!

        Set<String> hashset=new HashSet<String>();
        hashset.add("i");
        hashset.add("am");
        hashset.add("awesome");
        hashset.add("am");
        System.out.println(hashset);
        System.out.println("SORTED ORDER:: ");
        Set<String > treeset=new TreeSet<String>(hashset);
        System.out.println(treeset);
        System.out.println(treeset.contains("i"));
        System.out.println("Elements iteration using iterator!");
        Iterator iterator=hashset.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
       /* for(Object object : hashset)                      does the same job as above!
        {
            System.out.println(object);
        }*/

        //Union,intersection,etc
        Set<Integer> a=new HashSet<Integer>();
        a.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));
        Set<Integer> b=new HashSet<Integer>();
        System.out.println(a);
        b.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5}));
        System.out.println(b);
        Set<Integer> union=new HashSet<Integer>(a);
        union.addAll(b);
        System.out.println("Union --> "+union);
        Set<Integer> intersection=new HashSet<Integer>(a);
        intersection.retainAll(b);                              //retains only the values which are present in both the sets!
        System.out.println("Intersection --> "+intersection);
        Set<Integer> difference=new HashSet<Integer>(a);
        difference.removeAll(b);                                //removes all elements which are not in b but are there in a!
        System.out.println("Difference --> "+difference);



    }
}
