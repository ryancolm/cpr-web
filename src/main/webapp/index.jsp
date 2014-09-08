<%--
  Created by IntelliJ IDEA.
  User: colm.ryan
  Date: 29/08/2014
  Time: 08:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="CPRWebApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="CPRWebApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="CPRWebApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="CPRWebApp" class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>CPR Web App</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app.css"/>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>

  <!--
  included scripts with pageContext
-->
  <script src="${pageContext.request.contextPath}/resources/js/angular.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/angular-route.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/angular-resource.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/services.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/filters.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/directives.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/xml2json.js" type="text/javascript" language="javascript"></script>

</head>
<body>

<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please upgrade your browser</a> to improve your experience.</p>
<![endif]-->


<div id='cssmenu'>
  <ul>
    <li><a href='hello.do'><span>Greet</span></a></li>
    <li class='active has-sub'><a href='#'><span>Simple JSON</span></a>
      <ul>
        <li class='has-sub'><a href='#'><span>JSON Test API (Working)</span></a>
          <ul>
            <li><a href='#/ipAddress'><span>IP Address</span></a></li>
            <li class='last'><a href='#/headers'><span>Headers</span></a></li>
          </ul>
        </li>
        <li class='has-sub'><a href='#'><span>JSON Test API (Not Working)</span></a>
          <ul>
            <li><a href='#/dateAndTime'><span>Date & Time</span></a></li>
            <li class='last'><a href='#'><span>Other</span></a></li>
          </ul>
        </li>
      </ul>
    </li>
    <li class='has-sub'><a href='#'><span>Irish Rail</span></a>
      <ul>
        <li><a href='currentTrains.do'><span>Current Trains</span></a></li>
        <li class='last'><a href='#'><span>Other</span></a></li>
      </ul>
    </li>
    <li><a href='#'><span>About</span></a></li>
    <li class='last'><a href='#'><span>Contact</span></a></li>
  </ul>






</div>

<!-- the partials are displayed here -->
<div ng-view></div>

<div>cpr app: v<span app-version></span></div>


</body>
</html>
