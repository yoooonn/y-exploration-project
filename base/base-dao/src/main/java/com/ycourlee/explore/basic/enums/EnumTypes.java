package com.ycourlee.explore.basic.enums;

/**
 * @author yongjiang
 * @date 2021.03.14
 */
public class EnumTypes {

    public enum Gender {
        /**
         * 男性
         */
        MALE((byte) 1, "男"),
        /**
         * 女性
         */
        FEMALE((byte) 2, "女"),
        ;

        private final Byte   code;
        private final String name;

        Gender(Byte code, String name) {
            this.code = code;
            this.name = name;
        }

        public Byte getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }


    public enum MovieType {

        /**
         * 动作
         */
        ACTION((byte) 1, "action"),
        /**
         * 科幻
         */
        SCI_FI((byte) 2, "sci-fi"),
        /**
         * 冒险
         */
        ADVENTURE((byte) 3, "adventure"),
        /**
         * 战争
         */
        WAR((byte) 4, "war"),
        /**
         * 喜剧
         */
        COMEDY((byte) 5, "comedy"),
        /**
         * 动画
         */
        ANIMATED((byte) 6, "animated"),
        /**
         * 奇幻
         */
        FANTASY((byte) 7, "fantasy"),
        /**
         * 爱情
         */
        LOVE((byte) 7, "love"),
        ;

        private final Byte   code;
        private final String name;

        MovieType(Byte code, String name) {
            this.code = code;
            this.name = name;
        }

        public Byte getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
