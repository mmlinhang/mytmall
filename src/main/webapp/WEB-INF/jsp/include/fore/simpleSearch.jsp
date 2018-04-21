<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/15/2018
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" isELIgnored="false" %>

<div >
    <a href="${contextPath}">
        <img id="simpleLogo" class="simpleLogo" src="img/site/simpleLogo.png">
    </a>

    <form action="foresearch" method="post" >
        <div class="simpleSearchDiv pull-right">
            <input type="text" placeholder="平衡车 原汁机"  value="${param.keyword}" name="keyword">
            <button class="searchButton" type="submit">搜天猫</button>
            <div class="searchBelow">
                <c:forEach items="${cs}" var="c" varStatus="st">
                    <c:if test="${st.count>=5 and st.count<=8}">
					<span>
						<a href="fore_categoryId">
                                ${c.name}
                        </a>
						<c:if test="${st.count!=8}">
                            <span>|</span>
                        </c:if>
					</span>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </form>
    <div style="clear:both"></div>
</div>