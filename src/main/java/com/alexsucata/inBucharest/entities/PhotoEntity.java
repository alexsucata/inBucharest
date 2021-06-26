package com.alexsucata.inBucharest.entities;


import javax.persistence.*;

@Entity
@Table(name = "photos")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer photoId;
    private String photoName;

    @ManyToOne
    @JoinColumn(name = "establishmentId")
    private EstablishmentEntity establishment;
}
