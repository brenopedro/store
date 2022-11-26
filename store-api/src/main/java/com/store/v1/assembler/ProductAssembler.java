package com.store.v1.assembler;

import com.store.domain.model.Product;
import com.store.v1.StoreLinks;
import com.store.v1.controller.ProductController;
import com.store.v1.model.ProductModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel> {

    private final ModelMapper modelMapper;

    private final StoreLinks storeLinks;

    public ProductAssembler(ModelMapper modelMapper, StoreLinks storeLinks) {
        super(ProductController.class, ProductModel.class);
        this.modelMapper = modelMapper;
        this.storeLinks = storeLinks;
    }

    @Override
    public ProductModel toModel(Product product) {
        ProductModel productModel = createModelWithId(product.getId(), product);
        modelMapper.map(product, productModel);

        productModel.add(storeLinks.linkToProducts("products"));
        productModel.getDepartment().add(storeLinks.linkToDepartment(productModel.getDepartment().getId()));
        return productModel;
    }

    @Override
    public CollectionModel<ProductModel> toCollectionModel(Iterable<? extends Product> entities) {
        return super.toCollectionModel(entities);
    }
}
