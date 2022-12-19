package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.*;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages>{
    private List<Beverages> beverages;


    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.beverages.stream().filter(beverage -> beverage.getName().equals(drinkName))
                .filter(beverage -> beverage.getBrand().equals(drinkBrand))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(beverages);
    }

    @Override
    public void add(Beverages entity) {
        this.beverages.add(entity);

    }
}
