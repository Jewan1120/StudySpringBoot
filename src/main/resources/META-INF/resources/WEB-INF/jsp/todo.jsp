<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" />
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" />
<title>List Todos Page</title>
</head>
<body>
  <div class="container">
    <h1>Enter Todo Details</h1>
    <!-- 스프링에서 제공하는 form 태그를 이용 -->
    <!-- modelAttribute="파라미터의 이름" -->
    <form:form method="post" modelAttribute="todo">
      <!-- required="required"으로 유효성 체크 가능 -->
      <!-- 유효성 검사는 Server Side에서 구현 -->
      <!-- name 속성 대신 path를 사용해서 빈에 매핑 -->

      <!-- 필드를 그룹화 -->
      <fieldset class="mb-3">
        <form:label path="description">Description</form:label>
        <form:input type="text" path="description" />
        <form:errors path="description" cssClass="text-warning" />
      </fieldset>

      <!-- 필드를 그룹화 -->
      <fieldset class="mb-3">
        <form:label path="targetDate">Target Date</form:label>
        <form:input type="text" path="targetDate" />
        <form:errors path="targetDate" cssClass="text-warning" />
      </fieldset>

      <form:input type="hidden" path="id" />
      <form:input type="hidden" path="done" />
      <input type="submit" class="btn btn-success">
    </form:form>
  </div>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
  <script type="text/javascript">
      $('#targetDate').datepicker({
        format : 'yyyy-mm-dd',
        startDate : '-3d'
      });
  </script>
</body>
</html>