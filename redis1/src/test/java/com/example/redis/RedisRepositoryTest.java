package com.example.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void createTest() {
        Item item = Item.builder()
                .name("keyboard")
                .description("Expensive keyboard")
                .price(100000)
                .build();

        itemRepository.save(item);
    }

//    @Test
//    public void readOneTest() {
//        Item item = itemRepository.findById(1L).orElseThrow();
//        System.out.println(item.getDescription());
//    }
//
//    @Test
//    public void updateTest() {
//        Item item = itemRepository.findById(1L).orElseThrow();
//        item.setDescription("Very Cheap");
//        Item save = itemRepository.save(item);
//        System.out.println(save.getDescription());
//    }
//
//    @Test
//    public void deleteTest() {
//        itemRepository.deleteById(1L);
//    }
}
