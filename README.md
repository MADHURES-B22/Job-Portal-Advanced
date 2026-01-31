# Job-Portal-Advanced
Job Portal Backend is a scalable and secure Spring Boot REST API designed to support a modern job portal application. The system provides user registration and authentication using JWT, role-based authorization, and robust job management capabilities.

The application follows a layered architecture with clear separation of concerns and incorporates Spring Security, Spring Data JPA, and Spring AOP to handle cross-cutting concerns such as logging, performance monitoring, and input validation.

Administrative users can create, update, and delete job postings, while regular users can browse and search available jobs. The backend is fully stateless, secured using JWT tokens, and built to integrate seamlessly with a React frontend.

🚀 Features
User registration & login
JWT authentication
Role-based authorization (ADMIN, USER)
Secure job management (Add / Edit / Delete jobs)
Public job listing & search
Spring Security with custom JWT filter
Clean layered architecture

🛠 Tech Stack
Java 17
Spring Boot
Spring Security
JWT (JSON Web Token)
Spring Data JPA
MySQL 
Maven


src/main/java/com/loga/Spring_rest_project
│
├── aop/
│   ├── LoggingAspect.java
│   ├── PerformanceMonitoringAspect.java
│   └── ValidatingInputAspect.java
│
├── config/
│   ├── SecurityConfig.java
│   ├── JwtFilter.java
│   └── CorsConfig.java
│
├── dao/
│   └── UserRepo.java
│
├── Repo/
│   └── JobRepo.java
│
├── model/
│   ├── JobPost.java
│   ├── User.java
│   ├── Role.java
│   └── UserPrincipal.java
│
├── service/
│   ├── JobService.java
│   ├── UserService.java
│   └── MyUserService.java
│
├── controller/
│   ├── JobRestController.java
│   └── UserController.java
│
└── SpringRestProjectApplication.java


🧠 Package Responsibilities 
🔹 aop
Cross-cutting concerns handled using Spring AOP:
Logging
Performance monitoring
Input validation

🔹 config
Application & security configuration:
JWT filter
Spring Security setup


🔹 model
JPA entities and security models:
User, Role, JobPost
Custom UserPrincipal for Spring Security

🔹 dao / Repo
Data access layer using Spring Data JPA:
UserRepo
JobRepo

🔹 service
Business logic layer:
Authentication & user handling
Job management logic

🔹 controller
REST API endpoints:
Job APIs
Auth & user APIs

🔐 Authentication & Authorization
Users authenticate using username & password
On successful login, a JWT token is generated
The token must be sent in every secured request using the header:
Authorization: Bearer <JWT_TOKEN>

👥 Roles
Role	Permissions
USER	View & search jobs
ADMIN	Add, update & delete jobs

📝 User Registration
New users can register using the /register endpoint.

🔓 Public Endpoint
Method	Endpoint	Description
POST	/register	Register a new user

📥 Sample Register Request
{
  "username": "admin",
  "password": "admin123",
  "roles": ["ADMIN"]
}

{
  "username": "user1",
  "password": "user123",
  "roles": ["USER"]
}


Passwords are securely encoded using Spring Security before storing in the database.

🔑 Login
Method	Endpoint	Description
POST	/login	Authenticate user & return JWT
📥 Sample Login Request
{
  "username": "admin",
  "password": "admin123"
}

📤 Sample Login Response
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}


📌 API Endpoints
🔓 Public Endpoints
Method	Endpoint	Description
POST	/register	Register new user
POST	/login	Login & receive JWT
GET	/jobPosts	Get all jobs
GET	/jobPost/{id}	Get job by ID
GET	/jobPosts/keyword/{keyword}	Search jobs

🔒 Secured Endpoints (ADMIN only)
Method	Endpoint	Description
POST	/jobPost	Add new job
PUT	/jobPost	Update job
DELETE	/jobPost/{id}	Delete job

🧾 Sample Job JSON
{
  "postId": 1,
  "postProfile": "Backend Developer",
  "postDesc": "Spring Boot Developer",
  "reqExperience": 2,
  "postTechStack": ["Java", "Spring Boot", "MySQL"]
}


⚙️ Configuration
application.properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

▶️ Running the Application
Prerequisites
Java 17+
Maven
MySQL (or H2)

Steps
1) git clone https://github.com/your-username/job-portal.git
2) cd backend
3) mvn spring-boot:run


Backend will be available at:
http://localhost:8080

You can test APIs using Postman
