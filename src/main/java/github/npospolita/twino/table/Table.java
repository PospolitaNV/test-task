package github.npospolita.twino.table;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Интерфейс для работы с электронными таблицами.
 * @author NPospolita
 * @since 26.05.2018
 */
public interface Table {


    /**
     * Метод вставки значения в таблицу.
     * @param column - номер столбца.
     * @param row - номер строки.
     * @param value - значение для вставки в ячейку.
     * @throws IllegalArgumentException если пытаемся обратиться к ячейке за пределами таблицы.
     *
     * @return предыдущее значение в ячейке или null, если оно отсутствует.
     */
    @Nullable String put(int column, int row, @Nonnull String value);


    /**
     * Метод получения значения таблицы.
     * @param column - номер столбца.
     * @param row - номер строки.
     * @throws IllegalArgumentException если пытаемся обратиться к ячейке за пределами таблицы.
     *
     * @return значение в ячейке или null, если оно отсутствует.
     */
    @Nullable String get(int column, int row);

}
