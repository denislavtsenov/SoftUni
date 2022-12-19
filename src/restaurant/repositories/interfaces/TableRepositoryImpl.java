package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Map<Integer, Table> tables;

    public TableRepositoryImpl() {
        this.tables = new LinkedHashMap<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(tables.values());
    }

    @Override
    public void add(Table entity) {
        this.tables.put(entity.getTableNumber(), entity);
    }

    @Override
    public Table byNumber(int number) {
        return this.tables.get(number);
    }
}
