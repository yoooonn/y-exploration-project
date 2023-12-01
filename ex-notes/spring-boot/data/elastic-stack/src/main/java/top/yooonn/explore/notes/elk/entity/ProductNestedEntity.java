package top.yooonn.explore.notes.elk.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yooonn
 * @date 2022.03.11
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class ProductNestedEntity implements Serializable {

    private static final long serialVersionUID = 1418272875036754649L;

    @Field(name = "_id", type = FieldType.Text, ignoreAbove = 256)
    private String  id;
    @Field(name = "base_price", type = FieldType.Half_Float)
    private Float   basePrice;
    @Field(name = "base_unit_price", type = FieldType.Half_Float)
    private Float   baseUnitPrice;
    @Field(name = "category", type = FieldType.Text)
    private String  category;
    @Field(name = "created_on", type = FieldType.Date, format = DateFormat.date_time_no_millis)
    private Date    createdOn;
    @Field(name = "discount_amount", type = FieldType.Half_Float)
    private Float   discountAmount;
    @Field(name = "discount_percentage", type = FieldType.Half_Float)
    private Float   discountPercentage;
    @Field(name = "manufacturer", type = FieldType.Text)
    private String  manufacture;
    @Field(name = "min_price", type = FieldType.Half_Float)
    private Float   minPrice;
    @Field(name = "price", type = FieldType.Half_Float)
    private Float   price;
    @Field(name = "product_id", type = FieldType.Long)
    private String  productId;
    @Field(name = "product_name", type = FieldType.Text, analyzer = "english")
    private String  productName;
    @Field(name = "quantity", type = FieldType.Integer)
    private Integer quantity;
    @Field(name = "sku", type = FieldType.Keyword)
    private String  sku;
    @Field(name = "tax_amount", type = FieldType.Half_Float)
    private Float   taxAmount;
    @Field(name = "taxful_price", type = FieldType.Half_Float)
    private Float   taxFulPrice;
    @Field(name = "taxless_price", type = FieldType.Half_Float)
    private Float   taxLessPrice;
    @Field(name = "unit_discount_amount", type = FieldType.Half_Float)
    private Float   unitDiscountAmount;
}
