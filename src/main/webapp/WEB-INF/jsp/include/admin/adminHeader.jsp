<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/5/2018
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="css/back/style.css" rel="stylesheet"/>
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet"/>

    <script>
        function checkEmpty(id, name) {
            var value = $("#"+id).val();
            if(value.length == 0)
            {
                alert(name + "的值不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }

        function checkNumber(id, name)
        {
            if(!checkEmpty(id, name))
            {
                return false;
            }
            var value = $("#"+id).val();
            if(isNaN(value))
            {
                alert(name+"的值必须为数字");
                $("#"+id)[0].focus();
                return false;
            }

            return true;
        }

        function checkInt(id, name)
        {
            if(!checkEmpty(id, name))
            {return false;}

            var value = $("#"+id).val();
            if(parseInt(value) != value)
            {
                alert(name+"的值必须为整数");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }

        $(function(){

            $("a").click(function(){
                var deleteLink = $(this).attr("deleteLink");
                if(deleteLink == "true")
                {
                    var v = confirm("确定要删除?");
                    if(v)
                        return true;
                    return false;
                }
            })

        })
    </script>
</head>
<body>