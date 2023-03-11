package com.example.post_keeper.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "history")
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_type", referencedColumnName = "id")
    private HistoryTypeEntity historyType;

    @NotNull
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    private ShipmentEntity shipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_office", referencedColumnName = "id")
    private PostOfficeEntity postOffice;
}
