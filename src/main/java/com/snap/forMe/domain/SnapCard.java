package com.snap.forMe.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "snap_cards")
public class SnapCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long card_id;

    @Column(nullable = false)
    private String card_name;

    @Column(nullable = false)
    private int card_energy;

    @Column(nullable = false)
    private int card_power;

    @Column(nullable = false)
    private String card_image;

    @Column(nullable = false)
    private String card_text;

    @Builder
    public SnapCard(String card_name, int card_energy, int card_power,
                          String card_image, String card_text){
        this.card_name = card_name;
        this.card_energy = card_energy;
        this.card_power = card_power;
        this.card_image = card_image;
        this.card_text = card_text;
    }
}
