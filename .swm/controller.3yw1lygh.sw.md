---
title: Controller
---
# Introduction

This document will walk you through the implementation of the <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="26:4:4" line-data="public class EmployeeController {">`EmployeeController`</SwmToken> in a Spring Boot application. The <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="26:4:4" line-data="public class EmployeeController {">`EmployeeController`</SwmToken> is responsible for handling HTTP requests related to employee data management.

/

![](/.swm/images/2025-03-03_10h35_33-2025-2-4-8-33-39-372.png)

We will cover:

1. Why the <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="26:4:4" line-data="public class EmployeeController {">`EmployeeController`</SwmToken> is structured to handle CRUD operations.
2. How the code flow is organized to manage employee data.
3. The class diagram representation of the <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="26:4:4" line-data="public class EmployeeController {">`EmployeeController`</SwmToken>.

# Code flow

## Controller setup

## Dependency injection

<SwmSnippet path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" line="28">

---

The <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="29:3:3" line-data="	private EmployeeRepository employeeRepository;">`EmployeeRepository`</SwmToken> is injected into the controller using <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="28:1:2" line-data="	@Autowired">`@Autowired`</SwmToken>. This allows the controller to interact with the database through the repository.

```
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
```

---

</SwmSnippet>

## Retrieve all employees

<SwmSnippet path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" line="28">

---

The <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="33:8:8" line-data="	public List&lt;Employee&gt; getAllEmployees(){">`getAllEmployees`</SwmToken> method handles GET requests to retrieve all employee records from the database. It uses the <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="29:5:5" line-data="	private EmployeeRepository employeeRepository;">`employeeRepository`</SwmToken> to fetch the data.

```
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
```

---

</SwmSnippet>

## Create a new employee

<SwmSnippet path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" line="37">

---

The <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="39:5:5" line-data="	public Employee createEmployee(@RequestBody Employee employee) {">`createEmployee`</SwmToken> method handles POST requests to add a new employee. It saves the employee data received in the request body to the database.

```
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
```

---

</SwmSnippet>

## Retrieve an employee by ID

<SwmSnippet path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" line="37">

---

The <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="45:8:8" line-data="	public ResponseEntity&lt;Employee&gt; getEmployeeById(@PathVariable Long id) {">`getEmployeeById`</SwmToken> method handles GET requests to fetch a specific employee by their ID. It throws a <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="47:11:11" line-data="				.orElseThrow(() -&gt; new ResourceNotFoundException(&quot;Employee not exist with id :&quot; + id));">`ResourceNotFoundException`</SwmToken> if the employee does not exist.

```
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
```

---

</SwmSnippet>

## Delete an employee

<SwmSnippet path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" line="66">

---

The <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="68:13:13" line-data="	public ResponseEntity&lt;Map&lt;String, Boolean&gt;&gt; deleteEmployee(@PathVariable Long id){">`deleteEmployee`</SwmToken> method handles DELETE requests to remove an employee from the database. It confirms the deletion by returning a response map.

```
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
```

---

</SwmSnippet>

# Class diagram

The <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="26:4:4" line-data="public class EmployeeController {">`EmployeeController`</SwmToken> class diagram would include the following components:

- <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="26:4:4" line-data="public class EmployeeController {">`EmployeeController`</SwmToken>: The main class handling HTTP requests.
  - **Attributes**:
    - <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="29:5:5" line-data="	private EmployeeRepository employeeRepository;">`employeeRepository`</SwmToken>: An instance of <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="19:10:10" line-data="import com.bosch.ec.repository.EmployeeRepository;">`EmployeeRepository`</SwmToken> for database operations.
  - **Methods**:
    - <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="33:8:10" line-data="	public List&lt;Employee&gt; getAllEmployees(){">`getAllEmployees()`</SwmToken>: Retrieves all employees.
    - <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="39:5:5" line-data="	public Employee createEmployee(@RequestBody Employee employee) {">`createEmployee`</SwmToken>`(`\`Employee` `<SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="37:5:5" line-data="	// create employee rest api">`employee`</SwmToken>`)`: Creates a new employee.
    - <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="45:8:8" line-data="	public ResponseEntity&lt;Employee&gt; getEmployeeById(@PathVariable Long id) {">`getEmployeeById`</SwmToken>`(`<SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="45:13:13" line-data="	public ResponseEntity&lt;Employee&gt; getEmployeeById(@PathVariable Long id) {">`Long`</SwmToken>` `<SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="43:9:9" line-data="	// get employee by id rest api">`id`</SwmToken>`)`: Retrieves an employee by ID.
    - <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="54:8:8" line-data="	public ResponseEntity&lt;Employee&gt; updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){">`updateEmployee`</SwmToken>`(`<SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="45:13:13" line-data="	public ResponseEntity&lt;Employee&gt; getEmployeeById(@PathVariable Long id) {">`Long`</SwmToken>` `<SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="43:9:9" line-data="	// get employee by id rest api">`id`</SwmToken>`, `\`Employee` `<SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="54:23:23" line-data="	public ResponseEntity&lt;Employee&gt; updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){">`employeeDetails`</SwmToken>`)`: Updates an employee's details.
    - <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="68:13:13" line-data="	public ResponseEntity&lt;Map&lt;String, Boolean&gt;&gt; deleteEmployee(@PathVariable Long id){">`deleteEmployee`</SwmToken>`(`<SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="45:13:13" line-data="	public ResponseEntity&lt;Employee&gt; getEmployeeById(@PathVariable Long id) {">`Long`</SwmToken>` `<SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="43:9:9" line-data="	// get employee by id rest api">`id`</SwmToken>`)`: Deletes an employee.

This structure ensures that all CRUD operations are efficiently managed within the <SwmToken path="/springboot-backend/src/main/java/com/bosch/ec/controller/EmployeeController.java" pos="26:4:4" line-data="public class EmployeeController {">`EmployeeController`</SwmToken>.

<SwmMeta version="3.0.0" repo-id="Z2l0aHViJTNBJTNBZWFzeUNvbmZpZyUzQSUzQUFzYXJ1ZGhlZW5L" repo-name="easyConfig"><sup>Powered by [Swimm](https://app.swimm.io/)</sup></SwmMeta>
