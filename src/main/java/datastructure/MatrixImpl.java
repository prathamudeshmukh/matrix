package datastructure;

import exceptions.AdditionNotAllowedException;
import exceptions.IrregularDimensionsException;
import exceptions.SubtractionNotAllowedException;

public class MatrixImpl implements Matrix
{
    private int[][] data;

    public MatrixImpl(int totalRows, int totalColumns) {
        data = new int[totalRows][totalColumns];
    }

    public MatrixImpl(int[][] data) throws IrregularDimensionsException
    {
        // TODO: Use custom constraint validator
        validate(data);
        this.data = data;
    }

    public Matrix multiply(Matrix matrix)
    {
        return null;
    }

    @Override
    public Matrix add(Matrix matrix) throws AdditionNotAllowedException
    {
        if(matrix.rowSize() != rowSize() || matrix.columnSize() != columnSize()) {
            throw new AdditionNotAllowedException("Dimensions of 2 matrices are not same");
        }
        Matrix additionMatrix = new MatrixImpl(rowSize(), columnSize());
        for(int row = 0; row < data.length; row++) {
            for(int col = 0; col < data[row].length; col++) {
                int sum = get(row, col) + matrix.get(row, col);
                additionMatrix.set(row, col, sum) ;
            }
        }
        return additionMatrix;
    }

    public Matrix subtraction(Matrix matrix) throws SubtractionNotAllowedException
    {
        if(matrix.rowSize() != rowSize() || matrix.columnSize() != columnSize()) {
            throw new SubtractionNotAllowedException("Dimensions of 2 matrices are not same");
        }
        Matrix subtractionMatrix = new MatrixImpl(rowSize(), columnSize());
        for(int row = 0; row < data.length; row++) {
            for(int col = 0; col < data[row].length; col++) {
                int sum = get(row, col) - matrix.get(row, col);
                subtractionMatrix.set(row, col, sum) ;
            }
        }
        return subtractionMatrix;
    }

    public Matrix transpose()
    {
        return null;
    }

    public int get(int row, int col)
    {
        return data[row][col];
    }

    public void set(int row, int col, int value)
    {
        data[row][col] = value;
    }

    public int rowSize()
    {
        return data.length;
    }

    public int columnSize()
    {
        return data[0].length;
    }

    private void validate(int[][] data) throws IrregularDimensionsException
    {
        for (int[] row: data) {
            if (data[0].length != row.length) {
                throw new IrregularDimensionsException();
            }
        }
    }
}
