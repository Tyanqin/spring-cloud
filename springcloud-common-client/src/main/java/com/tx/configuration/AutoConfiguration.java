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

package com.tx.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * 配置Redis 为获取key做准备
 */
@Configuration
//@ComponentScan({"cn.turing.ml.rice.auth.client","com.github.ag.core","cn.turing.ml.rice.common.util"})
public class AutoConfiguration {

//    @Bean
//    SiteAuthConfig getServiceAuthConfig(){
//        return new SiteAuthConfig();
//    }
//
//    @Bean
//    UserAuthConfig getUserAuthConfig(){
//        return new UserAuthConfig();
//    }

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate template = new RedisTemplate();
//        template.setConnectionFactory(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
}
