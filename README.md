# 🎮 Twitch+ — Personalized Twitch Resources Recommendation Platform
This is a full-stack web application that allows users to search for Twitch resources (streams, videos, clips) and receive intelligent content-based recommendations. Built with Spring Boot, React, Ant Design, and deployed using AWS services.

---

## 🧱 Tech Stack

- **Frontend:** React + Ant Design  
- **Backend:** Spring Boot, Spring Security, OpenFeign, Caffeine Cache  
- **Database:** MySQL (hosted on AWS RDS)  
- **Deployment:** AWS App Runner  
- **API:** Twitch API (official)

---

## 🚀 Features

- 🔍 **Twitch Search & Recommendation**  
  Search Twitch streams/videos/clips and get recommendations based on your favorites.

- 🌐 **Responsive Web UI**  
  Built with React and Ant Design for a modern, user-friendly experience.

- 🛡️ **User Authentication**  
  Supports user register, login, logout using Spring Security.

- 💾 **Persistent Storage**  
  CRUD operations on a MySQL database using Spring Data JDBC.

- 🔄 **Live Twitch Integration**  
  Real-time Twitch resources fetched using Twitch API via OpenFeign client.

- ⚡ **Caching & Testing**  
  Backend performance boosted with Caffeine Cache and covered with unit tests.

- 📦 **Cloud Deployment**  
  Fully containerized and deployed on AWS App Runner.

---

## 🛠️ How to Run Locally

### 📌 Prerequisites

- Java 17+  
- Node.js 18+  
- MySQL  
- Twitch Developer API credentials

---

### ▶️ Backend

```bash
cd backend
./mvnw spring-boot:run
```

> Make sure to configure your database and Twitch API credentials in `src/main/resources/application.properties`.

---

### ▶️ Frontend

```bash
cd frontend
npm install
npm start
```

> The app will run in development mode at `http://localhost:3000`.

---

## 📁 Project Structure

```
twitch-fullstack-project/
├── frontend/   # React + Ant Design frontend  
└── backend/    # Spring Boot backend
```

---

## 🙌 Author

**Zhuoyue Ren**  
Built as a full-stack personal project with a professional architecture, real API integration, and AWS cloud deployment.

---

## 📬 Contact

GitHub: [@RZY631](https://github.com/RZY631)
```
