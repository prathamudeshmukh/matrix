package datastructure;

import exceptions.AdditionNotAllowedException;
import exceptions.SubtractionNotAllowedException;

public interface Matrix
{
    Matrix multiply(Matrix matrix);
    Matrix add(Matrix matrix) throws AdditionNotAllowedException;
    Matrix subtraction(Matrix matrix) throws SubtractionNotAllowedException;
    Matrix transpose();
    int get(int row, int col);
    void set(int row, int col, int value);
    int rowSize();
    int columnSize();
}
