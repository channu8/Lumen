package com.example.demo.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorHandler {

	private LocalDateTime currentTime;
	private String message;
	private String description;
}
