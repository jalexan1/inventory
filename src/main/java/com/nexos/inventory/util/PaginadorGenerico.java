package com.nexos.inventory.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import com.nexos.inventory.dto.FilterDTO;
import com.nexos.inventory.dto.FilterDTO.Operations;
import com.nexos.inventory.dto.FilterDTO.Types;
import com.nexos.inventory.dto.PageDTO;

@Component
public class PaginadorGenerico<T> {

	public Page<T> consultar(PageDTO page, JpaSpecificationExecutor<T> repository) {
		Pageable pageable = null;
		
		if(page.getOrder() != null && !page.getOrder().equals("")) {
			pageable = PageRequest.of(page.getPage(), page.getSize(), Sort.by(orderedFileds(page.getOrder(), page.getOrderType())));
		} else {
			pageable = PageRequest.of(page.getPage(), page.getSize());
		}
		
		return repository.findAll(new Specification<T>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				page.getConditions().forEach((field, filter) -> predicates
						.addAll(generadorFiltros(field, filter, root, criteriaBuilder)));
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
		
	}
	
	/**
     * Utilidades de paginado - consultas dinamicas
     */
    private List<Predicate> generadorFiltros(String field, FilterDTO filter, Root<?> root,
			CriteriaBuilder criteriaBuilder) {    	
    	
		List<Predicate> predicates = new ArrayList<>();

		if (filter.getOperation() == Operations.BETWEEN) {
			if (filter.getType() == Types.INTEGER) {
				Integer iFrom = getValueInteger(filter, 0);
				Integer iTo = getValueInteger(filter, 1);
				predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get(field), iFrom, iTo)));
			} else if (filter.getType() == Types.DATE) {
				String dFrom = getValueSring(filter, 0);
				String dTo = getValueSring(filter, 1);
				Expression<String> dateStringExpr = criteriaBuilder.function("FORMAT", String.class,
						root.<Date>get(field), criteriaBuilder.literal("yyyy-MM-dd"));
				predicates.add(criteriaBuilder.and(criteriaBuilder.between(dateStringExpr, dFrom, dTo)));
			} else {
				String sFrom = getValueSring(filter, 0);
				String sTo = getValueSring(filter, 1);
				predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get(field), sFrom, sTo)));
			}
		} else if (filter.getOperation() == Operations.EQUALS) {
			Path<Object> path = null;
			switch (filter.getType()) {
			case INTEGER:
				Integer value = getValueInteger(filter, 0);
				predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(field), value)));
				break;
			case DATE:
				String date = getValueSring(filter, 0);
				Expression<String> dateStringExpr = criteriaBuilder.function("FORMAT", String.class,
						root.<Date>get(field), criteriaBuilder.literal("yyyy-MM-dd"));
				predicates.add(criteriaBuilder.and(criteriaBuilder.equal(dateStringExpr, date)));
				break;
			default:
				String text = filter.getValues().length > 0 ? filter.getValues()[0] : "0";
				path = getPath(field, root);
				predicates.add(criteriaBuilder.and(criteriaBuilder.equal(path, text)));
				break;
			}
		} else if (filter.getOperation() == Operations.LIKE) {
			String like = "%" + getValueSring(filter, 0) + "%";
			predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get(field), like)));
		}

		return predicates;
	}
	
	private Path<Object> getPath(String field, Root<?> root) {
		Path<Object> path = null;

		if (field.contains(".")) {
			String[] atributos = field.split(Pattern.quote("."));

			for (int i = 0; i < atributos.length; i++) {
				if (path == null) {
					path = root.get(atributos[i]);
				} else {
					path = path.get(atributos[i]);
				}
			}
		} else {
			path = root.get(field);
		}
		return path;
	}
	
	private Integer getValueInteger(FilterDTO filter, int index) {
		Integer value = null;
		value = Integer.parseInt((filter.getValues().length > 0 ? filter.getValues()[index] : "0"));
		return value;
	}

	private String getValueSring(FilterDTO filter, int index) {
		String value = null;
		value = (filter.getValues().length > 0 ? filter.getValues()[index] : "0");
		return value;
	}
	
	private List<Order> orderedFileds(String fields, String orderType)
	{
		String[] orderField = fields.split(",", -1);
		List<Order> orders = new ArrayList<>();
		Direction dir ;
		
		if (orderType== null || orderType.isEmpty() || orderType.equals("ASC"))
		{
			dir = Sort.Direction.ASC;
		}
		else {
			dir = Sort.Direction.DESC;
		}
		
		for (String field : orderField) {
			orders.add(new Order(dir, field));
		}
		
		return orders;
	
	}
	
}
