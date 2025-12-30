#!/bin/bash

# Setup script for NASA Social Media Application
echo "Building and running the NASA Social Media Application..."

# Build and run Docker containers
docker-compose up --build -d

echo "Application is running!"
echo "Backend: http://localhost:8080"
echo "Frontend: http://localhost:3000"