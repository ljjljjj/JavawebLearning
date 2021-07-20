package com.bjpowernode;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jiaozi_money=30;
        int gaifan_money=15;
        int miantiao_money=20;
        String food,userName = null;
        Integer money=0,xiaofei=0,balance=0;
        Cookie cookieArray[]=null;
        Cookie newcard = null;

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //1.读取请求头参数信息，得到用户点餐食物类型
        food = request.getParameter("food");
        //2.读取请求头中的Cookie
        cookieArray = request.getCookies();
        //3.刷卡消费
        for (Cookie card:cookieArray){
            String key = card.getName();
            String value = card.getValue();
            if ("userName".equals(key)){
                userName = value;
            }else if ("money".equals(key)){
                money = Integer.valueOf(value);
                if ("饺子".equals(food)){
                    if (jiaozi_money > money){
                        out.print("用户："+userName+"余额不足，请充值");
                    }else{
                        newcard = new Cookie("money",(money-jiaozi_money)+"");
                        xiaofei = jiaozi_money;
                        balance = money-jiaozi_money;
                    }
                }else if ("面条".equals(food)){
                    if (miantiao_money > money){
                        out.print("用户："+userName+"余额不足，请充值");
                    }else {
                        newcard = new Cookie("money",(money-miantiao_money)+"");
                        xiaofei = miantiao_money;
                        balance = money-miantiao_money;
                    }
                }else if ("盖饭".equals(food)){
                    if (gaifan_money > money) {
                        out.print("用户：" + userName + "余额不足，请充值");
                    }else {
                        newcard = new Cookie("money",(money-gaifan_money)+"");
                        xiaofei = gaifan_money;
                        balance = money-gaifan_money;
                    }
                }
            }
        }
        //4.将用户会员卡返还
        response.addCookie(newcard);
        //5.将消费记录写入到响应体
        out.print("用户："+userName+"<br/>本次消费："+xiaofei+"<br/>余额为："+balance);
    }
}
