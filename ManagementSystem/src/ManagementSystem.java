//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class com1_3 {
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        ProjectManagementApp.run(scanner);
//        EmployeeManagementApp.run(scanner);
//        ProjectManagementApp.assignEmployeesToProjects(scanner);
//        scanner.close();
//    }
//}
//
//class ProjectManagementApp {
//    private static int projectIdCounter = 1;
//    private static List<Project> projects = new ArrayList<>();
//
//    public static void run(Scanner scanner) {
//        while (true) {
//            String projectName = promptInput("Enter Project Name:", scanner);
//            String projectDescription = promptInput("Enter Project Description:", scanner);
//            String startDate = promptInput("Enter Start Date (dd-mm-yyyy):", scanner);
//            String endDate = promptInput("Enter End Date (dd-mm-yyyy):", scanner);
//            projects.add(new Project(projectIdCounter++, projectName, projectDescription, startDate, endDate));
//            String response = promptInput("Do you want to enter another project? (yes/no)", scanner);
//            if (response.equalsIgnoreCase("no")) {
//                break;
//            }
//        }
//        System.out.println("All entered projects:");
//        for (Project project : projects) {
//            System.out.println(project);
//        }
//    }
//
//    private static String promptInput(String message, Scanner scanner) {
//        System.out.println(message);
//        return scanner.nextLine();
//    }
//    
//    public static void assignEmployeesToProjects(Scanner scanner) {
//        while (true) {
//        	try {
//                int projectId = Integer.parseInt(promptInput("Enter Project ID to assign employees:", scanner));
//                if (projectId <= 0) {
//                    System.out.println("Invalid Project ID. Please enter a positive number.");
//                    continue;
//                }
//
//                Project project = findProjectById(projectId);
//                if (project == null) {
//                    System.out.println("Project not found!");
//                    continue;
//                }
//        	
//            
//                int employeeId = Integer.parseInt(promptInput("Enter Employee ID:", scanner));
//                if (employeeId <= 0) {
//                    System.out.println("Invalid Employee ID. Please enter a positive number.");
//                    continue;
//                }
//
//                Employee employee = EmployeeManagementApp.findEmployeeById(employeeId);
//                if (employee == null) {
//                    System.out.println("Employee not found!");
//                    continue;
//                }
//
//                String role = promptInput("Enter Role in the project:", scanner);
//                project.assignEmployee(employee, role);
//
//                String response = promptInput("Do you want to assign another employee to a project? (yes/no)", scanner);
//                if (response.equalsIgnoreCase("no")) {
//                    break;
//                }
//                
//            } catch (NumberFormatException ex) {
//                System.out.println("Invalid input. Please enter a valid number for ID.");
//            }
//        	
//        }
//    }
//    
//
//    private static Project findProjectById(int id) {
//        for (Project project : projects) {
//            if (project.getProjectId() == id) {
//                return project;
//            }
//        }
//        return null;
//    }
//}
//
//class Project {
//    private int projectId;
//    private String projectName;
//    private String projectDescription;
//    private String startDate;
//    private String endDate;
//    
//    private List<ProjectEmployeeAssignment> assignments = new ArrayList<>();
//    
//    public int getProjectId() {
//        return projectId;
//    }
//    
//    public Project(int projectId, String projectName, String projectDescription, String startDate, String endDate) {
//        this.projectId = projectId;
//        this.projectName = projectName;
//        this.projectDescription = projectDescription;
//        this.startDate = startDate;
//        this.endDate = endDate;
//    }
//    
//    public void assignEmployee(Employee employee, String role) {
//        assignments.add(new ProjectEmployeeAssignment(employee, role));
//    }
//    
//    
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Project ID: ").append(projectId)
//            .append("\nProject Name: ").append(projectName)
//            .append("\nProject Description: ").append(projectDescription)
//            .append("\nStart Date: ").append(startDate)
//            .append("\nEnd Date: ").append(endDate)
//
//        for (ProjectEmployeeAssignment assignment : assignments) {
//            sb.append(assignment).append("\n");
//        }
//        return sb.toString();
//    }
//} 
//
//class ProjectEmployeeAssignment {
//    private Employee employee;
//    private String role;
//
//    public ProjectEmployeeAssignment(Employee employee, String role) {
//        this.employee = employee;
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return employee.getFullName() + " - Role: " + role;
//    }
//}
//
//
//class EmployeeManagementApp {
//    private static int employeeIdCounter = 1;
//    private static List<Employee> employees = new ArrayList<>();
//
//    public static void run(Scanner scanner) {
//        while (true) {
//            String employeeFirstName = promptInput("Enter Employee First Name:", scanner);
//            String employeeLastName = promptInput("Enter Employee Last Name:", scanner);
//            String department = promptInput("Enter Department:", scanner);
//            String role = promptInput("Enter Role:", scanner);
//            employees.add(new Employee(employeeIdCounter++, employeeFirstName, employeeLastName, department, role));
//            String response = promptInput("Do you want to enter another employee? (yes/no)", scanner);
//            if (response.equalsIgnoreCase("no")) {
//                break;
//            }
//        }
//        System.out.println("All entered employees:");
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//    }
//
//    private static String promptInput(String message, Scanner scanner) {
//        System.out.println(message);
//        return scanner.nextLine();
//    }
//    
//    public static Employee findEmployeeById(int id) {
//        for (Employee employee : employees) {
//            if (employee.getEmployeeId() == id) {
//                return employee;
//            }
//        }
//        return null;
//    }
//}
//
//
//class Employee {
//    private int employeeId;
//    private String employeeFirstName;
//    private String employeeLastName;
//    private String department;
//    private String role;
//    
//    public int getEmployeeId() {
//        return employeeId;
//    }
//    
//    public String getFullName() {
//        return employeeFirstName + " " + employeeLastName;
//    }
//
//    public Employee(int employeeId, String employeeFirstName, String employeeLastName, String department, String role) {
//        this.employeeId = employeeId;
//        this.employeeFirstName = employeeFirstName;
//        this.employeeLastName = employeeLastName;
//        this.department = department;
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return new StringBuilder()
//            .append("Employee ID: ").append(employeeId)
//            .append("\nEmployee First Name: ").append(employeeFirstName)
//            .append("\nEmployee Last Name: ").append(employeeLastName)
//            .append("\nDepartment: ").append(department)
//            .append("\nRole: ").append(role)
//            .append("\n")
//            .toString();
//    }
//}

