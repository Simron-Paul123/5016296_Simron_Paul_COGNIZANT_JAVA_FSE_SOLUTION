package com.bookstore.entity;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public class BookModelAssembler implements RepresentationModelAssembler<Book_entity,EntityModel<Book_entity>>{

	@Override
	public EntityModel<Book_entity> toModel(Book_entity entity) {
		// TODO Auto-generated method stub
		EntityModel<Book_entity> BookModel=EntityModel.of(entity);
		return BookModel;
	}

}
