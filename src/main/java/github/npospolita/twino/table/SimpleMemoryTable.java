package github.npospolita.twino.table;

import javax.annotation.Nonnull;

/**
 * Простая реализация интерфейса для работы с электронными таблицами.
 * Значения ячеек хранятся в памяти.
 *
 * @author NPospolita
 * @since 26.05.2018
 */
public class SimpleMemoryTable implements Table {

    private String[][] table;
    private int columnSize;
    private int rowSize;

    public SimpleMemoryTable(int columnSize, int rowSize) {
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        table = new String[rowSize][columnSize];
    }

    @Override
    public String put(int column, int row, @Nonnull String value) {
        checkBounds(column, row);
        String prevValue = table[row][column];
        table[row][column] = value;
        return prevValue;
    }


    @Override
    public String get(int column, int row) {
        checkBounds(column, row);
        return table[row][column];
    }

    private void checkBounds(int column, int row) {
        if(column > columnSize || row > rowSize) {
            throw new IllegalArgumentException("Index out of bounds!");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                stringBuilder.append(table[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
