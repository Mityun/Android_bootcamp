package com.samsung.rest.dto;

import com.samsung.domain.Author;
import com.samsung.domain.Importance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImportanceDto {

    private int id;

    private String name;


    public static ImportanceDto toDto(Importance importance){

        return new ImportanceDto(
                importance.getId(),
                importance.getName()
        );
    }

    public static Importance toDomainObject(ImportanceDto importanceDto){

        return new Importance(
                importanceDto.getId(),
                importanceDto.getName()
        );
    }
}
