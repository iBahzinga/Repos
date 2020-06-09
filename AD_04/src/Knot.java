public class Knot <T extends Comparable<T>> {

    private T data;
    private Knot childLeft;
    private Knot childRight;
    private Knot parent;

    public Knot (T data, Knot parent) {
        this.data = data;
        this.parent = parent;
    }
    public T getData () {
        return data;
    }

    public Knot getChildLeft () {
        return childLeft;
    }

    public Knot getChildRight () {
        return childRight;
    }

    public Knot getParent () {
        return parent;
    }

    public void setChildLeft(Knot childLeft) {
        this.childLeft = childLeft;
    }

    public void setChildRight(Knot childRight) {
        this.childRight = childRight;
    }

    public void setParent(Knot parent) {
        this.parent = parent;
    }
}
