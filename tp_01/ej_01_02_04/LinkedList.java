package Prog_III_2023.tp_01.ej_01_02_04;

public class LinkedList<T> {

    private Node<T> first;
    private int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    public Node<T> getFirst() {
        return this.first;
    }

    public void insertFront(T info) {
        if (this.first == null) {
            this.first = new Node<T>(info, null);
        } else {
            this.first = new Node<T>(info, this.first);
        }
        this.size += 1;
    }
    /* CC List = O(1) | Array = O(n)
    La inserción en el frente de la lista es constante, a diferencia de la inserción en array que requiere
     corrimiento de tantos elementos como contenga, sumado a la potencial complejidad derivada de la capacidad
     limitada de la estructura, lo que supone la transferencia de todos los elementos a un nuevo array si se
     acaba el espacio definido al crearlo-.
     */

    public T extractFront() {
        if(this.first != null) {
            Node<T> toExtract = this.first;
            this.first = toExtract.getNext();
            this.size -= 1;
            return toExtract.getInfo();
        }
        return null;
    }
    /*
    CC List = O(1) | Array = O(n)
    En el caso de la lista, la inserción al frente es la mejor opción, ya que no requiere recorrer la estructura al
    almacenar siempre el primer elemento.
    La inserción al frente en un array implicará siempre el corrimiento de tantos elementos como el array contenga,
    es el peor caso, junto a la inserción al frente en un array sin espacio.
     */


    public boolean isEmpty() {
        return this.first == null;
    }
    /*
    CC O(1)
     */

    public int size() {
        return this.size;
    }
    /*
    CC List = O(n) --> O(1) | Array = O(1)
    Dado que en la lista vinculada los espacios de memoria asignados no son contiguos,
    contar los elementos que la integran supone recorrer toda la estructura.
    Un buen criterio de diseño destinado a reducir esta complejidad puede ser el almacenamiento de este valor en una variable,
    que deberá mantenerse actualizada en las operaciones de inserción y borrado.
     */

    public T get(int index) {
        Node<T> tmp = this.getNode(index);
        if(null != tmp) {
            return tmp.getInfo();
        }
        return null;
    }
    /*
    CC List = O(n) | Array = O(1)
    Mientras el array permite acceder a los elementos por su índice en un solo acceso a memoria,
    la lista vinculada, al ocupar espacios de memoria NO contiguos, requiere recorrer toda la estructura
    hasta llegar al índice indicado que, en el peor de los casos, será el último de ellos.
     */

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("LinkedList{");
        if(this.first != null) {
            int i = 0;
            Node<T> current = this.getFirst();
            while(i < size && current != null) {
                tmp.append("index=").append(i).append(" ").append(current.getInfo()).append(", ");
                current = current.getNext();
                i++;
            }
        }
        tmp.append("size=").append(size).append('}');
        return tmp.toString();
    }



    //-------------------------------------------- Otros métodos... ----------------------------------------------------
    //---------------- (insertLast, insert by index, getNode, setInfo, delete by index) --------------------------------

    public void insertLast(T info) {
        if(this.first == null) {
            this.insertFront(info);
        } else {
            int i = 0;
            Node<T> current = this.getFirst();
            Node<T> next = current.getNext();
            while(next != null && i < size) {
                current = next;
                next = current.getNext();
                i++;
            }
            Node<T> newNode = new Node<T>(info, null);
            current.setNext(newNode);
            this.size += 1;
        }
    }
    /* CC List = O(n) --> O(1) | Array = O(1)
     Excepto que el array no tenga espacio, la inserción al final no requiere corrimientos, por lo que es constante.
     En el caso de la lista, deberá recorrerse toda la estructura para hallar el último elemento al cual
     vincular la nueva inserción, a menos que se almacene en una variable el último elemento, del mismo modo que
     se almacena el primero. Este diseño haría que la complejidad se reduzca a un valor constante.
     */

    public void insert(int index, T info) {
        if(this.first == null || index == 0 || index < 0) {
            this.insertFront(info);
        }
        if(index == this.size) {
            this.insertLast(info);
        }
        int i = 0;
        Node<T> previous = null;
        Node<T> current = this.getFirst();
        Node<T> next = current.getNext();
        while(index != i) {
            previous = current;
            current = next;
            next = current.getNext();
            i++;
        }
        Node<T> newNode = new Node<T>(info, current);
        if(null != previous) previous.setNext(newNode);
        this.size += 1;
    }
    /* CC List = O(n) Array = O(n)
    La inserción por índice en lista requiere recorrer la estructura hasta el índice dado, en el peor caso será el anteúltimo.
    En el caso del array, implicará tantos corrimientos como elementos contenga a la derecha del índice dado. El peor caso será
    la inserción en segundo lugar de un array que con la nueva inserción quede completo, o la inserción en un array que no
    contenga espacio para la nueva inserción.
     */

    private Node<T> getNode(int index) {
        if(index >= 0 && index < this.size()) {
            int i = 0;
            Node<T> current = this.getFirst();
            Node<T> next = current.getNext();
            while(index != i && next != null){
                current = next;
                next = current.getNext();
                i++;
            }
            if(index == i) {
                return current;
            }
        }
        return null;
    }

    public T setInfo(int index, T info) {
        Node<T> tmp = this.getNode(index);
        if(tmp == null) return null;
        T oldInfo = tmp.getInfo();
        tmp.setInfo(info);
        return oldInfo;
    }
    /*
    CC List = O(n) | Array = O(1)
    Modificar la información de un nodo en una lista requiere recorrerla, mientras que en el array implica sólo
    un acceso a memoria.
     */

    public T delete(int index) {
        if(index >= 0 && index < this.size()) {
            int i = 0;
            Node<T> previous = null;
            Node<T> current = this.getFirst();
            Node<T> next = current.getNext();
            while(index != i && next != null){
                previous = current;
                current = next;
                next = current.getNext();
                i++;
            }
            if(index == i) {
                T result = current.getInfo();
                if(previous != null && next != null) {
                    previous.setNext(next);
                }
                if (previous == null) extractFront();
                if (next == null) {
                    previous.setNext(null);
                }
                this.size -= 1;
                return result;
            }
        }
        return null;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Ejercicio 04
    public int indexOf(T info) {
        int i = 0;
        Node<T> current = this.first;
        while(i < this.size && current != null) {
            if(current.getInfo() == info) {
                return i;
            } else {
                current = current.getNext();
                i++;
            }
        }
        return -1;
    }
}
