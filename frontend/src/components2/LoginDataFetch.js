import React, { useEffect, useState } from "react";

function LoginFetchData() {
  const [user, setUser] = useState("");
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/profile", {
      method: "GET",
      credentials: "include", // include cookies for Spring Security session
      headers: {
    "Accept": "application/json",
    "Content-Type": "application/json"
  }
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch profile");
        }
        return response.json(); // or .json() if your API returns JSON
      })
      .then((data) => {
        setUser(data); // assuming backend returns plain text (username)
      })
      .catch((error) => {
        setError(error.message);
      });
  }, []);

  return (
    <div>
      <h2>User Profile</h2>
      {error && <p>Error: {error}</p>}
      {user ? <p>Logged in as: {user.username}</p> : <p>Loading...</p>}
    </div>
  );
}

export default LoginFetchData;
