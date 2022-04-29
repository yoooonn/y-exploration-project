package com.ycourlee.explore.notes.bootweb.model.request;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
@Setter
@Getter
@ToString
public class FollowRequest {

    private JSONObject follows;
}
