package com.store.v1.assembler;

import com.store.domain.model.SubCategory;
import com.store.v1.StoreLinks;
import com.store.v1.controller.SubCategoryController;
import com.store.v1.model.SubCategoryModel;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryAssembler extends RepresentationModelAssemblerSupport<SubCategory, SubCategoryModel> {

    private final ModelMapper modelMapper;
    private final StoreLinks storeLinks;

    public SubCategoryAssembler(ModelMapper modelMapper, StoreLinks storeLinks) {
        super(SubCategoryController.class, SubCategoryModel.class);
        this.modelMapper = modelMapper;
        this.storeLinks = storeLinks;
    }

    @Override
    public SubCategoryModel toModel(SubCategory subCategory) {
        SubCategoryModel subCategoryModel = createModelWithId(subCategory.getId(), subCategory);
        modelMapper.map(subCategory, subCategoryModel);

        subCategoryModel.add(storeLinks.linkToSubCategories("sub-categories"));
        return subCategoryModel;
    }

    @Override
    public CollectionModel<SubCategoryModel> toCollectionModel(Iterable<? extends SubCategory> entities) {
        return super.toCollectionModel(entities);
    }
}
