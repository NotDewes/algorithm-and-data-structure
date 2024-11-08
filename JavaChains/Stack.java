import java.util.EmptyStackException;

public class Stack {

        private linkedList Stack;

        public Stack() {
            Stack = new linkedList();
        }

        public void push(Integer e) {
            Stack.insert(e,0);
        }

        public void pop() {
            if (Stack.isEmpty())
                throw new EmptyStackException();
            Stack.remove_at(0);
        }

        public Integer top() {
            if (Stack.isEmpty())
                throw new EmptyStackException();
            return Stack.get(0);
        }

        public int size() {
            return Stack.size();
        }

        public boolean isEmpty() {
            return Stack.isEmpty();
        }

        public void clear() {
            Stack.clear();
        }
    }

