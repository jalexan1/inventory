package com.nexos.inventory.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nexos.inventory.dto.Pageable;
import com.nexos.inventory.dto.Sort;

@Component
public class PageMapper<T> {

	public Map<String, Object> mapper(Page<T> page, Object object) {
		
		Map<String, Object> response = new HashMap<>();
		response.put("content", object);
		
		Pageable pageable = new Pageable();
		Sort sort = new Sort(page.getSort().isSorted(), page.getSort().isUnsorted(), page.getSort().isEmpty());
		pageable.setSort(sort);
		pageable.setOffset(page.getPageable().getOffset());
		pageable.setPageNumber(page.getPageable().getPageNumber());
		pageable.setPageSize(page.getPageable().getPageSize());
		pageable.setPaged(true);
		pageable.setUnpaged(false);
		response.put("pageable", pageable);
		
		response.put("totalPages", page.getTotalPages());
		response.put("last", page.isLast());
		response.put("totalElements", page.getTotalElements());
		response.put("size", page.getSize());
		response.put("number", page.getNumber());
		response.put("first", page.isFirst());
		response.put("numberOfElements", page.getNumberOfElements());
		response.put("empty", page.isEmpty());
		
		return response;
		
	}
}
