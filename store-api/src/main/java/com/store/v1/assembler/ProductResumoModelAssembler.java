package com.store.v1.assembler;

import com.store.domain.model.Product;
import com.store.v1.StoreLinks;
import com.store.v1.controller.ProductController;
import com.store.v1.model.ProductResumoModel;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ProductResumoModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductResumoModel> {

    private final ModelMapper modelMapper;

    private final StoreLinks storeLinks;

    public ProductResumoModelAssembler(ModelMapper modelMapper, StoreLinks storeLinks) {
        super(ProductController.class, ProductResumoModel.class);
        this.modelMapper = modelMapper;
        this.storeLinks = storeLinks;
    }

    @Override
    public ProductResumoModel toModel(Product product) {
        ProductResumoModel productResumoModel = createModelWithId(product.getId(), product);
        modelMapper.map(product, productResumoModel);

        productResumoModel.add(storeLinks.linkToProducts("products"));
        return productResumoModel;
    }
}
