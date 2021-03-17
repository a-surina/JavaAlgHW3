import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Реализуем массив
        String[] subjectsStaticArray = new String[] {"History", "Math", "Biology", "Chemistry"};
        System.out.println("StaticArray created: " + Arrays.toString(subjectsStaticArray));

        //Задание 3.1: из массива создаем простой список и коллекцию, замеряяем время
        long startTimeArrayList = System.nanoTime();
        ArrayList<String> subjectsArrayList = new ArrayList<>(Arrays.asList(subjectsStaticArray));
        double elapsedNanosArrayList = (double) (System.nanoTime() - startTimeArrayList)/1000000;
        System.out.println("3.1.1. ArrayList created from StaticArray: " + subjectsArrayList);
        System.out.println("\tTime elapsed on ArrayList creation: " + String.valueOf(elapsedNanosArrayList) + " milliseconds\n");

        long startTimeLinkedList = System.nanoTime();
        Collection<String> subjectsLinkedList = new LinkedList<>(Arrays.asList(subjectsStaticArray));
        double elapsedNanosLinkedList = (double) (System.nanoTime() - startTimeLinkedList)/1000000;
        System.out.println("3.1.1. LinkedList created from StaticArray: " + subjectsLinkedList);
        System.out.println("\tTime elapsed on LinkedList creation: " + String.valueOf(elapsedNanosLinkedList) + " milliseconds\n");

        //Задание 3.2: реализуем основные методы добавления, удаления и получения объекта или элемента из списка
        String english = "English";
        int index = 2;
        long startTimeArrayListAdd = System.nanoTime();
        subjectsArrayList.add(index, english);
        double elapsedNanosArrayListAdd = (double) (System.nanoTime() - startTimeArrayListAdd)/1000000;
        System.out.println("3.2.1. Element " + english + " added to ArrayList: " + subjectsArrayList);
        System.out.println("\tTime elapsed: " + String.valueOf(elapsedNanosArrayListAdd) + " milliseconds\n");

        String literature = "Literature";
        index = 1;
        long startTimeArrayListInsert = System.nanoTime();
        subjectsArrayList.set(index, literature);
        double elapsedNanosArrayListInsert = (double) (System.nanoTime() - startTimeArrayListInsert)/1000000;
        System.out.println("3.2.2. Element " + literature + " inserted into ArrayList: " + subjectsArrayList);
        System.out.println("\tTime elapsed: " + String.valueOf(elapsedNanosArrayListInsert) + " milliseconds\n");

        long startTimeArrayListDelete = System.nanoTime();
        subjectsArrayList.remove(literature);
        double elapsedNanosArrayListDelete = (double) (System.nanoTime() - startTimeArrayListDelete)/1000000;
        System.out.println("3.2.3. Element " + literature + " deleted from ArrayList: " + subjectsArrayList);
        System.out.println("\tTime elapsed: " + String.valueOf(elapsedNanosArrayListDelete) + " milliseconds\n");

        long startTimeArrayListGet = System.nanoTime();
        String elemFound = subjectsArrayList.get(index);
        double elapsedNanosArrayListGet = (double) (System.nanoTime() - startTimeArrayListGet)/1000000;
        System.out.println("3.2.4. Element with index " + index + " retrieved from ArrayList: " + elemFound);
        System.out.println("\tTime elapsed: " + String.valueOf(elapsedNanosArrayListGet) + " milliseconds\n");

        //Задание 3.3: реализуем односвязный список и его методы
        OneDirectionLinkedList<String> hobbiesArrayList = new OneDirectionLinkedList<>();
        System.out.println("3.3. OneDirectionLinkedList");
        hobbiesArrayList.print();

        System.out.println("OneDirectionLinkedList is empty: " + String.valueOf(hobbiesArrayList.empty()));

        hobbiesArrayList.add("Swimming");
        hobbiesArrayList.add("Reading");
        hobbiesArrayList.add("Travelling");
        hobbiesArrayList.add("Programming");
        hobbiesArrayList.add("Cooking");
        hobbiesArrayList.print();
        System.out.println("OneDirectionLinkedList is empty: " + String.valueOf(hobbiesArrayList.empty()));

        String programming = "Programming";
        hobbiesArrayList.rem(programming);
        hobbiesArrayList.print();
        String elemToFind = "Reading";
        System.out.println(elemToFind + " found in OneDirectionLinkedList: " + String.valueOf(hobbiesArrayList.inList(elemToFind)));
        System.out.println(programming + " found in OneDirectionLinkedList: " + String.valueOf(hobbiesArrayList.inList(programming)) + "\n");


        //Задание 3.4: двусторонний список, заполненный объектами из моего класса MyClass, и его методы
        LinkedList<MyClass> myClassLinkedList = new LinkedList<>();
        myClassLinkedList.add(new MyClass(10, 'S', 599.0, true, "Socks", new String[]{"red", "black", "blue"}));
        myClassLinkedList.add(new MyClass(0, 'L', 2199.90, false, "Hat", new String[]{"yellow"}));
        myClassLinkedList.add(new MyClass(6, 'S', 999.0, true, "Gloves", new String[]{"black"}));
        myClassLinkedList.add(new MyClass(1, 'M', 10_000.0, true, "Jacket", new String[]{"red", "black", "blue"}));
        myClassLinkedList.addFirst(new MyClass(3, 'S', 7499.0, true, "Dress", new String[]{"violet", "grey", "pink"}));
        myClassLinkedList.addLast(new MyClass(40, 'M', 2999.0, true, "Jeans", new String[]{"light blue", "blue"}));

        System.out.println("MyClassLinkedList: ");

        for (MyClass item : myClassLinkedList) {
            item.printer();
            System.out.println("");
        }
        System.out.println("MyClassLinkedList has size of " + String.valueOf(myClassLinkedList.size()));

        myClassLinkedList.pollFirst();
        myClassLinkedList.pollLast();
        myClassLinkedList.remove(2);

        System.out.println("MyClassLinkedList has size of " + String.valueOf(myClassLinkedList.size()));
        System.out.println("");

        //Задание 3.5: Базовые операции итератора:

        ListIterator<MyClass> listIter = myClassLinkedList.listIterator();

        System.out.println("MyClassLinkedList objects from left to right: ");
        while(listIter.hasNext()){
            System.out.println(String.valueOf(listIter.next().id));
        }

        System.out.println("MyClassLinkedList objects from right to left: ");
        long startTimeIterLeft = System.nanoTime();
        listIter.set(myClassLinkedList.getLast());
        while(listIter.hasPrevious()){
            System.out.println(String.valueOf(listIter.previous().id));
        }
        double elapsedNanosIterLeft = (double) (System.nanoTime() - startTimeIterLeft)/1000000;
        System.out.println("\tTime elapsed: " + String.valueOf(elapsedNanosIterLeft) + " milliseconds\n");
    }
    }