import java.util.HashMap;
import java.util.Scanner;

public class ManagementSystem {
	// Using a constant for the scanner so it can be reused across multiple methods
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Starting the Project Management Application
		ProjectManagementApp.run(scanner);
		// Starting the Employee Management Application
		EmployeeManagementApp.run(scanner);
		// Assign employees to a particular project
		ProjectManagementApp.assignEmployeesToProjects(scanner);
		// List employees who are assigned to a particular project
		ProjectManagementApp.listEmployeesForProject(scanner);
		// List projects for particular employees
		EmployeeManagementApp.listProjectsForEmployee(scanner);
		// List projects an employee is assigned to
		ProjectManagementApp.listAllProjectsAndAssignedEmployees();
		// Display all projects and their assigned employees
		ProjectManagementApp.updateProjectDetails(scanner);
		// Update which employees are assigned to a project
		ProjectManagementApp.updateEmployeeAssignment(scanner);
		// Delete a project from the system
		ProjectManagementApp.deleteProject(scanner);
		// Display all projects and their assigned employees again to show the update
		ProjectManagementApp.listAllProjectsAndAssignedEmployees();
		// Close the scanner as it's no longer needed
		scanner.close();
	}
}

class ProjectManagementApp {
	// Counter to keep track of unique project IDs
	private static int projectIdCounter = 1;
	// A HashMap to store all projects, where key is the project's ID and value is
	// the Project object
	private static HashMap<Integer, Project> projects = new HashMap<>();

	// Method to run the Project Management Application
	public static void run(Scanner scanner) {

		// Infinite loop to add projects
		while (true) {
			// Prompt user for various project details
			String projectName = promptInput("Enter Project Name:", scanner);
			String projectDescription = promptInput("Enter Project Description:", scanner);
			String startDate = promptInput("Enter Start Date (dd-mm-yyyy):", scanner);
			String endDate = promptInput("Enter End Date (dd-mm-yyyy):", scanner);
			// Create a new project with the provided details and a unique ID
			Project project = new Project(projectIdCounter++, projectName, projectDescription, startDate, endDate);
			// Store the project in the HashMap
			projects.put(project.getProjectId(), project);
			// Ask if the user wants to add another project
			String response = promptInput("Do you want to enter another project? (yes/no)", scanner);
			if (response.equalsIgnoreCase("no")) {
				break;
			}
		}
		// Print all entered projects after exiting the loop
		System.out.println("All entered projects:");
		System.out.println("*********************");
		for (Project project : projects.values()) {
			System.out.println(project);
		}
	}

