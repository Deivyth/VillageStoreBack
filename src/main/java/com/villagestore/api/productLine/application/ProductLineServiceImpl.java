package com.villagestore.api.productLine.application;

import com.villagestore.api.productLine.domain.ProductLine;
import com.villagestore.api.productLine.infrastructure.ProductLineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductLineServiceImpl implements ProductLineService {

    private final ProductLineRepository productLineRepository;
    private final ProductLineMapper productLineMapper;

    public ProductLineServiceImpl(ProductLineRepository productLineRepository, ProductLineMapper productLineMapper) {
        this.productLineRepository = productLineRepository;
        this.productLineMapper = productLineMapper;
    }

    @Override
    @Transactional
    public ProductLineDTO addProductLine(ProductLineDTO productLineDTO) {
        ProductLine productLine = productLineRepository.save(productLineMapper.toEntity(productLineDTO));
        return productLineMapper.toDto(productLine);
    }
}
