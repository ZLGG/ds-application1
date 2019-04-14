package com.zlg.bs.user.eo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Data
public class UserEo implements Serializable {
    private Long id;
    @Column(name = "account_id")
    private String accountId;
    private String userName;
    private String mobile;
    private String email;
    private String password;
    private Integer role;
    private String roleName;

    private Integer status;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "update_time")
    private String updateTime;
    private Integer dr;


}
