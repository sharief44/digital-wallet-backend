# 💰 Digital Wallet Backend (Spring Boot + JWT + PostgreSQL)

A secure REST API for a Digital Wallet system built using Spring Boot, JWT Authentication, and PostgreSQL.

---

## 🚀 Features

- ✅ User Registration
- ✅ User Login (JWT Authentication)
- ✅ Add Money to Wallet
- ✅ Transfer Money Between Users
- ✅ View Wallet Balance
- ✅ Transaction History
- ✅ Secure Endpoints with JWT
- ✅ PostgreSQL Database Integration

---

## 🛠 Tech Stack

- **Backend:** Spring Boot 4
- **Security:** Spring Security + JWT
- **Database:** PostgreSQL
- **ORM:** Hibernate / JPA
- **Build Tool:** Maven
- **API Testing:** Postman

---

## 📂 Project Structure

```
com.example.wallet
│
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── repository
├── security
├── service
└── service.impl
```

---

## 🔐 Authentication Flow

1. User registers
2. User logs in
3. JWT token is generated
4. Token must be sent in header:

```
Authorization: Bearer <your-token>
```

All `/api/wallet/**` endpoints require authentication.

---

## 📦 API Endpoints

### 👤 User APIs

| Method | Endpoint | Description |
|--------|----------|------------|
| POST | `/api/users/register` | Register new user |
| POST | `/api/users/login` | Login and receive JWT |

---

### 💰 Wallet APIs (Protected)

| Method | Endpoint | Description |
|--------|----------|------------|
| POST | `/api/wallet/add` | Add money |
| GET | `/api/wallet/balance/{userId}` | Get wallet balance |
| POST | `/api/wallet/transfer` | Transfer money |
| GET | `/api/wallet/transactions/{userId}` | Get transactions |

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/sharief44/digital-wallet-backend.git
cd digital-wallet-backend
```

---

### 2️⃣ Configure PostgreSQL

Create database:

```
walletdb
```

Update `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/walletdb
    username: postgres
    password: yourpassword

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

Application runs on:

```
http://localhost:8080
```

---

## 🧪 Testing with Postman

1. Register a user
2. Login to receive JWT
3. Add JWT in Headers:

```
Authorization: Bearer <token>
```

4. Access wallet APIs

---

## 📈 Future Improvements

- Swagger API Documentation
- Role-Based Authorization (Admin/User)
- Docker Support
- Unit & Integration Testing
- Cloud Deployment (Render / Railway / AWS)
- CI/CD Pipeline

---

## 👨‍💻 Author

Sharief Sk  
Full Stack Java Developer  

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
