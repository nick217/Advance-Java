<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>


	<form:form action="processForm" modelAttribute="student">
		<!-- When form is loaded Spring MVC will call the getter methods of Student class -->
		First name: <form:input path="firstName" />

		<br>
		<br>
		Last name: <form:input path="lastName" />

		<br>
		<br>
		
		Country: 
		<form:select path="country">
			<!--	<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" />
			-->

			<!--  Populating dropdown values from java class -->
			<form:options items="${student.countryOptions}" />
		</form:select>

		<br>
		<br>
		
		Favourite Language: 
		Java <form:radiobutton path="favouriteLanguage" value="Java" />
		C++<form:radiobutton path="favouriteLanguage" value="C++" />
		PHP <form:radiobutton path="favouriteLanguage" value="PHP" />
		Javascript <form:radiobutton path="favouriteLanguage" value="JS" />
		<br>
		<br>

		Operating Systems:
		Linux<form:checkbox path="operatingSystems" value="Linux" />
		Mac OS<form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
		<br>
		<br>
		<input type="submit" value="Submit" />
		<!-- When form is submitted Spring MVC will call the setter methods of Student class -->
	</form:form>
</body>
</html>