	// Utility method to prompt the user for input
	private static String promptInput(String message, Scanner scanner) {
		System.out.println(message);
		return scanner.nextLine();
	}

	// Method to assign employees to projects
	public static void assignEmployeesToProjects(Scanner scanner) {
		while (true) {
			try {
				int projectId = Integer.parseInt(promptInput("Enter Project ID to assign employees:", scanner));
				Project project = projects.get(projectId);
				if (project == null) {
					System.out.println("Project not found!");
					continue;
				}

				int employeeId = Integer.parseInt(promptInput("Enter Employee ID:", scanner));
				Employee employee = EmployeeManagementApp.findEmployeeById(employeeId);
				if (employee == null) {
					System.out.println("Employee not found!");
					continue;
				}

				String role = promptInput("Enter Role in the project:", scanner);
				project.assignEmployee(employee, role);

				String response = promptInput("Do you want to assign another employee to a project? (yes/no)", scanner);
				if (response.equalsIgnoreCase("no")) {
					break;
				}

			} catch (NumberFormatException ex) {
				System.out.println("Invalid input. Please enter a valid number for ID.");
			}
		}
	}

	// Method to list employees assigned to a particular project
	public static void listEmployeesForProject(Scanner scanner) {
		while (true) {
			try {
				int projectId = Integer.parseInt(promptInput("Enter Project ID to list employees:", scanner));
				Project project = projects.get(projectId);
				if (project == null) {
					System.out.println("Project not found!");
					continue;
				}

				System.out.println("Employees assigned to project " + project.getProjectId() + ":");
				System.out.println("*******************************");
				project.listAssignedEmployees();

				String response = promptInput("Do you want to list employees for another project? (yes/no)", scanner);
				if (response.equalsIgnoreCase("no")) {
					break;
				}
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input. Please enter a valid number for ID.");
			}
		}
	}

	// Method to list all projects and their assigned employees
	public static void listAllProjectsAndAssignedEmployees() {
		System.out.println("Listing all projects and their assigned employees:");
		System.out.println("**********************************************");
		for (Project project : projects.values()) {
			System.out.println(project);
			System.out.println("--------------");
		}
	}

	// Method to update details of a project
	public static void updateProjectDetails(Scanner scanner) {
		while (true) {
			try {
				int projectId = Integer.parseInt(promptInput("Enter Project ID to update:", scanner));
				Project project = projects.get(projectId);
				if (project == null) {
					System.out.println("Project not found!");
					continue;
				}

				System.out.println("Current Project Details:");
				System.out.println(project);

				String projectName = promptInput("Enter New Project Name (or press enter to skip):", scanner);
				String projectDescription = promptInput("Enter New Project Description (or press enter to skip):",
						scanner);
				String startDate = promptInput("Enter New Start Date (dd-mm-yyyy) (or press enter to skip):", scanner);
				String endDate = promptInput("Enter New End Date (dd-mm-yyyy) (or press enter to skip):", scanner);

				if (!projectName.isEmpty())
					project.setProjectName(projectName);
				if (!projectDescription.isEmpty())
					project.setProjectDescription(projectDescription);
				if (!startDate.isEmpty())
					project.setStartDate(startDate);
				if (!endDate.isEmpty())
					project.setEndDate(endDate);

				System.out.println("Project details updated!");

				String response = promptInput("Do you want to update another project? (yes/no)", scanner);
				if (response.equalsIgnoreCase("no")) {
					break;
				}
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input. Please enter a valid number for ID.");
			}
		}
	}

	// Method to update an employee's assignment to a project
	public static void updateEmployeeAssignment(Scanner scanner) {
		while (true) {
			try {
				int projectId = Integer
						.parseInt(promptInput("Enter Project ID to update employee assignment:", scanner));
				Project project = projects.get(projectId);
				if (project == null) {
					System.out.println("Project not found!");
					continue;
				}

				int employeeId = Integer.parseInt(promptInput("Enter Employee ID for assignment update:", scanner));
				if (!project.hasEmployeeAssigned(employeeId)) {
					System.out.println("Employee not assigned to this project!");
					continue;
				}

				String role = promptInput("Enter New Role in the project:", scanner);
				project.updateEmployeeRole(employeeId, role);

				System.out.println("Employee assignment updated!");

				String response = promptInput("Do you want to update another employee assignment? (yes/no)", scanner);
				if (response.equalsIgnoreCase("no")) {
					break;
				}
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input. Please enter a valid number for ID.");
			}
		}
	}

