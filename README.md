# NASA Social Media Application

This project is a full-stack application with a Spring Boot backend and React frontend for NASA social media features.

## Prerequisites

- Docker
- Docker Compose

## Quick Start

1. Clone the repository
2. Run the setup script:
   ```bash
   ./setup.sh
   ```
   Or manually:
   ```bash
   docker-compose up --build
   ```

3. Access the application:
   - Frontend: http://localhost:3000
   - Backend API: http://localhost:8080

## Services

- **Backend**: Spring Boot application with REST APIs
- **Frontend**: React application served via Nginx

## Development

To run locally without Docker:

### Backend
```bash
cd backend
./gradlew bootRun
```

### Frontend
```bash
cd frontend
npm install
npm start
```

## Docker Commands

- Start services: `docker-compose up`
- Stop services: `docker-compose down`
- Rebuild: `docker-compose up --build`