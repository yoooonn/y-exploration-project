package com.ycourlee.explore.notes.elk.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

/**
 * @author yongjiang
 * @date 2022.03.11
 */
@Setter
@Getter
@ToString
public class GeoIpNestedEntity {

    @Field(name = "city_name", type = FieldType.Keyword)
    private String   cityName;
    @Field(name = "continent_name", type = FieldType.Keyword)
    private String   continentName;
    @Field(name = "country_iso_code", type = FieldType.Keyword)
    private String   countryIsoCode;
    @GeoPointField
    @Field(name = "location")
    private GeoPoint location;
    @Field(name = "region_name", type = FieldType.Keyword)
    private String   regionName;
}