	// Method to delete a project
	public static void deleteProject(Scanner scanner) {
		while (true) {
			try {
				int projectId = Integer.parseInt(promptInput("Enter Project ID to delete:", scanner));
				Project project = projects.get(projectId);
				if (project == null) {
					System.out.println("Project not found!");
					continue;
				}

				System.out.println("Current Project Details:");
				System.out.println(project);

				String response = promptInput("Are you sure you want to delete this project? (yes/no)", scanner);
				if (response.equalsIgnoreCase("yes")) {
					projects.remove(projectId);
					System.out.println("Project deleted successfully!");
				} else {
					System.out.println("Project was not deleted.");
				}

				response = promptInput("Do you want to delete another project? (yes/no)", scanner);
				if (response.equalsIgnoreCase("no")) {
					break;
				}
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input. Please enter a valid number for ID.");
			}
		}
	}

	// Method to retrieve all projects
	public static HashMap<Integer, Project> getAllProjects() {
		return projects;
	}

}

class Project {
	// Fields to store project details
	private int projectId;
	private String projectName;
	private String projectDescription;
	private String startDate;
	private String endDate;
	// HashMap to store assignments of employees to the project
	// Key is employee's ID and value is the ProjectEmployeeAssignment object
	private HashMap<Integer, ProjectEmployeeAssignment> assignments = new HashMap<>();

	// Constructor to initialise a Project with its details
	public Project(int projectId, String projectName, String projectDescription, String startDate, String endDate) {
		//Unique ID for the project
		this.projectId = projectId;
		//Name of the project
		this.projectName = projectName;
		//Description of the project
		this.projectDescription = projectDescription;
		//Start date of the project
		this.startDate = startDate;
		//End date of the project
		this.endDate = endDate;
	}

	// Returns the project's ID
	public int getProjectId() {
		return projectId;
	}

	// Sets the project's name
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	// Sets the project's description
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	// Sets the project's start date
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	// Sets the project's end date
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	// Assigns an employee to the project with a specific role
	public void assignEmployee(Employee employee, String role) {
		assignments.put(employee.getEmployeeId(), new ProjectEmployeeAssignment(employee, role));
	}

	@Override
	public String toString() {
		// Initialise a StringBuilder to construct the project details string
		StringBuilder sb = new StringBuilder();
		// Append basic project details to the string
		sb.append("Project ID: ").append(projectId).append("\nProject Name: ").append(projectName)
				.append("\nProject Description: ").append(projectDescription).append("\nStart Date: ").append(startDate)
				.append("\nEnd Date: ").append(endDate).append("\n");

		// Loop through each employee assignment and append to the string
		for (ProjectEmployeeAssignment assignment : assignments.values()) {
			sb.append(assignment).append("\n");
		}
		// Return the constructed string
		return sb.toString();
	}

	// List all employees assigned to the project
	public void listAssignedEmployees() {
		// Check if there are no assignments and display a message if so
		if (assignments.isEmpty()) {
			System.out.println("No employees assigned to this project.");
			return;
		}
		// Loop through each employee assignment and display it
		for (ProjectEmployeeAssignment assignment : assignments.values()) {
			System.out.println(assignment);
		}
	}

	// Check if a specific employee is assigned to the project
	public boolean hasEmployeeAssigned(int employeeId) {
		return assignments.containsKey(employeeId);
	}

	// Update the role of a specific employee in the project
	public void updateEmployeeRole(int employeeId, String newRole) {
		// Check if the employee is assigned, then update their role
		if (assignments.containsKey(employeeId)) {
			assignments.get(employeeId).setRole(newRole);
		}
	}

}

class EmployeeManagementApp {
	// Static variable to maintain unique employee IDs
	private static int employeeIdCounter = 1;
	// HashMap to store employee objects with their IDs as keys
	private static HashMap<Integer, Employee> employees = new HashMap<>();

	// Main runner function for the employee management application
	public static void run(Scanner scanner) {
		// Continuous loop to enter employee details
		while (true) {
			// Prompt user for employee's first name
			String employeeFirstName = promptInput("Enter Employee First Name:", scanner);
			// Prompt user for employee's last name
			String employeeLastName = promptInput("Enter Employee Last Name:", scanner);
			// Prompt user for employee's department
			String department = promptInput("Enter Department:", scanner);
			// Prompt user for employee's role
			String role = promptInput("Enter Role:", scanner);
			// Create a new employee object and increment the ID counter
			Employee employee = new Employee(employeeIdCounter++, employeeFirstName, employeeLastName, department,
					role);
			// Store the employee object in the HashMap
			employees.put(employee.getEmployeeId(), employee);
			// Prompt user if they want to add another employee
			String response = promptInput("Do you want to enter another employee? (yes/no)", scanner);
			// Break the loop if user does not want to continue
			if (response.equalsIgnoreCase("no")) {
				break;
			}
		}
		// Print a message indicating the listing of all entered employees
		System.out.println("All entered employees:");
		// Print a decorative line
		System.out.println("*********************");
		// Loop through all the employees in the HashMap and print each one
		for (Employee employee : employees.values()) {
			System.out.println(employee);
		}
	}

