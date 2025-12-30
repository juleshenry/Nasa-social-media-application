import { useState, useEffect } from "react";

function UserProfile() {
    const [userData, setUserData] = useState({ name: "", text: "" });

    useEffect(() => {
        fetch("http://localhost:8080/", {
            method: "GET",
            credentials: "include", // Include cookies for authentication
            headers: { "Content-Type": "application/json" }
        })
        .then(response => response.json()) // Parse JSON response
        .then(data => setUserData(data)) // Set state with response data
        .catch(error => console.error("Error fetching data:", error));
    }, []);

    return (
        <div>
            <h1>Hello, {userData.name}!</h1>
            <p>{userData.text}</p>
        </div>
    );
}

export default UserProfile;
