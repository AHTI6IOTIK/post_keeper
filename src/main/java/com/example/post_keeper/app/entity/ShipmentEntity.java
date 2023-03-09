package com.example.post_keeper.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shipment")
public class ShipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_type", referencedColumnName = "id")
    private ShipmentTypeEntity shipmentType;
    private int recipientZipcode;
    private String recipientAddress;
    private String recipientName;
}
