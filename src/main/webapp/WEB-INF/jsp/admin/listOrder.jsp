<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2018
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigater.jsp"%>

<script>
    $(function(){
        $("button.orderPageCheckOrderItems").click(function()
        {
            var oid = $(this).attr("oid");
            $("tr.orderPageOrderItemTR[oid="+oid+"]").toggle();
        })
    })

</script>

<title>订单管理</title>


<div class="workingArea">
    <h1 class="label label-info" >订单管理</h1>
    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover1  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>状态</th>
                <th>金额</th>
                <th width="100px">商品数量</th>
                <th width="100px">买家名称</th>
                <th>创建时间</th>
                <th>支付时间</th>
                <th>发货时间</th>
                <th>确认收货时间</th>
                <th width="120px">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="o">
                <tr>
                    <td>${o.id}</td>
                    <c:if test="${o.state == 1}">
                        <td>待付款</td>
                    </c:if>
                    <c:if test="${o.state == 2}">
                        <td>待发货</td>
                    </c:if>
                    <c:if test="${o.state == 3}">
                        <td>待收货</td>
                    </c:if>
                    <c:if test="${o.state == 4}">
                        <td>待评价</td>
                    </c:if>
                    <c:if test="${o.state == 5}">
                        <td>完成</td>
                    </c:if>

                    <td>￥<fmt:formatNumber type="number" minFractionDigits="2" value="${o.totalPrice}"/></td>
                    <td align="center">${o.totalNum}</td>
                    <td align="center">${o.user.userName}</td>

                    <td><fmt:formatDate value="${o.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${o.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${o.deliverTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${o.confirmTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

                    <td>
                        <button oid=${o.id} class="orderPageCheckOrderItems btn btn-primary btn-xs">查看详情</button>

                        <c:if test="${o.state==2}">
                            <a href="admin_order_delivery?id=${o.id}">
                                <button class="btn btn-primary btn-xs">发货</button>
                            </a>
                        </c:if>
                    </td>
                </tr>
                <tr class="orderPageOrderItemTR"  oid=${o.id}>
                    <td colspan="10" align="center">

                        <div  class="orderPageOrderItem">
                            <table width="800px" align="center" class="orderPageOrderItemTable">
                                <c:forEach items="${o.ois}" var="oi">
                                    <tr>
                                        <td align="left">
                                            <img width="40px" height="40px" src="img/productSingle/${oi.product.firstPid}.jpg">
                                        </td>

                                        <td>
                                            <a href="foreproduct?pid=${oi.product.id}">
                                                <span>${oi.product.name}</span>
                                            </a>
                                        </td>
                                        <td align="right">

                                            <span class="text-muted">${oi.totalNum}个</span>
                                        </td>
                                        <td align="right">

                                            <span class="text-muted">单价：￥${oi.product.discountPrice}</span>
                                        </td>

                                    </tr>
                                </c:forEach>

                            </table>
                        </div>

                    </td>
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
