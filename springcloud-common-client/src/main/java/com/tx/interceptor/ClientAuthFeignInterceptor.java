/*
 *  Copyright (C) 2018  Wanghaobin<463540703@qq.com>

 *  AG-Enterprise 企业版源码
 *  郑重声明:
 *  如果你从其他途径获取到，请告知老A传播人，奖励1000。
 *  老A将追究授予人和传播人的法律责任!

 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.

 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.

 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.tx.interceptor;

import com.tx.common.handler.BaseContextHandler;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 站点级别的拦截，可对feign拦击
 * @author malong
 * @version 2017/9/12
 */
public class ClientAuthFeignInterceptor implements RequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(ClientAuthFeignInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            Integer type = BaseContextHandler.getTokenType();
            String header = "";
            String token = BaseContextHandler.getToken();
            if(type == 1){
                header = "center-auth";
            }
            if(type == 2){
                header = "site-auth";
            }
            if(type == 3){
                header = "Authorization";
            }
            requestTemplate.header(header, token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
