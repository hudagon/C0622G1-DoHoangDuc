package com.project.be.service.product;

import com.project.be.dto.product.ProductSearchDto;
import com.project.be.model.product.Product;
import com.project.be.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IGeneralService {

    Page<Product> searchAllProduct(ProductSearchDto productSearchDto, Pageable pageable);

    Page<Product> findAllOk1(ProductSearchDto productSearchDto, Pageable pageable);

}
