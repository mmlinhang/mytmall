<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2018
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
    $(function(){
        $("div.productsAsideCategorys div.row a").each(function(){
            var v = Math.round(Math.random() *6);
            if(v == 1)
                $(this).css("color","#87CEFA");
        });
    });

</script>

<c:forEach items="${cs}" var="c">
    <div cid="${c.categoryId}" class="productsAsideCategorys">

    <c:forEach items="${c.productsByRows}" var="ps">
        <div class="row show1">
        <c:forEach items="${ps}" var="p">
            <c:if test="${!empty p.subTitle}">
                <a href="fore_product?productId=${p.id}">
                <c:forEach items="${fn:split(p.subTitle, ' ')}" var="title" varStatus="st">
                    <c:if test="${st.index==0}">
                        ${title}
                    </c:if>
                </c:forEach>
                </a>
            </c:if>
        </c:forEach>
        <div class="seperator"></div>
        </div>
    </c:forEach>
    </div>
</c:forEach>

