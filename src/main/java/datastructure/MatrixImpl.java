package datastructure;

import exceptions.AdditionNotAllowedException;
import exceptions.IrregularDimensionsException;
import exceptions.MultiplicationNotAllowedException;
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

    public Matrix multiply(Matrix matrix) throws MultiplicationNotAllowedException
    {
        if(columnSize() != matrix.rowSize()) {
            throw new MultiplicationNotAllowedException("Dimensions of 2 matrices are not same");
        }
        Matrix productMatrix = new MatrixImpl(rowSize(), matrix.columnSize());
        for (int rowIndex = 0; rowIndex<rowSize(); rowIndex++) {
            int[] row = getRow(rowIndex);
            for (int mColumnIndex = 0; mColumnIndex<matrix.columnSize(); mColumnIndex++)
            {
                int[] column = matrix.getColumn(mColumnIndex);
                int dotProduct = 0;
                for (int dotIndex = 0; dotIndex < columnSize(); dotIndex++)
                {
                    dotProduct += row[dotIndex] * column[dotIndex];
                }
                productMatrix.set(rowIndex, mColumnIndex, dotProduct);
            }

        }
        return productMatrix;
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

    public Matrix subtract(Matrix matrix) throws SubtractionNotAllowedException
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

    public int[] getRow(int rowIndex) {
        return data[rowIndex];
    }

    public int[] getColumn(int columnIndex) {
        int[] column = new int[rowSize()];
        for (int rowIndex=0; rowIndex<rowSize(); rowIndex++) {
            column[rowIndex] = data[rowIndex][columnIndex];
        }
        return column;
    }
}
