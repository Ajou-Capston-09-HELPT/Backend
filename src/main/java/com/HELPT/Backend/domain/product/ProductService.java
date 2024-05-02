package com.HELPT.Backend.domain.product;

import com.HELPT.Backend.domain.gym.dto.GymResponse;
import com.HELPT.Backend.domain.product.dto.ProductRequest;
import com.HELPT.Backend.domain.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    @Transactional(readOnly = true)
    public List<ProductResponse> findAllProducts(Long gymId) {

        List<Product> products = productRepository.findAllByGymId(gymId)
                .orElseThrow(() -> new RuntimeException("Product Error"));
        return  products.stream()
                    .map(product -> new ProductResponse(product))
                    .collect(Collectors.toList());

    }

    @Transactional
    public ProductResponse addProduct(Long gymId, ProductRequest productRequest) {

        Product product = Product.builder()
                .gymId(gymId).day(productRequest.getDay()).price(productRequest.getPrice()).build();

        Product saveProduct = productRepository.save(product);
        return new ProductResponse(saveProduct);

    }

    @Transactional
    public ProductResponse modifyProduct(Long gymId, Long productId,ProductRequest productRequest) {

        Product findProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product Error"));
        findProduct.setDay(productRequest.getDay());
        findProduct.setPrice(productRequest.getPrice());

        return new ProductResponse(findProduct);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);

    }
}
