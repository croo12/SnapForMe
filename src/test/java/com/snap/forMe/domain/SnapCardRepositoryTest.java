package com.snap.forMe.domain;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SnapCardRepositoryTest {
    @Autowired
    SnapCardRepository snapCardRepository;

    @After
    public void cleanup(){
        snapCardRepository.deleteAll();
    }

    @Test
    public void insert_test(){

        String card_name = "iron man";
        int card_energy = 5;

        snapCardRepository.save(SnapCard.builder()
                .card_name(card_name)
                        .card_energy(card_energy)
                        .card_power(0)
                        .card_text("이 필드 파워 2배")
                        .card_image("")
                .build());

        List<SnapCard> cardList = snapCardRepository.findAll();

        SnapCard card = cardList.get(0);
        Assertions.assertThat(card.getCard_name()).isEqualTo(card_name);
        Assertions.assertThat(card.getCard_energy()).isEqualTo(card_energy);
    }
}
