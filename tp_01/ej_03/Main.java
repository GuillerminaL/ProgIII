package Prog_III_2023.tp_01.ej_03;

public class Main {

    public static void main(String[] args) {

        System.out.println(" ");
        System.out.println("Push...");
        Stack<String> stack = new Stack<String>();
        stack.push("Liliana");
        stack.push("Juan");
        stack.push("Horacio");
        stack.push("Gonzalo");
        System.out.println(stack.toString());

        System.out.println(" ");
        System.out.println("Get top of stack...");
        System.out.println("Top of stack is " + stack.top());
        System.out.println(stack.toString());

        System.out.println(" ");
        System.out.println("Delete top of stack...");
        System.out.println("Top of stack " + stack.pop() + " has been deleted");
        System.out.println(stack.toString());

        System.out.println(" ");
        System.out.println("Reverse stack...");
        stack.reverse();
        System.out.println(stack.toString());

    }
}
