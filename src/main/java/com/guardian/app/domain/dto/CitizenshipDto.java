package com.guardian.app.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
@EqualsAndHashCode
public class CitizenshipDto {

    private String citizenship;

}
