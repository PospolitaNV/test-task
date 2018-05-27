package github.npospolita.twino;

import github.npospolita.twino.table.SimpleMemoryTable;
import github.npospolita.twino.table.Table;

/**
 * @author NPospolita
 * @since 26.05.2018
 */
public class Main {

    public static void main(String[] args) {
        Table table = new SimpleMemoryTable(10, 15);
        System.out.println(table);
        table.put(5, 5, "TEST");
        System.out.println(table);
    }
}
