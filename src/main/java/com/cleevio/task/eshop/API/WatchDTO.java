package com.cleevio.task.eshop.API;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WatchDTO {
    @Nullable
    private Long id;
    @Nullable
    private String title;
    @Nullable
    private int price;
    @Nullable
    private String description;
    @NotEmpty(message = "Image may not be null")
    private String imageBase64;
}
