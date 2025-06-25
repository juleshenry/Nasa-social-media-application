import { useState } from "react";

const SaveComment = () => {
    const [name, setName] = useState("");  // New state for username
    const [comment, setComment] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch("http://localhost:8080/posts", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ 
                userIdentifier: name, 
                text: comment 
            }),
        });

        if (response.ok) {
            const data = await response.json();
            console.log("Comment saved:", data);
            setName("");  // Clear fields after submission
            setComment("");
        } else {
            console.error("Failed to save comment");
        }
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    placeholder="Enter your username"
                    required
                />
                <textarea
                    value={comment}
                    onChange={(e) => setComment(e.target.value)}
                    placeholder="Write your comment..."
                    required
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default SaveComment;
