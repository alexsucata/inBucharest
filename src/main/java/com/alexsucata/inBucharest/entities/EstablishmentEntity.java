package com.alexsucata.inBucharest.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "establishments")
public class EstablishmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer establishmentId;
    private String establishmentName;
    private String establishmentAddress;
    private String establishmentDescription;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private EstablishmentTypeEntity type;

    @OneToMany(mappedBy = "establishment")
    private List<PhotoEntity> photos;



    public Integer getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(Integer establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public String getEstablishmentAddress() {
        return establishmentAddress;
    }

    public void setEstablishmentAddress(String establishmentAddress) {
        this.establishmentAddress = establishmentAddress;
    }

    public String getEstablishmentDescription() {
        return establishmentDescription;
    }

    public void setEstablishmentDescription(String establishmentDescription) {
        this.establishmentDescription = establishmentDescription;
    }

    public EstablishmentTypeEntity getType() {
        return type;
    }

    public void setType(EstablishmentTypeEntity type) {
        this.type = type;
    }

}
