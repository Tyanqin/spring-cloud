package com.tx.common.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TanXiao
 * @date 2022-05-27 13:42
 */
@Component
public class TokenDataSource {

    private static final Map<String,Object> mapData = new HashMap<String,Object>();

    public  TokenDataSource append(String key,Object obj){
          mapData.put(key,obj);
          return this;
    }

//    public  TokenDataSource appendObject(User user){
//       this.append("id",user.getId())
//               .append("userName",user.getUserName())
//               .append("iphone",user.getIphone())
//               .append("perMark",user.getPermission().getPerMark())
//               .append("perName",user.getPermission().getPerName())
//               .append("perLevel",user.getPermission().getPerLevel())
//               .append("deptName",user.getDept().getDeptName())
//               .append("deptCode",user.getDept().getDeptCode())
//               .append("isDetailsBtn",user.getPermission().getIsDetailsBtn())
//               .append("isConfirmBtn",user.getPermission().getIsConfirmBtn())
//               .append("isBackBtn",user.getPermission().getIsBackBtn())
//               .append("isPostBtn",user.getPermission().getIsPostBtn())
//               .append("isUpdateBtn",user.getPermission().getIsUpdateBtn())
//               .append("isDeleteBtn",user.getPermission().getIsDeleteBtn())
//               .append("isInsertBtn",user.getPermission().getIsInsertBtn())
//              .append("isReviewBtn",user.getPermission().getIsReviewBtn());
//        return this;
//    }


    public  Map<String,Object>   build(){
        return mapData;
    }

}
