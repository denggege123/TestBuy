package com.java1234.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ����������
 * @author Administrator
 *
 */
public class NavUtil {

	/**
	 * ���ɵ�������
	 * @param subName
	 * @return
	 */
	public static String genNavCode(String subName,HttpServletRequest request){
		StringBuffer navCode=new StringBuffer();
		navCode.append("�����ڵ�λ�ã�");
		navCode.append("<a href='"+request.getContextPath()+"/index.jsp'>��ҳ</a>&nbsp;");
		navCode.append("&gt; ");
		navCode.append(subName);
		return navCode.toString();
	}
}
