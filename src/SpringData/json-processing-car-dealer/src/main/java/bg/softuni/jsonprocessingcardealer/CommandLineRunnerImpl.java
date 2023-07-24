package bg.softuni.jsonprocessingcardealer;

import bg.softuni.jsonprocessingcardealer.service.CarService;
import bg.softuni.jsonprocessingcardealer.service.CustomerService;
import bg.softuni.jsonprocessingcardealer.service.PartService;
import bg.softuni.jsonprocessingcardealer.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SupplierService supplierService;

    public CommandLineRunnerImpl(CarService carService, CustomerService customerService, PartService partService, SupplierService supplierService) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();
    }

    private void seedData() throws IOException {
        supplierService.seedSuppliers();
        partService.seedParts();
        carService.seedCars();
    }
}
