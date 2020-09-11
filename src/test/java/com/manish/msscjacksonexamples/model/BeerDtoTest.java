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

        String jsonString = "{\n" +
                "   \"id\":\"3d741157-e8b7-48f0-909c-4b47521bfd09\",\n" +
                "   \"beerName\":\"BeerName\",\n" +
                "   \"beerStyle\":\"Ale\",\n" +
                "   \"upc\":123456,\n" +
                "   \"price\":12.99,\n" +
                "   \"createdDate\":\"2020-09-11T07:52:53.9578212+05:30\",\n" +
                "   \"lastUpdatedDate\":\"2020-09-11T07:52:53.9578212+05:30\"\n" +
                "}";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        System.out.println(beerDto);
    }
}
