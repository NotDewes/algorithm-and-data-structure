package JavaChains;
import java.util.EmptyStackException;

public class Pilha {

        private linkedList pilha;

        public Pilha() {
            pilha = new linkedList();
        }

        public void push(Integer e) {
            pilha.add_at(e,0);
        }

        public void pop() {
            if (pilha.isEmpty())
                throw new EmptyStackException();
            pilha.remove_at(0);
        }

        public Integer top() {
            if (pilha.isEmpty())
                throw new EmptyStackException();
            return pilha.get(0);
        }

        public int size() {
            return pilha.size();
        }

        public boolean isEmpty() {
            return pilha.isEmpty();
        }

        public void clear() {
            pilha.clear();
        }
    }

