package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExplorerRepository implements Repository<Explorer> {
    private Map<String, Explorer> explorers;

    public ExplorerRepository() {
        explorers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(explorers.values());
    }

    @Override
    public void add(Explorer entity) {
        this.explorers.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return this.explorers.values().remove(entity);
    }

    @Override
    public Explorer byName(String name) {
        return explorers.values().stream().filter(explorer -> explorer.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
