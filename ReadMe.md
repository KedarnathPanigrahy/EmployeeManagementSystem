1. Please Configure the data base properties in the application.properties (src/main/resources) file.
	# spring.datasource.url=jdbc:mysql://Host:Port/Schema_name (for Ex. jdbc:mysql://localhost:3306/Schema_name)
  	# spring.datasource.username=User_Name
	# spring.datasource.password=Password
	
2. Do maven clean and install.
3. Run the application.
4. Try to hit the apis
	-> For register :
		  URL : http://host_address:port/employee/create
		  Method : Post
		  Body : {
				    "firstName" : "firstName",
				    "lastName" : "lastName",
				    "gender" : "gender",
				    "dateOfBirth" : "dateOfBirth",
				    "department" : "department"
				  }
	-> For getting Employee list :
	      URL : http://host_address:port/employee/getList
	      Method : Get
	
		