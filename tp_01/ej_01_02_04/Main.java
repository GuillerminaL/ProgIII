package Prog_III_2023.tp_01.ej_01_02_04;

public class Main {

    public static void main(String[] args) {

        System.out.println(" ");
        LinkedList<String> namesList = new LinkedList<String>();
        System.out.println(namesList.toString());

        System.out.println(" ");
        System.out.println("Insert front");
        namesList.insertFront("Juan");
        namesList.insertFront("Horacio");
        namesList.insertFront("Gonzalo");
        System.out.println(namesList.toString());

        System.out.println(" ");
        System.out.println("Insert last");
        namesList.insertLast("Liliana");
        System.out.println(namesList.toString());

        System.out.println(" ");
        System.out.println("Insert by index:");
        int index = 2;
        namesList.insert(index, "Middle");
        System.out.println(namesList.toString());

        System.out.println(" ");
        System.out.println("Getting info by index:");
        int ind = 0;
        String info = namesList.get(ind);
        System.out.println("The info in index '" + ind + "' is = " + info);

        System.out.println(" ");
        System.out.println("Changing info in index:");
        int inx = 1;
        String newInfo = "Changed";
        String oldInfo = namesList.get(inx);
        if(oldInfo == null) {
            System.out.println("Index dos not exist");
        } else {
            namesList.setInfo(inx, newInfo);
            System.out.println("Info in index '" + inx + "' has been changed from '" + oldInfo + "' to " + newInfo);
            System.out.println(namesList.toString());
        }

        System.out.println(" ");
        System.out.println("Inserting in front to delete...");
        namesList.insertFront("to delete");
        System.out.println(namesList.toString());
        System.out.println("Deleted = " + namesList.extractFront());
        System.out.println(namesList.toString());

        System.out.println(" ");
        System.out.println("Delete by index...");
        System.out.println("Deleted = " + namesList.delete(100));
        System.out.println(namesList.toString());

        //Ejercicio 04
        System.out.println(" ");
        System.out.println("Get index of...");
        String key = "Liliana";
        int i = namesList.indexOf(key);
        if(i == -1) {
            System.out.println("Key '" + key + "' is not in the list");
        } else {
            System.out.println("Key '" + key + "' is in index '" + i + "' ");
        }

        System.out.println(" ");
        System.out.println("Get index of and delete...");
        String keyToDelete = "Midd";
        int indexToDelete = namesList.indexOf(keyToDelete);
        if(indexToDelete == -1) {
            System.out.println("Key '" + keyToDelete + "' is not in the list");
        } else {
            System.out.println("Deleting index " + indexToDelete);
            String deleted = namesList.delete(indexToDelete);
            System.out.println("Key '" + deleted + "'| index '" + indexToDelete + "' has been deleted");
        }
        System.out.println(namesList.toString());


    }
}
