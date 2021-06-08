package com.alexsucata.inBucharest.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "establishment_types")
public class EstablishmentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;
    private String type;

    @OneToMany(mappedBy = "type")
    private List<EstablishmentEntity> establishmentEntities;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer categoryId) {
        this.typeId = categoryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<EstablishmentEntity> getEstablishmentEntities() {
        return establishmentEntities;
    }

    public void setEstablishmentEntities(List<EstablishmentEntity> establishmentEntities) {
        this.establishmentEntities = establishmentEntities;
    }

    @Override
    public String toString() {
        return type;
    }
}
