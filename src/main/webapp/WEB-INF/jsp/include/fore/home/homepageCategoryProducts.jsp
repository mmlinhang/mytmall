<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2018
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="100"/>
</c:if>

<c:if test="${!empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>

<div class="homepageCategoryProducts">
    <c:forEach items="${cs}" var="c" varStatus="stc">
        <c:if test="${stc.count<=categorycount}">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">${c.categoryName}</span>
                <br>
                <c:forEach items="${c.products}" var="p" varStatus="st">
                    <c:if test="${st.count<=5}">
                        <div class="productItem" >
                            <a href="fore_product?productId=${p.id}">
                                <c:if test="${p.firstPid != -1}">
                                    <img width="100px" src="img/productSingle/${p.firstPid}.jpg">
                                </c:if>
                            </a>
                            <a class="productItemDescLink" href="fore_product?productId=${p.id}">
								<span class="productItemDesc">[热销]
								${fn:substring(p.name,0 , 20)}
								</span>
                            </a>
                            <span class="productPrice">
								<fmt:formatNumber type="number" value="${p.discountPrice}" minFractionDigits="2"/>
							</span>
                        </div>
                    </c:if>
                </c:forEach>
                <div style="clear:both"></div>
            </div>
        </c:if>
    </c:forEach>


    <img id="endpng" class="endpng" src="img/site/end.png">

</div>
