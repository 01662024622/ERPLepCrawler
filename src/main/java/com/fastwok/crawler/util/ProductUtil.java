package com.fastwok.crawler.util;

import com.fastwok.crawler.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductUtil {
    public static List<Product> convert(JSONArray jsonArray,long parentId) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject productObject = jsonArray.getJSONObject(i);
            Product product = convertProduct(productObject,parentId);
            products.add(product);
            if (!productObject.has("products")||productObject.isNull("products")) continue;
            try {

                products.addAll(convert(productObject.getJSONArray("products"),product.getERPId()));
            }catch (Exception e){
                log.info(productObject.toString());
            }
        }
        return products;
    }

    private static Product convertProduct(JSONObject productObject, long parentId) {
        Product product = new Product();
        product.setERPCode(productObject.getString("sku"));
        product.setERPId(productObject.getLong("id"));
        product.setERPName(productObject.getString("name"));
        product.setERPParentId(parentId);
        return product;
    }
}
