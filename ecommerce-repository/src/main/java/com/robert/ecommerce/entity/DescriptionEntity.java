package com.robert.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADDITIONAL_DESCRIPTION")
public class DescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    public DescriptionEntity(String title, String description, byte[] image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
