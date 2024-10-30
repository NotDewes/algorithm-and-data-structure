public class linkedList {

    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }

        @SuppressWarnings("unused")
        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }        
    }

    private Node head;
    private Node tail;
    private int count;

    //construtor
    public linkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }


    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }    

    public void add(Integer element)  {
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    //Retorna o elemento de uma determinada posicao da lista
    public Integer get(int index) { //O(n)
        if ((index < 0) || (index >= count)) 
            throw new IndexOutOfBoundsException();

        if (index == count-1)
            return tail.element;

        Node aux = head;
        for (int c = 0;c < index; c++)
            aux = aux.next;
        
        return aux.element;
    }

    //Retorna true se a lista contem o elemento especificado.
    public boolean contains(Integer element) { //O(n)
        Node aux = head;
        while(aux != null) {
            if (aux.element.equals(element))
                return true;
            aux = aux.next;
        }
        return false;
    }

    //obter uma representação textual dos elementos da lista
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }    

    //Remove a primeira ocorrencia do elemento na lista, se estiver presente
    public boolean remove(Integer element) {
        // Se a lista esta vazia
        if (count == 0)
            return false;

        //remocao do primeiro 
        if (element.equals(head.element)) {
            if (count == 1) { 
                tail = null;
            }
            head = head.next;
            count--;
            return true;
        }

        Node ant = head; // referencia aponta para o anterior
        Node aux = head.next; // referencia aponta para o elemento que está sendo verificado

        for (int i=1; i<count; i++) {
            if (aux.element.equals(element)) { 
                if (aux == tail) { //remocao do ultimo
                    tail = ant;
                    tail.next = null;
                }
                else { //remocao do meio
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
            aux = aux.next;
            ant = ant.next;
        }   
        // Se nao removeu
        return false;
    }

    //Insere um elemento em uma determinada posicao da lista
    public void add_at(Integer element, int pos){
        Node n = new Node(element);

        int i = 0;
        Node atual = head;

        while (atual.next != null && i < pos - 1){
            atual = atual.next;
            i++;
        }

        if (atual.next == null){
            tail = n;
        }

        n.next = atual.next;
        atual.next = n;
    }

    //Substitui o elemento armanzenado em uma determinada posicao da lista
    public void set(Integer element, int pos){
        Node n = new Node(element);

        if (pos < 0 || pos >= count)
            throw new IndexOutOfBoundsException();

        if (pos == 0)
            head = n;

        if (pos == count - 1)
            tail = n;

        Node atual = head;
        int i = 0;
        while (i != pos){
            atual = atual.next;
            i++;
        }
        atual.element = n.element;

        
    }

    public void remove_at(int pos){
        if (pos < 0 || pos >= count)
            throw new IndexOutOfBoundsException();

        if (pos == 0)
            head = head.next;

        Node atual = head;
        for (int i = 0; i < pos - 1; i++){
            atual = atual.next;
        }

        atual.next = atual.next.next;
    }
    
    public int indexOf(Integer element){
        Node atual = head;
        int i = 0;
        while (atual != null){
            if (atual.element == element)
                return i;
            atual = atual.next;
            i++;
        }
        return -1;
    }

    
    public static void main(String[] args){
        linkedList lista = new linkedList();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        System.out.println(lista.indexOf(1));
        lista.add_at(999, 0);
        System.out.print(lista.toString());

        //arrumar o add at
    }
}

