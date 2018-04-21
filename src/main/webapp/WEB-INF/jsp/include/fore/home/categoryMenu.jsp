<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2018
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<div class="categoryMenu">
    <c:forEach items="${cs}" var="c">
        <div cid="${c.categoryId}" class="eachCategory">
            <span class="glyphicon glyphicon-link">
                <a href="fore_category?cid=${c.categoryId}">
                    ${c.categoryName}
                </a>
            </span>
        </div>
    </c:forEach>
</div>
