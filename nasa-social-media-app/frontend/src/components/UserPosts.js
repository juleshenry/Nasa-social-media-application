import React, { useEffect, useState } from "react";

const UserPosts = () => {
    const [userPosts, setUserPosts] = useState({});
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        // Fetch from your Spring Boot backend
        fetch("http://localhost:8080/user-posts")
            .then((res) => {
                if (!res.ok) {
                    throw new Error("Failed to fetch user posts");
                }
                return res.json();
            })
            .then((data) => {
                setUserPosts(data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    }, []);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div>
            <h2>User Posts</h2>
            {Object.entries(userPosts).map(([userIdentifier, text]) => (
                <div key={userIdentifier} style={{ marginBottom: "1rem" }}>
                    <h3>{userIdentifier}</h3>
                    <ul>
                        {text.map((text, index) => (
                            <li key={index}>{text}</li>
                        ))}
                    </ul>
                </div>
            ))}
        </div>
    );
};

export default UserPosts;
