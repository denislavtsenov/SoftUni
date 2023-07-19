package bg.softuni.jsonprocessing.service.impl;

import bg.softuni.jsonprocessing.repository.ProductRepository;
import bg.softuni.jsonprocessing.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void seedProducts() {

    }
}
