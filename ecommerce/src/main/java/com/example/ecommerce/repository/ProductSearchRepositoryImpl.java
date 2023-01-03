package com.example.ecommerce.repository;

import com.example.ecommerce.domain.product.Product;
import com.example.ecommerce.domain.product.QProduct;
import com.example.ecommerce.dto.CategoryProduct;
import com.example.ecommerce.dto.ProductSearchCondition;
import com.example.ecommerce.dto.QCategoryProduct;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;

import com.querydsl.core.types.dsl.PathBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.example.ecommerce.domain.product.QProduct.*;

public class ProductSearchRepositoryImpl extends QuerydslRepositorySupport implements ProductSearchRepository  {

    public ProductSearchRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public List<CategoryProduct> searchProductBuilder(ProductSearchCondition condition) {
        BooleanBuilder builder = new BooleanBuilder();
        if(condition.getCategoryId().size() >0){
            condition.getCategoryId().forEach(s -> {
                builder.and(product.categoryIds.contains(s));
            });
        }
        if(condition.getStandardPrice() != null){
            builder.and(product.price.loe(condition.getStandardPrice()));
        }

       from(product)
               .where(builder)
               .orderBy(getOrder(condition).toArray(OrderSpecifier[]::new))
               .select(product.detail,product.id,product.price)
               .fetch();

        return null;
    }

    private List<OrderSpecifier> getOrder(ProductSearchCondition condition){
        List<OrderSpecifier> orders = new ArrayList<>();
        if(condition.getPriceLoe() != null){
            PathBuilder pathBuilder = new PathBuilder(product.price.getType(),product.price.getMetadata());
            orders.add(new OrderSpecifier(Order.ASC,pathBuilder.get(product.price)));
        }
        if(condition.getPriceGoe() != null){
            PathBuilder pathBuilder = new PathBuilder(product.price.getType(),product.price.getMetadata());
            orders.add(new OrderSpecifier(Order.DESC,pathBuilder.get(product.price)));
        }
        return orders;
    }
}
