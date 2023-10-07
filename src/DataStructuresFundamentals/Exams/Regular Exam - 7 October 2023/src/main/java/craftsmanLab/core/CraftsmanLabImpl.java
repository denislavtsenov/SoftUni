package craftsmanLab.core;

import craftsmanLab.models.ApartmentRenovation;
import craftsmanLab.models.Craftsman;

import java.util.*;
import java.util.stream.Collectors;

public class CraftsmanLabImpl implements CraftsmanLab {
    private final Map<String, Craftsman> craftsmen;
    private final Map<String, Craftsman> assignedCraftsmen;
    private final Map<String, Craftsman> unassignedCraftsmen;
    private final Map<String, Craftsman> craftsmanByApartment;
    private final Map<String, ApartmentRenovation> apartments;
    private final Map<String, Craftsman> assignedApartments;
    private final Map<String, ApartmentRenovation> unassignedApartments;
    private final Map<String, Double> apartmentsCost;

    public CraftsmanLabImpl() {
        this.craftsmen = new LinkedHashMap<>();
        this.apartments = new LinkedHashMap<>();
        this.assignedApartments = new LinkedHashMap<>();
        this.unassignedCraftsmen = new LinkedHashMap<>();
        this.assignedCraftsmen = new LinkedHashMap<>();
        this.unassignedApartments = new LinkedHashMap<>();
        this.craftsmanByApartment = new LinkedHashMap<>();
        this.apartmentsCost = new TreeMap<>();
    }

    @Override
    public void addApartment(ApartmentRenovation job) {

        if (exists(job)) {
            throw new IllegalArgumentException();
        }

        apartments.put(job.address, job);
        unassignedApartments.put(job.address, job);
        craftsmanByApartment.put(job.address, null);
    }

    @Override
    public void addCraftsman(Craftsman craftsman) {

        if (exists(craftsman)) {
            throw new IllegalArgumentException();
        }

        craftsmen.put(craftsman.name, craftsman);
        unassignedCraftsmen.put(craftsman.name, craftsman);
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

        if (!exists(craftsman) || isCraftsmanAssigned(craftsman)) {
            throw new IllegalArgumentException();
        }

        craftsmen.remove(craftsman.name);
        unassignedCraftsmen.remove(craftsman.name);
    }

    @Override
    public Collection<Craftsman> getAllCraftsmen() {
        return craftsmen.values();
    }

    @Override
    public void assignRenovations() {
        for (ApartmentRenovation apartment : apartments.values()) {
            Craftsman craftsman = getLowestEarningsCraftsman();

            if (assignedApartments.get(apartment.address) != null) {
                continue;
            }
//
//            if (assignedCraftsmen.get(craftsman.name) != null) {
//                continue;
//            }

            craftsman.totalEarnings += apartment.workHoursNeeded * craftsman.hourlyRate;

            assignedCraftsmen.put(craftsman.name, craftsman);

            assignedApartments.put(apartment.address, craftsman);

            craftsmanByApartment.put(apartment.address, craftsman);

            unassignedApartments.remove(apartment.address);
            unassignedCraftsmen.remove(craftsman.name);

            Double totalCost = this.calculateRenovationCost(apartment);
            apartmentsCost.put(apartment.address, totalCost);
        }
    }

    @Override
    public Craftsman getContractor(ApartmentRenovation job) {


        Craftsman craftsman = craftsmanByApartment.get(job.address);

        if (craftsman == null) {
            throw new IllegalArgumentException();
        }

        return craftsman;
    }

    @Override
    public Craftsman getLeastProfitable() {

        if (craftsmen.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return craftsmen.values()
                .stream()
                .sorted(Comparator.comparing(Craftsman::getTotalEarnings))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public Collection<ApartmentRenovation> getApartmentsByRenovationCost() {
        return apartments.values()
                .stream()
                .sorted((f, s) -> {
                    double first;
                    double second;

                    if (craftsmanByApartment.get(f.address) != null) {
                        first = calculateRenovationCost(f);
                    } else {
                        first = craftsmanByApartment.get(f.address).hourlyRate;
                    }

                    if (craftsmanByApartment.get(s.address) != null) {
                        second = calculateRenovationCost(s);
                    } else {
                        second = craftsmanByApartment.get(s.address).hourlyRate;
                    }
                    return Double.compare(second, first);
                })
                .collect(Collectors.toList());

    }

    @Override
    public Collection<ApartmentRenovation> getMostUrgentRenovations(int limit) {
        List<ApartmentRenovation> allApartments = apartments.values()
                .stream()
                .sorted(Comparator.comparing(ApartmentRenovation::getDeadline))
                .collect(Collectors.toList());

        if (allApartments.size() < limit) {
            return allApartments;
        }

        List<ApartmentRenovation> newToReturn = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            newToReturn.add(allApartments.get(i));
        }

        return newToReturn;
    }

    private boolean isCraftsmanAssigned(Craftsman craftsman) {
        return assignedCraftsmen.containsKey(craftsman.name);
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
        Craftsman craftsman = craftsmanByApartment.get(address);

        if (craftsman != null) {
            return apartment.getWorkHoursNeeded() * craftsman.getHourlyRate();
        } else {
            return apartment.getWorkHoursNeeded();
        }
    }
}
