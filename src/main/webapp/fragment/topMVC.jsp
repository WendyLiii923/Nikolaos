<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value='/css/eDM.css' />" rel="stylesheet"
  type="text/css" />
<script src="<c:url value='/javascript/jquery-1.9.1.js' />"></script>
<link href="<c:url value='/javascript/eDM.js' />" rel="stylesheet"
  type="text/css" />

<c:set var='debug' value='true' scope='application' />
<table class='menuOuter'>
  <tr height="48px">
    <td width="60px" rowspan='2'><img width="60px" height="40px"
      src="<c:url value='/images/BookStore.gif' />">
	</td>
    <td>
      <table class='menuInner'>
        <tr>
          <td class='menuData'>
            <div class='menu'>
              <c:if test="${empty LoginOK}">
<%--                 <a href="<c:url value='/_02_login/login.jsp' />"> 登入 </a> --%>
                <a href="<c:url value='/_02_login/login' />"> 登入 </a>
              </c:if>
            </div>
          </td>
          <td class='menuData'>
            <div class='menu'>
              <c:choose>
                <c:when test="${ funcName != 'SHO' }">
                  <a href="<c:url value='/_03_listBooks/DisplayPageProducts' />">
                    購物 
			      </a>
                </c:when>
                <c:otherwise>
                    購物
                </c:otherwise>
              </c:choose>
            </div>
          </td>
          <td class='menuData'>
            <div class='menu'>
              <c:choose>
                <c:when test="${ funcName != 'CHE' }">
                  <a
<%--                     href="<c:url value='/_04_ShoppingCart/ShowCartContent.jsp' />"> --%>
                    href="<c:url value='/_04_ShoppingCart/ShowCartContent' />">
                    結帳 
				  </a>
                </c:when>
                <c:otherwise>
                     結帳 
                </c:otherwise>
              </c:choose>

            </div>
          </td>
          <td class='menuData'>
            <div class='menu'>
              <c:choose>
                <c:when test="${ funcName != 'ORD' }">
                  <a href="<c:url value='/_05_orderProcess/orderList.do' />">
                    訂單 </a>
                </c:when>
                <c:otherwise>
                      訂單
                </c:otherwise>
              </c:choose>
            </div>
          </td>
          <td class='menuData'>
            <div class='menu'>
              <c:choose>
                <c:when test="${ funcName != 'BMT' }">
                  <a
                    href="<c:url value='/_20_productMaintain/DisplayPageProducts' />">
                    維護 </a>
                </c:when>
                <c:otherwise>
                      維護
                </c:otherwise>
              </c:choose>
            </div>
          </td>
          <td class='menuData'>
            <div class='menu'>&nbsp;</div>
          </td>

          <td class='menuData'>
            <div class='menu'>
              <c:choose>
                <c:when test="${ funcName != 'REG' }">
<%--                   <a href="<c:url value='/register/register.jsp' />"> 註冊 --%>
                  <a href="<c:url value='/register/register' />"> 註冊
                  </a>
                </c:when>
                <c:otherwise>
                      註冊
                </c:otherwise>
              </c:choose>

            </div>
          </td>
          <td class='menuData'>
            <div class='menu' style='width: 50px;'>
              <c:if test="${ funcName != 'IND' }">
<%--                 <a href="<c:url value='/index.jsp' />"> 回首頁 </a> --%>
                <a href="<c:url value='/' />"> 回首頁 </a>
              </c:if>
            </div>
          </td>
          <c:choose>
            <c:when test="${ ! empty LoginOK }">
              <td class='menuData'>
                <div class='menu'>
<%--                   <a href="<c:url value='/_02_login/logout.jsp' />"> 登出 </a> --%>
                  <a href="<c:url value='/_02_login/logout' />"> 登出 </a>
                </div>
              </td>
              <td class='menuData' rowspan='2'><img height='40px'
                width='30px'
                src="<c:url value='/_00_init/getMemberImage?id=${LoginOK.memberId}' />">
              </td>
            </c:when>
            <c:otherwise>
              <td class='menuData'></td>
              <td class='menuData'></td>
            </c:otherwise>
          </c:choose>
        </tr>
        <tr height='20px'>
          <td width='300px' colspan='9'><small>${pageContext.session.id}</small>
          </td>
        </tr>
      </table>
  <tr>
    <td>
      <hr style="color: #f00; background-color: #f00; height: 2px;">
    </td>
  </tr>
</table>