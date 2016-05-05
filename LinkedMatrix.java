import java.util.NoSuchElementException;

/**
 * Create a Two-Dimensional Linked list to represent a matrix of values.
 * The nodes in this linked list must hold an integer value for themselves,
 * as well as two potential reference pointers. One pointer which points to
 * the node below the current node (or to null), and one pointer which points to
 * the node to the right of the current node (or to null).
 *
 * Valid row and column values start at 0,0. For example, a 5x5 matrix should
 * have nodes at locations 0,0 (the first node) and 5,5 (the last node).
 *
 * The value of each node when the matrix is initialized is the combination of its
 * row and column positions. For example, the node at 0,0 is 0 (row 0 + column 0).
 * The node at 1,0 is 10 (row 1 + column 0). The node at 1,2 is 12 (row 1 + column 2).
 *
 * A sample 5x5 matrix is shown here, with column and row sums included in the display:
 *
 * [00][01][02][03][04](10)
 * [10][11][12][13][14](60)
 * [20][21][22][23][24](110)
 * [30][31][32][33][34](160)
 * [40][41][42][43][44](210)
 * (100)(105)(110)(115)(120)
 *
 *
 * The linked lists do not need to be circular nor bi-directional.
 *
 * @author Jean-Paul Labadie
 * @since 11/5/2015
 */
public interface LinkedMatrix {
    /**
     * Initializes the 2D Matrix (in place of a constructor).
     * Rows and Columns must both be greater than zero.
     *
     * @param rows integer specifying the height of the matrix, must be > 0.
     * @param cols integer specifying the width of the matrix must be > 0.
     * @return boolean, true if inputs were acceptable, false otherwise.
     */
    boolean init(int rows, int cols);

    /**
     * Inserts an integer value at the specified row and column.
     * Input values can be negative, zero, or positive.
     * @param value any integer for the value.
     * @param row the 'y' position for the input value.
     * @param col the 'x' position for the input value.
     * @return boolean, true if the position existed, false otherwise.
     */
	boolean setValue(int value, int row, int col);

    /**
     * Replace all values in the matrix with the given integer.
     * @param value any desired integer to fill all matrix values.
     */
    void fill(int value);

    /**
     * Returns the sum of all values from a specified row.
     *
     * @param row the row to sum for the return statement.
     * @return the sum of the values in the given row.
     * @throws NoSuchElementException if the specified row does not exist.
     */
	int sumRow(int row) throws NoSuchElementException;

    /**
     * Returns the sum of all values from a specified column.
     *
     * @param col the column to sum for the return statement.
     * @return the sum of the values in the given column.
     * @throws NoSuchElementException if the specified column does not exist.
     */
	int sumCol(int col) throws NoSuchElementException;

    /**
     * Returns the value at a specified location in the matrix.
     *
     * @param row the value's 'y' location.
     * @param col the values's 'x' location.
     * @return the value of the node at the given location in the matrix.
     * @throws NoSuchElementException if the specified location does not exist.
     */
    int getValue(int row, int col) throws NoSuchElementException;
}
