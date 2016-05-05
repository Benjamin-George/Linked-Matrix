/**
 * Created by Ben on 11/20/2015.
 */
public class MatrixNode<T> {
    private T data; //T just a placeholder for whatever data type of the node
    private MatrixNode<T> right;
    private MatrixNode<T> bottom;

    public MatrixNode(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setRight(MatrixNode<T> right) {
        this.right = right;
    }

    public MatrixNode<T> getRight(){
        return this.right;
    }

    public void setBottom(MatrixNode<T> bottom) {
        this.bottom = bottom;
    }

    public MatrixNode<T> getBottom(){
        return this.bottom;
    }

    public String toString() {
        return data.toString();
    }
}
