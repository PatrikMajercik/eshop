package com.cleevio.task.eshop.dao;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="watches")
@EqualsAndHashCode
@Builder
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int price;
    private String description;
    private byte[] image;
}
