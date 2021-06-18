package com.nexos.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sort {
	private boolean sorted;
	private boolean unsorted;
	private boolean empty;
}
