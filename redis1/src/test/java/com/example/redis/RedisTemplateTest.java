package com.example.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTemplateTest {

    // StringRedisTemplate : 자바 자료형 중 String 타입을 key로 설정하겠다. -> 즉, 자바에서 key를 전달할 때 문자열을 줄거다
    // 단순히 생각하면 redis의 데이터가 자바에 오면 무슨 타입일까?를 나타낸다 -> 자바 기준으로 생각하면 된다.
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringOpsTest() {
        // 지금 RedisTemplate에 설정된 타입을 바탕으로 Redis 문자열 조작을 할거다.
        // ValueOperations가 Redis 문자열 조작을 위해 쓰이는 클래스다.
        // ValueOperation은 우리가 배운 Redis 명령어를 method로 가지고 있다.
        // 자바의 문자열을 사용하는 클래스
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("simpleKey", "simpleValue");
        System.out.println(ops.get("simpleKey"));

        SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
        opsForSet.add("hobbies", "games");
        opsForSet.add(
                "hobbies",
                "coding", "alchole", "games"
        );
        System.out.println(opsForSet.size("hobby"));
        stringRedisTemplate.expire("hobbies", 10, TimeUnit.SECONDS);
        stringRedisTemplate.delete("simpleKey");
    }

    @Autowired
    private RedisTemplate<String, ItemDto> itemDtoRedisTemplate;

    @Test
    public void itemRedisTemplateTest() {
        ValueOperations<String, ItemDto> ops = itemDtoRedisTemplate.opsForValue();
        ops.set("my:keyboard", ItemDto.builder()
                .name("Machanical Keyboard")
                .price(25000)
                .description("OMG")
                .build());
        System.out.println(ops.get("my:keyboard"));

        ops.set("my:mouse", ItemDto.builder()
                .name("Micky Mouse")
                .price(30000)
                .description("OMOMOMG")
                .build());
        System.out.println(ops.get("my:mouse"));
    }

}
