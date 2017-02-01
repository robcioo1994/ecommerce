package com.robert.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "IMAGES")
public class ImagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    public ImagesEntity(byte[] image) {
        this.image=image;
    }
}
