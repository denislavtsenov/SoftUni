package org.softuni.exam.structures;

import org.softuni.exam.entities.Deliverer;
import org.softuni.exam.entities.Package;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliveriesManagerImpl implements DeliveriesManager {

    Map<String, Deliverer> deliverers = new LinkedHashMap<>();
    Map<String, Package> packages = new LinkedHashMap<>();
    Map<String, Package> unAssignPackages = new LinkedHashMap<>();
    Map<String, Package> packagesByDeliverer = new LinkedHashMap<>();
    Map<String, Integer> packagesCountByDeliverer = new LinkedHashMap<>();

    @Override
    public void addDeliverer(Deliverer deliverer) {
        deliverers.put(deliverer.getId(), deliverer);
        packagesCountByDeliverer.put(deliverer.getId(), 0);
    }

    @Override
    public void addPackage(Package _package) {
        packages.put(_package.getId(), _package);
        unAssignPackages.put(_package.getId(), _package);
    }

    @Override
    public boolean contains(Deliverer deliverer) {
        return deliverers.get(deliverer.getId()) != null;
    }

    @Override
    public boolean contains(Package _package) {
        return packages.get(_package.getId()) != null;
    }

    @Override
    public Iterable<Deliverer> getDeliverers() {
        return this.deliverers.values();
    }

    @Override
    public Iterable<Package> getPackages() {
        return this.packages.values();
    }

    @Override
    public void assignPackage(Deliverer deliverer, Package _package) throws IllegalArgumentException {

        if (!contains(deliverer) || !contains(_package)) {
            throw new IllegalArgumentException();
        }

        int currentCount = packagesCountByDeliverer.get(deliverer.getId());
        packagesCountByDeliverer.put(deliverer.getId(), currentCount + 1);

        packagesByDeliverer.put(deliverer.getId(), _package);
        unAssignPackages.remove(_package.getId());
    }

    @Override
    public Iterable<Package> getUnassignedPackages() {
        return unAssignPackages.values();
    }

    @Override
    public Iterable<Package> getPackagesOrderedByWeightThenByReceiver() {
        return packages.values()
                .stream()
                .sorted(Comparator.comparing(Package::getWeight).reversed()
                        .thenComparing(Package::getReceiver))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName() {

        return deliverers.values()
                .stream()
                .sorted(Comparator.comparing((Deliverer d) -> packagesCountByDeliverer.get(d.getId())).reversed()
                        .thenComparing(Deliverer::getName))
                .collect(Collectors.toList());
    }
}
