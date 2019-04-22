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
            $("#btn").click(function () {
                var jQuery = $("#tiJiao").serialize();
                console.log(jQuery);
            })
        })

    </script>

</head>
<body>
<form id="tiJiao">
    <c:forEach var="pro" items="${sessionScope.cart}">
        <li>${pro.value}</li><input name="Order" type="checkbox" value="${pro.key}" />
    </c:forEach><br/>
    支付人:<input type="text" name="buyer_name">
    支付电话:<input type="text" name="buyer_name">
    支付地址:<input type="text" name="buyer_name">
    支付账号:<input type="text" name="buyer_name">
</form>
<button type="button" id="btn">提交订单</button>
</body>
</html>