package craftsmanLab.core;

import craftsmanLab.models.ApartmentRenovation;
import craftsmanLab.models.Craftsman;

import java.util.*;
import java.util.stream.Collectors;

public class CraftsmanLabImpl implements CraftsmanLab {

    private final Map<String, ApartmentRenovation> apartments;
    private final Map<String, Craftsman> craftsmen;
    private final Map<String, Craftsman> assignedCraftsmen;
    private final Map<String, Craftsman> unassignedCraftsmen;
    private final Map<String, Craftsman> craftsmanByJob;

    public CraftsmanLabImpl(Map<String, Craftsman> craftsmanByJob) {
        this.craftsmanByJob = new HashMap<>();
        this.apartments = new LinkedHashMap<>();
        this.craftsmen = new LinkedHashMap<>();
        this.assignedCraftsmen = new LinkedHashMap<>();
        this.unassignedCraftsmen = new LinkedHashMap<>();
    }

    @Override
    public void addApartment(ApartmentRenovation job) {

        if (exists(job)) {
            throw new IllegalArgumentException();
        }

        craftsmanByJob.put(job.address, null);
        apartments.put(job.address, job);
    }

    @Override
    public void addCraftsman(Craftsman craftsman) {

        if (exists(craftsman)) {
            throw new IllegalArgumentException();
        }
unassignedCraftsmen.put(craftsman.name, craftsman);
        craftsmen.put(craftsman.name, craftsman);
    }

    @Override
    public boolean exists(ApartmentRenovation job) {
        return apartments.containsKey(job.address);
    }

    @Override
    public boolean exists(Craftsman craftsman) {
        return craftsmen.containsKey(craftsman.name);
    }

    @Override
    public void removeCraftsman(Craftsman craftsman) {

        if (!exists(craftsman)) {
            throw new IllegalArgumentException();
        }

        craftsmen.remove(craftsman.name);
    }

    @Override
    public Collection<Craftsman> getAllCraftsmen() {
        return craftsmen.values();
    }

    @Override
    public void assignRenovations() {

        for (ApartmentRenovation apartment : apartments.values()) {


            Craftsman craftsman = getLowestEarningsCraftsman();

            if (assignedCraftsmen.get(apartment.address) != null &&
                    unassignedCraftsmen.get(craftsman.name) == null) {
                continue;
            }

            assignedCraftsmen.put(apartment.address, craftsman);
            unassignedCraftsmen.remove(craftsman.name);
        }

    }

    @Override
    public Craftsman getContractor(ApartmentRenovation job) {

        Craftsman craftsman = craftsmanByJob.get(job.address);

        if (craftsman == null) {
            throw new IllegalArgumentException();
        }

        return craftsman;
    }

    @Override
    public Craftsman getLeastProfitable() {
        return craftsmen.values()
                .stream()
                .sorted(Comparator.comparing(Craftsman::getTotalEarnings))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public Collection<ApartmentRenovation> getApartmentsByRenovationCost() {
        return null;
    }

    @Override
    public Collection<ApartmentRenovation> getMostUrgentRenovations(int limit) {
        List<ApartmentRenovation> sorted = apartments.values()
                .stream()
                .sorted(Comparator.comparing(ApartmentRenovation::getDeadline).reversed())
                .collect(Collectors.toList());

        if (sorted.size() < limit) {
            return sorted;
        }

        return sorted.stream().limit(limit).collect(Collectors.toList());
    }

    private Craftsman getLowestEarningsCraftsman() {
        Craftsman lowestEarningsCraftsman = null;
        for (Craftsman craftsman : craftsmen.values()) {
            if (lowestEarningsCraftsman == null || craftsman.getTotalEarnings() < lowestEarningsCraftsman.getTotalEarnings()) {
                lowestEarningsCraftsman = craftsman;
            }
        }

        return lowestEarningsCraftsman;
    }

    private double calculateRenovationCost(ApartmentRenovation apartment) {

        String address = apartment.address;
        Craftsman craftsman = craftsmanByJob.get(address);

        if (craftsman != null) {
            return apartment.getWorkHoursNeeded() * craftsman.getHourlyRate();
        } else {
            return apartment.getWorkHoursNeeded();
        }
    }
}
