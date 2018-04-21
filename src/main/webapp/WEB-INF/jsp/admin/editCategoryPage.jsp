<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/6/2018
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8"%>

<%@include file="../include/admin/adminHeader.jsp"%>

<script>
    $(function(){
        $("#editForm").submit(function(){
            if(!checkEmpty("name", "分类名称"))
                return false;
            return true;
        })
    })
</script>

    <div class="workingArea">

        <ol class="breadcrumb">
            <li><a href="admin_category_list">所有分类</a></li>
            <li class="active">编辑分类</li>
        </ol>

        <div class="panel panel-warning editDiv">
            <div class="panel-heading">编辑分类</div>
            <div class="panel-body">
                <form method="post" id="editForm" action="admin_category_edit"  enctype="multipart/form-data">
                    <table class="editTable">
                        <tr>
                            <td>分类名称</td>
                            <td><input  id="name" name="categoryName" value="${c.categoryName}" type="text" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>分类圖片</td>
                            <td>
                                <input id="categoryPic" accept="image/*" type="file" name="image" />
                            </td>
                        </tr>
                        <tr class="submitTR">
                            <td colspan="2" align="center">
                                <input type="hidden" name="categoryId" value="${c.categoryId}">
                                <button type="submit" class="btn btn-success">提 交</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
