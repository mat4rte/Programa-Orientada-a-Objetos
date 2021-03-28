import java.util.ArrayList;

/**
 * Stack
 */
public class Stack {

    private ArrayList<String> valores;

    public Stack() {
        valores = new ArrayList<String>();
    }

    public Stack(int n) {
        valores = new ArrayList<String>(n);
    }

    public Stack(Stack s) {
        this.valores = new ArrayList<String>();
        //this.valores = new ArrayList<String>(s.valores); //outra forma
        for (String str : s.valores) {
            this.valores.add(str);
            //this.valores.add(str.clone()); <-- para objetos que nao String , segundo a estrategia //Composiçaõ
        }
    }

    // getters/setters

    public ArrayList<String> getValores() {
        ArrayList<String> ret = new ArrayList<String>();
        for (String str : this.valores) {
            ret.add(str);
        }
        return ret;
    }

    public void setValores(ArrayList<String> newValores) {
        this.valores = new ArrayList<String>();

        for (String str : newValores) {
            this.valores.add(str);
        }
    }
        // clone,equals,toString

        public Stack clone () {
            return new Stack(this);
        }

        public boolean equals (Object o){
            if (o == this)
                return true;
            if ((o == null) || this.getClass() != o.getClass())
                return false;

            Stack s = (Stack) o;

            return this.valores.equals(s.getValores());
        }

        public String toString () {
            return "Stack: " + this.valores.toString();
        }

        public int length () {
            return this.valores.size();
        }

        public boolean empty () {
            return this.valores.isEmpty();
        }

        public String top () {
            return this.valores.get(this.valores.size() - 1);
        }

        public void push (String s){
            this.valores.add(s);
        }

        public void pop () {
            if (!empty()) {
                this.valores.remove(this.valores.size() - 1);
            }
        }

        public String popR () {
            int indice = this.valores.size() - 1;
            String r = this.valores.get(indice);
            this.valores.remove(indice);
            return r;
        }
}