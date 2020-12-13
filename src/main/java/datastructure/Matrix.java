package datastructure;

import exceptions.AdditionNotAllowedException;
import exceptions.MultiplicationNotAllowedException;
import exceptions.SubtractionNotAllowedException;

public interface Matrix
{
    Matrix multiply(Matrix matrix) throws MultiplicationNotAllowedException;;
    Matrix add(Matrix matrix) throws AdditionNotAllowedException;
    Matrix subtract(Matrix matrix) throws SubtractionNotAllowedException;
    Matrix transpose();
    int get(int row, int col);
    void set(int row, int col, int value);
    int rowSize();
    int columnSize();
    int[] getRow(int rowIndex);
    int[] getColumn(int columnIndex);
}
