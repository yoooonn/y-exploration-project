create table actor
(
    id          bigint auto_increment
        primary key,
    code        varchar(50)  default ''                not null comment '编号',
    name        varchar(200) default ''                not null comment '姓名',
    age         int          default 0                 not null comment '年龄',
    sex         tinyint      default 1                 not null comment '1 female; 2 mail',
    birthday    date                                   null comment '生日',
    memo        text                                   not null comment '备注',
    create_time datetime     default CURRENT_TIMESTAMP not null comment '记录创建时间',
    update_time datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '记录更新时间',
    was_delete  tinyint      default 0                 not null comment '记录是否删除'
)
    comment '演员表' charset = utf8mb4;

create table actor_country
(
    id          bigint auto_increment
        primary key,
    actor_id    bigint   default 0                 not null comment '演员id',
    country_id  int      default 0                 not null comment '国家id',
    memo        text                               not null comment '备注',
    create_time datetime default CURRENT_TIMESTAMP not null comment '记录创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '记录更新时间',
    was_delete  tinyint  default 0                 not null comment '记录是否删除'
)
    comment '演员国家关系表' charset = utf8mb4;

create table actor_movie
(
    id          bigint auto_increment
        primary key,
    actor_id    bigint   default 0                 not null comment '演员id',
    movie_id    bigint   default 0                 not null comment '电影id',
    memo        text                               not null comment '备注',
    create_time datetime default CURRENT_TIMESTAMP not null comment '记录创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '记录更新时间',
    was_delete  tinyint  default 0                 not null comment '记录是否删除'
)
    comment '演员电影关系表' charset = utf8mb4;

create table country
(
    id               int auto_increment
        primary key,
    code             varchar(50)  default ''                not null comment '编码',
    language         varchar(50)  default ''                not null comment '使用语言',
    capital          varchar(200) default ''                not null comment '首都',
    universal_region varchar(100) default ''                not null comment '世界地理区域',
    memo             text                                   not null comment '备注',
    create_time      datetime     default CURRENT_TIMESTAMP not null comment '记录创建时间',
    update_time      datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '记录更新时间',
    was_delete       tinyint      default 0                 not null comment '记录是否删除'
)
    comment '国家表' charset = utf8mb4;

create table movie
(
    id               bigint auto_increment
        primary key,
    code             varchar(50)  default ''                not null comment '电影编码',
    name             varchar(200) default ''                not null comment '电影名称',
    type             tinyint      default 0                 not null comment '电影类型',
    memo             text                                   not null comment '描述',
    release_datetime datetime     default CURRENT_TIMESTAMP not null comment '上映时间',
    post_date        date                                   null comment '发布时间',
    create_time      datetime     default CURRENT_TIMESTAMP not null comment '记录创建时间',
    update_time      datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '记录更新时间',
    was_delete       tinyint      default 0                 not null comment '记录是否删除'
)
    comment '电影表' charset = utf8mb4;

