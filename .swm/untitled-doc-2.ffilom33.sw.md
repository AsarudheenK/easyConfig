---
title: Untitled doc (2)
---
# Introduction

This document will walk you through the migration of the <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="11:4:4" line-data="export class CreateEmployeeComponent implements OnInit {">`CreateEmployeeComponent`</SwmToken> class to the latest Angular version. The purpose of this migration is to ensure compatibility with the latest Angular features and improvements.

We will cover:

1. Initialization of the component and its dependencies.
2. Handling of employee data and submission logic.
3. Navigation logic after employee creation.

# Component initialization

<SwmSnippet path="/angular-frontend/src/app/create-employee/create-employee.component.ts" line="13">

---

The <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="11:4:4" line-data="export class CreateEmployeeComponent implements OnInit {">`CreateEmployeeComponent`</SwmToken> is initialized with dependencies injected via the constructor. This includes the <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="14:8:8" line-data="  constructor(private employeeService: EmployeeService,">`EmployeeService`</SwmToken> for handling employee data and the <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="15:6:6" line-data="    private router: Router) { }">`Router`</SwmToken> for navigation purposes. The component also initializes an <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="13:1:1" line-data="  employee: Employee = new Employee();">`employee`</SwmToken> object of type <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="13:4:4" line-data="  employee: Employee = new Employee();">`Employee`</SwmToken>.

```
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService,
    private router: Router) { }
```

---

</SwmSnippet>

# Employee data handling

<SwmSnippet path="/angular-frontend/src/app/create-employee/create-employee.component.ts" line="17">

---

The <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="20:1:1" line-data="  saveEmployee(){">`saveEmployee`</SwmToken> method is crucial for handling the creation of a new employee. It uses the <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="14:8:8" line-data="  constructor(private employeeService: EmployeeService,">`EmployeeService`</SwmToken> to send the employee data to the backend. Upon successful creation, it logs the response and navigates to the employee list. Error handling is also included to log any issues during the process.

```
  ngOnInit(): void {
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }
```

---

</SwmSnippet>

# Navigation and submission logic

<SwmSnippet path="/angular-frontend/src/app/create-employee/create-employee.component.ts" line="28">

---

The <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="28:1:1" line-data="  goToEmployeeList(){">`goToEmployeeList`</SwmToken> method is responsible for navigating to the employee list view after a successful employee creation. The <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="32:1:1" line-data="  onSubmit(){">`onSubmit`</SwmToken> method logs the current employee data and triggers the <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="34:3:3" line-data="    this.saveEmployee();">`saveEmployee`</SwmToken> method, effectively submitting the form data.

```
  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
  
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
}
```

---

</SwmSnippet>

This migration ensures that the <SwmToken path="/angular-frontend/src/app/create-employee/create-employee.component.ts" pos="11:4:4" line-data="export class CreateEmployeeComponent implements OnInit {">`CreateEmployeeComponent`</SwmToken> is up-to-date with the latest Angular standards, maintaining functionality while leveraging improvements in the framework.

<SwmMeta version="3.0.0" repo-id="Z2l0aHViJTNBJTNBZWFzeUNvbmZpZyUzQSUzQUFzYXJ1ZGhlZW5L" repo-name="easyConfig"><sup>Powered by [Swimm](https://app.swimm.io/)</sup></SwmMeta>
