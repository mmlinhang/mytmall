<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2018
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<a href="${contextPath}">
    <img id="logo" src="img/site/logo.gif" class="logo">
</a>

<form action="foresearch" method="post" >
    <div class="searchDiv">
        <input name="keyword" type="text" value="" placeholder="时尚男鞋  太阳镜 ">
        <button  type="submit" class="searchButton">搜索</button>
        <div class="searchBelow">
            <c:forEach items="${cs}" var="c" varStatus="st">
                <c:if test="${st.count >= 5 and st.count <= 8}">
                    <a href="fore_category?cid=${c.categoryId}">
                            ${c.categoryName}
                    </a>
                    <c:if test="${st.count != 8}">
                        <span>|</span>
                    </c:if>
                </c:if>

            </c:forEach>
        </div>
    </div>
</form>

