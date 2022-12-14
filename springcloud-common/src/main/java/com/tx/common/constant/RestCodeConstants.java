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

package com.tx.common.constant;

/**
 * rest接口返回码
 *
 * @author ace
 * @version 2017/8/23
 */
public class RestCodeConstants {
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40101;
    public static final Integer EX_USER_FORBIDDEN_CODE = 40131;

    // site token异常
    public static final Integer EX_SITE_INVALID_CODE = 40301;
    public static final Integer EX_SITE_FORBIDDEN_CODE = 40331;

    // center token 异常
    public static final Integer EX_CENTER_INVALID_CODE = 40501;
    public static final Integer EX_CENTER_FORBIDDEN_CODE = 40531;

    // 业务异常返回码
    public static final Integer EX_BUSINESS_BASE_CODE = 30101;
    public static final int EX_USER_DOSE_NOT_EXIST = 30102;
}
