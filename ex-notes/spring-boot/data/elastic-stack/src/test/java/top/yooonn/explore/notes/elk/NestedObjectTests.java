/*
 * Copyright 2013-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package top.yooonn.explore.notes.elk;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedObjectTests {

    @Document(indexName = "test-index-book-nested-objects")
    static class Book {

        @Nullable
        @Id
        private String                           id;
        @Nullable
        private String                           name;
        @Nullable
        @Field(type = FieldType.Object)
        private Author                           author;
        @Nullable
        @Field(type = FieldType.Nested)
        private Map<Integer, Collection<String>> buckets = new HashMap<>();
        @Nullable
        @MultiField(mainField = @Field(type = FieldType.Text, analyzer = "whitespace"),
                otherFields = {@InnerField(suffix = "prefix", type = FieldType.Text, analyzer = "stop",
                        searchAnalyzer = "standard")})
        private String                           description;

        @Nullable
        public String getId() {
            return id;
        }

        public void setId(@Nullable String id) {
            this.id = id;
        }

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }

        @Nullable
        public Author getAuthor() {
            return author;
        }

        public void setAuthor(@Nullable Author author) {
            this.author = author;
        }

        @Nullable
        public Map<Integer, Collection<String>> getBuckets() {
            return buckets;
        }

        public void setBuckets(@Nullable Map<Integer, Collection<String>> buckets) {
            this.buckets = buckets;
        }

        @Nullable
        public String getDescription() {
            return description;
        }

        public void setDescription(@Nullable String description) {
            this.description = description;
        }
    }

    @Document(indexName = "test-index-person")
    static class Person {

        @Nullable
        @Id
        private String     id;
        @Nullable
        private String     name;
        @Nullable
        @Field(type = FieldType.Nested)
        private List<Car>  car;
        @Nullable
        @Field(type = FieldType.Nested, includeInParent = true)
        private List<Book> books;

        @Nullable
        public String getId() {
            return id;
        }

        public void setId(@Nullable String id) {
            this.id = id;
        }

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }

        @Nullable
        public List<Car> getCar() {
            return car;
        }

        public void setCar(@Nullable List<Car> car) {
            this.car = car;
        }

        @Nullable
        public List<Book> getBooks() {
            return books;
        }

        public void setBooks(@Nullable List<Book> books) {
            this.books = books;
        }
    }

    static class Car {

        @Nullable
        private String name;
        @Nullable
        private String model;

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Nullable
        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }

    @Document(indexName = "test-index-person-multiple-level-nested")
    static class PersonMultipleLevelNested {

        @Nullable
        @Id
        private String           id;
        @Nullable
        private String           name;
        @Nullable
        @Field(type = FieldType.Nested)
        private List<GirlFriend> girlFriends;
        @Nullable
        @Field(type = FieldType.Nested)
        private List<Car>        cars;
        @Nullable
        @Field(type = FieldType.Nested, includeInParent = true)
        private List<Car>        bestCars;

        @Nullable
        public String getId() {
            return id;
        }

        public void setId(@Nullable String id) {
            this.id = id;
        }

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }

        @Nullable
        public List<GirlFriend> getGirlFriends() {
            return girlFriends;
        }

        public void setGirlFriends(@Nullable List<GirlFriend> girlFriends) {
            this.girlFriends = girlFriends;
        }

        @Nullable
        public List<Car> getCars() {
            return cars;
        }

        public void setCars(@Nullable List<Car> cars) {
            this.cars = cars;
        }

        @Nullable
        public List<Car> getBestCars() {
            return bestCars;
        }

        public void setBestCars(@Nullable List<Car> bestCars) {
            this.bestCars = bestCars;
        }
    }

    static class GirlFriend {

        @Nullable
        private String    name;
        @Nullable
        private String    type;
        @Nullable
        @Field(type = FieldType.Nested)
        private List<Car> cars;

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }

        @Nullable
        public String getType() {
            return type;
        }

        public void setType(@Nullable String type) {
            this.type = type;
        }

        @Nullable
        public List<Car> getCars() {
            return cars;
        }

        public void setCars(@Nullable List<Car> cars) {
            this.cars = cars;
        }
    }

    static class Author {

        @Nullable
        private String id;
        @Nullable
        private String name;

        @Nullable
        public String getId() {
            return id;
        }

        public void setId(@Nullable String id) {
            this.id = id;
        }

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }
    }

}