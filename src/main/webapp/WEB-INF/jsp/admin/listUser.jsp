<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2018
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigater.jsp"%>

<script>
</script>

<title>用户管理</title>


<div class="workingArea">
    <h1 class="label label-info" >用户管理</h1>

    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>用户名称</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.userName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>


</div>

<%@include file="../include/admin/adminFooter.jsp"%>
