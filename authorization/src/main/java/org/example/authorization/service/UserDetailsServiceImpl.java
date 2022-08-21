package org.example.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 自定义登录的用户名和密码
 *
 * 框架默认
 * 用户名：user
 * 密码：项目启动时打印在控制台
 * 密码示例：Using generated security password: 20577576-510c-46ed-997d-4a7d9691df9f
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //1.验证用户是否存在
        if(!"admin".equals(userName)){
            throw new UsernameNotFoundException("userName不存在");
        }
        //2.验证密码是否正确
        String psencode = passwordEncoder.encode("123");

        //前缀时ROLE表示的是角色，在使用的时候需要去掉前缀
        return new User(userName,psencode,
                AuthorityUtils
                        .commaSeparatedStringToAuthorityList("admin,normal,ROLE_abc,/main.html"));
    }
}
