<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈豪
  Date: 2021/1/28
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="pages/script/jquery-1.7.2.js"></script>
<script>
    $(function () {
        $("#button").click(function () {
            var pageNo = $("#pn_input").val();
            if ( pageNo == 0 ) {
                return false;
            } else {
                var url = $("#button").attr("url");
                location = "http://localhost:8080/books/"+ url +"&pageNo=" + pageNo;
            }
        });
        $("#pn_input").change(function () {
            var pageNo = $("#pn_input").val();
            if ( pageNo == 0) {
                alert("请输入正确的页码");
            }
        })
    })
</script>
<div>
        <c:if test="${ requestScope.page.pageNo > 1 }">
            <a href="${requestScope.page.url}&pageNo=1">首页</a>
            <a href="${requestScope.page.url}&pageNo=${ requestScope.page.pageNo-1 }">上一页</a>
        </c:if>
    <c:choose>
        <%-- 当总页面小于等于5的时候 --%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${requestScope.page.pageNo == i}">
                    【${i}】
                </c:if>
                <c:if test="${requestScope.page.pageNo != i}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
    </c:choose>

    <c:choose>
        <%-- 当总页码大于5的时候 --%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%-- 小情况1 前面123页码 --%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${requestScope.page.pageNo == i}">
                            【${i}】
                        </c:if>
                        <c:if test="${requestScope.page.pageNo != i}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%-- 小情况2 8、9、10页码 --%>
                <c:when test="${requestScope.page.pageTotal-3 <= requestScope.page.pageTotal}">
                    <c:forEach begin="${requestScope.page.pageTotal-3}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${requestScope.page.pageNo == i}">
                            【${i}】
                        </c:if>
                        <c:if test="${requestScope.page.pageNo != i}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%-- 小情况3 4567页码  --%>
                <c:otherwise>
                    <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                        <c:if test="${requestScope.page.pageNo == i}">
                            【${i}】
                        </c:if>
                        <c:if test="${requestScope.page.pageNo != i}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }" >
        <a href="${requestScope.page.url}&pageNo=${ requestScope.page.pageNo+1 }">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${ requestScope.page.pageTotal }">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${ param.pageNo }"  id="pn_input" style="width: 30px"/>页
    <input type="button" value="确认" id="button" url="${requestScope.page.url}" />
</div>

