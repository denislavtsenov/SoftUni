package bg.softuni.jsonprocessingcardealer.service.impl;

import bg.softuni.jsonprocessingcardealer.model.dto.SupplierSeedDto;
import bg.softuni.jsonprocessingcardealer.model.entity.Supplier;
import bg.softuni.jsonprocessingcardealer.repository.SupplierRepository;
import bg.softuni.jsonprocessingcardealer.service.SupplierService;
import bg.softuni.jsonprocessingcardealer.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final static String SUPPLIER_FILE_PATH = "src/main/resources/files/suppliers.json";

    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers() throws IOException {

        if (supplierRepository.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(SUPPLIER_FILE_PATH));

        SupplierSeedDto[] supplierSeedDtos = gson.fromJson(fileContent, SupplierSeedDto[].class);

        Arrays.stream(supplierSeedDtos)
                .map(supplierSeedDto ->
                        modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(supplierRepository::save);
    }

    @Override
    public Supplier getRandomSupplier() {

        long randomId = ThreadLocalRandom
                .current().nextLong(1, supplierRepository.count() + 1);

        return supplierRepository.findById(randomId).orElse(null);
    }
}
