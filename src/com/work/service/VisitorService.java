package com.work.service;

import org.springframework.stereotype.Service;

import com.work.exception.UserException;
import com.work.model.User;
import com.work.utils.StrUtil;
import com.work.utils.ValidateUtils;

/**
 * 游客Service
 * 
 * @author 张昊
 * @date 2016年8月7日
 */
@Service
public class VisitorService extends SuperService{

	/**
	 * 用户登陆方法
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws UserException
	 * @author 张昊
	 * @date 2016年8月7日
	 */
	public User login(String userName,String passWord) throws UserException{
		//1.验证参数
		if(StrUtil.isEmpty(userName)||StrUtil.isEmpty(passWord)){
			throw new UserException("登录参数不全");
		}
		//2.查看用户是否存在
		User db_User = userDAO.getByUserName(userName);
		if(db_User==null)
			throw new UserException("用户不存在");
		//3.查看用户密码是否正确
		if(!db_User.getPassword().equals(passWord)){
			throw new UserException("用户密码不正确");
		}
		return db_User;
	}
	
	
	/**
	 * 注册用户
	 * @param form_User
	 * @return
	 * @author 张昊
	 * @date 2016年8月7日
	 */
	public void register(User form_User) throws UserException{
		//1.验证参数
		if(form_User==null||StrUtil.isEmpty(form_User.getUserName())
				||StrUtil.isEmpty(form_User.getPassword())){
			throw new UserException("注册参数不全");
		}else if(!ValidateUtils.isPhoneNum(form_User.getPhoneNum())){
			throw new UserException("手机号格式不正确");
		}else if(!ValidateUtils.isChineseName(form_User.getRealName())){
			throw new UserException("姓名请使用中文名");
		}else if(!ValidateUtils.isEnglishName(form_User.getUserName())){
			throw new UserException("用户名请使用英文字母");
		}
		//2.查看用户是否存在
		User db_User = userDAO.getByUserName(form_User.getUserName());
		if(db_User!=null)
			throw new UserException("用户已存在");
		//3.保存
		userDAO.save(form_User);
	}
	
}
