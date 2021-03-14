package com.cleevio.task.eshop.API;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WatchDTO {
    private Long id;
    private String title;
    private int price;
    private String description;
    private String imageBase64;
}
