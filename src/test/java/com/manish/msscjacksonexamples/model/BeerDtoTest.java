package com.manish.msscjacksonexamples.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
public class BeerDtoTest extends BaseTest {
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserializeJson() throws JsonProcessingException {

        String jsonString = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123456,\"price\":\"12.99\",\"createdDate\":\"2020-09-11T09:34:53+0530\",\"lastUpdatedDate\":\"2020-09-11T09:34:53.6235994+05:30\",\"myLocalDate\":\"20200911\",\"beerId\":\"2bde587c-610d-4094-82a5-6c95b186e84f\"}";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        System.out.println(beerDto);
    }
}
