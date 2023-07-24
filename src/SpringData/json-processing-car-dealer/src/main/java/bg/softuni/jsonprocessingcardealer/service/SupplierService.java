package bg.softuni.jsonprocessingcardealer.service;

import bg.softuni.jsonprocessingcardealer.model.entity.Supplier;

import java.io.IOException;

public interface SupplierService {
    void seedSuppliers() throws IOException;

    Supplier getRandomSupplier();
}
