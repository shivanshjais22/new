
# Product Service - E-Commerce Platform

This is a Product Service built using Java Spring Boot. It is part of an e-commerce platform that manages product listings, categories, prices, and orders.

----------------------
FEATURES
----------------------
- Add, update, delete, and retrieve products
- Product categorization
- Price management
- RESTful APIs for frontend or other microservices
- Integrated with MySQL database using JPA/Hibernate
- DTO-based data transfer

----------------------
TECH STACK
----------------------
- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Postman (for API testing)
- Spring Web, Spring DevTools

----------------------
PROJECT STRUCTURE
----------------------
src/
├── controller/
│   └── ProductController.java
├── service/
│   └── ProductService.java
├── model/
│   ├── Product.java
│   ├── Category.java
│   └── Price.java
├── dto/
│   └── GenericProductDTO.java
├── repository/
│   └── ProductRepository.java
└── ECommerceApplication.java

----------------------
DATABASE SCHEMA
----------------------

Product Table:
- id: UUID/String – Unique product ID
- title: String – Product name
- category: String – Category name
- price: Double – Product price
- description: String – Product details

Category Table:
- id: UUID – Category ID
- name: String – Category Name

----------------------
API ENDPOINTS (Sample)
----------------------

POST   /products        - Add new product
GET    /products        - Get all products
GET    /products/{id}   - Get product by ID
PUT    /products/{id}   - Update product
DELETE /products/{id}   - Delete product
