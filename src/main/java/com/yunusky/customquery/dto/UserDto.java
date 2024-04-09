package com.yunusky.customquery.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record UserDto(String username, boolean active, long salary, Date birthDate) {
}
