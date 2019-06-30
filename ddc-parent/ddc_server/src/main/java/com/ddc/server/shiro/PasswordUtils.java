package com.ddc.server.shiro;

import com.ddc.server.entity.DDCAdmin;
import com.ddc.server.entity.DDCMember;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;
/**
 * 工具类
 * @author dingpengfei
 */
public class PasswordUtils {

    public static final String ALGORITHM_NAME = "MD5";
    public static final Integer HASH_ITERATIONS = 2;

    public static void entryptPassword(DDCAdmin admin) {
        String salt = admin.getName()+"_"+UUID.randomUUID().toString();
        String temPassword = admin.getPassword();
        Object md5Password = new SimpleHash(ALGORITHM_NAME, temPassword, ByteSource.Util.bytes(salt), HASH_ITERATIONS);
        admin.setSalt(salt);
        admin.setPassword(md5Password.toString());
    }

    public static void entryptPassword(DDCMember member) {
        String salt = "_"+member.getId();
        String temPassword = member.getPassword();
        Object md5Password = new SimpleHash(ALGORITHM_NAME, temPassword, ByteSource.Util.bytes(salt), HASH_ITERATIONS);
        member.setPassword(md5Password.toString());
    }

}