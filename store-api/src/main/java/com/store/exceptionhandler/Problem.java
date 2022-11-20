package com.store.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "Problem")
@Builder
@Getter
public class Problem {

    @Schema(example = "404")
    private Integer status;

    @Schema(example = "Invalid ID")
    private String title;

    @Schema(example = "The request body is invalid. Please check again.")
    private String detail;

    @Schema(example = "The request body is invalid. Please check again.")
    private String userMessage;

    @Schema(example = "2022-11-20T22:14:03.840Z")
    private OffsetDateTime timestamp;

    @Schema(description = "List of error objects")
    private List<Object> objects;

    @Schema(name = "ProblemObject")
    @Builder
    @Getter
    public static class Object {

        @Schema(example = "id")
        private String name;

        @Schema(example = "id cannot be blank")
        private String userMessage;
    }
}
