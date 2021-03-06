package io.github.satr.aws.lambda.shoppingbot.entity.converters;
// Copyright © 2017, github.com/satr, MIT License

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.satr.aws.lambda.shoppingbot.entity.ShoppingCartItem;
import java.util.List;

public class ShoppingCartItemConverter extends DbTypeConverter implements DynamoDBTypeConverter<String, List<ShoppingCartItem>> {

    @Override
    public String convert(List<ShoppingCartItem> entities) {
        String outputString = null;
        try {
            outputString = objectMapper.writeValueAsString(entities);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return outputString;
    }

    @Override
    public List<ShoppingCartItem> unconvert(String inputString) {
        List<ShoppingCartItem> entities = null;
        try {
            if (inputString != null && inputString.length() != 0)
                entities = objectMapper.readValue(inputString, new TypeReference<List<ShoppingCartItem>>(){});
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }
}
