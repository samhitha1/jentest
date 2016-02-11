<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%>

<!doctype html>
<html ng-app="tar" id="ng-app">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Administration and Registration Tools - Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>   
    <jsp:include page="includes/exploded/css-includes.jsp"></jsp:include>
    <script src="resources/js/nothing.js"></script>
</head>
  
<body>
    <input type="hidden" id="baseUrl" value="${baseUrl}" />
       <div class="container" >
          <div class="header">
            <div class="info" >
                <ul >
                                                                          
                     <li>Logged in as: 
                         Admin
                     </li>
                   

                </ul>
            </div>
            <div class="banner" data-ng-controller="HomeController">                           
                    <span class="logo"><a href="#" data-ng-click="go('/')")><img data-ng-src="resources/images/ancientagro-logo.png" class="thumbnail" alt="Logo" name="SBAC_logo"></a></span>
                           
                    
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="content" data-ng-controller="HomeController">
                <div data-ui-view="testregview"></div>
        </div>
       <jsp:include page="includes/exploded/js-includes.jsp"></jsp:include>
       <jsp:include page="includes/exploded/custom-js-includes.jsp"></jsp:include>
      
</body>
    
</html>
