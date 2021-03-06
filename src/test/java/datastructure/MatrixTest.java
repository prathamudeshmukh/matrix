package datastructure;

import exceptions.AdditionNotAllowedException;
import exceptions.IrregularDimensionsException;
import exceptions.MultiplicationNotAllowedException;
import exceptions.SubtractionNotAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest
{
    @DisplayName("Test if set sets the value and get return the value")
    @Test
    void testSetAndGetForMatrix() {
        Matrix matrix = new MatrixImpl(2,2);
        matrix.set(0, 0, 1);
        assertEquals(1, matrix.get(0,0));
    }

    @DisplayName("Matrix constructor should throw exception when there irregular dimensions")
    @Test
    void testShouldThrowIrregularDimensions() {
        Assertions.assertThrows(IrregularDimensionsException.class, () -> {
            new MatrixImpl(new int[][]{ {1, 2, 3},{3,4} });
        });
    }

    @DisplayName("Matrix constructor should throw exception if provided irregular length arrays")
    @Test
    void testShouldThrowIrregularDimensions_whenProvidedIrregularLengthArrays() {
        Assertions.assertThrows(IrregularDimensionsException.class, () -> {
            new MatrixImpl(new int[][]{ {1, 3},{3, 2, 4} });
        });
    }

    @DisplayName("Matrix constructor should not throw exception if provided regular length arrays")
    @Test
    void testShouldNotThrowIrregularDimensions_whenProvidedRegularLengthArrays() {
        Assertions.assertDoesNotThrow(() -> {
            new MatrixImpl(new int[][]{ {1, 3, 5},{3, 2, 4} });
        });
    }

    @DisplayName("Throw exception if 2 matrix donot have same dimensions")
    @Test
    void testShouldThrowException_whenOperandMatrixDimensionDoesNotMatch() throws IrregularDimensionsException
    {
        Matrix matrix1 = new MatrixImpl(new int[][]{ {1,2}, {3,4} });
        Matrix matrix2 = new MatrixImpl(new int[][]{ {5,6,9}, {7,8,9} });
        Assertions.assertThrows(AdditionNotAllowedException.class, () -> {
            matrix1.add(matrix2);
        }, "Dimensions of 2 matrices are not same");
    }

    @DisplayName("Test addition of 2 given matrix")
    @Test
    void testAdditionOfTwoMatrix() throws IrregularDimensionsException, AdditionNotAllowedException
    {
        Matrix matrix1 = new MatrixImpl(new int[][]{ {1,2},{3,4} });
        Matrix matrix2 = new MatrixImpl(new int[][]{ {5,6},{7,8} });
        Matrix sum = matrix1.add(matrix2);
        int[][] expectedAddition = { { 6, 8 }, { 10, 12 }};

        assertEquals(expectedAddition[0][0], sum.get(0,0));
        assertEquals(expectedAddition[0][1], sum.get(0,1));
        assertEquals(expectedAddition[1][0], sum.get(1,0));
        assertEquals(expectedAddition[1][1], sum.get(1,1));
    }

    @DisplayName("Throw exception if 2 matrix donot have same dimensions while subtracting")
    @Test
    void testShouldThrowException_whenOperandMatrixDimensionDoesNotMatchForSubtracting() throws IrregularDimensionsException
    {
        Matrix matrix1 = new MatrixImpl(new int[][]{ {1,2}, {3,4} });
        Matrix matrix2 = new MatrixImpl(new int[][]{ {5,6,9}, {7,8,9} });
        Assertions.assertThrows(SubtractionNotAllowedException.class, () -> {
            matrix1.subtract(matrix2);
        }, "Dimensions of 2 matrices are not same");
    }

    @DisplayName("Test subtraction of 2 given matrix")
    @Test
    void testSubtractionOfTwoMatrix() throws IrregularDimensionsException, SubtractionNotAllowedException
    {
        Matrix matrix1 = new MatrixImpl(new int[][]{ {1,2},{3,4} });
        Matrix matrix2 = new MatrixImpl(new int[][]{ {5,6},{7,8} });
        Matrix sum = matrix1.subtract(matrix2);
        int[][] expectedAddition = { { -4, -4 }, { -4, -4 }};

        assertEquals(expectedAddition[0][0], sum.get(0,0));
        assertEquals(expectedAddition[0][1], sum.get(0,1));
        assertEquals(expectedAddition[1][0], sum.get(1,0));
        assertEquals(expectedAddition[1][1], sum.get(1,1));
    }

    @DisplayName("Throw exception if 2 matrix donot have valid dimensions while multiplying")
    @Test
    void testShouldThrowException_whenOperandMatrixIsNotValidForMultiplying() throws IrregularDimensionsException
    {
        Matrix matrix1 = new MatrixImpl(new int[][]{ {1,2}, {3,4} });
        Matrix matrix2 = new MatrixImpl(new int[][]{ {5, 6}, {7, 8}, {10, 11} });
        Assertions.assertThrows(MultiplicationNotAllowedException.class, () -> {
            matrix1.multiply(matrix2);
        }, "Dimensions of 2 matrices are not same");
    }

    @DisplayName("Return multiplication matrix of 2 matrices")
    @Test
    void testShouldReturnProductOf2Matrix_whenOperandMatrixIsValid() throws IrregularDimensionsException, MultiplicationNotAllowedException
    {
        Matrix matrix1 = new MatrixImpl(new int[][]{ {1, 2, 3}, {4, 5, 6} });
        Matrix matrix2 = new MatrixImpl(new int[][]{ {7, 8}, {9, 10}, {11, 12} });
        Matrix product = matrix1.multiply(matrix2);

        int[][] expectedAddition = { { 58, 64 }, { 139, 154 }};

        assertEquals(expectedAddition[0][0], product.get(0,0));
        assertEquals(expectedAddition[0][1], product.get(0,1));
        assertEquals(expectedAddition[1][0], product.get(1,0));
        assertEquals(expectedAddition[1][1], product.get(1,1));
    }

    @DisplayName("Return transpose of a matrix")
    @Test
    void testShouldReturntransposeOfMatrix() throws IrregularDimensionsException
    {
        Matrix matrix = new MatrixImpl(new int[][]{ {1, 2}, {3, 4} , {5, 6} });
        Matrix transposeMatrix = matrix.transpose();

        int[][] expectedTranspose = { { 1, 3, 5 }, { 2, 4, 6 }};

        assertEquals(expectedTranspose[0][0], transposeMatrix.get(0,0));
        assertEquals(expectedTranspose[0][1], transposeMatrix.get(0,1));
        assertEquals(expectedTranspose[0][2], transposeMatrix.get(0,2));
        assertEquals(expectedTranspose[1][0], transposeMatrix.get(1,0));
        assertEquals(expectedTranspose[1][1], transposeMatrix.get(1,1));
        assertEquals(expectedTranspose[1][2], transposeMatrix.get(1,2));
    }

}
