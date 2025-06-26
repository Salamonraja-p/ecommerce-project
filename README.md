📄 E-Commerce Project Summary Report

 ✅ Project Name:

  Online E-Commerce Web Application

 🎯 Project Purpose:
  To design and implement a fully functional e-commerce platform that allows users to:

   Register and log in.

   Browse products.

   Add items to a cart.

   Place orders.

   View their order history.

   Admins can manage product listings.


🛠 Technologies Used:
  Layer	Technology	Purpose
  Frontend (UI)	HTML, CSS, JavaScript	Building the user interface of the site.
  Backend (Logic)	Java (Spring Boot)	Server-side logic and RESTful API handling.
  Database	MySQL	Storing users, products, orders, etc.
  Template Engine	Thymeleaf (optional)	(For HTML rendering if needed)
  Build Tool	Maven	Dependency management and build automation.
  HTTP Client	Fetch API (JavaScript)	Communicating with backend APIs via AJAX calls.

🧱 System Architecture:

    [Browser] ⇄ [Spring Boot REST API] ⇄ [MySQL Database]


🔑 Major Functional Modules:

 1. User Module

   register.html – Page for user registration

   login.html – Page for user authentication

   UserController.java – Handles register/login API

   UserService.java – Business logic for user management

   User.java – Entity that maps to the users table in MySQL

 2. Product Module

   product-list.html – Displays all available products

   ProductController.java – Provides /products API endpoints

   ProductService.java – Handles product logic

   ProductRepository.java – JPA repository for DB access

   Product.java – Maps to the product table

 3. Cart Module

   cart.html – Displays cart items and provides a checkout button

   JavaScript – Stores cart items using localStorage

 4. Order Module

   OrderController.java – API for placing and fetching orders

   OrderService.java – Saves order and links items

   Order.java – Represents the main order table

   OrderItem.java – Represents the items in each order

   order-history.html – View orders placed by a given email


📁 Folder Structure Overview:

   ecommerce/
   ├── controller/
   │   └── Handles REST APIs for products, orders, and users
   ├── service/
   │   └── Business logic of the app
   ├── model/
   │   └── All entity classes (User, Product, Order, etc.)
   ├── repository/
   │   └── Interfaces extending JpaRepository for DB interaction
   ├── resources/
   │   ├── static/ → HTML, CSS, JS files
   │   ├── templates/ → Thymeleaf templates (optional)
   │   └── application.properties → Configuration


🌐 Key URLs for Testing:

 Page	URL
   Home Page	http://localhost:9090/
   Register	http://localhost:9090/register.html
   Login	http://localhost:9090/login.html
   Product Listing	http://localhost:9090/product-list.html
   Cart	http://localhost:9090/cart.html
   Order History	http://localhost:9090/order-history.html
   Admin Page (Optional)	http://localhost:9090/admin/manage-products.html

✅ Highlights:

   Clean separation of frontend/backend logic.

   Uses REST API to dynamically fetch/store data.

   Products and orders are managed using standard JPA.

   Cart logic is handled in the browser using localStorage.


📌 Future Scope (Optional Enhancements):

   Implement admin login & dashboard.

   Add product images stored in the DB or filesystem.

   Add pagination and category filters to product listing.

   Integrate payment gateway (like Razorpay or Stripe).

   Enhance security (JWT, password hashing, validation).
