import java.util.NoSuchElementException;

/**
 * Created by Ben on 11/20/2015.
 */
public class MyLinkedMatrix implements LinkedMatrix {
    private MatrixNode<Integer> first;
    private int numRows, numCols;

    public boolean init(int rows, int cols) {
        if (rows < 1 || cols < 1) { //if either input was bad, do nothing
            return false;
        } else {                    //otherwise, build the matrix
            numRows = rows;
            numCols = cols;

            first = new MatrixNode<>(0);    //initialize first node, coordinates (1, 1)

            //set counters to be used in building the matrix and setting links
            MatrixNode<Integer> current = first;
            MatrixNode<Integer> top = first;

            //build first row, one node at a time
            if (cols > 1) {
                for (int j = 2; j <= cols; j++) {
                    current.setRight(new MatrixNode<>(j - 1));
                    current = current.getRight();
                }

                current = first;
            }

            //build remaining rows
            if (rows > 1) {
                for (int i = 2; i <= rows; i++) {
                    //set current and top to point to the left most node in the most recently created row
                    while (current.getBottom() != null) {
                        current = current.getBottom();
                        top = current;
                    }

                    //create first node in new row, set current to point to it
                    current.setBottom(new MatrixNode<>(10 * (i - 1)));
                    current = current.getBottom();

                    //create remaining nodes in the row
                    if (cols > 1) {
                        for (int j = 2; j <= cols; j++) {
                            current.setRight(new MatrixNode<>(10 * (i - 1) + j - 1));
                            current = current.getRight();

                            //set link between current and the node 'above' it
                            if (top.getRight() != null) {
                                top = top.getRight();
                                top.setBottom(current);
                            }
                        }
                    }

                    //reset counters for next row
                    current = first;
                    top = first;
                }
            }

            return true;
        }
    }

    public boolean setValue(int value, int row, int col) {
        if (row > numRows || row < 1 || col > numCols || col < 1) { //if any inputs were bad, do nothing
            return false;
        } else {
            MatrixNode<Integer> current = first;

            //move current to desired row
            for (int i = 1; i < row; i++) {
                current = current.getBottom();
            }

            //move current to desired column
            for (int j = 1; j < col; j++) {
                current = current.getRight();
            }

            //return data at that row and column
            current.setData(value);

            return true;
        }
    }

    public void fill(int value) {
        MatrixNode<Integer> currentFirst = first;

        first.setData(value);

        //iterate through all rows
        for (int i = 1; i <= numRows; i++) {
            MatrixNode<Integer> current = currentFirst;

            //iterate through all nodes in the row
            for (int j = 1; j <= numCols; j++) {
                current.setData(value);     //set the value in the current node

                //move current to the right if possible
                if (current.getRight() != null) {
                    current = current.getRight();
                }
            }

            //move current down if possible
            if (currentFirst.getBottom() != null) {
                currentFirst = currentFirst.getBottom();
            }
        }
    }

    public int sumRow(int row) throws NoSuchElementException {
        if (row > numRows || row < 1) { //if the input was bad, throw an exception
            throw new NoSuchElementException();
        } else {
            int sum = 0;    //start a count
            MatrixNode<Integer> current = first;

            //move to desired row
            for (int i = 1; i < row; i++) {
                current = current.getBottom();
            }

            //sum all values in that row
            for (int j = 1; j <= numCols; j++) {
                sum += current.getData();
                current = current.getRight();
            }

            return sum;
        }
    }

    public int sumCol(int col) throws NoSuchElementException {
        if (col > numCols || col < 1) { //if input was bad, throw an exception
            throw new NoSuchElementException();
        } else {
            int sum = 0;    //start a count
            MatrixNode<Integer> current = first;

            //move to desired column
            for (int j = 1; j < col; j++) {
                current = current.getRight();
            }

            //sum all values in that column
            for (int i = 1; i <= numRows; i++) {
                sum += current.getData();
                current = current.getBottom();
            }

            return sum;
        }
    }

    public int getValue(int row, int col) throws NoSuchElementException {
        if (row > numRows || row < 1 || col > numCols || col < 1) { //if either input was bad, throw an exception
            throw new NoSuchElementException();
        } else {
            MatrixNode<Integer> current = first;

            //move to desired row
            for (int i = 1; i < row; i++) {
                current = current.getBottom();
            }

            //move to desired column
            for (int j = 1; j < col; j++) {
                current = current.getRight();
            }

            //return value at that row and column
            return current.getData();
        }
    }
}
