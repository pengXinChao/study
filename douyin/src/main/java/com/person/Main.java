package com.person;

import com.doudian.open.core.AccessToken;
import com.doudian.open.core.AccessTokenBuilder;
import com.doudian.open.core.GlobalConfig;

/**
 * @author 彭心潮
 * @date ${DATE} ${TIME}
 */
public class Main {

    public static void main(String[] args) {
        //设置appKey和appSecret，全局设置一次
        GlobalConfig.initAppKey("7146470228656932383");
        GlobalConfig.initAppSecret("154771e6-da29-403d-a76a-f55f562743df");
        //入参为shopId
        AccessToken accessToken = AccessTokenBuilder.build(7630771L);
//        AccessToken accessToken = AccessTokenBuilder.build(7630771L);
        System.out.println("Token:" + accessToken.getAccessToken());
    }
}