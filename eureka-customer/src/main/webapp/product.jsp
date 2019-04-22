<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $.post("${pageContext.request.contextPath}/product/list",function (result) {
                console.log(result);
                $.each(result.data,function (i,info) {
                    console.log(info);
                    var li=$("<li><b>"+info.name+"</b></li>");
                    var vl=$("<ul/>");
                    $.each(info.foods,function (j,pro) {
                        console.log(pro);
                        var li1=$("<li onclick=add("+pro.id+");>"+pro.name+"</li>");
                        vl.append(li1);
                    })
                    li.append(vl);
                    $("#product").append(li);
                })

            })
        })
    function add(id) {
        $.post("${pageContext.request.contextPath}/car/add","id="+id,function (result) {
            if(result!=null){
                alert("添加购物车成功");
            }else {
                alert("添加购物车失败");
            }
        })
    }
    </script>

</head>
<body>
<div id="product">

</div>
</body>
</html>