# Inventory Management System

## Overview
This Inventory Management System is designed to effectively organize and track inventory-related information. It supports two user roles:

- **Administrator**
- **Materially Responsible Person (MRP)**

Each role has specific permissions and functionalities within the system.

## User Operations

### Administrator
- Create and manage Materially Responsible Persons (MRPs).

### Materially Responsible Person (MRP)
- Manage inventory registrations and client associations.

## Inventory Operations

- **Product Registration:**
  - Inventory number
  - Description
  - Type (Fixed Assets - FA or Movable Assets - MA)
  - Depreciation level (applicable only to FA)

- **Decommission Criteria:**
  - Years of usage, condition, or custom criteria

- **Client Management:**
  - Register clients
  - Assign products to clients
  - Deregister (return) products from clients

- **Automatic Asset Transfer:**
  - Automatic calculation and transfer of products from FA to MA
  - Decommissioning of products

## Reports
The system supports detailed reports within a specified time period for:

- Products registered to specific clients
- Complete product inventory
- Product categorization by type (FA/MA)
- Decommissioned products
- Product availability status (Available/Missing)

## Notifications
The system generates automatic notifications for:
- Product transition from FA to MA
- Product decommissioning

## User Interface (UI) Design

- **Login Panel:**
  - Users select their role (Administrator or MRP)
  - Enter username and password
  - Provides error feedback if credentials are incorrect or fields are empty

- **Control Panel:**
  - Separate control panels for Administrator and MRP
  - Administrator panel includes functionality to create MRPs
  - Buttons for navigation to product registration, client management, reporting, and more
  - Back and Logout buttons for seamless navigation

## Form Validation

- **Product Registration:**
  - Mandatory field validation
  - Depreciation level is disabled when MA type is selected

- **Client Registration:**
  - Mandatory field validation

- **Product Assignment to Client:**
  - Validates product and client IDs
  - Prevents reassignment or assignment of decommissioned products

- **Product Deregistration:**
  - Automatic timestamp upon successful deregistration
  - Error notification when attempting to deregister an already returned product

## Reporting Panels
- Date validation for generating reports
- Informative error messages when mandatory parameters are missing

## Architecture
The system is built using a multilayered architecture, promoting clear structure and modularity. This approach facilitates maintenance, scalability, and clear separation of concerns, allowing each layer to provide specific services to the next higher level, enhancing the overall manageability and extensibility of the application.
For more info, you can check the doc: 
https://docs.google.com/document/d/1NyyoHplhVx7V-2NhxPqezU14ZBXstKdUrgLj7OdDp9s/edit?usp=sharing
