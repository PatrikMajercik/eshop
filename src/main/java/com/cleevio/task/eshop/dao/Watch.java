package com.cleevio.task.eshop.dao;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "watch")
@EqualsAndHashCode
@Builder
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Nullable
    private String title;
    @Nullable
    private int price;
    @Nullable
    private String description;
    @NotEmpty(message = "Image may not be null")
    private byte[] image;
}
