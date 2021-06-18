package com.nexos.inventory.dto;

import lombok.Data;

@Data
public class Pageable {

	private Sort sort;
	private long offset;
	private Integer pageNumber;
	private Integer pageSize;
	private boolean paged;
	private boolean unpaged;
	
}
