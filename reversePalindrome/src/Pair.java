 public class Pair<V> {
    public V h;
    public V t;

    public Pair(V h, V t) {
        this.h = h;
        this.t = t;
    }

    public Pair() {
        this.h = null;
        this.t = null;
    }

    public void add(V h, V t) {
        this.h = h;
        this.t = t;
    }

    public String print() {
        String output;
        if (this.h != null && this.t != null) {
            output = this.h.toString() + " " + this.t.toString();
        } else if (this.h == null && this.t != null) {
            output = "null " + this.t.toString();
        } else if (this.h != null && this.t == null) {
            output = this.h.toString() + " null";
        } else {
            output = "null null";
        }
        return output;
    }
}
