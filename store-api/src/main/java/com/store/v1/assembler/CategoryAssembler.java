package com.store.v1.assembler;

import com.store.domain.model.Category;
import com.store.v1.StoreLinks;
import com.store.v1.controller.CategoryController;
import com.store.v1.model.CategoryModel;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CategoryAssembler extends RepresentationModelAssemblerSupport<Category, CategoryModel> {

    private final ModelMapper modelMapper;

    private final StoreLinks storeLinks;

    public CategoryAssembler(ModelMapper modelMapper, StoreLinks storeLinks) {
        super(CategoryController.class, CategoryModel.class);
        this.modelMapper = modelMapper;
        this.storeLinks = storeLinks;
    }

    @Override
    public CategoryModel toModel(Category category) {
        CategoryModel categoryModel = createModelWithId(category.getId(), category);
        modelMapper.map(category, categoryModel);

        categoryModel.add(storeLinks.linkToCategories("categories"));
        return categoryModel;
    }

    @Override
    public CollectionModel<CategoryModel> toCollectionModel(Iterable<? extends Category> entities) {
        return super.toCollectionModel(entities);
    }
}