	// Helper method to prompt the user for input and return the entered line
	private static String promptInput(String message, Scanner scanner) {
		// Display the prompt message
		System.out.println(message);
		// Read and return the user's input
		return scanner.nextLine();
	}

	// Method to find and return an employee based on their ID
	public static Employee findEmployeeById(int id) {
		return employees.get(id);
	}

	public static void listProjectsForEmployee(Scanner scanner) {
		// Start a loop to continuously prompt the user for input
		while (true) {
			try {
				// Prompt the user to enter an employee ID
				int employeeId = Integer.parseInt(promptInput("Enter Employee ID to list projects:", scanner));
				// Attempt to find the employee by the given ID
				Employee employee = findEmployeeById(employeeId);
				// Check if the employee was found
				if (employee == null) {
					System.out.println("Employee not found!");
					continue; // Skip the current iteration and prompt the user again
				}
				// Display the projects assigned to the specified employee
				System.out.println("Projects assigned to employee " + employee.getFullName() + ":");
				listAssignedProjects(employeeId);
				// Ask the user if they want to continue listing projects for another employee
				String response = promptInput("Do you want to list projects for another employee? (yes/no)", scanner);
				if (response.equalsIgnoreCase("no")) {
					break; // End the loop if the user answers "no"
				}
			} catch (NumberFormatException ex) { // Handle the exception if the input is not a valid number
				System.out.println("Invalid input. Please enter a valid number for ID.");
			}
		}
	}

	public static void listAssignedProjects(int employeeId) {
		// Start with the assumption that the employee has no projects
		boolean hasProjects = false;
		// Iterate through all the projects in the application
		for (Project project : ProjectManagementApp.getAllProjects().values()) {
			// Check if the current project has the given employee assigned
			if (project.hasEmployeeAssigned(employeeId)) {
				// Display the project details
				System.out.println(project);
				// Update the flag to indicate that the employee has at least one project
				hasProjects = true;
			}
		}
		// If no projects were found for the employee, display a message
		if (!hasProjects) {
			System.out.println("No projects assigned to this employee.");
		}
	}

}

//Employee class represents individual employees
class Employee {
	// Unique identifier for the employee
	private int employeeId;
	// First name of the employee
	private String employeeFirstName;
	// Last name of the employee
	private String employeeLastName;
	// Department to which the employee belongs
	private String department;
	// Role or position of the employee in the organisation
	private String role;

	// Constructor to initialise an employee object with details
	public Employee(int employeeId, String employeeFirstName, String employeeLastName, String department, String role) {
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.department = department;
		this.role = role;
	}

	// Getter method to retrieve the employee's unique ID
	public int getEmployeeId() {
		return employeeId;
	}

	// Method to get the full name of the employee by combining first and last name
	public String getFullName() {
		return employeeFirstName + " " + employeeLastName;
	}

	@Override
	// Method to represent Employee object as a formatted string
	public String toString() {
		return new StringBuilder()
				// Appending employee's unique ID
				.append("Employee ID: ").append(employeeId)
				// Appending employee's first name
				.append("\nEmployee First Name: ").append(employeeFirstName)
				// Appending employee's last name
				.append("\nEmployee Last Name: ").append(employeeLastName)
				// Appending employee's department
				.append("\nDepartment: ").append(department)
				// Appending employee's role or position
				.append("\nRole: ").append(role).append("\n").toString();
	}
}

//Class to represent the assignment of an employee to a project with a specific role
class ProjectEmployeeAssignment {
	// Employee object representing the employee assigned to the project
	private Employee employee;
	// Role or designation of the employee in the project
	private String role;

	// Constructor to initialise a project-employee assignment with given employee
	// and role
	public ProjectEmployeeAssignment(Employee employee, String role) {
		this.employee = employee;
		this.role = role;
	}

	// Setter method to update the role of the employee in the project
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	// Overrides the toString method to return a formatted string representing the
	// employee's full name and role in the project
	public String toString() {
		return employee.getFullName() + " - Role: " + role;
	}
}
