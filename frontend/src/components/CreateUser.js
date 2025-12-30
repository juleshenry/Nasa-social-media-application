import React, { useState } from "react";
import axios from "axios";

const CreateUser = () => {
    const [username, setUsername] = useState("");
    const [userPassword, setUserPassword] = useState("");
    const [message, setMessage] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post("http://localhost:8080/register/user", {
                username,
                userPassword
            });

            setMessage(response.data);
        } catch (error) {
            setMessage("Error creating account.");
        }
    };

    return (
        <div style={{ width: "300px", textAlign: "center" }}>
            <h2>Create Account</h2>
            <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column" }}>
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    required
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={userPassword}
                    onChange={(e) => setUserPassword(e.target.value)}
                    required
                />
                <button type="submit">Sign Up</button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );
};




export default CreateUser;
