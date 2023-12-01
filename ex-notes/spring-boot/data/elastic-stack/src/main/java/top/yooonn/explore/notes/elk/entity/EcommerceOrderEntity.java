package top.yooonn.explore.notes.elk.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yooonn
 * @date 2022.03.10
 */
@Setter
@Getter
@ToString
@Document(indexName = "kibana_sample_data_ecommerce")
public class EcommerceOrderEntity implements Serializable {

    private static final long serialVersionUID = 4501376782612197280L;

    @Id
    @Field(name = "_id", type = FieldType.Text)
    private String id;

    @Field(name = "category", type = FieldType.Text)
    private String category;

    @Field(name = "currency", type = FieldType.Keyword)
    private String  currency;
    @Field(name = "customer_id", type = FieldType.Keyword)
    private String  customerId;
    @Field(name = "customer_first_name", type = FieldType.Text, ignoreAbove = 256)
    private String  customerFirstName;
    @Field(name = "customer_last_name", type = FieldType.Text, ignoreAbove = 256)
    private String  customerLastName;
    @Field(name = "customer_full_name", type = FieldType.Text, ignoreAbove = 256)
    private String  customerFullName;
    @Field(name = "customer_gender", type = FieldType.Keyword)
    private String  customerGender;
    @Field(name = "customer_birth_date", type = FieldType.Date, format = DateFormat.date_time_no_millis)
    private Date    customerBirthdayDate;
    @Field(name = "customer_phone", type = FieldType.Keyword)
    private String  customerPhone;
    @Field(name = "day_of_week", type = FieldType.Keyword)
    private String  dayOfWeek;
    @Field(name = "day_of_week_i", type = FieldType.Integer)
    private Integer dayOfWeekI;
    @Field(name = "email", type = FieldType.Keyword)
    private String  email;
    @Field(name = "event.dataset", type = FieldType.Keyword)
    private String  eventDataset;

    @Field(name = "geoip", type = FieldType.Object)
    private GeoIpNestedEntity geoip;

    @Field(name = "manufacturer", type = FieldType.Text)
    private String manufacture;
    @Field(name = "order_date", type = FieldType.Date, format = DateFormat.date_time_no_millis)
    private Date   orderDate;
    @Field(name = "order_id", type = FieldType.Keyword)
    private String orderId;

    @Field(name = "products")
    private List<ProductNestedEntity> products;

    @Field(name = "sku", type = FieldType.Keyword)
    private String  sku;
    @Field(name = "taxful_total_price", type = FieldType.Half_Float)
    private Float   taxFulTotalPrice;
    @Field(name = "taxless_total_price", type = FieldType.Half_Float)
    private Float   taxLessTotalPrice;
    @Field(name = "total_quantity", type = FieldType.Integer)
    private Integer totalQuantity;
    @Field(name = "total_unique_products", type = FieldType.Integer)
    private Integer totalUniqueProducts;
    @Field(name = "type", type = FieldType.Keyword)
    private String  type;
    @Field(name = "user", type = FieldType.Keyword)
    private String  user;

}
